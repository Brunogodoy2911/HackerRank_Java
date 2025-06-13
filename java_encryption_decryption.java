import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'decryptMessage' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING encryptedMessage as parameter.
     */

    public static String decryptMessage(String encryptedMessage) {

        String regex = "\\s+";

        String[] encryptedWords = encryptedMessage.split(regex);

        List<String> wordsInCorrectOrder = new ArrayList<>(Arrays.asList(encryptedWords));
        Collections.reverse(wordsInCorrectOrder);

        List<String> decompressedWords = new ArrayList<>();

        for (String compressedWord : wordsInCorrectOrder) {

            StringBuilder decompressedWordBuilder = new StringBuilder();

            for (int i = 0; i < compressedWord.length(); i++) {
                char currentCharacter = compressedWord.charAt(i);

                if ((i + 1 < compressedWord.length()) && Character.isDigit(compressedWord.charAt(i + 1))) {
                    int repetitions = Character.getNumericValue(compressedWord.charAt(i + 1));
                    for (int j = 0; j < repetitions; j++) {
                        decompressedWordBuilder.append(currentCharacter);
                    }
                    i++;
                } else {
                    decompressedWordBuilder.append(currentCharacter);
                }
            }
            decompressedWords.add(decompressedWordBuilder.toString());
        }

        return String.join(regex, decompressedWords);
    }

}

public class java_encryption_decryption {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String encryptedMessage = bufferedReader.readLine();

        String result = Result.decryptMessage(encryptedMessage);

        System.out.println("Resultado:");
        System.out.println(result);

        bufferedReader.close();

    }
}
