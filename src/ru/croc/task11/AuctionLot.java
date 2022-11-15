package ru.croc.task11;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AuctionLot {

    private volatile String lastPersonName;
    private final LocalDateTime dateTimeEnd;
    private volatile BigDecimal actualPrice;

    public AuctionLot(LocalDateTime dateTimeEnd) {
        this.dateTimeEnd = dateTimeEnd;
    }

    public void setActualPrice(BigDecimal actualPrice, String lastPersonName) {
        if (this.actualPrice.doubleValue() < actualPrice.doubleValue() && LocalDateTime.now().isBefore(dateTimeEnd)) {
            this.actualPrice = actualPrice;
            this.lastPersonName = lastPersonName;
        }
    }

    public String getLastPersonName() {
        return lastPersonName;
    }

}
