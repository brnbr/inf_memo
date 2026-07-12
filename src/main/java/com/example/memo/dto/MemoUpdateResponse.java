package com.example.memo.dto;

import lombok.Getter;

@Getter
public class MemoUpdateResponse {

    private final Long id;
    private final String content;

    public MemoUpdateResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
