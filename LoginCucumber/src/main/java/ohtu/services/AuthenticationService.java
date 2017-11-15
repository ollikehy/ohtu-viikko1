package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        if (username.isEmpty() || password.isEmpty()) {
            return false;
        }

        if (!tarkistaSalasana(password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
        if (username.length() <= 2) {
            return true;
        } else if (password.length() <= 7) {
            return true;
        }
        return false;
    }

    private boolean tarkistaSalasana(String password) {
        ArrayList<Character> numerot = new ArrayList();
        numerot.add('0');
        numerot.add('1');
        numerot.add('2');
        numerot.add('3');
        numerot.add('4');
        numerot.add('5');
        numerot.add('6');
        numerot.add('7');
        numerot.add('8');
        numerot.add('9');

        char a = password.charAt(0);
        boolean numero = false;
        boolean eriKirjaimia = false;
        for (int i = 0; i < password.length(); i++) {
            if (password.charAt(i) != a) {
                eriKirjaimia = true;
            }
            if (numerot.contains(password.charAt(i))) {
                numero = true;
            }
        }
        if (!numero || !eriKirjaimia) {
            return false;
        }
        return true;
    }
}
