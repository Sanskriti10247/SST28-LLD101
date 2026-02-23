import java.util.*;

public class TextTable {

    public static void print(List<StudentRecord> rows) {
        System.out.println("| ID             | NAME | PROGRAM |");
        for (StudentRecord r : rows) {
            System.out.printf(
                "| %-15s | %-4s | %-7s |%n",
                r.id, r.name, r.program
            );
        }
    }
}