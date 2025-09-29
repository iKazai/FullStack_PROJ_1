export type Player = {
  person_id: number;
  player_last_name: string;
  player_first_name: string;
  team_id: number | null;
  position: string | null;
  jersey_number: number | null;
  team_name: string | null;
  team_slug: string | null;
  height: string | null;
  weight: number | null;
  college: string | null;
  country: string | null;
  draft_year: number | null;
  is_defunct: number | null;
  team_city: string | null;
  draft_round: number | null;
  draft_number: number | null;
  from_year: number | null;
  to_year: number | null;
  pts: number | null;
  reb: number | null;
  ast: number | null;
};

const API_BASE = process.env.NEXT_PUBLIC_API_BASE || "http://localhost:8080";

export async function fetchPlayers(
  params: Record<string, string | number | (string | number)[] | undefined> = {}
): Promise<Player[]> {
  const usp = new URLSearchParams();
  for (const [k, v] of Object.entries(params)) {
    if (v === undefined || v === null) continue;
    if (Array.isArray(v)) {
      v.filter(x => x !== undefined && x !== null && x !== "").forEach(x => usp.append(k, String(x)));
    } else {
      if (v !== "") usp.append(k, String(v));
    }
  }
  const url = `${API_BASE}/players${usp.toString() ? `?${usp.toString()}` : ""}`;
  const res = await fetch(url, { next: { revalidate: 0 } });
  if (!res.ok) {
    throw new Error(`Failed to fetch players: ${res.status}`);
  }
  return res.json();
}
