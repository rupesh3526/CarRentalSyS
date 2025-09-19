package CarRentalSyS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSys {
    List<Car> cars = new ArrayList<>() ;
    List<Customer> customers = new ArrayList<>() ;
    List<Rental> rentals = new ArrayList<>() ;
    public void add(Car car){
        cars.add(car);
    }

    public void menu() {
        int choice;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("===Welocme to Car Rentals.===");
            System.out.println("1.Rent a car.");
            System.out.println("2.Return a rented car.");
            System.out.println("3.Exit");
            System.out.println("Enter your choice.");
            choice = sc.nextInt();
            sc.nextLine();


            if (choice == 1) {
                System.out.println("Enter your name.");
                String customerName = sc.nextLine();
                System.out.println("These cars are available for Rent");
                for (Car car : cars) {
                    if (car.isAvaliable()) {
                        System.out.println(car.getCarId() + " " + car.getBrandName() + " " + car.getModel() + " " + car.isAvaliable());
                    }
                }
                System.out.println("\nEnter the CarId You want to rent");
                String carId = sc.nextLine();

                System.out.println("For how many days you want?");
                int days = sc.nextInt();
                sc.nextLine();

                Customer customer = new Customer("CUS" + customers.size() + 1, customerName);
                customers.add(customer);
                Car selectedCar = null;

                for (Car car : cars) {
                    if (car.getCarId().equals(carId)) {
                        selectedCar = car;
                        car.setAvaliable(false);
                        break;
                    }

                }
                if (selectedCar != null) {
                    double totalPrice = selectedCar.getBestPricePerDay() * days;
                    System.out.println("\nRental information\n");
                    System.out.println("Customer Id :" + customer.getCustomerId());
                    System.out.println("Customer Name: " + customerName);
                    System.out.println("Selected car:" + selectedCar.getCarId());
                    System.out.println("Car Brand:" + selectedCar.getBrandName());
                    System.out.println("Car Model:" + selectedCar.getModel());
                    System.out.println("Retal Days" + days);
                    System.out.println("Total Rental Price:" + totalPrice);

                    System.out.println("\nCofirm (Y/N)");
                    String confirm = sc.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        Rental rental = new Rental(selectedCar, customer, days);
                        rentals.add(rental);
                        System.out.println(rental.getCar().getCarId() + "Thank you for renting .");
                    } else {
                        System.out.println("Thank you for showing interest.");
                    }

                } else {
                    System.out.println("You have entered wrong carId.");
                }

            } else if (choice == 2) {
                System.out.println("--Return car--");
                System.out.println("Enter the car Id you want to return.");
                String carId= sc.nextLine();
                Car rentedCar = null;
                for (Rental rented : rentals){
                    if (rented.getCar().getCarId().equals(carId)){
                        System.out.println("This car is reted by :" +rented.getCustomer().getCustomerName());
                        rented.getCar().setAvaliable(true);
                        rentals.remove(rented);
                        rentedCar=rented.getCar();
                        break;


                    }
                    else {
                        System.out.println("This Car was never Rented");
                    }
                }
                if (rentedCar!=null){
                    System.out.println("Thank you for using our service.");
                }

            } else {
                break;
            }
        }
    }
    public void rentCar(Car car, Customer customer, int days){
        if (car.isAvaliable()){
            car.setAvaliable(false);
            rentals.add(new Rental(car,customer,days));
            System.out.println("Thank you "+customer.getCustomerName()+ " for renting. Your Car id : "+car.getCarId());
        }else {
            System.out.println("This car is not available right now.");
        }

    }

    public void returnRentedCar(Car car){
        Rental removeFromRental= null;
        for (Rental rental : rentals){
            if (rental.getCar().equals(car)){
                removeFromRental=rental;
                break;
            }
        }
        if (removeFromRental!=null){
            System.out.println("Thanks for returning the car");
        }
        else {
            System.out.println("Car was never Rented");

        }

    }
}

