package ir.aaap.messengercore;

/* loaded from: classes3.dex */
public interface LoadListener<T> {
    void onDidLoad(T t);

    void onError(Exception exc);
}
