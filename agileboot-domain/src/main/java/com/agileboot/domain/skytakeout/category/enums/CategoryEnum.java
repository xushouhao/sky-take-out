package com.agileboot.domain.skytakeout.category.enums;


import com.agileboot.common.enums.DictionaryEnum;
import com.agileboot.common.enums.dictionary.CssTag;
import com.agileboot.common.enums.dictionary.Dictionary;
import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

@Dictionary(name = "Category.type")
public enum CategoryEnum implements DictionaryEnum<Integer> {

    /**
     * 用户性别
     */
    MEAL(1, "菜品分类", CssTag.PRIMARY),
    MENU(2, " 套餐分类", CssTag.PRIMARY);
    @EnumValue
    @JsonValue
    private final int value;
    private final String description;
    private final String cssTag;


    CategoryEnum(int value, String description, String cssTag) {
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
