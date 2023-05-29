import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SILab2Test {
    public List<User> createList(User... users) {
        return new ArrayList<>(Arrays.asList(users));
    }


    // multiple condition testing
    @Test
    void MultipleCondition() {
        RuntimeException ex;
        List<User> allUsers = new ArrayList<User>();

        // T X X
        User user1 = new User(null, "pass", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //F T X
        User user2 = new User("andrijana", null, "andrijanaarovska");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // F F T
        User user3 = new User("andrijana", "andrijanapass", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        // F F F
        User user = new User("andrijana", "andrijanapass", "andrijanaarsovska12@gmail.com");
        assertDoesNotThrow(() -> SILab2.function(user, allUsers));

    }


    // testing for every branch
    @Test
    void FirstTest() {
        User user = new User("andrijana12", null, "andrijana12@gmail.com");
        List<User> allUsers = new ArrayList<User>();
        allUsers.add(new User("person1","password1","person1@yahoo.com"));
        allUsers.add(new User("person2", "password2", "person2@yahoo.com"));
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user, allUsers));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));
    }

    @Test
    void SecondTest() {
        User user = new User("andrijana", "arsovska 12", "andrijanaarsovska12@gmail.com");
        List<User> allUsers = createList(
                new User("andrijana", "pass1", "andrijanaarsovska12@gmail.com"),
                new User("person", "pass2", "person12@gmail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void ThirdTest() {
        User user = new User("andrijana", "Softversko12@", "andrijanagmail");
        List<User> allUsers = createList(new User("person12", "pass1", "person1@gmail.com"));
        assertFalse(SILab2.function(user, allUsers));
    }

    @Test
    void FourthTest() {
        User user = new User("", "password12", "person12@gmail.com");
        List<User> allUsers = createList();
        assertFalse(SILab2.function(user, allUsers));
    }



}