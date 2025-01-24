package org.example;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.concurrent.Semaphore;

public class Log {
    private String m_fileName;
    private static Log m_instance = null;
    private FileWriter m_fileWriter = null;
    private Object mutex = new Object();

    private Log()
    {
        System.out.println("A Singleton Log Object Created");
    }

    public static synchronized Log getInstance()
    {
        if (m_instance == null)
        {
            m_instance = new Log();
        }

        return m_instance;
    }

    public void init(String fileName)
    {
        m_fileName = fileName;

        try {
            File myObj = new File(m_fileName);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try
        {
            m_fileWriter = new FileWriter(m_fileName);
        }
        catch (IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }





    }

    public void writeLog(String content)
    {

        synchronized (mutex)
        {
            try
            {
                m_fileWriter.write(content);
            } catch (IOException e) {
                //throw new RuntimeException(e);
                e.printStackTrace();
            }
        }




    }

    private void flush() throws IOException {
        m_fileWriter.flush();
    }

    public void close() throws IOException {
        flush();
        m_fileWriter.close();
    }
}
