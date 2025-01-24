package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String res = String.format("Welcome to %s! %d %s", "geeks" , 4 , "hello");
        Log logInstance = Log.getInstance();
        logInstance.init("Hello1.txt");
        logInstance.writeLog("hello world" + "\n");
        logInstance.writeLog(res + "\n");
        logInstance.writeLog("hello world\n");
        System.out.println("Hello world!");
        System.out.println(s);
        logInstance.close();
    }
}