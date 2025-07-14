package com.thc.sprbasic2025summer.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User extends AuditingField{
    String username;
    String password;
    String name;
    String phone;
}
