package models;

public class Rating {
    private final FitnessLesson lesson;
    private final Customer customer;
    private final int rating;

    public Rating(FitnessLesson lesson, Customer customer, int rating) {
        this.lesson = lesson;
        this.customer = customer;
        this.rating = rating;
    }

    @Override
    public String toString() {
        String satisfaction = "";
        switch (rating){
            case 1: satisfaction = "Very Dissatisfied"; break;
            case 2: satisfaction = "Dissatisfied"; break;
            case 3: satisfaction = "OK"; break;
            case 4: satisfaction = "Satisfied"; break;
            case 5: satisfaction = "Very Satisfied"; break;
        }
        return  customer.getName()+ " is " + satisfaction + " with " + lesson.getType();
    }




}

