package RCLI;

import RTools.TestCodeBox;
import org.apache.http.NameValuePair;

import java.util.ArrayList;

/**
 * Created by ReaperMan on 5/18/2016.
 */
public class TestHttpCon {
    public static boolean debugEnabled = false;
    public static void main(String[] args){
        try{
            String url = args[0];
            ArrayList <String> protocols = new ArrayList<String>();
            for(int i = 1; i<args.length; i++){
                if(checkArrayElementExists(args, i)){
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
        catch(NoClassDefFoundError e){
            showDebug("****NOCLASS ERROR****" + e);
        }
        catch(Exception e){
            showDebug("Error: " + e);
        }
    }
    public static Boolean checkArrayElementExists(String[] array, int index){
        try{
            String test = array[index];
            return true;
        } catch(ArrayIndexOutOfBoundsException e){
            return false;
        }

    }
    public static void showDebug(String message){
        if(debugEnabled){
            System.out.println(message);
        }
    }
    public static void print(String message){
        System.out.println(message);
    }
}
