package ru.croc.task11;

import java.time.LocalDateTime;

public class AuctionLot {

    private volatile String lastPersonName;
    private final LocalDateTime dateTimeEnd;
    private volatile int actualPrice;

    public AuctionLot(LocalDateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public void setActualPrice(int actualPrice, String lastPersonName) {
        if (this.actualPrice < actualPrice && LocalDateTime.now().isBefore(dateTimeEnd)) {
            this.actualPrice = actualPrice;
            this.lastPersonName = lastPersonName;
        }
    }

    public String getLastPersonName() {
        return lastPersonName;
    }

}
