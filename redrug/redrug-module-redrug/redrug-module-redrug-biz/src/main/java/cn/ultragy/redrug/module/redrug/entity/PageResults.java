package cn.ultragy.redrug.module.redrug.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class PageResults<T> implements Serializable {
    private T data;
    private Boolean success;
    private Long total;

    public PageResults(T data, Boolean success, Long total) {
        this.data = data;
        this.success = success;
        this.total = total;
    }
}
