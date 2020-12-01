import ujson.{Bool, Num, Str}
import upickle.default._

import scala.io.Source

object UsingPickle extends App{
  println("Let's work with some JSON!")

  println(write(Seq(1, 2, 3))) //so we gain an ability to encode our Scala data structures into JSON strings


  //  def getNumbers(beg: Int=1, end:Int=10) = {
  //    val mySeq = for (i <- beg to end) yield Seq(i, i*i, i*i*i)
  //    mySeq
  //  }
  //
  //  println(write(getNumbers()))

  //TODO print JSON of a list of Maps with each map containing key number->value, square->value squared and
  //cube -> number cubed

  //  case class Thing(number: Int, square: Int, cube: Int)
  //  object Thing{
  //    implicit val rw: RW[Thing] = macroRW
  //  }
  //
  //  val myNumbers = getNumbers(1,10)
  //  for (line <- myNumbers) println(write(Thing(line(0), line(1), line(2))))
  //  val myThings = for (line <- myNumbers) yield Thing(line(0), line(1), line(2))
  //  println(write(myThings))
  //
  ////  import java.nio.file.Files
  //  val pw = new PrintWriter(new File("mydata.json" ))
  //  pw.write(write(myThings,indent = 2))
  //  pw.close()
  //
  //  val fileContents = Source.fromFile("./src/resources/todo.json").getLines.mkString //so this leaves file open
  //  println(fileContents)
  //  val myData = read[Seq[Map[String,String]]](fileContents) //FIXME how to read arbitrary objects
  //  println(myData.getClass)

  //  val myJSON = Source.fromFile("./src/resources/mydata.json").getLines.mkString
  //  val myData = read[Seq[Map[String,Int]]](myJSON)
  //  myData.foreach(println)

  val todoJSON = Source.fromFile("./src/resources/european-union-countries.json").getLines.mkString
  val rawData = read[ujson.Value](todoJSON)
  println(rawData)
  val todoSeq = rawData.arr
  todoSeq.foreach(println)
  val myMaps = todoSeq.map(_.obj)
  println(myMaps(1))
  println(myMaps(1)("title"))

  val rawSeq = read[Seq[ujson.Value]](todoJSON)
  rawSeq.foreach(println)
  val todoData = read[Seq[Map[String,ujson.Value]]](todoJSON)
  todoData.foreach(println)
  todoData.foreach(obj => {
    for ((k,v) <- obj) print(s"k:$k -> v:$v " )
    println("")
  })

  def checkObj(obj: ujson.Value): Unit = {
    obj match {
      case Num(value) => println(s"Got number! $value ")
      case Str(value) => println(s"Got String! $value ")
      case Bool(value) => println(s"Got Boolean! $value ")
      case _ => println("Need to work on covering more cases")
    }
  }
  val firstMap = todoData(0)
  for ((k,v) <- firstMap) {
    checkObj(v)
  }
}