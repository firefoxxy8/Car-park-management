
public class Car extends Vehicle {
    private String numDoors;
    private String Color;

    public String getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(String numDoors) {
        this.numDoors = numDoors;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    @Override
    public String toString() {
        return "ID : " + getIdPlate() + " Brand : " + getVehicleBrand() + " Time : " + dateTime.toString()+ " Doors : " +numDoors+ " Color : " + getColor();
    }
}
