package units;

import java.util.ArrayList;

// Монах. Своё свойство - лечение
public class Monk extends Unit {
    int healing;
    public Monk(String name, int x, int y) {
        super(name, 150, "null", 0, 4, 10, 50, 40, new Position(x,y));
        healing = 0;
    }
    @Override
    public String toString(){
        return name;
    }



    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> friend) {

    }
}
