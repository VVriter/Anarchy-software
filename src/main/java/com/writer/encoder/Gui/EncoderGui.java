package com.writer.encoder.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class EncoderGui {


    public static void frame(String... args)  {

        //Window Settings
        JFrame frame = new JFrame("UTF-8 ENCODER");
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        //Centering window
        frame.setBounds(x,y,350,300);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setBackground(Color.WHITE);
        JLabel output = new JLabel("Out:");
        output.setBounds(25,40,50,20);
        output.setOpaque(true);
        output.setForeground(Color.BLACK);
        output.setBackground(Color.WHITE);
        output.setFont(new Font("Vernanda",Font.BOLD,15));

        JTextField outputt = new JTextField();
        outputt.setBounds(100,40,230,20);




        JButton copy = new JButton("Copy");
        copy.setBounds(15,200,319,25);
        copy.setBackground(Color.WHITE);
        copy.setForeground(Color.BLACK);




        JLabel login = new JLabel("Print:");
        login.setBounds(25,10,50,20);
        login.setOpaque(true);
        login.setForeground(Color.BLACK);
        login.setBackground(Color.WHITE);
        login.setFont(new Font("Vernanda",Font.BOLD,15));

        JTextField pass3 = new JTextField();
        pass3.setBounds(100,10,230,20);


        JButton button = new JButton("Decode");
        button.setBounds(175,230,159,25);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                byte[] decodedBytes = Base64.getDecoder().decode(pass3.getText());
                String decodedString = new String(decodedBytes);
                System.out.println(decodedString);
                outputt.setText(decodedString);
            }
        });


        JButton code = new JButton("Encode");
        code.setBounds(15,230,159,25);
        code.setBackground(Color.WHITE);
        code.setForeground(Color.BLACK);

        code.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                byte[] bytes = new byte[0];
                try {
                    bytes = pass3.getText().getBytes("UTF-8");
                } catch (UnsupportedEncodingException ex) {
                    throw new RuntimeException(ex);
                }
                String encoded = Base64.getEncoder().encodeToString(bytes);
                byte[] decoded = Base64.getDecoder().decode(encoded);
                String decodedStr = new String(decoded, StandardCharsets.UTF_8);
                System.out.println(encoded);
                outputt.setText(encoded);

            }
        });




        copy.addActionListener(new ActionListener() {
            @Override
            public  void actionPerformed(ActionEvent e) {
                final Clipboard clipboard = Toolkit.getDefaultToolkit ( ).getSystemClipboard ( );
                final StringSelection contents = new StringSelection(outputt.getText());
                clipboard.setContents ( contents , null );
            }
        });


        JButton maingui = new JButton("Return to main frame");
        maingui.setBounds(15,100,319,25);
        maingui.setBackground(Color.WHITE);
        maingui.setForeground(Color.BLACK);
        maingui.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGui.frame();
                frame.dispose();
            }
        });




        //add
        frame.setVisible(true);
        frame.add(login);
        frame.add(copy);
        frame.add(code);
        frame.add(button);
        frame.add(output);
        frame.add(outputt);
        frame.add(maingui);
        frame.add(pass3);
    }
}