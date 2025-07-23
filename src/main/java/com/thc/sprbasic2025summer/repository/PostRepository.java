package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}