package mission.ui.exception;

public enum InputError {
    INVALID_FORMAT("입력 형식이 올바르지 않습니다. 예시: [정어리-3],[고등어-2]");

    private final String message;

    InputError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
