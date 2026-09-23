package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {

    private static Properties properties;

    static {

        try {

            FileInputStream file =
                    new FileInputStream(
                            "src/main/resources/testdata.properties"
                    );

            properties = new Properties();

            properties.load(file);

            file.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    public static String getData(String key) {

        return properties.getProperty(key);
    }
}