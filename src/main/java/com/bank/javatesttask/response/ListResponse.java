package com.bank.javatesttask.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ListResponse<T> {
    private List<T> data;
    private Page<T> page;
    private Integer code;

    public ListResponse(org.springframework.data.domain.Page<T> data) {
        this(data, 200);
    }

    public ListResponse(org.springframework.data.domain.Page<T> data, Integer code) {
        this.data = data.getContent();
        this.page = new Page<T>(data);
        this.code = code;
    }

    public ListResponse(List<T> data) {
        this(data, 200);
    }

    public ListResponse(List<T> data, Integer code) {
        this.data = data;
        this.page = null;
        this.code = code;
    }
}
