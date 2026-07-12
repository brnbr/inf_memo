package com.example.memo.service;

import com.example.memo.dto.*;
import com.example.memo.entity.Memo;
import com.example.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemoService {

    private final MemoRepository memoRepository;

    //CREATE
    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request) {
        Memo memo = new Memo(request.getContent());
        Memo saved = memoRepository.save(memo);

        return new MemoCreateResponse(
                saved.getId(),
                saved.getContent()
        );
    }

    //RESEARCH - All
    @Transactional(readOnly = true)
    public List<GetMemoResponse> getAll() {
        List<Memo> memos = memoRepository.findAll();
        List<GetMemoResponse> dtos = new ArrayList<>();

        for (Memo memo : memos) {
            GetMemoResponse dto = new GetMemoResponse(
                    memo.getId(),
                    memo.getContent()
            );
            dtos.add(dto);
        }
        return dtos;
    }

    //REASERCH - One
    @Transactional(readOnly = true)
    public GetMemoResponse getOne(Long id) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("메모가 없습니다.")
        );

        return new GetMemoResponse(
            memo.getId(),
            memo.getContent()
        );
    }

    //UPDATE
    @Transactional
    public MemoUpdateResponse update(Long id, MemoUpdateRequest request) {
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalStateException("메모가 없습니다.")
        );

        memo.update(request.getContent());
        return new MemoUpdateResponse(
            memo.getId(),
            memo.getContent()
        );
    }

    //DELETE
    @Transactional
    public void delete(Long id) {
        boolean existence = memoRepository.existsById(id);

        if (!existence) {
            throw new IllegalArgumentException("메모가 없습니다.");
        }

        memoRepository.deleteById(id);
    }
}
