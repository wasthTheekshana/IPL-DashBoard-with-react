package com.wasthDev.IPL.Dashboard.repositry;

import com.wasthDev.IPL.Dashboard.model.Matchs;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Matchs,Long> {
    List<Matchs> getByTeam1OrTeam2OrderByDateDesc(String teamName1, String teamName2, Pageable pageable);

//    List<Matchs> getByTeam1AndDateBetweenOrTeam2AndDateBetweenOrderByDateDesc(
//            String teamName1, LocalDate date1, LocalDate date2,
//            String teamName2, LocalDate date3, LocalDate date4
//    );

    @Query("select m from Matchs m where (m.team1 = :teamName or m.team2 = :teamName) and m.date between :dateStart and :dateEnd order by current_date desc")
    List<Matchs> getMatchsByTeamBetweenDates(@Param("teamName") String teamName, @Param("dateStart") LocalDate dateStart, @Param("dateEnd") LocalDate dateEnd);

    default List<Matchs> findLatestMatchesByTeam(String teamName , int count){
        return getByTeam1OrTeam2OrderByDateDesc(teamName,teamName, PageRequest.of(0,count));
    }
}
