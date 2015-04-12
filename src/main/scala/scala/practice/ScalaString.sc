import com.sun.org.apache.xalan.internal.xsltc.compiler.ForEach

object ScalaString {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //String Equality
  val s1 = "Fremont"                              //> s1  : String = Fremont
  val s2 = "Fremont";                             //> s2  : String = Fremont

  if (s1 == s2) {
    println("true")
  }                                               //> true

  val s3 = "fremont";                             //> s3  : String = fremont

  if (s3.toUpperCase() == s2.toUpperCase()) {
    println("true")
  }                                               //> true

  val s4 = """ asdffg
	 sssssss""";                              //> s4  : String = " asdffg
                                                  //| 	 sssssss"

  " I, live, in, Fremont, ".split(", ").foreach(println);
                                                  //>  I
                                                  //| live
                                                  //| in
                                                  //| Fremont

  " I, live, in, Fremont, ".split(",").map(_.trim()).foreach(println)
                                                  //> I
                                                  //| live
                                                  //| in
                                                  //| Fremont
                                                  //| 

  //substitute a variable

  println(s"I live in $s1")                       //> I live in Fremont

  val Age = 4;                                    //> Age  : Int = 4
  println(s"Age + 4 ${Age + 4}")                  //> Age + 4 8

  var data = "fremont , newark".map(c => c.toUpper)
                                                  //> data  : String = FREMONT , NEWARK
  var data1 = "fremont , newark".filter(_ != 'e').map(_.toUpper)
                                                  //> data1  : String = FRMONT , NWARK
  var data4 = for (c <- "Fremont") yield c.toUpper//> data4  : String = FREMONT
  def toLower(c: Char): Char = (c.toByte + 32).toChar
                                                  //> toLower: (c: Char)Char

  "FREMONTTT".map(toLower)                        //> res0: String = fremonttt

  //RegEx in scala

  val regPattern = "[0-9]+".r                     //> regPattern  : scala.util.matching.Regex = [0-9]+

  val address = "123 san fransicso CA 22344"      //> address  : String = 123 san fransicso CA 22344

  val match2 = regPattern.findAllIn(address).foreach(println)
                                                  //> 123
                                                  //| 22344
                                                  //| match2  : Unit = ()

  val match4 = regPattern.findAllIn(address).toArray
                                                  //> match4  : Array[String] = Array(123, 22344)

  val add2 = "asd asasa"                          //> add2  : String = asd asasa

  val match5 = regPattern.findFirstIn(add2).getOrElse("NO match")
                                                  //> match5  : String = NO match

  val add3 = "123 Snfo ca 2222222"
    .replaceAll("[0-9]2", "x")                    //> add3  : String = x3 Snfo ca xxx2

  val regPattern2 = "([0-9]+) ([A-Za-z]+)".r      //> regPattern2  : scala.util.matching.Regex = ([0-9]+) ([A-Za-z]+)

  val regPattern2(data10, city) = "100 fre"       //> data10  : String = 100
                                                  //| city  : String = fre

  add3(0)                                         //> res1: Char = x

  //add your method to String class

  implicit class StringImprovements(s: String) {

    def increment = s.map(c => (c + 32).toChar)

  }

  val myStr = "abc".increment                     //> myStr  : String = Â�Â‚Âƒ

  def decode(num: Int) {
    num match {

      case 1 => println(1)

      case 2 => println(2)

      case _ => print("NOMATCH")

    }
  }                                               //> decode: (num: Int)Unit

  decode(3)                                       //> NOMATCH

  decode(1)                                       //> 1

  def decode2(num: Int) {

    println(num match {
      case 1 => "One"

      case 2 => "TWO"

      case _ => "NOMATCH"

    })

  }                                               //> decode2: (num: Int)Unit

  decode2(2)                                      //> TWO
  //imperative
  def total(list: List[Int]) = {
    var sum = 0;

    for (i <- list) {

      sum += i;
    }
    sum
  }                                               //> total: (list: List[Int])Int

  total(List(1, 2, 3, 4, 5, 67))                  //> res2: Int = 82

  //functional
  def total2(list: List[Int]) = {

    list.fold(0)((x, y) => x + y)

  }                                               //> total2: (list: List[Int])Int

  total2(List(1, 2, 3, 4, 5, 67))                 //> res3: Int = 82

  def total3(list: List[Int]) = {
    var sum = 0;

    list.foreach(e => if (e % 2 == 0) sum += e)
    sum
  }                                               //> total3: (list: List[Int])Int

  total3(List(1, 2, 3, 4, 5, 67))                 //> res4: Int = 6

  def totaFunc(list: List[Int], selected: Int => Boolean) = {
    var sum = 0

    list.foreach { e =>
      if (selected(e)) sum += e
    }
    sum
  }                                               //> totaFunc: (list: List[Int], selected: Int => Boolean)Int

  totaFunc(List(1, 2, 3, 4, 5, 67), e => true)    //> res5: Int = 82
  totaFunc(List(1, 2, 3, 4, 5, 67), e => e % 2 == 0)
                                                  //> res6: Int = 6

  var sum = List(1, 2, 3, 4, 5) map (_ + 10) filter { _ % 2 == 0 } map (_ * 3)
                                                  //> sum  : List[Int] = List(36, 42)

}