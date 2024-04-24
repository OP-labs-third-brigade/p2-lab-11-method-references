import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        // constructor ref
        ElectricCar.ElectricCarInterface constructor = ElectricCar::new;
        ElectricCar electricCar = constructor.createInstance("Tesla", "Model 3", 2023, 75);

        ElectricCar electricCar1 = new ElectricCar("Hyundai", "Ioniq 6", 2022, 74);
        ElectricCar electricCar2 = new ElectricCar("Rolls-Royce", "Spectre", 2023, 87);

        GasolineCar gasolineCar = new GasolineCar("Toyota", "Camry", 2023, 3.5);
        GasolineCar gasolineCar1 = new GasolineCar("Nissan", "Sentra", 2021, 2.5);
        GasolineCar gasolineCar2 = new GasolineCar("Kia", "Forte", 2022, 1.5);

        ElectricCar copyElectricCar = electricCar.copy();
        GasolineCar copyGasolineCar = gasolineCar.copy();

        System.out.println("Are an electric car and a copy of an electric car the same? " + electricCar.equals(copyElectricCar));
        System.out.println("Are a gasoline car and a copy of an gasoline car the same? " + gasolineCar.equals(copyGasolineCar));

        Car[] carsArray = { electricCar,
                electricCar1,
                electricCar2,
                gasolineCar,
                gasolineCar1,
                gasolineCar2
        };
        Arrays.sort(carsArray, new Car.CarYearComparator());

        System.out.println("\nSorted cars array by year:");
        for (Car car : carsArray) {
            System.out.println(car);
        }

        TreeSet<Car> carsSet = new TreeSet<>(new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                return car1.getBrand().compareTo(car2.getBrand());
            }
        });

        carsSet.add(electricCar);
        carsSet.add(electricCar1);
        carsSet.add(electricCar2);
        carsSet.add(gasolineCar);
        carsSet.add(gasolineCar1);
        carsSet.add(gasolineCar2);

        System.out.println("\nCars TreeSet sorted by brand:");
        for (Car car : carsSet) {
            System.out.println(car);
        }

        System.out.println("\nRefs demonstrated:");

        // ref to nonstatic method
        CarReferenceInterface nonStaticRef = Car::printCarDetails;
        nonStaticRef.printCar(electricCar);

        // ref to a static method
        CarReferenceInterface staticRef = Car::staticPrintCarDetails;
        staticRef.printCar(electricCar);

        // ref to object method
        CarToStringInterface toStringRef = Car::toString;
        System.out.println(toStringRef.toString(electricCar));
    }

    interface CarReferenceInterface {
        void printCar(Car car);
    }

    interface CarToStringInterface {
        String toString(Car car);
    }
}