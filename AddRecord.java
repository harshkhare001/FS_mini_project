import java.io.IOException;
import java.io.*;
import java.util.Scanner;

class AddRecord {
    public static int add(String[] data) {
        String record = data[0]+"##"+data[1]+"##"+data[2]+"##"+data[3]+"##"+data[4]+"##"+data[5];
        String  nid = data[0];
        String id;
        int b=0;
        String Filedetails;
        try {
            File file = new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf
                    = new RandomAccessFile(file, "rw");
            boolean found = false;
            if(raf.length()==0){
                found=false;
            }
            else {
                while (raf.getFilePointer() < raf.length()) {
                    Filedetails = raf.readLine();
                    String[] lineSplit = Filedetails.split("##", 6);
                    id = lineSplit[0];
                    if (id.equals(nid)) {
                        found = true;
                        break;
                    }
                }
            }
            if(found==false){
                raf.writeBytes(record);
                raf.writeBytes(System.lineSeparator());
                System.out.println(" record added. ");
                raf.close();
                b=1;
            }
            else
                System.out.println("record exists");
        } catch (IOException e) {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
        return b;
    }

    public static void main(String[] args) {
        String [] record = new String[6];
        Scanner scanner=new Scanner(System.in);
        System.out.println("ID : ");
        record[0] = scanner.next();
        System.out.println("Name : ");
        record[1] = scanner.next();
        System.out.println("Designation : ");
        record[2] = scanner.next();
        System.out.println("Phone Number : ");
        record[3] = scanner.next();
        System.out.println("Pass left : ");
        record[4] = scanner.next();
        System.out.println("PTO left : ");
        record[5] = scanner.next();
        add(record);
    }
}
