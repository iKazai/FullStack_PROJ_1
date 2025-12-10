from pathlib import Path
import json
import math


def sql_escape(s: str) -> str:
    return s.replace("'", "''")


def sql_value(v):
    if v is None:
        return 'NULL'
    if isinstance(v, bool):
        return '1' if v else '0'
    if isinstance(v, (int,)) and not isinstance(v, bool):
        return str(v)
    if isinstance(v, float):
        if math.isnan(v):
            return 'NULL'
        return str(v)
    # strings
    s = str(v).strip()
    if s == '':
        return 'NULL'
    return f"'{sql_escape(s)}'"


def parse_int(s):
    if s is None:
        return None
    try:
        return int(s)
    except Exception:
        try:
            return int(float(s))
        except Exception:
            return None


def parse_float(s):
    if s is None:
        return None
    try:
        return float(s)
    except Exception:
        # sometimes weights are strings like '243'
        try:
            return float(str(s).strip())
        except Exception:
            return None


def player_to_update(player: dict) -> str:
    pid = player.get('PERSON_ID')
    if pid is None:
        return ''

    cols = {
        'player_last_name': player.get('PLAYER_LAST_NAME'),
        'player_first_name': player.get('PLAYER_FIRST_NAME'),
        'team_id': player.get('TEAM_ID'),
        'position': player.get('POSITION'),
        'jersey_number': parse_int(player.get('JERSEY_NUMBER')),
        'team_name': player.get('TEAM_NAME'),
        'team_slug': player.get('TEAM_SLUG'),
        'height': player.get('HEIGHT'),
        'weight': parse_float(player.get('WEIGHT')),
        'college': player.get('COLLEGE'),
        'country': player.get('COUNTRY'),
        'draft_year': player.get('DRAFT_YEAR'),
        'is_defunct': player.get('IS_DEFUNCT') if 'IS_DEFUNCT' in player else player.get('ROSTER_STATUS'),
        'team_city': player.get('TEAM_CITY'),
        'draft_round': player.get('DRAFT_ROUND'),
        'draft_number': player.get('DRAFT_NUMBER'),
        'from_year': parse_int(player.get('FROM_YEAR')),
        'to_year': parse_int(player.get('TO_YEAR')),
        'pts': parse_float(player.get('PTS')),
        'reb': parse_float(player.get('REB')),
        'ast': parse_float(player.get('AST')),
    }

    set_parts = []
    for col, val in cols.items():
        set_parts.append(f"{col} = {sql_value(val)}")

    set_clause = ', '.join(set_parts)
    comment_name = sql_escape(f"{player.get('PLAYER_FIRST_NAME','')} {player.get('PLAYER_LAST_NAME','')}")
    stmt = f"-- PERSON_ID={pid} {comment_name}\nUPDATE players_table SET {set_clause} WHERE person_id = {sql_value(pid)};\n"
    return stmt


def main():
    base = Path(__file__).resolve().parent
    in_path = base / 'players.json'
    out_path = base / 'players_updates.sql'

    if not in_path.exists():
        print(f"Input file not found: {in_path}")
        return

    data = json.loads(in_path.read_text(encoding='utf-8'))
    players = data.get('players') or []

    with out_path.open('w', encoding='utf-8') as out:
        out.write('-- Generated UPDATE statements from players.json\n')
        out.write('BEGIN TRANSACTION;\n')
        for p in players:
            stmt = player_to_update(p)
            if stmt:
                out.write(stmt)
        out.write('COMMIT;\n')

    print(f"Wrote {out_path} with {len(players)} UPDATE statements (one per player).")


if __name__ == '__main__':
    main()
