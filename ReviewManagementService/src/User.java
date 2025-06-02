public abstract class User {
    private String userName;
    private String userId;
    private String password;
    private boolean isAdmin;

    protected User(String userName, String userId, String password, boolean isAdmin) {
        this.userName = userName;
        this.userId = userId;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    abstract boolean login();

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
}
