public class GasolineCar extends Car implements Immutable {
    private final double engineCapacity;

    public GasolineCar(String brand, String model, int year, double engineCapacity) {
        super(brand, model, year);
        this.engineCapacity = engineCapacity;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public void printEngineDetails() {
        System.out.println("Engine details: " + this.getEngineCapacity());
    }

    @Override
    public GasolineCar copy() {
        double newEngineCapacity = this.getEngineCapacity() + 0.5;
        return new GasolineCar(getBrand(), getModel(), getYear(), newEngineCapacity);
    }

    @Override
    public String toString() {
        return "GasolineCar{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", year=" + getYear() +
                ", engineCapacity=" + engineCapacity +
                '}';
    }
}
