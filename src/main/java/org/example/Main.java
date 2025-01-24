package org.example;

import java.io.IOException;

class ThreadImpl extends Thread
{
    // Method to start Thread
    private Log m_logInstance = null;
    ThreadImpl(Log logInstance)
    {
        m_logInstance = logInstance;
    }
    @Override
    public void run()
    {
        String str = "Thread Class Implementation Thread"
                + " is Running Successfully";
        System.out.println(str);
        String res = String.format("Welcome to %s! %d %s", "geeks" , 4 , "hello");

        m_logInstance.writeLog("hello world" + "\n");
        m_logInstance.writeLog(res + "\n");
    }
}

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