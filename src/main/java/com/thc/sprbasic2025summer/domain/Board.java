package com.thc.sprbasic2025summer.domain;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board extends AuditingField{
    String title;
    String content;
    String author;

    protected Board() {}
    private Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public static Board of(String title, String content, String author) {
        return new Board(title, content, author);
    }

    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
