package com.geekbrains.homework;

public class Main {

    public static void main(String[] args) {
//        1 Задать размерность матрицы от 5 до 7
//        2 Создать матрицу с указанной размерностью
//        3 Заполнить матрицу по спирали (числа увеличиваются на 1) (число начинается с 1)
        printSpiralMatrix(5, 7);
        printSpiralMatrix(7, 5);
        printSpiralMatrix(6, 8);
        printSpiralMatrix(5, 6);
        printSpiralMatrix(6, 5);

    }

    private static void printSpiralMatrix(int row, int column) {
        int chRow = row;
        int chColumn = column;
        int[][] matrix = new int[row][column];
        int number = 1;
        boolean flagRow = true;
        boolean flagColumn = true;
        for (int i = 0; i < row + row - 1; i++) {
            if (i % 2 == 0) {
                if (flagColumn) {
                    for (int j = column - chColumn; j < chColumn; j++) {
                        matrix[column - chColumn][j] = number++;
                    }
                    chColumn--;
                } else {
                    for (int j = chColumn - 1; j > column - chColumn - 2; j--) {
                        matrix[chRow][j] = number++;
                    }
                }
                flagColumn = !flagColumn;
            } else {
                if (flagRow) {
                    for (int j = row - chRow + 1; j < chRow; j++) {
                        matrix[j][chColumn] = number++;
                    }
                    chRow--;
                } else {
                    for (int j = chRow - 1; j > row - chRow - 1; j--) {
                        matrix[j][column - chColumn - 1] = number++;
                    }
                }
                flagRow = !flagRow;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
