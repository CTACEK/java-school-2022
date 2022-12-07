package ru.croc.task17and18.databases.pojomodel;

import java.util.Objects;

public class Item {
    private String name;
    private String itemCode;
    private Integer price;

    public Item(String name, String itemCode, Integer price) {
        this.name = name;
        this.itemCode = itemCode;
        this.price = price;
    }


    public Integer getPrice() { return price; }

    public void setPrice(Integer price) { this.price = price;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemNumber() {
        return itemCode;
    }

    public void setItemNumber(String itemNumber) {
        this.itemCode = itemNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(name, item.name) && Objects.equals(itemCode, item.itemCode) && Objects.equals(price, item.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, itemCode, price);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", itemCode='" + itemCode + '\'' +
                ", price=" + price +
                '}';
    }
}
