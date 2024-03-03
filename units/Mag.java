package units;

import java.util.ArrayList;

// Колдун. Своё свойство - мана и магия
public class Mag extends Unit {
    int mana;
    String magic;
    public Mag(String name, int x, int y) {
        super(name, 150, "magicStick", 20, 2, 10, 50, 40, new Position(x,y));
        mana = 200;
        magic = "wizardDust";
    }
    @Override
    public String toString(){
        return name;
    }


    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> friend) {

    }
}
