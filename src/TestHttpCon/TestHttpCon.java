package TestHttpCon;

import RTools.TestCodeBox;
import org.apache.http.NameValuePair;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by ReaperMan on 5/18/2016.
 */
public class TestHttpCon {
    public static boolean debugEnabled = false;

    public static void main(String[] args) {
        try{
            executeParameters(args);
        }
        catch(Exception e){
            System.out.println("***Error: " +e);
        }
    }

    private static void executeParameters(String[] args) {
        try {
            if (args[0].toString().equalsIgnoreCase("noob")) {
                System.out.println("About to start GUI");
                THCGui window = new THCGui("N00b GUI for TestHttpCon Utility", 640, 480);

            } else {
                debugEnabled = true;
                String url = args[0];
                ArrayList<String> protocols = new ArrayList<String>();
                for (int i = 1; i < args.length; i++) {
                    if (checkArrayElementExists(args, i)) {
                        showDebug("args value: " + args[i]);
                        protocols.add(args[i]);
                    }
                }
                showDebug("Args size: " + args.length);
                showDebug(url + "******" + protocols);

                showDebug("about to instantiate TCB");
                TestCodeBox tb = new TestCodeBox();
                showDebug("Instantiated TCB");
                tb.setdebugMode(true);
                ArrayList<NameValuePair> parameters = new ArrayList<NameValuePair>();
                String[] protArray = new String[protocols.size()];
                protArray = protocols.toArray(protArray);
                print("*********Attempting to Open Connection*********");
                print("");
                tb.attemptHTTPSPostConnection(url, parameters, protArray);
                print("");
                print("*********Finished*********");
            }
        } catch (NoClassDefFoundError e) {
            showDebug("****NOCLASS ERROR****" + e);
        }
        catch(SecurityException e){
            showDebug("***Security Exception: " + e);
        }
        catch (Exception e) {
            showDebug("***Error: " + e);
        }
    }

    private static JFrame initializeGUI(String titleOfWindow) {
        JFrame window = new JFrame();
        window.setSize(640,480);
        window.setTitle(titleOfWindow);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLayout(new FlowLayout());
        JTextArea tbox1 = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(tbox1);
        tbox1.append("This is a test string for the textbox");
        window.add(scrollPane);
        window.setVisible(true);
        //Drawer drawComponent = new Drawer();
        //drawComponent.paint();
        JTextArea tbox2 = new JTextArea(5,25);
        window.add(tbox2);
        tbox2.append("Test");
        JTextArea tbox3 = new JTextArea(5,40);
        tbox3.append("Test3");
        window.add(tbox3);
        return window;
    }


    private static Boolean checkArrayElementExists(String[] array, int index) {
        try {
            String test = array[index];
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }

    }

    private static void showDebug(String message) {
        if (debugEnabled) {
            System.out.println(message);
        }
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
