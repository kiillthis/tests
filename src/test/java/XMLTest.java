import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class XMLTest {

    XmlMapper xmlMapper = new XmlMapper();

    @Test
    public void testFromObjectToXML() throws JsonProcessingException {
        String actualXML = xmlMapper.writeValueAsString(createCar());
        String expectedXML = createCarXML();

        Assertions.assertEquals(expectedXML, actualXML);

    }

    @Test
    public void testFromXMLtoObject() throws JsonProcessingException {
        Car actualObject = xmlMapper.readValue(createCarXML(), Car.class);
        Car expectedObject = createCar();

        Assertions.assertEquals(expectedObject, actualObject);
    }

    static Car createCar() {
        Car car = new Car();

        Engine engine = new Engine();
        engine.setModel("Model");
        engine.setId(2L);

        List<Device> devices = new ArrayList<>();
        Device device1 = new Device();
        device1.setId(3L);
        device1.setName("Name");

        Device device2 = new Device();
        device2.setId(4L);
        device2.setName("Name");

        devices.add(device1);
        devices.add(device2);

        car.setId(1L);
        car.setType("Type");
        car.setDamaged(false);
        car.setEngine(engine);
        car.setDevices(devices);

        return car;
    }

    static String createCarXML() {
        return "<Car>" +
                    "<id>1</id>" +
                    "<type>Type</type>" +
                    "<engine>" +
                        "<id>2</id>" +
                        "<model>Model</model>" +
                    "</engine>" +
                    "<devices>" +
                        "<devices>" +
                            "<id>3</id>" +
                            "<name>Name</name>" +
                        "</devices>" +
                        "<devices>" +
                            "<id>4</id>" +
                            "<name>Name</name>" +
                            "</devices>" +
                    "</devices>" +
                    "<damaged>false</damaged>" +
                "</Car>";
    }
}
