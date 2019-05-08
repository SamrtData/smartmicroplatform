package org.smart.micro.config.datasource;

/**
 * @ClassName DbContextHolder
 * @Description 获取数据源
 * @Author jiangsida
 * @VERSION 1.0
 */

public class DbContextHolder {

    private static final ThreadLocal contextHolder = new ThreadLocal<>();

    /**
     * 设置数据源
     * @param dbType
     */
    public  static  void setDbType(DBTypeEnum dbType){
        contextHolder.set(dbType.getValue());
    }

    /**
     * 获取数据源
     */
    public static  String getDbtype(){
        return (String)contextHolder.get();
    }

    /**
     * 清除当前上下文
     */
    public static void clearDbType(){
        contextHolder.remove();
    }


}
