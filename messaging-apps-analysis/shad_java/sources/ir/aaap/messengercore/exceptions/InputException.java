package ir.aaap.messengercore.exceptions;

/* loaded from: classes3.dex */
public class InputException extends Exception {

    public enum ErrorEnum {
        IsInvalidInput
    }

    public InputException() {
        ErrorEnum errorEnum = ErrorEnum.IsInvalidInput;
    }

    public InputException(ErrorEnum errorEnum) {
    }
}
