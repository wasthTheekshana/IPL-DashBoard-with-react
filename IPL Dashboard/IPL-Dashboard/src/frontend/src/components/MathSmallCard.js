import {React} from 'react';
import { Link } from "react-router-dom";
import './MatchSmallCard.scss'
export const MathSmallCard = ({teamName, match}) => {
    const otherTeam = match.team1 === teamName ? match.team2 : match.team1;
    const otherTeamRoutes = `/team/${otherTeam}`;
    const isMatchWon = teamName === match.winner;
    return (
        <div  className={isMatchWon ? 'MatchSmallCard won-card' : 'MatchSmallCard lost-card'}>
            <span className="vs">vs</span>
            <h1><Link to={otherTeamRoutes}>{otherTeam}</Link></h1>
            <p className="match-result">{match.winner} won by {match.resultMargin} {match.result}</p>
        </div>
    );
}
