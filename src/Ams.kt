import java.util.*

fun main (args: Array<String>){
   // dayOfWeek()
    println("${if(args[0].toInt()<12) "Good morning, Kotlin" else "Good Night, Kotlin"}!")

    val isUnit = println("This is an expression")
    println(isUnit)

    val temperature = 10
    val isHot = temperature > 50
    println(isHot)

    val message = "You are ${if (temperature>50) "fried" else "safe"} fish"
    println(message)
}

fun dayOfWeek (){
    var dayOfWeek : String ? = null;
    println("What day is it today")
    dayOfWeek = when(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)){
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