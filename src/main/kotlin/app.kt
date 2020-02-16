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

  val file = File("00776574000903_3_1734769.xml")
  val fileIS = FileInputStream(file)
  val builderFactory = DocumentBuilderFactory.newInstance()
  val builder = builderFactory.newDocumentBuilder()

  val xmlDocument: Document = builder.parse(fileIS)
  val xPath = XPathFactory.newInstance().newXPath()
  val expression = "//nfeProc/NFe/infNFe/emit"
  val nodeList = xPath.compile(expression).evaluate(
    xmlDocument, XPathConstants.NODESET
  ) as NodeList

  for (i in 0 until nodeList.length) {
    val nNode: Node = nodeList.item(i)
    System.out.println("\nCurrent Element Name:" + nNode.getNodeName())

    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
      val eElement: Element = nNode as Element
      var value = eElement.getElementsByTagName("CNPJ").item(0).getTextContent()
      System.out.println("\nCurrent Element Value:" + value)
    }
  }
}
