import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainLVL {

    public static void main(String[] args) {
        int rarity = 4;
        Scanner reader = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("##,###,###");
        try {
            System.out.println("Is Pet a Golden Dragon? (Yes/No)");
            String gDrag = reader.next();
            if (!gDrag.equalsIgnoreCase("yes")) {
                System.out.println("Enter Rarity: ");
                for (int i = 0; i < Lvl.Rarity.values().length; i++) {
                    System.out.println(i + ": " + Lvl.Rarity.values()[i].toString());
                }
                rarity = reader.nextInt();
                if (rarity < 0 || rarity > 4)
                    throw new Exception("Rarity range between 0-4");
            }

            System.out.println("Enter Starting Level: ");
            int fromLevel = reader.nextInt();
            if (!(fromLevel >= 1 && fromLevel <= 200))
                throw new Exception("Starting level out of bounds");
            System.out.println("Enter Current XP: ");

            int currentXP = reader.nextInt();
            if (currentXP > Lvl.combined[rarity][fromLevel])
                throw new Exception("Out of Bounds Level XP");
            System.out.println("Enter Last Level: ");
            int toLevel = reader.nextInt();
            if (!(toLevel > fromLevel && toLevel <= 200))
                throw new Exception("Last level out of bounds");
            System.out.println("\u001b[36mXP Required: " + f.format(Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, currentXP, toLevel, Lvl.Rarity.values()[rarity])));
            System.out.println( "\u001b[36mUltimate Carrot Candies Required: " + (Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, currentXP, toLevel, Lvl.Rarity.values()[rarity]) / 1500000 + 1));
        } catch (Exception e) {
            System.out.println("\u001b[31mError: " + e.getMessage() + ", try again");
        }
    }
}