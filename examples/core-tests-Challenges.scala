
object Cells {
  //Challenge #1 - Write a function to calculate the length of a given List using recursion
  var length = 0;
  def length(xs: List[Int]) : Int = xs match {
    case Nil => length;
    case _ => /*println(xs);*/  length +=1; length(xs.tail); 
  }
  
  val xs = List(1,2,3,4)
  println(length(xs)) // expect 4

  /* ... new cell ... */

  //Challenge #2 - Write a function to reverse the elements in the list
  
  val xs = List(1,2,3,4)
  def reverse(xs: List[Int]) : List[Int] = xs match {
    case Nil => xs;
    case _ => /*println(xs);*/  xs.last :: reverse(xs.init);
  }
  
  println(reverse(xs))   // expect List(4,3,2,1)
  println(reverse(List(1,2,3,4,8,11,13)))   // expect List(13,11,8,4,3,2,1)

  /* ... new cell ... */

  /*
  Challenge #3 - Write a function to validate whether parentheses are balance
  
  Your function should return true for the following strings
  
  (if (zero? x) max (/ 1 x))
  I told him (that it’s not (yet) done). (But he wasn’t listening)
  
  Your function should return false for the following strings
  :-)
  ())(
  
  The following methods are useful for this challenge
  1. chars.isEmpty
  2. chars.head
  3. chars.tail
  
  Hint: you can define an inner function if you need to pass extra parameters to your function.
  
  To convert a String to List[Char] ==> "ucsc school".toList
  
  Extra credit: write another implementation that uses pattern match with list extraction pattern
  */
  
  def balance(chars: List[Char]): Boolean = {
    // iterating without index
    var startBraces = 0;
    var closingBraces = 0;
    var matchFound = 0;
    
    for (char <- chars){
      //println(char);
      if ( char == '(' ){
        startBraces +=1;
      }
      else if ( char == ')' ){
        if ( startBraces >= 1 ) {
          matchFound +=1; 
          startBraces -=1;
        }
        closingBraces+=1;
      }
    }//end for loop
    
    println( "-----------------------------");  
    println( "startBraces:"+startBraces);
    println( "closingBraces:"+closingBraces);  
    println( "matchFound:"+matchFound);    
    
    if ( closingBraces ==  matchFound ) true;
    else false;
  }
  
  println(balance ( "(if (zero? x) max (/ 1 x))".toList ));
  println(balance ( "I told him (that it’s not (yet) done). (But he wasn’t listening)".toList ));
  
  println(balance ( ":-)".toList ));
  println(balance ( "())(".toList ));
  println(balance ( "())()".toList ));

  /* ... new cell ... */

  /* Challenge #4 - Sol# 1
  Given a list of numbers with duplicate values - write a function to remove the duplicates.
  
  Hint - think recursively, leverage pattern matching and declare all the possible cases your function needs to handle. 
  
  Use List.contains method and list append operator :+
  */
  
  val dups = List(1,2,3,4,6,3,2,7,9,4);
  //var list = List(Int);
  def removeDups(xs : List[Int]) : List[Int] = xs match {
    case Nil => xs;
    case x :: xs => 
      println( "----------------------------------------" );
      println("x:"+x+"xs:"+xs);
      //println( "xs.filter:"+xs.filter(_ / x != 1).isEmpty );
      println( "xs.filter:"+xs.filter(_ / x != 0) );
      //list = list :+ x; 
  /*    if (list.contains(x)) {
        x :: removeDups(xs); 
      }
      else x :: removeDups(xs);
      //List(1);
  */
    x :: removeDups(xs.filter(_ / x != 0));
  }
  
  //dups.distinct //removes duplicates from the list
  
  removeDups(dups).sorted  // expect List(1,2,3,4,6,7,9

  /* ... new cell ... */

  //How to use Lists in Scala match expressions
  /*
  You know that a List data structure is a little different than other collection data structures. 
  It’s built from “cons” cells and ends in a Nil element. You want to use this to your advantage when 
  working with a match expression, such as when writing a recursive function.
  */
  
  val n = List(1,2,3,4)
  val s = List("LNKD", "GOOG", "AAPL")
  
  def sum(xs: List[Int]) : Int = xs match {
    case Nil => 0
    case x :: ys => println("x:"+x+",ys:"+ys); x + sum(ys);
  }
  
  sum(n);

  /* ... new cell ... */

  /* Challenge #4 - Sol# 2
  Given a list of numbers with duplicate values - write a function to remove the duplicates.
  
  Hint - think recursively, leverage pattern matching and declare all the possible cases your function needs to handle. 
  
  Use List.contains method and list append operator :+
  */
  
  val dups = List(1,2,3,4,6,3,2,7,9,4);
  //var list = List(Int);
  def removeDups(xs : List[Int]) : List[Int] = xs match {
    case Nil => xs;
    case x :: xs => 
      println( "----------------------------------------" );
      println("x:"+x+"xs:"+xs);
      println( "xs.filter:"+xs.filter( _ / x.toFloat != 1f) ); //only same #s are diviable with remainder 1 so ignore them in new List
      x :: removeDups(xs.filter(_ / x.toFloat != 1)); //if ignored toFloat than inly Int gets pciked up after devision
  }
  
  removeDups(dups).sorted  // expect List(1,2,3,4,6,7,9

  /* ... new cell ... */

  /* Challenge #4 - Sol# 3
  Given a list of numbers with duplicate values - write a function to remove the duplicates.
  
  Hint - think recursively, leverage pattern matching and declare all the possible cases your function needs to handle. 
  
  Use List.contains method and list append operator :+
  */
  
  val dups = List(1,2,3,4,6,3,2,7,9,4);
  
  def removeDups[A](xs : List[A]) : List[A] = 
    xs.tail.foldLeft(List[A]()) { 
      (r,c) => if (r.contains(c)) r else c :: r //because ris an array and c is just an elemtn of that thats why we need to append c within r list
    };
  
  def unique[A](list: List[A]): List[A] =
    list.foldLeft(List[A]()) { (r,c) =>
      if (r.contains(c)) r else c :: r
    };
  
  removeDups(dups).sorted  // expect List(1,2,3,4,6,7,9
  unique(dups).sorted  // expect List(1,2,3,4,6,7,9

  /* ... new cell ... */

  /* Challenge #4 - Sol# 4
  Given a list of numbers with duplicate values - write a function to remove the duplicates.
  
  Hint - think recursively, leverage pattern matching and declare all the possible cases your function needs to handle. 
  
  Use List.contains method and list append operator :+
  */
  def toSet[A](list: List[A]): Set[A] =
    list.foldLeft(Set[A]())(r,c) => { println(r + "," + c); r + c}
  
  val dups = List(1,2,3,4,6,3,2,7,9,4);
  println( "toSet(dups):"+toSet(dups) );

  /* ... new cell ... */

  //Challenge #5 - Sol # 1
  /*
  Given a string containing uppercase characters (A-Z), compress repeated 'runs' of the same character by storing 
  the length of that run, and provide a function to reverse the compression. The output can be anything, as long as 
  you can recreate the input with it. 
  
  Write two functions for performing run length encoding and decoding:
  
  encoding("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW") ==> "12W1B12W3B8W"
  decoding("12W1B12W3B8W") ==> "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW"
  */
  
  def encode(s: String) = (1 until s.size).foldLeft((1, s(0), new StringBuilder)) {
    case ((len, c, sb), index) if c != s(index) => sb.append(len); sb.append(c); (1, s(index), sb)
    case ((len, c, sb), _) => (len + 1, c, sb)
  } match {
    case (len, c, sb) => sb.append(len); sb.append(c); sb.toString
  }
   
  encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW") // "12W1B12W3B8W"

  /* ... new cell ... */

  //Challenge #5 - Sol # 2
  /*
  Given a string containing uppercase characters (A-Z), compress repeated 'runs' of the same character by storing 
  the length of that run, and provide a function to reverse the compression. The output can be anything, as long as 
  you can recreate the input with it. 
  
  Write two functions for performing run length encoding and decoding:
  
  encoding("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW") ==> "12W1B12W3B8W"
  decoding("12W1B12W3B8W") ==> "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW"
  */
  def encode(s:String) = {
    //println("s:"+s);
    s.foldLeft((0,s(0),""))( (t,c) => t match {case (i,p,s) => if (p==c) (i+1,p,s) else (1,c,s+i+p)})
      match {case (i,p,s) => println("s"+s+",i:"+i+", p:"+p); s+i+p}
  }
  
  encode("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW") // "12W1B12W3B8W"
  
  /*
  encode("WWWBBWWBW") // "12W1B12W3B8W"
  
      // (0,w,"") w = (1,w,"") - 0
      // (1,w,"") w = (2,w,"") - 1
      // (2,w,"") w = (3,w,"") - 2
      // (3,w,"") B = (1,B, ""+3+w) = (1,B,"3w") - 3  
      // (1,B,"3w") B = (2,B,"3w") - 4
      // (2,B,"3W") W = (1,W,"3W2B") - 5
      // (1,W,"3W2B") W = (2,W,"3W2B") - 6  
      // (2,W,"3W2B") B = (1,B,"3W2B2W") - 7
      // (1,B,"3W2B2W") W = (1,W,"3W2B2W1B") - 8
      // (1,W,"3W2B2W1B") ==> ("3W2B2W1B1W") - last match  
  */

  /* ... new cell ... */

  //Challenge #5 - Sol # 3
  /*
  Given a string containing uppercase characters (A-Z), compress repeated 'runs' of the same character by storing 
  the length of that run, and provide a function to reverse the compression. The output can be anything, as long as 
  you can recreate the input with it. 
  
  Write two functions for performing run length encoding and decoding:
  
  encoding("WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW") ==> "12W1B12W3B8W"
  decoding("12W1B12W3B8W") ==> "WWWWWWWWWWWWBWWWWWWWWWWWWBBBWWWWWWWW"
  
  def encode[A](list: List[A]): List[(A,Int)] =
  list.foldLeft(List[(A,Int)]()){ (r,c) =>
      r match {
        case (value, count) :: tail =>
          if (value == c) (c, count+1) :: tail
          else            (c, 1) :: r
        case Nil =>
          (c, 1) :: r
      }
  }.reverse
  
  def decode[A](list: List[(A,Int)]): List[A] =
  list.foldLeft(List[A]()){ (r,c) =>
      var result = r
      for (_ <- 1 to c._2) result = c._1 :: result
      result
  }.reverse
  
  
  def decode(s:String) = {
    val onlyDigitsRegex = "^\\d*$".r;
    
    s.foldLeft(("", ""))( (t,c) => c match {
      case onlyDigitsRegex  => (t + c , b);
      case (_) => (1 to t.toInt) c;  
    })
  }
  */
  def decode(s: String) = {
    val sb = new StringBuilder
    val Code = """(\d+)([A-Z])""".r
    for (Code(len, c) <- Code findAllIn s) { println("len:"+len+", c:"+c); sb.append(c * len.toInt);}
    sb.toString
  }
  //val decodedMsg = "12W1B12W3B8W";
  //val Code = """(\d+)([A-Z])""".r;
  //val splitMsgChars = Code findAllIn s;
  //val splitMsgChars = decodedMsg.split("(\\d+)(\\D)");
  println( "splitMsgChars:"+splitMsgChars );
  decode("12W1B12W3B8W") // "12W1B12W3B8W"

  /* ... new cell ... */

  //tuples 1 through 22
  (1,2,3,4,"T5","T6",7,8,9,10,11,12,13,14,15,16,17,18,19,20,"T21","T22")
  
  //tuples 1 through 23 
  //(1,2,3,4,"T5","T6",7,8,9,10,11,12,13,14,15,16,17,18,19,20,"T21","T22","T23")//errors out because tuples are 1 through 22

  /* ... new cell ... */

  val a = "012";
  val b : Int = a;

  /* ... new cell ... */
}
              