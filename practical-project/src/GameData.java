import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class GameData {
    protected final List<Knight> activeKnights;
    protected final List<Fortune> fortunes;
    protected final List<Knight> knights;
    protected final int MAX_ACTIVE = 4;
    protected final List<MOB> monsters;
    private static final Random random = new Random();

    public GameData() {
        this.knights = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.fortunes = new ArrayList<>();
        this.activeKnights = new ArrayList<>();
    }

    /*
     * public List<Knight> getKnights()
     * Returns all knights.
     * Returns:
     * all knights stored in knights
     */

    public List<Knight> getKnights() {
        return knights;
    }

    /*
     * public List<Knight> getActiveKnights()
     * Returns list of knights currently set as active.
     * Returns:
     * Essentially returns activeKnights
     */

    public List<Knight> getActiveKnights() {
        return activeKnights;
    }

    /*
     * public Knight getActive(String nameOrId)
     * Gets an active knight based on a string or id. The string can be word in the
     * knights name, and will return the first knight that it comes across that
     * matches that string. The id is supposed to be unique, and will find the
     * knight with that id, immediately returning the knight. Uses findKnight to
     * accomplish the task.
     * Parameters:
     * nameOrId - string or ID as a string
     * Returns:
     * the active knight if it exists, or null if it is not found
     */

    public Knight getActive(String nameOrId) {
        return findKnight(nameOrId, activeKnights);
    }

    /*
     * public Knight getKnight(String nameOrId)
     * Gets an knight from the all knights list based on a string or id. The string
     * can be word in the knights name, and will return the first knight that it
     * comes across that matches that string. The id is supposed to be unique, and
     * will find the knight with that idea, immediately returning the knight. Uses
     * findKnight to accomplish the task.
     * Parameters:
     * nameOrId - string or ID as a string
     * Returns:
     * the knight if it exists, or null if it is not found
     */

    public Knight getKnight(String nameOrId) {
        return findKnight(nameOrId, knights);
    }

    /*
     * protected Knight findKnight(String nameOrId,
     * List<Knight> list)
     * Finds a knight based on nameOrId based on the a List of knights passed into
     * it. The name can be any part of the name (contains), but the ID must exactly
     * match. Case does not matter for names. Note for students: getId() returns an
     * Integer (not int), so you can call toString, and just compare Strings. That
     * is valid, no need to parse.
     * Parameters:
     * nameOrId - a name or id string
     * list - the list of knights to search - often knights or activeKnights
     * Returns:
     * the single knight if found, or null if not found.
     */

    protected Knight findKnight(String nameOrId, List<Knight> list) {
        for (Knight knight : list) {
            if (knight.getName().toLowerCase().contains(nameOrId.toLowerCase())
                    || knight.getId().toString().equalsIgnoreCase(nameOrId)) {
                return knight;
            }
        }
        return null;
    }

    /*
     * public boolean setActive(Knight kt)
     * Adds a knight to the activeKnights list, as long as there are no more than 4
     * knights in the list.
     * Parameters:
     * kt - knight to add
     * Returns:
     * true if the addition was successful, false if the knight wasn't added due to
     * too many knights already being in the list
     */

    public boolean setActive(Knight kt) {
        if (activeKnights.size() < MAX_ACTIVE) {
            activeKnights.add(kt);
            return true;
        }
        return false;
    }

    /*
     * public void removeActive(Knight kt)
     * Removes a knight from the activeKnights list and resets the damage on the
     * knight! Remember, list.remove returns true if the remove was successful.
     * Parameters:
     * kt - knight to remove
     */

    public void removeActive(Knight kt) {
        if (activeKnights.remove(kt)) {
            kt.resetDamage();
        }
    }

    /*
     * public Fortune getRandomFortune()
     * Gets a random fortune from fortunes Since fortunes.size() gives you the total
     * fortunes, and random.nextInt(N) gives you a random number between 0-(N-1),
     * combine them!
     * Returns:
     * a Fortune from the fortunes list
     */

    public Fortune getRandomFortune() {
        if (!fortunes.isEmpty()) {
            int index = random.nextInt((fortunes.size()));
            return fortunes.get(index);
        }
        return null;
    }

    /*
     * 
     * public List<MOB> getRandomMonsters()
     * Gets a random monster from monsters assuming the max number of monsters is
     * less than or equal to activeKnights.size(). Careful about an OB1 error here!
     * Returns:
     * a list of MOBs no greater than activeKnights.size()
     */

    public List<MOB> getRandomMonsters() {
        return getRandomMonsters(Math.min(monsters.size(), activeKnights.size()));
    }

    /*
     * public List<MOB> getRandomMonsters(int number)
     * Builds a list of random monsters of size number. Note, that monsters should
     * be copied into the return List, so they can be modified individually.
     * Parameters:
     * number - the number of monsters to randomly grab and copy
     * Returns:
     * a list of MOB/monsters (copies)
     * See Also:
     * MOB.copy()
     */

    public List<MOB> getRandomMonsters(int number) {
        List<MOB> rmobs = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            if (!monsters.isEmpty()) {
                int index = random.nextInt(monsters.size());
                MOB randomMonster = monsters.get(index).copy();
                rmobs.add(randomMonster);
            }
        }
        return rmobs;
    }

    /*
     * public abstract void save(String filename)
     * Required for the implementing class to be able to save the file
     * Parameters:
     * filename - name of file to save
     */

    public abstract void save(String filename);
}