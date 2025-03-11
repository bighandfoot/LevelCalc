import java.text.DecimalFormat;
import java.util.Scanner;

public class MainLVL {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("##,###,###");
        System.out.println("Enter Starting Level: ");
        int fromLevel = reader.nextInt();
        System.out.println("Enter Last Level: ");
        int toLevel = reader.nextInt();

        if (toLevel > 100) {
            System.out.println("Golden Dragon XP: " + f.format(Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, toLevel, Lvl.Rarity.values()[4])));
        } else {

            System.out.println("Enter Rarity: ");
            for (int i = 0; i < Lvl.Rarity.values().length; i++) {
                System.out.println(i + ": " + Lvl.Rarity.values()[i].toString());
            }
            int rarity = reader.nextInt();

            System.out.println(f.format(Lvl.calcExpDiffBetweenLvlsByRarity(fromLevel, toLevel, Lvl.Rarity.values()[rarity])));
        }
    }
}
