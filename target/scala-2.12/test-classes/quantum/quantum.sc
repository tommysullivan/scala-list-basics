import list.List
import scala.math.sqrt

trait Multipliable extends Addable {
  def * (other:Multipliable):Multipliable
}

trait Addable {
  def + (other:Addable):Addable
  implicit def toDouble:Double
  def toInt:Int
}

object Zero extends Multipliable {
  def +(other:Addable) = other
  def *(Other:Multipliable) = Zero
  implicit def toDouble = 0
  def toInt = 0
}

implicit class Rootable(addable:Addable) {
  def squareRoot = sqrt(addable)
}

implicit class IntSummable(intList:List[Addable]) {
  def sum:Addable = intList.fold[Addable]((a,b) => a + b, Zero)
}

case class FiniteVector[T <: Multipliable](elements:List[T]) {
  def size:Int = elements.length
  def magnitude:Double = elements.map(i => i * i).sum.squareRoot
}