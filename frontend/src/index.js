import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import ExtraordinaryMap from './ExtraordinaryMap'; // Import the component
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));

if (window.location.port === '3000') {
  root.render(
    <React.StrictMode>
      <App />
    </React.StrictMode>
  );
} else if (window.location.port === '4000') {
  root.render(
    <React.StrictMode>
      <ExtraordinaryMap /> 
    </React.StrictMode>
  );
}

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
