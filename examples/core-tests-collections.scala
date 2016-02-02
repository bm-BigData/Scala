
object Cells {
  //Vectors
  val winnerNames = Vector("Buland","Qasim","Bilal","Shahzad")
  println(winnerNames);
  println(winnerNames.size);
  println(winnerNames(0));//zero based index

  /* ... new cell ... */

  //Vectors
  val winnerNamesAndAges = Vector("Buland","Qasim","Bilal","Shahzad")

  /* ... new cell ... */

  //Set
  var studentNamesSet = Set("Azka","Zegham","Saim");
  println( studentNamesSet("Azka") );//check for Azka inside set and returns boolean accordingly -- True
  println( studentNamesSet("Sohaib") );//False

  /* ... new cell ... */

  //Set example by setting the data type of set
  var studentResultsSet: Set[Double] = Set(99,89.97,97.50,100);
  println( studentResultsSet );
  println( studentResultsSet(99) );
  println( studentResultsSet(50) );

  /* ... new cell ... */

  //Maps
  var studentNamesAndResultsMap = Map("Azka"->100 , "Saim"->99.50 , "Sohaib"->99.97);
  println( studentNamesAndResultsMap );
  println( studentNamesAndResultsMap("Azka") );
  //println( studentNamesAndResultsMap("Zegham") ); //throws an error 'java.util.NoSuchElementException: key not found: Zegham'

  /* ... new cell ... */

  //Iterators
  val a = Iterator(1,2,3)
  val b = a.map(x => x + 1) // stage an operation, but don't traverse yet
  println( a );
  println( b.sum );
  
  val e = Iterator(1,2,3)
  val f = e.map(x => x + 1) // stage an operation, but don't traverse yet
  //val f = e.map(x => x + 1) // this will create a map(0->2,1->3,3->4)
  val g = f.toVector        // g: Vector[Int] = Vector(2, 3, 4)
  val h = g.sum             // h: Int = 9
  val i = g.mkString(" ")   // i: String = "2 3 4"

  /* ... new cell ... */

  //list foldLeft examples
  /*
  Write a function called ‘mimicToString’ that mimics List’s own toString method. That is, it should return a 
  String containing a comma-delimited series of string representations of the list contents with “List(” on the 
  left and “)” on the right.
  */
  
  val letters = List('A','B','C','D');
  val str = List("ABCD");
  val numbers = List[Int](1,2,3,4,5,6,7,8,9,10);
  
  //sol # 1 for mimicToString
  def mimicToStringSol1[A](list: List[A]): String = list match {
    case head :: tail => tail.foldLeft("List(" + head)(_ + ", " + _) + ")"
    case Nil => "List()"
  }
  
  println(  "mimicToStringSol1 (letters):"+mimicToStringSol1 (letters) );
  println(  "mimicToStringSol1 (str):"+mimicToStringSol1 (str) );
  println(  "mimicToStringSol1 (numbers):"+mimicToStringSol1 (numbers) );
  
  println(  "-----------------------------------------" );
  
  //sol # 2 for mimicToString --- half cooked ')' is missing at the end
  def mimicToStringSol2[A](list: List[A]): String = 
    list.tail.foldLeft("List(" + list.head) ((r,c) => r + ", " + c);
  
  println(  "mimicToStringSol2 (letters):"+mimicToStringSol2 (letters) );
  println(  "mimicToStringSol2 (str):"+mimicToStringSol2 (str) );
  println(  "mimicToStringSol2 (numbers):"+mimicToStringSol2 (numbers) );

  /* ... new cell ... */

  //testing operators
  
  val list = List(2,3,4);
  
  // cons operator – prepend a new element to the beginning
  val m = 1::list
  println("list:"+list);
  println("m:"+m)
  
  println("2f/3:"+2f/3);
  println("2/3f:"+2/3f);
  println("2f/3f:"+2f/3f);
  println("2/3:"+2/3);

  /* ... new cell ... */
}
              