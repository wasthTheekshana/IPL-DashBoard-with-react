import {React, useEffect, useState} from 'react';
import './HomePage.scss';
import { PieChart } from 'react-minimal-pie-chart';
import {TeamTile} from "../components/TeamTile";


export const HomePage = () => {

    const [team, setTeam] = useState([]);

    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch(`http://localhost:8080/team`);
                const data = await response.json();
                console.log(data);
                setTeam(data);
            };
            fetchMatches();
        }, []
    );
    return (
        <div className="HomePage">
            <div className="header-section"><h1 className="app-name ">IPL Dashboard</h1></div>
                <div className="team-grid">
                    {team.map(team => <TeamTile teamName={team.teamName}/>)}
                </div>
        </div>
    );
}

