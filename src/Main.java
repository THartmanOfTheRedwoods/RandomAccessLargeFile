import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RandomAccessManager ram = null;
        Scanner s = new Scanner(System.in);
        System.out.print("Input a file path: ");
        String filePath = s.nextLine();
        try {
            ram = new RandomAccessManager(filePath);
        } catch (FileNotFoundException fnf) {
            System.err.println("Failed to locate file.");
        } catch (IOException ioe) {
            System.err.println("Failed to load file.");
        }
        int threadCount = 10;
        if(args.length == 1) {
            threadCount = Integer.parseInt(args[0]);
            System.out.printf("~~~ Using %d threads. ~~~%n", threadCount);
        }
        Thread[] threads = new Thread[threadCount];
        // Thread instantiating loop
        for(int i=0; i<threads.length; i++) {
            threads[i] = new Thread(new PasswordGrabber(ram));
        }
        // Thread start loop
        for(int i=0; i<threads.length; i++) {
            threads[i].start();
        }
    }
}
