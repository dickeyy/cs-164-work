public class Knight extends MOB {
    private Fortune activeFortune;
    private int id;
    private int xp;

    public Knight(int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public int getArmor() {
        // Include armor from the active fortune if it is set
        return super.getArmor() + (activeFortune != null ? activeFortune.getArmor() : 0);
    }

    public DiceType getDamageDie() {
        // Use the damage die from the active fortune if it is set
        return (activeFortune != null && activeFortune.getDamageDie() != null) ? activeFortune.getDamageDie() : super.getDamageDie();
    }

    public int getHitModifier() {
        // Include hit modifier from the active fortune if it is set
        return super.getHitModifier() + (activeFortune != null ? activeFortune.getHitModifier() : 0);
    }

    public Integer getId() {
        return id;
    }

    public int getMaxHP() {
        // Include max HP bonus from the active fortune if it is set
        return super.getMaxHP() + (activeFortune != null ? activeFortune.getMaxHP() : 0);
    }

    public int getXP() {
        return xp;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    public String toCSV() {
        // Returns a Comma Separated value representation of the knight. The order is as follows
        // name,maxHP,armor,hitmodifer,damageDie,xp

        // for example, arthur, who has won zero battles, would return:
        // Arthur,40,16,2,D8,0
        return getName() + "," + getMaxHP() + "," + getArmor() + "," + getHitModifier() + "," + getDamageDie() + "," + getXP();
    }

    public String toString() {
        // The toString for the knight, returns a 'knight card'
        return "+============================+\n" +
                String.format("| %-27s|%n", getName()) +
                String.format("| id: %-23d|%n", getId()) +
                "|                            |\n" +
                String.format("| Health: %-6d  XP: %-7d|%n", getHP(), getXP())  +
                String.format("|  Power: %-6s  Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }
}
