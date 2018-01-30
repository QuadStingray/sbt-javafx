package com.quadstingray.sbt.javafx.model

import scala.xml.Node

case class JavaPlatformSettings(javafx: Option[String], j2se: Option[String], jvmargs: Seq[String], jvmuserargs: Seq[(String, String)], properties: Seq[(String, String)]) {

  def getXML: Node = {
    <fx:platform id="platform" javafx={javafx.getOrElse("")} j2se={j2se.getOrElse("")}>
      {jvmargs.map({ value =>
        <fx:jvmarg value={value}/>
    })}{jvmuserargs.map({
      case (name, value) =>
          <fx:jvmuserarg name={name} value={value}/>

    })}{properties.map({
      case (name, value) =>
          <fx:property name={name} value={value}/>

    })}
    </fx:platform>
  }

}
