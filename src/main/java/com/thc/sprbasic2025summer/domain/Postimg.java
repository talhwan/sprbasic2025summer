package com.thc.sprbasic2025summer.domain;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Postimg extends AuditingField{
    Long postId;
    String img;

    protected Postimg() {}
    private Postimg(Long postId, String img) {
        this.postId = postId;
        this.img = img;
    }

    public static Postimg of(Long postId, String img) {
        return new Postimg(postId, img);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
