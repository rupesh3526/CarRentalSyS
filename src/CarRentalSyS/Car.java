package CarRentalSyS;

class Car{
    private String carId;
    private String brandName;
    private String model;
    private double bestPricePerDay;



    public Car() {
        super();
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", model='" + model + '\'' +
                ", bestPricePerDay=" + bestPricePerDay +
                ", isAvaliable=" + isAvaliable +
                '}';
    }
    private boolean isAvaliable;
    public Car(String carId, String brandName, double bestPricePerDay, String model) {
        this.carId = carId;
        this.brandName = brandName;
        this.bestPricePerDay = bestPricePerDay;
        this.model = model;
        this.isAvaliable = true;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getBestPricePerDay() {
        return bestPricePerDay;
    }

    public void setBestPricePerDay(double bestPricePerDay) {
        this.bestPricePerDay = bestPricePerDay;
    }

    public boolean isAvaliable() {
        return isAvaliable;
    }

    public void setAvaliable(boolean avaliable) {
        isAvaliable = avaliable;
    }
}

