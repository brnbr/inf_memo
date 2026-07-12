package com.example.memo.dto;

import lombok.Getter;

@Getter
public class MemoCreateResponse {

    private final Long id;
    private final String content;

    public MemoCreateResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
