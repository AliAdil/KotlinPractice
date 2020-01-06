package aquarium

class Spice(var name: String, var spiciness: String = "mild") {

    val heat: Int
        get() = when (spiciness) {
            "mild" -> 1
            "hot" -> 2
            "moderate" -> 3
            "spicy" -> 5
            "very spicy" -> 7
            "extremely spicy" -> 10
            else -> 0
        }
    init {
        println("\n\nSpice name: " +name + "\nSpice Type: "+spiciness+ "\n Spice heat: "+ heat )
    }

}

// Consider making helper method
fun makeSalt() = Spice("salt" )