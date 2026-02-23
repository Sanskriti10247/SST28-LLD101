import java.util.*;

class OnboardingPrinter {

    void printInput(String raw) {
        System.out.println("INPUT: " + raw);
    }

    void printErrors(List<String> errors) {
        System.out.println("ERROR: cannot register");
        for (String e : errors) {
            System.out.println("- " + e);
        }
    }

    void printSuccess(StudentRecord record, int total) {
        System.out.println("OK: created student " + record.id);
        System.out.println("Saved. Total students: " + total);
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }

    void printDbDump(FakeDb db) {
        System.out.println("\n-- DB DUMP --");
        TextTable.print(db.all());
    }
}