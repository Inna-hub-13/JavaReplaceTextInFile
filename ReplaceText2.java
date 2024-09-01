import java.util.*;
import java.io.*;

public class ReplaceText2 {

    public static void main(String[] args) {

        try{

            File file = new File("temp.txt");

            replaceString(file, "Bowling", "Exception");

            String str = Methods.read(file);
            System.out.println(str);

            System.out.println("File " + file.getName()
                    + " last modified " + new Date(file.lastModified()));
        }
        catch(Exception ex) {

            System.out.println(ex);
        }
    }


    public static void replaceString(File file, String newString, String oldString) throws IOException {

        String readStr = Methods.read(file);
        String writeStr = "";

        int oldLength = oldString.length();
        for(int i = 0, j = 0; i < readStr.length();) {

            if(readStr.charAt(i) == oldString.charAt(0)) {

                while(j < oldLength) {

                    if(readStr.charAt(i + j) != oldString.charAt(j))
                        break;
                    j++;
                }

                //Found match
                if(j == oldLength) {

                    writeStr += newString;
                    j = 0;
                    // jumps over the checked sequence of characters
                    i += oldLength;
                }

                else {

                    writeStr += readStr.charAt(i);
                    i++;
                }

            }

            else {

                writeStr += readStr.charAt(i);
                i++;
            }
        }

        Methods.write(file, writeStr);
    }
}
