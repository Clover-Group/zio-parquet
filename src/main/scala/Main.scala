package hello

import parquetBase.ParquetReaderUtils

//import ParquetReaderUtils._


object  Main extends App {

  val path = "/tmp/hello.pq"

  val parquet       = ParquetReaderUtils.getParquetData(path)
  val simpleGroup   = parquet.getData()
  val storedString  = simpleGroup.get(0).getString("theFieldIWant", 0)
  

}

