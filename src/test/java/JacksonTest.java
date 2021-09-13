import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JacksonTest {

    static final ObjectWriter serializer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    static final String expectedJson = "{\n" +
            "  \"id\" : 4,\n" +
            "  \"type\" : \"Track\",\n" +
            "  \"engine\" : {\n" +
            "    \"id\" : 1,\n" +
            "    \"model\" : \"Yamaha\"\n" +
            "  },\n" +
            "  \"devices\" : [ {\n" +
            "    \"id\" : 2,\n" +
            "    \"name\" : \"Audio system\"\n" +
            "  }, {\n" +
            "    \"id\" : 3,\n" +
            "    \"name\" : \"Toy\"\n" +
            "  } ],\n" +
            "  \"damaged\" : false\n" +
            "}";

    @Test
    public void fromObjectsToJson() throws JsonProcessingException {

        Car car = createTestCar();

        String actual = serializer.writeValueAsString(car);

        Assertions.assertEquals(expectedJson, actual);
    }

    @Test
    public void fromJsonToObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car expected = createTestCar();
        Car car = objectMapper.readValue(createTestCarJson(), Car.class);

        Assertions.assertEquals(expected, car);
    }

    static Car createTestCar() {
        Engine engine = new Engine(1L, "Yamaha");

        Device device1 = new Device(2L, "Audio system");
        Device device2 = new Device(3L, "Toy");

        List<Device> devices = new ArrayList();

        devices.add(device1);
        devices.add(device2);

        return new Car(4L, "Track", false, engine, devices);
    }

    static String createTestCarJson() {
        return "{\n" +
                "  \"id\" : 4,\n" +
                "  \"type\" : \"Track\",\n" +
                "  \"engine\" : {\n" +
                "    \"id\" : 1,\n" +
                "    \"model\" : \"Yamaha\"\n" +
                "  },\n" +
                "  \"devices\" : [ {\n" +
                "    \"id\" : 2,\n" +
                "    \"name\" : \"Audio system\"\n" +
                "  }, {\n" +
                "    \"id\" : 3,\n" +
                "    \"name\" : \"Toy\"\n" +
                "  } ],\n" +
                "  \"damaged\" : false\n" +
                "}";
    }
}
