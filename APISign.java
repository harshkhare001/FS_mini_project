import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.json.JSONObject;

import java.io.*;
import java.net.URI;
import java.util.Random;

public class APISign implements HttpHandler {
    private static Login login = new Login();
    private static SignUp signUp = new SignUp();
    private static ReadRecord readRecord = new ReadRecord();
    private static AddEmployee addEmployee = new AddEmployee();
    private static DeleteRecord deleteRecord = new DeleteRecord();
    private static SearchRecord searchRecord = new SearchRecord();
    private static UpdateRecord updateRecord = new UpdateRecord();
    private static final int HTTP_OK_STATUS = 200;
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        URI uri = exchange.getRequestURI();
        String response = null;
        if(exchange.getRequestURI().getPath().toLowerCase().contains("/signin")){
            InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if(buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String userName = "";
            String password = "";
            if(object.has("username") && object.has("password")) {
                userName = object.get("username").toString();
                password = object.get("password").toString();
                int status = login.log(userName, password);
                if (status == 1) {
                    response = "{\"status\" : true,\"statusText\" : \"Login Successful\"}";
                } else if (status == 0)
                    response = "{\"status\" : false,\"statusText\" : \"User Not Found\"}";
                else if (status == -1)
                    response = "{\"status\" : false,\"statusText\" : \"Invalid Password\"}";
                else
                    response = "{\"status\" : false,\"statusText\" : \"Login Fail\"}";
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/signup")){
            InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if(buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String userName = "";
            String password = "";
            if(object.has("username") && object.has("password")) {
                userName = object.get("username").toString();
                password = object.get("password").toString();
                int status = signUp.signup(userName, password);
                if (status == 0) {
                    response = "{\"status\" : true,\"statusText\" : \"Sign Up Successful\"}";
                } else if (status == 1)
                    response = "{\"status\" : false,\"statusText\" : \"User Already Exists\"}";
                else if (status == -1)
                    response = "{\"status\" : false,\"statusText\" : \"Please Enter An Unique Password\"}";

                else
                    response = "{\"status\" : false,\"statusText\" : \"Sign Up Fail\"}";
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/viewemployee")){
            InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if(buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            response = readRecord.read().toString();
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/addemployee")){
            InputStreamReader isr =  new InputStreamReader(exchange.getRequestBody(),"utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if(buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String [] data = new String[6];
            int check;
            if(object.has("Eid") && object.has("Name") && object.has("Des") && object.has("Phone")){
                data[0] = object.getString("Eid");
                data[1] = object.getString("Name");
                data[2] = object.getString("Des");
                data[3] = object.getString("Phone");
                data[4] = "4";
                data[5] = "6";
            }
            check = addEmployee.addemployee(data);
            if(check==1){
                response = "{\"status\" : true,\"statusText\" : \"Employee Added\"}";
            }
            else if(check==0){
                response = "{\"status\" : false,\"statusText\" : \"Employee Already Exists\"}";
            }
            else {
                response = "{\"status\" : false}";
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/updateemployee")) {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if (buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String [] data = new String[6];
            int check;
            if(object.has("Eid") && object.has("Name") && object.has("Des") && object.has("Phone")){
                data[0] = object.getString("Eid");
                data[1] = object.getString("Name");
                data[2] = object.getString("Des");
                data[3] = object.getString("Phone");
                System.out.println(data);
            }

            check = updateRecord.update(data);
            if(check==1){
                response = "{\"status\" : true,\"statusText\" : \"Employee Updated\"}";
            }
            else if(check==0){
                response = "{\"status\" : false,\"statusText\" : \"Employee Does Not Exist\"}";
            }
            else {
                response = "{\"status\" : false}";
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/usepass")) {
            System.out.println("Here");
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if (buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String id = "";
            int check;
            if(object.has("Eid")){
                id = object.getString("Eid");
            }
            check = updateRecord.updatepass(id);
            String pin = "";
            if(check==1){
                Random random = new Random();
                pin = id+"7277"+String.valueOf(random.nextInt(10000));
            }
            String res = "{\"status\" : true,\"statusText\" : \" Pass Generated OTP:-"+pin+" \"}";
            if(check==1){
                response = res;
            }
            else if(check==-1){
                response = "{\"status\" : false,\"statusText\" : \"Pass Unavailable\"}";
            }
            else if(check==0){
                response = "{\"status\" : false,\"statusText\" : \"Employee Does Not Exist\"}";
            }
            else {
                response = "{\"status\" : false}";
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/usepto")) {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if (buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String id = "";
            int check;
            if(object.has("Eid")){
                id = object.getString("Eid");
            }
            check = updateRecord.updatepto(id);
            String pin = "";
            if(check==1){
                Random random = new Random();
                pin = id+"786"+String.valueOf(random.nextInt(10000));
            }
            String res = "{\"status\" : true,\"statusText\" : \" PTO Generated OTP:-"+pin+" \"}";
            if(check==1){
                response = res;
            }
            else if(check==0){
                response = "{\"status\" : false,\"statusText\" : \"Employee Does Not Exist\"}";
            }
            else if(check==-1){
                response = "{\"status\" : false,\"statusText\" : \"PTO Unavailable\"}";
            }
            else {
                response = "{\"status\" : false}";
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/deleteemployee")) {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if (buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String id = "";
            int check;
            if (object.has("Eid")) {
                id = object.getString("Eid");
                check = deleteRecord.delete(id);
                if(check==1){
                    response = "{\"status\" : true,\"statusText\" : \"Employee Delete\"}";
                }
                else if(check==0){
                    response = "{\"status\" : false,\"statusText\" : \"Employee Does Not Exist\"}";
                }
                else {
                    response = "{\"status\" : false}";
                }
            }
        }
        else if(exchange.getRequestURI().getPath().toLowerCase().contains("/searchemployee")) {
            InputStreamReader isr = new InputStreamReader(exchange.getRequestBody(), "utf-8");
            BufferedReader br = new BufferedReader(isr);
            int b;
            StringBuilder buf = new StringBuilder(512);
            while ((b = br.read()) != -1) {
                buf.append((char) b);
            }
            br.close();
            isr.close();
            JSONObject object = new JSONObject();
            if (buf.length() > 0) {
                object = new JSONObject(buf.toString());
            }
            String id = "";
            String [] record = new String[6];
            if (object.has("Eid")) {
                id = object.getString("Eid");
            }
            record = searchRecord.search(id);
            if(record[0] != null){
                JSONObject r = new JSONObject();
                r.put("status",true);
                r.put("statusText","Search Successful");
                r.put("Eid",record[0]);
                r.put("Name",record[1]);
                r.put("Des",record[2]);
                r.put("Phone",record[3]);
                r.put("Pass",record[4]);
                r.put("Pto",record[5]);
                response = r.toString();
            }
            else{
                response = "{\"status\" : false,\"statusText\" : \"Employee Does Not Exist\"}";
            }
        }
        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
        if (exchange.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "POST, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
            exchange.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            exchange.sendResponseHeaders(200, response.length());
        }
        System.out.println("Response: " + response);
        exchange.sendResponseHeaders(HTTP_OK_STATUS, response.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
