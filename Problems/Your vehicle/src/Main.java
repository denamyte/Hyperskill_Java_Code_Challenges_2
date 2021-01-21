//class Vehicle {
//
//    Vehicle() {
//
//    }
//
//    class Engine {
//        void start() {
//            System.out.println("RRRrrrrrrr....");
//        }
//    }
//}

class EnjoyVehicle {

    public static void startVehicle() {
        new Vehicle().new Engine().start();
    }
}