package list

case class NonEmptyList[T](firstElement:T, allOtherElements:List[T]) extends List[T] {
  override def toString = s"$firstElement,$allOtherElements"
  override def addToEnd[S >: T](elementToAdd:S) = new NonEmptyList(firstElement, allOtherElements.addToEnd(elementToAdd))
  def length = 1 + allOtherElements.length
}