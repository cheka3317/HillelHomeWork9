package app;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[][] matrix = new int[4][4];
        Random random = new Random();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = random.nextInt(50) + 1;
            }
        }

        System.out.println("Матриця 4x4:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }

        int sumEvenRows = 0;
        int sumOddRows = 0;
        long productEvenCols = 1;
        long productOddCols = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i % 2 == 0) {
                    sumEvenRows += matrix[i][j];
                } else {
                    sumOddRows += matrix[i][j];
                }

                if (j % 2 == 0) {
                    productEvenCols *= matrix[i][j];
                } else {
                    productOddCols *= matrix[i][j];
                }
            }
        }

        System.out.println("\nСума елементів у парних рядках (0, 2): " + sumEvenRows);
        System.out.println("Сума елементів у непарних рядках (1, 3): " + sumOddRows);
        System.out.println("Добуток елементів у парних стовпцях (0, 2): " + productEvenCols);
        System.out.println("Добуток елементів у непарних стовпцях (1, 3): " + productOddCols);

        boolean isMagic = true;
        int magicSum = 0;

        for (int j = 0; j < matrix[0].length; j++) {
            magicSum += matrix[0][j];
        }

        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != magicSum) {
                isMagic = false;
            }
        }

        for (int j = 0; j < matrix[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < matrix.length; i++) {
                colSum += matrix[i][j];
            }
            if (colSum != magicSum) {
                isMagic = false;
            }
        }

        int diag1 = 0;
        int diag2 = 0;

        for (int i = 0; i < matrix.length; i++) {
            diag1 += matrix[i][i];
            diag2 += matrix[i][matrix.length - 1 - i];
        }

        if (diag1 != magicSum || diag2 != magicSum) {
            isMagic = false;
        }

        if (isMagic) {
            System.out.println("\nМатриця є магічним квадратом.");
        } else {
            System.out.println("\nМатриця не є магічним квадратом.");
        }
    }
}

