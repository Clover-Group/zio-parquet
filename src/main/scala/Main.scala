package hello

import Reader._
import zio.{ App }

object Main extends App {

  def run(args: List[String]) =
    res.fold(_ => 1, _ => 0)

  val path = "/tmp/hello.pq"

  val res = Reader.getSource(path)

}
