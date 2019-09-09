import java.io.*;
import java.util.ArrayList;

public class Reader {
    public static ArrayList<String> readFile(File file) throws Exception {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader br =  new BufferedReader(new FileReader(file));

        while(br.ready()){
            lines.add(br.readLine());
        }

        return lines;
    }
}
