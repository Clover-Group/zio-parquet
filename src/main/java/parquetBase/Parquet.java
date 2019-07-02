package parquetBase;

import org.apache.parquet.example.data.simple.SimpleGroup;
import org.apache.parquet.schema.Type;

import java.util.List;

public class Parquet {
    private List<SimpleGroup> data;
    private List<Type> schema;

    public Parquet(List<SimpleGroup> data, List<Type> schema) {
        this.data = data;
        this.schema = schema;
    }

    public List<SimpleGroup> getRows() {
        return data;
    }

    public List<Type> getCols() {
        return schema;
    }
    public int getRowSize() {
        return data.size();
    }
    public int getColSize() {
        return schema.size();
    }
}