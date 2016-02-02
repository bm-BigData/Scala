
object Cells {
  println("Hello, Buland");

  /* ... new cell ... */

  val xs = Vector(1,2,3,4,5)
  for(x <- xs)
    println(x)

  /* ... new cell ... */

  val xs = Array(1,2,4,6)
  for (x <- xs)
    println(x);

  /* ... new cell ... */

  var name = "Buland A Malik"

  /* ... new cell ... */

  var name1 = "Buland";
  name = name1 + " Malik";

  /* ... new cell ... */

  println(name);

  /* ... new cell ... */

  name = "hello";

  /* ... new cell ... */

  val name = "";

  /* ... new cell ... */

  var name = "hello"

  /* ... new cell ... */

  //One Contrcutor Example
  case class Person(name:String, age:Int){
    def whoAmI : String = "Hello, " + name + ". You are " + age + " years old.";
  }
  
  /*
  case class Person(name:String, age:Int, sex: String){
    def whoAmI : String = "Hello, " + name + ". You are " + age + " years old and you are "+sex;
  }
  */
  
  //defining buland with val/var is required
  val buland = Person("Buland A Malik", 35);
  val buland1 = new Person("Buland Malik", 35);
  //val obj2 = new Person("Buland Malik"); //this is an error because there is only primary constructor that requires all fields
  println(buland.whoAmI);
  println(buland1.whoAmI);
  //println(buland2.whoAmI);
  
  //Checking equality as it should be provided by 'case'
  println(buland == Person("Buland A Malik", 35));
  println(buland == Person("Buland A Malik", 36));
  
  //testing toString as it should be provided by 'case'
  println(buland.toString);
  println(buland.toString());
  println(buland);
  
  //testing hashcode as it should be provided by 'case'
  println(buland.hashCode());
  println(Person("Buland A Malik", 35).hashCode());

  /* ... new cell ... */

  //multiple constructor Example
  //cannot make it a Case Class because of multiple constructors
  class Mammal(name: String, age: Int, voice: String){
    def this(name: String){
      this(name, 0, "NOT KNOWN");
    }
  
    def this(name: String,age: Int){
      this(name, age, "NOT KNOWN");
    }
  
    def this(name: String, voice: String){
      this(name, 0, voice);
    }
  
    def whoAmI() : String = "Hello, " + name + ", you are " + age + " years old and your vocie is " + voice;
  }
  
  val pussyDog = new Mammal("Pussy");
  println(pussyDog.whoAmI());
  
  val hushDog = new Mammal("Hush", "Waho");
  println(hushDog.whoAmI());
  
  var teraCat = new Mammal("Tera", 1, "Meoow");
  println(teraCat.whoAmI());

  /* ... new cell ... */
}
              