package Model;

import java.sql.Date;

public class Booking {
    private int id_customer;
    private int id_room;
    private Date start;
    private Date expire;

    public Booking() {
    }

    public Booking(int id_customer, int id_room, Date start, Date expire) {
        this.id_customer = id_customer;
        this.id_room = id_room;
        this.start = start;
        this.expire = expire;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
