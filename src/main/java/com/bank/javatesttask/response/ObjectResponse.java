package com.bank.javatesttask.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ObjectResponse<T> {
    private T data;
    private Integer code;

    public ObjectResponse(T data) {
        this(data, 200);
    }

    public ObjectResponse(T data, Integer code) {
        this.data = data;
        this.code = code;
    }
}
