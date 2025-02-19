package Utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class RandomString {
    public static String randomString(int length) {
        return ThreadLocalRandom.current()
                .ints(length, 97, 123) // Генерируем символы по ASCII кодам
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
