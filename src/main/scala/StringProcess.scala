import scala.io.Source

class StringProcess {

  def getSumOfInts(str:String): Int = {
    if(str.length>0) {
      val f1 = filterStrig _
      val f2 = mapStrig _
      val f3 = addNum _
      (f1 andThen f2 andThen f3)(str)
      //processString(filterStrig, mapStrig, addNum, str)
      //str.filter(_.isDigit).toList.foldLeft(0)(_ + _.toString.toInt)
    } else {
      0
    }
  }
//
//  def filterStrig(str:String): String = str.filter(_.isDigit)
//
//  def mapStrig(x:String): List[Int] = x.map(_.toString.toInt).toList
//
//  def addNum(y:List[Int]): Int = y.sum
//
//  val list = List(1,2,3)
//
//  def doubleValue: Int => Int = (x: Int) => x * x
//
//  val doubledList1: List[Int] = list.map(x => x*x)
//  val doubledList: List[Int] = list.map(x => doubleValue(x))
//
//  def addition(f: (Int, Int) => Int,a: Int, b:Int): Int = f(a,b)
//  val squareSum: (Int, Int) => Int = (x: Int, y: Int) => (x*x + y*y)
//  val cubeSum: (Int, Int) => Int = (x: Int, y: Int) => (x*x*x + y*y*y)
//  val intSum: (Int, Int) => Int = (x: Int, y: Int) => (x + y)
//
//  val squaredSum: Int = addition(squareSum, 1, 2)
//  val cubedSum: Int = addition(cubeSum, 1, 2)
//  val normalSum: Int = addition(intSum, 1, 2)

  def filterStrig(str:String): String = str.filter(_.isDigit)

  def mapStrig(str:String): List[Int] = str.map(_.toString.toInt).toList

  def addNum(x: List[Int]): Int = x.sum

  def processString(f1: String => String,
                    f2: String => List[Int],
                    f3: List[Int] => Int, z:String): Int = f3(f2(f1(z)))

  def getFile: List[String] ={
    val fileStream = getClass.getResourceAsStream("json-sample.js")
    val lines = Source.fromInputStream(fileStream).getLines
    lines.foreach(line => println(line))

    lines.toList
  }
}
