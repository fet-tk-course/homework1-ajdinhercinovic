package functions

import model.*


fun filterRating(lista : List<App>, rating : Double) : List<App>{
        val filteredList = mutableListOf<App>()
        for(app in lista){
            if(app.avgRating > rating){
                filteredList.add(app)
            }
        }
        return filteredList.toList()
    }

fun filterRatingLambda(lista : List<App>, rating : Double) : List<App> {
    return lista.filter { it.avgRating > rating }
}

fun categoryCount(apps : List<App>) : Map<String, Int> {
    val map = mutableMapOf<String, Int>()
    for(app in apps){
        if(map.containsKey(app.category)){
            map[app.category] = map[app.category]!!.plus(1)
        } else{
            map[app.category] = 1
        }
    }
    return map.toMap()
}

fun categoryCountLambda(lista : List<App>) : Map<String, Int> {
    val map = lista.groupingBy { it.category }.eachCount()
    return map
}

fun sortDwDesc(lista : List<App>) : List<App> {
    val sortirana = lista.toMutableList()
        for(i in 0 until sortirana.size){
            var maxIndex = i
            for(j in i + 1 until sortirana.size){
                if(sortirana[j].downloads > sortirana[maxIndex].downloads){
                    maxIndex = j
                }
            }
            if(maxIndex != i){
                val temp = sortirana[i]
                sortirana[i] = sortirana[maxIndex]
                sortirana[maxIndex] = temp
            }
        }
    return sortirana.toList()
}

fun sortDwDescLambda(lista : List<App>) : List<App> {
    return lista.sortedByDescending { it.downloads }
}

fun avgSizePerCategory(lista: List<App>) : Map<String, Double> {
    val map = lista.groupingBy { it.category }.fold(0 to 0) { avg, app ->
        val (total, count) = avg
        (total + app.sizeMB) to (count + 1)
    }.mapValues { (_,pair) -> pair.first.toDouble() / pair.second }
    return map
}

fun searchByName(lista: List<App>, name : String) : String?{
    val found = lista.find { it.appName == name }
    if(found == null){
        println("Aplikacija sa imenom:$name nije pronađena!")
    } else {
        println("${found.appName} (${found.category}) Downloads:${found.downloads} Rating:${found.avgRating}/5, ${found.sizeMB}MB")
    }
    return found?.appName
}

fun write(lista: List<App>){
    lista.toMutableList()
    for(app in lista){
        var downloadShort = app.downloads.toString()
        if((app.downloads / 1000000) >= 1){
            downloadShort = ("${app.downloads / 1000000}M+")
        } else if((app.downloads / 1000) > 1){
            downloadShort = ("${app.downloads / 100}K+")
        }
        println("App: ${app.appName} | Category:${app.category} | Rating:${app.avgRating} | Downloads:$downloadShort | size:${app.sizeMB}MB")
    }
}

fun devMostDw(developers : List<Developer>) : Developer{
    var max = developers.first()
    var countMax = developers.first().developed.sumOf { it.downloads }
    for(developer in developers){
        val count = developer.developed.sumOf { it.downloads }
        if(count > countMax){
            countMax = count
            max = developer
        }
    }
    return max
}

fun devAvgAppRating(developer : Developer) : Double{
    var sum = 0.0
    var count = 0
    for(app in developer.developed){
        sum += app.avgRating
        count++
    }
    return sum / count
}