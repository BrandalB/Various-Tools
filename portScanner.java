package BrandalBT;
import java.net.InetSocketAddress;
import java.net.Socket;
public abstract class portScanner {

    public static void selfScan(){
    /*
     * Scans your local host to see which ports are open prints the ports
     * Parameters: NONE
     * Return: NONE
     */
        for(int port = 1;port <= 65535;port++){
            try{
                Socket s = new Socket();
                s.connect(new InetSocketAddress("localhost", port),100);
                s.close();
                System.out.println("Port " + port + " is open");
            }catch(Exception ex){}
        }    
    }
    /*
     * Scans a given server to see the ports that are open
     * Parameters: String hostname - the name of the server you wish to scan
     * Returns: NONE
     * 
     */
    public static void openPortScan(String hostname){
        for(int port = 1;port <= 65535;port++){
            try{
                Socket s = new Socket();
                s.connect(new InetSocketAddress(hostname, port),100);
                s.close();
                System.out.println("Port " + port + " is open");
            }catch(Exception ex){}
        }    
    }
    /*
     * Checks the port on a given server to see if its open
     * Parameters: String hostname - the name of the server you wish to scan
     *             int port - the port to be checked 
     * Returns: boolean - true - open
     *                  - false - closed
     */
    public static boolean isPortOpen(String hostname,int port){
        try{
            Socket s = new Socket();
            s.connect(new InetSocketAddress(hostname, port),200);
            s.close();
            System.out.println("Port " + port + " is open");
            return true;
        }catch(Exception ex){}
        System.out.println("Port " + port + " is closed");
        return false;
    }
    
}
