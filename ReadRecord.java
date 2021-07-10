import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Comparator;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ReadRecord {

    public static JSONArray read()throws NumberFormatException{
        JSONArray array = new JSONArray();
        String Filedetail;
        try {
            File file = new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            while (raf.getFilePointer() < raf.length()){
                JSONObject Allrecords = new JSONObject();
                Filedetail= raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                Allrecords.put("Eid",lineSplit[0]);
                Allrecords.put("Name",lineSplit[1]);
                Allrecords.put("Des",lineSplit[2]);
                Allrecords.put("Phone",lineSplit[3]);
                Allrecords.put("Pass",lineSplit[4]);
                Allrecords.put("Pto",lineSplit[5]);
                array.put(Allrecords);
                System.out.println(Allrecords);
            }
        }
        catch (IOException ioe)
        {

            System.out.println(ioe);
        }
        JSONArray sorted = new JSONArray(array.toList().stream().sorted(Comparator.comparing(a -> Double.valueOf((String) ((HashMap) a).get("Eid")))).collect(Collectors.toList()));
        return sorted;
    }


    public static void main(String[] args) {
        System.out.println(read());
    }


}
