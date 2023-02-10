package com.jeff.common.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jeff.common.entity.BasePage;
import com.jeff.common.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 基礎 controller 類，所有 controller 都繼承此類
 * @param <Service>
 */
@SuppressWarnings("unchecked")
public class BaseController <Service extends IService, T> {
    private static final Logger log = LoggerFactory.getLogger(BaseMapper.class);

    private Service service;

    @Autowired
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


}
