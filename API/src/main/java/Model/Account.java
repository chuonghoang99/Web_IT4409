package Model;

public class Account {
    private String username;
    private String password;
    private Person person;
    public String getUsername() {
        return username;
    }

    public Account(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public String getPassword() {
        return password;
    }

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
