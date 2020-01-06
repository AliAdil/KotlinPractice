package aquarium
// We make constructor just like we are passing argument to a function

class Aquarium (var length : Int, var width : Int, var  height: Int){
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
    var volume: Int get() = width * height * length / 1000
        //by convention name to the setter parameter is value but you can
        //choose different if you prefer
        //changing value in cubic meter
        set(value){height = (value *1000)/(width*length)}

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

