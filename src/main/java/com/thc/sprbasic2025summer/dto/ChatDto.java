package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.domain.Chat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

public class ChatDto {

    /**/

    @Setter @Getter @Builder
    public static class CreateReqDto {
        String title;

        Long fromUserId;
        Long toUserId;

        public Chat toEntity(){
            return Chat.of(getTitle());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String title;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        String title;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        String title;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        String title;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        String title;
    }
}
