package aquarium

fun main(args: Array<String>) {

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

class Plecostomus101 : FishAction101, FishColor {
    override fun eat() {
        println("eat algae")
    }

    override val color: String
        get() = "gold"

}

/*class GoldColor : FishColor {
    override val color = "gold"
}*/
//This will declare a class and make exactly one instance of it
//the instance will be called golf color
//there is no way to make another instance of this class
// Singleton Pattern implementation in kotlin
object GoldColor : FishColor {
    override val color = "gold"

}