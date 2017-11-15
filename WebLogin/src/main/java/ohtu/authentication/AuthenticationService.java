package ohtu.authentication;

import java.util.ArrayList;
import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

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

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();

        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length() < 3) {
            status.addError("username should have at least 3 characters");
        }

        if (password.length() < 8) {
            status.addError("password should have at least 8 characters");
        }

        if (!password.equals(passwordConfirmation)) {
            status.addError("password and password confirmation do not match");
        }
        if (!tarkistaSalasana(password)) {
            status.addError("password should have atleast two different letters and a number");
        }
        
        if (status.isOk()) {
            userDao.add(new User(username, password));
        }

        return status;
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
