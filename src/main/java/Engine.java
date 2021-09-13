import java.util.Objects;

public class Engine {

    private Long id;

    private String model;

    public Engine() {
    }

    public Engine(Long id, String model) {
        this.id = id;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return Objects.equals(id, engine.id) && Objects.equals(model, engine.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model);
    }
}
