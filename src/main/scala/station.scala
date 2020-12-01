abstract class station {
  val station_european_code: Int
  val station_local_code: Int
  val station_name: String
  val station_description: String

  override def toString = s" $station_european_code $station_local_code in $station_name."

  <station_info>
    <station_european_code>LV0010R</station_european_code>
    <station_local_code>LV10</station_local_code>
    <station_name>Rucava</station_name>
    <station_description>Station is situated in the south-west part of Latvia (Seaside Lowland), some 10 km east from the Baltic Sea and 50 km south from the sity of Liepaja</station_description>
    <station_nuts_level0>LV</station_nuts_level0>
    <station_nuts_level1>0</station_nuts_level1>
    <station_nuts_level2>0</station_nuts_level2>
    <station_nuts_level3>3</station_nuts_level3>
    <lau_level1_code>640000</lau_level1_code>
    <lau_level2_code>648400</lau_level2_code>
    <lau_level2_name>Rucavas pagasts</lau_level2_name>
    <sabe_country_code>LV</sabe_country_code>
    <sabe_unit_code>6484</sabe_unit_code>
    <sabe_unit_name>Rucavas pag.</sabe_unit_name>
    <station_start_date>7-1-1985</station_start_date>
    <station_latitude_decimal_degrees>56.162000</station_latitude_decimal_degrees>
    <station_longitude_decimal_degrees>21.173100</station_longitude_decimal_degrees>
    <station_latitude_dms>+056°09&apos;43&quot;</station_latitude_dms>
    <station_longitude_dms>+021°10&apos;23&quot;</station_longitude_dms>
    <station_altitude>18</station_altitude>
    <type_of_station>Background</type_of_station>
    <station_type_of_area>rural</station_type_of_area>
    <station_characteristic_of_zone>agricultural/natural</station_characteristic_of_zone>
    <station_subcategory_rural_background>regional</station_subcategory_rural_background>
    <monitoring_obj>Compliance monitoring for national legislation</monitoring_obj>
    <monitoring_obj>Trend analysis</monitoring_obj>
    <monitoring_obj>International programmes (EMEP, GAW...)</monitoring_obj>
    <meteorological_parameter>Conductivity</meteorological_parameter>
    <meteorological_parameter>pH</meteorological_parameter>
    <meteorological_parameter>Wind velocity</meteorological_parameter>
    <meteorological_parameter>Wind direction</meteorological_parameter>
    <meteorological_parameter>Pressure</meteorological_parameter>
    <meteorological_parameter>Temperature</meteorological_parameter>
    <meteorological_parameter>Relative humidity</meteorological_parameter>
    <meteorological_parameter>Duration of sunlight</meteorological_parameter>
    <meteorological_parameter>Precipitation</meteorological_parameter>
    <meteorological_parameter>Direct solar radiation</meteorological_parameter>
    <meteorological_parameter>Global radiation</meteorological_parameter>
  </station_info>


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
