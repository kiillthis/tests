import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Animal {

    private Long id;
    private String name;
    private Long age;

    @JsonCreator
    public Animal(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("age") Long age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(id, animal.id) && Objects.equals(name, animal.name) && Objects.equals(age, animal.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
