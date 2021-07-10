public class AddEmployee {
    private static AddRecord addRecord = new AddRecord();
    public static int addemployee(String [] data){
        int b=0;
        b=addRecord.add(data);
        return b;
    }
}
