package JsonTest;

/**
 * Created by hp on 2014/3/28.
 */

import JsonTest.JsonRead.*;
import JsonTest.JsonWrite.JsonWrite;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Test {
    public static void main(String[] args) {
        JsonRead jR = new JsonRead();
        JsonWrite jW = new JsonWrite();
        JSONObject obj = jR.readFromFile("read.json");
        try {
            //json的object 利用 getJsonObject和getJsonArray两个函数得到所需对象
            //getString函数可以得到对像的value
            System.out.println(obj.getJSONObject("section").getJSONArray("signing").toString());
            System.out.println(obj.getJSONObject("section").getString("title"));
            System.out.println(obj.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonG = new JSONObject();
        Test test = new Test();
        jsonG = test.jsonGenerate();
        jW.writeToFile(jsonG, "write.json");

    }

    public JSONObject jsonGenerate()
    {
        JSONObject json1 = new JSONObject();
        JSONObject json2 = new JSONObject();
        JSONObject json3 = new JSONObject();
        JSONObject json4 = new JSONObject();
        JSONObject json5 = new JSONObject();
        JSONObject json6 = new JSONObject();
        JSONObject json7 = new JSONObject();
        JSONObject json8 = new JSONObject();
        JSONArray jsonA1= new JSONArray();
        try {
            json1.put("name", "author-1");
            json2.put("author", json1);
            json3.put("title", "book1").put("price", "$11");
            json2.put("book", json3);

            json4.put("name","author2");
            json5.put("author",json4);
            json6.put("title", "book2").put("price", "$22");
            json5.put("book", json6);
            jsonA1.put(json2).put(json5);

            json7.put("title", "book").put("signing", jsonA1);

            json8.put("section", json7);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json8;
    }
}
