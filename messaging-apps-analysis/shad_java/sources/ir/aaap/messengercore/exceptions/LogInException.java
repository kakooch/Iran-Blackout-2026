package ir.aaap.messengercore.exceptions;

/* loaded from: classes3.dex */
public class LogInException extends Exception {
    public ErrorEnum errorMessage;

    public enum ErrorEnum {
        phoneIsNotCorrect,
        nullInputs,
        signInFailed,
        CodeIsUsed,
        CodeIsExpired,
        CodeIsInvalid,
        AuthNull
    }

    public LogInException(ErrorEnum errorEnum, String str) {
        this.errorMessage = errorEnum;
    }

    public LogInException(ErrorEnum errorEnum) {
        this.errorMessage = errorEnum;
    }
}
