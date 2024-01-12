import reactLogo from "./assets/react.svg";

import './assets/App.css'
import './assets/welcome.css'

import {Welcome} from "./views/welcome.jsx";

function App() {

  return (
    <div id='App'>
      <nav><div>
        <span>Made with React</span>
        <a href="https://reactjs.org" target="_blank" rel="noreferrer">
            <img src={reactLogo} width="70" className="react-logo" alt="React logo"/>
        </a>
      </div></nav>

      <Welcome />
    </div>
  )
}

export default App;