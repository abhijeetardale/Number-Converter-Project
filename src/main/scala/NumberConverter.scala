/**
 * Roman Numbers are 1- 3999
 * conversion logic ->
 * 1st find the position the list and get the count for the Roman character and get reminder for the next Roman character
 * 250 -> 2*C and 50%
 * 50 -> 1*L and 0%
 */


/*
800

(M*(800/1000))+ (("CM", 900)), 800%1000
  (CM*(800/900))+ (("D", 500)), 800%900
    (D*(800/500))+ (("CD", 400)), 800%500
      (CD*(300/400))+ (("C", 100)), 300%400
        (C*(300/100))+ (("C", 100)), 300%100
          (XC*(0/90))+ (("XC", 90)), 0%90
            (L*(0/50))+ (("L", 50)), 0%30
              (XL*(0/40))+ (("XL",40)), 0%40
                (X*(0/10))+ (("X", 10)), 0%10
                  (IX*(0/9))+ (("IX", 9)), 0%9
                    (V*(0/5))+ (("V", 5)), 0%5
                      (IV*(0/4))+ (("IV", 4)), 0%4
                        (I*(0/1))+ (("I", 1)), 0%1

= ""+""+"D"+""+"C"+""+""+""+X+""+V+"+I+I

17

(M*(17%1000))+(CM*(17%900))+(D*(17%500))+(CD*(17%400))+(C*(17%100))+(XC*(17%90))+(L*(17%50))+(XL*(17%40))+(X*(17%10))+(IX*(7%9))+(V*(7%5))+(IV*(2%4))+(I*(2%1))+(I*(1%1))
= ""+""+""+""+""+""+""+""+X+""+V+"+I+I
*/

class NumberConverter {

  val romanList = List(("M", 1000), ("CM", 900), ("D", 500), ("CD", 400), ("C", 100), ("XC", 90), ("L", 50), ("XL", 40), ("X", 10), ("IX", 9), ("V", 5), ("IV", 4), ("I", 1))

  def romanNumberConverter(number: Int): String = {

    var tempNumber = number

    val sb = new StringBuilder()

    romanList.map { element =>

      sb.append(element._1 * (tempNumber / element._2))

      tempNumber = tempNumber % element._2
    }

    sb.toString()

  }


  def romanNumberConverter1(number: Int): String = {

    val moduloCount = romanList.scanLeft(number)((num: Int, element: (String, Int)) => num % element._2)

    //println("######### moduloCount" + moduloCount)

    val result = for ((element, reminder) <- (romanList zip moduloCount)) yield {

      element._1 * (reminder / element._2)

    }

    //println("######### result" + result)

    result.foldLeft("") { (sb, s) => sb + s}
  }

  def arabicNumberConverter(romanNumber: String): Int = {

    romanList.filter(x => x._1 == romanNumber).foldLeft(0) { (sb, s) => sb + s._2}

    romanNumber.map{
      c=> getArabicValue(romanNumber,c)
    }.foldLeft(0)(_+_)

  }

  def getArabicValue(romanNumber: String, num:Char): Int ={

    romanNumber(romanNumber.indexOf(num)) match {
      case 'I' if(romanNumber.size > romanNumber.indexOf(num)+1 && (romanNumber(romanNumber.indexOf(num)+1)=='V' || romanNumber(romanNumber.indexOf(num)+1)=='X')) => - romanList.find(x => x._1 == num.toString).get._2
      case 'X' if(romanNumber.size > romanNumber.indexOf(num)+1 && (romanNumber(romanNumber.indexOf(num)+1)=='L' || romanNumber(romanNumber.indexOf(num)+1)=='C')) => - romanList.find(x => x._1 == num.toString).get._2
      case 'C' if(romanNumber.size > romanNumber.indexOf(num)+1 && (romanNumber(romanNumber.indexOf(num)+1)=='D' || romanNumber(romanNumber.indexOf(num)+1)=='M')) =>  - romanList.find(x => x._1 == num.toString).get._2
      case _ => romanList.find(x => x._1 == num.toString).get._2
    }
  }

}
