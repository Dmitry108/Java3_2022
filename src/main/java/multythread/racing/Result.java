package multythread.racing;

public class Result implements Comparable<Result> {
    private final Car car;
    private final int time;

    public Result(Car car, int time) {
        this.car = car;
        this.time = time;
    }

    @Override
    public int compareTo(Result result) {
        return this.time - result.time;
    }

    @Override
    public String toString() {
        return String.format("%s (скорость %s) прошел за %d мс%n", car.getName(), car.getSpeed(), time);
    }
}