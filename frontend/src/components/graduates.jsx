// import React, { useState } from 'react';
import axios from 'axios';

// export const UserContext = React.createContext();

const Graduates = async () => {

    const list = await axios.get("hhtp://localhost:8080/user/all")
    const view = await list.data;

    return (
        <ul>
            { view.map(res => <li key={ res }> {{ res }}</li>) }
        </ul>
    )
}

export default Graduates;