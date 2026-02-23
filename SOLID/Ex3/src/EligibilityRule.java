import java.util.*;

interface EligibilityRule {
    boolean isSatisfied(StudentProfile s);
    String reason();
}