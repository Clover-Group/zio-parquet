package ParquetReader

import zio.{ Chunk }

import parquetBase.Parquet
import parquetBase.ParquetReaderUtils

import ParquetPkg._

sealed abstract class Reader {

  def getFrame(fin: String): Chunk[Parquet]
  def getRows(frame: Parquet): Chunk[TypeData]
  def getCols(frame: Parquet): Chunk[TypeSchema]
  def getAll(fin: String): Chunk[(TypeData, TypeSchema)]

}

object Reader extends Reader {

  def getFrame(fin: String): Chunk[Parquet] = Chunk.succeed(ParquetReaderUtils.getParquetData(fin))

  def getRows(frame: Parquet): Chunk[TypeData]   = Chunk.succeed(frame.getRows)
  def getCols(frame: Parquet): Chunk[TypeSchema] = Chunk.succeed(frame.getCols)

  def getAll(fin: String): Chunk[(TypeData, TypeSchema)] =
    for {
      frame <- getFrame(fin)
      rows  <- getRows(frame)
      cols  <- getCols(frame)
    } yield (rows, cols)

}
