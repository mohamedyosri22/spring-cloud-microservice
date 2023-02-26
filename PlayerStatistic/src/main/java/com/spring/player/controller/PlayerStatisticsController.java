package com.spring.player.controller;


import com.spring.player.config.PlayerStatisticsConfiguration;
import com.spring.player.model.PlayerStatistics;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/players-statistics")
public class PlayerStatisticsController {

    private Logger logger =
            LoggerFactory.getLogger(PlayerStatisticsController.class);


    @Autowired
    private PlayerStatisticsConfiguration playerStat;

    @GetMapping("/statistics")
    public PlayerStatistics getPlayerStatistics(){
        return new PlayerStatistics(playerStat.getNumberTeams(),playerStat.getNumberPlayers(),playerStat.getCountry());
    }

    @GetMapping("/salary")
    @Retry(name = "mySettings",fallbackMethod ="callBack") //3 times
    public Integer salary(){
        logger.info("Request Done !");
        ResponseEntity<Integer> salary = new RestTemplate().getForEntity(
                "http://localhost:9631/players-statistics/salary",Integer.class
        );

        return salary.getBody();
    }

   /* @GetMapping("/sum")
    @HystrixCommand(fallbackMethod = "callBack")
    public String getSum(){
        throw new NullPointerException("idk");
    }
    */

    public Integer callBack(Exception e){
        return 1500;
    }
}
