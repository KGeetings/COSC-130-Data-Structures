package Maps;

import java.util.*;

public class User {
    private String username;
    private String password;
    private String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        users.put("fred", new User("fred", "sectret", "Freddy"));
        users.put("joe", new User("joe", "secret", "Joe"));
        users.put("bob", new User("bob", "secret", "Bob"));
        SortedMap<String, User> tree = new TreeMap<>();
        tree.put("fred", new User("fred", "sectret", "Freddy"));
        tree.put("joe", new User("joe", "secret", "Joe"));
        tree.put("bob", new User("bob", "secret", "Bob"));
    }
}
