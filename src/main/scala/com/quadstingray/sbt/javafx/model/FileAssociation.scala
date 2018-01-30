package com.quadstingray.sbt.javafx.model

import scala.xml.Elem

case class FileAssociation(extension: String = "", mimetype: String = "", description: String = "") {
  def getXml: Elem = <fx:association extension={extension} mimetype={mimetype} description={description}/>
}
