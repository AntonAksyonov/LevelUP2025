package lesson12.serial;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;

public class Employee implements Externalizable, Serializable {

    private static final long serialVersionUID = 1L;

    private String fullName;
    private int workAge;
    private /*transient*/ Position position;
    private boolean gender = false;

    public Employee() {

    }

    public Employee(String fullName, int workAge, Position position) {
        this.fullName = fullName;
        this.workAge = workAge;
        this.position = position;
    }

    public String getFullName() {
        return fullName;
    }

    public int getWorkAge() {
        return workAge;
    }

    public Position getPosition() {
        return position;
    }

    public boolean isGender() {
        return gender;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setWorkAge(int workAge) {
        this.workAge = workAge;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fullName='" + fullName + '\'' +
                ", workAge=" + workAge +
                ", position=" + position +
                ", gender=" + gender +
                '}';
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(workAge);
        out.writeUTF(fullName);
        out.writeObject(position);
        out.writeBoolean(gender);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.workAge = in.readInt();
        this.fullName = in.readUTF();
        this.position = (Position) in.readObject();
        this.gender = in.readBoolean();
    }
}