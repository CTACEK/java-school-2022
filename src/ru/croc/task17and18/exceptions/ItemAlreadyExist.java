package ru.croc.task17and18.exceptions;

import ru.croc.task17and18.databases.pojomodel.Item;

public class ItemAlreadyExist extends Exception {
    private final Item item;

    public ItemAlreadyExist(Item item) {
        this.item = item;
    }

    @Override
    public String getMessage() {
        return "Item with code " + item.getItemNumber() + " already exists";
    }
}
