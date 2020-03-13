name := "Number-Converter-Project"

version := "1.0"

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
	"junit" % "junit" % "4.12" % "test",
	"com.novocode" % "junit-interface" % "0.11" % "test",
	"org.specs2" %% "specs2-core" % "3.8.4" % "test",
	"org.scalatest" %% "scalatest" % "3.0.0" % "test",
	"org.scalacheck" %% "scalacheck" % "1.14.0" % "test"
)

