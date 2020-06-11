import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bruh {
    public static void main(String[] args) throws IOException {
        String bruhs = new String(Files.readAllBytes(Paths.get("src/bruhs.txt")));
        BigInteger bigInteger = new BigInteger(bruhs);
        if (args[0].equals("-integerAdditionAmount")) {
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                bigInteger = bigInteger.add(bigInteger);
            }
        }
        System.out.println(bigInteger);
    }
}
