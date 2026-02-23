public class Demo01 {
    public static void main(String[] args) {

        System.out.println("=== Student Onboarding ===");

        FakeDb db = new FakeDb();

        OnboardingService service = new OnboardingService(
                db,
                new StudentInputParser(),
                new StudentValidator(),
                new OnboardingPrinter()
        );

        String raw =
            "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";

        service.registerFromRawInput(raw);
    }
}