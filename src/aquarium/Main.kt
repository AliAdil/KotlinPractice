package aquarium
fun main(args: Array<String>){
    buildAquarium()
    makeSpices()
    makeFish()






/* val spice = Spice("cayenne",spiciness = "spicy")*/
/*   val spiceList = spice.filter { it.heat < 5 }*/
    /* println("\n second list"+spice)*/


//    println("Volume: ${myAquarium.volume} liters")

  /*  val simpleSpice = SimpleSpice()
    println("Name :${simpleSpice.name} & Temperature: ${simpleSpice.heat}")
*/
  /*  val smallAquarium = Aquarium(length = 20,width = 15,height = 30)
    println("Small Aquarium: ${smallAquarium.volume} liters")

    val myAquarium2 = Aquarium(numberOfFish = 9)
    println("Small Aquarium 2: ${myAquarium2.volume} liters with "+
           "length ${myAquarium2.length} " +
            "width ${myAquarium2.width} "+
             "height ${myAquarium2.height}")*/
}

// it will only available inside the file which is containing declaration
/*private fun buildAquarium() = Aquarium()*/

// it will be available anywhere in the same module
// A module is a set of kotlin files compiled together
// when it is internal, we can use it from anywhere inside our project
// but if we compile the library it wouldn't be exported as function
// fun buildAquarium() = Aquarium(100,20,40)

 fun buildAquarium() {
    // it is like new in other languages
    //it creates the new instance of aquarium by calling its constructor
    //constructor construct object instances from class descriptions
 //   val myAquarium = Aquarium()
    //Can access properties directly
    // Under the hood kotlin actually made a getter for all three properties
    //even so we didn't write any code
 /*   print("Length: ${myAquarium.length} " +
            "Width: ${myAquarium.width} "+
            "Height: ${myAquarium.height} ")
    myAquarium.height = 80
    println("Height ${myAquarium.height} cm")
    println("Volume ${myAquarium.volume} liters")*/

  /*val smallAquarium = Aquarium(length = 20,width = 15,height = 30)
  println("Small Aquarium: ${smallAquarium.volume} liters")*/
  var numberOfFish = 2
  val myAquarium2 = Aquarium(numberOfFish)
  println("Small Aquarium number of fish:${numberOfFish} and water is ${myAquarium2.volume} liters with "+
          "length ${myAquarium2.length}cm " +
          "width ${myAquarium2.width}cm "+
          "height ${myAquarium2.height}cm")


 }

fun makeSpices(){
    val spice =  listOf(
        Spice("Red Chili", "hot")
        , Spice("black pepper", "moderate"),
        Spice("green curry", "mild"),
        Spice("hot pepper", "extremely spicy"),
        Spice("cayenne", "spicy")
    )
    makeSalt()
}

fun feedFish(fish : FishAction){
    //make some food then
    fish.eat()

}
fun makeFish(){
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color} \n Plecostomus : ${pleco.color}")
    shark.eat()
    pleco.eat()
}
