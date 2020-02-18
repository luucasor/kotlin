import org.w3c.dom.Document
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import java.io.FileInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.xpath.XPathConstants
import javax.xml.xpath.XPathFactory

class XMLReader (pathName: String){

  val file = File(pathName)
  val fileIS = FileInputStream(file)
  val builderFactory = DocumentBuilderFactory.newInstance()
  val builder = builderFactory.newDocumentBuilder()

  val xmlDocument: Document = builder.parse(fileIS)
  val xPath = XPathFactory.newInstance().newXPath()
  val expression = "//*"
  val nodeList = xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET) as NodeList

  fun getRootElement(): Node {
    return nodeList.item(0)
  }

  //  for (i in 0 until nodeList.length) {
//    val nNode: Node = nodeList.item(i)
//    System.out.println("\nCurrent Element Name:" + nNode.getNodeName())
//
//    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//      val eElement: Element = nNode as Element
//      println(eElement.nodeName)
//      //var value = eElement.getElementsByTagName("CNPJ").item(0).getTextContent()
//      //System.out.println("\nCurrent Element Value:" + value)
//    }
//  }
}
