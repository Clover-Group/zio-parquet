package Reader

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
  def getData(frame: Parquet): UIO[TypeData]
  def getSchema(frame: Parquet): UIO[TypeSchema]
  def getAll(fin: String): UIO[(TypeData, TypeSchema)]

}

object Reader extends Reader {

  def getFrame(fin: String): UIO[Parquet] = UIO.succeed(ParquetReaderUtils.getParquetData(fin))

  def getData(frame: Parquet): UIO[TypeData]     = UIO.succeed(frame.getData)
  def getSchema(frame: Parquet): UIO[TypeSchema] = UIO.succeed(frame.getSchema)

  def getAll(fin: String): UIO[(TypeData, TypeSchema)] =
    for {
      frame  <- Reader.getFrame(fin)
      data   <- Reader.getData(frame)
      schema <- Reader.getSchema(frame)
    } yield (data, schema)

}
