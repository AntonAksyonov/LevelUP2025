package homework14;

import HomeWork2.Task3;
import HomeWork3.ArraySorting;
import homework7.CheckpointPassage;
import homework7.atomobile.Automobile;
import homework7.atomobile.Truck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@DisplayName("Данный тест проверяет корректность расчёта/действий некоторых домашних заданий")
public class HomeWorksTest {

    @Test
    @DisplayName("расчёт корней квадратного уравнения из 2-го домашнего задания (Task3)")
    public void testRootsQuadraticEquation() {
        Assertions.assertEquals(0, Task3.rootsQuadraticEquation(3, 5, 10).length);
        Assertions.assertEquals(1, Task3.rootsQuadraticEquation(2, 4, 2).length);
        Assertions.assertEquals(2, Task3.rootsQuadraticEquation(-30, 5, 1).length);
    }

    @Test
    @DisplayName("сортировка массива из 3-го домашнего задания (ArraySorting)")
    public void testArraySorting() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        int[] expected = new int[]{1, 2, 2, 3, 43, 45, 89};
        int[] forSorting = {3, 2, 45, 89, 43, 1, 2};
        int[] sortingArray = new int[]{};

        Method sortingMethod = ArraySorting.class.getDeclaredMethod("getSortUp", int[].class);
        sortingMethod.setAccessible(true);
        sortingArray = (int[]) sortingMethod.invoke(sortingArray, forSorting);

        Assertions.assertArrayEquals(expected, sortingArray);
    }

    @Test
    @DisplayName("из 7-го домашнего задания проверка проезда шлагбаума")
    public void testCheckpointPassage() {

        Automobile automobile = new Truck("54845", 75, 4, 2, 4, 8);
        Assertions.assertEquals(true, new CheckpointPassage(automobile).getPassageAllowed());

        automobile = new Truck("54845", 85, 4, 2, 4, 8);
        Assertions.assertEquals(false, new CheckpointPassage(automobile).getPassageAllowed());
    }
}