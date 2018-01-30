package com.quadstingray.sbt.javafx.model

import sbt.File

import scala.xml.Node

case class SigningSettings(keyStore: Option[File], storePass: Option[String], alias: Option[String], keyPass: Option[String], storeType: Option[String]) {

  def getSigningXml(dir: File): Node = {
    <fx:signjar destdir={dir.getAbsolutePath} keyStore={keyStore.map(_.getAbsolutePath).getOrElse(sys.error("javaFxKeyStore is not defined"))} storePass={storePass.getOrElse(sys.error("javaFxStorePass is not defined"))}
                alias={alias.getOrElse(sys.error("javaFxSigningAlias is not defined"))} keyPass={keyPass.getOrElse(sys.error("javaFxSigningKeyPass is not defined"))} storeType={storeType.getOrElse("jks")}>
      <fx:fileset dir={dir.getAbsolutePath}/>
    </fx:signjar>
  }

}
