package hello

import Reader._
import zio.{ App }

object Main extends App {

  def run(args: List[String]) =
    res.fold(_ => 1, _ => 0)

  val path = "/tmp/hello.pq"

  val res =
    for {
      frame  <- Reader.getFrame(path)
      data   <- Reader.getData(frame)
      schema <- Reader.getSchema(frame)
    } yield (data, schema)

}
