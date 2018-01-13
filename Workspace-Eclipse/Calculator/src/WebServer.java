import java.io.*;
import java.net.*;
import java.util.*;

class HttpHandler {

    Socket client;

    public HttpHandler(Socket client) {
        this.client = client;

    }

    public void handle() throws Exception {
        String path = new File(".").getCanonicalPath();
        FileInputStream fin = null;
        boolean found = true;

        String status = "HTTP/1.0 200 OK\r\n\r";
        String type = "Content-type: text/html\r\n\r\n";
        String error = "<H2>404 Not Found</H2>";
        
        DataInputStream din = new DataInputStream(client.getInputStream());

        OutputStream ot = client.getOutputStream();
        BufferedOutputStream out = new BufferedOutputStream(ot);

        String request = din.readLine().trim();
        StringTokenizer tokenizer = new StringTokenizer(request, " /");
        String header = tokenizer.nextToken();

        if (header.equals("GET")) {
            String fileName = tokenizer.nextToken();
            try {
                fin = new FileInputStream(path + "\\" + fileName);
            } catch (Exception e) {
                found = false;
            }
            
            out.write(status.getBytes());
            out.write(type.getBytes());

            if (found) {
                byte[] buffer = new byte[1024];
                int bytes = 0;
                while ((bytes = fin.read(buffer)) != -1) {
                    out.write(buffer, 0, bytes);
                }
                fin.close();
            } else {
                
                out.write(error.getBytes());
            }

            out.close();
        }
    }
}

public class WebServer {

    public static void main(String args[]) {
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
	    System.out.println("Server is UP and running");
            while (true) {
		Socket socket = serverSocket.accept();
                HttpHandler request = new HttpHandler(socket);
                request.handle();
		
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}