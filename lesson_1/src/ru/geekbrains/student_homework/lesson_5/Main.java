package ru.geekbrains.student_homework.lesson_5;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        //First task
        Integer[] array = new Integer[2];
        array[0] = 1;
        array[1] = 2;

        ArraysTransformer.swapTwoElOfArray(array, 0, 1);
        System.out.println(array[0] + " " + array[1]);

        //Second task

        List<Integer> arrayList = ArraysTransformer.transformArrayToArrayList(array);

        System.out.println(arrayList);
        
        //Third task
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        for (int i = 0; i < 5; i++)
            orangeBox.addFruit(new Orange());
        for (int i = 0; i < 5; i++)
            appleBox1.addFruit(new Apple());

        System.out.println(orangeBox.compare(appleBox1));
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>();
        for (int i = 0; i < 5; i++)
            appleBox2.addFruit(new Apple());
        appleBox1.pourIntoAnotherBox(appleBox2);

        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());
    }
}
