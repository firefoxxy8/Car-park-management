import java.util.*;
public class WestminsterCarParkManager implements CarParkManager {

    //Creating 20 slots initializing it with null
    List<Vehicle> slots = new ArrayList<Vehicle>(Collections.nCopies(20,null));
    //scanner to get the inputs
    Scanner sc = new Scanner(System.in);
    //free slot counter
    int slotCounter = 20;


    public static void main(String[] args) {
        WestminsterCarParkManager w = new WestminsterCarParkManager();
        //w.initialize();
        w.display();

    }

    //Method to display the menu
    public void display(){

        //String to hold the menu option
        int option;
        //instance of westminster car park manager
        WestminsterCarParkManager westminsterCarParkManager = new WestminsterCarParkManager();

        System.out.println("\t \t \t \t \tW E L C O M E \t T O \t T H E" );
        System.out.println();
        System.out.println("W E S T M I N S T E R \t C A R \t P A R K \t M A N A G E M E N T \t S Y S T E M " );
        System.out.println();
        System.out.println("- - - - - - - - - - - Main Menu- - - - - - - - - - - ");
        System.out.println();
        System.out.println("1. Add a new Vehicle");

        option = sc.nextInt();

        switch (option){
            case 1:
                westminsterCarParkManager.addVehicle();
                //System.out.println(Arrays.toString(slots));
                break;
            case 2:

        }

    }
    /*//initialises the slot array
    public void initialize(){
        for (int i=0;i<20;i++){
            slots[i] = new Slot("Empty Slot");
        }
    }*/

    //Method for adding a new Vehicle
    public void addVehicle(){

        //string to hold the vehicle type selection
        int type;

        System.out.println();
        System.out.println("- - - - - - - - - Add a new vehicle- - - - - - - - - \n ");

        //displays the number of free slots
        getFreeSlots();

        if(slotCounter>0) {

            System.out.println("Please select the type of the Vehicle");
            System.out.println("\t 1. Car");
            System.out.println("\t 2. Van");
            System.out.println("\t 3. Motorbike");

            type = sc.nextInt();

            switch (type) {
                case 1:

                    Car car = addVehicleToList(Car.class);

                    System.out.println("Please enter the number of Doors of the Car");
                    car.setNumDoors(sc.next());

                    System.out.println("Please enter the Color of the Car");
                    car.setColor(sc.next());

                    slots.remove(slotCounter-1);
                    slots.add(slotCounter-1,car);
                    slotCounter--;
                    System.out.println(slots.toString());
                    addVehicle();

                    break;

                case 2:

                    Van van = addVehicleToList(Van.class);

                    System.out.println("Please enter the cargo volume of the van");
                    van.setCargoVolume(sc.next());

                    slots.remove(slotCounter-1);
                    slots.add(slotCounter-1,van);
                    slotCounter = slotCounter - 2;
                    System.out.println(slots.toString());
                    addVehicle();

                    break;

                case 3:

                    Motorbike bike = addVehicleToList(Motorbike.class);

                    System.out.println("Please enter the engine capacity of the Motor bike");
                    bike.setEngineCapacity(sc.next());

                    slots.remove(slotCounter-1);
                    slots.add(slotCounter-1,bike);
                    slotCounter--;
                    System.out.println(slots.toString());

                    addVehicle();

                    break;

            }
        }else {
            return;
        }

    }
    public void getFreeSlots(){

        if(slotCounter>0){
            System.out.println(" \n There are " +slotCounter+ " free slots left. \n" );
        }else {
            System.out.println("\n Sorry! There are no free slots left. \n" );
        }
    }

    public <T extends Vehicle> T addVehicleToList(Class type){
        T vehicle;
        if(type.equals(Car.class)){
            vehicle = (T)new Car();
        } else if(type.equals(Van.class)){
            vehicle = (T)new Van();
        } else{
            vehicle = (T)new Motorbike();
        }

        DateTime dateTime = new DateTime();

        System.out.println("Please enter the ID Plate number of the Vehicle");
        vehicle.setIdPlate(sc.next());

        System.out.println("Please enter the Brand of the Car");
        vehicle.setVehicleBrand(sc.next());

        String timeString;
        String[] time;

        //loop until the time is valid
        do {
            System.out.println("Please enter the entrance Time in the format of "+
                    "HH:MM:SS" );

            timeString = sc.next();
            time = timeString.split(":");

            //display an error if the time is invalid
            if (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60) {
                System.out.println( "\n Invalid time. Please try again.\n ");
                continue;
            }

        }
        while (Integer.parseInt(time[0]) >= 24 || Integer.parseInt(time[1]) >= 60 || Integer.parseInt(time[2]) >= 60);


        //setting the time
        dateTime.setHour(time[0]);
        dateTime.setMinute(time[1]);
        dateTime.setSecond(time[2]);

        String dateString;
        String[] date;

        //loop until the date is valid
        do {
            System.out.println("Please enter the entrance Date in the format of "+
                    "YYYY-MM-DD");

            dateString = sc.next();
            date = dateString.split("-");

            //display an error if the date is invalid
            if (Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31) {
                System.out.println("\n Invalid date. Please try again.\n ");
                continue;

                //checks if the year is a 4 digit number or not
            } else if ((int) Math.log10(Integer.parseInt(date[0])) + 1 < 4) {
                System.out.println( "\n The year you entered appears to be invalid. Please try again.\n " );
                continue;
            }

        }
        while ((int) Math.log10(Integer.parseInt(date[0])) + 1 < 4 || Integer.parseInt(date[1]) > 12 || Integer.parseInt(date[2]) > 31);

        //sets the date
        dateTime.setYear(date[0]);
        dateTime.setMonth(date[1]);
        dateTime.setDay(date[2]);
        vehicle.setDateTime(dateTime);
        return vehicle;

    }
}
