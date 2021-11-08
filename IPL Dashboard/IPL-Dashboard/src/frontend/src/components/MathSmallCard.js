import {React} from 'react';
import { Link } from "react-router-dom";
import {MatchDetailCard} from "./MatchDetailCard";

export const MathSmallCard = ({teamName, match}) => {
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoutes = `/team/${otherTeam}`;
    return (
        <div className="MatchDetailCard">
            <h3>vs <Link to={otherTeamRoutes}>{otherTeam}</Link>
                </h3>
            <p>{match.winner} won by {match.resultMargin} {match.result}</p>
        </div>
    );
}
