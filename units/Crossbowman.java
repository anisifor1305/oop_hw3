package units;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Арбалетчик. Своё свойство - количество стрел
public class Crossbowman extends Unit {
    int countArrow;
    public Crossbowman(String name, int x, int y) {
        super(name, 150, "crossbow", 20, 4, 15, 50, 40, new Position(x,y));
        countArrow = 10;
    }
    @Override
    public String toString(){
        return name;
    }

/*
Доработать классы лучников. Лучник должен, во-первых, проверить жив ли он и есть ли у него стрелы,
если нет то завершить метод. Если всё да, то найти ближайшего противника и выстрелить по нему
и, соответственно потратить одну стрелу. Реализовать весь функционал лучников в методе step().
 */
    @Override
    public void step(ArrayList<Unit> enemy, ArrayList<Unit> friend) {
        if ((health<=0) || (countArrow == 0)) return;
        Unit target = super.nearestEnemy(enemy);
        target.getHit(this.powerHit);
        countArrow--;




    }





}
