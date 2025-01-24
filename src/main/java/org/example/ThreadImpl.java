package org.example;

import org.example.Log.Log;

public class ThreadImpl extends Thread{
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
