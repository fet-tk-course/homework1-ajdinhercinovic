package main

import model.App
import functions.*

fun main() {
    val apps = listOf(
        App("Instagram", "Social", 1, 4.3, 86),
        App("Facebook", "Social", 2, 4.2, 125),
        App("Youtube", "Entertainment", 3, 4.7, 177),
        App("Olx.ba", "Shopping", 4, 4.0, 205),
        App("Spotify", "Music", 5, 4.8, 350),
        App("Weather&Radar", "Weather", 6, 4.7, 56),
        App("Glovo", "Food", 7, 4.6, 82),
        App("Klix.ba", "News", 8, 4.3, 86),
        App("Viber", "Messaging", 9, 4.2, 115),
        App("Fashion&Friends", "Shopping", 10, 4.3, 86)
    )
    /*val filtrirana = filterRatingLambda(apps, 4.5)
    for(app in filtrirana){
        println("${app.appName} Category:${app.category} Downloads:${app.downloads} Rating:${app.avgRating} size:${app.sizeMB}MB")
    }*/
    /*val map = categoryCountLambda(apps)
    for((category, count) in map){
        println("$category -> $count")
    }*/
    /*val sortirana = sortDwDescLambda(apps)
    for(app in sortirana){
        println("${app.appName} Category:${app.category} Downloads:${app.downloads} Rating:${app.avgRating} size:${app.sizeMB}MB")
    }*/
    /*val katPoVel = avgSizePerCategory(apps)
    for((category, avgSize) in katPoVel) {
        println("$category -> $avgSize")
    }*/
    searchByName(apps, "Facebook")
}