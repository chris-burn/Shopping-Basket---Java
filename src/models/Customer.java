package models;

/**
 * Created by user on 22/07/2017.
 */
public class Customer {

    private boolean shopLoyaltyCard;

    public Customer(boolean shopLoyaltyCard){
        this.shopLoyaltyCard = shopLoyaltyCard;
    }

    public boolean hasLoyaltyCard() {
        return this.shopLoyaltyCard;
    }


}
