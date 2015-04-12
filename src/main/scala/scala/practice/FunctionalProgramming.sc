object FunctionalProgramming {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class User(var age: Int, val city: Int) {
    println("yyyyoyyooy")
    def cal(myAge: Int) = {
      age += myAge
      age
    }

    def this(age: Int) {
      this(age, 0)
    }
  }

  class User2 {
    def turn(direction: String) {
      println("turn :" + direction)
    }

  }

  object User2 {
    def apply() = new User2
  }

  var userObj = new User(11, 111)                 //> yyyyoyyooy
                                                  //| userObj  : FunctionalProgramming.User = FunctionalProgramming$$anonfun$main$
                                                  //| 1$User$1@106faf1e
  userObj.cal(100)                                //> res0: Int = 111
  userObj.city                                    //> res1: Int = 111

  println(new User(11).city)                      //> yyyyoyyooy
                                                  //| 0

  var obj3 = new User2                            //> obj3  : FunctionalProgramming.User2 = FunctionalProgramming$$anonfun$main$1$
                                                  //| User2$2@1247fdc3
  obj3 turn "right"                               //> turn :right

  def data(age: Int) {
    println(age)

  }                                               //> data: (age: Int)Unit

  data(1)                                         //> 1

  //find GCD
  var x: Int = 12;                                //> x  : Int = 12
  var y = 78;                                     //> y  : Int = 78

  while (x != 0) {
    var temp = x;
    x = y % x;
    y = temp
  }
  y                                               //> res2: Int = 6

  for (i <- 1 to 4) {
    println("hello")                              //> hello
                                                  //| hello
                                                  //| hello
                                                  //| hello
  }

  def max(x: Int, y: Int) = {
    if (x > y) x
    else y

  }                                               //> max: (x: Int, y: Int)Int

  max(12, 1)                                      //> res3: Int = 12

  def gcd(x: Int, y: Int): Long = {
    if (y == 0) {
      x
    } else {
      gcd(y, x % y)
    }

  }                                               //> gcd: (x: Int, y: Int)Long

  gcd(12, 78)                                     //> res4: Long = 6

}