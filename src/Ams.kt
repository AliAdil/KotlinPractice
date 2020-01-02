import java.util.*
// Almost everything in kotlin is expression with value
fun main(args: Array<String>) {

    println("${if (args[0].toInt() < 12) "Good morning, Kotlin" else "Good Night, Kotlin"}!")

    feedTheFish()
  /*  var bubbles = 0
    while (bubbles < 50){
        bubbles++
        println(bubbles)
    }*/

    // Control flow function from standard libaray
    // repeat (function from standard libaray)
    /*repeat(2){
    println("A fish is swing")
    }*/
    /* println(canAddFish(10.0f, listOf(2,2,2),hasDecoration = false))
     println(canAddFishReal(10.0, listOf(2,2,2),hasDecorations = false))*
       var fortune: String

       for (i in 1..10) {
           fortune = getFortuneCookie(getBirthday())
           println("\n Your fortune is : $fortune")
           if (fortune.contains("Take it easy")) break;
       }*/
    /* val isUnit = println("This is an expression")
     println(isUnit)

     val temperature = 10
     val isHot = temperature > 50
     println(isHot)

     val message = "You are ${if (temperature > 50) "fried" else "safe"} fish"
     println(message)*/

    /*dayOfWeek()*/
  //  var fortune: String = ""
  /*  for (i in 1..10) {
        fortune =  getFortuneCookie(getBirthday())
        println("\n Your fortune is : $fortune")
        if (fortune.contains("Take it easy")) break;
    }*/

/*   repeat (10) {
        fortune =  getFortuneCookie(getBirthday())
        println("\n Your fortune is : $fortune")
        //if (fortune.contains("Take it easy")) break;
    }*/

  /*  while (!fortune.contains("Take it easy")) {
        fortune =  getFortuneCookie(getBirthday())
        println("\n Your fortune is : $fortune")
        //if (fortune.contains("Take it easy")) break;
    }*/

}
 fun makeNewAquarium() = println("Building a new aquarium.......")
//Any Can Hold any type of Object
fun aquariumStatusReport(aquarium : Any = makeNewAquarium()){

}
////////////////////////////////////////////////////////////////////////////////////
fun feedTheFish() {
    val day = randomDay()
    val dayNumber = randomNumber()
    val food = fishFood(day)
    if (shouldChangeWater(day)) {
        println("\n Change the water")
    }

    //call dirty processor
    dirtyProcessor()

    // val food = "pellets"
    //println("Today is $day and this fish eat $food and day number $dayNumber")
   /* swim(50)*/
    // function with argument
   // println("\n" + shouldChangeWater(day, 20, 20))
    // function with one argument and use two default arguments

 /*   println(
        "\n Today is $day and should we change water whats your answer: " + if (shouldChangeWater(day, 30, 5)) {
            "Yes"
        } else {
            "No"
        }
    )*/
    // function with with two argument but not in order it is using one default parameter
   // println("\n" + shouldChangeWater(day, dirty = 50))


}
var dirty = 20
// WaterFilter can b any function can take int and return int
val waterFilter:(Int)-> Int ={dirty -> dirty/2}
//Named function not a lambda
fun feedFish(dirty:Int) = dirty +10
// Higher order function take function as a argument
fun updateDirty(dirty: Int, operation: (Int)->Int):Int{
    return operation(dirty)
}
fun dirtyProcessor (){
    dirty = updateDirty(dirty,waterFilter)
    println(dirty)
    // Name function called by double colon ::  we are not try
    // to call function we are just passing reference
    dirty = updateDirty(dirty,::feedFish)
    println(dirty)
    //Last parameter called syntax
    // lambda is an argument to update dirty
    // but we are passing it as last parameter we dont have
    // to put it into parenthesis
    dirty = updateDirty(dirty,{dirty -> dirty + 50})
    println(dirty)


}

//////////////////////////////////////////////////////////////////////////////////////
// it is a good practice to use undefined parameters first and then default otherwise
//compiler will give an error or you  can call by name e.g. shouldChangeWater(day="tuesday")
fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = getDirtySensorReading()): Boolean {
    /*val isToHot = temperature > 30
     val isDirty = dirty >30
     val isSunday = day == "Sunday"*/
// with helper functions
    return when {
        isToHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> true
    }

    //Little simplified
    /*  return when {
          isToHot -> true
          isDirty -> true
          isSunday-> true
          else -> false
      }*/
    //Common Way
/*    return when {
        temperature > 30 -> true
        dirty > 30 -> true
        day == "Sunday" -> true
        else -> false
    }*/
}
///////////////////////////////////////////////////////////////////////////////////
//Return type can be inferred form the function
/*fun isToHot(temperature: Int) :Boolean = temperature >30*/
fun isToHot(temperature: Int) = temperature > 30
fun isDirty(dirty: Int) = dirty > 30
fun isSunday(day: String) = day == "Sunday"
fun getDirtySensorReading() = 20


///////////////////////////////////////////////////////////////
fun canAddFishReal(
    tankSize: Double,
    currentFish: List<Int>,
    fishSize: Int = 2,
    hasDecorations: Boolean = true
): Boolean {
    return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}

/////////////////////////////////////////////////////////////////
fun canAddFish(tankSize: Float, currentFish: List<Int>, fishSize: Int = 2, hasDecoration: Boolean = true): Boolean {
    val myArray = IntArray(currentFish.size) { i -> currentFish[i] * fishSize }
    val fishAfterCalculation = myArray.sum()
    val tankSizeAfterCalculation: Float
    if (hasDecoration) {
        tankSizeAfterCalculation = (80 * tankSize) / 100
    } else {
        tankSizeAfterCalculation = tankSize
    }

    return (fishAfterCalculation < tankSizeAfterCalculation)

}

////////////////////////////////////////////////////////////////////
fun swim(time: Int = 0, speed: String = "fast") {
    println("fishes are swimming $speed at the speed of $time km/h")
}

/////////////////////////////////////////////////////////////////////
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
//////////////////////////////////////////////////////////////////////////////

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

/////////////////////////////////////////////////////////////////////////////////
// randomDay() : String {}   String is a returnType
fun randomDay(): String {
    val week = listOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday", "Sunday")
    //7 is the boundary and excluded
    //returning week day with random index
    //Random().nextInt(7) is a builtin function
    return week[Random().nextInt(7)]
}
//////////////////////////////////////////////////////////////////////////////////

fun randomNumber(): Int {
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    return listOfNumber[Random().nextInt(3)]
}

///////////////////////////////////////////////////////////////////////////////////////
fun randomNumberDynamicBound(bound: Int): Int {
    val listOfNumber = listOf(1, 2, 3, 4, 5, 6, 7)
    return listOfNumber[Random().nextInt(bound)]
}

///////////////////////////////////////////////////////////////////////////////////
fun getFortuneCookie(birthday: Int): String {
    val listOfFortunes = listOf(
        "You will have a great day!", "Things will go well for you today.",
        "Things will go Awesome for you today.", "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.", "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )
    // val remainder = birthday.div(listOfFortunes.size)
    return when (birthday) {
        in 1..10 -> listOfFortunes[randomNumberDynamicBound(1)]
        11, 15 -> listOfFortunes[5]
        in 21..31 -> listOfFortunes[randomNumberDynamicBound(7)]
        else -> listOfFortunes[birthday.rem(listOfFortunes.size)]
    }
}

////////////////////////////////////////////////////////////////////////////////////
fun getBirthday(): Int {
    println("Enter your birthday:")
    // if value is null elvis operation ( :? ) return one
    /* val birthday = readLine()?.toIntOrNull() ?: 1*/
    return readLine()?.toIntOrNull() ?: 1
}
//////////////////////////////////////////////////////////////////////////////////
