package hello

import ru.itclover.ParquetReaderUtils

//import ParquetReaderUtils._


object  Main extends App {

  val parquet       = ParquetReaderUtils.getParquetData("path")
  val simpleGroup   = parquet.getData()
  val storedString  = simpleGroup.get(0).getString("theFieldIWant", 0)
  

}

