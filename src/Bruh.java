import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Bruh {
    public static void main(String[] args) throws IOException {
        String bruhs = new String(Files.readAllBytes(Paths.get("src/bruhs.txt")));
        BigInteger bruhAmount = new BigInteger(bruhs);
        BigInteger stopAt = bruhAmount;
        if (!(args.length == 0)) {
            if (args[0].equals("-integerAdditionAmount")) {
                for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                    bruhAmount = bruhAmount.add(bruhAmount);
                }
            }
            if (args[0].equals("-stopAt")) {
                stopAt = new BigInteger(args[1]);
            }
        }
        for (BigInteger i = BigInteger.valueOf(0); i.compareTo(stopAt) < 0; i = i.add(BigInteger.valueOf(1))) {
            System.out.print("bruh ");
        }
    }
}
