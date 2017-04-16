package list

case class NonEmptyList[T](firstElement:T, allOtherElements:List[T]) extends List[T] {
  override def toString = s"$firstElement,$allOtherElements"
  def length = 1 + allOtherElements.length
}