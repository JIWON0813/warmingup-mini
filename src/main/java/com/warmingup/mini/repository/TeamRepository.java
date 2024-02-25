package com.warmingup.mini.repository;

import com.warmingup.mini.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, String> {
}
