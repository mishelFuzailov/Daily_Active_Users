package DataReaders;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class FileReader implements IDataReader<Set<String>>{
    String file_name;
    public FileReader(String file_name) {
        this.file_name = file_name;
    }


    @Override
    // read ech line from file and insert to hash set string of "userNum,Day".
    public Set<String> read(){
        Set<String> result = new HashSet<>();
        try { // open file
            FileInputStream stream = new FileInputStream(this.file_name);
            Scanner scanner = new Scanner(stream);
            //returns true if there is another line to read
            while(scanner.hasNextLine())
            {
                result.add(scanner.nextLine().split(" ")[0]);
            }
            //closes the scanner
            scanner.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
