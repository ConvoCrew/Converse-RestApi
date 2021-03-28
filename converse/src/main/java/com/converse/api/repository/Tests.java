package com.converse.api.repository;

import com.converse.api.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tests extends JpaRepository<Test, Long> {
}
