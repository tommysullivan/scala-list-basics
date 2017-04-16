import list.{EmptyList, NonEmptyList}

val l0 = new NonEmptyList(1, EmptyList)
l0.addToBeginning("tommy")
l0.addToBeginning(true)

class Person extends Object {
  def sayHi:Unit
}
class Firefighter extends Person {
  def shootHose:Unit
}
class Nurse extends Person {
  def savePerson:Unit
}

//Given: Firefighter is a subclass of Person
//Q: List[Firefighter] a subclass of List[Person]


var f:Firefighter = null
var p:Person = null

p = f
p.sayHi

var lF:List[Firefighter] = null
val lP:List[Person] = null