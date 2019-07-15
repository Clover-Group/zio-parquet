package parrrtest

import org.specs2._

import zio.{ Chunk, DefaultRuntime}
import ParquetPkg._
import ParquetReader._

class NetSpec extends Specification with DefaultRuntime {

  // Read parquet data
  val path = "/tmp/hello.pq"

  val rows: Chunk[(Int, TypeData)] =
    for {
      frame <- Reader.getFrame(path)
      size  = frame.getRowSize
      data  <- Reader.getRows(frame)
    } yield (size, data)

  def is = s2"""

  TSP Network should      
    display parquet file contents $disp
    """

  def disp = {
    unsafeRun(
      for {
        data <- rows._2.sadf
      } yield data.isEmpty == false

    ) 
    // true must_== true
  }

}
