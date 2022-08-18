package multythread.abc;

public class ABCMain {

    public static void main(String[] args) {
        StringBuffer string = new StringBuffer();
        LettersThread a = new LettersThread('A', 0, string);
        LettersThread b = new LettersThread('B', 1, string);
        LettersThread c = new LettersThread('C', 2, string);
        a.start();
        b.start();
        c.start();
        try {
            a.join();
            b.join();
            c.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(string);
    }
}