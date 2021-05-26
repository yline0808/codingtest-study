package chapter01;

public class Test01 {
    public static void main(String[] args) {
        System.out.print("Hello world");

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("total run time : " + (endTime - startTime) / 1000.0 + "s");
    }
}