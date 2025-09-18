package CarRentalSyS;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {


    public static void main(String[] args) {

        Car car = new Car("Car01","A",15,"123");
        Car car2 = new Car("Car02","B",10,"132");
        Car car3= new Car("Car03","C",17,"321");
        List<Car> cr = new ArrayList<>();


        CarRentalSys  carRentalSys= new CarRentalSys();
        carRentalSys.add(car);
        carRentalSys.add(car2);
        carRentalSys.add(car3);
        carRentalSys.menu();


    }



}




