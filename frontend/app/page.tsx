'use client'
import { useState } from 'react'

interface Fighter {
  name: string
  wins: number
  losses: number
  heightCms: number
  reachCms: number
  age: number
  weightClass: string
}

export default function Home() {
  const [searchTerm, setSearchTerm] = useState('')
  const [fighters, setFighters] = useState<Fighter[]>([])
  const [loading, setLoading] = useState(false)

  const searchFighters = async () => {
    if (!searchTerm.trim()) return
    
    setLoading(true)
    try {
      const response = await fetch(`http://localhost:8080/api/fighters/search?name=${searchTerm}`)
      const data = await response.json()
      setFighters(data)
    } catch (error) {
      console.error('Error fetching fighters:', error)
    } finally {
      setLoading(false)
    }
  }

  return (
    <main className="min-h-screen p-8 bg-gray-900 text-white">
      <div className="max-w-4xl mx-auto">
        <h1 className="text-4xl font-bold mb-8 text-center">UFC Fight Explorer</h1>
        
        <div className="bg-gray-800 p-6 rounded-lg mb-8">
          <div className="flex gap-4 mb-4">
            <input
              type="text"
              placeholder="Search for a fighter..."
              value={searchTerm}
              onChange={(e) => setSearchTerm(e.target.value)}
              className="flex-1 p-3 rounded bg-gray-700 text-white"
              onKeyPress={(e) => e.key === 'Enter' && searchFighters()}
            />
            <button
              onClick={searchFighters}
              disabled={loading}
              className="px-6 py-3 bg-blue-600 hover:bg-blue-700 rounded disabled:bg-gray-600"
            >
              {loading ? 'Searching...' : 'Search'}
            </button>
          </div>
          
          {fighters.length > 0 && (
            <div className="grid gap-4">
              {fighters.map((fighter, index) => (
                <div key={index} className="bg-gray-700 p-4 rounded">
                  <h3 className="text-xl font-semibold text-blue-400">{fighter.name}</h3>
                  <div className="grid grid-cols-2 gap-2 mt-2 text-sm">
                    <p>Record: {fighter.wins}-{fighter.losses}</p>
                    <p>Weight Class: {fighter.weightClass}</p>
                    <p>Height: {fighter.heightCms}cm</p>
                    <p>Reach: {fighter.reachCms}cm</p>
                    <p>Age: {fighter.age}</p>
                  </div>
                </div>
              ))}
            </div>
          )}
        </div>
      </div>
    </main>
  )
}