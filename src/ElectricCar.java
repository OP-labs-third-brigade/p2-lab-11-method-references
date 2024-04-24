public class ElectricCar extends Car implements Immutable {
    private final int batteryCapacity;

    public ElectricCar(String brand, String model, int year, int batteryCapacity) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public ElectricCar copy() {
        int newBatteryCapacity = this.getBatteryCapacity() + 10;
        return new ElectricCar(this.getBrand(), this.getModel(), this.getYear(), newBatteryCapacity);
    }

    @Override
    public String toString() {
        return "ElectricCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", batteryCapacity=" + batteryCapacity +
                '}';
    }

    interface ElectricCarInterface {
        ElectricCar createInstance(String brand, String model, int year, int batteryCapacity);
    }
}
