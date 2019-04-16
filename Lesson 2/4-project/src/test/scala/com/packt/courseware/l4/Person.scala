import org.scalatest.FunSuite


case class Person(firstName:String, lastName:String)

object Person {
  def classify(p:Person): String = {
    val r = p match {
      case Person("Joe",_) => "A"
      case x: Person if (x.lastName.take(1).toLowerCase() == x.lastName.take(1)) => "C"
      case _ => "B"
    }
    r
  }
}

class PersonTest extends FunSuite {
  test("Person(Joe,_) should return A") {
    assert(Person.classify(Person("Joe","X")) == "A")
  }
  test("Person(_,eFRAIN) should return C") {
    assert(Person.classify(Person("X","eFRAIN")) == "C")
  }
  test("Person(Albert,Einstein) should return B") {
    assert(Person.classify(Person("Albert","Einstein")) == "B")
  }
}
