package list

object groupTheory {
  trait AlgStruct[A] {
    def op(a: A, b: A): A
    def is(a: A, b: A): Boolean = (a == b)
  }

  trait SemiGroup[A] extends AlgStruct[A] {
    //Op is associative
  }

  trait Monoid[A] extends SemiGroup[A] {
    //Identity element
    val e: A
  }

  trait Group[A] extends Monoid[A] {
    def inv(a: A): A
  }

  trait FiniteAlgStruct[A] extends AlgStruct[A] {
    //Contains a finite set
    val set: Set[A]
    def order = set.size
    def contains(x: A) = set.contains(x)
  }

  trait FiniteSemiGroup[A] extends SemiGroup[A] with FiniteAlgStruct[A]
  trait FiniteMonoid[A] extends Monoid[A] with FiniteSemiGroup[A]
  trait FiniteGroup[A] extends Group[A] with FiniteMonoid[A]

  //Concrete below, abstract above this line

  case object MultMod5over1to4 extends FiniteGroup[Int] {
    val set: Set[Int] = Set(1, 2, 3, 4)
    def op(a: Int, b: Int): Int = (a * b) % 5
    val e = 1
    def inv(a: Int): Int = a match {
      case 1 => 1
      case 2 => 3
      case 3 => 2
      case 4 => 4
    }
  }

  //* != "multiply two numbers"
  //*Z = "perform the operation of "multiplication mod Z" on two numbers"
  //given two numbers, x and y, yield (x times y) % Z

  case object TommysFiniteAlgStruct extends FiniteAlgStruct[Int] {
    override val set: Set[Int] = Set(1,2,3)
    override def op(a: Int, b: Int): Int = a + b
  }

  case object IntAdd extends Group[Int] {
    def op(a: Int, b: Int): Int = a + b
    val e = 0
    def inv(a: Int): Int = 0 - a
  }

  class TommysAlgStruct extends AlgStruct[Int] {
    override def op(a: Int, b: Int): Int = a + b
  }

  class TommysNonAlgStruct extends AlgStruct[Int] {
    override def op(a: Int, b: Int): Int = a / b
  }

//  trait SemiGroup[A] extends AlgStruct[A] {
//    //Op is associative
//  }
//
//  trait Monoid[A] extends SemiGroup[A] {
//    //Identity element
//    val e: A
//  }
//
//  trait Group[A] extends Monoid[A] {
//    def inv(a: A): A
//  }
//
//  case class IntAdd extends Group[Int] {
//    def op(a: Int, b: Int): Int = a + b
//    val e = 0
//    def inv(a: Int): Int = 0 - a
//  }
//
//  trait FiniteAlgStruct[A] extends AlgStruct[A] {
//    //Contains a finite set
//    val set: Set[A]
//
//    def order = set.size
//
//    def contains(x: A) = set.contains(x)
//  }
//
//  trait FiniteSemiGroup[A] extends SemiGroup[A] with FiniteAlgStruct[A]
//  trait FiniteMonoid[A] extends Monoid[A] with FiniteSemiGroup[A]
//  trait FiniteGroup[A] extends Group[A] with FiniteMonoid[A]
//
//  case class MultMod5over1to4 extends FiniteGroup[Int] {
//    val set: Set[Int] = Set(1, 2, 3, 4)
//    def op(a: Int, b: Int): Int = (a * b) % 5
//    val e = 1
//    def inv(a: Int): Int = a match {
//      case 1 => 1
//      case 2 => 3
//      case 3 => 2
//      case 4 => 4
//    }
//  }
}