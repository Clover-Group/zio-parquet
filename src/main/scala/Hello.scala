package hello

import parquetBase.ParquetReaderUtils
import scala.collection.JavaConverters._

object Hello extends App {

  val path = "/tmp/hello.pq"
  //val path = "/tmp/dump0.pq"

  val parquet     = ParquetReaderUtils.getParquetData(path)
  val simpleGroup = parquet.getRows()

  // This accesses a single data type in the frame
  def getDataType(num: Int)() = parquet.getCols().get(num)

  // Custom element read
  println("Reading custom elements")
  val p0    = getDataType(0)
  val p0Val = simpleGroup.get(0)

  val p1    = getDataType(1)
  val p1Val = simpleGroup.get(1)

  println(p0)
  println(p0Val)

  println(p1)
  println(p1Val)

  // Iterate thru the whole list
  println("Looping thru the dump")
  simpleGroup.iterator().asScala.foreach(println)

}
