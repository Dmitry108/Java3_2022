package multythread.racing;

import java.util.Vector;

public interface Competition {
    void initRacing();
    void start();
    void finish();
    void showResults(Vector<Result> table);
}
