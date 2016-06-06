package TestHttpCon;

import RTools.TestCodeBox;
import org.apache.http.NameValuePair;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

/**
 * Created by ReaperMan on 5/21/2016.
 */
public class THCGui extends JFrame {
    public JTextArea displayConsole = new JTextArea(10, 50);
    public JScrollPane consolePane = new JScrollPane(displayConsole);
    public JTextField httpsURLInput = new JTextField(50);
    public JTextField protocol = new JTextField(50);

    public JButton executeButton = new JButton();

    public THCGui(String titleofWindow, int width, int height) {
        setSize(width, height);
        setTitle(titleofWindow);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        displayConsole.setEditable(false);
        httpsURLInput.setText("https://tls1test.salesforce.com/s/");
        executeButton.setText("Execute Test");
        displayConsole.setLineWrap(true);
        protocol.setText("TLSv1");
        setVisible(true);
        add(httpsURLInput);
        add(consolePane);
        add(executeButton);
        add(protocol);
        executeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayConsole.setText("");
                if(httpsURLInput.getText().contains("The sky is green, and the grass is blue...")){
                    displayConsole.setText("it worked...");
                    wipeMyself();
                    buildSecretGUI();
                }
                else{
                    TestCodeBox tcb = new TestCodeBox();
                    displayConsole.append(tcb.attemptHTTPSPostConnection(httpsURLInput.getText(), new ArrayList<NameValuePair>(), new String[]{protocol.getText()}));
                    if(displayConsole.getText().contains("***SUCCESS***") || displayConsole.getText().isEmpty()){
                        executeButton.setBackground(new Color(0,255,0));
                    }
                    else{
                        executeButton.setBackground(new Color(255,0,0));
                    }
                }

            }
        });
    }

    private void wipeMyself(){
        getContentPane().removeAll();
        revalidate();
        repaint();
    }

    private void buildSecretGUI(){
        JTextField serverAddress = new JTextField(10);
        JButton connectButton = new JButton();
        JTextArea consoleArea = new JTextArea(10,50);
        JScrollPane consolePane = new JScrollPane(consoleArea);
        JTextField chatInput = new JTextField(40);
        JButton sendMessage = new JButton();
        Boolean connectionStatus = false;
        serverAddress.setText("Server IP...");
        connectButton.setText("Connect");
        connectButton.setBackground(new Color(255,0,0));
        consoleArea.setText("Console...");
        chatInput.setText("Type your message here...");
        sendMessage.setText("Send");
        setVisible(true);
        add(serverAddress);
        add(connectButton);
        add(consolePane);
        add(chatInput);
        add(sendMessage);
        validate();

    }
}
