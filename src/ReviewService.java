import java.util.*;

public class ReviewService {
    private static ReviewService reviewService;
    Map<String, Review> allReviews = new HashMap<>();
    Map<String, ReviewUser> allUsers = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    boolean keepCliOpen = true;

    private ReviewService() {}

    public static ReviewService getInstance(){
        if(reviewService == null) {
            reviewService = new ReviewService();
        }
        return reviewService;
    }

    public void submitReview(ReviewUser reviewUser){
        System.out.println("Please Provide the review");
        String reviewText = reviewService.scanner.nextLine();
        System.out.println("Please provide the Rating from 0 to 5");
        int rate = reviewService.scanner.nextInt();
        reviewService.scanner.nextLine();
        ReviewRating reviewRating = ReviewRating.fromValue(rate);
        String reviewId = UUID.randomUUID().toString();
        Review review = new Review(reviewId, reviewText, reviewUser.getUserId(), reviewRating);
        reviewService.allReviews.put(reviewId, review);
        System.out.println("Review Submitted Successfully");
    }


    public static void main(String[] args) {
        ReviewService reviewService = ReviewService.getInstance();

        while(reviewService.keepCliOpen){
            System.out.println("Review Service");
            System.out.println("Are you a User or Admin? Press U for User, A for Admin, C to Close");
            String checkUserRole = reviewService.scanner.nextLine();
            if(checkUserRole.equals("U")){
                System.out.println("To enter review: Please Enter userId, if user doesn't exist Press anything");
                String userId = reviewService.scanner.nextLine();
                Optional<ReviewUser> reviewUser = Optional.ofNullable(reviewService.allUsers.get(userId));
                if(reviewUser.isPresent()){
                    reviewService.submitReview(reviewUser.get());
                } else{
                    System.out.println("First Create User; Enter comma separated: userName and password");
                    String line = reviewService.scanner.nextLine();
                    String[] parts = line.split(",");

                    if (parts.length != 2) {
                        System.out.println("Invalid input. Please enter in format: userName,password");
                    } else {
                        String userName = parts[0].trim();
                        String password = parts[1].trim();
                        System.out.println("Username: " + userName);
                        System.out.println("Password: " + password);
                        String newUserId = UUID.randomUUID().toString();
                        ReviewUser newReviewUser = new ReviewUser(newUserId, userName, password);
                        reviewService.allUsers.put(newUserId, newReviewUser);
                        reviewService.submitReview(newReviewUser);
                    }
                }
            } else if(checkUserRole.equals("A")){
                System.out.println("To show all reviews: Press R\n To Show all Users: Press U");
                String choice = reviewService.scanner.nextLine();
                if(choice.equals("R")){
                    System.out.println("Here are the Reviews");
                    reviewService.allReviews.forEach((s, review)-> System.out.println(review));
                } else if(choice.equals("U")){
                    System.out.println("Here are the Users");
                    reviewService.allUsers.forEach((s, user)-> System.out.println(user));
                } else{
                    System.out.println("Invalid Choice Enter R or S");
                }
            } else if (checkUserRole.equals("C")) {
                reviewService.keepCliOpen = false;
                System.out.println("Program Closed successfully");
                break;
            }
            else{
                System.out.println("Invalid choice");
            }
        }
        System.out.println("Bye See You Soon");
    }
}
