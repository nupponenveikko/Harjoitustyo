package com.example.htveikkonupponen;

public class BattleField {
    public String fight(Lutemon first, Lutemon second) {
        StringBuilder result = new StringBuilder();

        Lutemon attacker = first;
        Lutemon defender = second;

        first.addBattle();
        second.addBattle();

        while (first.isAlive() && second.isAlive()) {
            result.append(attacker.getStats()).append("\n");
            result.append(defender.getStats()).append("\n");

            result.append(attacker.getName())
                    .append(" hyökkää ")
                    .append(defender.getName())
                    .append("\n");

            defender.defend(attacker.attack());

            if (defender.isAlive()) {
                result.append(defender.getName())
                        .append(" survived.\n\n");

                Lutemon temp = attacker;
                attacker = defender;
                defender = temp;
            } else {
                result.append(defender.getName())
                        .append(" lost the battle.\n");

                attacker.train();
                attacker.addWin();
                attacker.resetHealth();
                defender.resetHealth();

                result.append(attacker.getName())
                        .append(" wins!\n");

                break;
            }
        }

        return result.toString();
    }
}
