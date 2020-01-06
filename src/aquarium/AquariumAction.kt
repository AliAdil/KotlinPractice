package aquarium

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

abstract class AquariumFish1 : FishAction1 {
    abstract  val color : String
    override fun eat() = println("yum")
}