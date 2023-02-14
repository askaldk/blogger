package com.jeff.common.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class CodeGenerator {
    /**
     * <p>
     * 讀取控制台內容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("請輸入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("請輸入正確的" + tip + "！");
    }

    public static void main(String[] args) {
        ResourceBundle resource = ResourceBundle.getBundle("myBatisPlus");
        String outPutDir = resource.getString("outputDir");
        Boolean fileOverride = true;
        if ("true".equals(resource.getString("fileOverride"))) {
            fileOverride = true;
        }
        String url = resource.getString("url");
        String driverClass = resource.getString("driverClass");
        String userName = resource.getString("userName");
        String passWord = resource.getString("passWord");
        String setParent = resource.getString("setParent");
        String mapperPath = resource.getString("mapperPath");

        //代碼生成器
        AutoGenerator mpg = new AutoGenerator();

        //全局配置
        GlobalConfig gc = new GlobalConfig();
        //生成的文件輸出到哪
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + outPutDir);
        //默認主鍵生成策略為uuid
        // AUTO(0),
        //    NONE(1),
        //    INPUT(2),
        //    ID_WORKER(3),
        //    UUID(4),
        //    ID_WORKER_STR(5)
        gc.setIdType(IdType.AUTO);
        gc.setOpen(false);
        gc.setFileOverride(fileOverride);
        gc.setAuthor("Jeff");
        gc.setBaseColumnList(true);
        gc.setBaseResultMap(true);

        gc.setEntityName("%sEntity");
        gc.setMapperName("%sDao");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");
        mpg.setGlobalConfig(gc);
        //gc.setIdType(IdType.UUID);
        //是否開啟Swagger2
        //gc.setSwagger2(true);
        //gc.setXmlName("%sDaoMapper");


        //數據源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl(url);
        dsc.setDriverName(driverClass);
        dsc.setUsername(userName);
        dsc.setPassword(passWord);
        mpg.setDataSource(dsc);


        //包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(setParent);
        pc.setMapper("dao")
                .setService("service")
                .setController("controller")
                .setEntity("entity");
        mpg.setPackageInfo(pc);


        //自定義配置
        if (StringUtils.isNotEmpty(mapperPath)) {
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    // to do nothing
                }
            };
            List<FileOutConfig> focList = new ArrayList<>();
            //mapper.xml
            focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
                @Override
                public String outputFile(TableInfo tableInfo) {
                    // 自定義輸入文件名稱
                    return projectPath + mapperPath
                            + tableInfo.getMapperName() + "Mapper" + StringPool.DOT_XML;
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);
        }


        //模板配置
        TemplateConfig tc = new TemplateConfig();
        tc.setController("/templates/controller.java")
                .setEntity("/templates/entity.java")
                .setMapper("/templates/mapper.java")
                .setService("/templates/service.java")
                .setServiceImpl("/templates/serviceImpl.java")
                .setXml(null);
        mpg.setTemplate(tc);


        //策略配置
        StrategyConfig strategy = new StrategyConfig();
        //下劃線到駝峰的命名方式
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //使用lombok
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        strategy.setInclude(scanner("表名"));
        strategy.setControllerMappingHyphenStyle(true);
        //繼承自定義的controller，service，impl，dao
        strategy.setSuperControllerClass("com.jeff.common.base.BaseController");
        strategy.setSuperServiceClass("com.jeff.common.base.BaseService");
        strategy.setSuperServiceImplClass("com.jeff.common.base.BaseServiceImpl");
        strategy.setSuperMapperClass("com.jeff.common.base.BaseDao");
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.setStrategy(strategy);
        mpg.execute();
    }
}
