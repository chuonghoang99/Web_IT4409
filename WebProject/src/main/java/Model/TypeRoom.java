package Model;

public class TypeRoom {
    private int id;
    private String name;
    private int num_bed;
    private int price;

    public TypeRoom() {
    }

    public TypeRoom(int id, String name, int num_bed, int price) {
        this.id = id;
        this.name = name;
        this.num_bed = num_bed;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum_bed() {
        return num_bed;
    }

    public void setNum_bed(int num_bed) {
        this.num_bed = num_bed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
