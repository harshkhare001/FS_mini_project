import java.io.*;
public class SearchRecord {
    public static String [] search(String eid){
        String id;
        String Filedetail;
        String [] data = new String[6];
        try {
            File file = new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            while (raf.getFilePointer() < raf.length()) {
                Filedetail = raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                id=lineSplit[0];
                String name=lineSplit[1];
                String des=lineSplit[2];
                long phone = Long.parseLong(lineSplit[3]);
                int pass=Integer.parseInt(lineSplit[4]);
                int pto=Integer.parseInt(lineSplit[5]);
                if (id.equals(eid)){
                    System.out.println("record found");
                    data[0] = lineSplit[0];
                    data[1] = lineSplit[1];
                    data[2] = lineSplit[2];
                    data[3] = lineSplit[3];
                    data[4] = lineSplit[4];
                    data[5] = lineSplit[5];
                    System.out.println("Employee id: "+id+" "+"Name: "+name+" "+"Designation: "+des+" "+" Phone_Number: "+phone+" Pass left: "+pass+" "+"PTO left: "+pto);
                    found=true;
                    break;
                }

            }
            if(!found){
                System.out.println("Record not found");
            }

        }
        catch (IOException | NumberFormatException ioe)
        {

            System.out.println(ioe);
        }
        return data;
    }
    public static void main(String[] args){
    }
}
