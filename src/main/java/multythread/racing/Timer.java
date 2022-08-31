package multythread.racing;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Timer {
    private final CountDownLatch cdlStart;
    private final CountDownLatch cdlFinish;
    private final CyclicBarrier cb;
    private final Competition competition;
    private final Vector<Result> result = new Vector<>();
    private long timeStart;

    public Timer(int competitorsCount, Competition competition) {
        this.competition = competition;
        this.cdlStart = new CountDownLatch(competitorsCount);
        this.cdlFinish = new CountDownLatch(competitorsCount);
        this.cb = new CyclicBarrier(competitorsCount);
    }

    public void onStart() {
        try {
            cdlStart.countDown();
            if (cdlStart.getCount() == 0) {
                competition.start();
                timeStart = System.currentTimeMillis();
            }
            cb.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void onFinish(Car car) {
        result.add(new Result(car, (int) (System.currentTimeMillis() - timeStart)));
        cdlFinish.countDown();
        if (cdlFinish.getCount() == 0) {
            competition.finish();
            competition.showResults(result);
        }
    }

    public void start() {
        try {
            cdlStart.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}