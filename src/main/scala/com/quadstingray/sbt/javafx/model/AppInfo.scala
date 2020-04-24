package com.quadstingray.sbt.javafx.model

import scala.xml.Node

case class AppInfo(mainClass: String,
                   vendor: String,
                   title: String,
                   appVersion: String,
                   category: String,
                   copyright: String,
                   description: String,
                   license: String) {

  def getApplicationXML: Node = {
    if (mainClass.equalsIgnoreCase("")) {
      sys.error("javaFxMainClass not defined")
    }
    <fx:application id={title} name={title} version={appVersion} mainClass={mainClass}/>
  }

}
