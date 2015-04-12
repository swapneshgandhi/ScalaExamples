import scala.collection.mutable.ListBuffer
import scala.io._

object wc5 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  val dataQ = List(1, 2, 3)                       //> dataQ  : List[Int] = List(1, 2, 3)

  val dataQ2 = List[Number](1, 2, 3, 4, 1000)     //> dataQ2  : List[Number] = List(1, 2, 3, 4, 1000)

  val dataQ3 = List.range(1, 10)                  //> dataQ3  : List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

  val dataQ4 = List.fill(3)("hello")              //> dataQ4  : List[String] = List(hello, hello, hello)

  val dataQ5 = List.tabulate(5)(n => n * n)       //> dataQ5  : List[Int] = List(0, 1, 4, 9, 16)

  val mutableList = collection.mutable.ListBuffer(1, 2, 3)
                                                  //> mutableList  : scala.collection.mutable.ListBuffer[Int] = ListBuffer(1, 2, 3
                                                  //| )

  mutableList += 4                                //> res0: wc5.mutableList.type = ListBuffer(1, 2, 3, 4)
  mutableList -= 1                                //> res1: wc5.mutableList.type = ListBuffer(2, 3, 4)

  var cityList = new ListBuffer[String]           //> cityList  : scala.collection.mutable.ListBuffer[String] = ListBuffer()
  cityList += "Fremont"                           //> res2: scala.collection.mutable.ListBuffer[String] = ListBuffer(Fremont)
  cityList += "SanJose"                           //> res3: scala.collection.mutable.ListBuffer[String] = ListBuffer(Fremont, SanJ
                                                  //| ose)

  val finalList = cityList.toList                 //> finalList  : List[String] = List(Fremont, SanJose)

  //merging lists

  val newList = List(2, 3, 4)                     //> newList  : List[Int] = List(2, 3, 4)

  val mergedList = newList ++ dataQ2              //> mergedList  : List[Any] = List(2, 3, 4, 1, 2, 3, 4, 1000)

  //better
  val mergedList2 = newList ::: dataQ2            //> mergedList2  : List[Any] = List(2, 3, 4, 1, 2, 3, 4, 1000)

  //lazy colection
  val lazyList = 1 #:: 1 #:: 3 #:: Stream.empty   //> lazyList  : scala.collection.immutable.Stream[Int] = Stream(1, ?)
  lazyList(2)                                     //> res4: Int = 3

  //maps

  val Map1 = Map("US" -> "USA", "MEX" -> "MEXICO")//> Map1  : scala.collection.immutable.Map[String,String] = Map(US -> USA, MEX -
                                                  //| > MEXICO)
  val Map2 = collection.mutable.Map("US" -> "USA", "MEX" -> "MEXICO")
                                                  //> Map2  : scala.collection.mutable.Map[String,String] = Map(MEX -> MEXICO, US 
                                                  //| -> USA)
  Map2 += ("IND" -> "INDIA")                      //> res5: wc5.Map2.type = Map(MEX -> MEXICO, IND -> INDIA, US -> USA)

	val fileName = "C:\\Users\\Swapnesh\\scala_workspace\\ScalaPractice\\input.txt"
                                                  //> fileName  : String = C:\Users\Swapnesh\scala_workspace\ScalaPractice\input.
                                                  //| txt

	val fileSource = Source.fromFile (fileName)
                                                  //> fileSource  : scala.io.BufferedSource = non-empty iterator
	
	for ( line <- fileSource.getLines()){
	println(line)                             //> swapnesh gandhi
	}
	fileSource.close()
}