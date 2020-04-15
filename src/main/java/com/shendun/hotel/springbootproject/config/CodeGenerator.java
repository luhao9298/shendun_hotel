package com.shendun.hotel.springbootproject.config;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: CodeGeneration
 * @Description: 代码生成器
 * @author lh
 * @date 2020年4月2日14:08:37
 */

public class CodeGenerator {
    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/lh_database?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true");
        // dsc.setSchemaName("public");
        //dsc.setDriverName("com.mysql.cj.jdbc.Driver");
         dsc.setDriverName("com.mysql.jdbc.Driver"); //mysql5.6以下的驱动
        dsc.setUsername("root");
        dsc.setPassword("1234QWERt-");
        mpg.setDataSource(dsc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
       // gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("lh");//作者名称
        gc.setOpen(false);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
//        gc.setControllerName("%sController");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setIdType(IdType.ASSIGN_UUID);
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

         gc.setSwagger2(false); //实体属性 Swagger2 注解
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.shendun.hotel.springbootproject");
      // pc.setModuleName("generation"); //自定义包名
        pc.setMapper("mapper");//dao
        pc.setService("service");//servcie
        pc.setController("controller");//controller
        pc.setEntity("entity");



        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        // 模板引擎是 freemarker
        // 自定义controller的代码模板
        // 如果模板引擎是 velocity
//         String templatePath = "/templates/mapper.xml.vm";
          String templatePath = "/templates/mapper.xml.ftl";
//        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();

//        // 自定义配置会被优先输出,配置mapper.xml
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
               /* return projectPath + "/src/main/resources/mappers/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;*/
                //根据自己的位置修改
                return projectPath + "/src/test/java/com/shendun/hotel/springbootproject/generation/" +tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        //控制层
        templatePath = "/templates/controller.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/test/java/com/shendun/hotel/springbootproject/generation/" + "controller";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getControllerName());
                return entityFile;
            }
        });

        //业务层
        templatePath = "/templates/service.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/test/java/com/shendun/hotel/springbootproject/generation/" + "service";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getServiceName());
                return entityFile;
            }
        });
        templatePath = "/templates/serviceImpl.java.ftl";
         //自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/test/java/com/shendun/hotel/springbootproject/generation/" + "service/impl";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getServiceImplName());
                return entityFile;
            }
        });

        //数据层
        templatePath = "/templates/mapper.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/test/java/com/shendun/hotel/springbootproject/generation/"+"mapper";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getMapperName());
                return entityFile;
            }
        });

        //数据层
        templatePath = "/templates/entity.java.ftl";
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 + pc.getModuleName()
                String expand = projectPath + "/src/test/java/com/shendun/hotel/springbootproject/generation/"+"entity";
                String entityFile = String.format((expand + File.separator + "%s" + ".java"), tableInfo.getEntityName());
                return entityFile;
            }
        });

        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录");
                return false;
            }
        });
        */
        mpg.setPackageInfo(pc);
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
//        templateConfig.setEntity("templates/1.java");
        // templateConfig.setService();
       // templateConfig.setController(null);
        //此处设置为null，就不会再java下创建xml的文件夹了
       // templateConfig.setXml(null);
        mpg.setTemplate(templateConfig);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        strategy.setEntityLombokModel(true);
        strategy.setRestControllerStyle(true);
        TableFill create_time=new TableFill("create_time", FieldFill.INSERT);
        TableFill update_time = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(create_time);
        tableFills.add(update_time);
        strategy.setTableFillList(tableFills);
        strategy.setVersionFieldName("version");
        // 公共父类
        //strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");
        //表名
        strategy.setInclude("person_info");
        strategy.setControllerMappingHyphenStyle(true);
        //根据你的表名来建对应的类名，如果你的表名没有什么下划线，比如test，那么你就可以取消这一步
        //strategy.setTablePrefix("person_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
