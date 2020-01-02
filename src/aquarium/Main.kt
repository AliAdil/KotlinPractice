package aquarium
fun main(args: Array<String>){
   val myAquarium =  buildAquarium()
    println("Volume: ${myAquarium.volume}")


}

// it will only available inside the file which is containing declaration
/*private fun buildAquarium() = Aquarium()*/

// it will be available anywhere in the same module
// A module is a set of kotlin files compiled together
// when it is internal, we can use it from anywhere inside our project
// but if we compile the library it wouldn't be exported as function
internal fun buildAquarium() = Aquarium()

/* fun buildAquarium() {
    // it is like new in other languages
    //it creates the new instance of aquarium by calling its constructor
    //constructor construct object instances from class descriptions
    val myAquarium = Aquarium()
    //Can access properties directly
    // Under the hood kotlin actually made a getter for all three properties
    //even so we didn't write any code
    print("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} "+
            "Height: ${myAquarium.height} ")
    myAquarium.height = 80
    println("Height ${myAquarium.height} cm")
    println("Volume ${myAquarium.volume} liters")

}*/
