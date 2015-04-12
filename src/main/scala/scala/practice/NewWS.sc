object NewWS {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet

  class Point(inputx: Int, inputy: Int) {
    var x = inputx
    var y = inputy

    def vectorAddition(newPoint: Point): Point = {
      new Point(x + newPoint.x, y + newPoint.y)
    }

  }

  var pobj = new Point(1, 2)                      //> pobj  : NewWS.Point = NewWS$$anonfun$main$1$Point$1@c0e1f6c
  var pobj2 = new Point(2, 1)                     //> pobj2  : NewWS.Point = NewWS$$anonfun$main$1$Point$1@7330f1a2

  var pobj3 = pobj.vectorAddition(pobj2)          //> pobj3  : NewWS.Point = NewWS$$anonfun$main$1$Point$1@1247fdc3

  println(pobj3.x)                                //> 3
  println(pobj3.y)                                //> 3

  class Point2(inputx: Int, inputy: Int) {

    var x = inputx
    var y = inputy

    def +(newPoint: Point2): Point2 = {
      new Point2(x + newPoint.x, y + newPoint.y)
    }

    def -(newPoint: Point2): Point2 = {
      new Point2(x + newPoint.x, y + newPoint.y)
    }
  }

  var pobj4 = new Point2(1, 2)                    //> pobj4  : NewWS.Point2 = NewWS$$anonfun$main$1$Point2$1@58adab12
  var pobj5 = new Point2(2, 1)                    //> pobj5  : NewWS.Point2 = NewWS$$anonfun$main$1$Point2$1@71ba5839

  var pobj6 = pobj4 + pobj5                       //> pobj6  : NewWS.Point2 = NewWS$$anonfun$main$1$Point2$1@f64084
  var pobj7 = pobj4 + pobj5                       //> pobj7  : NewWS.Point2 = NewWS$$anonfun$main$1$Point2$1@27059a9a

  println(pobj6.x)                                //> 3

  case class Point3(x: Int, y: Int) {

    def +(newPoint: Point3) = new Point3(x + newPoint.x, y + newPoint.y)

    override def toString() = x + " " + y;

  }

  var pobj9 = Point3(1, 2)                        //> pobj9  : NewWS.Point3 = 1 2
  var pobj10 = Point3(2, 1)                       //> pobj10  : NewWS.Point3 = 2 1

  var pobj11 = pobj9 + pobj10                     //> pobj11  : NewWS.Point3 = 3 3

  println(pobj11)                                 //> 3 3

}