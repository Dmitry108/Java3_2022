package generics.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    //Написать метод, который меняет два элемента массива местами.(массив может быть любого ссылочного типа)
    public static <T> void replace(T[] array, int first, int second) {
        T temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    //Написать метод, который преобразует массив в ArrayList
    public static <T> ArrayList<T> toArrayList(T[] array) {
        ArrayList<T> list = new ArrayList<>(Arrays.asList(array));
        return list;
    }

    public static void main(String[] args) {
        String[] strArray = {"first", "second", "third", "fourth", "fifth"};
        replace(strArray, 0, 3);
        System.out.println(Arrays.toString(strArray));
        List<String> list = toArrayList(strArray);
        System.out.println(list.get(0));
    }
}