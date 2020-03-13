class BS {

  //T-> TestCase
  //N-> Number of elemets
  //K-> SubSeq
  //P-> adjust number should be less than P
  //numbers-> input numbers as per N

  //9,8,7,1,5,6 -> 1,5,6,7,8,9
  //    1,5,6
  //    1,6,7
  //    1,7,8
  //    1,8,9
  //    1,9
  //    5,6
  //    5,7
  //    5,8
  //    5,9

  def getTestCases(N:Int, K:Int, P:Int, numbers:List[Int]) : List[List[Int]] = {
    val sorted= numbers.sorted

    val mList = getMultipleList(sorted)

    val aList = arrangeList(mList)

    addElement(aList, sorted).distinct.filter(el => calculateDiff(el, P))

  }

  def calculateDiff(dList: List[Int], dVal: Int): Boolean ={

    @scala.annotation.tailrec
    def getDiff(dList: List[Int], dVal: Int, res: Boolean): Boolean ={
      dList match {
        case Nil | _:: Nil => res
        case head:: tail => getDiff(tail, dVal, res && (tail.head-head)<=dVal)
      }

    }

    getDiff(dList.sorted, dVal, res = true)

  }

  def addElement(mList:List[List[Int]], sorted:List[Int]): List[List[Int]] ={
    @scala.annotation.tailrec
    def addToList(sortedList:List[List[Int]], sorted:List[Int], op:List[List[Int]]): List[List[Int]] = {
      sortedList match{
        case Nil => op
        case head :: Nil => op ++ moreLists(head, sorted.diff(head), Nil)
        case head :: tail => addToList(tail, sorted, op++ moreLists(head, sorted.diff(head), Nil))
      }
    }

    addToList(mList, sorted, List.empty)
  }


  def moreLists(mList:List[Int], sorted:List[Int], op:List[List[Int]]): List[List[Int]] ={

    @scala.annotation.tailrec
    def generateList(ip:List[Int], iList:List[Int], op:List[List[Int]]): List[List[Int]] ={
      ip match{
        case head ::tail => val res = mList ++ List(head)
          generateList(tail, iList, op ++ List(res.sorted))
        case head ::Nil => val res = mList ++ List(head)
          op ++ List(res.sorted)
        case Nil => op
      }
    }

    generateList(sorted, mList, Nil)
  }


  def arrangeList(mList:List[List[Int]]): List[List[Int]] ={
    @scala.annotation.tailrec
    def arrangeAllList(sortedList:List[List[Int]], op:List[List[Int]]): List[List[Int]] = {
      sortedList match{
        case Nil => op
        case head :: Nil => op++anotherRecursion(head, head.head, List.empty)
        case head :: tail => arrangeAllList(tail, op++anotherRecursion(head, head.head, List.empty))
      }
    }

    arrangeAllList(mList, List.empty)
  }

  def getMultipleList(sortedList:List[Int]): List[List[Int]] ={
    @scala.annotation.tailrec
    def generateList(ip:List[Int], op:List[List[Int]]): List[List[Int]] ={
      ip match{
        case Nil | _ :: Nil => op
        case _ :: tail => generateList(tail, op ++ List(tail))
      }
    }

    generateList(sortedList, List(sortedList))
  }

  def anotherRecursion(sortedList:List[Int], h:Int, op:List[List[Int]]): List[List[Int]] ={

    @scala.annotation.tailrec
    def generateList(ip:List[Int], h:Int, op:List[List[Int]]): List[List[Int]] ={
      ip match{
        case head ::tail => generateList(tail, h, op ++ List(List(h, head)))
        case head ::Nil => op ++ List(List(h, head))
        case Nil => op
      }
    }

    generateList(sortedList.tail, sortedList.head, Nil)
  }

}