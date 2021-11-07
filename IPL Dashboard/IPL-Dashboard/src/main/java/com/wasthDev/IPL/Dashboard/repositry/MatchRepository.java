package com.wasthDev.IPL.Dashboard.repositry;

import com.wasthDev.IPL.Dashboard.model.Matchs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Matchs,Long> {
    List<Matchs> getByTeam1OrTeam2(String teamName1,String teamName2);

}
