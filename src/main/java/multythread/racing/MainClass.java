package multythread.racing;

import java.util.Collections;
import java.util.Vector;

public class MainClass implements Competition {
    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        new MainClass().initRacing();
    }

    @Override
    public void initRacing() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(CARS_COUNT / 2), new Road(40));
        Timer timer = new Timer(CARS_COUNT, this);
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), timer);
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        timer.start();
    }

    @Override
    public void start() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
    }

    @Override
    public void finish() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    @Override
    public void showResults(Vector<Result> table) {
        Collections.sort(table);
        for (int i = 0; i < table.size(); i++) {
            System.out.printf("%d место: %s", i + 1, table.get(i));
        }
    }
}