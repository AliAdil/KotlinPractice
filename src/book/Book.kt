package book

open class Book(val title :String = "Default" , val author :String = "Default") {

 /*   private var currentPage: Int = 0*/
    private var currentPage: Int = 1

    open fun readPage(){
       /* currentPage.plus(1)*/
        currentPage++
    }
}

class eBook(title: String, author: String,var format:String ="text"): Book(){
    private  var wordCount: Int = 0
    override fun readPage(){
        wordCount.plus(250)
    }

}