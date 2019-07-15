package homework8;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import homework7.entities.Substances;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Map;

public class InputProvider {

    private static final String DATA_SET = "src/test/resources/JDI_ex8_metalsColorsDataSet.json";

    @DataProvider(name = "inputData")
    public static Object[] inputData() {

        Map<String, Substances> map = null;
        Gson gson = new Gson();
        try (Reader reader = new FileReader(DATA_SET)) {
            map = gson.fromJson(reader, new TypeToken<Map<String, Substances>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Object[] array = new Object[map.size()];
        Iterator<Substances> iterator = map.values().iterator();
        for (int i = 0; iterator.hasNext(); i++) {
            array[i] = iterator.next();
        }

        return array;
    }
}
