import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import AppLayout from './AppLayout.jsx'
import { BrowserRouter, Route, Routes } from 'react-router'

const appRouter = 
<BrowserRouter>
  <Routes>
    <Route path='/' element={<AppLayout />} />
  </Routes>
</BrowserRouter>

createRoot(document.getElementById('root')).render(
  <StrictMode>
    {appRouter}
  </StrictMode>,
)
