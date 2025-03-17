import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLVL {

    public static void main(String[] args) {
        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("##,###,###");
        try {
        System.out.println("Enter Starting Level: ");
        list.add(count++);
        int fromLevel = reader.nextInt();
        if (!(fromLevel >= 1 && fromLevel <= 200))
            throw new Exception();
            System.out.println("Enter Current XP: ");
            list.add(count++);
            int currentXP = reader.nextInt();
            if (fromLevel >= 100 && currentXP > Lvl.combined[4][fromLevel - 1])
                throw new Exception();

            System.out.println("Enter Last Level: ");
            list.add(count++);
            int toLevel = reader.nextInt();
            if (!(toLevel > fromLevel && toLevel <= 200))
                throw new Exception();

            if (toLevel > 100) {
                System.out.println("Golden Dragon XP: " + f.format(Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, currentXP, toLevel, Lvl.Rarity.values()[4])));
            } else {

                System.out.println("Enter Rarity: ");
                list.add(count++);
                for (int i = 0; i < Lvl.Rarity.values().length; i++) {
                    System.out.println(i + ": " + Lvl.Rarity.values()[i].toString());
                }
                int rarity = reader.nextInt();

                System.out.println(f.format(Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, currentXP, toLevel, Lvl.Rarity.values()[rarity])));
            }
        } catch (Exception e) {
            switch (list.size()) {
                case 1:
                    System.out.println("\u001b[31mError: Starting level out of bounds.");
                    break;
                case 2:
                    System.out.println("\u001b[31mError: Out of Bounds Level XP.");
                    break;
                case 3:
                    System.out.println("\u001b[31mError: Last level out of bounds.");
                    break;
                case 4:
                    System.out.println("\u001b[31mError: Rarity range between 0-4, try again.");
                    break;
            }
        }
    }
}
