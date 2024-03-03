package units;
import java.util.Comparator;
import java.util.List;

public abstract class Unit implements MyInterface{
    String name;
    int health;
    String weapon;
    int powerHit;
    int speed;
    int bronya;
    int atackRange;
    int hidding;
    int maxHealth;
    int x;
    int y;

    String className;
    Position position;

    public Unit(String name, int health, String weapon, int powerHit, int speed, int bronya, int atackRange, int hidding, Position position){
        this.className = this.getClass().getSimpleName();
        this.name = name;
        this.maxHealth = this.health = health;
        this.weapon = weapon;
        this.powerHit = powerHit;
        this.speed = speed;
        this.bronya = bronya;
        this.atackRange = atackRange;
        this.hidding = hidding;
        this.position = position;


    }



    // Метод вывода информации о персонаже
    public void print() {
        System.out.println("units.Unit: " + className + ", Name: " + name + ", Health: " + health + ", Weapon: " + weapon + ", PowerHit: " + powerHit + ", Speed: " + speed + ", Bronya: " + bronya + ", AtackRange: " + atackRange + ", Hidding: " + hidding +"units.Position: " + position.getX() + "," + position.getY() + ".");
    }

    // Метод вывода короткой информации о персонаже
    public void printShort() {
        System.out.println("units.Unit: " + className + ", Name: " + name +", units.Position: " + position.getX() + "," + position.getY() + ".");
    }

    // Метод нанесения урона
    public void getHit(float damage) {
        health -= damage;
        if (health < 0) health = 0;
        if (health > maxHealth) health = maxHealth;

    }

    // Метод лечения
    public void Heall(Monk monk, Unit unit1) {
        unit1.health = unit1.health + monk.healing;

    }

    // Метод получения урона
    public void Damag(Unit unit1, Unit unit2) {
        unit1.health = unit1.health - unit2.powerHit;

    }

    // Метод колдовства
    public void Magical(Mag mag, Unit unit1) {
        unit1.health = unit1.health - mag.mana;

    }

    public Unit nearestEnemy(List<Unit> targets) {
        if (targets.isEmpty()) {
            return null; // Handle empty list case
        }

        Unit nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Unit hero : targets) {
            double distance = position.distance(hero.position);
            if (distance < minDistance && hero.health > 0) {
                minDistance = distance;
                nearest = hero;
            }
        }

        return nearest;
    }


    public int getSpeed() {
        return speed;
    }
}


