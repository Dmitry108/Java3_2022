package generics.fruits;

//a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
//b. Класс Box в который можно складывать фрукты, коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//c. Для хранения фруктов внутри коробки можете использовать ArrayList;
//d. Сделать метод getWeight() который высчитывает вес коробки, зная количество фруктов и вес одного фрукта
// (вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
//e. Внутри класса коробка сделать метод compare, который позволяет сравнить текущую коробку с той,
// которую подадут в compare в качестве параметра, true - если их веса равны, false в противном случае
// (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//f. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую коробку
// (помним про сортировку фруктов, нельзя яблоки высыпать в коробку с апельсинами),
// соответственно в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в этой коробке;
//g. Не забываем про метод добавления фрукта в коробку.

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Apple> apples = Arrays.asList(new Apple(), new Apple(), new Apple());
        List<Orange> oranges = Arrays.asList(new Orange(), new Orange());
        Box<Apple> appleBox = new Box<>(apples);
        Box<Orange> orangeBox = new Box<>(oranges);

        System.out.println(appleBox.compare(orangeBox));
        System.out.println(appleBox);
        Box<Apple> appleBox2 = new Box<>();
        appleBox.transferToBox(appleBox2);
        System.out.println(appleBox);
        System.out.println(appleBox2);
    }
}