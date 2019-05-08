package org.smart.micro.config.datasource;


import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MybatiesPlusConfig
 * @Description TODO
 * @Author jiangsida
 * @VERSION 1.0
 */
@EnableTransactionManagement
@Configuration
@MapperScan("org.smart.micro.mapper.db1")
public class MybatiesPlusConfig {
    //注册分页插件mybaties自动帮你分页
   @Bean
    public PaginationInterceptor paginationInterceptor(){
         return   new PaginationInterceptor();
   }

    @Bean("db1")
    @ConfigurationProperties("spring.datasource.druid.db1")
    public DataSource db1() {
        return DruidDataSourceBuilder.create().build();
    }
    /**
     * 多数据源配置就需要添加@Bean("db2)注解就行
     */

    /**
     * 动态数据源配置
     */
    @Bean
    @Primary
    public  DataSource multipleDataSource(@Qualifier("db1") DataSource db1){

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DBTypeEnum.db1.getValue(),db1);
        dynamicDataSource.setTargetDataSources(targetDataSources);
        dynamicDataSource.setDefaultTargetDataSource(db1);
         return  dynamicDataSource;

    }

    /**
     * 从mybatisplus中创建sqlSessionFactory
     * @return
     * @throws Exception
     */
    @Bean("SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {

        MybatisSqlSessionFactoryBean sqlSessionFactoryBean = new MybatisSqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(multipleDataSource(db1()));
        MybatisConfiguration configuration = new MybatisConfiguration();
        configuration.setJdbcTypeForNull(JdbcType.NULL);
        configuration.setMapUnderscoreToCamelCase(true);
        configuration.setCacheEnabled(false);
        sqlSessionFactoryBean.setConfiguration(configuration);
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{
                paginationInterceptor()
        });
         return sqlSessionFactoryBean.getObject();
    }

}
