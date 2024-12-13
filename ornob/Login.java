import java.util.HashMap;
import java.util.Map;

public class Login {
    private Map<String, String> users = new HashMap<>();
    private final String adminUsername = "ornob";
    private final String adminPassword = "1234";

    public void registerUser(String username, String password) {
        users.put(username, password);
    }

    public boolean authenticate(String username, String password) {
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            return true; // Admin login check
        }
        return users.containsKey(username) && users.get(username).equals(password);
    }
}
