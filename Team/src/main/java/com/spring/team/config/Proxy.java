package com.spring.team.config;

import com.spring.team.model.Team;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "football-players",url = "localhost:9094")
//,url = "${football-players.url}"
@FeignClient(name = "football-players")
@RibbonClient(name = "football-players")
@Service
public interface Proxy {
    @GetMapping("/football-players/buy/{from}/club/{to}")
    public Team getFootballPlayer(@PathVariable String from,@PathVariable String to);
}
