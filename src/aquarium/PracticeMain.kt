package aquarium
// In kotlin there is only one difference in abstract classes and interface
//Abstract classes can have constructors and interfaces cannot
//Both can contain implementations of methods
//On interface we call them default implementation
// Big difference is only when an how use them
//Use interface if you have a lot of methods
fun main(args: Array<String>) {
/*   val myPlea = Plecostomus()

    //calling color form interface delegation
    println(myPlea.color)*/

    delegate()
}

fun delegate() {
    val pleco = Plecostomus101()
    println("Fish has color ${pleco.color}")
    pleco.eat()
}

interface FishAction101 {
    fun eat()
}

interface FishColor {
    val color: String
}


// All is handled by interface delegation
class Plecostomus101(fishColor: FishColor = GoldColor):
      FishAction101 by PrintingFishAction ("a lot of algae"),
      FishColor by fishColor

/*class Plecostomus101 : FishAction101, FishColor by GoldColor  {
    override fun eat() {
        println("eat algae")
    }


    //member variable
   *//* override val color: String
        get() = "gold"*//*

}*/

/*class GoldColor : FishColor {
    override val color = "gold"
}*/
//This will declare a class and make exactly one instance of it
//the instance will be called gold color
//there is no way to make another instance of this class
// Singleton Pattern implementation in kotlin

// Interface delegation
object GoldColor : FishColor {
    override val color = "gold"
}

object RedColor : FishColor {
    override val color = "red"
}

class PrintingFishAction(val food: String) :FishAction101{
    override fun eat() {
        println(food)
    }

}