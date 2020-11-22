package Model;

public class Person {
    private String fullName;
    private int age;
    private String address;
    private String indentityCardNumber;
    private String bank;
    private String bankNumber;

    public Person() {
    }

    public Person(String fullName, int age, String address, String indentityCardNumber, String bank, String bankNumber) {
        this.fullName = fullName;
        this.age = age;
        this.address = address;
        this.indentityCardNumber = indentityCardNumber;
        this.bank = bank;
        this.bankNumber = bankNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setIndentityCardNumber(String indentityCardNumber) {
        this.indentityCardNumber = indentityCardNumber;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getIndentityCardNumber() {
        return indentityCardNumber;
    }

    public String getBank() {
        return bank;
    }

    public String getBankNumber() {
        return bankNumber;
    }
}
