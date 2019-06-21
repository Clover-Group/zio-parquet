package Reader

import zio.{ UIO }

import parquetBase.Parquet
import parquetBase.ParquetReaderUtils
import org.apache.parquet.example.data.simple.SimpleGroup
//import scala.collection.JavaConverters._

sealed abstract class Reader {

  def getFrame(fin: String): UIO[Parquet]
  def getData(frame: Parquet): UIO[SimpleGroup]
  def getSchema(frame: Parquet): UIO[Int]

}

object Reader {

  type ParquetType = List[SimpleGroup]
  //def apply():UIO[ParquetReaderUtils] = new Reader

  def getFrame(fin: String): UIO[Parquet] = UIO.succeed(ParquetReaderUtils.getParquetData(fin))

  def getData(frame: Parquet)   = UIO.succeed(frame.getData)
  def getSchema(frame: Parquet) = UIO.succeed(frame.getSchema)

}
