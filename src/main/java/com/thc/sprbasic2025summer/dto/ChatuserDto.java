package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.domain.Chatuser;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class ChatuserDto {


    /**/

    @Setter @Getter @Builder
    public static class CreateReqDto {
        Long chatId;
        Long userId;

        public Chatuser toEntity(){
            return Chatuser.of(getChatId(), getUserId());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        Long chatId;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        Long chatId;
        Long userId;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ListReqDto extends DefaultDto.ListReqDto {
        Long chatId;
        Long userId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto {
        Long chatId;
        Long userId;
    }
    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto {
        Long chatId;
        Long userId;
    }
}
