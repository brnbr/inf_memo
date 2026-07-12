package com.example.memo.dto;

import lombok.Getter;

@Getter
public class GetMemoResponse {

    private final Long id;
    private final String content;

    public GetMemoResponse(Long id, String content) {
        this.id = id;
        this.content = content;
    }
}
