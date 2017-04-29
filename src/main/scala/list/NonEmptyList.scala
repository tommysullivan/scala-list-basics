package list

case class NonEmptyList[T](firstElement:T, allOtherElements:List[T]) extends List[T] {
  override def toString = s"$firstElement,$allOtherElements"
  override def addToEnd[S >: T](elementToAdd:S) = new NonEmptyList(firstElement, allOtherElements.addToEnd(elementToAdd))
  def addListToEnd[S >: T](elementsToAdd:List[S]):List[S] = {
    new NonEmptyList[S](firstElement, allOtherElements.addListToEnd(elementsToAdd))
  }
  def length = 1 + allOtherElements.length
//  def map[S](transformFunction:T=>S):List[S] = new NonEmptyList[S](transformFunction(firstElement), allOtherElements.map(transformFunction))
//  def fold[S](incrementalFold:(T,S)=>S, initialValue:S):S = {
//    incrementalFold(firstElement, allOtherElements.fold(incrementalFold, initialValue))
//  }
}