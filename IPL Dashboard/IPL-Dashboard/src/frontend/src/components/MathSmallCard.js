import { React } from 'react';
import {MatchDetailCard} from "./MatchDetailCard";

export const MathSmallCard = ({ match }) => {
    return (
        <div className="MatchDetailCard">
      <p> {match.team1} vs {match.team2}</p>
        </div>
    );
}
