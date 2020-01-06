package aquarium

import kotlin.math.PI

// We make constructor just like we are passing argument to a function

//by default classes are not subclassible we have to explicitly allow it

open class Aquarium(var length: Int = 100, var width: Int = 20, var height: Int = 10) {

    //properties and characteristics of aquarium class
    // currently properties are val which makes them
    //Immutable means that they can't be modified after they're created
    // So that all aquarium we create will have same size
/*
    val width : Int = 20
    val height :  Int = 40
    val length : Int = 100
    val volume: Int
        get() = width * height * length / 1000
*/

    //difference btw val and var is that variable declared as val cannot be changed
//once they have been assigned a value and variable declared with var can be
// changed
/*    var width:  Int = width
    var height: Int = height
    var length: Int = length*/
    // We can access this as property
    open var volume: Int
        get() = width * height * length / 1000
        //by convention name to the setter parameter is value but you can
        //choose different if you prefer
        //changing value in cubic meter
        set(value) {
            height = (value * 1000) / (width * length)
        }

    //We need to put it below volume because
    //properties get initialized in the order in which they are defined
    open var water = volume * 0.9

    constructor(numberOfFish: Int) : this() {
        val water: Int = numberOfFish * 2000 //cm3
        val tank: Double = water + water * 0.1
        height = (tank / (length * width)).toInt()

    }

    //third way
    /*  get(){
        return  width*height*length /1000
    }*/

    // 2nd way
    /* fun  volume() = width * height * length / 1000*/

    //One way
    /*fun volume() : Int {
        return width * height * length /1000
    }*/


    // Package visibility
    //In kotlin everything is public by default
    //public - Default. Everywhere. Class and public member
    //private - File  - inside class. subclasses can't see.
    //internal - Module - it work as a internal file level
    //protect - Inside class.(Like Private) but Subclasses CAN see.
}

class TowerTank() : Aquarium() {
    override var water = volume * 0.8

    override var volume: Int
        get() = (width * height * length / 1000 * PI).toInt()
        set(value) {
            height = (value * 1000) / (width * length)
        }
}

