package seedDataReader;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by rhaveson on 5/24/2017.
 */
public class GsonStreamerMain {

    public static void main(String args[]) {
        String jsonString = "{\"name\":\"Mahesh Kumar\", \"age\":21,\"verified\":false,\"marks\": [100,90,85]}";
        JsonReader reader = new JsonReader(new StringReader(jsonString));
        try {
            handleJsonObject(reader);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleJsonObject(JsonReader reader) throws IOException {
        reader.beginObject();
        String fieldname = null;

        while(reader.hasNext()) {
            JsonToken token = reader.peek();

            if(token.equals(JsonToken.BEGIN_ARRAY)) {
                System.out.print("Marks [ ");
                handleJsonArray(reader);
                System.out.print("]");
            } else if(token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
                return;
            } else {
                if(token.equals(JsonToken.NAME )) {
                    // get the current token
                    fieldname = reader.nextName();
                }
                if("name".equals(fieldname)) {
                    token = reader.peek();
                    System.out.println("Name: " + reader.nextString());
                }

                if("age".equals(fieldname)) {
                    token = reader.peek();
                    System.out.println("Age: " + reader.nextInt());
                }

                if("verified".equals(fieldname)) {
                    token = reader.peek();
                    System.out.println("verified: " + reader.nextBoolean());
                }
            }
        }
    }

    private static void handleJsonArray(JsonReader reader) throws IOException {
        reader.beginArray();
        String fieldname = null;
        while(true) {
            JsonToken token = reader.peek();

            if(token.equals(JsonToken.END_ARRAY)) {
                reader.endArray();
                break;
            } else if(token.equals(JsonToken.BEGIN_OBJECT)) {
                handleJsonObject(reader);
            } else if(token.equals(JsonToken.END_OBJECT)) {
                reader.endObject();
            } else {
                System.out.print(reader.nextInt() + " ");
            }
        }
    }

}
