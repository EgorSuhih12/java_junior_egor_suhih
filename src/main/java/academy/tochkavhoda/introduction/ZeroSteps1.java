package academy.tochkavhoda.introduction;

public class ZeroSteps1 {

    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public int mod(int x, int y) {
        return x % y;
    }

    public boolean isEqual(int x, int y) {
        return x == y;
    }

    public boolean isGreater(int x, int y) {
        return x > y;
    }

    public double calculateTriangleSquare(int side1, int side2) {
        return side1 * side2 / 2.0;
    }

    public double calculateTrianglePerimeter(int side1, int side2) {
        double hypotenuse = Math.sqrt(side1 * side1 + side2 * side2);
        return side1 + side2 + hypotenuse;
    }

    public int reverseNumber(int number) {
        int firstDigit = number / 100;
        int secondDigit = number / 10 % 10;
        int thirdDigit = number % 10;

        return thirdDigit * 100 + secondDigit * 10 + firstDigit;
    }

    public long calculate15Degree(int number) {
        long secondDegree = (long) number * number;
        long thirdDegree = secondDegree * number;
        long sixthDegree = thirdDegree * thirdDegree;
        long twelfthDegree = sixthDegree * sixthDegree;

        return twelfthDegree * thirdDegree;
    }

    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        return x >= xLeft && x <= xRight && y >= yTop && y <= yBottom;
    }

    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }

    public boolean isTriangleExist(int side1, int side2, int side3) {
        return side1 + side2 > side3
                && side1 + side3 > side2
                && side2 + side3 > side1;
    }

    public int getDigitsProduction(int number) {
        int firstDigit = number / 1000;
        int secondDigit = number / 100 % 10;
        int thirdDigit = number / 10 % 10;
        int fourthDigit = number % 10;

        return firstDigit * secondDigit * thirdDigit * fourthDigit;
    }

    public boolean isCircleInsideSquare(int radius, int side) {
        return radius * 2 < side;
    }

    public char getCharByCode(short code) {
        return (char) code;
    }

    public short getCodeByChar(char character) {
        return (short) character;
    }

    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }

    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }

    public char getAverageChar(char ch1, char ch2) {
        return (char) ((ch1 + ch2) / 2);
    }
}
