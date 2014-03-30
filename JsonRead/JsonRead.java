package JsonTest.JsonRead;

/**
 * Created by hp on 2014/3/28.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonRead {
    public JSONObject readFromFile(String fileName)
    {
        JSONObject readObj = new JSONObject();
        try {
            readObj = new JSONObject(new JSONTokener(new FileReader(new File(fileName))));


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return  readObj;
    }
}
