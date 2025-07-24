package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.domain.Postlike;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class PostlikeDto {


    @Setter @Getter @Builder
    public static class WatchReqDto {
        Long postId;
        Long userId;
    }
    @Setter @Getter @Builder
    public static class WatchResDto {
        Boolean isLiked;
    }

    @Setter @Getter @Builder
    public static class ToggleReqDto {
        Long postId;
        Long userId;
        Boolean like; // 라이크 추가인지, 취소인지 여부!
    }
    @Setter @Getter @Builder
    public static class ToggleResDto {
        Integer countlike;
    }

    /**/

    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long postId;
        Long userId;

        public Postlike toEntity(){
            return Postlike.of(getPostId(), getUserId());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        Long postId;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        Long postId;
        Long userId;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        Long postId;
        Long userId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        Long postId;
        Long userId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        Long postId;
        Long userId;
    }
}
