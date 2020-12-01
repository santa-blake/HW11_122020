import java.io.File

import com.github.tototoshi.csv.{CSVReader, CSVWriter, DefaultCSVFormat}

object UsingScalaCSV extends App {
  println("Going to read some files")
  val filePath = "./src/resources/IS_meta.xml"

  //so optional implicit to change formatting

  val reader = CSVReader.open(new File(filePath))
  //  val res = reader.all()
  //  res.foreach(line => println(line.mkString(",")))

  //as with most streams you only read it once
  val resMap = reader.allWithHeaders()
  resMap.foreach(myMap => for ((k,v) <- myMap) println(s"key: $k, value: $v"))

  def getNumbers(beg: Int=1, end:Int=10) = {
    val mySeq = for (i <- beg to end) yield Seq(i, i*i, i*i*i)
    mySeq
  }
  val myData = getNumbers()
  val saveFile = "./src/resources/power-table.csv"



  def saveNumbers(saveFile: String) = {
    val writer = CSVWriter.open(new File(saveFile))

    writer.writeRow(Seq("number","square","cube"))
    writer.writeAll(getNumbers(1,10))

    writer.close()
  }
  implicit object MyFormat extends DefaultCSVFormat {
    override val delimiter = '#'
  }

  saveNumbers(saveFile)

  saveNumbers("./src/resources/power-table2.csv")

}
