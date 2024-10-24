package ticket;

import utils.IdCounter;
import interfaces.Printable;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket implements Printable {

    private int id = IdCounter.getId();
    private String concertHall;
    private String eventCode;
    private LocalDateTime time;
    private boolean isPromo;
    private StadiumSector stadiumSector;
    private double maxAllowedBackpackWeightInKg;
    private final LocalDateTime ticketCreationTime = LocalDateTime.now();
    private BigDecimal price;
    private TicketType ticketType;

    public Ticket() {
    }

    public Ticket(String concertHall, String eventCode, LocalDateTime time, boolean isPromo, StadiumSector stadiumSector, double maxAllowedBackpackWeightInKg, String ticketPrice, TicketType ticketType) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        DecimalFormat decimalFormat = new DecimalFormat("#.###");
        this.maxAllowedBackpackWeightInKg = Double.parseDouble(decimalFormat.format(maxAllowedBackpackWeightInKg));
        price = new BigDecimal(ticketPrice).setScale(2, RoundingMode.HALF_UP);
        this.ticketType = ticketType;
    }

    public Ticket(String concertHall, String eventCode, LocalDateTime time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public String getEventCode() {
        return eventCode;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public StadiumSector getStadiumSector() {
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

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setStadiumSector(StadiumSector stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return isPromo == ticket.isPromo && Double.compare(maxAllowedBackpackWeightInKg, ticket.maxAllowedBackpackWeightInKg) == 0 && Objects.equals(id, ticket.id) && Objects.equals(concertHall, ticket.concertHall) && Objects.equals(eventCode, ticket.eventCode) && Objects.equals(time, ticket.time) && stadiumSector == ticket.stadiumSector && Objects.equals(ticketCreationTime, ticket.ticketCreationTime) && Objects.equals(price, ticket.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,
                concertHall != null ? concertHall.hashCode() : 0,
                eventCode != null ? eventCode.hashCode() : 0,
                time != null ? time.hashCode() : 0,
                isPromo,
                stadiumSector != null ? stadiumSector.hashCode() : 0,
                maxAllowedBackpackWeightInKg,
                ticketCreationTime,
                price != null ? price.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode='" + eventCode + '\'' +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxAllowedBackpackWeightInKg=" + maxAllowedBackpackWeightInKg +
                ", ticketCreationTime=" + ticketCreationTime +
                ", price=" + price +
                ", ticketType=" + ticketType +
                '}';
    }

    public void share(String phone) {
        System.out.println("Ticket is shared by phone: " + phone);
    }

    public void share(String phone, String email) {
        System.out.println("Ticket is shared by phone: " + phone + " and email: " + email);
    }

    @Override
    public void print() {
        System.out.println(this);
    }
}

