package com.writer.encoder.Gui;

import com.writer.encoder.Util.DiscordWebhook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class WebhookSpamGui extends JFrame {
    public static void frame(String... args){
        JFrame frame = new JFrame("Webhook spammer");
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


        //Webhook field
        JLabel webhookFieldText = new JLabel("Webhook:");
        webhookFieldText.setBounds(25,10,100,20);
        webhookFieldText.setOpaque(true);
        webhookFieldText.setForeground(Color.BLACK);
        webhookFieldText.setBackground(Color.WHITE);
        webhookFieldText.setFont(new Font("Vernanda",Font.BOLD,15));
        //Webhook Text field
        JTextField webhookField = new JTextField();
        webhookField.setBounds(110,10,220,20);


        //Delay field
        JLabel delayTextField = new JLabel("Delay:");
        delayTextField.setBounds(25,35,100,20);
        delayTextField.setOpaque(true);
        delayTextField.setForeground(Color.BLACK);
        delayTextField.setBackground(Color.WHITE);
        delayTextField.setFont(new Font("Vernanda",Font.BOLD,15));
        //Delay text field
        JTextField delayField = new JTextField("1");
        delayField.setBounds(110,35,220,20);


        //Amount Field
        JLabel amountTextField = new JLabel("Amount:");
        amountTextField.setBounds(25,60,80,20);
        amountTextField.setOpaque(true);
        amountTextField.setForeground(Color.BLACK);
        amountTextField.setBackground(Color.WHITE);
        amountTextField.setFont(new Font("Vernanda",Font.BOLD,15));
        //Amount text field
        JTextField amountField = new JTextField("20");
        amountField.setBounds(110,60,220,20);



        //Mention Checkmark
        JCheckBox mentionCheckBox = new JCheckBox();
        mentionCheckBox.setBounds(311,81,30,30);
        mentionCheckBox.setOpaque(true);
        mentionCheckBox.setForeground(Color.BLACK);
        mentionCheckBox.setBackground(Color.WHITE);
        //Mention text field
        JLabel mentionTextField = new JLabel("Mention:");
        mentionTextField.setBounds(230,86,80,20);
        mentionTextField.setOpaque(true);
        mentionTextField.setForeground(Color.BLACK);
        mentionTextField.setBackground(Color.WHITE);
        mentionTextField.setFont(new Font("Vernanda",Font.BOLD,15));

        //Text for spam field
        JLabel textForSpamText = new JLabel("Message:");
        textForSpamText.setBounds(25,120,80,20);
        textForSpamText.setOpaque(true);
        textForSpamText.setForeground(Color.BLACK);
        textForSpamText.setBackground(Color.WHITE);
        textForSpamText.setFont(new Font("Vernanda",Font.BOLD,15));
        //Text for spam field
        JTextField textForSpamTextField = new JTextField("");
        textForSpamTextField.setBounds(110,120,220,20);







        //Spam button
        JButton spam = new JButton("Spam!");
        spam.setBounds(15,200,319,25);
        spam.setBackground(Color.WHITE);
        spam.setForeground(Color.BLACK);
        spam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //Do Spam
                DiscordWebhook webhook = new DiscordWebhook(webhookField.getText());
                if(mentionCheckBox.isSelected()){
                webhook.setContent("@everyone "+textForSpamTextField.getText());
                }else {
                    webhook.setContent(textForSpamTextField.getText());
                }
                try {
                    int numberToSpam = Integer.parseInt(amountField.getText());
                    int delay = Integer.parseInt(delayField.getText());
                    for(int i = 0; i<numberToSpam;){
                        webhook.execute();
                        i++;
                        Thread.sleep(delay*1000);
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        //Nuke button
        JButton nukeButton = new JButton("Nuke!");
        nukeButton.setBounds(15,170,319,25);
        nukeButton.setBackground(Color.WHITE);
        nukeButton.setForeground(Color.BLACK);
        nukeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do Nuke
                URL url = null;
                try {
                    url = new URL(webhookField.getText());
                    HttpURLConnection http = null;
                    http = (HttpURLConnection)url.openConnection();
                    http.setRequestMethod("DELETE");
                    System.out.println(http.getResponseCode() + " " + http.getResponseMessage());
                    http.disconnect();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });




        //Return button
        JButton maingui = new JButton("Return to main frame");
        maingui.setBounds(15,230,319,25);
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

        frame.add(webhookField);
        frame.add(webhookFieldText);

        frame.add(delayField);
        frame.add(delayTextField);

        frame.add(amountTextField);
        frame.add(amountField);

        frame.add(mentionCheckBox);
        frame.add(mentionTextField);

        frame.add(textForSpamText);
        frame.add(textForSpamTextField);

        frame.add(maingui);
        frame.add(spam);
        frame.add(nukeButton);
    }
}
