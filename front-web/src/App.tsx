import { ToastContainer } from 'react-toastify';

import 'react-toastify/dist/ReactToastify.css';

import Route from './Router';

import './App.css';


function App() {
  return (
    <div >
      <>
       <Route/>
       <ToastContainer />
       </>
    </div>
  );
}

export default App;
