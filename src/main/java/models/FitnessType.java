package models;

public enum FitnessType {

    SPIN(2000), YOGA(2500), BODY_SCULPT(3000), ZUMBA(1500), AQUACISE(1200), BOX_FIT(3000);

    public final int price;
    FitnessType(int price){
        this.price = price;
    }
}