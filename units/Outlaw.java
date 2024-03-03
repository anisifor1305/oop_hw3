package units;

import java.util.ArrayList;

// Разбойник. Своё свойство - воровство(крадет здоровье)
public class Outlaw extends Unit {
    int theft;
    public Outlaw(String name, int x, int y) {
        super(name, 150, "blade", 30, 6, 15, 50, 80, new Position(x,y));
        theft = 10;
    }
    @Override
    public String toString(){
        return name;
    }


    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> friend) {
        if (health<=0) return;

        Unit target = super.nearestEnemy(enemy);
        if (position.distance(target.position) < 2){
            target.getHit(this.powerHit);
            return;
        }
        Position diff = position.getDifference(target.position);

        Position newposition = new Position(position.x, position.y);

        if (Math.abs(diff.x) > Math.abs(diff.y))

            newposition.x += diff.x < 0 ? 1 : -1;
        else
            newposition.y += diff.y < 0 ? 1 : -1;

        for (Unit unit : friend) {
            if (unit.position.equals(newposition)) return;

        }
        this.position = newposition;

    }
}
