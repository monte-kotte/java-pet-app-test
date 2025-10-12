package monte.test.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigFileReader {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = ConfigFileReader.class.getClassLoader()
                .getResourceAsStream("config/dev.properties")) {
            if (input == null) {
                throw new RuntimeException("Unable to find dev.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration file", e);
        }
    }

    public static String getPetServiceUrl() {
        return properties.getProperty("service.pet.url");
    }

    public static String getPetServiceEndpoint() {
        return properties.getProperty("service.pet.endpoint");
    }
}
