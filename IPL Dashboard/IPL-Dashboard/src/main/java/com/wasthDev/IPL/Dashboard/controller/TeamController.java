package com.wasthDev.IPL.Dashboard.controller;

import com.wasthDev.IPL.Dashboard.model.Team;
import com.wasthDev.IPL.Dashboard.repositry.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamController {

    private final TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


    @GetMapping("/team/{teamname}")
    public Team getTeam(@PathVariable String teamname){
     Team team =  this.teamRepository.findByTeamName(teamname);
     return team;
    }
}
