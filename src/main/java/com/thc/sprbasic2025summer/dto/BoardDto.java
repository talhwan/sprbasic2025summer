package com.thc.sprbasic2025summer.dto;

import com.thc.sprbasic2025summer.domain.Board;
import lombok.*;
import lombok.experimental.SuperBuilder;

public class BoardDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        String title;
        String content;
        String author;

        public Board toEntity(){
            return Board.of(getTitle(), getContent(), getAuthor());
        }
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto {
        String title;
        String content;
        String author;
    }

    @Setter @Getter @SuperBuilder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto extends DefaultDto.DetailResDto {
        String title;
        String content;
        String author;
    }
}
