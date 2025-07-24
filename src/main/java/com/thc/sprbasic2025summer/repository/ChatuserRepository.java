package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.Chatuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatuserRepository extends JpaRepository<Chatuser, Long> {
    Chatuser findByChatIdAndUserId(Long chatId, Long userId);
}