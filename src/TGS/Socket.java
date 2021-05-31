package TGS;

import DES.Decryption;
import Message.Ticket;

import java.io.*;
import java.net.ServerSocket;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Socket {
    private static final String MyIDtgs = "1001";
    private static final String Lifetime4 = "0200000";

    public static void main(String[] args) {
        int port = 46322;
        Socket server = new Socket();
        server.serverTest(port);
    }

    private static class InnerThread implements Runnable {
        private final java.net.Socket clientSocket;

        public InnerThread(java.net.Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        public void run() {
            Statemachine.TGSstate status = Statemachine.TGSstate.listen;//状态机定义
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
            String Message3 = buf;
            String G_IDv = Message.Message3.getIDv(Message3);
            String EN_Tickettgs = Message.Message3.getTickettgs(Message3);
            String EN_Authenticator = Message.Message3.getAuthenticator(Message3);
            String Ektgs;
            String Ekv;

            //正式验证
            try {
                Ektgs = GetKey.getEktgs(MyIDtgs);
                Ekv = GetKey.getEkv(G_IDv);
                if (Ekv == null) {
                    System.out.println("验证失败");
                    status.err();//状态转换
                    try {
                        clientSocket.close();//断开连接
                        br.close();
                        assert pw != null;
                        pw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    assert Ektgs != null;
                    String DE_Tickettgs = Decryption.decryption(EN_Tickettgs, Ektgs);
                    String T_IDc = Ticket.getIDc(DE_Tickettgs);
                    String Kctgs = Ticket.getKctgs(DE_Tickettgs);
                    String DE_Authenticator = Decryption.decryption(EN_Authenticator, Kctgs);
                    try {
                        if (!Check.check(G_ADc, MyIDtgs, G_IDv, DE_Tickettgs, DE_Authenticator)) {//验证失败
                            System.out.println("验证失败");
                            status.err();//状态转换
                            try {//结束
                                br.close();
                                clientSocket.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            assert pw != null;
                            pw.close();
                        } else {//验证成功
                            status.nextstatus();
                            String Kcv = CreateKcv.createKcv();
                            String Message4 = CreateM4.createM4(Kctgs, Ekv, Kcv, G_IDv, T_IDc, G_ADc, Lifetime4);
                            assert pw != null;
                            pw.println(Message4);
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
                InnerThread innerThread = new InnerThread(clientSocket);
                pool.execute(innerThread);
            }
        } catch (Exception e) {
            e.printStackTrace();
            pool.shutdown();
        }
    }
}
