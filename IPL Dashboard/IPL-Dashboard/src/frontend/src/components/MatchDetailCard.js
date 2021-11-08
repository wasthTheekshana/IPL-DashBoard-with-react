import { React } from 'react';
import {Link} from "react-router-dom";

export const MatchDetailCard = ({teamName,match}) => {
    if (!match) return null;
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoutes = `/team/${otherTeam}`;
    return (
        <div className="MatchDetailCard">
            <h1>Latest Matches</h1>
            <h4>Match details</h4>
            <h1>vs <Link to={otherTeamRoutes}>{otherTeam}</Link></h1>
            <h2>{match.date}</h2>
            <h2> at {match.venue}</h2>
            <h3>{match.winner} won by {match.resultMargin} {match.result}</h3>
        </div>
    );
}
