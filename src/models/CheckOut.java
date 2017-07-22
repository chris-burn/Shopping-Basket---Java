package models;

import java.util.ArrayList;

/**
 * Created by user on 22/07/2017.
 */
public class CheckOut {

    Customer customer;
    Basket basket;
    private float total;
    private float subTotal;
    private ArrayList<Item> freeOfferList;

    public CheckOut(Customer customer, Basket basket){
        this.customer = customer;
        this.basket = basket;
        this.freeOfferList = new ArrayList<Item>();
        this.total = 0;
        this.subTotal = 0;
    }

    public float subtotalIncOffers() {
        for (Item item : basket.getList()){
            if (freeOfferList.contains(item) == false) {
                freeOfferList.add(item);
                subTotal += item.getPrice();
            }
            //          doesn't update subtotal upon removal, allows item to be added again and added to subTotal if required
            else {
                freeOfferList.remove(item);
            }
        }
        if (subTotal >= 20.00){
            return subTotal * 0.90f;
        } else{
            return subTotal;
        }
    }

    public float totalInclLoyalty(){
//        use previous subTotal via last method
        total = subtotalIncOffers();
        if (customer.hasLoyaltyCard() == true) {
           return total * 0.98f;
        }
        else {
            return total;
        }
    }


    // TODO: 22/07/2017 Add final customer discount in,   total = SubTotal ---  if (customer.hasLoyaltyCard = true){ total * 0.98 } return total

}
