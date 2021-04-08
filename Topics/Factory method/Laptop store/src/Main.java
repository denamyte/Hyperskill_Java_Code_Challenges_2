import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        LaptopStore laptopStore = new LaptopStore();

        Laptop laptop13 = laptopStore.orderLaptop("13 inch");
        Laptop laptop15 = laptopStore.orderLaptop("15 inch");
        Laptop laptop17 = laptopStore.orderLaptop("17 inch");

        System.out.println("Available laptops in the store:");
        System.out.println(laptop13);
        System.out.println(laptop15);
        System.out.println(laptop17);
    }
}

abstract class LaptopFactory {

    abstract Laptop createLaptop(String type);

    Laptop orderLaptop(String type) throws InterruptedException {
        Laptop laptop = createLaptop(type);
        if (laptop == null) {
            System.out.println("Sorry, we are not able to create this kind of laptop\n");
            return null;
        }
        System.out.println("Making a " + laptop.getName());
        laptop.attachKeyboard();
        laptop.attachTrackpad();
        laptop.attachDisplay();
        Thread.sleep(1500L);
        System.out.println("Done a " + laptop.getName() + "\n");
        return laptop;
    }
}

class LaptopStore extends LaptopFactory {

    static final Map<String, Supplier<Laptop>> LAPTOP_MAP = Stream.of(13, 15, 17)
            .collect(Collectors.toMap(i -> i + " inch", i -> () -> new Laptop(i + " inch Laptop")));
    static final Supplier<Laptop> NO_LAPTOP = () -> null;

    @Override
    Laptop createLaptop(String type) {
        return LAPTOP_MAP.getOrDefault(type, NO_LAPTOP).get();
    }
}

class Laptop {
    private String name;

    Laptop(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void attachKeyboard() {
        System.out.println("Attaching keyboard");
    }

    void attachTrackpad() {
        System.out.println("Attaching trackpad");
    }

    void attachDisplay() {
        System.out.println("Attaching display");
    }

    @Override
    public String toString() {
        return name;
    }
}
