package list

trait List[+T] {
  def length:Int
  def addToBeginning[S >: T](elementToAdd:S) = new NonEmptyList(elementToAdd, this)
  def addToEnd[S >: T](elementToAdd:S):List[S]
//  def map[S](transformFunction:T=>S):List[S]
//  def fold[S](incrementalFold:(T,S)=>S, initialValue:S):S
  def addListToEnd[S >: T](elementsToAdd:List[S]):List[S]
}