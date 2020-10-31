package ru.geekbrains.student_homework.lesson_5;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private final ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double result = 0.0;
        for (T fruit : fruits) {
            result += fruit.getWeight();
        }
        return result;
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
    }

    public boolean pourIntoAnotherBox(Box<T> box) {
        if (this == box)
            return false;
        box.fruits.addAll(fruits);
        fruits.clear();
        return true;
    }
}
