package org.example;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {


        Log logInstance = Log.getInstance();
        logInstance.init("Hello1.txt");

        // Method 1 - Thread Class
        ThreadImpl t1 = new ThreadImpl(logInstance);
        t1.start();

        ThreadImpl t2 = new ThreadImpl(logInstance);
        t2.start();
        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        logInstance.close();


    }
}