package BrandalBT;
public abstract class rot13{
    public static String encrypt(String s){
        char[] c = s.toCharArray();
        s = "";
        for (int i = 0; i < c.length; i++) {
            if(c[i]>=97 && c[i]<=123){ // if the character is a letter
                if(c[i] + 13 >= 123){ // keeps the character inside the bounds of the letters and if it overflows it will go back to the beginning with the remainding amount
                    c[i] = (char) (((c[i] + 13) - 123)+97);
                }
                else{
                    c[i] = (char)(c[i]+13);
                }
            }
            else if(c[i]>=48 && c[i]<=58){ // if the character is a number rot5
                if(c[i] + 5 >= 58){
                    c[i] = (char) (((c[i] + 5) - 58)+48);
                }
                else{
                    c[i] = (char)(c[i]+5);
                }
            }
            s+=c[i];
        }
        return s;
    }
    public static String decrypt(String s){// does the same thing as encrypt but the name will suggust that it should only be used on strings that have been encrypted already
        char[] c = s.toCharArray();
        s = "";
        for (int i = 0; i < c.length; i++) {
            if(c[i]>=97 && c[i]<=123){ // if the character is a letter
                if(c[i] + 13 >= 123){ // keeps the character inside the bounds of the letters and if it overflows it will go back to the beginning with the remainding amount
                    c[i] = (char) (((c[i] - 13) - 123)+97);
                }
                else{
                    c[i] = (char)(c[i]+13);
                }
            }
            else if(c[i]>=48 && c[i]<=58){ // if the character is a number rot5
                if(c[i] + 5 >= 58){
                    c[i] = (char) (((c[i] + 5) - 58)+48);
                }
                else{
                    c[i] = (char)(c[i]+5);
                }
            }
            s+=c[i];
        }
        return s;
    }
}