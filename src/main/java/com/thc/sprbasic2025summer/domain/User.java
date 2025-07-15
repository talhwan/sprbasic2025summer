package com.thc.sprbasic2025summer.domain;

import com.thc.sprbasic2025summer.dto.DefaultDto;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends AuditingField{
    String username; // 아이디 기능!
    String password; // 비밀번호!!
    String name;
    String phone;

    protected User() {}
    private User(String username, String password, String name, String phone) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
    }

    public static User of(String username, String password, String name, String phone) {
        return new User(username, password, name, phone);
    }

    public DefaultDto.CreateResDto toCreateResDto() {
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }
}
