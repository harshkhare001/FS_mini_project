import java.io.*;
public class DeleteRecord {
    public static int delete(String eid){
        String Filedetail; String id; int index;
        int b=0;
        try{
            File file=new File("D:\\Demo\\demo.txt");
            RandomAccessFile raf = new RandomAccessFile(file, "rw");
            boolean found = false;
            while(raf.getFilePointer() < raf.length()){
                Filedetail= raf.readLine();
                String[] lineSplit = Filedetail.split("##");
                id=lineSplit[0];
                if(id.equals(eid)){
                    b=1;
                    found=true;
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
                        continue;
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
                System.out.println(" Employee deleted. ");
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

}
