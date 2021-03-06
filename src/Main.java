import DataCounters.DAU_Counter;
import DataCounters.IDataCounter;
import DataReaders.FileReader;
import DataReaders.IDataReader;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        String file_name = "src\\input.txt";
        IDataReader<Set<String>> data_reader = new FileReader(file_name);
        IDataCounter data_counter = new DAU_Counter(data_reader);
        // count and print
        Map<String, Integer> count_map = data_counter.Count();
        data_counter.printCounter(count_map);
        // print one day
        data_counter.printOneCount(count_map, "01/01/2020");
    }

}
