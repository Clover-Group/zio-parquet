package parrrtest

import org.specs2._

import zio.{ Chunk, DefaultRuntime }
// import zio.console.{ putStrLn }
import ParquetPkg._
import ParquetReader._

class HelloSpec extends Specification with DefaultRuntime {

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
    Chunk with data must not be empty $zero
    display parquet file contents $disp
    """

  def zero =
    rows.length > 0 must beTrue

  def disp = {

    val size = rows.map(_._1).length
    //val data = rows.map(_._2)

    println(s"Chunk size = $size")
    println(rows)

    true must_== true

  }
}
