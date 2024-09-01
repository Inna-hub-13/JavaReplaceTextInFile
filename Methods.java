import java.io.*;
import java.util.Scanner;

public class Methods {

    public static String read(File file) throws IOException {

        String str = "";
        try(Scanner input = new Scanner(file)) {

            while(input.hasNextLine())
                str += input.nextLine() + "\n";
        }

        return str;
    }

    public static void write(File file, String str) throws IOException {

        try(PrintWriter output = new PrintWriter(file)) {
            output.print(str);
        }
    }
}
