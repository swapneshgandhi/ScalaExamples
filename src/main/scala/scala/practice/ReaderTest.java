package scala.practice;

import java.io.IOException;

public class ReaderTest {

    public static void main(String[] args) throws IOException {

        ReaderMY obj = new ReaderMY("input.txt");

        int c = 0;

        while ((c = obj.read()) != -1) {
            System.out.print((char) c);
        }

    }

}
