import scala.io.Source

class StringProcess {

  def maxHeight(wallPositions: Array[Int], wallHeights: Array[Int]): Int = {

    if(wallPositions.isEmpty && wallHeights.isEmpty) {
      0
    } else if(wallPositions.isEmpty) {
      0
    } else {
      val wallSegs = fillArray(wallPositions.reverse.head, wallPositions)
      wallSegs.max
    }
  }

  def fillArray(s:Int, wallPositions: Array[Int]): Seq[Int] ={

    def rec(w:Seq[Int], size:Int) : Seq[Int] ={
      if(size==s) w
      else if(wallPositions.contains(s)) {
        rec(w++Seq(s), size+1)
      } else {
        rec(w++Seq(0), size+1)
      }
    }
    rec(Seq(), s)
  }

  def updateArray(wallPositions: Array[Int], wallHeights: Array[Int]): Seq[Int] ={

    def rec(w:Seq[Int], size:Int) : Seq[Int] ={
      if(size==wallPositions.length) w
      else {
        wallPositions.toSeq match{
          case x::Nil => Seq(x)
          case x::y::Nil => Seq()
          case x::y::z::Nil => Seq()
        }
      }
    }
    rec(Seq(), 0)
  }


  def isPossible(a: Int, b: Int, c: Int, d: Int): String = {
    def rec(p: Int, q: Int): String = {
      val (x, y) = if(a+b<=c) (a+b, b) else (a, a+b)
      (x, y) match {
        case (_,_) if x==c && y==d => "Yes"
        case (_,_) if x>=c && y>d => println(s"$x, $y")
          "No"
        case (_,_) if x>c && y>=d => println(s"$x, $y")
          "No"
        case (_,_) if x>c || y>=d => println(s"$x, $y")
          "No"
        case (_,_)  => rec(x, y)
      }
    }
    if(Seq(a, b, c, d).exists(x => x < 0 || x > 1001)){
      "No"
    } else if (a==c && b==d)
      "Yes"
    else {
      rec(a, b)
    }

  }

  def fizzBuzz(n: Int): Unit= {
    def rec(next:Int, last:Int): Unit ={
     if(next<=last){
       val res = next match {
         case _ if next%3==0 && next%5==0 => "FizzBuzz"
         case _ if next%3==0 => "Fizz"
         case _ if next%5==0 => "Buzz"
         case _ => next.toString
       }
       println(res)
       rec(next+1,last)
     } else{  }
    }
    rec(1, n)
  }

  def getSumOfInts(str:String): Int = {
    if(str.nonEmpty) {
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
