package Model;

import java.sql.Time;

public class Room {
    private String name;
    private Time start;
    private Time expire;
    private Account account;

    public Room() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Time getStart() {
        return start;
    }


    public void setStart(Time start) {
        this.start = start;
    }

    public void setExpire(Time expire) {
        this.expire = expire;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Time getExpire() {
        return expire;
    }

    public Account getAccount() {
        return account;
    }
}
