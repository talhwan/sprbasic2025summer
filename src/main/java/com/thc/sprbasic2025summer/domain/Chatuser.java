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
    }
    ,uniqueConstraints= {
    @UniqueConstraint(name = "UQ_chatuser_chatId_userId", columnNames = {"chatId", "userId"})
})
@Entity
public class Chatuser extends AuditingField{
    Long chatId;
    Long userId;

    protected Chatuser() {}
    private Chatuser(Long chatId, Long userId) {
        this.chatId = chatId;
        this.userId = userId;
    }

    public static Chatuser of(Long chatId, Long userId) {
        return new Chatuser(chatId, userId);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
