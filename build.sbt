import sbt._

organization := "com.flipkart.connekt"

name := "concord"

version := "0.1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe" % "config" % "1.3.0",
  "org.slf4j" % "slf4j-api" % "1.7.13"
)

resolvers ++= Seq(
  "mavenCentral" at "http://repo1.maven.org/maven/"
)

pomExtra :=
  <licenses>
    <license>
      <name>MIT License</name>
      <url>https://opensource.org/licenses/MIT</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>https://github.com/Flipkart/concord.git</url>
  </scm>
  <developers>
    <developer>
      <id>phantomastray</id>
      <name>Durga Sahoo</name>
    </developer>
    <developer>
      <id>kingster</id>
      <name>Kinshuk Bairagi</name>
    </developer>
  </developers>

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
