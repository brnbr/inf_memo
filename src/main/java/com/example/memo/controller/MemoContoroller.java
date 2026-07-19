package com.example.memo.controller;

import com.example.memo.dto.*;
import com.example.memo.repository.MemoRepository;
import com.example.memo.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemoContoroller {

    private final MemoService memoService;

    //CREATE
    @PostMapping("/memos")
    public ResponseEntity<MemoCreateResponse> create(
            @RequestBody MemoCreateRequest request
    ) {
        return ResponseEntity.ok(memoService.save(request));
    }

    //READ - ALL
    @GetMapping("/memos")
    public ResponseEntity<List<GetMemoResponse>> getAll() {
        return ResponseEntity.ok(memoService.getAll());
    }

    //READ - ONE
    @GetMapping("/momes/{id}")
    public ResponseEntity<GetMemoResponse> getOne(@PathVariable Long id) {
        return ResponseEntity.ok(memoService.getOne(id));
    }

    //UPDATE
    @PutMapping("/memos/{id}")
    public ResponseEntity<MemoUpdateResponse> update(
            @PathVariable Long id,
            @RequestBody MemoUpdateRequest request
    ) {
        return ResponseEntity.ok(memoService.update(id, request));
    }

    //DELETE
    @DeleteMapping("/memos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        memoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
