import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.util.*

class PropertiesFile(private val pathName: String) {

  var prop = getProperties()

  private fun getProperties(): Properties {
    return if (existsPropertiesFile()) readPropertiesFile() else createPropertiesFile()
  }

  private fun existsPropertiesFile(): Boolean {
    return File(pathName).exists()
  }

  private fun readPropertiesFile(): Properties {
    val properties = Properties()
    properties.load(File(pathName).inputStream())
    return properties
  }

  private fun createPropertiesFile(): Properties {
    var prop = Properties()
    prop["INPUT"] = ""
    prop["OUTPUT"] = ""
    prop["ERROR"] = ""
    prop["SUCCESS"] = ""

    val os = FileOutputStream("config.properties")
    val osw = OutputStreamWriter(os, Charsets.UTF_8)
    prop.store(osw, null)

    os.close()
    osw.close()

    return prop
  }
}

