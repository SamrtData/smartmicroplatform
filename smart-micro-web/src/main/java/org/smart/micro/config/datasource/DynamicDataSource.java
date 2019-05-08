package org.smart.micro.config.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @ClassName DynamicDataSource
 * @Description 动态数据源切换充当了Datasource的路由中介，在运行时候根据key来切换
 * @Author jiangsida
 * @VERSION 1.0
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DbContextHolder.getDbtype();
    }
}
