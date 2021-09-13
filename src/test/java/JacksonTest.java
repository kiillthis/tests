import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.util.ArrayList;
import java.util.List;

public class JacksonTest {

    static final ObjectWriter serializer = new ObjectMapper().writer().withDefaultPrettyPrinter();

    // ignore some field when deser.
    // different name of fields in JSON and class
    // when deser. we map input value, default value to text
    // only constructor with parameters

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
    public void fromObjectsToJson() throws JsonProcessingException, JSONException {

        Car car = createTestCar();

        String actual = serializer.writeValueAsString(car);

        JSONAssert.assertEquals(expectedJson,actual, false);
    }

    @Test
    public void fromJsonToObject() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car expected = createTestCar();
        Car car = objectMapper.readValue(createTestCarJson(), Car.class);

        Assertions.assertEquals(expected, car);
    }

    @Test
    public void testIgnoreField() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Phone expected = createPhone(1L, null, "0987654123");
        String phone = createPhoneJson(1L, "Iphone", "0987654123");
        Phone actual = objectMapper.readValue(phone, Phone.class);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void testDifferentFieldNames() throws JsonProcessingException, JSONException {
        ObjectMapper objectMapper = new ObjectMapper();

        Order orderExpected = createOrder();
        String orderJsonExpected = serializer.writeValueAsString(orderExpected);

        Order actualObject = objectMapper.readValue(orderJsonExpected, Order.class);

        String actualJson = serializer.writeValueAsString(orderExpected);

        Assertions.assertEquals(orderExpected, actualObject);
        JSONAssert.assertEquals(orderJsonExpected, actualJson, false);
    }

    static Car createTestCar() {
        Engine engine = new Engine(1L, "Yamaha");

        Device device1 = new Device(2L, "Audio system");
        Device device2 = new Device(3L, "Toy");

        List<Device> devices = new ArrayList<Device>();

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

    static String createPhoneJson(Long id, String model, String number) {
       return "{\n" +
               "  \"id\": \"" + id +"\",\n" +
               "  \"model\": \"" + model + "\",\n" +
               "  \"number\": \"" + number + "\" \n" +
               "}";
    }

    static Phone createPhone(Long id, String model, String number) {
        Phone phone = new Phone();

        phone.setId(id);
        phone.setModel(model);
        phone.setNumber(number);

        return phone;
    }

    static Order createOrder() {
        Order order = new Order();

        order.setId(1L);
        order.setName("Food");
        order.setDuration(10L);

        return order;
    }

    static String createOrderJson() {
        return "{\n" +
                "  \"identification\": 1,\n" +
                "  \"label\": \"Food\",\n" +
                "  \"time\": 10\n" +
                "}";
    }
}
