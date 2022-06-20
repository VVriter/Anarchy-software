package com.writer.encoder.Gui;

import com.writer.encoder.Util.DiscordWebhook;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.*;

public class WebhookSpamGui extends JFrame {




    public  static boolean isEmbeded = false;






    public static void frame(String... args){
        JFrame frame = new JFrame("Webhook spammer");
        int x = (int) ((Toolkit.getDefaultToolkit().getScreenSize().height) / 2);
        int y = (int) ((Toolkit.getDefaultToolkit().getScreenSize().width ) / 2);
        //Centering window
        frame.setBounds(y,x,350,300);

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



        //Author
        JLabel iconUrlField = new JLabel("Author:");
        iconUrlField.setBounds(10000,1000,80,20);
        iconUrlField.setOpaque(true);
        iconUrlField.setForeground(Color.BLACK);
        iconUrlField.setBackground(Color.WHITE);
        iconUrlField.setFont(new Font("Vernanda",Font.BOLD,15));
        //Icon text field
        JTextField iconTextField = new JTextField("");
        iconTextField.setBounds(10000,10000,220,20);
        frame.add(iconTextField);
        frame.add(iconUrlField);

        //Author
        JLabel title = new JLabel("Title:");
        title.setBounds(10000,1000,80,20);
        title.setOpaque(true);
        title.setForeground(Color.BLACK);
        title.setBackground(Color.WHITE);
        title.setFont(new Font("Vernanda",Font.BOLD,15));
        //Icon text field
        JTextField title1 = new JTextField("");
        title1.setBounds(10000,10000,220,20);
        frame.add(title1);
        frame.add(title);

        //Author
        JLabel image = new JLabel("Image:");
        image.setBounds(10000,1000,80,20);
        image.setOpaque(true);
        image.setForeground(Color.BLACK);
        image.setBackground(Color.WHITE);
        image.setFont(new Font("Vernanda",Font.BOLD,15));
        //Icon text field
        JTextField image1 = new JTextField("");
        image1.setBounds(10000,10000,220,20);
        frame.add(image);
        frame.add(image1);

        //Author
        JLabel image3 = new JLabel("Image2:");
        image3.setBounds(10000,1000,80,20);
        image3.setOpaque(true);
        image3.setForeground(Color.BLACK);
        image3.setBackground(Color.WHITE);
        image3.setFont(new Font("Vernanda",Font.BOLD,15));
        //Icon text field
        JTextField image4 = new JTextField("");
        image4.setBounds(10000,10000,220,20);
        frame.add(image3);
        frame.add(image4);

        //Footer
        JLabel foot = new JLabel("Footer:");
        foot.setBounds(10000,1000,80,20);
        foot.setOpaque(true);
        foot.setForeground(Color.BLACK);
        foot.setBackground(Color.WHITE);
        foot.setFont(new Font("Vernanda",Font.BOLD,15));
        //Footer
        JTextField foot1 = new JTextField("");
        foot1.setBounds(10000,10000,220,20);
        frame.add(foot);
        frame.add(foot1);


        //Embed text field
        JLabel embedLabel = new JLabel("Embed?:");
        embedLabel.setBounds(25,81,100,30);
        embedLabel.setOpaque(true);
        embedLabel.setForeground(Color.BLACK);
        embedLabel.setBackground(Color.WHITE);
        embedLabel.setFont(new Font("Vernanda",Font.BOLD,15));

        //Spam button
        JButton spam = new JButton("Spam!");
        spam.setBounds(15,200,319,25);
        spam.setBackground(Color.WHITE);
        spam.setForeground(Color.BLACK);
        spam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Do Spam
                DiscordWebhook.EmbedObject embed = new DiscordWebhook.EmbedObject();
                DiscordWebhook webhook = new DiscordWebhook(webhookField.getText());
                DiscordWebhook simpleDiscordWebhook = null;
                if(mentionCheckBox.isSelected() && !isEmbeded){
                    webhook.setContent("@everyone "+textForSpamTextField.getText());

                } if(!mentionCheckBox.isSelected() && !isEmbeded){
                    webhook.setContent(textForSpamTextField.getText());
                }  if(isEmbeded && mentionCheckBox.isSelected()){
                    webhook.setContent("@everyone");
                    embed.setAuthor(iconTextField.getText(),null,null);
                    embed.setTitle(title1.getText());
                    embed.setDescription(textForSpamTextField.getText());
                    embed.setImage(image1.getText());
                    embed.setThumbnail(image4.getText());
                    embed.setFooter(foot1.getText(),iconTextField.getText());
                    embed.setColor(new Color(0x8B10F14B, true));
                    webhook.addEmbed(embed);
                }if(isEmbeded && !mentionCheckBox.isSelected()){
                    embed.setAuthor(iconTextField.getText(),null,null);
                    embed.setTitle(title1.getText());
                    embed.setDescription(textForSpamTextField.getText());
                    embed.setImage(image1.getText());
                    embed.setThumbnail(image4.getText());
                    embed.setFooter(foot1.getText(),null);
                    embed.setColor(new Color(0x8B10F14B, true));
                    webhook.addEmbed(embed);
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





        //Embed checkmark
        JCheckBox embedCheck = new JCheckBox();
        embedCheck.setBounds(110,81,30,30);
        embedCheck.setOpaque(true);
        embedCheck.setForeground(Color.BLACK);
        embedCheck.setBackground(Color.WHITE);

        embedCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(embedCheck.isSelected()){
                    System.out.println("Okkkk");
                    isEmbeded = true;
                    //REMOVES components for NOT EMBED
                    frame.setBounds(y,x,350,700);
                    maingui.setBounds(15,630,319,25);
                    spam.setBounds(15,600,319,25);
                    nukeButton.setBounds(15,570,319,25);
                    
                    iconTextField.setBounds(110,170,220,20);
                    iconUrlField.setBounds(25,170,80,20);

                    title.setBounds(25,200,80,20);
                    title1.setBounds(110,200,220,20);

                    textForSpamText.setBounds(25,230,80,20);
                    textForSpamTextField.setBounds(110,230,220,20);

                    image.setBounds(25,260,80,20);
                    image1.setBounds(110,260,220,20);

                    image3.setBounds(25,290,80,20);
                    image4.setBounds(110,290,220,20);

                    foot.setBounds(25,320,80,20);
                    foot1.setBounds(110,320,220,20);







                }else {
                    System.out.println("Nooo");
                    isEmbeded = false;
                    //ADD components for NOT EMBED
                    textForSpamText.setBounds(25,120,80,20);
                    textForSpamTextField.setBounds(110,120,220,20);
                    frame.setBounds(y,x,350,300);

                    maingui.setBounds(15,170,319,25);
                    spam.setBounds(15,200,319,25);
                    nukeButton.setBounds(15,230,319,25);

                    iconTextField.setBounds(1100,170,220,20);
                    iconUrlField.setBounds(2500,170,80,20);

                    title.setBounds(2500,200,80,20);
                    title1.setBounds(11000,200,220,20);

                    image.setBounds(1000,260,80,20);
                    image1.setBounds(1000,260,80,20);

                    foot.setBounds(25000,320,80,20);
                    foot.setBounds(110000,310,220,20);

                }
            }
        });






        //add

        frame.add(embedCheck);
        frame.add(embedLabel);

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
