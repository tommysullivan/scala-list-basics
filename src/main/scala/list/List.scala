package list

trait List[+T] {
  def length:Int
  def addToBeginning[S >: T](elementToAdd:S) = new NonEmptyList(elementToAdd, this)
}