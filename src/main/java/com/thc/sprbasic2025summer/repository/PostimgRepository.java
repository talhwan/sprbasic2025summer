package com.thc.sprbasic2025summer.repository;

import com.thc.sprbasic2025summer.domain.Postimg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostimgRepository extends JpaRepository<Postimg, Long> {
}