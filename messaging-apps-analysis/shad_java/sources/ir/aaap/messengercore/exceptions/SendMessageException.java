package ir.aaap.messengercore.exceptions;

/* loaded from: classes3.dex */
public class SendMessageException extends Exception {
    public String errorString;

    public SendMessageException(String str) {
        this.errorString = str;
    }
}
