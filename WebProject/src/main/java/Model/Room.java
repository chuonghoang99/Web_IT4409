package Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room {
    private int id_room;
    private int type_room;
    private String status_room;
    private TypeRoom typeRoom;

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public Room() {
    }

    public Room(int id_room, int type_room, String status_room) {
        this.id_room = id_room;
        this.type_room = type_room;
        this.status_room = status_room;
    }

    public int getId_room() {
        return id_room;
    }

    public void setId_room(int id_room) {
        this.id_room = id_room;
    }

    public int getType_room() {
        return type_room;
    }

    public void setType_room(int type_room) {
        this.type_room = type_room;
    }

    public String getStatus_room() {
        return status_room;
    }

    public void setStatus_room(String status_room) {
        this.status_room = status_room;
    }
}
