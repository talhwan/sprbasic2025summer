package com.thc.sprbasic2025summer.domain;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(
    indexes = {
    @Index(columnList = "deleted")
    })
@Entity
public class Chattalk extends AuditingField{
    Long chatuserId;
    String content;

    protected Chattalk() {}
    private Chattalk(Long chatuserId, String content) {
        this.chatuserId = chatuserId;
        this.content = content;
    }

    public static Chattalk of(Long chatuserId, String content) {
        return new Chattalk(chatuserId, content);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
