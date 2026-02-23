import java.util.*;

class StudentInputParser {

    Map<String, String> parse(String raw) {
        Map<String, String> data = new LinkedHashMap<>();

        String[] parts = raw.split(";");
        for (String p : parts) {
            String[] kv = p.split("=", 2);
            if (kv.length == 2) {
                data.put(kv[0].trim(), kv[1].trim());
            }
        }
        return data;
    }
}