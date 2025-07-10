package com.thc.sprbasic2025summer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardCreateReqDto {
    String title;
    String content;
    String author;
}
