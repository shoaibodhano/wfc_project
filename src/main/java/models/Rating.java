package models;

import java.text.DecimalFormat;

public class Rating {
    private int noOfRating=0;
    private double totalRating=0;

    @Override
    public String toString() {

        if (noOfRating==0) return "No Reviews";
        String r = new DecimalFormat("#.#").format(totalRating /noOfRating);
        return  r + " (" + noOfRating + ")";
    }



    public void addCustomerRating(int rating){
        this.totalRating += rating;
        this.noOfRating++;
    }

}

