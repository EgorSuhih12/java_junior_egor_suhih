package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Square {

    private Point topLeft;
    private int length;

    public Square(Point leftTop, int size) {
        topLeft = leftTop;
        length = size;
    }

    public Square(int xLeft, int yTop, int size) {
        this(new Point(xLeft, yTop), size);
    }

    public Square(int size) {
        this(0, -size, size);
    }

    public Square() {
        this(1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(
                topLeft.getX() + length,
                topLeft.getY() + length
        );
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public int getLength() {
        return length;
    }

    public void moveTo(int x, int y) {
        topLeft.moveTo(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        length = (int) (length * ratio);
    }

    public double getArea() {
        return length * length;
    }

    public double getPerimeter() {
        return 4.0 * length;
    }

    public boolean isInside(int x, int y) {
        Point bottomRight = getBottomRight();

        return x >= topLeft.getX()
                && x <= bottomRight.getX()
                && y >= topLeft.getY()
                && y <= bottomRight.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Square square) {
        Point bottomRight = getBottomRight();
        Point otherBottomRight = square.getBottomRight();

        return bottomRight.getX() >= square.topLeft.getX()
                && topLeft.getX() <= otherBottomRight.getX()
                && bottomRight.getY() >= square.topLeft.getY()
                && topLeft.getY() <= otherBottomRight.getY();
    }

    public boolean isInside(Square square) {
        return isInside(square.topLeft)
                && isInside(square.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Square square = (Square) o;
        return length == square.length
                && Objects.equals(topLeft, square.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, length);
    }
}
