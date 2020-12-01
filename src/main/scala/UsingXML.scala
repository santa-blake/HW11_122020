import java.awt.print.Book

import scala.xml.{Node, NodeSeq}
import scala.xml.XML.loadFile

  object UsingXML extends App {

    val airbase = loadFile("./src/resources/IS_meta.xml") // built in xml loading AND parsing
    //  println(airbase)

    val countries = airbase \ "country"
    val country_name = for (country <- countries) yield (country \ "country_name").text
    println("Country observed:")
    country_name.foreach(println)
    //val countryName = (airbase \\ "country_name").map(it => it.text)
    //countryName.foreach(println)

    println("")

    println("Stations in this country:")
    val stations = airbase \ "station_info"
    //val station_name = for (station <- stations) yield (station \ "station_name").text
    val station_name = (airbase \\ "station_name").map(it => it.text)
    station_name.foreach(println)

    println("")

    def getStationInfoFromEl(el:Node): station = {
      new station {
        val station_european_code = (el \ "station_european_code").text.toInt
        val station_local_code = (el \ "station_local_code").text.toInt
        val station_name = (el \ "station_local_code").text
        val station_description = (el \ "station_description").text
      }
    }
// val station1 = getStationInfoFromEl(stations(0))
// print(station1)

    //deserialization of XML into our internal data forma
    def getStationList(stationNodes: NodeSeq): Seq[station] = {
      for (station <- stationNodes) yield getStationInfoFromEl(station)
    }

    val stationList = getStationList(stations)
    println("Station information in lists by each:")
    stationList.foreach(println)

    //println(stations(0))

    val stationDescription = for (station <- stations) yield station \ "station_description"
    stationDescription.foreach(println)


    //  dirPrices.foreach(println)
    //  val hp = (bookstore \ "books").filter(item => item.attribute.get("category") == "children")
    //  val hp = books.filter(_.attribute("category").contains("children")) //TODO flatten

    val stationInfo = (airbase \\ "station_info").map(it => it.text)
    stationInfo.foreach(println)

    val hp = (airbase \\ "country" filter {
      _ \\ "@category" exists (_.text == "children")
    }).text
    //  println(hp)
    val webBooks = airbase \\ "country" filter {
      _ \\ "@category" exists (_.text == "web")
    }
    //  //so we can save our book collection by adding some parent element for example root
    //  save("./src/resources/webBooks.xml", <bookstore>{webBooks}</bookstore>, xmlDecl = true)

    //  println(webBooks)
    //  println(books.head.attribute("category"))
    //  println(books.head.attributes)
    //  val cat = books.head.attribute("category")
    //  println(cat)

    val myBook = new Book {
      val category = "childrens"
      val title = "Happy Potter"
      val titleLang = "en"
      val authors = List("J.K. Rowling", "Richard Galbraith")
      val year = 1997
      val price = 19.95
    }
    //  println(myBook.toXML)
    //  save("./src/resources/mybook.xml", myBook.toXML, xmlDecl = true)
  }