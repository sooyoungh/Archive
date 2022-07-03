package com.archive.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest // 다른 설정없을 시 H2에 자동 실행
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장 () {
        String title = "xexe";
        String content = "sdfsf";

        Posts post1 = Posts.builder().title(title).content(content).author("hah").build();

        postsRepository.save(post1);

        List<Posts> postList = postsRepository.findAll();

        Posts posts = postList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);

    }

}