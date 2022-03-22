import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static java.lang.System.out;

public class test {

    public static void main(String[] args) throws IOException, InterruptedException {
//        basic();
//        fileOp();
        httpOp();
    }

    private static void httpOp() throws IOException, InterruptedException {
        HttpClient hc = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(URI.create("https://www.baidu.com")).build();
        HttpResponse<String> response = hc.send(req, HttpResponse.BodyHandlers.ofString());
        out.println(response.body());
    }

    public static void fileOp() throws IOException {
        for (File file : File.listRoots()) {
            out.println(file);
        }

        File f = new File("jt.txt");
        out.println(f.createNewFile());
        out.println(f.canWrite());
        new FileOutputStream(f).write("aaa".getBytes());
        out.println(new String(new FileInputStream("jt.txt").readAllBytes()));
    }

    public static void basic() {
        String abc = "hello java";
        out.printf("format: %s\n", abc);
        String a = abc.substring(abc.indexOf("j"));
        out.println(a);

        for (int i = 0; i < 10; i++) {
            out.println(i);
        }
        out.println(Math.abs(10.20));
        out.println(Math.random());
        StringBuffer sb = new StringBuffer();
        sb.append(222);
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
        out.printf("result: %s\n", sb.toString());

        String[] array = {"11", "22", "3", "4", "6", "8", "10"};
        out.println(array);
        for (String s : array) {
            out.println(s);
        }
        Arrays.sort(array);
        for (String s : array) {
            out.println(s);
        }

        Date d = new Date();
        out.println(d.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        out.println(sdf.format(d));


        out.println(sum(1, 2));

        AAA aaa = new AAA();
        aaa.c = 10;
        out.println(aaa.su());
    }

    public static int sum(int a, int b) {
        return a + b;
    }

}