package list

case object EmptyList extends List[Nothing] {
  override def toString = "."
  def length = 0
  def map[S](transformFunction:Nothing=>S):List[S] = this
  def fold[S](incrementalFold:(Nothing,S)=>S, initialValue:S):S = initialValue
}