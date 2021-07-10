import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Login {
    public static int log(String user, String pass){
        String User;
        String Pass;
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
                    if (User.equals(user) && Pass.equals(pass)) {
                        found = true;
                        b=1;
                        break;
                    }
                    else if(User.equals(user) && !Pass.equals(pass)){
                        b=-1;
                    }
                }
            }
        }catch (IOException e){
            return 1;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(log("admin","124"));
    }
}
