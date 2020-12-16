package Model;

import config.SqlDateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;
@XmlRootElement(name = "Booking")
@XmlAccessorType(XmlAccessType.FIELD)
public class Booking {
    private int id_customer;
    private int id_room;
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
    @XmlElement(name = "start")
    private Date start;
    @XmlJavaTypeAdapter(SqlDateAdapter.class)
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
