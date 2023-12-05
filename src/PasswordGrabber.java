import java.io.FileNotFoundException;
import java.io.IOException;

public class PasswordGrabber implements Runnable{
    RandomAccessManager ram;

    public PasswordGrabber(RandomAccessManager ram) {
        this.ram = ram;
    }

    @Override
    public void run() {
        try {
            String line;
            while( ram.hasNextLine() ) {
                line = ram.getNexLine();
                System.out.printf("%d: %s%n", Thread.currentThread().threadId(), line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("That's an invalid file.");
        } catch (IOException ioe) {
            System.out.println("Could not read farther.");
        }
    }
}
