package com.wasthDev.IPL.Dashboard.controller;

import com.wasthDev.IPL.Dashboard.model.Team;
import com.wasthDev.IPL.Dashboard.repositry.MatchRepository;
import com.wasthDev.IPL.Dashboard.repositry.TeamRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    public TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {
        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }


    @GetMapping("/team/{teamname}")
    public Team getTeam(@PathVariable String teamname){
     Team team =  this.teamRepository.findByTeamName(teamname);
    team.setMatches(this.matchRepository.findLatestMatchesByTeam(teamname,4));
     return team;
    }
}
