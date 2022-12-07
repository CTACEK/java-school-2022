package ru.croc.task17and18.databases.pojomodel;

public class CustomerOrder {
    private int idUser;
    private int idOrder;

    public CustomerOrder(int idUser, int idOrder) {
        this.idUser = idUser;
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "idUser=" + idUser +
                ", idOrder=" + idOrder +
                '}';
    }
}
