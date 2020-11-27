package ru.geekbrains.javalevel3.lesson_7;

public class SomeClass {
    @BeforeSuite
    public static void before() {
        System.out.println("before");
    }

    @AfterSuite
    public static void after() {
        System.out.println("after");
    }

    @Test(priority = 2)
    public static void test1() {
        System.out.println("test 1");
    }

    @Test(priority = 7)
    public static void test2() {
        System.out.println("test 2");
    }

    @Test(priority = 3)
    public static void test3() {
        System.out.println("test 3");
    }

    @Test(priority = 2)
    public static void test4() {
        System.out.println("test 4");
    }

    @Test(priority = 9)
    public static void test5() {
        System.out.println("test 5");
    }

}
