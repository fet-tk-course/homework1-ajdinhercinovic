package main

import model.*
import functions.*

fun main() {
    val apps = listOf(
        App("Instagram", "Social", 150000000, 4.3, 86),
        App("Facebook", "Social", 120000000, 4.2, 125),
        App("Youtube", "Entertainment", 180000000, 4.7, 177),
        App("Olx.ba", "Shopping", 1700000, 4.0, 205),
        App("Spotify", "Music", 80000000, 4.8, 350),
        App("Weather&Radar", "Weather", 1500000, 4.7, 56),
        App("Glovo", "Food", 695000, 4.6, 82),
        App("Klix.ba", "News", 730000, 4.3, 86),
        App("Viber", "Messaging", 230000000, 4.2, 115),
        App("Fashion&Friends", "Shopping", 150000000, 4.3, 86)
    )

    val developers = listOf(
        Developer("Ajdin Hercinovic", "Bosnia and Herzegovina",
            listOf(App("Instagram", "Social", 150000000, 4.3, 86),
            App("Facebook", "Social", 120000000, 4.2, 125),
            App("Youtube", "Entertainment", 180000000, 4.7, 177))),
        Developer("Erling Haaland", country = "Norway",
            listOf(App("Spotify", "Music", 80000000, 4.8, 350),
                App("Weather&Radar", "Weather", 1500000, 4.7, 56))),
        Developer("Jason Stateham", "United Kingdom",
            listOf(App("Viber", "Messaging", 230000000, 4.2, 115),
                App("Fashion&Friends", "Shopping", 150000000, 4.3, 86)))
    )

    //3) Filtriranje
    /*val minRating = 4.5
    val filtrirana = filterRatingLambda(apps, minRating)
    write(filtrirana)*/
    //Provjera
    /*val status = filtrirana.all{ it.avgRating > minRating }
    if(status){
        println("Provjera uspjesna!")
    } else{
        println("Provjera neuspjesna!")
    }*/


    //4) Grupisanje po kategoriji
    /*val map = categoryCountLambda(apps)
    for((category, count) in map){
        println("$category -> $count")
    }*/
    //Provjera
    /*var status = false
    if(map["Social"] == apps.count{ it.category == "Social"}){
        status = true
    }
    if(status){
        println("Provjera uspjesna")
    } else{
        println("Provjera neuspjesna")
    }*/

    //5) Sortiranje po broju preuzimanja
    /*val sortirana = sortDwDescLambda(apps)
    write(sortirana) */

    //6) Prosječna veličina po kategoriji
    /*val katPoVel = avgSizePerCategory(apps)
    for((category, avgSize) in katPoVel) {
        println("$category -> $avgSize")
    }*/

    //7) Pretraga po imenu
    /*val target = "Facebook"
    val found = searchByName(apps, target)*/
    //Provjera
    /*if(found == target){
        println("Provjera uspjesna!")
    } else {
        println("Provjera neuspjesna!")
    }*/

    //Ispis
    //write(apps)

    //Pronalazak developera sa najvećim ukupnim brojem preuzimanja,
    /*val best = devMostDw(developers)
    println("${best.nameSurname}")*/

    //Izračunavanje prosječne ocjene svih njegovih aplikacija.
    println(devAvgAppRating(developers[1]))
}