public class Admin extends User {
    protected Admin(String userName, String userId, String password, boolean isAdmin) {
        super(userName, userId, password, isAdmin);
    }

    @Override
    boolean login() {
        return false;
    }
}
