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
    @UniqueConstraint(name = "UQ_postlike_postId_userId", columnNames = {"postId", "userId"})
})
@Entity
public class Postlike extends AuditingField{
    Long postId;
    Long userId;

    protected Postlike() {}
    private Postlike(Long postId, Long userId) {
        this.postId = postId;
        this.userId = userId;
    }

    public static Postlike of(Long postId, Long userId) {
        return new Postlike(postId, userId);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
