package models;

import java.util.ArrayList;

public class Basket {

   private ArrayList<Item> list;

    public Basket(){
        list = new ArrayList<Item>();
    }

    public ArrayList<Item> getList() {
        return new ArrayList<Item>(list);
    }

    public void addToBasket(Item item){
        list.add(item);
    }

    public int getBasketSize() {
        return list.size();
    }

    public void emptyBasket() {
        list.clear();
    }

    public void removeBasketItem(Item item) {
        list.remove(item);
    }

    public float getBasketTotal() {
        float subtotal = 0;
        for (Item item : list){
            subtotal += item.getPrice();
        }
        return subtotal;
    }
}
