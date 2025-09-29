"use client";
import { useEffect, useMemo, useState } from "react";
import { MagnifyingGlassIcon } from "@heroicons/react/24/outline";
import { NbaTeams, Positions, Heights, CollegeTeams, Countries, Weights } from "./PlayerData";
import { FilterSection } from "./components/FilterSection"; 
import { fetchPlayers, type Player } from "../lib/api";

export default function Home() {
  const [focused, setFocused] = useState(false);
  const [NameSearching, setNameSearching] = useState("");
  const [selectedTeams, setSelectedTeams] = useState<string[]>([]);
  const [selectedCountry, setSelectedCountry] = useState<string[]>([]);
  const [selectedDraftYear, setSelectedDraftYear] = useState<string[]>([]);
  const [selectedJerseyNumber, setSelectedJerseyNumber] = useState<string[]>([]);
  const [selectedHeight, setSelectedHeight] = useState<string[]>([]);
  const [selectedWeight, setSelectedWeight] = useState<number[]>([]);
  const [selectedCollege, setSelectedCollege] = useState<string[]>([]);
  const [selectedPosition, setSelectedPosition] = useState<string[]>([]);

  const [players, setPlayers] = useState<Player[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);

  // Fonction générique pour gérer la sélection/désélection d'un item
  const handleSelection = <T extends string | number>(
    setter: React.Dispatch<React.SetStateAction<T[]>>,
    currentSelection: T[],
    item: T
  ) => {
    if (currentSelection.includes(item)) {
      setter(currentSelection.filter(i => i !== item));
    } else {
      setter([...currentSelection, item]);
    }
  };

  // draft_year go from 2008 to 2022
  const jerseyNumbers = useMemo(() => Array.from({ length: 100 }, (_, i) => String(i)), []);
  // jersey_number : 0 to 99
  const draftYears = useMemo(() => Array.from({ length: 2022 - 2008 + 1 }, (_, i) => String(2008 + i)), []);

  useEffect(() => {
    const load = async () => {
      setLoading(true);
      setError(null);
      try {
        const params: Record<string, string | number | (string | number)[] | undefined> = {
          teamName: selectedTeams,
          lastName: NameSearching || undefined,
          position: selectedPosition,
          college: selectedCollege,
          country: selectedCountry,
          jerseyNumber: selectedJerseyNumber.map(j => parseInt(j, 10)).filter(n => !Number.isNaN(n)),
          height: selectedHeight,
          weight: selectedWeight,
          draftYear: selectedDraftYear.map(y => parseInt(y, 10)).filter(n => !Number.isNaN(n)),
        };
        const data = await fetchPlayers(params);
        setPlayers(data);
      } catch (e: any) {
        setError(e?.message ?? "Erreur inconnue");
      } finally {
        setLoading(false);
      }
    };
    load();
  }, [
    NameSearching,
    selectedTeams,
    selectedPosition,
    selectedCollege,
    selectedCountry,
    selectedJerseyNumber,
    selectedHeight,
    selectedWeight,
    selectedDraftYear,
  ]);

  return (
    <section className="flex min-h-screen flex-col items-center justify-between p-5">
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
              if (NameSearching === "") { 
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
                placeholder="Search a player by name"
                onBlur={() => {
                  if (NameSearching === "") {
                    setFocused(false);
                  } else {
                    setFocused(true);
                  }
                }}
                value={NameSearching}
                onChange={e => setNameSearching(e.target.value)}
              />
            )}
          </div>
        </nav>

        {/* Filter */}
        <div className="mt-4 grid grid-cols-2 md:grid-cols-4 lg:grid-cols-5 gap-4">
          <FilterSection
            title="Teams"
            items={NbaTeams}
            selectedItems={selectedTeams}
            onItemClick={(item) => handleSelection(setSelectedTeams, selectedTeams, item as string)}
          />
          <FilterSection
            title="Positions"
            items={Positions}
            selectedItems={selectedPosition}
            onItemClick={(item) => handleSelection(setSelectedPosition, selectedPosition, item as string)}
          />
          <FilterSection
            title="Heights"
            items={Heights}
            selectedItems={selectedHeight}
            onItemClick={(item) => handleSelection(setSelectedHeight, selectedHeight, item as string)}
          />
          <FilterSection
            title="Weights"
            items={Weights}
            selectedItems={selectedWeight}
            onItemClick={(item) => handleSelection(setSelectedWeight, selectedWeight, item as number)}
          />
          <FilterSection
            title="Colleges"
            items={CollegeTeams}
            selectedItems={selectedCollege}
            onItemClick={(item) => handleSelection(setSelectedCollege, selectedCollege, item as string)}
          />
          <FilterSection
            title="Countries"
            items={Countries}
            selectedItems={selectedCountry}
            onItemClick={(item) => handleSelection(setSelectedCountry, selectedCountry, item as string)}
          />
          <FilterSection
            title="Filter by Jersey Numbers"
            items={jerseyNumbers}
            selectedItems={selectedJerseyNumber}
            onItemClick={(item) => handleSelection(setSelectedJerseyNumber, selectedJerseyNumber, item as string)}
          />

          <FilterSection
            title="Filter by Draft Years"
            items={draftYears}
            selectedItems={selectedDraftYear}
            onItemClick={(item) => handleSelection(setSelectedDraftYear, selectedDraftYear, item as string)}
          />
        </div> 
      </header>

      <main className="w-full flex-1 flex flex-col border-1 m-4 border-gray-300 rounded-lg p-4 shadow-md">
        {/* Player List */}
        {loading && <p>Chargement…</p>}
        {error && <p className="text-red-600">{error}</p>}
        {!loading && !error && (
          <ul className="divide-y divide-gray-200">
            {players.map((p) => (
              <li key={p.person_id} className="py-2 flex items-center justify-between">
                <div>
                  <div className="font-semibold">{p.player_first_name} {p.player_last_name}</div>
                  <div className="text-sm text-gray-600">
                    {p.team_name ?? "Free Agent"} • {p.position ?? "-"} • #{p.jersey_number ?? "-"}
                  </div>
                </div>
                <div className="text-sm text-gray-500">
                  {p.height ?? "?"} • {p.weight ?? "?"}lbs • {p.country ?? "?"}
                </div>
              </li>
            ))}
          </ul>
        )}
      </main>
    </section>
  );
}