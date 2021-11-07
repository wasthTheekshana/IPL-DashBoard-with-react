package com.wasthDev.IPL.Dashboard.repositry;

import com.wasthDev.IPL.Dashboard.model.Matchs;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Matchs,Long> {
    List<Matchs> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

    default List<Matchs> findLatestMatchesByTeam(String teamName , int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName, PageRequest.of(0,count));
    }
}
