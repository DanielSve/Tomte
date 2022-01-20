package Inlämningsuppgift2


/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"

Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)

Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"

För att bli godkänd på uppgiften måste du använda rekursion.

 */



class Tomteland {

    val tomten: MutableList<String> = mutableListOf("Glader","Butter")
    val glader: MutableList<String> = mutableListOf("Tröger","Trötter","Blyger")
    val butter: MutableList<String> = mutableListOf("Rådjuret", "Nyckelpigan", "Haren", "Räven")
    val trötter: MutableList<String> = mutableListOf("Skumtomten")
    val skumtomten: MutableList<String> = mutableListOf("Dammråttan")
    val räven: MutableList<String> = mutableListOf("Gråsuggan", "Myran")
    val myran: MutableList<String> = mutableListOf("Bladlusen")

    val mapAll: Map<String,MutableList<String>>  = mapOf("Tomten" to tomten, "Glader" to glader, "Butter" to butter,
        "Trötter" to trötter, "Skumtomten" to skumtomten, "Räven" to räven, "Myran" to myran)

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {
        if(mapAll.containsKey(currentName)) {
            mapAll[currentName]!!.forEach { res.add(it) }
            mapAll[currentName]!!.forEach { getUnderlings(it, res) }
        }
        return res
    }
}

fun main() {
    var tomteland = Tomteland()
    var list: MutableList<String> = mutableListOf()
    println(tomteland.getUnderlings("Tomten",list))
}