package multythread.racing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Stage {
    protected int length;
    protected String description;

    public abstract void go(Car c);

    public void toLog(String message) {
        System.out.printf("%s: %s%n", LocalTime.now(), message);
    }
}