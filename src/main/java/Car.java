import java.util.List;
import java.util.Objects;

public class Car {

    private Long id;

    private String type;

    private Boolean isDamaged;

    private Engine engine;

    private List<Device> devices;

    public Car() {
    }

    public Car(Long id, String type, Boolean isDamaged, Engine engine, List<Device> devices) {
        this.id = id;
        this.type = type;
        this.isDamaged = isDamaged;
        this.engine = engine;
        this.devices = devices;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getDamaged() {
        return isDamaged;
    }

    public void setDamaged(Boolean damaged) {
        isDamaged = damaged;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void setDevices(List<Device> devices) {
        this.devices = devices;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id) && Objects.equals(type, car.type) && Objects.equals(isDamaged, car.isDamaged) && Objects.equals(engine, car.engine) && Objects.equals(devices, car.devices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, isDamaged, engine, devices);
    }
}
