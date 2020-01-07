package aquarium
//If you have lots of methods use interfaces
//and one or two default implementations
interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim(){
        println("swim")
    }
}

interface FishAction1{
    fun eat()
}

// Use abstract class anytime you cannot complete classes
//composition is when you use an instance of another class
//as opposed to inheriting from it
abstract class AquariumFish1 :FishAction1 {
    abstract  val color : String
    override fun eat() = println("yum")
}