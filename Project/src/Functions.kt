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