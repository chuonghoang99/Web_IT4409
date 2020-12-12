package Model;

public class Customer {
    private String name_customer;
    private int age;
    private int id_admin;
    private String phone;
    private String note;
    private String noid;

    public Customer(String name_customer, int age, int id_admin, String phone, String note, String noid) {
        this.name_customer = name_customer;
        this.age = age;
        this.id_admin = id_admin;
        this.phone = phone;
        this.note = note;
        this.noid = noid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoid() {
        return noid;
    }

    public void setNoid(String noid) {
        this.noid = noid;
    }

    public Customer() {
    }

    public Customer(String name_customer, int age, int id_admin) {
        this.name_customer = name_customer;
        this.age = age;
        this.id_admin = id_admin;
    }

    public String getName_customer() {
        return name_customer;
    }

    public int getAge() {
        return age;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setName_customer(String name_customer) {
        this.name_customer = name_customer;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }
}
