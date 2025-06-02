public class ReviewUser extends User{
    @Override
    boolean login() {
        return false;
    }
    ReviewUser(String userId, String userName, String password){
        super(userName, userId, password, false);
    }

    @Override
    public String toString() {
        return "UserId: " + this.getUserId() + " UserName: " + this.getUserName();
    }
}
