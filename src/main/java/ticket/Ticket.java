package ticket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class Ticket {

    private String id;
    private String concertHall;
    private String eventCode;
    private long time;
    private boolean isPromo;
    private String stadiumSector;
    private double maxAllowedBackpackWeightInKg;
    private final LocalDateTime ticketCreationTime;
    private BigDecimal price;

    public Ticket() {

        ticketCreationTime = LocalDateTime.now();
    }

    public Ticket(String id, String concertHall, String eventCode, long time, boolean isPromo, String stadiumSector, double maxAllowedBackpackWeightInKg, String ticketPrice) {
        if (id.length() > 4) {
            throw new IllegalArgumentException("ID length must be 4 or less");
        } else {
            this.id = id;
        }
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Concert hall must be 10 chars or less");
        } else {
            this.concertHall = concertHall;
        }
        if (eventCode.matches("\\d{3}")) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException("Event code must contain 3 digits");
        }
        this.time = time;
        this.isPromo = isPromo;
        if (stadiumSector.matches("[ABC]")) {
            this.stadiumSector = stadiumSector;
        } else {
            throw  new IllegalArgumentException("Stadium sector must be equal to A, B or C");
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        this.maxAllowedBackpackWeightInKg = Double.parseDouble(decimalFormat.format(maxAllowedBackpackWeightInKg));
        price = new BigDecimal(ticketPrice).setScale(2, RoundingMode.HALF_UP);
        ticketCreationTime = LocalDateTime.now();
    }

    public Ticket(String concertHall, String eventCode, long time) {
        if (concertHall.length() > 10) {
            throw new IllegalArgumentException("Concert hall must be 10 chars or less");
        } else {
            this.concertHall = concertHall;
        }
        if (eventCode.matches("\\d{3}")) {
            this.eventCode = eventCode;
        } else {
            throw new IllegalArgumentException("Event code must contain 3 digits");
        }
        this.time = time;
        ticketCreationTime = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    public long getTime() {
        return time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public String getStadiumSector() {
        return stadiumSector;
    }

    public double getMaxAllowedBackpackWeightInKg() {
        return maxAllowedBackpackWeightInKg;
    }

    public LocalDateTime getTicketCreationTime() {
        return ticketCreationTime;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

