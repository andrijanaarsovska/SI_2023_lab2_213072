# SI_2023_lab2_213072
Андријана Арсовска 213072

Control Flow Graph


![cfg1](https://github.com/andrijanaarsovska/SI_2023_lab2_213072/assets/129632251/226552e2-0446-48dc-b069-187f4d547c16)



Цикломатска комплексност

Цикломатската комплексност на дадениот код е 11. Се пресметува така што се бројат областите околку јазлите (кои во дадениот код испаѓаат 10) 
и се додава и надворешната област. Истата може да се пресмета и по бројот на предикатни јазли +1.


Тест случаи според критериумот Every Branch





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

Тест случаи според критериумот Multiple Condition


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


Објаснување за Unit tests
  
За овие тестови употребив Every Branch и Multiple Condition критериуми. Туе обезбедуваат правилно извршување на кодот.
assertTrue потврдува дека функцијата е точна, спротивно на овој тест користиме assertFalse за неточна функција.
Овие тестови се пишуваат со цел да се поминат сите услови, вклучувајќи и exceptions.  За да се фати еден exception се употребува assertThrows, 
а потоа за проверка дали се фрлил соодветниот exception се употребува assertTrue. Доколку сакаме да потврдиме дека кодот не фрла exception се користи assertDoesNotThrow.
Тестирањето според Every Branch е проследено со 4 тест случаи каде што главната цел е да се поминат сите можни разгранувања на јаслите.
За разлика од ова, тестирањето според Multiple Condition ги проверува сите if услови каде има повеќе од еден услов.
