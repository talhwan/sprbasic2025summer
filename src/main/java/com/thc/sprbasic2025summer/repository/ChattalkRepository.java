package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.Chattalk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChattalkRepository extends JpaRepository<Chattalk, Long> {
}