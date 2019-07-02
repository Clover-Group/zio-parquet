package ParquetReader

import zio.{ UIO }

import java.util.{ List => JList }
import parquetBase.Parquet
import parquetBase.ParquetReaderUtils
import org.apache.parquet.example.data.simple.SimpleGroup
//import scala.collection.JavaConverters._

sealed abstract class Reader {

  type TypeData   = JList[SimpleGroup]
  type TypeSchema = JList[org.apache.parquet.schema.Type]

  def getFrame(fin: String): UIO[Parquet]
  def getRows(frame: Parquet): UIO[TypeData]
  def getCols(frame: Parquet): UIO[TypeSchema]
  def getAll(fin: String): UIO[(TypeData, TypeSchema)]  

}

object Reader extends Reader {

  def getFrame(fin: String): UIO[Parquet] = UIO.succeed(ParquetReaderUtils.getParquetData(fin))

  def getRows(frame: Parquet): UIO[TypeData]    = UIO.succeed(frame.getRows)
  def getCols(frame: Parquet): UIO[TypeSchema]  = UIO.succeed(frame.getCols)
  
  def getAll(fin: String): UIO[(TypeData, TypeSchema)] =
    for {
      frame  <- getFrame(fin)
      rows   <- getRows(frame)
      cols <- getCols(frame)
    } yield (rows, cols)

}
