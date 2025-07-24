package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.Postlike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostlikeRepository extends JpaRepository<Postlike, Long> {
    Postlike findByPostIdAndUserId(Long postId, Long userId);
}