package hello

import ParquetReader._
import zio.{ App }
//import org.apache.parquet.hadoop.ParquetReader

object Main extends App {

  def run(args: List[String]) =
    out.fold(_ => 1, _ => 0)

  val path = "/tmp/hello.pq"

  val fdata = Reader.getAll(path)

  val out = fdata map (println)

}
