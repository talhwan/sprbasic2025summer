package com.thc.sprbasic2025summer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@EntityListeners(AuditingEntityListener.class) //이게 있어야 자동으로 값 넣어줌!!
@Getter
@Entity
public class Board {
    @Id // @Id 는 테이블에서 PK로 사용되는 것!! 무조건 unique 해야 함..
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 값은 자동으로 올라가게 해줘!
    Long id;

    @Setter String title;
    @Setter String content;
    @Setter String author;

    protected Board() {} // 나중 이야기인데, 이거 못쓰게 할껍니다!
    private Board(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    } // 이 생성자도 못쓰게 할껍니다!!

    // 이 메서드를 통해서만 데이터를 생성할 수 있습니다!!
    public static Board of(String title, String content, String author) {
        return new Board(title, content, author);
    }
}
