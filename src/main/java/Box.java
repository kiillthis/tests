import java.util.Objects;

public class Box {

    private Long id;
    private Long width;
    private Long length;
    private Long square;

    public Box() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWidth() {
        return width;
    }

    public void setWidth(Long width) {
        this.width = width;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public Long getSquare() {
        return square;
    }

    public void setSquare(Long square) {
        this.square = square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return Objects.equals(id, box.id) && Objects.equals(width, box.width) && Objects.equals(length, box.length) && Objects.equals(square, box.square);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, width, length, square);
    }
}
