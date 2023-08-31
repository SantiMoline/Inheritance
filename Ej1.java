import Ej1.entities.Animal;
import Ej1.entities.Dog;
import Ej1.entities.Cat;
import Ej1.entities.Horse;

public class Ej1 {
    public static void main(String[] args) {
        Animal dog1 = new Dog("Stich", "Meat", 15, "Doberman");
        dog1.eat();

        Animal dog2 = new Dog("Teddy", "Fish & Chips", 10, "Golden Retriever");
        dog2.eat();

        Animal cat = new Cat("Tom", "Cookies", 15, "Siamés");
        cat.eat();

        Animal horse = new Horse("Tornado", "Grass", 25, "Pony");
        horse.eat();

    }
}
