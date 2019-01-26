package dropbox.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationService {
    private Properties properties = new Properties();
    private String path;
    private InputStream input = null;

    public ConfigurationService(String path) {
        this.path = path;
    }

    public void load() {
        try {
            input = new FileInputStream(path);

            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String get(String key) {
        return properties.getProperty(key);
    }
}
