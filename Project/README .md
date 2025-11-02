# README

## UVOD

Zadatak je bio implementacije Kotlin logike za buduću Android aplikaciju nalik **Google Play Store-u**.  
Svaka aplikacija u sistemu ima osnovne informacije — naziv, kategoriju, broj preuzimanja, prosječnu ocjenu i veličinu.  
Potrebno je analizirati i filtrirati aplikacije pomoću Kotlin skupova i funkcija višeg reda.  

---

## OPIS STRUKTURE PROJEKTA I SVRHA SVAKE FUNKCIJE

Projekat je logički organizovan kroz tri datoteke:

### 🟩 Main.kt — glavni program

- Na vrhu zaglavlja korištene su naredbe `package` i `import`.  
  `package` organizuje kod u logične cjeline (model, functions, main), dok `import` omogućava da iz jednog fajla koristim klase ili funkcije definisane u drugom.  
  Bez toga Kotlin ne bi znao gdje se nalaze ti elementi u projektu.  
  > *Koristio sam AI alat da me nauči i provede kroz korištenje ovih naredbi, jer se uključivanje fajlova u Kotlinu razlikuje od dosadašnjih programskih jezika koje sam učio. Nisam koristio AI alat za generisanje koda.*

- Unutar funkcije `main` kreirane su dvije liste koje su tražene u zadatku: **apps** i **developers**.  
  Ostatak `main` funkcije korišten je za pozive kreiranih funkcija traženih u zadatku.

---

### 🟦 Model.kt — definicija klasa

- Definisane su *data klase* `App` i `Developer` sa traženim atributima.  
  Kod klase `App` korišten je inicijalizacioni blok `init` — dio koda koji se automatski izvršava odmah nakon što se objekt kreira.  
  Upotrijebljen je za provjeru da li svi atributi klase imaju realne i dozvoljene vrijednosti.  
  > *Koristio sam AI alat da saznam šta se koristi za provjeru vrijednosti atributa i da mi objasni način rada i upotrebe. Nisam koristio AI alat za generisanje koda.*

---

### 🟨 Functions.kt — definicija funkcija

#### `filterRating`
- Vraća sve aplikacije čija je ocjena veća od određene vrijednosti.  
- Korištene funkcije: `.add()` za dodavanje elemenata u listu i `.toList()` da bi vratio nepovratnu listu.

#### `filterRatingLambda`
- Identično kao `filterRating`, ali uz upotrebu *lambda izraza* i funkcije `filter()`.  
  `filter()` prolazi kroz svaki element kolekcije, provjerava da li ispunjava uslov iz lambda izraza i vraća novu kolekciju samo sa elementima koji taj uslov ispunjavaju.

#### `categoryCount`
- Grupira aplikacije po kategorijama i vraća mapu oblika **kategorija → broj aplikacija** u toj kategoriji.  
- Implementirano bez `groupingBy()` ili `associate()`.  
- `map.containsKey()` provjerava da li mapa već sadrži tu kategoriju.  
  > *Koristio sam AI alat da saznam za ovu funkciju. Nisam koristio AI alat za generisanje koda funkcije.*

#### `categoryCountLambda`
- Identično, ali uz upotrebu `groupingBy()`.  
  `lista.groupingBy { it.category }.eachCount()` izračuna koliko elemenata ima u svakoj kategoriji.  
  Rezultat je mapa tipa `Map<String, Int>`.

#### `sortDwDesc`
- Sortira aplikacije po broju preuzimanja u **opadajućem redoslijedu** bez korištenja `sortedByDescending()`.

#### `sortDwDescLambda`
- Identično, ali uz korištenje `sortedByDescending()`, koja prolazi kroz elemente i sortira ih u opadajućem nizu.

#### `avgSizePerCategory`
- Računa prosječnu veličinu aplikacija unutar svake kategorije.  
  Rezultat: mapa **kategorija → prosječna veličina aplikacija**.  
  Implementirano pomoću `.fold()`.

  `fold()` se poziva na rezultat `groupingBy { it.category }`, koji predstavlja grupe elemenata po kategoriji.  
  `fold()` ima dva argumenta — prvi je akumulator koji pamti stanje, a drugi element kolekcije.  
  > *Koristio sam AI alat da bih saznao za tip varijable `pair`, koji mi je pomogao da izračunam srednju vrijednost i mapiram je pomoću funkcije `.mapValues`. Nisam koristio AI alat za generisanje koda.*

#### `searchByName`
- Pretražuje aplikacije po nazivu.  
  Ako aplikacija postoji — prikazuju se njeni podaci; ako ne, prikazuje se poruka da nije pronađena.  
  Korištena funkcija `find()`, koja vraća adresu elementa koji ispunjava dati uslov.

#### `devMostDw`
- Pronalazi **developera sa najvećim ukupnim brojem preuzimanja**.

#### `devAvgAppRating`
- Izračunava **prosječnu ocjenu svih aplikacija** određenog developera.

---

## PRIMJER FUNKCIONALNOSTI U ANDROID APLIKACIJI

- `filterByRating()` i `sortDwDesc()` bi mogle filtrirati aplikacije prikazane u **RecyclerView-u** prema ocjeni, odnosno prema broju preuzimanja.  
- `searchByName()` bi se mogao koristiti za brži pronalazak aplikacije unutar vlastite verzije Play Store-a.

