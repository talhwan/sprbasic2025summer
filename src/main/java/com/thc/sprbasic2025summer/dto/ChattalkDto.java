package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.domain.Chattalk;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class ChattalkDto {


    /**/

    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long chatuserId;
        String content;

        public Chattalk toEntity(){
            return Chattalk.of(getChatuserId(), getContent());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String content;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        Long chatuserId;
        String content;

        Long chatId;
        Long userId;
        String userName;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        Long chatId;
        Long userId;
        Long chatuserId;
        Long myChatuserId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        Long chatId;
        Long userId;
        Long chatuserId;
        Long myChatuserId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        Long chatId;
        Long userId;
        Long chatuserId;
        Long myChatuserId;
    }
}
