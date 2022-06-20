package com.writer.encoder.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Base64;

public class MainGui extends JFrame {


    public static void frame(String... args){
        JFrame frame = new JFrame("Anarchy software");
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



        //Encoder button
        JButton encoderButton = new JButton("Encoder");
        encoderButton.setBounds(15,10,319,25);
        encoderButton.setBackground(Color.WHITE);
        encoderButton.setForeground(Color.BLACK);
        encoderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EncoderGui.frame();
                frame.dispose();
            }
        });


        //Webhook spammer button
        JButton webhookSpam = new JButton("Webhook Spammer");
        webhookSpam.setBounds(15,40,319,25);
        webhookSpam.setBackground(Color.WHITE);
        webhookSpam.setForeground(Color.BLACK);
        webhookSpam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WebhookSpamGui.frame();
                frame.dispose();
            }
        });


        //add
        frame.setVisible(true);

        frame.add(encoderButton);
        frame.add(webhookSpam);
    }

}
