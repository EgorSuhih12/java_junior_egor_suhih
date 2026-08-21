package academy.tochkavhoda.introduction;

public class ZeroSteps4 {

    private final ZeroSteps3 zeroSteps3 = new ZeroSteps3();

    public int min(int[][] matrix) {
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int rowMin = zeroSteps3.min(matrix[i]);

            if (rowMin < minValue) {
                minValue = rowMin;
            }
        }

        return minValue;
    }

    public int max(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int rowMax = zeroSteps3.max(matrix[i]);

            if (rowMax > maxValue) {
                maxValue = rowMax;
            }
        }

        return maxValue;
    }

    public boolean find(int[][] matrix, int value) {
        for (int i = 0; i < matrix.length; i++) {
            if (zeroSteps3.find(matrix[i], value)) {
                return true;
            }
        }

        return false;
    }

    public boolean isSortedDescendant(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!zeroSteps3.isSortedDescendant(matrix[i])) {
                return false;
            }
        }

        return true;
    }

    public int hasNoZeroRows(int[][] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (!zeroSteps3.find(matrix[i], 0)) {
                count++;
            }
        }

        return count;
    }

    public boolean hasFullZeroRow(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length > 0 && isFullZero(matrix[i])) {
                return true;
            }
        }

        return false;
    }

    public boolean isSymmetric(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }

        return true;
    }

    public int mainDiagonalMax(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix[i].length && matrix[i][i] > maxValue) {
                maxValue = matrix[i][i];
            }
        }

        return maxValue;
    }

    public int mainDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (i < matrix[i].length && matrix[i][i] > 0) {
                sum = sum + matrix[i][i];
            }
        }

        return sum;
    }

    public int secondaryDiagonalMax(int[][] matrix) {
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            int j = matrix.length - 1 - i;

            if (j >= 0 && j < matrix[i].length && matrix[i][j] > maxValue) {
                maxValue = matrix[i][j];
            }
        }

        return maxValue;
    }

    public int secondaryDiagonalPositivesSum(int[][] matrix) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            int j = matrix.length - 1 - i;

            if (j >= 0 && j < matrix[i].length && matrix[i][j] > 0) {
                sum = sum + matrix[i][j];
            }
        }

        return sum;
    }

    public int[][] matrixSum(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[matrix1.length][];

        for (int i = 0; i < matrix1.length; i++) {
            result[i] = new int[matrix1[i].length];

            for (int j = 0; j < matrix1[i].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        return result;
    }

    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void interchange(int[][] matrix) {
        for (int i = 0; i < matrix.length; i = i + 2) {
            int[] temp = matrix[i];
            matrix[i] = matrix[i + 1];
            matrix[i + 1] = temp;
        }
    }

    public int[] toLinearByRow(int[][] matrix) {
        int[] result = new int[countElements(matrix)];
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[index] = matrix[i][j];
                index++;
            }
        }

        return result;
    }

    public int[] toLinearByColumn(int[][] matrix) {
        int[] result = new int[matrix.length * matrix.length];
        int index = 0;

        for (int j = 0; j < matrix.length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                result[index] = matrix[i][j];
                index++;
            }
        }

        return result;
    }

    public int[] toLinearByRowUpperTriangle(int[][] matrix) {
        int size = matrix.length * (matrix.length + 1) / 2;
        int[] result = new int[size];
        int index = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                result[index] = matrix[i][j];
                index++;
            }
        }

        return result;
    }

    public int sumUntilNotFoundInRow(int[][] matrix, int barrier) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == barrier) {
                    break;
                }

                sum = sum + matrix[i][j];
            }
        }

        return sum;
    }

    public int sumUntilNotFound(int[][] matrix, int barrier) {
        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == barrier) {
                    return sum;
                }

                sum = sum + matrix[i][j];
            }
        }

        return sum;
    }

    private boolean isFullZero(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                return false;
            }
        }

        return true;
    }

    private int countElements(int[][] matrix) {
        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            count = count + matrix[i].length;
        }

        return count;
    }
}
