package DataCounters;

import DataReaders.IDataReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DAU_Counter implements IDataCounter {
    IDataReader<Set<String>> data_reader;
    public DAU_Counter(IDataReader<Set<String>> data_reader) {
        this.data_reader = data_reader;
    }

    @Override
    /*
      Count user per day, and insert the counts to a hash-map
      @return Map<String, Integer> result : map od date:num of users
     */
    public Map<String, Integer> Count(){
        int a = 0;
        // key: Day, value: num of users in this day
        Map<String, Integer> result = new HashMap<>();
        // get set of users and days from dataReader.
        Set<String> usersAndDays = this.data_reader.read();
        // Because a set contains each element once, there is no way that the same user, date
        // will appear twice.
        for (String user_day : usersAndDays) {
            String[] split_uer_day = user_day.split(",");
            //split_uer_day[1] = date. if the map contains this day.
            if (result.containsKey(split_uer_day[1])) {
                // increase it's value.
                result.put(split_uer_day[1], result.get(split_uer_day[1])+1);
            } else {
                // init this key
                result.put(split_uer_day[1], 1);
            }
        }
        return result;
    }

    @Override
    public void printCounter(Map<String, Integer> count_map) {
        System.out.println("Daily Active Users: ");

        for (String key : count_map.keySet()) {
            String value = count_map.get(key).toString();
            System.out.println("Date: " + key + ", Num of users: " + value);
        }
    }

    @Override
    public void printOneCount(Map<String, Integer> count_map, String key) {

        if (count_map.containsKey(key)) {
            System.out.println("Number of Daily Active Users for: " + key + ", is: " +
                    count_map.get(key));
        } else {
            System.out.println("Invalid date! please choose another date.");
        }
    }

    @Override
    public int getUsersForDay(Map<String, Integer> count_map, String key) {
        return count_map.get(key);
    }
}
