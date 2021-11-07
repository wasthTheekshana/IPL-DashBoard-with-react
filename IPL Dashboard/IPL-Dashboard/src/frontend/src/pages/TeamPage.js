import { React } from 'react';
import {MatchDetailCard} from "../components/MatchDetailCard";
import {MathSmallCard} from "../components/MathSmallCard";

export const TeamPage = () => {
    return (
        <div className="TeamPage">
            <h1>Team Name</h1>
           <MatchDetailCard/>
            <MathSmallCard/>
            <MathSmallCard/>
            <MathSmallCard/> 
        </div>
    );
}

