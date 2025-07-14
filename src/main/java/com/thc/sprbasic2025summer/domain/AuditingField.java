package com.thc.sprbasic2025summer.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@ToString
@EntityListeners(AuditingEntityListener.class) //이게 있어야 자동으로 값 넣어줌!!
@MappedSuperclass
public class AuditingField {
    @Id // @Id 는 테이블에서 PK로 사용되는 것!! 무조건 unique 해야 함..
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id 값은 자동으로 올라가게 해줘!
    Long id;

    @Column(nullable = false) //이거는 테이블 컬럼에 속성을 주기 위함 입니다!! 낫 널!!!!
    @Setter
    protected Boolean deleted;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    protected LocalDateTime createdAt; // 생성일시

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @LastModifiedDate
    @Column(nullable = false)
    protected LocalDateTime modifiedAt; // 수정일시

    @PrePersist
    public void onPrePersist() {
        this.deleted = false;
    }
}
