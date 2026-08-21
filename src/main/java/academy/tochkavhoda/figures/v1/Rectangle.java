package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class Rectangle {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point leftTop, Point rightBottom) {
        topLeft = leftTop;
        bottomRight = rightBottom;
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom));
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(1, 1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();

        topLeft.moveTo(x, y);
        bottomRight.moveTo(x + length, y + width);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        stretch(ratio, ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);

        bottomRight.moveTo(
                topLeft.getX() + newLength,
                topLeft.getY() + newWidth
        );
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2.0 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX()
                && x <= bottomRight.getX()
                && y >= topLeft.getY()
                && y <= bottomRight.getY();
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    public boolean isIntersects(Rectangle rectangle) {
        return bottomRight.getX() >= rectangle.topLeft.getX()
                && topLeft.getX() <= rectangle.bottomRight.getX()
                && bottomRight.getY() >= rectangle.topLeft.getY()
                && topLeft.getY() <= rectangle.bottomRight.getY();
    }

    public boolean isInside(Rectangle rectangle) {
        return isInside(rectangle.topLeft)
                && isInside(rectangle.bottomRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rectangle rectangle = (Rectangle) o;
        return Objects.equals(topLeft, rectangle.topLeft)
                && Objects.equals(bottomRight, rectangle.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}
