package DataCounters;

import java.io.IOException;
import java.util.Map;

public interface IDataCounter {
    Map<String, Integer> Count();
    void printCounter(Map<String, Integer> count_map);
    void printOneCount(Map<String, Integer> count_map, String key);
    int getUsersForDay(Map<String, Integer> count_map,String key);
}
