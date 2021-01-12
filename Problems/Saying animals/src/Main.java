class Animal {

    public void say() {
        output("...An incomprehensible sound...");
    }

    public static void output(String saying) {
        System.out.println(saying);
    }

//    public static void main(String[] args) {
//        new Cat().say();
//        new Dog().say();
//        new Duck().say();
//    }
}

class Cat extends Animal {
    @Override
    public void say() {
        output("meow-meow");
    }
}

class Dog extends Animal {
    @Override
    public void say() {
        output("arf-arf");
    }
}

class Duck extends Animal {
    @Override
    public void say() {
        output("quack-quack");
    }
}