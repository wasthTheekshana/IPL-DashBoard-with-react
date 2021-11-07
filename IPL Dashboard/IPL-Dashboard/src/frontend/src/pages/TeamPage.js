import {React, useEffect, useState} from 'react';
import {MatchDetailCard} from "../components/MatchDetailCard";
import {MathSmallCard} from "../components/MathSmallCard";

export const TeamPage = () => {

    const[team, setTeam] = useState({matches: []});
    useEffect(
        () =>{
            const fetchMatches = async () => {
            const response = await fetch('http://localhost:8080/team/Mumbai%20Indians');
            const data = await response.json();
            console.log(data);
           setTeam(data);
            };
            fetchMatches();
        },[]
    );
    let matchesRender;
    return (
        <div className="TeamPage">
            <h1>{team.teamName}</h1>
           <MatchDetailCard match={team.matches[0]}/>
            {team.matches.slice(1).map(match => <MathSmallCard match={match}/>)}
        </div>
    );
}

