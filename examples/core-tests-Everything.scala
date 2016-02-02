
object Cells {
  val msg = "Buland";
  // string interpolation
  s"Greeting: $msg"

  /* ... new cell ... */

  //Pattern Matching
  def errorMsg(n:Int) = n match {
     case 1 => println("Not a problem")
     case 2 => println("You may want to double check")
     case 3 => println("System is shutting down")
  }
  
  errorMsg(3);

  /* ... new cell ... */

  //Pattern Matching
  abstract class Shape
  case class Rectangle(h:Int, w:Int) extends Shape
  case class Circle(r:Int) extends Shape
  case class Polygon(r:Int) extends Shape
  
  def area(s:Shape) = s match {
    case (Rectangle(h:Int, w:Int)) => "I am Rectangle"
    case (Circle(r:Int)) => "I am Circle"
    case _ => "I am not defined"
  }
  
  println(area(Rectangle(4,5)))
  
  println(area(Circle(5)))
  
  println(area(Polygon(5)))

  /* ... new cell ... */

  val n = List(1,2,3,4)
  val s = List("LNKD", "GOOG", "AAPL")
  val p = List(265.69, 511.78, 108.49)
  
  var product = 1;
  n.foreach(product *= _)  // 24
  
  n.filter(_ % 2 != 0)     // List(1,3)
  n.partition(_ % 2 != 0) // (List(1,3), List(2,4))
  
  n.find(_ % 2 != 0)       // Some(1)
  n.find(_ < 0)            // None
  
  p.takeWhile(_ > 200.00)  // List(265.69, 511.78)
  p.dropWhile(_ > 200.00)  // List(108.49)
  
  p.span(_ > 200.00)       // (List(265.69, 511.78),List(108.49))
  
  val n1 = List(1,2,3,4)
  val s1 = List("LNKD", "GOOG", "AAPL")
  
  
  n1.map(_ + 1)             // List(2,3,4,5)
  s1.flatMap(_.toList)      // List(L,N,K,D,G,O,O,G,A,A,P,L)
  
  //n1.reduce((a,b)           ==> { a + b} )         // { a + b} )  ==> 10
  n1.reduce(_ + _)
  
  n1.contains(3)            // true

  /* ... new cell ... */

  val l = List(1,2,3,4);
  //l.foreach(println)
  //l.foreach(x => println(x + " "))
  
  //println(l.head)  //1
  println(l.tail)  // List(2,3,4)
  //println(l.last)  // 4
  println(l.init)  // List(1,2,3)

  /* ... new cell ... */

  val table: List[List[Int]] = List (
         List(1,0,0),
         List(0,1,0),
         List(0,0,1)        
  )
  
  val list = List(2,3,4);
  
  // cons operator – prepend a new element to the beginning
  val m = 1::list 
  
  // appending
  val n = list :+ 5
  
  // to find out whether a list is empty or not
  println("empty list? " + m.isEmpty)
  
  // take the first n elements
  list.take(2) // List(2,3)
  
  // drop the first n elements
  list.drop(2) // List(4)

  /* ... new cell ... */

  //Nested Function -- recursion
  def filter(xs: List[Int], threshold: Int) = {
      def process(ys: List[Int]): List[Int] =
        if (ys.isEmpty) ys
        else if (ys.head < threshold) ys.head :: process(ys.tail)
        else process(ys.tail)
      process(xs)
    }
    println(filter(List(1, 9, 2, 8, 3, 7, 4), 8))

  /* ... new cell ... */

  val n = List(1,2,3,4)
  //val s = List("LNKD", "GOOG", "AAPL")
  
  def sum(xs: List[Int]) : Int = xs match {
    case Nil => 0
    case x :: ys => x + sum(ys)
  }
  
  sum(n);

  /* ... new cell ... */
}
              