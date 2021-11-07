package com.wasthDev.IPL.Dashboard.repositry;

import com.wasthDev.IPL.Dashboard.model.Team;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends CrudRepository<Team,Long> {
    Team findByTeamName(String teamName);
}
