class SeggezzaTest {


  // Complete the birthday function below.
  def birthday(s: Array[Int], d: Int, m: Int): Int = {

    def checkList(numList: Array[Int], day: Int, month: Int, seg:Int) : Int = {
      numList.toList match{
        case Nil => seg
        case x if(x.size >= month) => if(numList.take(month).sum == day) {
          checkList(numList.tail, day, month, seg+1)
        } else{
          checkList(numList.tail, day, month, seg)
        }
        case _ => seg
      }
    }
    checkList(s, d, m, 0)
  }

  def separateNumbers(s: String) : String =  {

    println(processStringList(s.map(_.toString).toList))
    processStringList(s.map(_.toString).toList)

  }

  private def processStringList(numList: List[String]) : String =  {

    def checkList(numList: List[String], smallNumber: Int, len:Int, seg:String) : String = {
      numList match{
        case Nil => seg
        case _ if(numList.size/2 >= len) => val res = numList.splitAt(len)
          if(checkDiff(res._2.take(len).mkString(""), res._1.mkString(""))) {
            checkList(res._2, smallNumber, len, s"YES $smallNumber")
          } else if(checkDiff(res._2.take(len+1).mkString(""), res._1.mkString(""))) {
            checkList(res._2, smallNumber, len+1, s"YES $smallNumber")
          } else {
            checkList(numList, numList.take(len+1).mkString("").toInt, len+1, s"NO")
          }
        case _ => seg
      }
    }

    checkList(numList, numList.head.toInt, 1, s"NO")

  }

  private def checkDiff(s1:String, s2: String) : Boolean = {
    (s1.mkString("").toInt - s2.mkString("").toInt) == 1 && !(s1.startsWith("0") || s2.startsWith("0"))
  }

  // Complete the alternate function below.
  def alternate(s: String): Int = {
    val dCount = s.toList.distinct.size -2
    val perList = s.toList.distinct.combinations(dCount).toList
    def createPerList(per:List[List[Char]], list:List[Char]): Int ={
      per match {
        case Nil => list.size
        case head :: tail => val res = s.toList.filterNot(head.contains(_))
          val sz = res.size
          val lSize = (res.indices.collect { case i if i % 2 == 1 => res(i) }).toList.distinct.size
          val rSize = (res.indices.collect { case i if i % 2 == 0 => res(i) }).toList.distinct.size
          if(lSize==1 && rSize==1){
            createPerList(tail, if(sz<=list.size) list else res)
          } else createPerList(tail, list)
        case _ => list.size
      }
    }
    createPerList(perList, List.empty)
  }

  def missingNumbers(arr: Array[Int], brr: Array[Int]): Array[Int] = {
      def getRes(b: Array[Int], a: Array[Int], res:Array[Int]): Array[Int] = {
      b.toList match {
        case Nil => res
        case head :: tail =>
          if(a.contains(head)) {
            getRes(tail.toArray, a.tail, res)
          } else {
            getRes(tail.toArray, a, res++Array(head))
          }
      }
    }
    getRes(brr.sorted, arr.sorted, Array[Int]())
  }

}
