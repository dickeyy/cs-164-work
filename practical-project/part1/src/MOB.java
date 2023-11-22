public class MOB implements Attributes {
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;

    public MOB(String name, int maxHP, int armor, int hitModifier, DiceType damageDie) {
        this.name = name;
        this.maxHP = maxHP;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.damageDie = damageDie;
    }

    public void addDamage(int damage) {
        this.damage += damage;
    }

    public MOB copy() {
        return new MOB(name, maxHP, armor, hitModifier, damageDie);
    }

    public void resetDamage() {
        damage = 0;
    }

    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                            |\n" +
                String.format("|         Health: %-10d |%n", getHP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return maxHP - damage;
    }

    public int getDamage() {
        return damage;
    }
    
    // public static void main(String[] args) {
        
    // }
}
