package ir.aaap.messengercore.utilites;

/* loaded from: classes3.dex */
public interface CoreLog {
    void e(String str, String str2);

    void handleException(Throwable th);

    boolean isDebug();

    void recordFireBaseException(Exception exc);
}
