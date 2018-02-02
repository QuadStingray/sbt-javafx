# Signing Settings
Digitally signs an application JAR file with a certificate.

Signs the JAR file as BLOB. In other words, instead of every entry being signed separately, the JAR file is signed as a single binary object.

This is a new signing method in JavaFX. For traditional signing, the standard Ant signjar task should be used. See: [Oracle JavaFX documentation](https://docs.oracle.com/javafx/2/deployment/javafx_ant_task_reference.htm#CIADDAEE)


## javaFxPermissions
```scala
import com.quadstingray.sbt.javafx.model.Permissions
javaFxPermissions := Permissions(elevated = true, cacheCertificates = false)
```

## KeyStore
Keystore file name
```scala
javaFxKeyStore := Some("path/to/keystore")
```

## Store Password
Password to check integrity of the keystore or unlock the keystore

```scala
javaFxStorePass := Some("somepassword")
```

## Signing Alias
The alias for the key
```scala
javaFxSigningAlias := Some("alias")
```

## KeyPass
Password for the private key
```scala
javaFxSigningKeyPass := Some("somekeypass")
```

## Keystore type
```scala
javaFxSigningKeyStoreType := Some("jks")
```

