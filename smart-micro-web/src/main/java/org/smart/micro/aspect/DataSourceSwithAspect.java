package org.smart.micro.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.smart.micro.config.datasource.DBTypeEnum;
import org.smart.micro.config.datasource.DbContextHolder;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @ClassName DataSourceSwithAspect
 * @Description TODO
 * @Author jiangsida
 * @VERSION 1.0
 */
@Component
@Slf4j
@Aspect
@Order(value=-100)
public class DataSourceSwithAspect {
    /**
     * 定义切点db1 文件夹下面的类的任何方法
     */
    @Pointcut("execution(* org.smart.micro.mapper.db1..*.*(..))")
    public  void db1Aspect(){

    }
    @Pointcut("execution(* org.smart.micro.mapper.db2..*.*(..))")
    public  void  db2Aspect(){

    }

    @Before("db1Aspect()")
    public void db1(){
        log.info("切换到db1数据源");
        DbContextHolder.setDbType(DBTypeEnum.db1);
    }
    @Before("db2Aspect()")
    public  void db2(){
        log.info("切换到db2数据源");
        DbContextHolder.setDbType(DBTypeEnum.db2);
    }


}
