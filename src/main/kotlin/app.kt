import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import java.io.FileInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory


fun main() {
  var prop = PropertiesFile("config.properties").prop

  println(
    prop.forEach { k, v ->
      if (k == "INPUT")
        println("Key : $k \nValue : $v")
    }
  )

  val xmlReader = XMLReader("00776574000903_3_1734769.xml")
  println("Primeiro elemento: "+xmlReader.getRootElement().nodeName)
}
