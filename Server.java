import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String args[]) throws Exception{
        int PORT = 8005;
        int MAX_CONN_IN_Q = 20000;
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT), MAX_CONN_IN_Q);
        HttpContext login = server.createContext("/index", new APISign());
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        System.out.println("started");
    }
}