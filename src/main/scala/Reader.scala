package ParquetReader

import zio.{ UIO }

import parquetBase.Parquet
import parquetBase.ParquetReaderUtils

import ParquetPkg._

sealed abstract class Reader {  

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
