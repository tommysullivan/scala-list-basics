package list

case class NonEmptyList[T](firstElement:T, allOtherElements:List[T]) extends List[T] {
  override def toString = s"$firstElement,$allOtherElements"
  override def addToEnd[S >: T](elementToAdd:S) = new NonEmptyList(firstElement, allOtherElements.addToEnd(elementToAdd))
  def addListToEnd[S >: T](elementsToAdd:List[S]):List[S] = {
    new NonEmptyList[S](firstElement, allOtherElements.addListToEnd(elementsToAdd))
  }
  def addListToBeginning[S >: T](listThatShouldBeAtBeginningOfNewList:List[S]):List[S] = {
    listThatShouldBeAtBeginningOfNewList.addListToEnd(this)
  }
  def length = 1 + allOtherElements.length
  def map[S](transformFunction:T=>S):List[S] = {
    new NonEmptyList[S](transformFunction(firstElement),allOtherElements.map(transformFunction))
  }
  def filter(predicate:T=>Boolean):List[T] = {
    if(predicate(firstElement)) new NonEmptyList[T](firstElement,allOtherElements.filter(predicate))
    else allOtherElements.filter(predicate)
  }
}