package org.smart.micro.config.datasource;

/**
 * @ClassName DBTypeEnum
 * @Description TODO
 * @Author jiangsida
 * @VERSION 1.0
 */
public enum DBTypeEnum {

    db1("db1"), db2("db2"), db3("db3");
    private String value;

    DBTypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
