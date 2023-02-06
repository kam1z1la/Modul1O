package Task2;

import com.google.gson.*;

import java.lang.reflect.Type;

public class UserSerializer implements JsonSerializer<User> {
    @Override
    public JsonElement serialize(User user, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject result = new JsonObject();

        result.addProperty("name",  user.getUserID().toString());
        result.addProperty("age", user.getUserData().toString());

        return result;
    }
}
