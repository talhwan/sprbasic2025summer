package com.thc.sprbasic2025summer.dto;

import lombok.*;

public class BoardDto {
    @Setter @Getter @Builder
    public static class CreateReqDto {
        String title;
        String content;
        String author;
    }

    @Setter @Getter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class CreateResDto {
        Long id;
    }

    @Setter @Getter @Builder
    public static class UpdateReqDto {
        Long id; //필수!!
        String title;
        String content;
        String author;
    }

    @Setter @Getter @Builder @NoArgsConstructor @AllArgsConstructor
    public static class DetailResDto {
        Long id;
        String title;
        String content;
        String author;
    }
}
