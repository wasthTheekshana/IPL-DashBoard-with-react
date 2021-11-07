package com.wasthDev.IPL.Dashboard.data;
import com.wasthDev.IPL.Dashboard.model.Matchs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

// input output
public class MathDataProcessor implements ItemProcessor<MatchInput, Matchs> {
    private static final Logger log = LoggerFactory.getLogger(MathDataProcessor.class);

    @Override
    public Matchs process(final MatchInput matchInput) throws Exception {
        Matchs match = new Matchs();
        match.setId(Long.parseLong(matchInput.getId()));
        match.setCity(matchInput.getCity());

        match.setDate(LocalDate.parse(matchInput.getDate()));
        match.setPlayerOfMatch(matchInput.getPlayer_of_match());
        match.setVenue(matchInput.getVenue());

        //set team 1 2 depending the inning order
        String firstInningTeam,seaconInniongTeam;

        if ("bat".equals(matchInput.getToss_decision())){
            firstInningTeam = matchInput.getToss_winner();
            seaconInniongTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
        }else {
            seaconInniongTeam = matchInput.getToss_winner();
            firstInningTeam = matchInput.getToss_winner().equals(matchInput.getTeam1()) ? matchInput.getTeam2() : matchInput.getTeam1();
        }
        match.setTeam1(firstInningTeam);
        match.setTeam2(seaconInniongTeam);
        match.setTossWinner(matchInput.getToss_winner());
        match.setTossDecision(matchInput.getToss_decision());
        match.setWinner(matchInput.getWinner());
        match.setResult(matchInput.getResult());
        match.setResultMargin(matchInput.getResult_margin());
        match.setUmpire1(matchInput.getUmpire1());
        match.setUmpire2(matchInput.getUmpire2());


        return match;
    }
}
