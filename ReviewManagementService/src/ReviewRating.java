public enum ReviewRating {
        ONE_STAR(1),
        TWO_STARS(2),
        THREE_STARS(3),
        FOUR_STARS(4),
        FIVE_STARS(5);
    private final int value;
    ReviewRating(int i) {
        this.value = i;
    }
    int getValue(){
        return value;
    }
    public static ReviewRating fromValue(int value){
        for(ReviewRating r: ReviewRating.values()){
            if(r.value == value){
                return r;
            }
        }
        throw new IllegalArgumentException("Invalid review rating value: " + value);
    }
}
