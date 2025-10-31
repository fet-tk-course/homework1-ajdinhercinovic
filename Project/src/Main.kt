package main

import model.App
import functions.*

fun main() {
    val apps = listOf(
        App("Instagram", "Social", 150000000, 4.3, 86),
        App("Facebook", "Social", 120000000, 4.2, 125),
        App("Youtube", "Entertainment", 180000000, 4.7, 177),
        App("Olx.ba", "Shopping", 1700000, 4.0, 205),
        App("Spotify", "Music", 80000000, 4.8, 350),
        App("Weather&Radar", "Weather", 1500000, 4.7, 56),
        App("Glovo", "Food", 2000000, 4.6, 82),
        App("Klix.ba", "News", 1000000, 4.3, 86),
        App("Viber", "Messaging", 230000000, 4.2, 115),
        App("Fashion&Friends", "Shopping", 150000000, 4.3, 86)
    )
    val filtrirana = filterRatingLambda(apps, 4.5)
    for(app in filtrirana){
        println("${app.appName} Category:${app.category} Downloads:${app.downloads} Rating:${app.avgRating} size:${app.sizeMB}MB")
    }
}