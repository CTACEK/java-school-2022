package ru.croc.task17and18.databases.pojomodel;

public class Order {
    private String codeItem;

    private Integer idOrder;

    public Order(String idItem, Integer idOrder) {
        this.codeItem = idItem;
        this.idOrder = idOrder;
    }

    public String getCodeItem() {
        return codeItem;
    }

    public void setCodeItem(String codeItem) {
        this.codeItem = codeItem;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "Order{" +
                "codeItem='" + codeItem + '\'' +
                ", idOrder=" + idOrder +
                '}';
    }
}
