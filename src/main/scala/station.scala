abstract class station {
  val station_european_code: Int
  val station_local_code: Int
  val station_name: String
  val station_description: String

  override def toString = s" $station_european_code $station_local_code in $station_name."


  //  <station_start_date>20-1-2005</station_start_date>
//    <station_latitude_decimal_degrees>65.688890</station_latitude_decimal_degrees>
//    <station_longitude_decimal_degrees>-18.100000</station_longitude_decimal_degrees>
//    <station_latitude_dms>+065°41&apos;20&quot;</station_latitude_dms>
//    <station_longitude_dms>-018°06&apos;00&quot;</station_longitude_dms>
//    <station_altitude>6</station_altitude>
//    <type_of_station>Traffic</type_of_station>
//    <station_type_of_area>urban</station_type_of_area>
//    <station_characteristic_of_zone>commercial</station_characteristic_of_zone>
//    <main_emission_source>Road transport</main_emission_source>
//    <station_area_of_representativeness>15.000</station_area_of_representativeness>
//    <station_city>AKUREYRI</station_city>
//    <population>17.000</population>
//    <street_name>Tryggvabraut/Glerárgata</street_name>
//    <street_type>Wide street: L/H &gt; 1.5</street_type>
//    <number_of_vehicles>20000</number_of_vehicles>
//    <station_lorry_percentage>5.000</station_lorry_percentage>
//    <station_traffic_speed>50.000</station_traffic_speed>
//    <station_street_width>16.000</station_street_width>
//    <monitoring_obj>Exposure assesment (population and/or ecosystems and/or materials)</monitoring_obj>
//    <meteorological_parameter>

//
//  val network_time_reference_basis: String //we could have multiple authors
//  val network_type: String //we could have multiple authors
//  val year: Int //could also use some date format
//  val price: Double //possibly some money related format

  //toString is built in already so we override
//  override def toString = s"${authors.head}: $category $title in $titleLang from $year"

  //TODO investigate how to add newline when saving list of elements
//  def getAuthorSeq() =
//    for (author <- authors) yield <author>
//      {author}
//    </author>

//  //TODO add attributes and author list
//  def toXML = <book category="children">
//    <title lang="en">
//      {title}
//    </title>{getAuthorSeq()}<year>
//      {year}
//    </year>
//    <price>
//      {price}
//    </price>
//  </book>
}
