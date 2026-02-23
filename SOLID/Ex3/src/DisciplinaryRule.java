class DisciplinaryRule implements EligibilityRule {

    public boolean isSatisfied(StudentProfile s) {
        return s.disciplinaryFlag == LegacyFlags.NONE;
    }

    public String reason() {
        return "disciplinary flag present";
    }
}