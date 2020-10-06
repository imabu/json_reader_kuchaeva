resolvers += "Spark Packages Repo" at "http://dl.bintray.com/spark-packages/maven"

name := "json_reader_kuchaeva"

version := "0.0.1"

scalaVersion := "2.11.8"

dependencyOverrides ++= {
  Seq(
    "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.6.7.1",
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.6.7",
    "com.fasterxml.jackson.core" % "jackson-core" % "2.6.7"
  )
}
libraryDependencies ++= Seq("org.apache.spark" %% "spark-sql" % "2.4.4" % "provided",
  "org.json4s" %% "json4s-jackson" % "3.2.11")

