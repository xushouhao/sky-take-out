package com.agileboot.domain.skytakeout.employee.enums;

import com.agileboot.common.enums.DictionaryEnum;
import com.agileboot.common.enums.dictionary.CssTag;
import com.agileboot.common.enums.dictionary.Dictionary;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 对应sys_user的sex字段
 *
 * @author valarchie
 */
@Dictionary(name = "Employee.sex")
public enum EmployeeSexEnum implements DictionaryEnum<Integer> {

    /**
     * 用户性别
     */
    MALE(1, "男", CssTag.PRIMARY),
    FEMALE(2, "女", CssTag.PRIMARY),
    UNKNOWN(0, "未知", CssTag.PRIMARY);
    @EnumValue
    @JsonValue
    private final int value;
    private final String description;
    private final String cssTag;


    EmployeeSexEnum(int value, String description, String cssTag) {
        this.value = value;
        this.description = description;
        this.cssTag = cssTag;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public String cssTag() {
        return cssTag;
    }

}
