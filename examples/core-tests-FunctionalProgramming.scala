
object Cells {
  //Lambda Functions
  val add1 = (x:Int) => x + 1;
  
  println ( "add1(2):" + add1(2) );
  println ( "add1(3):" + add1(3) );
  
  val add2: (Int => Int) = x => x + 1;
  println ( "add2(2):" + add2(2) );
  
  def add3(f: (Int=>Int), i:Int) = f(i);
  
  println(add3(x=>x+1, 2));
  println(add3(add1,3));

  /* ... new cell ... */

  //map: Take a function as an argument and apply it to every element in the collection.
  
  Vector(1,2,3).map(x => x + 2)  // same as...
  //Vector(1,2,3).map(_ + 2)       // res0: Vector[Int] = Vector(3, 4, 5)

  /* ... new cell ... */

  //flatten: Flatten a collection of collections.
  
  val a = Vector(Vector(1,2,3), Vector(4,5,6), Vector(7,8,9))
  a.flatten   // res1: Vector[Int] = Vector(1, 2, 3, 4, 5, 6, 7, 8, 9)

  /* ... new cell ... */

  //flatMap: Map a function over the collection and flatten the result
  
  Vector(1,2,3).flatMap(n => Vector.fill(n)(s"[$n]"))    
  // res2: Vector[String] = Vector([1], [2], [2], [3], [3], [3])
  
  Vector(1,2).flatMap(n => Vector.fill(n) (s"[$n]"))

  /* ... new cell ... */

  //for comprehension
  val a = 
    for(
       x <- Vector(1,2,3,4,5); // outer loop over a vector
       if x % 2 == 1;          // filter out even xs
       y <- Set(1,2,3);        // inner loop over a list
       if x + y == 6           // filter out entries that don't sum to 6
      ) yield x * y
  // a: scala.collection.immutable.Vector[Int] = Vector(9, 5)

  /* ... new cell ... */

  //This is accomplished by having the compiler translate the expression into a series of method calls. 
  //Each iteration is a call to flatMap and the last iteration is a call is to map:
  
  val a = 
    Vector(1,2,3,4,5)
      .filter(x => x % 2 == 1)
      .flatMap(x => 
        Set(1,2,3)
          .filter(y => x + y == 6)
          .map(y => x * y))
  // a: scala.collection.immutable.Vector[Int] = Vector(9, 5)

  /* ... new cell ... */

  val ? = scala.math.Pi
  
  println(?)

  /* ... new cell ... */
}
              