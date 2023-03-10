package com.spring.football.controller;

import com.netflix.discovery.EurekaClient;
import com.spring.football.model.PlayerTeam;
import com.spring.football.repository.PlayerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/football-players")
public class FootballController {
    @Autowired
    private PlayerRepo playerRepo;

    @Value("${server.port}")
    private String port;

    @GetMapping("/buy/{from}/club/{to}")
    public PlayerTeam buyPlayer(@PathVariable("from")String from,
                                @PathVariable("to")String to){

        PlayerTeam player = playerRepo.findByFromAndTo(from,to);
        player.setPort(port);

        return player;
    }
}
