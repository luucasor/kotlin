fun main() {
    var prop = PropertiesFile("config.properties").prop

    println(
      prop.forEach {
        k, v -> if (k == "INPUT")
        println("Key : $k \nValue : $v")
      }
    )
}






