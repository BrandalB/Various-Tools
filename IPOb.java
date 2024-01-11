package BrandalBT;
import java.net.Socket;
import java.net.InetSocketAddress;

public abstract class IPOb {
    public static String IP2dword(String IP){
        String[] segment = IP.split("\\.");
        //int dword = ((((((Integer.parseInt(segment[0])*256)+Integer.parseInt(segment[1]))*256)+Integer.parseInt(segment[2]))*256)+Integer.parseInt(segment[3]));
        int dword =(206 * 256) + 191;
            dword *= 256 + 158; 
            dword *= 256 + 55;
        return Integer.toString(dword);
    }
    public static String IP2octal(String IP){
        String[] segment = IP.split("\\.");
        String Oct = "0"+segment[0] +"."+"0"+segment[1]+"."+"0"+segment[2]+"."+"0"+segment[3];
        return Oct;
    }
    public static String IP2hex(String IP){
        String[] segment = IP.split("\\.");
        String Hex="";
        int segL = segment.length;
        for (int i = 0; i < segL; i++) {
            int segDec = Integer.parseInt(segment[i]);
            int first = segDec/16;  
            int Q=segDec%16;
            int second=Q%16;
            char fir = (char)first;
            char sec = (char)second;
            if(first<=9){
                first+=48;
                fir = (char)first;
            }
            else if(first>9){
                first+=55;
                fir=(char)first;
            }
            if(second<=9){
                second+=48;
                sec = (char)second;
            }
            else if(second>9){
                second+=55;
                sec=(char)second;
            }
            Hex += "0x"+fir+sec;
            if(i<3){
              Hex+=".";
            }
        }
        return Hex;
    }
    public static String ObscureLink(String hostname, String type){
        InetSocketAddress Inet = new InetSocketAddress(hostname,80);
        String nIP = Inet.getAddress().toString();
        String[] sepIP = nIP.split("/");
        nIP=sepIP[1];
        //System.out.println(nIP);
        String Link = "";
        switch (type) {
            case "hex":
                Link = IP2hex(nIP);
                break;
            case "oct":
                Link = IP2octal(nIP);
                break;
            case "dword":
                Link = IP2dword(nIP);
                break;
            default:
                break; 
        }
        return "https://"+Link;
    }
}
