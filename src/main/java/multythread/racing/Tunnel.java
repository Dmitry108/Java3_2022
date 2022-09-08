package multythread.racing;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private final int max;
    private final Semaphore sph;

    public Tunnel(int max) {
        this.length = 80;
        this.max = max;
        this.description = "Тоннель " + length + " метров";
        this.sph = new Semaphore(max);
    }
    @Override
    public void go(Car c) {
        try {
            try {
                toLog(c.getName() + " готовится к этапу(ждет): " + description);
                sph.acquire();
                toLog(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                toLog(c.getName() + " закончил этап: " + description);
                sph.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}