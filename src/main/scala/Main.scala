package hello
//import ParquetReaderUtils._


object  Main extends App {

  val parquet       = ParquetReaderUtils.getParquetData()
  val simpleGroup   = parquet.getData().get(0)
  val storedString  = simpleGroup.get(0).getString("theFieldIWant", 0)
  

}

