import kotlin.math.ln

fun main(args: Array<String>) {
    //println("What is your mood\n")
    //val mood:String = readLine().toString()
    //whatShouldIDoToday(mood, "Sunny")
    /*println(whatShouldIDoToday(readLine()!!))*/
    // eagerExample()
    var dirty = 20
    // WaterFilter can b any function can take int and return int
    val waterFilter:(Int)-> Int ={dirty -> dirty/2}
    fun feedFish(dirty:Int) = dirty +10

   //Higher Order function
    //is just any function that takes a function as the argument
   //operation function of int to int
    //Kotlin prefers function arguments to be the last parameter
    fun updateDirty(dirty: Int, operation: (Int)->Int):Int{
        return operation(dirty)
    }



    practiceTime()
}

fun practiceTime() {

    val numbers = listOf("one", "two", "three", "four")

    val filteredIdx = numbers.filterIndexed { index, s -> (index != 3 && index != 0) && (s.length < 4) }
    println(filteredIdx)

    val filterNot = numbers.filterNot { it.length <= 3 }
    println(filterNot)

/* There are also functions that narrow the element type by filtering elements of a given type:
    filterIsInstance() returns collection elements of a given
     type. Being called on a List<Any>, filterIsInstance<T>()
     returns a List<T>, thus allowing you to call functions of
     the T type on its items.
*/
    val numbersS = listOf(null, 1, "two", 3.0, "four")
    print("All Elements in upper case :")
    numbersS.filterIsInstance<String>().forEach {
        println(it.toUpperCase())
    }

/*filterNotNull() returns all non-null elements. Being called
on a List<T?>, filterNotNull() returns a List<T: Any>,
thus allowing you to treat the elements as non-null objects.
*/
    val numbersWithNotNull = listOf(null,"One","Two",null)
    val notNullValuefilter = numbersWithNotNull.filterNotNull().forEach{
        println("\n "+it+" "+it.length)
    }

/*Partitioning

Another filtering function – partition() – filters a collection
by a predicate and keeps the elements that don't match it in a
separate list. So, you have a Pair of Lists as a return value:
the first list containing elements that match the predicate and
 the second one containing everything else from the original
 collection.*/
    val numberPartitioning = listOf("one","two","three","four")
    val(match,rest) = numberPartitioning.partition { it.length>3 &&  (it.contains('t') ) && it.endsWith('e') }
    println("match "+match)
    println("rest"+rest)

    val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "red pepper")
    val startAndEnd = spices.filter { it.startsWith('c') }.filter { it.endsWith('e') }
    println(startAndEnd)

    val anotherWayStartEnd = spices.filter { it.startsWith('c') && it.endsWith('e') }
    println(anotherWayStartEnd)

    val take3StartWithC = spices.take(3).filter { it.startsWith('c') }
    println(take3StartWithC)

    val sortedList = spices.filter { it.contains("curry") }.sortedBy { it.length }
    println(sortedList)


}





//function using filter
// by default eager is implemented on list
fun eagerExample() {
    val decoration = listOf("rocks", "pagoda", "plastic plant", "aligator", "flowerpot")
    //eager will hold NEW list containing the decoration that start with p
    val eager = decoration.filter { it[0] == 'p' }
    /* println(eager)*/

    //For lazy calls we can use sequence
    //A sequence is a collection that can only look at one
    // item at a time starting at the beginning and to end
    //Conveniently, this is exactly the API filter needs
    //when returning filter result as
    // sequence filter variable will not hold new list
    // it will hold a sequence of all of the list elements
    //and knowledge of the filter to apply to  its elements.
    val filtered = decoration.asSequence().filter { it[0] == 'p' }
    /*   print(filtered)
       print("\n"+filtered.toList())*/
    //apply map Lazily
    val lazyMap = decoration.asSequence().map {
        println("map : $it")
        it
    }
    println("\n" + lazyMap)
    println("first: ${lazyMap.first()}")
    println("all: ${lazyMap.toList()}")
}
fun whatShouldIDoToday2(mood: String, weather: String = "Sunny", temperature: Int = 24) {

    val result = when (mood) {

        "Happy" -> when (weather) {
            "Sunny" -> "Go for walk"
            "Rainy" -> "Dont Forget to take your umbrella"
            "Snow" -> "Stay at home and burn fire"
            else -> "Rolo Kata"
        }

        "Sad" -> when (weather) {
            "Sunny" -> "Go For drive"
            "Rainy" -> "Pull out your hands from window and see droplets of Rain"
            "Snow" -> "Vodka Time :D "
            else -> "Rolo Kata"
        }

        else -> "Stat home and read"

    }

    println(result)

}
fun whatShouldIDoToday(mood: String, weather: String = "Sunny", temperature: Int = 24) {
    val result = when {
        isHappy(mood) && isRainy(weather) -> "Go for walk"
        isSad(mood) && isSunny(weather) && temperature == 24 -> "Go for sun bath"
        isAngry(mood) && isSnow(weather) && temperature == 5 -> "stay in bed and burn fire for warmth"
        temperatureCheck(temperature) -> "go swimming"
        else -> "Stay home and read"
        /* mood == "happy" && weather == "Sunny" -> "Go for walk"
        mood == "sad" && weather == "rainy" && temperature == 0 -> "stay in bed"
        temperature > 35 -> "go swimming"*/
    }
    println(result)
}
fun isHappy(mood: String) = mood == "Happy"
fun isSad(mood: String) = mood == "Sad"
fun isAngry(mood: String) = mood == "Angry"
fun isRainy(weather: String) = weather == "Rainy"
fun isSunny(weather: String) = weather == "Sunny"
fun isSnow(weather: String) = weather == "Snow"
fun temperatureCheck(temperature: Int) = temperature > 30
/*Challenge
fun main(args: Array<String>) {
    println(whatShouldIDoToday("happy", "sunny"))
    println(whatShouldIDoToday("sad"))
    print("How do you feel?")
    println(whatShouldIDoToday(readLine()!!))
}

fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
    mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
    return when {
        isVeryHot(temperature) -> "go swimming"
        isSadRainyCold(mood, weather, temperature) -> "stay in bed"
        isHappySunny(mood, weather) -> "go for a walk"
        else -> "Stay home and read."
    }
}
Loops
Using repeat:

fun main(args: Array<String>) {
    var fortune: String = ""
    repeat (10) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
        if (fortune.contains("Take it easy")) break;
    }
}

Using a while loop:

fun main(args: Array<String>) {
    var fortune: String = ""
    while (!fortune.contains("Take it easy")) {
        fortune = getFortune(getBirthday())
        println("\nYour fortune is: $fortune")
    }
}*/
//Filter are standard library function on list in kotlin
// filters are both eager and lazy

/*val decoration = listOf("rocks","plants","plastic","aligator","flowerpot")
println(decoration.filter { true })*/
/*val decoration = listOf("rocks","plants","plastic","aligator","flowerpot")
println(decoration.filter { it[0] == 'p' })*/
/*val decoration = listOf("rocks","plants","plastic","aligator","flowerpot")
println(decoration.filter { it[0] == 'p' || it[0] =='a' })*/
//Kotlin Lambdas
/*{ println("Hello")}()
Hello

val swim = { println("swim \n")}
swim()
swim
*/
/*  -> is called function arrow  */
/*
val waterFilter = {dirty:Int -> dirty/2}
println(waterFilter)*/

/*
val dirty = 20
val waterFilter = {dirty:Int -> dirty/2}
waterFilter(dirty)*/
