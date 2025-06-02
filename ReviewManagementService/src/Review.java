public class Review {
    private String reviewId;
    private String reviewText;
    private String userId;
    private ReviewRating reviewRating;
    Review(String reviewId, String reviewText, String userId, ReviewRating reviewRating){
        this.reviewId = reviewId;
        this.reviewRating = reviewRating;
        this.userId = userId;
        this.reviewText = reviewText;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public void setReviewRating(ReviewRating reviewRating){
        this.reviewRating = reviewRating;
    }
    public ReviewRating getReviewRating() {
        return reviewRating;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    @Override
    public String toString() {
        return "UserID: " + this.userId + "Rating: " + this.reviewRating.toString() + " ReviewText: " + this.reviewText;
    }
}
