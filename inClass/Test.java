public class Test {
    public static void main(String[] args) {
        int x = 10;
        int y = 5;

        if (x % 2 == 0 && y % 2 == 0 || x > y) {
            System.out.println("yes");
            if (y * 2 == x || y > 5 && x <= 10){
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } else {
            System.out.println("no");
        }
    }

    public class Person {
        private String name;
        private String phone;

        public Person(String name, String phone) {
            setName(name);
            setPhone(phone);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String toString(){
            return String.format("Name: %s\nPhone: %s", name, phone);
        }
    }

    public class Animal {
        private String name;
        private int yearsOld;
        private Person owner;

        public Animal(String name, int years, Person owner) {
            this.name = name;
            this.yearsOld = years;
            this.owner = owner;
        }

        public void setName(String name) {
            this.name = name;
        } 

        public void setYearsOld(int years) {
            this.yearsOld = years;
        }

        public void setOwner(Person owner) {
            this.owner = owner;
        }

        public String getName() {
            return name;
        }

        public int getYearsOld() {
            return yearsOld;
        }

        public Person getOwner() {
            return owner;
        }

        public String toString() {
            return String.format("Name: %s\nYears: %d\nOwner: %s", name, yearsOld, owner);
        }
    }
}
