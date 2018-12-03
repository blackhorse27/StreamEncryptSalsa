/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streamencryptsalsa;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
//import java.net.DatagramPacket;
//import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author CVGS
 */
public class ClientStream extends javax.swing.JFrame {

    /**
     * Creates new form ServerStream
     */
    Boolean isRunning = false;
//    SecretKey secretKey = null;
//    Cipher cipher = null;
    long capFrameStart, capFrameFinish;
    double frameNum = 0;

    Socket socket;
    int pixel;

    public ClientStream() throws NoSuchAlgorithmException, IOException {
        initComponents();
        Dimension screenSize, windowSize;
        int sWidth, sHeight, wHeight;

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        windowSize = getSize();
        sWidth = (int) screenSize.getWidth();
        sHeight = (int) screenSize.getHeight();
        wHeight = (int) windowSize.getHeight();
        setLocation((sWidth / 2), 0);//(sHeight / 2) - wHeight);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        encryptedVideo = new javax.swing.JLabel();
        decryptedVideo = new javax.swing.JLabel();
        panelKey1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        statusText = new javax.swing.JLabel();
        panelKey = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        buttonStart = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        fieldIPR = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        fieldIPT = new javax.swing.JTextField();
        fieldPortT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fieldIV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        fieldKey = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client Webcam | SIMON 48/72");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Encrypted Video");

        encryptedVideo.setBackground(new java.awt.Color(0, 0, 0));
        encryptedVideo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        encryptedVideo.setText("Encrypted Video");

        decryptedVideo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        decryptedVideo.setText("Decrypted Video");
        decryptedVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                decryptedVideoMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Status");

        statusText.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        statusText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusText.setText("Click \"Start Video Streaming\" to start capture video and see status here");

        javax.swing.GroupLayout panelKey1Layout = new javax.swing.GroupLayout(panelKey1);
        panelKey1.setLayout(panelKey1Layout);
        panelKey1Layout.setHorizontalGroup(
            panelKey1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(statusText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelKey1Layout.setVerticalGroup(
            panelKey1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKey1Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusText, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Key : ");

        buttonStart.setBackground(new java.awt.Color(255, 255, 255));
        buttonStart.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonStart.setForeground(java.awt.Color.green);
        buttonStart.setText("Start Video Streaming");
        buttonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonStartActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Transmitter IP : ");

        fieldIPR.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        fieldIPR.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Receiver IP : ");

        fieldIPT.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        fieldPortT.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Port : ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("IV : ");

        fieldIV.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        fieldKey.setColumns(20);
        fieldKey.setLineWrap(true);
        fieldKey.setRows(5);
        fieldKey.setWrapStyleWord(true);
        jScrollPane2.setViewportView(fieldKey);

        javax.swing.GroupLayout panelKeyLayout = new javax.swing.GroupLayout(panelKey);
        panelKey.setLayout(panelKeyLayout);
        panelKeyLayout.setHorizontalGroup(
            panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeyLayout.createSequentialGroup()
                .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKeyLayout.createSequentialGroup()
                        .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldIV)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKeyLayout.createSequentialGroup()
                                .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(fieldIPT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(fieldIPR))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldPortT, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonStart, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKeyLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())))
        );
        panelKeyLayout.setVerticalGroup(
            panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKeyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
                .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelKeyLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldIV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(fieldIPR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(fieldIPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKeyLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(panelKeyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonStart)
                            .addComponent(fieldPortT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Decrypted Video");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(encryptedVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(decryptedVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE))
                    .addComponent(panelKey1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelKey, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(decryptedVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(encryptedVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelKey1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void decryptedVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_decryptedVideoMouseClicked

    }//GEN-LAST:event_decryptedVideoMouseClicked

    private void buttonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonStartActionPerformed

        if (!isRunning && !fieldKey.getText().isEmpty() && fieldKey.getText().length() % 32 == 0 && isHex(fieldKey.getText()) && !fieldIPT.getText().isEmpty() && !fieldPortT.getText().isEmpty()) {
            /*Untuk Protokol TCP, aktifkan mulai sini.....*/
//            int port = Integer.parseInt(fieldPortT.getText());
//            String host = fieldIPT.getText();
//            try {
//                socket = new Socket(host, port);
//                System.out.println("Connection to host established.");
//            } catch (UnknownHostException e) {
//                System.err.println("Don't know about host: " + host);
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
            /*.....sampai sini*/
            isRunning = true;
            try {
                fieldIPR.setText(InetAddress.getLocalHost().getHostAddress());
            } catch (UnknownHostException ex) {
                Logger.getLogger(ClientStream.class.getName()).log(Level.SEVERE, null, ex);
            }
            buttonStart.setText("Stop Video Streaming");
            buttonStart.setForeground(Color.red);
            encryptedVideo.setText("");
            decryptedVideo.setText("");
            new VideoFeed().start();
        } else if (!isRunning && fieldKey.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Key masih kosong! Inputkan Key");
        } else if (!isRunning && (fieldKey.getText().length() % 32 != 0 || !isHex(fieldKey.getText()))) {
            if (fieldKey.getText().length() != 18) {
                JOptionPane.showMessageDialog(null, "Panjang Key Tidak Sesuai !\nMasukkan 32 Karakter Heksadesimal");
            } else if (!isHex(fieldKey.getText())) {
                JOptionPane.showMessageDialog(null, "Key Bukan Heksadesimal !\nMasukkan 32 Karakter Heksadesimal");
            }
        } else if (fieldIPT.getText().isEmpty() || fieldPortT.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "IP dan Port Tidak Lengkap !\nLengkapi Inputan IP dan Port ");
        } else {
            isRunning = false;
            buttonStart.setText("Start Video Streaming");
            buttonStart.setForeground(Color.green);
            /* ini juga untuk tcp, aktifkan mulai sini....*/
//            try {
//                socket.close();
//            } catch (IOException ex) {
//                Logger.getLogger(ClientStream.class.getName()).log(Level.SEVERE, null, ex);
//            }
            /*....sampai sini*/
        }
    }//GEN-LAST:event_buttonStartActionPerformed
    public boolean isHex(String in) {
        boolean ret;
        try {
            // try to parse the string to a long, using 16 as radix
            for (int i = 0; i < in.length(); i++) {
                int t = Integer.parseInt(in.substring(i, i + 1), 16);
            }
            // parsing succeeded, string is valid hex number
            ret = true;
        } catch (NumberFormatException e) {
            // parsing failed, string is not a valid hex number
            ret = false;
        }
        return ret;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientStream.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    ClientStream clientStream = new ClientStream();
                    clientStream.setVisible(true);
                    clientStream.fieldIPT.setText(InetAddress.getLocalHost().getHostAddress());
                    clientStream.fieldPortT.setText("3000");
                    clientStream.fieldIPR.setText(InetAddress.getLocalHost().getHostAddress());
//                    clientStream.fieldPortR.setText("5100");

//                    clientStream.fieldKey.setText("c1b5d7cf0d1b61ec7a22a53b622d7a83");
//                    clientStream.fieldIV.setText("61066d4e77b9d215");
                    clientStream.setDefaultCloseOperation(EXIT_ON_CLOSE);
                } catch (NoSuchAlgorithmException | IOException ex) {
                    Logger.getLogger(ClientStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    class VideoFeed extends Thread {

        @Override
        public void run() {
            int msgLength;
            String decryptedFilename, encryptedFilename, key, iv;
            BufferedImage decImage;
            DecimalFormat df;
            Image decImg;
            long firstCapTime, timeDiff, avgDecTime = 0, decTime, runTime;
            double fps;

            fps = 0;
            encryptedFilename = "client/encrypted.jpg";//nama file hasil dekripsi
            decryptedFilename = "client/decrypted.jpg";//nama file hasil enkripsi
            firstCapTime = System.currentTimeMillis();//waktu pertama kali stream webcam
            timeDiff = 0;
            df = new DecimalFormat("#.##");

            key = fieldKey.getText();
            iv = fieldIV.getText();
            if (key.length() == 32) {
                key += key;
            }

//            msgLength = 76032;
            Salsa20 salsa20;//Inisialisasi metode simon 48/72 dengan key yang telah dibangkitkan
            while (isRunning) {
                try {
                    receiveCapture2(encryptedFilename);//penerimaan paket gambar yang dikirim
                    msgLength = pixel * 3;
                    salsa20 = new Salsa20(key, iv, msgLength);
                    capFrameStart = System.currentTimeMillis();//waktu memulai capture frame terkini
                    salsa20.decryptSalsa20(encryptedFilename, decryptedFilename);//dekripsi simon 48/72
                    decImage = ImageIO.read(new File(decryptedFilename));//pembacaan gambar hasil dekripsi
                    decImg = decImage.getScaledInstance(decryptedVideo.getWidth(), decryptedVideo.getHeight(), Image.SCALE_SMOOTH);
                    decryptedVideo.setIcon(new ImageIcon(decImg));//menampilkan gambar hasil dekripsi
                    capFrameFinish = System.currentTimeMillis();//waktu akhir capture frame terkini
                    decTime = capFrameFinish - capFrameStart;//menghitung waktu dekripsi per frame
                    runTime = capFrameFinish - firstCapTime;//menghitung waktu capture sejak awal dimulai
                    /*Penghitungan Frame Rate (fps)*/
                    if (runTime < 1000) {
                        frameNum++;
                        avgDecTime += decTime / frameNum;
                        fps = frameNum / runTime;
//                        statusText.setText("Frame Rate : " + df.format(fps) + " fps | Decrypting Time : " + decTime + " ms | Total Time : " + runTime + " s");
                    } else if (runTime - timeDiff < 1000) {
                        frameNum++;
//                        statusText.setText("Frame Rate : " + df.format(fps) + " fps | Decrypting Time : " + decTime + " ms | Total Time : " + runTime + " s");
                    } else {
                        fps = frameNum;
                        timeDiff += 1000;
//                        statusText.setText("Frame Rate : " + df.format(fps) + " fps | Decrypting Time : " + decTime + " ms | Total Time : " + runTime + " s");
                        frameNum = 1;
                    }
                    statusText.setText("Frame Rate : " + df.format(fps) + " fps | Decrypting Time : " + decTime + " ms | Total Time : " + (runTime / 1000) + " s");

//                    statusText.setText("Decrypting Time : " + decTime + " ms | Total Time : " + runTime + " s");
//                    Thread.sleep(1000 / capRate);
                } catch (IOException ex) {
                    Logger.getLogger(ClientStream.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        public void receiveCapture(String encFile) throws IOException, ClassNotFoundException {
            InputStream in;
            BufferedImage image;
            Image img;
            FileOutputStream fo;
            BufferedOutputStream bo;
            ObjectInputStream ois;
            byte[] byteImage;
            if (isRunning) {
                ois = new ObjectInputStream(socket.getInputStream());
                byteImage = (byte[]) ois.readObject();
                in = new ByteArrayInputStream(byteImage);
                image = ImageIO.read(in);
                pixel = image.getWidth() * image.getHeight();
                fo = new FileOutputStream(encFile);
                bo = new BufferedOutputStream(fo);
                ImageIO.write(image, "png", bo);
                bo.close();
                img = image.getScaledInstance(encryptedVideo.getWidth(), encryptedVideo.getHeight(), Image.SCALE_SMOOTH);
                encryptedVideo.setIcon(new ImageIcon(img));
            } else {
                socket.close();
            }
        }

        /* penerimaan dengan UDP*/
        public void receiveCapture2(String encFile) throws IOException {
//            try {
                String ipSrc, ipDst;
                int portSrc, portDst;
                InetAddress ipSource, ipDestination;
                DatagramSocket clientsocket;
                DatagramPacket recv_packet;
                byte[] receivedata, buff;
                InputStream in;
                BufferedImage img;
                FileOutputStream fo;
                BufferedOutputStream bo;

                ipSrc = fieldIPT.getText();
                ipDst = fieldIPR.getText();
                portSrc = Integer.parseInt(fieldPortT.getText());
//            portDst = Integer.parseInt(fieldPortR.getText());
                portDst = 5000;

                ipSource = InetAddress.getByName(ipSrc);
                ipDestination = InetAddress.getByName(ipDst);
                clientsocket = new DatagramSocket(portDst, ipDestination);
//            clientsocket = new DatagramSocket();
                receivedata = new byte[92024];
                recv_packet = new DatagramPacket(receivedata, receivedata.length);
                clientsocket.connect(ipSource, portSrc);
                clientsocket.receive(recv_packet);
                buff = recv_packet.getData();
//                if (isRunning) {
                    in = new ByteArrayInputStream(buff);
                    img = ImageIO.read(in);
                    fo = new FileOutputStream(encFile);
                    bo = new BufferedOutputStream(fo);
                    ImageIO.write(img, "jpg", bo);
                    bo.close();
                    encryptedVideo.setIcon(new ImageIcon(img));
                    clientsocket.close();
//                } else {
//                    clientsocket.close();
//                }
//            } catch () {
//
//            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonStart;
    private javax.swing.JLabel decryptedVideo;
    private javax.swing.JLabel encryptedVideo;
    private javax.swing.JTextField fieldIPR;
    private javax.swing.JTextField fieldIPT;
    private javax.swing.JTextField fieldIV;
    private javax.swing.JTextArea fieldKey;
    private javax.swing.JTextField fieldPortT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panelKey;
    private javax.swing.JPanel panelKey1;
    private javax.swing.JLabel statusText;
    // End of variables declaration//GEN-END:variables
}