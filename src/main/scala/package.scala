import java.util.{ List => JList }
import org.apache.parquet.example.data.simple.SimpleGroup

package object ParquetPkg {

  type TypeData   = JList[SimpleGroup]
  type TypeSchema = JList[org.apache.parquet.schema.Type]

}
