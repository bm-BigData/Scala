
object Cells {
  val a = (1, "second", 3.4)

  /* ... new cell ... */

  val tuple1 = (1, "second", 3.4)
  println(tuple1._1);
  println(tuple1._2);
  println(tuple1._3);

  /* ... new cell ... */

  //tuples
  val tuple2 = 1 -> 2
  println(tuple2._1);
  println(tuple2._2);

  /* ... new cell ... */

  //accessing undefined tuple index
  //tuples
  val tuple2 = 1 -> 2
  println(tuple2._3); //it should fail

  /* ... new cell ... */
}
              