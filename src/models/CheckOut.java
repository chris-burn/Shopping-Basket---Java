package models;

import java.util.ArrayList;


public class CheckOut {

    Customer customer;
    Basket basket;
    private float total;
    private float subTotal;
    private ArrayList<Item> freeOfferList;

    public CheckOut(Customer customer, Basket basket) {
        this.customer = customer;
        this.basket = basket;
        freeOfferList = new ArrayList<>();
        this.total = 0;
        this.subTotal = 0;
    }

    public float subtotalIncOffers() {
//        loop through basket and check whether we have item in secondary "free" arrayList,
//          if not present adds item to new arrayList AND adds price to subTotal counter, if already present removes item previously placed there
//          doesn't update subtotal upon removal, allows item to be added again and added to subTotal again if necessary
        for (Item item : basket.getList()) {
            if (!freeOfferList.contains(item)) {
                freeOfferList.add(item);
                subTotal += item.getPrice();
            }
            else {
                freeOfferList.remove(item);
            }
        }
        if (subTotal >= 20.00) {
            return subTotal * 0.90f;
        } else {
            return subTotal;
        }
    }

    public float totalInclLoyalty() {
//        use previous subTotal method and runs through loyalty discount calc
        total = subtotalIncOffers();
        if (customer.hasLoyaltyCard()) {
            return total * 0.98f;
        } else {
            return total;
        }
    }

}
