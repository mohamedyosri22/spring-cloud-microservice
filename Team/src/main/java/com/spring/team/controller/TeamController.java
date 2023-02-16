package com.spring.team.controller;

import com.netflix.discovery.EurekaClient;
import com.spring.team.config.Proxy;
import com.spring.team.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/team-players")
public class TeamController {
    @Autowired
    private Proxy proxy;

    @GetMapping("/team/{from}/player/{to}")
    public Team teamWithPlayer(@PathVariable String from,@PathVariable String to){
        Map<String,String> urlAttribute = new HashMap<>();
        urlAttribute.put("from",from);
        urlAttribute.put("to",to);

        var callApi = new RestTemplate().getForEntity(
                "http://localhost:9092/football-players/buy/{from}/club/{to}",
                Team.class,urlAttribute
        );



        Team team = new Team(callApi.getBody().getId(),callApi.getBody().getFrom(),callApi.getBody().getTo(),callApi.getBody().getMoneyTeam(),"NONE","50");
        team.setPort(callApi.getBody().getPort());
        return team;
    }

    @GetMapping("/teamNew/{from}/player/{to}")
    public Team teamWithPlayerNew(@PathVariable String from,@PathVariable String to){
        Team teamResponse = proxy.getFootballPlayer(from,to);
        teamResponse.setNumberTeam("5000");
        teamResponse.setNote("NONE");

        //Team team = new Team(teamResponse.getId(),teamResponse.getFrom(),teamResponse.getTo(),teamResponse.getMoneyTeam(),"NONE","50");

        return teamResponse;
    }
}
