public class Fortune implements Attributes {
    private final int armor;
    private final DiceType dtype;
    private final int hitModifier;
    private final int hpBonus;
    private final String name;

    public Fortune(String name, int hpBonus, int armor, int hitModifier) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.dtype = null;
    }

    public Fortune(String name, int hpBonus, int armor, int hitModifier, DiceType type) {
        this.name = name;
        this.hpBonus = hpBonus;
        this.armor = armor;
        this.hitModifier = hitModifier;
        this.dtype = type;
    }

    @Override
    public int getArmor() {
        return armor;
    }

    @Override
    public int getMaxHP() {
        return hpBonus;
    }

    @Override
    public DiceType getDamageDie() {
        return dtype;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        // return in this format
        // +======================+
        // |Nobility              |
        // |HP Bonus:          +10|
        // |AC Bonus:           +1|
        // |Hit Bonus:          +1|
        // |Damage Adj:          -|
        // +======================+
        // Spacing is -22s for the name, 12s for the HP Bonus, 12s for the AC bonus, 11s for the hit bonus and 10s for the damage adj. Note: AC is armor., so you are looking at using the following methods:
        // getName()
        // getMaxHP() (for HP Bonus)
        // getArmor() (for AC Bonus)
        // getHitModifier() (For hit bonus)
        // getDamageDie() (For Damage Adj. Note if null, put in a dash - good case for the ternary operator ?)
        return "+======================+\n" +
                String.format("| %-22s|%n", getName()) +
                String.format("| HP Bonus:          +%-2d|%n", getMaxHP()) +
                String.format("| AC Bonus:          +%-2d|%n", getArmor()) +
                String.format("| Hit Bonus:         +%-2d|%n", getHitModifier()) +
                String.format("| Damage Adj:        %-2s|%n", getDamageDie() == null ? "-" : getDamageDie().toString()) +
                "+======================+";

    }

    // public static void main(String[] args) {
    //     Fortune ftn = new Fortune("Merlin Luck", 10, 5, 2, DiceType.D12);
    //     System.out.println("TESTING Armor in fortune\n " + ftn.getArmor());
    //     System.out.println("TESTING MaxHP in fortune\n " + ftn.getMaxHP());
    //     System.out.println("TESTING DamageDie in fortune\n " + ftn.getDamageDie());
    //     System.out.println("TESTING HitModifier in fortune\n " + ftn.getHitModifier());
    //     System.out.println("TESTING toString in fortune\n " + ftn.toString());
    // }
    
}
