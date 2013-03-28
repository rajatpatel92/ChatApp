
package chatapp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 *
 * @author Rajat
 */
class OpenServerStreams {
    private ServerSocket serverSocket;
    private Socket socket;
    OutputStream os;
    public void openStreams() throws IOException{
        serverSocket = new ServerSocket(5995);
        socket = serverSocket.accept();
        System.out.println("Server Started...waiting for client..");
        System.out.println("Accepted connection : " + socket);
        os = socket.getOutputStream();
    }
}

class OpenClientStreams {
    Socket clientSocket;
    InputStream is;
    public void openStreams() throws IOException{
        clientSocket = new Socket("127.0.0.1", 5995);
        System.out.println("Connecting...");
        is = clientSocket.getInputStream();
    }
}
