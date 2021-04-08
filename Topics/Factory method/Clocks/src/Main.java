import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

/* Product - Clock */
interface Clock {
    void tick();
}

/* Concrete Product - Sand Clock */
class SandClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...sand noise...");
    }
}

/* Concrete Product - Digital Clock */
class DigitalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...pim...");
    }
}

/* Concrete Product - Mechanical Clock */
class MechanicalClock implements Clock {

    @Override
    public void tick() {
        System.out.println("...clang mechanism...");
    }
}

class ClockFactory {

    static final Map<String, Supplier<Clock>> CLOCK_MAP = Map.of(
            "Sand", SandClock::new,
            "Digital", DigitalClock::new,
            "Mechanical", MechanicalClock::new
    );

    /* It produces concrete clocks corresponding their types : Digital, Sand or Mechanical */
    public Clock produce(String type) {
        return CLOCK_MAP.get(type).get();
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String type = scanner.next();
        final ClockFactory clockFactory = new ClockFactory();
        final Clock clock = clockFactory.produce(type);
        clock.tick();
        scanner.close();
    }
}