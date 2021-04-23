
import scala.collection.immutable.{HashMap, ListMap}

val fruit: List[String] = List("apples", "oranges", "pears")

val dim: List[List[Int]] =
	List(
		List(1, 0, 0),
		List(0, 1, 0),
		List(0, 0, 1)
	)

for(i<-0 to 2) {
	for(j<-0 to 2) {
		if(dim(i)(j) == 0) {
			println("Hello : " + dim(i)(j))
		}
	}
}

val fruit1 = "apples" :: "oranges" :: "pears" :: Nil
val fruit2 = "mangoes" :: ("banana" :: Nil)
var fruit = fruit1 ::: fruit2 ++  List("a")

List.fill(3)("apples")

val x1 = List.tabulate(2,6)((x,n) => n + x + 1)
val x = List.tabulate(2,6)((x,n) => n + x + 1).flatten.distinct.sorted.reverse
x.min
x.max
x.sum

x.drop(4)

x.take(4)



fruit1 intersect fruit2

fruit1 union fruit2

fruit1 diff fruit2

fruit2 diff fruit1

(1 to 5).toList
(1 until 5).toList
(1 to 10).toList.slice(1,5)

val hashMap = HashMap("C"->"Csharp", "S"->"Scala", "J"->"Java")

// Iterating elements
hashMap.foreach
{
	case (key, value) => println (key + " -> " + value)
}
var listMapName = ListMap("k1"->"v1", "k2"->"v2", "k3"->"v3")

listMapName.foreach
{
	case (key, value) => println (key + " -> " + value)
}

val numbers = List(5, 4, 8, 6, 2)

numbers.fold(1) { (z, i) =>
	z + i
}

