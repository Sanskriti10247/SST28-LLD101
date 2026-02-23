public class NotificationResult {
    public final boolean isSuccess;
    public final String errorMessage;

    private NotificationResult(boolean isSuccess, String errorMessage) {
        this.isSuccess = isSuccess;
        this.errorMessage = errorMessage;
    }

    public static NotificationResult success() {
        return new NotificationResult(true, null);
    }

    public static NotificationResult failure(String errorMessage) {
        return new NotificationResult(false, errorMessage);
    }
}