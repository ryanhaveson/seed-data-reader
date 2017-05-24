package seedDataReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

/**
 * Created by rhaveson on 5/24/2017.
 */
public class TreeModelMain {

    public static void main(String args[]) {
        String jsonString ="{\"name\":\"Ryan Haveson\", \"age\":45,\"verified\":true,\"marks\": [99,91,84]}";

        JsonParser parser = new JsonParser();
        JsonElement rootNode = parser.parse(jsonString);

        if(rootNode.isJsonObject()) {
            JsonObject details = rootNode.getAsJsonObject();
            JsonElement nameNode = details.get("name");
            System.out.println("Name: " + nameNode.getAsString());

            JsonElement ageNode = details.get("age");
            System.out.println("Age: " + ageNode.getAsString());

            JsonElement verifiedNode = details.get("verified");
            System.out.println("verified: " + (verifiedNode.getAsBoolean() ? "true" : "false"));

            JsonArray marks = details.getAsJsonArray("marks");
            for(int i = 0; i < marks.size(); i++) {
                JsonPrimitive value = marks.get(i).getAsJsonPrimitive();
                System.out.print(value.getAsInt() + " ");
            }

        }

    }

}
