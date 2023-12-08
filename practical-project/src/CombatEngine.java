import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CombatEngine {

    private final GameData data;
    private final DiceSet dice;
    private final Random rnd;
    private final GameView view;

    /*
     * public CombatEngine(GameData data,
     * GameView view)
     * To run the combat, a GameData and GameView is essential for it to work. It is
     * designed to use classes that implement the GameView and GameData interfaces
     * Parameters:
     * data - a game dataset
     * view - a game view
     */

    public CombatEngine(GameData data, GameView view) {
        this.data = data;
        this.view = view;
        this.dice = new DiceSet();
        this.rnd = new Random();
    }

    /*
     * public void initialize()
     * Before every quest, active knights are assigned random fortunes
     * (GameData.getRandomFortune(). Once a fortune is assigned to each active
     * knight, call GameView.printFortunes(List) Hints: Loops through
     * getActiveKnights() and setActiveFortune using a getRandomFortune() from data.
     */

    public void initialize() {
        for (Knight knight : data.getActiveKnights()) {
            knight.setActiveFortune(data.getRandomFortune());
        }
        view.printFortunes(data.getActiveKnights());
    }

    /*
     * public void runCombat()
     * Runs the combat simulation (optional).
     * This method is NOT graded - and is purely a "challenge" for you to implement.
     * 
     * Combat will continue to run as long as there are either knights or
     * monsters/MOBs. If MOBs are reduced to zero, the player will be promoted to
     * see if they wish to continue exploring GameView.checkContinue(). If they
     * respond yes, more random monsters will be generated, and combat begins again.
     * At the start of each battle:
     * 
     * Generates a random list of MOBs, no larger than the total number of knights
     * GameData.getRandomMonsters()
     * Prints the battle text, on who the fight is between
     * GameView.printBattleText(List, List)
     * Runs through the combat
     * 
     * The combat order itself is undefined on order of actions, but the following
     * must happen
     * When knights are defeated (MOB.getHP() <= 0), they are removed from active
     * knights
     * When MOBs are defeated, every active knight earns 1 XP point
     * (Knight.addXP(int))
     * While combat order is undefined, a common implementation is cycle through the
     * knights having them attack a random monster. We then cycle through the MOBs
     * having them each attack a random knight.
     * When a knight or mob is defeated, we print that they were defeated
     * GameView.printBattleText(MOB)
     * If all knights are defeated, we notify the player using
     * GameView.printDefeated().
     * 
     * Calculating Hits
     * To calculate a successful hit, you roll a D20 (DiceSet.roll(DiceType) take
     * that value, add the MOBs/Knights toHitModifier. If the value is greater than
     * the armor value, they score a hit, and the damage die is rolled.
     * 
     * D20 + hitModifier > armor (successful hit formula)
     * 
     * 
     * Upon a successful strike, the damage die is rolled to determine the amount of
     * damage the opponent takes Hint to students: private helper methods are
     * extremely helpful here. As is helps break up the above steps. Make sure to
     * take it in small parts, printing out in each step.
     */

    public void runCombat() {
        while (!data.getActiveKnights().isEmpty() && !data.getRandomMonsters().isEmpty()) {
            List<MOB> monsters = data.getRandomMonsters();
            List<Knight> activeKnights = data.getActiveKnights();

            view.printBattleText(monsters, activeKnights);

            for (Knight knight : activeKnights) {
                MOB randomMonster = getRandomMonster(monsters);
                performAttack(knight, randomMonster);
            }

            for (MOB monster : monsters) {
                Knight randomKnight = getRandomKnight(activeKnights);
                performAttack(monster, randomKnight);
            }

            List<Knight> defeatedKnights = removeDefeatedKnights(activeKnights);
            List<MOB> defeatedMonsters = removeDefeatedMonsters(monsters);

            for (Knight knight : defeatedKnights) {
                view.printBattleText(knight);
            }

            for (MOB monster : defeatedMonsters) {
                view.printBattleText(monster);
                for (Knight knight : activeKnights) {
                    knight.addXP(1);
                }
            }

            if (data.getActiveKnights().isEmpty()) {
                view.printDefeated();
            }

            if (view.checkContinue()) {
                data.getRandomMonsters();
            } else {
                break;
            }
        }
    }

    private MOB getRandomMonster(List<MOB> monsters) {
        return monsters.get(rnd.nextInt(monsters.size()));
    }

    private Knight getRandomKnight(List<Knight> knights) {
        return knights.get(rnd.nextInt(knights.size()));
    }

    private void performAttack(MOB attacker, MOB defender) {
        if (attacker.getHP() > 0 && defender.getHP() > 0) {
            if (dice.roll(DiceType.D20) + attacker.getHitModifier() > defender.getArmor()) {
                int damage = dice.roll(attacker.getDamageDie());
                defender.addDamage(damage);
            }
        }
    }

    private List<Knight> removeDefeatedKnights(List<Knight> knights) {
        List<Knight> defeatedKnights = new ArrayList<>();
        knights.removeIf(knight -> {
            if (knight.getHP() <= 0) {
                defeatedKnights.add(knight);
                return true;
            }
            return false;
        });
        return defeatedKnights;
    }

    private List<MOB> removeDefeatedMonsters(List<MOB> monsters) {
        List<MOB> defeatedMonsters = new ArrayList<>();
        monsters.removeIf(monster -> {
            if (monster.getHP() <= 0) {
                defeatedMonsters.add(monster);
                return true;
            }
            return false;
        });
        return defeatedMonsters;
    }

    /*
     * clear
     * public void clear()
     * Sets all fortunes to *null* across all knights. It is easier to just loop
     * through all Knights setting the fortune to null, simply because activeKnights
     * can be harder to track after combat is done.
     * See Also:
     * Knight.setActiveFortune(Fortune)
     * GameData.getKnights()
     */

    public void clear() {
        for (Knight knight : data.getKnights()) {
            knight.setActiveFortune(null);
        }
    }
}