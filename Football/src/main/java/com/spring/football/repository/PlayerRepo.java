package com.spring.football.repository;

import com.spring.football.model.PlayerTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepo extends JpaRepository<PlayerTeam,Long> {
    public PlayerTeam findByFromAndTo(String from,String to);
}
