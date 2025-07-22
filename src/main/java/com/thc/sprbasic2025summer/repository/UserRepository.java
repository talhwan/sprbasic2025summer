package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);

    //List<User> findByPhone(String phone);
}
