package model

data class App(
	var appName : String,
    var category : String,
    var downloads : Int,
    var avgRating : Double,
    var sizeMB : Int
){
    init{
        require(appName.isNotBlank()) {"Naziv aplikacije ne smije biti prazan!"}
        require(category.isNotBlank()) {"Kategorija mora biti navedena!"}
        require(downloads >= 0) {"Broj preuzimanja moze biti 0 ili pozitivan"}
        require(avgRating in 0.0..5.0){"Prosječna ocjena mora biti u opsegu od 0.0 do 5.0"}
        require(sizeMB > 0){"Velicina aplikacije mora biti veca od 0MB"}
    }
    
}