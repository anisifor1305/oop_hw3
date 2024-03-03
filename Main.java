


import units.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();

        int teamcount = 10;
        ArrayList<Unit> team1 = new ArrayList<>();
        ArrayList<Unit> team2 = new ArrayList<>();
        for (int i = 0; i < teamcount; i++) {
            int val = random.nextInt(7);
            int coordX1 = random.nextInt(10);
            int coordX2 = random.nextInt(10);
            Position xy1 = new Position(coordX1, 0);
            Position xy2 = new Position(coordX2, 9);
            System.out.println(xy1);
            switch (val) {
                case 0:
                    team1.add(new Crossbowman(getName(), i,0));
                    team2.add(new Crossbowman(getName(), i,9));
                    break;
                case 1:
                    team1.add(new Mag(getName(), i,0));
                    team2.add(new Mag(getName(), i,9));
                    break;
                case 2:
                    team1.add(new Monk(getName(),i,0));
                    team2.add(new Monk(getName(), i,9));
                    break;
                case 3:
                    team1.add(new Outlaw(getName(), i,0));
                    team2.add(new Outlaw(getName(), i,9));
                    break;
                case 4:
                    team1.add(new Peasant(getName(), i,0));
                    team2.add(new Peasant(getName(), i,9));
                    break;
                case 5:
                    team1.add(new Sniper(getName(), i,0));
                    team2.add(new Sniper(getName(), i,9));
                    break;
                case 6:
                    team1.add(new Spearman(getName(), i,0));
                    team2.add(new Spearman(getName(), i,9));
                    break;
            }
        }
        System.out.println("Команда № 1:");
        for (Unit a : team1){
            a.printShort();

        }
        System.out.println("Команда № 2:");
        for (Unit a : team2){
            a.printShort();
        }

        List<Unit> team3 = new ArrayList<>();
        team3.addAll(team1);
        team3.addAll(team2);
        team3.sort((o1, o2) -> o2.getSpeed() - o1.getSpeed());
        System.out.println();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            scanner.nextLine();

            for (Unit unit : team3) {
                if (team1.contains(unit)) unit.step(team2, team1);
                else unit.step(team1, team2);

            }
            team3.forEach(n -> n.printShort());



        }
    }





    private static String getName(){
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }
}
