

object ParsingJSON extends App {
    //TODO parse MOCK_DATA.json
    //Get gender balance Male/Female
    //Get most popular first names
    val fileName = "european-union-countries.json"
//    val jsonString = os.read(os.pwd / "src" / "resources" / fileName)
//    println(jsonString.size)
//    val jsonBlob = read[ujson.Value](jsonString)
//    val seqMap = read[Seq[Map[String,ujson.Value]]](jsonString)

    def getPersonSeq(seqMap:Seq[Map[String,ujson.Value]]) : Seq[APerson] = {
      seqMap.map(p => APerson(p("id").num.toInt, p("first_name").str, p("last_name").str, p("email").str, p("gender").str, p("ip_address").str))
    }
//    val personSeq = getPersonSeq(seqMap)
//
//    //TODO filter values out
//    val males = personSeq.count(_.gender == "Male")
//    val females = personSeq.count(_.gender == "Female") // maybe there others...
//    println(s"Out of ${personSeq.size} persons there are $males males and $females females ")
//    val freqMapUnsorted = personSeq.groupBy(_.first_name).view.mapValues(_.size) //so gives us unsorted frequency mapping of groupBy value and its frequency
//    val freqMap = freqMapUnsorted.toSeq.sortBy(_._2).reverse
//    freqMap.slice(0,10).foreach(println)
  }

  case class APerson(id:Int,first_name:String,last_name:String,email:String,gender:String,ip_address:String)
