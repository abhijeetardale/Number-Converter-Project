class BritishCurrency {

  private val  BritishCurrency = List(
    ("£2", 200),
    ("£1", 100),
    ("50p", 50),
    ("20p", 20),
    ("10p", 10),
    ("5p", 5),
    ("2p", 2),
    ("1p", 1)
  )

  def makeChange(number: Int) : List[String] = BritishCurrency.foldLeft((List[String](), number)){
    case ((sb, num), (coinVal, currencyVal)) =>(sb ++ appendElement((num / currencyVal), coinVal), num % currencyVal)
  }._1


  private def appendElement(count:Int, item : String): List[String] = Range(0, count).toList.foldLeft(List[String]())((temp,_)=> (temp ++ List(item)))

/*  private def appendElement1(count:Int, item : String): List[String] = {
    def append(count:Int, temp:List[String]): List[String] = count match {
      case 0 => temp
      case _ => append(count-1, temp ++ List(item))
    }
    append(count, List())
  }*/

  def makePossibleChangeWithAvailableCoins(number: Int, availableCoins:List[String]) : List[String] = BritishCurrency.foldLeft((List[String](), number)){
    case ((sb, num), (coinVal, currencyVal)) => {
      val requiredCoins = appendElement((num / currencyVal), coinVal)
      val possibleCoins = availableCoins.intersect(requiredCoins)
      (sb ++ possibleCoins, ((num % currencyVal) + ((requiredCoins.length - possibleCoins.length) * currencyVal)))
    }
  }._1

  def addList(numList: List[Int]): Int ={
    def append(count:Int, temp:List[Int]): Int = temp match {
      case Nil => count
      case head::Nil => count+head
      case head::tail if(head==tail.head) => append(count, tail)
      case head::tail => append(count+head, tail)
    }
    append(0, numList)
  }
//
//  def addList(numList: List[Int]): Int ={
//
//    numList.foldLeft((0,0))((x,y) => {
//      if(x._1==y) (y,x._2) else (y,x._2+y)
//    })._2
//
//  }


}
