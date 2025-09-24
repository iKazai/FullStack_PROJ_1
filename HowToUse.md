# NBA Players API - Guide d'utilisation

## 🏀 API des Joueurs NBA

Cette API permet de récupérer, filtrer et gérer des informations sur les joueurs NBA.

**Base URL:** `http://localhost:8080`

---

## 📋 Endpoints Disponibles

### 1. **Récupérer tous les joueurs**
```http
GET /players
```
**Exemple:**
```bash
curl http://localhost:8080/players
```

---

### 2. **Filtrer les joueurs** (Paramètres de requête)

Tous les filtres utilisent des paramètres de requête (`query parameters`) et supportent la recherche partielle (insensible à la casse).

**🔥 NOUVEAU : Filtrage Multiple !**  
Vous pouvez maintenant **combiner plusieurs filtres** dans une même requête pour des recherches plus précises !

#### **Filtres disponibles :**

| Paramètre | Type | Description | Exemple |
|-----------|------|-------------|---------|
| `teamName` | String | Nom de l'équipe | `Lakers` |
| `lastName` | String | Nom de famille | `James` |
| `firstName` | String | Prénom | `LeBron` |
| `nation` | String | Nationalité | `USA` |
| `position` | String | Position | `SF` |
| `college` | String | Université | `Duke` |
| `country` | String | Pays | `France` |
| `age` | Integer | Âge exact | `25` |
| `jerseyNumber` | Integer | Numéro de maillot | `23` |
| `teamCity` | String | Ville de l'équipe | `Los Angeles` |
| `height` | String | Taille exacte | `6-6` |
| `weight` | Double | Poids exact | `220.5` |
| `draftYear` | Integer | Année de draft | `2003` |

#### **Exemples de filtrage simple :**

#### **Filtrer par nom de l'équipe**
```http
GET /players?teamName={nom_equipe}
```
**Exemples:**
```bash
curl "http://localhost:8080/players?teamName=Lakers"
curl "http://localhost:8080/players?teamName=Warriors"
```

#### **Filtrer par nom de famille**
```http
GET /players?lastName={nom_famille}
```
**Exemples:**
```bash
curl "http://localhost:8080/players?lastName=James"
curl "http://localhost:8080/players?lastName=Curry"
curl "http://localhost:8080/players?lastName=bro"  # Trouve tous les noms contenant "bro"
```

#### **Filtrer par position**
```http
GET /players?position={position}
```
**Exemples:**
```bash
curl "http://localhost:8080/players?position=PG"  # Point Guard
curl "http://localhost:8080/players?position=SG"  # Shooting Guard
curl "http://localhost:8080/players?position=SF"  # Small Forward
curl "http://localhost:8080/players?position=PF"  # Power Forward
curl "http://localhost:8080/players?position=C"   # Center
```

---

### 🚀 **Filtrage Multiple - Nouvelles Fonctionnalités**

#### **Combiner plusieurs critères :**

**Exemple 1: Joueurs des Lakers en position SF**
```bash
curl "http://localhost:8080/players?teamName=Lakers&position=SF"
```

**Exemple 2: Joueurs français âgés de 25 ans**
```bash
curl "http://localhost:8080/players?nation=France&age=25"
```

**Exemple 3: Joueurs avec le numéro 23 dans les équipes de Los Angeles**
```bash
curl "http://localhost:8080/players?jerseyNumber=23&teamCity=Los Angeles"
```

**Exemple 4: Recherche très précise**
```bash
curl "http://localhost:8080/players?lastName=James&firstName=LeBron&teamName=Lakers&position=SF"
```

**Exemple 5: Filtrer par année de draft et position**
```bash
curl "http://localhost:8080/players?draftYear=2003&position=PG"
```

**Exemple 6: Joueurs d'une taille et d'un poids spécifiques**
```bash
curl "http://localhost:8080/players?height=6-6&weight=220.5"
```

#### **Filtres par critères numériques exacts :**

```bash
# Tous les joueurs de 28 ans
curl "http://localhost:8080/players?age=28"

# Tous les joueurs avec le numéro 24
curl "http://localhost:8080/players?jerseyNumber=24"

# Tous les joueurs draftés en 2020
curl "http://localhost:8080/players?draftYear=2020"

# Combinaison: joueurs de 25 ans avec le numéro 10
curl "http://localhost:8080/players?age=25&jerseyNumber=10"
```

#### **Exemples de filtres avancés par texte :**

#### **Exemples de filtres avancés par texte :**

**Filtrer par prénom:**
```bash
curl "http://localhost:8080/players?firstName=LeBron"
curl "http://localhost:8080/players?firstName=le"  # Trouve tous les prénoms contenant "le"
```

**Filtrer par nationalité:**
```bash
curl "http://localhost:8080/players?nation=USA"
curl "http://localhost:8080/players?nation=France"
curl "http://localhost:8080/players?nation=Canada"
```

**Filtrer par université/collège:**
```bash
curl "http://localhost:8080/players?college=Duke"
curl "http://localhost:8080/players?college=UCLA"
curl "http://localhost:8080/players?college=kentucky"
```

**Filtrer par pays:**
```bash
curl "http://localhost:8080/players?country=USA"
curl "http://localhost:8080/players?country=France"
curl "http://localhost:8080/players?country=Spain"
```

**Filtrer par ville d'équipe:**
```bash
curl "http://localhost:8080/players?teamCity=Los Angeles"
curl "http://localhost:8080/players?teamCity=Miami"
curl "http://localhost:8080/players?teamCity=Boston"
```

---

### 3. **Ajouter un nouveau joueur**
```http
POST /players
Content-Type: application/json
```

**Exemple:**
```bash
curl -X POST http://localhost:8080/players \
  -H "Content-Type: application/json" \
  -d '{
    "person_id": 12345,
    "player_last_name": "Doe",
    "player_first_name": "John",
    "nation": "USA",
    "age": 25,
    "team_id": 1,
    "pos": "SG",
    "jersey_number": 23,
    "team_slug": "lal",
    "height": "6-6",
    "weight": 220.5,
    "college": "Duke",
    "country": "USA",
    "team_city": "Los Angeles",
    "team_name": "Lakers"
  }'
```

---

### 4. **Mettre à jour un joueur**
```http
PUT /players
Content-Type: application/json
```

**Exemple:**
```bash
curl -X PUT http://localhost:8080/players \
  -H "Content-Type: application/json" \
  -d '{
    "person_id": 12345,
    "player_last_name": "Doe",
    "player_first_name": "John",
    "age": 26,
    "pos": "SF"
  }'
```

---

### 5. **Supprimer un joueur**
```http
DELETE /players/{nom_de_famille}
```

**Exemples:**
```bash
curl -X DELETE http://localhost:8080/players/Doe
curl -X DELETE http://localhost:8080/players/James
```

---

## 🔍 Fonctionnalités de Recherche

### **🆕 Filtrage Multiple Simultané**
Vous pouvez désormais combiner **autant de filtres que vous voulez** dans une seule requête :
- Tous les filtres sont appliqués avec une logique **ET** (AND)
- Exemple : `?teamName=Lakers&position=SF&age=25` trouve les joueurs qui sont **à la fois** dans les Lakers **ET** en position SF **ET** âgés de 25 ans

### **Recherche Partielle (Filtres Textuels)**
Tous les filtres textuels supportent la recherche partielle :
- `lastName=Jam` → trouve "James", "Jamal", etc.
- `firstName=Ste` → trouve "Stephen", "Steve", etc.
- `college=duke` → trouve "Duke University"
- `teamCity=Los` → trouve "Los Angeles"

### **Recherche Exacte (Filtres Numériques)**
Les filtres numériques nécessitent une correspondance exacte :
- `age=25` → trouve seulement les joueurs de exactement 25 ans
- `jerseyNumber=23` → trouve seulement les joueurs avec le numéro 23
- `draftYear=2003` → trouve seulement les joueurs draftés en 2003

### **Insensible à la Casse**
Les recherches textuelles ne sont pas sensibles à la casse :
- `teamName=lakers` = `teamName=LAKERS` = `teamName=Lakers`

---

## 📊 Exemples d'Utilisation Avancés

### **Dans un navigateur web:**
```
# Exemples simples
http://localhost:8080/players
http://localhost:8080/players?teamName=Lakers
http://localhost:8080/players?position=PG
http://localhost:8080/players?nation=France

# 🆕 Exemples avec filtrage multiple
http://localhost:8080/players?teamName=Lakers&position=SF
http://localhost:8080/players?nation=France&age=25
http://localhost:8080/players?lastName=James&teamName=Lakers
http://localhost:8080/players?position=PG&draftYear=2020&age=24
```

### **Avec JavaScript (fetch):**
```javascript
// Récupérer tous les joueurs
fetch('http://localhost:8080/players')
  .then(response => response.json())
  .then(players => console.log(players));

// Filtrer par équipe
fetch('http://localhost:8080/players?teamName=Lakers')
  .then(response => response.json())
  .then(players => console.log(players));

// 🆕 Filtrage multiple : Lakers + SF
fetch('http://localhost:8080/players?teamName=Lakers&position=SF')
  .then(response => response.json())
  .then(players => console.log(players));

// 🆕 Recherche complexe : Français de 25 ans
fetch('http://localhost:8080/players?nation=France&age=25')
  .then(response => response.json())
  .then(players => console.log(players));
```

### **Avec Python (requests):**
```python
import requests

# Récupérer tous les joueurs
response = requests.get('http://localhost:8080/players')
players = response.json()

# Filtrer par nom de famille
response = requests.get('http://localhost:8080/players?lastName=James')
james_players = response.json()

# 🆕 Filtrage multiple : Warriors + PG
params = {'teamName': 'Warriors', 'position': 'PG'}
response = requests.get('http://localhost:8080/players', params=params)
warriors_pg = response.json()

# 🆕 Recherche très précise
params = {
    'lastName': 'James',
    'firstName': 'LeBron', 
    'teamName': 'Lakers',
    'position': 'SF'
}
response = requests.get('http://localhost:8080/players', params=params)
lebron = response.json()
```

---

## ⚠️ Notes Importantes

1. **🆕 Filtrage Multiple** : L'API supporte maintenant **plusieurs filtres simultanément** !
   - Tous les filtres sont appliqués avec une logique **ET** (AND)
   - Exemple : `?teamName=Lakers&position=SF&age=25`

2. **Types de filtres** :
   - **Filtres textuels** (recherche partielle, insensible à la casse) : teamName, lastName, firstName, nation, position, college, country, teamCity
   - **Filtres numériques** (correspondance exacte) : age, jerseyNumber, draftYear
   - **Filtres spéciaux** (correspondance exacte) : height, weight

3. **Valeurs null** : Certains champs peuvent être null dans la base de données (college, country, etc.)

4. **🆕 Nouveaux paramètres disponibles** :
   - `age` : Âge exact du joueur
   - `jerseyNumber` : Numéro de maillot exact
   - `teamCity` : Ville de l'équipe (recherche partielle)
   - `height` : Taille exacte (format "6-6")
   - `weight` : Poids exact
   - `draftYear` : Année de draft exacte

5. **Performance** : Plus vous ajoutez de filtres, plus la recherche sera précise et rapide

---

## 🚀 Test Rapide

Pour tester si votre API fonctionne :

```bash
# Test simple
curl http://localhost:8080/players

# Test avec un filtre
curl "http://localhost:8080/players?position=PG"

# 🆕 Tests avec filtres multiples
curl "http://localhost:8080/players?teamName=Lakers&position=SF"
curl "http://localhost:8080/players?nation=France&age=25"
curl "http://localhost:8080/players?lastName=James&firstName=LeBron"
curl "http://localhost:8080/players?draftYear=2003&position=SF&teamName=Lakers"
```

## 🎯 Exemples de Recherches Utiles

```bash
# Tous les meneurs français
curl "http://localhost:8080/players?position=PG&nation=France"

# Tous les joueurs des Lakers draftés en 2020
curl "http://localhost:8080/players?teamName=Lakers&draftYear=2020"

# Tous les joueurs de Duke University en position PG
curl "http://localhost:8080/players?college=Duke&position=PG"

# Tous les joueurs de 28 ans avec le numéro 24
curl "http://localhost:8080/players?age=28&jerseyNumber=24"

# Recherche très spécifique
curl "http://localhost:8080/players?lastName=James&teamCity=Los Angeles&position=SF"
```

---

## 📝 Structure de Réponse

Chaque joueur retourne un objet JSON avec les propriétés suivantes :

```json
{
  "person_id": 123,
  "player_last_name": "James",
  "player_first_name": "LeBron",
  "nation": "USA",
  "age": 39,
  "team_id": 1,
  "pos": "SF",
  "jersey_number": 23,
  "team_slug": "lal",
  "height": "6-9",
  "weight": 250.0,
  "college": "St. Vincent-St. Mary HS (OH)",
  "country": "USA",
  "draft_year": 2003,
  "team_city": "Los Angeles",
  "team_name": "Lakers"
}
```