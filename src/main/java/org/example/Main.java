package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Animal {
    private String name;
    private String species;
    private int age;

    public Animal(String name, String species, int age) {
        this.name = name;
        this.species = species;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }
}

class Enclosure {
    private int capacity;
    private String type;
    private List<Animal> animals;

    public Enclosure(int capacity, String type) {
        this.capacity = capacity;
        this.type = type;
        this.animals = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public String getType() {
        return type;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public boolean isFull() {
        return animals.size() >= capacity;
    }
}

class Zoo {
    private List<Animal> animals;
    private List<Enclosure> enclosures;

    public Zoo() {
        animals = new ArrayList<>();
        enclosures = new ArrayList<>();
    }

    public void addAnimal(String name, String species, int age) {
        Animal animal = new Animal(name, species, age);
        animals.add(animal);
        System.out.println("Animal added: " + name);
    }

    public void addEnclosure(int capacity, String type) {
        Enclosure enclosure = new Enclosure(capacity, type);
        enclosures.add(enclosure);
        System.out.println("Enclosure added: " + type);
    }

    public void viewAnimals() {
        System.out.println("Animals in the zoo:");
        for (Animal animal : animals) {
            System.out.println("Name: " + animal.getName() + ", Species: " + animal.getSpecies() + ", Age: " + animal.getAge());
        }
    }

    public void viewEnclosures() {
        System.out.println("Enclosures in the zoo:");
        for (Enclosure enclosure : enclosures) {
            System.out.println("Type: " + enclosure.getType() + ", Capacity: " + enclosure.getCapacity());
            System.out.print("Animals in the enclosure: ");
            for (Animal animal : enclosure.getAnimals()) {
                System.out.print(animal.getName() + ", ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Zoo zoo = new Zoo();

        while (true) {
            System.out.println("1. Add Animal");
            System.out.println("2. Add Enclosure");
            System.out.println("3. View Animals");
            System.out.println("4. View Enclosures");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.next();
                    System.out.print("Enter species: ");
                    String species = scanner.next();
                    System.out.print("Enter age: ");
                    int age = scanner.nextInt();
                    zoo.addAnimal(name, species, age);
                    break;
                case 2:
                    System.out.print("Enter capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter type: ");
                    String type = scanner.next();
                    zoo.addEnclosure(capacity, type);
                    break;
                case 3:
                    zoo.viewAnimals();
                    break;
                case 4:
                    zoo.viewEnclosures();
                    break;
                case 5:
                    System.out.println("Exiting the program.");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}