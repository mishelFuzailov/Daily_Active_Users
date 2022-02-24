import DataCounters.DAU_Counter;
import DataCounters.IDataCounter;
import DataReaders.FileReader;
import DataReaders.IDataReader;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class Test {
    @org.junit.Test
    public void dailyActiveUsers(){
        String file_name = "src\\input.txt";
        IDataReader<Set<String>> data_reader = new FileReader(file_name);
        IDataCounter data_counter = new DAU_Counter(data_reader);
        Map<String, Integer> count_map = data_counter.Count();

        Assert.assertEquals(3, data_counter.getUsersForDay(count_map, "01/01/2020"));
        Assert.assertEquals(2, data_counter.getUsersForDay(count_map, "02/01/2020"));
        Assert.assertEquals(2, data_counter.getUsersForDay(count_map, "03/01/2020"));
    }
}
