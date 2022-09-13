package annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/** Создать класс, который может выполнять «тесты»,
 *  в качестве тестов выступают классы с наборами методов с аннотациями @Test.
 *  Для этого у него должен быть статический метод start(),
 *  которому в качестве параметра передается или объект типа Class, или имя класса.
 *  Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется,
 *  далее запущены методы с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite.
 *  К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10),
 *  в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый,
 *  то порядок не имеет значения.
 *  Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре,
 *  иначе необходимо бросить RuntimeException при запуске «тестирования».
 */

public class MainTest {
    public static void start(Class<?> classObject) throws RuntimeException {

        Method[] methods = classObject.getDeclaredMethods();
        Method before = null;
        Method after = null;
        ArrayList<Method> tests = new ArrayList<>();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (before == null) {
                    before = method;
                } else throw new RuntimeException("Class has more then one before-method");
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (after == null) {
                    after = method;
                } else throw new RuntimeException("Class has more then one after-method");
            }
            if (method.isAnnotationPresent(Test.class)) {
                tests.add(method);
            }
        }
        tests.sort((one, two) -> one.getAnnotation(Test.class).priority() - two.getAnnotation(Test.class).priority());
        try {
            if (before != null) doMethod(before);
            for (Method test : tests) {
                doMethod(test);
            }
            if (after != null) doMethod(after);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void doMethod(Method method) throws IllegalAccessException, InvocationTargetException {
        System.out.printf("Method - %s : ", method.getName());
        method.invoke(null);
    }

    public static void start(String className) throws ClassNotFoundException {
        start(Class.forName(className));
    }

    public static void main(String[] args) {
        try {
            start("annotations.Testing");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            start(TestingWithBeforeException.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            start(TestingWithAfterException.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}