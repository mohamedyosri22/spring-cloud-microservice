package com.spring.player.controller;


import com.spring.player.config.PlayerStatisticsConfiguration;
import com.spring.player.model.PlayerStatistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/players-statistics")
public class PlayerStatisticsController {

    @Autowired
    private PlayerStatisticsConfiguration playerStat;

    @GetMapping("/statistics")
    public PlayerStatistics getPlayerStatistics(){
        return new PlayerStatistics(playerStat.getNumberTeams(),playerStat.getNumberPlayers(),playerStat.getCountry());
    }

   /* @GetMapping("/sum")
    @HystrixCommand(fallbackMethod = "callBack")
    public String getSum(){
        throw new NullPointerException("idk");
    }

    public String callBack(){
        return "Enabled !!";
    }*/
}
