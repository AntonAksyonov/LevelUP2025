package lesson12.serial;
//import com.fasterxml.jackson.databind.ObjectMapper;
import java.math.BigDecimal;
public class XmlRunner {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee(
                "Ivanov Vitaly", 20,
                new Position(1L, "Expert", new BigDecimal("1000000"))
        );
//        XmlMapper xmlMapper = new XmlMapper();
//        ObjectMapper jsonMapper = new ObjectMapper();
//        xmlMapper.registerModule(new JavaTimeModule());
//        XMLStreamWriter xmlStreamWriter = XMLOutputFactory.newInstance().createXMLStreamWriter(new FileWriter("src/resources/text.xml"));
//        xmlMapper.writeValue(xmlStreamWriter, employee);
//        System.out.println(xmlMapper.writeValueAsString(new Account()));
//        System.out.println(jsonMapper.writeValueAsString(employee));
    }
}