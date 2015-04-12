object wc4 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  //non strict
  def ns[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
    if (cond) onTrue else onFalse                 //> ns: [A](cond: Boolean, onTrue: => A, onFalse: => A)A

  ns(false, sys.error("Fail"), 3)                 //> res0: Int = 3

  //lazy caching

  def pair(i: => Int) = (i, i)                    //> pair: (i: => Int)(Int, Int)

  pair {
    println("Hello"); 1 + 42
  }                                               //> Hello
                                                  //| Hello
                                                  //| res1: (Int, Int) = (43,43)

  def pair2(i: Int) = {
    lazy val j = i;
    (j, j)
  }                                               //> pair2: (i: Int)(Int, Int)

  pair2 {
    println("Hello")
    1 + 42
  }                                               //> Hello
                                                  //| res2: (Int, Int) = (43,43)

  trait Friend {
    val name: String
    def command = println(name + " please coem herr")
  }

  class Person(val name: String) extends Friend

  val obj = new Person("ass")                     //> obj  : wc4.Person = wc4$$anonfun$main$1$Person$1@693b004c
  obj.command;                                    //> ass please coem herr

  class User(val name: String)

  class Admin(override val name: String) extends User(name) with Friend{
  
  }
 
 	val obj1 = new Admin("swapnesh")          //> obj1  : wc4.Admin = wc4$$anonfun$main$1$Admin$1@25b13009
  obj1.command                                    //> swapnesh please coem herr
  
  def seek (friend : Friend) = friend.command     //> seek: (friend: wc4.Friend)Unit
  
  seek(obj1)                                      //> swapnesh please coem herr
  
	class GeneralUser (override val name :String) extends User(name)
	
	val obj3 = new GeneralUser("gandhi") with Friend
                                                  //> obj3  : wc4.GeneralUser with wc4.Friend = wc4$$anonfun$main$1$$anon$1@ef8e76
                                                  //| 1
	
	obj3.command                              //> gandhi please coem herr



}