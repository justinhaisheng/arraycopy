package com.aispeech.array_copy.data;

/**
 * @创建者 luhaisheng
 * @创建时间 2020/2/6 10:53
 * @描述 ${TOO}
 */
public class WorkStation<T> {
    private T employee;
    public WorkStation(T employee) {
        this.employee = employee;
    }

    public T getEmployee() {
        return employee;
    }

    public void setEmployee(T employee) {
        this.employee = employee;
    }
}
