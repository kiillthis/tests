import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Objects;

public class Order {

    private Long id;
    private String name;
    private Long duration;

    public Order() {
    }

    @JsonGetter("identification")
    public Long getId() {
        return id;
    }

    @JsonSetter("identification")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonGetter("label")
    public String getName() {
        return name;
    }

    @JsonSetter("label")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("time")
    public Long getDuration() {
        return duration;
    }

    @JsonSetter("time")
    public void setDuration(Long duration) {
        this.duration = duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(name, order.name) && Objects.equals(duration, order.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration);
    }
}
