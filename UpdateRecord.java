import java.io.*;
class UpdateRecord{
    public static int update(String []data){
        String eid = data[0];
        String pass = "",pto = "";
        String Filedetail; String id; int index;
        int b = 0;
        try{
            File file=new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            while(raf.getFilePointer() < raf.length()){
                Filedetail= raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                id=lineSplit[0];
                if(id.equals(eid)){
                    found=true;
                    pass = lineSplit[4];
                    pto = lineSplit[5];
                    b=1;
                    break;
                }
            }
            if(found){
                File tmpFile = new File("D:\\temp.txt");
                RandomAccessFile tmpraf =new RandomAccessFile(tmpFile,"rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    Filedetail=raf.readLine();
                    index=Filedetail.indexOf("##");
                    id=Filedetail.substring(0,index);
                    if(id.equals(eid)){
                        Filedetail = data[0]+"##"+data[1]+"##"+data[2]+"##"+data[3]+"##"+pass+"##"+pto;
                    }
                    tmpraf.writeBytes(Filedetail);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                System.out.println(" Employee updated ");
            }
            else {
                raf.close();
                System.out.println("employee does not exist11");
            }

        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
        return b;
    }

    public static int updatepass(String eid){
        String pass = null;
        String pto = null;
        String Filedetail; String id; int index;
        int b = 0;
        try{
            File file=new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            while(raf.getFilePointer() < raf.length()){
                Filedetail= raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                id=lineSplit[0];
                if(id.equals(eid)){
                    found=true;
                    if(Integer.parseInt(lineSplit[4])==0){
                        found = false;
                        b=-1;
                        break;
                    }
                    pass = String.valueOf(Integer.parseInt(lineSplit[4])-1);
                    pto = lineSplit[5];
                    b=1;
                    break;
                }
            }
            if(found){
                File tmpFile = new File("D:\\temp.txt");
                RandomAccessFile tmpraf =new RandomAccessFile(tmpFile,"rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    Filedetail=raf.readLine();
                    index=Filedetail.indexOf("##");
                    id=Filedetail.substring(0,index);
                    String[] lineSplit = Filedetail.split("##");
                    if(id.equals(eid)){
                        Filedetail = lineSplit[0]+"##"+lineSplit[1]+"##"+lineSplit[2]+"##"+lineSplit[3]+"##"+pass+"##"+pto;
                    }
                    tmpraf.writeBytes(Filedetail);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                System.out.println(" Employee updated ");
            }
            else {
                raf.close();
                System.out.println("employee does not exist");
            }

        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
        return b;
    }

    public static int updatepto(String eid){
        String pass = null;
        String pto = null;
        String Filedetail; String id; int index;
        int b = 0;
        try{
            File file=new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            while(raf.getFilePointer() < raf.length()){
                Filedetail= raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                id=lineSplit[0];
                if(id.equals(eid)){
                    found=true;
                    pass = lineSplit[4];
                    if(Integer.parseInt(lineSplit[5])==0){
                        found = false;
                        b=-1;
                        break;
                    }
                    pto = String.valueOf(Integer.parseInt(lineSplit[5])-1);
                    b=1;
                    break;
                }
            }
            if(found){
                File tmpFile = new File("D:\\temp.txt");
                RandomAccessFile tmpraf =new RandomAccessFile(tmpFile,"rw");
                raf.seek(0);
                while (raf.getFilePointer() < raf.length()) {
                    Filedetail=raf.readLine();
                    index=Filedetail.indexOf("##");
                    id=Filedetail.substring(0,index);
                    String[] lineSplit = Filedetail.split("##");
                    if(id.equals(eid)){
                        Filedetail = lineSplit[0]+"##"+lineSplit[1]+"##"+lineSplit[2]+"##"+lineSplit[3]+"##"+pass+"##"+pto;
                    }
                    tmpraf.writeBytes(Filedetail);
                    tmpraf.writeBytes(System.lineSeparator());
                }
                raf.seek(0);
                tmpraf.seek(0);
                while (tmpraf.getFilePointer() < tmpraf.length()) {
                    raf.writeBytes(tmpraf.readLine());
                    raf.writeBytes(System.lineSeparator());
                }
                raf.setLength(tmpraf.length());
                tmpraf.close();
                raf.close();
                tmpFile.delete();
                System.out.println(" Employee updated ");
            }
            else {
                raf.close();
                System.out.println("employee does not exist");
            }

        }
        catch (IOException ioe) {
            System.out.println(ioe);
        }
        return b;
    }

    public static void yearlyupdate(){
        String pass = "4",pto = "6";
        String Filedetail;
        try{
            File file=new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            File tmpFile = new File("D:\\temp.txt");
            RandomAccessFile tmpraf =new RandomAccessFile(tmpFile,"rw");
            while (raf.getFilePointer() < raf.length()) {
                Filedetail=raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                Filedetail = lineSplit[0]+"##"+lineSplit[1]+"##"+lineSplit[2]+"##"+lineSplit[3]+"##"+pass+"##"+pto;
                tmpraf.writeBytes(Filedetail);
                tmpraf.writeBytes(System.lineSeparator());
            }
            raf.seek(0);
            tmpraf.seek(0);
            while (tmpraf.getFilePointer() < tmpraf.length()) {
                raf.writeBytes(tmpraf.readLine());
                raf.writeBytes(System.lineSeparator());
            }
            raf.setLength(tmpraf.length());
            tmpraf.close();
            raf.close();
            tmpFile.delete();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        yearlyupdate();
    }
}
