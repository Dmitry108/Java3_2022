package multythread.abc;

public class LettersThread extends Thread {
    private final char letter;
    private static volatile int index = 0;
    private final int order;
    private final StringBuffer string;

    public LettersThread(char letter, int order, StringBuffer string) {
        this.letter = letter;
        this.order = order;
        this.string = string;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (string) {
                while (index % 3 != order) {
                    try {
                        string.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                string.append(letter);
                index++;
                string.notifyAll();
            }
        }
    }
}