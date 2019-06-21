package Reader

import zio.{ UIO }

import parquetBase.ParquetReaderUtils
//import scala.collection.JavaConverters._

sealed abstract class Reader {

  def getSource(fin: String): UIO[ParquetReaderUtils]
  def getData(): Unit
  //def getSchema()

}

object Reader {

  def getSource(fin: String) = UIO.succeed(ParquetReaderUtils.getParquetData(fin))
  //def getData():Unit =

}
