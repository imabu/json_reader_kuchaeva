package com.github.json_reader

import org.apache.spark.sql.SparkSession
import org.json4s._
import org.json4s.jackson.Serialization.read

object JsonReader {

  case class Wine(id: Option[Int], country: Option[String], points: Option[Int], price: Option[Float],
                  title: Option[String], variety: Option[String], winery: Option[String])

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .master("local[*]")
      .appName("json reader")
      .getOrCreate()

    val filePath = args(0)
    val jsonTextRdd = spark.sparkContext.textFile(filePath)

    val rdd = jsonTextRdd.mapPartitions(a => {
      implicit val formats = DefaultFormats
      a.map(v => read[Wine](v))
    })

    rdd.collect().foreach(println)
  }
}
