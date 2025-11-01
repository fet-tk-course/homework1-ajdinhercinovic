package functions

import model.App


fun filterRating(lista : List<App>, rating : Double) : List<App>{
        val filteredList = mutableListOf<App>()
        for(app in lista){
            if(app.avgRating > rating){
                filteredList.add(app)
            }
        }
        return filteredList
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

fun searchByName(lista: List<App>, name : String){
    val found = lista.find { it.appName == name }
    if(found == null){
        println("Aplikacija sa imenom:$name nije pronađena!")
    } else {
        println("${found.appName} (${found.category}) Downloads:${found.downloads} Rating:${found.avgRating}/5, ${found.sizeMB}MB")
    }
}