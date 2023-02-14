package com.jeff.common.base;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeff.common.entity.BasePage;
import com.jeff.common.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * 基礎 controller 類，所有 controller 都繼承此類
 * @param <Service>
 */
@SuppressWarnings("unchecked")
public class BaseController <Service extends IService, T> {
    private static final Logger log = LoggerFactory.getLogger(BaseMapper.class);

    @Autowired
    private Service service;


    public void setService(Service service){
        this.service = service;
    }

    /**
     * 獲取所有的數據
     * @return 返回前端 json 數據
     */
    @GetMapping("getList")
    public Result getList(){
        List<T> list = service.list();
        return Result.successJson(list);
    }


    /**
     * 分頁查詢
     * @param basePage 分頁的實體類
     * @return 返回前端 json 數據
     */
    @GetMapping("getPageList")
    public Result getPageList(@RequestBody BasePage basePage){
        Page<T> pojo = new Page<>(basePage.getCurrent(), basePage.getSize());
        IPage<T> page = service.page(pojo);
        log.info("總條數 ===>" + page.getTotal());
        log.info("當前頁數 ===>" + page.getCurrent());
        log.info("當前每頁顯示數 ===>" + page.getSize());
        log.info("數據 ===>" + page.getRecords());
        return Result.successJson(page);
    }

    /**
     * 增加一條數據
     * @param pojo 任意一個類型的實體
     * @return  返回前端 json 數據
     */
    @PostMapping("addData")
    public Result addData(@RequestBody T pojo){
        boolean flag = service.save(pojo);
        if(flag){
            return Result.successJson("成功新增一條數據");
        }
        return Result.errorJson();
    }

    /**
     * 增加一組數據
     * @param pojo 任意實體類
     * @return 返回前端 json 數據
     */
    @PostMapping("addDataBatch")
    public Result addData(@RequestBody Collection<T> pojo){
        boolean flag = service.saveBatch(pojo, 500);
        if(flag){
            return Result.successJson("成功新增一組數據");
        }
        return Result.errorJson();
    }

    /**
     * 根據 id 修改一條數據，數據中必須有 id 主鍵字段
     * @param pojo 任意實體類
     * @return  返回前端 json 數據
     */
    @PutMapping("updateById")
    public Result updateById(@RequestBody T pojo){
        boolean flag = service.updateById(pojo);
        if(flag){
            return Result.successJson("成功修改一條數據");
        }
        return Result.errorJson();
    }

    /**
     * 根據其他屬性字段修改數據
     * @param pojo 任意實體類型
     * @param column 任意字段
     * @param value 任意字段的值
     * @return 返回前端 json 數據
     */
    @PutMapping("updateByColumn")
    public Result updateByColumn(@RequestBody T pojo, @RequestParam("column") String column, @RequestParam(name = "value") String value){
        Wrapper<T> wrapper = Wrappers.<T>update().eq(column, value);
        boolean flag = service.update(pojo, wrapper);
        if(flag){
            return Result.successJson("成功修改一條數據");
        }
        return Result.errorJson();
    }

    /**
     * 根據哪一個字段刪除一條數據
     * @param column 要根據哪個字段刪除
     * @param value 字段的值
     * @return 返回前端 json 數據
     */
    @DeleteMapping("deleteByColumn")
    public Result deleteByColumn(@RequestParam("column") String column, @RequestParam(name = "value") String value){
        Wrapper<T> wrapper = Wrappers.<T>update().eq(column, value);
        boolean flag = service.remove(wrapper);
        if(flag){
            return Result.successJson("成功刪除一條數據");
        }
        return Result.errorJson();
    }

    /**
     * 根據 id 刪除一個數據
     * @param id 傳入的 id 值
     * @return 返回前端 json 數據
     */
    @DeleteMapping("deleteById")
    public Result deleteById(@RequestParam("id") Integer id){
        boolean flag = service.removeById(id);
        if(flag){
            return Result.successJson("成功刪除一條數據");
        }
        return Result.errorJson();
    }


    /**
     * 根據一組 id 刪除數據
     * @param ids 一組 id
     * @return  返回前端 json 數據
     */
    @DeleteMapping("deleteByIds")
    public Result deleteData(@RequestParam(value = "ids") List<Integer> ids){
        boolean flag = service.removeByIds(ids);
        if(flag){
            return Result.successJson("成功刪除一組數據");
        }
        return Result.errorJson();
    }
}
