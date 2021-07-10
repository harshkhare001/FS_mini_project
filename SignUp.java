import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class SignUp {
    public static int signup(String user, String pass){
        String User;
        String Pass;
        String record = user+"##"+pass;
        int b=0;
        try {
            File file = new File("D:\\Demo\\admin.txt");
            RandomAccessFile raf
                    = new RandomAccessFile(file, "rw");
            boolean found = false;
            if(raf.length()==0){
                found=false;
            }
            else {
                while (raf.getFilePointer() < raf.length()) {
                    String Filedetails = raf.readLine();
                    String[] lineSplit = Filedetails.split("##");
                    User = lineSplit[0].toString();
                    Pass = lineSplit[1];
                    if (User.equals(user)) {
                        found = true;
                        b=1;
                        break;
                    }
                    else if(Pass.equals(pass)){
                        found = true;
                        b=-1;
                        break;
                    }
                }
            }
            if(found==false){
                raf.writeBytes(record);
                raf.writeBytes(System.lineSeparator());
                System.out.println(" record added. ");
                raf.close();
            }
        }catch (IOException e){
            return 0;
        }
        return b;
    }
    public static void main(String[] args) {
        signup("admin","1234");
    }
}
