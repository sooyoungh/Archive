package com.archive.web.dto;

import com.archive.domain.posts.Posts;
import lombok.Builder;

public class PostsSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder // Dto 생성
    public PostsSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    // Dto를 엔티티로 변환해서 반환
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
