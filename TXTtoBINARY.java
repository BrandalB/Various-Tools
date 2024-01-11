package BrandalBT;
import java.lang.Math;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;
/**
 * TXTConv: 
 * Returns converted txt file into binary.
 * 
 * MAX DECIMAL SIZE: 255
 */
public abstract class TXTtoBINARY { 
    //User selected file to be converted
    String fileName;
    public static String TXTConv(String fileName){
        ArrayList<String> output = new ArrayList<String>();
        //reading the file
        try {
            char[] tem={}; //array for all the characters in the given line to enter into
            Scanner in = new Scanner(System.in);
            in.close();
            File file = new File(fileName);
            Scanner rf = new Scanner(file);
            while (rf.hasNextLine()) {
            //breaking apart the line    
            String numLine = rf.nextLine(); // getting the line
            tem = numLine.toCharArray(); // breaking the line into individual characters
                for(int j = 0; j<tem.length-1;j++){
                    output.add(decToBinaryConverter(tem[j])); //converting the decimal version of the char 
                                                              //into binary then adding it into the output Arraylist.
                }
            }
            rf.close();
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          String out = "";//final output
        for(int i = 0; i<output.size();i++){
            out += output.get(i);//combining all of the characters into a single string
        }
        return out;
    }
    private static String decToBinaryConverter(int decimal){
        assert decimal<=255;
        String binary = "";
            int tDec = decimal;
            for(int exp =7;0<=exp;exp--){
                int sub = (int)Math.pow(2,exp);
                if(tDec-sub>=0){        //checks to see if 2^n-1 can go into the decimal provided
                    tDec = tDec-sub;    //  
                    binary+="1";        //if 2^n-1 can be subtracted from the decimal provided safely 
                }                       //it will update the decimal and add 1 to the binary output
                else{                   
                    binary+="0";        
                }                       
            }                           
            return binary;
    }
}