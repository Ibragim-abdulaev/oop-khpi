package abdulaev;

import static org.junit.jupiter.api.Assertions.*;

import ua.khpi.oop.abdulaev09.MyContainer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class test09 {

    MyContainer<Integer> test_container = new MyContainer<Integer>();

    public static int[] getSizeData() {
        return new int[] { 2, 0, 6};
    }

    @Test
    void testConstructor() {
        MyContainer<Integer> test_container1 = new MyContainer<Integer>();
    }


    @ParameterizedTest
    @MethodSource(value = "getSizeData")
    void testGetSize(int data) {
        int size = data;
        int expected = data;
        test_container.setSize(size);
        int actual = test_container.getSize();
        assertEquals(expected, actual, "Have to be equals");
    }

    @Test
    void testAdd() {
        int expected = 3;
        test_container = add(test_container);
        int actual = test_container.getSize();
        assertEquals(expected, actual, "Have to be equals");
    }

    @Test
    void testDelete() {
        test_container = add(test_container);
        boolean expected1 = true;
        boolean actual1 = test_container.delete(2);
        assertEquals(expected1, actual1, "Have to be the same");
        boolean expected2 = true;
        boolean actual2 = test_container.delete(1);
        assertEquals(expected2, actual2, "Have to be the same");
        boolean expected3 = true;
        boolean actual3 = test_container.delete(0);
        assertEquals(expected3, actual3, "Have to be the same");
        boolean expected4 = false;
        boolean actual4 = test_container.delete(0);
        assertEquals(expected4, actual4, "Have to be the same");
        boolean expected5 = false;
        boolean actual5 = test_container.delete(2);
        assertEquals(expected5, actual5, "Have to be the same");
    }

    @Test
    void testGetElement(){
        test_container = add(test_container);
        Integer expected1 = null;
        Integer actual1 = test_container.getElement(-1);
        assertEquals(expected1, actual1);
        Integer expected2 = null;
        Integer actual2 = test_container.getElement(60);
        assertEquals(expected2, actual2);
        Integer expected3 = new Integer (-100);
        Integer actual3 = test_container.getElement(2);
        assertEquals(expected3, actual3);
    }

    @Test
    void testIsEmpty() {
        boolean expected_t = true;
        boolean actual_t = test_container.isEmpty();
        assertEquals(expected_t, actual_t, "Have to be equals");
        test_container = add(test_container);
        boolean expected_f = false;
        boolean actual_f = test_container.isEmpty();
        assertEquals(expected_f, actual_f, "Have to be equals");
    }

    @Test
    void testClear() {
        test_container = add(test_container);
        test_container.clear();
        int expected = 0;
        int actual = test_container.getSize();
        assertEquals(expected, actual, "Have to be the same");
    }

    @Test
    void testToString() {
        test_container = add(test_container);
        String expected = "500" + "\n" + "46000" + "\n" + "-100" + "\n";
        String actual = test_container.toString();
        assertEquals(expected, actual, "Have to be the same");
    }

    @Test
    void testToArray(){
        Object[] obj_expected = new Object[3];
        Object[] obj_actual = new Object[3];
        obj_expected[0] = new Integer (500);
        obj_expected[1] = new Integer (46000);
        obj_expected[2] = new Integer (-100);
        test_container = add(test_container);
        obj_actual = test_container.toArray();
        assertEquals(obj_expected[0], obj_actual[0], "Have to be the same");
        assertEquals(obj_expected[1], obj_actual[1], "Have to be the same");
        assertEquals(obj_expected[2], obj_actual[2], "Have to be the same");
    }

    MyContainer<Integer> add(MyContainer<Integer> container){
        Integer a = new Integer (500);
        Integer b = new Integer (46000);
        Integer c = new Integer (-100);
        container.add(a);
        container.add(b);
        container.add(c);
        return container;
    }
}
