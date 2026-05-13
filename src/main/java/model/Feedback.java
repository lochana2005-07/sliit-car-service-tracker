package model;

public class Feedback {

    private String feedbackID;
    private String vehicleNumber;
    private String userName;
    private String comments;
    private int rating; // 1 to 5

    // Constructor
    public Feedback(String feedbackID, String vehicleNumber, String userName, String comments, int rating) {
        this.feedbackID = feedbackID;
        this.vehicleNumber = vehicleNumber;
        this.userName = userName;
        this.comments = comments;
        this.rating = rating;
    }

    // Getters
    public String getFeedbackID() {
        return feedbackID;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getComments() {
        return comments;
    }

    public int getRating() {
        return rating;
    }

    // Setters
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Feedback ID: " + feedbackID);
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("User: " + userName);
        System.out.println("Comments: " + comments);
        System.out.println("Rating: " + rating + "/5");
    }
}