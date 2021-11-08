package com.wasthDev.IPL.Dashboard.controller;

import com.wasthDev.IPL.Dashboard.model.Matchs;
import com.wasthDev.IPL.Dashboard.model.Team;
import com.wasthDev.IPL.Dashboard.repositry.MatchRepository;
import com.wasthDev.IPL.Dashboard.repositry.TeamRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping("/team")
    public Iterable<Team> getAllTeam(){
        return  this.teamRepository.findAll();
    }


    @GetMapping("/team/{teamname}/matches")
    public List<Matchs> getMatchesForTeam(@PathVariable String teamname , @RequestParam int year){
        LocalDate startDate = LocalDate.of(year,1,1);
        LocalDate endDate = LocalDate.of(year+1,1,1);
       return this.matchRepository.getMatchsByTeamBetweenDates(
                teamname,
               startDate,
               endDate
        );
    }
}
