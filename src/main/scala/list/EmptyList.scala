package list

case object EmptyList extends List[Nothing] {
  override def toString = "."
  def length = 0
  def addToEnd[S](elementToAdd:S) = addToBeginning(elementToAdd)
  def addListToEnd[S](elementsToAdd:List[S]):List[S] = {
    if(elementsToAdd.length == 0) this
    else elementsToAdd
  }
  def addListToBeginning[S](elementsToAdd:List[S]):List[S] = addListToEnd(elementsToAdd)
  def map[S](transformFunction:Nothing=>S):List[S] = this
  def filter(predicate:Nothing=>Boolean):List[Nothing] = this
  def fold[S](incrementalFold:(Nothing,S)=>S, initialValue:S):S = initialValue
}