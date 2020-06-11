package com.company;

import java.util.Scanner;

public class Main {

    private static void showMatrix(char[][] matrix) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------");
    }

    private static boolean winsX(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            if ((matrix[i][0] == 'X') && (matrix[i][1] == 'X') && (matrix[i][2] == 'X')) {
                return true;
            }
            if ((matrix[0][i] == 'X') && (matrix[1][i] == 'X') && (matrix[2][i] == 'X')) {
                return true;
            }
        }

        if (matrix[0][0] == 'X' && matrix[1][1] == 'X' && matrix[2][2] == 'X') {
            return true;
        }
        if (matrix[2][0] == 'X' && matrix[1][1] == 'X' && matrix[0][2] == 'X') {
            return true;
        }
        return false;
    }


    private static int countEmptyFields(char[][] matrix) {
        int count = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (chars[j] == ' ') {
                    ++count;
                }
            }
        }
        return count;
    }

    private static boolean winsO(char[][] matrix) {
        for (int i = 0; i < 3; i++) {
            if ((matrix[i][0] == 'O') && (matrix[i][1] == 'O') && (matrix[i][2] == 'O')) {
                return true;
            }
            if ((matrix[0][i] == 'O') && (matrix[1][i] == 'O') && (matrix[2][i] == 'O')) {
                return true;
            }
        }

        if (matrix[0][0] == 'O' && matrix[1][1] == 'O' && matrix[2][2] == 'O') {
            return true;
        }
        if (matrix[2][0] == 'O' && matrix[1][1] == 'O' && matrix[0][2] == 'O') {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] field = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = ' ';
            }
        }
        showMatrix(field);
        boolean nextX = true;

        do {
            System.out.println("Enter the coordinates:");
            Scanner scanner = new Scanner(System.in);
            String[] coordinates = scanner.nextLine().split(" ");

            try {
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                if (field[field.length - y][x - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                    continue;
                }
                if (nextX) {
                    field[field.length - y][x - 1] = 'X';
                    nextX = false;
                } else {
                    field[field.length - y][x - 1] = 'O';
                    nextX = true;
                }
                showMatrix(field);

                if (winsX(field)) {
                    System.out.println("X wins");
                    break;
                } else if (winsO(field)) {
                    System.out.println("O wins");
                    break;
                } else if (!winsX(field) && !winsO(field) && countEmptyFields(field) == 0) {
                    System.out.println("Draw");
                    break;
                }

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }
        }
        while (true);
    }
}
