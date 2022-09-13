package testing;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrayAfterFour(new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7})));
        System.out.println(isOnlyOneOrFour(new int[]{1, 1, 4, 4}));
    }

    /**  Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
    Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов,
    идущих после последней четверки.
    Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
    Написать набор тестов для этого метода (по 3-4 варианта входных данных).
    Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
    */
    public static int[] arrayAfterFour(int[] array){
        int fourIndex = -1;
        int length = array.length;
        for (int i = length - 1; i >= 0; i--) {
            if (array[i] == 4) {
                fourIndex = i;
                break;
            }
        }
        System.out.println(Arrays.toString(array));
        if (fourIndex == -1) throw new RuntimeException("В массиве нет цифры 4");
        int[] newArray = new int[length -= fourIndex + 1];
        System.arraycopy(array, fourIndex + 1, newArray,0, length);
        return newArray;
    }

    /** Написать метод, который проверяет состав массива из чисел 1 и 4.
     *  Если в нем нет хоть одной четверки или единицы, то метод вернет false;
     *  Написать набор тестов для этого метода (по 3-4 варианта входных данных).
     */
    public static boolean isOnlyOneOrFour(int[] array){
        boolean isOne = false;
        boolean isFour = false;

        for (int a:array) {
            switch (a){
                case 1: if(!isOne) isOne = true; break;
                case 4: if(!isFour) isFour = true; break;
                default: return false;
            }
        }
        return isOne && isFour;
    }
}