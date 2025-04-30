package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PayloadUtil {
    public static String getPayload(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
