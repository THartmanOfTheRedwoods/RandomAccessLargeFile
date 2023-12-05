import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessManager {
    private RandomAccessFile randomAccessFile;
    private long fileSize;

    public RandomAccessManager(String filePath) throws IOException {
        randomAccessFile = new RandomAccessFile(filePath,"r");
        fileSize = randomAccessFile.length();
    }

    public synchronized String getNexLine() throws IOException {
        return randomAccessFile.readLine();
    }

    public synchronized boolean hasNextLine() throws IOException {
        long savePos = randomAccessFile.getFilePointer();
        return (savePos < fileSize);
    }
}