import {React, useEffect, useState} from 'react';
import {Link} from "react-router-dom";
import './YearSelectedCard.scss'
export const YearSelectedCard = ({teamName}) => {

    let years = [];
    const startYear = process.env.REACT_APP_DATA_START_YEAR;
    const endYear = process.env.REACT_APP_DATA_END_YEAR;

    for (let i = startYear; i<= endYear; i++){
        years.push(i);
    }
    return(
        <ol className="YearSelectedCard">
            {years.map(year => <li><Link to={`/team/${teamName}/matches/${year}`}>{year}</Link></li>)}

        </ol>
    );
}