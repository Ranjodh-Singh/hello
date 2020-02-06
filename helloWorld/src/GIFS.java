import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GIFS {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String args[]) throws Exception {
  String line ="burger.letters.com - - [01/Jul/1995:00:00:12 -0400] \"GET /shuttle/countdown/video/livevideo.GIF HTTP/1.0\" 200 0";

        String token[] =line.split(" ");
        System.out.println(token.length);
        System.out.println(token[5]+token[6]+token[8]);
        if(token[5].indexOf("GET")>=0 && (token[6].indexOf("gif")>=0 ||token[6].indexOf("GIF")>=0 ) && token[8].indexOf("200")>=0 ){
            System.out.println(token[6]);
            String[] split = token[6].split("/");
            System.out.println(split[split.length-1]);
        }

    }
}
