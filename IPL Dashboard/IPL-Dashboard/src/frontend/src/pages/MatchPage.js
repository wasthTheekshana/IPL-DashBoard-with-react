import {React, useEffect, useState} from 'react';
import {useParams} from "react-router-dom";
import {MatchDetailCard} from "../components/MatchDetailCard";
import {MathSmallCard} from "../components/MathSmallCard";
import './MatchPage.scss'
import {YearSelectedCard} from "../components/YearSelectedCard";
export const MatchPage = () => {

    const [matches, setMatches] = useState([]);

    const { teamName,year } = useParams();
    useEffect(
        () =>{
            const fetchMatches = async () => {
                const response = await fetch(`http://localhost:8080/team/${teamName}/matches?year=${year}`);
                const data = await response.json();
                console.log(data);
                setMatches(data);
            };
            fetchMatches();
        },[teamName,year]
    );

return (
    <div className="MatchPage">
        <div className="year-selector">
            <h1>Select Year</h1>
            <YearSelectedCard teamName={teamName}/>
        </div>
        <div>
        <h1 className="page-heading">{teamName} matches in {year}</h1>
        {
            matches.map(match => <MatchDetailCard teamName={teamName} match={match}/>)
        }
        </div>
    </div>
);
}

