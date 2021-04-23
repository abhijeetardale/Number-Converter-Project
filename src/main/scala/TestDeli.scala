object TestDeli extends App {

	val expression1 = "6+9-12"
	val expression2 = "1+2-3+4-5+6-7"
	val expression3 = "100+200+300"
	val expression4 = "1-2-3-0"
	val expression5 = "255"
	val expression6 = "0-1-2-3"


	def mathsOperation(op1:Int, op2:Int, opList:List[Char]): Int ={
		opList match {
			case op :: Nil if op == '+'=> op1 + op2
			case op :: Nil if op == '-'=> op1 - op2
			case Nil => op2
		}
	}

	def calculate(input: String) : Unit = {

		def rec(inputString:List[Char], numList:List[Int], opList:List[Char], counter:Int): Int = {

			inputString match {
				case head::Nil =>
					val (headerList, combine) = (numList++List(head.toString.toInt)).splitAt(numList.length-counter)
					mathsOperation(headerList.head, combine.mkString.toInt, opList)
				case head::tail =>
					if(head == '+' || head == '-') {
						val (headerList, combine) = numList.splitAt(numList.length-counter)
						if(opList.nonEmpty){
							rec(tail, List(mathsOperation(headerList.head, combine.mkString.toInt, opList)) , List(head), 0)
						} else{
							rec(tail, headerList++List(combine.mkString.toInt) , List(head), 0)
						}
					} else {
						rec(tail, numList++List(head.toString.toInt), opList, counter+1)
					}
			}

		}

		val result = rec(input.toList, Nil, Nil, 0)

		println(input)
		println(result)

	}

	calculate(expression3)

}
