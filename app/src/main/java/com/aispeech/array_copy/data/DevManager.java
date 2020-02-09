package com.aispeech.array_copy.data;

/**
 * @创建者 luhaisheng
 * @创建时间 2020/2/6 10:53
 * @描述 ${TOO}
 */
public class DevManager extends Manager{
    private String language;
    public DevManager(String name) {
        super(name);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
