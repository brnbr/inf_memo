package com.example.memo.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "memos")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String content;

    public Memo(String content) {
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }

}
