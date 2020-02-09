package com.aispeech.array_copy.data;

/**
 * @创建者 luhaisheng
 * @创建时间 2020/2/6 10:52
 * @描述 ${TOO}
 */
public class Manager extends Employee{
    private Integer level;
    public Manager(String name) {
        super(name);
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
