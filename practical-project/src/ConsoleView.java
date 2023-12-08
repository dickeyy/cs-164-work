import java.util.List;
import java.util.Scanner;

public class ConsoleView implements GameView {

    private final Scanner in;

    public ConsoleView() {
        this.in = new Scanner(System.in);
    }

    /*
     * splashScreen
     * public void splashScreen()
     * Prints a splashScreen that is called at the launch of the game. Students: you
     * can make the splashScreen anything you want.
     * Specified by:
     * splashScreen in interface GameView
     */

    @Override
    public void splashScreen() {
        System.out.println("Welcome to the game!");
    }

    /*
     * public void endGame()
     * Prints a goodbye message for completing the game.
     * Specified by:
     * endGame in interface GameView
     */

    @Override
    public void endGame() {
        System.out.println("Thanks for playing! Goodbye!");
    }

    /*
     * displayMainMenu
     * public String displayMainMenu()
     * Displays a "menu" for the player. Really, for text based games this was often
     * just a simple question. The following question will be displayed
     * What would you like to do?
     * 
     * The clients response will be recorded, and returned out of the method.
     * Remember that Scanner connected to System.in, should be a class instance
     * variable to prevent conflicts.
     * 
     * Specified by:
     * displayMainMenu in interface GameView
     * Returns:
     * the clients response, as an entire line.
     */

    @Override
    public String displayMainMenu() {
        System.out.println("What would you like to do? ");
        return in.nextLine();
    }

    /*
     * printHelp
     * public void printHelp()
     * Prints the help menu. The options are as follows.
     * 
     * Unsure what to do, here are some options:
     * ls or list all - listing the knights
     * list active - list the active knights knights only
     * show name or id - show the knight details card
     * set active name or id - set knight as active (note: only 4 knights can be
     * active)
     * remove active name or id - remove a knight from active status (heals knight)
     * explore or adventure or quest - find random monsters to fight
     * save filename - save the game to the file name (default: saveData.csv)
     * exit or goodbye - to leave the game
     * 
     * Game rules: You can have four active knights. As long as they are active,
     * they won't heal,
     * but they can gain XP by going on adventures.
     * When you make a knight inactive, they will heal. How many monsters can you
     * defeat
     * before, you have to heal?
     * 
     * 
     * Note the space before the options is the tab character.
     * Specified by:
     * printHelp in interface GameView
     */

    @Override
    public void printHelp() {
        System.out.println("Unsure what to do, here are some options:");
        System.out.println("\tls or list all  - listing the knights");
        System.out.println("\tlist active  - list the active knights knights only");
        System.out.println("\tshow name or id - show the knight details card");
        System.out.println("\tset active name or id - set knight as active (note: only 4 knights can be active) ");
        System.out.println("\tremove active name or id - remove a knight from active status (heals knight)");
        System.out.println("\texplore or adventure or quest - find random monsters to fight");
        System.out.println("\tsave filename - save the game to the file name (default: saveData.csv)");
        System.out.println("\texit or goodbye - to leave the game");
        System.out.println();
        System.out.println(
                "Game rules: You can have four active knights. As long as they are active, they won't heal,\nbut they can gain XP by going on adventures.");
        System.out.println(
                "When you make a knight inactive, they will heal. How many monsters can you defeat\nbefore, you have to heal?");
        System.out.println();
    }

    /*
     * listKnights
     * public void listKnights(List<Knight> knights)
     * Lists the knights by id: name. Example:
     * 1: Guinevere
     * 2: Morrigan Ravenskind
     * 3: Eriu
     * 4: Danu of Ireland
     * 5: Fodla
     * 6: Banba
     * 7: Igraine of the Lake
     * 8: Anna of the Mountains
     * 9: Morgan la Fay
     * 10: Elaine Pendragon
     * 11: Morgawse
     * 12: Arthur
     * 13: Lancelot
     * 14: Gwain
     * 15: Argodras the Red
     * 16: The Green Knight
     * 17: Cam the Ram
     * 
     * 
     * If no knights are found, it prints the following:
     * No knights to list
     * 
     * 
     * Specified by:
     * listKnights in interface GameView
     * Parameters:
     * knights - a set of knights to list
     * See Also:
     * Knight.getId() MOB.getName()
     * 
     */

    @Override
    public void listKnights(List<Knight> knights) {
        if (knights.isEmpty()) {
            System.out.println("No knights to list");
        } else {
            for (Knight knight : knights) {
                System.out.println(knight.getId() + ": " + knight.getName());
            }
            System.out.println();
        }
    }

    /*
     * knightNotFound
     * public void knightNotFound()
     * Prints
     * Knight not found!
     * 
     * To the console.
     * Specified by:
     * knightNotFound in interface GameView
     */

    @Override
    public void knightNotFound() {
        System.out.println("Knight not found!");
    }

    /*
     * showKnight
     * public void showKnight(Knight knight)
     * Prints a knight to the console, plus a blank line.
     * Specified by:
     * showKnight in interface GameView
     * Parameters:
     * knight - the knight whose card is meant to print
     * See Also:
     * Knight.toString()
     */

    @Override
    public void showKnight(Knight knight) {
        System.out.println(knight);
        System.out.println();
    }

    /*
     * setActiveFailed
     * public void setActiveFailed()
     * Prints the following message followed by a blank line:
     * Unable to set active knight. Only four can be active at a time.
     * 
     * Specified by:
     * setActiveFailed in interface GameView
     */

    public void setActiveFailed() {
        System.out.println("Unable to set active knight. Only four can be active at a time.");
        System.out.println();
    }

    /*
     * printBattleText
     * public void printBattleText(List<MOB> monsters,
     * List<Knight> activeKnights)
     * Lists a number of knights side by side with their 'foes' (aka monsters).
     * Example:
     * Our heroes come across the following monsters. Prepare for battle!
     * Knights Foes
     * Guinevere Umber Hulk
     * Danu of Ireland
     * Arthur
     * 
     * 
     * Our heroes come across the following monsters. Prepare for battle!
     * Knights Foes
     * Danu of Ireland Frost Giant
     * Arthur Orc
     * Gwain Frost Giant
     * 
     * 
     * The spacing between does not matter. We used %-27s %n for our formatting. Be
     * careful when a list of monsters is less than the list of activeKnights, you
     * may need to think about different if conditions to make it work out without
     * an IndexOutOfBoundsException
     * 
     * Specified by:
     * printBattleText in interface GameView
     * Parameters:
     * monsters - a list of MOB objects
     * activeKnights - a list of Knight objects
     */

    @Override
    public void printBattleText(List<MOB> monsters, List<Knight> activeKnights) {
        System.out.println("Our heroes come across the following monsters. Prepare for battle!");
        System.out.printf("%-27s %s%n", "Knights", "Foes");

        int size = Math.max(monsters.size(), activeKnights.size());

        for (int i = 0; i < size; i++) {
            String knightName = (i < activeKnights.size()) ? activeKnights.get(i).getName() : "";
            String monsterName = (i < monsters.size()) ? monsters.get(i).getName() : "";

            System.out.printf("%-27s %s%n", knightName, monsterName);
        }
    }

    /*
     * printBattleText
     * public void printBattleText(MOB dead)
     * Prints that the MOB was defeated. Examples
     * Frost Giant was defeated!
     * 
     * Arthur was defeated!
     * 
     * Specified by:
     * printBattleText in interface GameView
     * Parameters:
     * dead - the defeated MOB
     * See Also:
     * MOB.getName()
     */

    @Override
    public void printBattleText(MOB dead) {
        System.out.printf("%s was defeated!%n", dead.getName());
    }

    /*
     * printFortunes
     * public void printFortunes(List<Knight> activeKnights)
     * Prints fortunes for the knight that they draw at the beginning of the quest
     * by cycling through the provided list of knights. You do not have to worry
     * about a special message if the fortune is null. Examples:
     * 
     * For this quest, our knights drew the following fortunes!
     * Danu of Ireland drew
     * +======================+
     * |Justice |
     * |HP Bonus: +5|
     * |AC Bonus: +2|
     * |Hit Bonus: +1|
     * |Damage Adj: -|
     * +======================+
     * Arthur drew
     * +======================+
     * |Nobility |
     * |HP Bonus: +10|
     * |AC Bonus: +1|
     * |Hit Bonus: +1|
     * |Damage Adj: -|
     * +======================+
     * Gwain drew
     * +======================+
     * |Obedience |
     * |HP Bonus: +0|
     * |AC Bonus: +3|
     * |Hit Bonus: +1|
     * |Damage Adj: -|
     * +======================+
     * 
     * 
     * Specified by:
     * printFortunes in interface GameView
     * Parameters:
     * activeKnights - A List of Knights
     * See Also:
     * Fortune.toString() MOB.getName()
     */

    @Override
    public void printFortunes(List<Knight> activeKnights) {
        System.out.println("For this quest, our knights drew the following fortunes!");
        for (Knight knight : activeKnights) {
            Fortune fortune = knight.getActiveFortune();
            System.out.println(knight.getName() + " drew");
            System.out.println(fortune);
        }
    }

    /*
     * public boolean checkContinue()
     * Checks with the user by asking if they want to continue their quest.
     * Would you like to continue on your quest (y/n)?
     * 
     * Specified by:
     * checkContinue in interface GameView
     * Returns:
     * true if the client types y, or yes (case ignored) - else false for anything
     * else.
     */

    @Override
    public boolean checkContinue() {
        System.out.println("Would you like to continue on your quest (y/n)? ");
        String response = in.nextLine();
        return response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes");
    }

    /*
     * printDefeated
     * public void printDefeated()
     * Prints when all knights are defeated, followed by an empty line.
     * All active knights have been defeated!
     * 
     * Specified by:
     * printDefeated in interface GameView
     */

    @Override
    public void printDefeated() {
        System.out.println("All active knights have been defeated!");
    }
}
