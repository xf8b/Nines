import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bruh {
    public static void main(String[] args) throws IOException {
        String bruhs = new String(Files.readAllBytes(Paths.get("src/bruhs.txt")));
        BigInteger bruhAmount = new BigInteger(bruhs);
        BigInteger stopAt = bruhAmount;
        if (!(args.length == 0)) {
            if (args[0].equals("-multiplyAmountBy")) {
                bruhAmount = bruhAmount.multiply(new BigInteger(args[1]));
                stopAt = bruhAmount.multiply(new BigInteger(args[1]));
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
