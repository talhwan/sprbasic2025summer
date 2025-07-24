package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
    Chat findByTitle(String title);
}