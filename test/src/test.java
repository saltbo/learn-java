import static java.lang.System.out;

public class test {

    public static void main(String[] args) {
        String abc = "123";
        out.printf("112233: %s\n", abc);
        abc = "111";
        if (!abc.equals("123")) {
            out.println(abc);
        }

        out.println(sum(1,2));

        AAA aaa = new AAA();
        aaa.c = 10;
        out.println(aaa.su());
    }

    public static int sum(int a, int b) {
        return a + b;
    }

}