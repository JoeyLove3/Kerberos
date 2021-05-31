package C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Socket {
    public static final String IDas="";
    public static final String IDtgs="";
    public static final String IDv="";
    public static final String MyIDc="";
    public static final String OutTime="";
    public static void main(String[] args) {
        int port = 46322;
        String ip = "127.0.0.1";
        Socket client = new Socket();
        client.clientTest(ip, port);
    }

    public void clientTest(String ip, int port){
        java.net.Socket clientSocket;
        BufferedReader br;
        PrintWriter pw;
        Scanner sc = new Scanner(System.in);
        String buf;

        //connect and communicate
        try {

            //connect
            clientSocket = new java.net.Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.println("try to connect server "+ ip + ": " + port);
            System.out.println("ready");

            //write and read
            /*while(true){
                System.out.print("client: ");
                buf = sc.nextLine();
                pw.println(buf);
                pw.flush();

                if(buf.equals("close")){
                    break;
                }

                buf= br.readLine();
                System.out.println("server: " + buf);

                if(buf.equals("close")){
                    break;
                }

            }*/

            //close
            br.close();
            pw.close();
            sc.close();
            clientSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
