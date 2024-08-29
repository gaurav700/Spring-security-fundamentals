package com.springSecurity.Spring.security.fundamentals.repositories;

import com.springSecurity.Spring.security.fundamentals.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
