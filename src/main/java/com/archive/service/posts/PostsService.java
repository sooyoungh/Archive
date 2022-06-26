package com.archive.service.posts;

import com.archive.domain.posts.Posts;
import com.archive.domain.posts.PostsRepository;
import com.archive.web.dto.PostsResponseDto;
import com.archive.web.dto.PostsSaveRequestDto;
import com.archive.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts post = postsRepository.findById(id)
                .orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id =" + id)
                );

        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException( "해당 게시글이 없습니다. id =" + id)
                );
        return new PostsResponseDto(entity);
    }
}
