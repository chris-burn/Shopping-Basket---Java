package models;

public class Customer {

    private boolean shopLoyaltyCard;

    public Customer(boolean shopLoyaltyCard){
        this.shopLoyaltyCard = shopLoyaltyCard;
    }

    public boolean hasLoyaltyCard() {
        return this.shopLoyaltyCard;
    }


}
