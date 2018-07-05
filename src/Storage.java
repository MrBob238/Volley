import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Vladimir on 05.07.2018.
 */
public class Storage {
    public static Map<String, String> properties = new HashMap<>();

    public void save (String filename) {
        Properties prop = new Properties();
        prop.putAll(properties);

    }

    public void load (String filename) {

    }
}
