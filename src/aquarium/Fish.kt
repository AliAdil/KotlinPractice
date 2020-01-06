package aquarium
// volume doesn't have val or var so kotlin will not create property from this argument for you
//with default parameters constructor overloading is not needed
class Fish (val friendly: Boolean = true , volumeNeeded : Int) {
    val size : Int
    // init block always run before any secondary constructor
    init{
        println("First init block")
    }
    // if you are using secondary constructor in kotlin it must contain
    //a call to primary constructor by using [[ this ]] keyword
    constructor() : this (true,9){
        println("Running secondary constructor")
    }
    init{
        if(friendly){
            size = volumeNeeded
        } else{
            size = volumeNeeded * 2
        }
    }
    init {
        println("constructed fish of size $volumeNeeded final size ${this.size}")
    }

    init {
        println("last init block")
    }
}

// Consider making helper method
fun makeDefaultFish() = Fish(true,50)

fun fishExample(){
    val fish = Fish(true,20)
    println("Is this fish friendly? ${fish.friendly}. it needs volume ${fish.size}")
}