import scala.xml.XML.loadFile
import scala.xml.{Node, NodeSeq}

  object UsingXML extends App {

    val airbase = loadFile("./src/resources/IS_meta.xml") // built in xml loading AND parsing
    //  println(airbase)

    println("Country observed:")
    val countries = airbase \ "country"
    val country_name = for (country <- countries) yield (country \ "country_name").text
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

    println("Station information in lists by each:")
    val stationList = getStationList(stations)
    stationList.foreach(println)
        val stationInfo = (airbase \\ "station_info").map(it => it.text)
        stationInfo.foreach(println)
    // println(stations(0))

//    val stationDescription = for (station <- stations) yield station \ "station_description"
//    stationDescription.foreach(println)

    println("Station descriptions:")
    val stationDescr2 = (airbase \\ "station_description").map(it => it.text)
    stationDescr2.foreach(println)

    //  println(myBook.toXML)
    //  save("./src/resources/mybook.xml", myBook.toXML, xmlDecl = true)
  }