import java.util.*

fun main(args: Array<String>) {
    /*dayOfWeek()*/
    println("${if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good Night, Kotlin"}!")

   /* val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = temperature > 50
    println(isHot)

    val message = "You are ${if (temperature > 50) "fried" else "safe"} fish"
    println(message)*/
    feedTheFish()
}

fun dayOfWeek() {
    println("What day is it today")
    val dayOfWeek: String? = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        1 -> "Sunday"
        2 -> "Monday"
        3 -> "Tuesday"
        4 -> "Wednesday"
        5 -> "Thursday"
        6 -> "Friday"
        7 -> "Saturday"
        else -> "Time has Stopped"
    }
    println("Today is $dayOfWeek")
}

fun feedTheFish(){
    val day = randomDay()
    val food = "pellets"
    println("Today is $day and this fish eat $food")

}

// randomDay() : String {}   String is a returnType
fun randomDay() : String {
    val week = listOf("Sunday","Monday","Tuesday","Wednesday","Thrusday","Friday","Saturday","Sunday")
    //7 is the boundary and excluded
    //returning week day with random index
    //Random().nextInt(7) is a builtin function
    return  week[Random().nextInt(7)]
}