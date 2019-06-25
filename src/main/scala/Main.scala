package hello

import Reader._
import zio.{ App }

object Main extends App {

  def run(args: List[String]) =
    out.fold(_ => 1, _ => 0)

  val path = "/tmp/hello.pq"

  val fdata = Reader.getAll(path)

  //val out =  fdata map ( v => println(v._1))
  val out = fdata map (println)

}
