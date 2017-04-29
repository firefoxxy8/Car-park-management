
public class Slot {
    private String availability;

    public Slot(String availability){
        this.availability = availability;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return availability;
    }
}
