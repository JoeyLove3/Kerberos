package test;

import java.net.* ;
import java.io.* ;
import java.util.Scanner;

public class testclient {

    public static void main(String[] args) {
        int port = 46322;
        String ip = "192.168.137.172";
        testclient client = new testclient();
        client.clientTest(ip, port);
    }

    public void clientTest(String ip, int port){
        Socket clientSocket;
        BufferedReader br;
        PrintWriter pw;
        Scanner sc = new Scanner(System.in);
        String buf;

        //connect and communicate
        try {

            //connect
            clientSocket = new Socket(ip, port);
            br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            System.out.println("try to connect server "+ ip + ": " + port);
            System.out.println("ready");

            //write and read
            while(true){
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

            }

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