"use client";
import { useState } from "react";
import { MagnifyingGlassIcon } from "@heroicons/react/24/outline";
import { NbaTeams, Positions, Heights, CollegeTeams, Countries, Weights } from "./PlayerData";

export default function Home() {
  const [focused, setFocused] = useState(false);
  const [searching, setSearching] = useState("");
  const [selectedTeams, setSelectedTeams] = useState<string[]>([]);
  const [selectedCountry, setSelectedCountry] = useState<string[]>([]);
  const [selectedDraftYear, setSelectedDraftYear] = useState<string[]>([]);
  const [selectedJerseyNumber, setSelectedJerseyNumber] = useState<string[]>([]);
  const [selectedHeight, setSelectedHeight] = useState<string[]>([]);
  const [selectedWeight, setSelectedWeight] = useState<number[]>([]);
  const [selectedCollege, setSelectedCollege] = useState<string[]>([]);
  const [selectedPosition, setSelectedPosition] = useState<string[]>([]);
  const [teamSearch, setTeamSearch] = useState("");

  return (
    <main className="flex min-h-screen flex-col items-center justify-between p-5">
      <header className="w-full">
        <nav className="flex flex-row justify-between items-center h-16 w-full">
          <h1 className="text-4xl font-extrabold">
              NBA LIST
          </h1>
          
          <div
            className={`flex items-center transition-all duration-300 ${
              focused ? "rounded-xl px-2" : ""
            }`}
            onMouseEnter={() => setFocused(true)}
            onMouseLeave={() => {
              if (searching === "") { 
                setFocused(false);
              }
            }}
          >
            {!focused ? (
              <MagnifyingGlassIcon 
                className="h-5 w-5 text-gray-400 cursor-pointer"
                onClick={() => setFocused(true)}
              />
            ) : (
              <input
                autoFocus
                className="pl-2 p-1 rounded-xl transition-all duration-300 w-48 bg-white border border-gray-400"
                placeholder="Search a player"
                onBlur={() => {
                  if (searching === "") {
                    setFocused(false);
                  } else {
                    setFocused(true);
                  }
                }}
                value={searching}
                onChange={e => setSearching(e.target.value)}
              />
            )}
          </div>
        </nav>

        {/* Filter */}
        <div className="mt-4 flex flex-row justify-start gap-4">
            <div className="flex flex-col gap-2">
              <h1 className="text-xl">Filter by teams</h1>
              <div>
                <input
                  autoFocus
                  placeholder="Search a team"
                  className="border-1 p-1"
                  value={teamSearch}
                  onChange={e =>
                    setTeamSearch(NbaTeams.filter((team => team.includes(e.target.value))))
                  }
                />
              </div>
               <div className="flex flex-col h-[150px] overflow-auto">
              {NbaTeams.filter(team => team.toLowerCase().includes(teamSearch.toLowerCase())).map(team => 
                <button 
                  key={team}
                  className={`p-1 cursor-pointer text-left text-m transition-colors
                    ${selectedTeams.includes(team)
                      ? 'bg-blue-500 text-white'
                      : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                  `}
                  onClick={() => {
                    if (selectedTeams.includes(team)) {
                      setSelectedTeams(selectedTeams.filter(t => t !== team));
                    } else {
                      setSelectedTeams([...selectedTeams, team]);
                    }
                  }}
                >
                  {team}
                </button>
              )}
              </div>
            </div>
            <div className="flex flex-col">
              <h1 className="text-xl">Filter by Countries</h1>
               <div className="flex flex-col h-[150px] overflow-auto">
              {Countries.map(country => 
                <button 
                  key={country}
                  className={`p-1 cursor-pointer text-left text-m transition-colors
                    ${selectedCountry.includes(country)
                      ? 'bg-blue-500 text-white'
                      : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                  `}
                  onClick={() => {
                    if (selectedCountry.includes(country)) {
                      setSelectedCountry(selectedCountry.filter(t => t !== country));
                    } else {
                      setSelectedCountry([...selectedCountry, country]);
                    }
                  }}
                >
                  {country}
                </button>
              )}
              </div>
              </div>

              <div className="flex flex-col">
                <h1 className="text-xl">Filter by Positions</h1>
                 <div className="flex flex-col h-[150px] overflow-auto">
                {Object.entries(Positions).map(([key, value]) => 
                  <button 
                    key={key}
                    className={`p-1 cursor-pointer text-left text-m transition-colors
                      ${selectedPosition.includes(key)
                        ? 'bg-blue-500 text-white'
                        : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                    `}
                    onClick={() => {
                      if (selectedPosition.includes(key)) {
                        setSelectedPosition(selectedPosition.filter(t => t !== key));
                      } else {
                        setSelectedPosition([...selectedPosition, key]);
                      }
                    }}
                  >
                    {value}
                  </button>
                )}
                </div>
              </div>
              <div className="flex flex-col">
                <h1 className="text-xl">Filter by Heights</h1>
                <div className="flex flex-col h-[150px] overflow-auto">
                {Heights.map(height => 
                  <button 
                    key={height}
                    className={`p-1 cursor-pointer text-left text-m transition-colors
                      ${selectedHeight.includes(height)
                        ? 'bg-blue-500 text-white'
                        : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                    `}
                    onClick={() => {
                      if (selectedHeight.includes(height)) {
                        setSelectedHeight(selectedHeight.filter(t => t !== height));
                      } else {
                        setSelectedHeight([...selectedHeight, height]);
                      }
                    }}
                  >
                    {height}
                  </button>
                )}
                </div>
              </div>
              <div className="flex flex-col">
                <h1 className="text-xl">Filter by Weights</h1>
                <div className="flex flex-col h-[150px] overflow-auto">
                {Weights.map(weight => 
                  <button 
                    key={weight}
                    className={`p-1 cursor-pointer text-left text-m transition-colors
                      ${selectedWeight.includes(weight)
                        ? 'bg-blue-500 text-white'
                        : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                    `}
                    onClick={() => {
                      if (selectedWeight.includes(weight)) {
                        setSelectedWeight(selectedWeight.filter(t => t !== weight));
                      } else {
                        setSelectedWeight([...selectedWeight, weight]);
                      }
                    }}
                    >
                    {weight}
                  </button>
                )}
                </div>
              </div>
              <div>
                <h1 className="text-xl">Filter by Colleges</h1>
                <div className="flex flex-col h-[150px] overflow-auto">
                {CollegeTeams.map(college => 
                  <button 
                    key={college}
                    className={`p-1 cursor-pointer text-left text-m transition-colors
                      ${selectedCollege.includes(college)
                        ? 'bg-blue-500 text-white'
                        : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                    `}
                    onClick={() => {
                      if (selectedCollege.includes(college)) {
                        setSelectedCollege(selectedCollege.filter(t => t !== college));
                      } else {
                        setSelectedCollege([...selectedCollege, college]);
                      }
                    }}
                  >
                    {college}
                  </button>
                )}
                </div>
              </div>
                <div className="flex flex-col">
                  <h1 className="text-xl">Filter by Jersey Numbers</h1>
                   <div className="flex flex-col h-[150px] overflow-auto">
                  {Array.from({ length: 100 }, (_, i) => {
                    const num = String(i);
                    return (
                      <button
                        key={num}
                        className={`p-1 cursor-pointer text-left text-m transition-colors
                          ${selectedJerseyNumber.includes(num)
                            ? 'bg-blue-500 text-white'
                            : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                        `}
                        onClick={() => {
                          if (selectedJerseyNumber.includes(num)) {
                            setSelectedJerseyNumber(selectedJerseyNumber.filter(t => t !== num));
                          } else {
                            setSelectedJerseyNumber([...selectedJerseyNumber, num]);
                          }
                        }}
                      >
                        {num}
                      </button>
                    );
                  })}
                  </div>
                </div>

                <div className="flex flex-col">
                  <h1 className="text-xl">Filter by Draft Years</h1>
                   <div className="flex flex-col h-[150px] overflow-auto">
                  {Array.from({ length: 2022 - 2008 + 1 }, (_, i) => {
                    const year = String(2008 + i);
                    return (
                      <button
                        key={year}
                        className={`p-1 cursor-pointer text-left text-m transition-colors
                          ${selectedDraftYear.includes(year)
                            ? 'bg-blue-500 text-white'
                            : 'bg-gray-100 hover:bg-blue-500 hover:text-white'}
                        `}
                        onClick={() => {
                          if (selectedDraftYear.includes(year)) {
                            setSelectedDraftYear(selectedDraftYear.filter(t => t !== year));
                          } else {
                            setSelectedDraftYear([...selectedDraftYear, year]);
                          }
                        }}
                      >
                        {year}
                      </button>
                    );
                  })}
                  </div>
                </div>
              
          </div>
      </header>
    </main>
  );
}