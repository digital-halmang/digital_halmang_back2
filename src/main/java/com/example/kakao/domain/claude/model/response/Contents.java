package com.example.kakao.domain.claude.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Contents {

    private CardNews cardNews;

    private BlogPost blogPost;

    private Caption caption;

    public Contents(Caption caption) {
        this.caption = caption;
    }

    public void setCardNews(CardNews cardNews) {
        this.cardNews = cardNews;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }
}
