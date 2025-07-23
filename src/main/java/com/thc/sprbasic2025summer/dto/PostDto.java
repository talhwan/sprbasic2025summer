package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.domain.Post;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class PostDto {

    /**/

    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long userId;
        String title;
        String content;
        String img;

        List<String> imgs;

        public Post toEntity(){
            return Post.of(getUserId(), getTitle(), getContent(), getImg());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String title;
        String content;
        String img;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        Long userId;
        String title;
        String content;
        String img;

        List<PostimgDto.DetailResDto> imgs;

        String userUsername;
        String userName;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        Long userId;
        String title;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        Long userId;
        String title;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        Long userId;
        String title;
    }
}
