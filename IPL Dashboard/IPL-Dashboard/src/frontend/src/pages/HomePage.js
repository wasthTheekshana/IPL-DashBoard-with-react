import {React, useEffect, useState} from 'react';
import './HomePage.scss';
import {TeamTile} from "../components/TeamTile";


export const HomePage = () => {

    const [team, setTeam] = useState([]);

    useEffect(
        () => {
            const fetchMatches = async () => {
                const response = await fetch(`${process.env.REACT_APP_API_ROOT_URL}/team`);
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
                    {team.map(team => <TeamTile key={team.id} teamName={team.teamName}/>)}
                </div>
        </div>
    );
}

