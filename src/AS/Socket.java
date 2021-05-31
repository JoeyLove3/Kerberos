package AS;

import DES.Decryption;
import Message.Ticket;
import AS.*;
import AS.GetKey;
import Message.Message1;
import java.io.*;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class Socket {
    private static final String MyIDtgs = "1000";
    private static final String Lifetime2 = "0200000";

    public static void main(String[] args) {
        int port = 46321;
        AS.Socket server = new AS.Socket();
        server.serverTest(port);
    }

    private static class InnerThread implements Runnable {
        private final java.net.Socket clientSocket;

        public InnerThread(java.net.Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            Statemachine.ASstate status = Statemachine.ASstate.listen;//状态机定义
            String buf = null;
            BufferedReader br = null;//读流
            PrintWriter pw = null;//写流

            try {
                br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                pw = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }

            String AD = clientSocket.getInetAddress().toString();
            status.nextstatus();//状态转换

            //网络地址转换
            String[] ADarr = AD.split("\\.");
            String a = "0";
            String G_ADc = "";
            for (int i = 0; i < ADarr.length; i++) {
                if (ADarr[i].length() < 3) {
                    if (ADarr[i].length() == 1)
                        ADarr[i] = a + a + i;
                    else
                        ADarr[i] = a + i;
                }
                G_ADc += ADarr[i];
            }

            //拆包
            try {
                assert br != null;
                buf = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String M1 = buf;
            String G_IDc = Message.Message1.getIDc(M1);
            String G_IDtgs = Message.Message1.getIDtgs(M1);


            //正式验证
            try {
                    try {
                        if (!AS_Check.check(G_IDc,G_IDtgs)) {//验证失败
                            System.out.println("验证失败");
                            status.err();//状态转换
                            try {//结束
                                br.close();
                                clientSocket.close();//断开连接
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            assert pw != null;
                            pw.close();
                        } else {//验证成功
                            status.nextstatus();
                            String Kctgs = CreateKctgs.createKctgs();
                            String Ekc=GetKey.getEkc(G_IDc);
                            String Ektgs=GetKey.getEktgs(G_IDtgs);
                            String Message2 = CreateM2.createM2(Ekc, Kctgs, Ektgs, G_IDtgs, G_IDc, G_ADc, Lifetime2);
                            assert pw != null;
                            pw.println(Message2);
                            pw.flush();
                            status.nextstatus();
                            System.out.println("close client");
                            try {
                                br.close();
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            pw.close();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void serverTest(int port) {
        ServerSocket serverSocket;
        ExecutorService pool = Executors.newFixedThreadPool(10);

        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                java.net.Socket clientSocket;
                clientSocket = serverSocket.accept();

                //当接收到socket时使用线程池中的一个进程开始服务
                AS.Socket.InnerThread innerThread = new AS.Socket.InnerThread(clientSocket);
                pool.execute(innerThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
            pool.shutdown();
        }
    }

}
