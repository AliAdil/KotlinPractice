fun main(args: Array<String>) {
    whatShouldIDoToday2("Sad","5")
}

fun whatShouldIDoToday2(mood: String, weather: String = "Sunny", temperature: Int = 24) {

    val result = when (mood) {

            "Happy" -> when (weather) {
                "Sunny" -> "Go for walk"
                "Rainy" -> "Dont Forget to take your umbrella"
                "Snow" -> "Stay at home and burn fire"
                else ->"Rolo Kata"}

            "Sad" -> when (weather) {
                "Sunny" -> "Go For drive"
                "Rainy" -> "Pull out your hands from window and see droplets of Rain"
                "Snow" -> "Vodka Time :D "
                else ->"Rolo Kata"}

            else -> "Stat home and read"

        }

    println(result)

}fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24) {
    val result = when {
        mood == "happy" && weather == "Sunny" -> "Go for walk"
        else ->"Stay home and read"
    }



    println(result)

}