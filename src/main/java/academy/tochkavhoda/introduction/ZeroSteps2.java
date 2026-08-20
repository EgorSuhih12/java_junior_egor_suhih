package academy.tochkavhoda.introduction;

public class ZeroSteps2 {

    public int sumSquares(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            sum = sum + i * i;
        }
        return sum;
    }

    public int sumOdds(int count) {
        int sum = 0;
        for (int i = 1; i <= count; i++) {
            if (i % 2 != 0) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public double sumInverses(int count) {
        double sum = 0;
        for (int i = 1; i <= count; i++) {
            sum = sum + 1.0 / i;
        }
        return sum;
    }

    public long factorial(int count) {
        long result = 1;

        for (int i = 1; i <= count; i++) {
            result = result * i;
        }

        return result;
    }

    public int prodDigits(int value) {
        if (value == 0) {
            return 0;
        }

        int product = 1;
        int currentValue = Math.abs(value);

        while (currentValue > 0) {
            product = product * (currentValue % 10);
            currentValue = currentValue / 10;
        }

        return product;
    }

    public int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }

        int previous = 0;
        int current = 1;

        for (int i = 2; i <= number; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }

        return current;
    }

    public long sum2Powers(int max) {
        long sum = 0;
        long power = 1;

        for (int i = 0; i <= max; i++) {
            sum = sum + power;
            power = power * 2;
        }

        return sum;
    }

    public int sumSquaresWithBarrier(int count, int barrier) {
        int sum = 0;

        for (int i = 1; i <= count; i++) {
            sum = sum + i * i;

            if (sum > barrier) {
                break;
            }
        }

        return sum;
    }

    public int sumPairProd(int count1, int count2) {
        int sum = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum = sum + i * j;
            }
        }

        return sum;
    }

    public int sumPairProdWithBarrier(int count1, int count2, int barrier) {
        int sum = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                int product = i * j;

                if (product < barrier) {
                    sum = sum + product;
                }
            }
        }

        return sum;
    }

    public double sumInversePairProd(int count1, int count2) {
        double sum = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                sum = sum + 1.0 / (i * j);
            }
        }

        return sum;
    }

    public int sumTripleProd(int count1, int count2, int count3) {
        int sum = 0;

        for (int i = 1; i <= count1; i++) {
            for (int j = 1; j <= count2; j++) {
                for (int k = 1; k <= count3; k++) {
                    sum = sum + i * j * k;
                }
            }
        }

        return sum;
    }

    public double calculateE() {
        double sum = 0;
        double currentValue = 1;
        int number = 1;

        // Складываем ряд, пока очередной элемент не стал меньше 1E-6.
        while (currentValue >= 1E-6) {
            sum = sum + currentValue;
            currentValue = currentValue / number;
            number++;
        }

        return sum;
    }

    public double calculatePi() {
        double sum = 0;
        int denominator = 1;
        int sign = 1;

        // Ряд Лейбница: знаки чередуются, знаменатель каждый раз увеличивается на 2.
        while (1.0 / denominator >= 1E-8) {
            sum = sum + sign * (1.0 / denominator);
            denominator = denominator + 2;
            sign = -sign;
        }

        return 4 * sum;
    }

    public double calculateCircleSquare(double length, int count) {
        int pointsInCircle = 0;
        double radius = length / 2;
        double centerX = length / 2;
        double centerY = length / 2;

        // Метод Монте-Карло: считаем, сколько случайных точек попало внутрь круга.
        for (int i = 0; i < count; i++) {
            double x = Math.random() * length;
            double y = Math.random() * length;

            double dx = x - centerX;
            double dy = y - centerY;

            if (dx * dx + dy * dy <= radius * radius) {
                pointsInCircle++;
            }
        }

        return length * length * pointsInCircle / count;
    }
}
