import java.util.*

fun main(args: Array<String>) {

    println("${if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good Night, Kotlin"}!")
    feedTheFish()
    var fortune: String

    for (i in 1..10) {
        fortune = getFortuneCookie(getBirthday())
        println("\n Your fortune is : $fortune")
        if (fortune.contains("Take it easy")) break;
    }
    /* val isUnit = println("This is an expression")
     println(isUnit)

     val temperature = 10
     val isHot = temperature > 50
     println(isHot)

     val message = "You are ${if (temperature > 50) "fried" else "safe"} fish"
     println(message)*/

    /*dayOfWeek()*/

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

fun feedTheFish() {
    val day = randomDay()
    val dayNumber = randomNumber()
    val food = fishFood(day)
    // val food = "pellets"
    println("Today is $day and this fish eat $food and day number $dayNumber")

}

// A parameter (day) is specified by its name a colon :  followed by its type and then we have
//colon and the return type
fun fishFood(day: String): String {
    var food = "fasting"
    return when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "graules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting"
    }

    /*   when (day) {
           "Monday" -> food = "flakes"
           "Tuesday" -> food = "pellets"
           "Wednesday" -> food = "redworms"
           "Thursday" -> food = "graules"
           "Friday" -> food = "mosquitoes"
           "Saturday" -> food = "lettuce"
           "Sunday" -> food = "plankton"
       }

       return food*/
}

// randomDay() : String {}   String is a returnType
fun randomDay(): String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday")
    //7 is the boundary and excluded
    //returning week day with random index
    //Random().nextInt(7) is a builtin function
    return week[Random().nextInt(7)]
}


fun randomNumber(): Int {
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    return listOfNumber[Random().nextInt(3)]
}
fun randomNumberDynamicBound(bound : Int ): Int {
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    return listOfNumber[Random().nextInt(bound)]
}

fun getFortuneCookie(birthday: Int): String {
    val listOfFortunes = listOf(
        "You will have a great day!", "Things will go well for you today.",
        "Things will go Awesome for you today.", "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    // val remainder = birthday.div(listOfFortunes.size)
    return when(birthday){
        in 1..10 -> listOfFortunes [randomNumberDynamicBound(1)]
        11,15 -> listOfFortunes [4]
        in 21 .. 31 -> listOfFortunes[randomNumberDynamicBound(7)]
        else -> listOfFortunes[birthday.rem(listOfFortunes.size)]
    }
}

fun getBirthday(): Int {
    println("Enter your birthday:")
    // if value is null elvis operation ( :? ) return one
    /* val birthday = readLine()?.toIntOrNull() ?: 1*/
    return readLine()?.toIntOrNull() ?: 1
}