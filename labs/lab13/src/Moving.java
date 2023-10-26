import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Moving {
    public ArrayList<Bird> BirdsBox;
    public ArrayList<Feline> FelinesBox;
    public ArrayList<Reptile> ReptilesBox;

    public Moving(String filename){
        BirdsBox = new ArrayList<>();
        FelinesBox = new ArrayList<>();
        ReptilesBox = new ArrayList<>();
        movingBoxes(filename);
    }

    /**
     *
     * The Zoo is currently moving to a bigger location. Because of this, we need to take our file with information
     * about each animal we have and sort them into the appropriate crate to save space when moving.
     * The boxes are separated into Felines, Reptiles, and Birds, as listed in the code in your Moving.java file.
     *
     * Each line in your text file is listed:
     * type name
     *
     * Using the animal's type (gecko, lizard, lion, tiger, toucan, or parrot),
     * create an object of that type and pass in the animal's name.
     * Then add that object to the appropriate box.
     *
     * @param filename
     */
    public void movingBoxes(String filename){
        try {
            Scanner animals = new Scanner(new File(filename));
            while (animals.hasNextLine()){
                String[] animal = animals.nextLine().split(" ");
                if (animal[0].equals("gecko")){
                    ReptilesBox.add(new Gecko(animal[1]));
                }
                else if (animal[0].equals("lizard")){
                    ReptilesBox.add(new Lizard(animal[1]));
                }
                else if (animal[0].equals("lion")){
                    FelinesBox.add(new Lion(animal[1]));
                }
                else if (animal[0].equals("tiger")){
                    FelinesBox.add(new Tiger(animal[1]));
                }
                else if (animal[0].equals("toucan")){
                    BirdsBox.add(new Toucan(animal[1]));
                }
                else if (animal[0].equals("parrot")){
                    BirdsBox.add(new Parrot(animal[1]));
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Uh oh! I couldn't find your file!!");
        }
    }

    /**
     * Now that we have succesfully moved each crate of animals to the new zoo, it's time to do a headcount.
     * To do this, you will want to go through each of your lists one at a time and keep count of how many of
     * each type of animal you have found.
     *
     * For example, when going through the BirdsBox, we should check if
     * each object is an instanceOf a toucan or a parrot, then add to the appropriate counter.
     * Then, no matter which it was, we add to the birds counter.
     *
     * At the end, you will add this information to a string with a new line after every single entry.
     *
     * Final string should be in the form:
     * Birds = num
     * Toucans = num
     * Parrots = num
     * Felines = num
     * Lions = num
     * Tigers = num
     * Reptiles = num
     * Lizards = num
     * Geckos = num
     *
     *
     * The first box has been done for you.
     *
     * @return string in the form listed above
     */
    public String headCount(){
        String counts = "";
        int birds = 0;
        int toucans = 0;
        int parrots = 0;
        int felines = 0;
        int lions = 0;
        int tigers = 0;
        int reptiles = 0;
        int lizards = 0;
        int geckos = 0;

        for (int i = 0; i < BirdsBox.size(); i++){
            if (BirdsBox.get(i) instanceof Parrot){
                parrots++;
            }
            if (BirdsBox.get(i) instanceof Toucan){
                toucans++;
            }
            birds++;
        }

        counts += String.format("Birds = %s\nToucans = %s\nParrots = %s\n", birds, toucans, parrots);

        for (int i = 0; i < FelinesBox.size(); i++){
            if (FelinesBox.get(i) instanceof Lion){
                lions++;
            }
            if (FelinesBox.get(i) instanceof Tiger){
                tigers++;
            }
            felines++;
        }

        counts += String.format("Felines = %s\nLions = %s\nTigers = %s\n", felines, lions, tigers);

        for (int i = 0; i < ReptilesBox.size(); i++){
            if (ReptilesBox.get(i) instanceof Lizard){
                lizards++;
            }
            if (ReptilesBox.get(i) instanceof Gecko){
                geckos++;
            }
            reptiles++;
        }

        counts += String.format("Reptiles = %s\nLizards = %s\nGeckos = %s\n", reptiles, lizards, geckos);

        return counts;
    }



    public static void main(String[] args) {
        String file = "src/Animals.txt";
        Moving mover = new Moving(file);
        for (Bird bird: mover.BirdsBox){
            System.out.println(bird.getName());
        }
        System.out.println();
        for (Feline feline: mover.FelinesBox){
            System.out.println(feline.getName());
        }
        System.out.println();
        for (Reptile reptile: mover.ReptilesBox){
            System.out.println(reptile.getName());
        }
        System.out.println();
        System.out.println(mover.headCount());
    }
}
