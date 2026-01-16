package ir.eitaa.tgnet;

/* loaded from: classes.dex */
public interface ResultCallback<T> {

    /* renamed from: ir.eitaa.tgnet.ResultCallback$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onError(ResultCallback resultCallback, TLRPC$TL_error tLRPC$TL_error) {
        }

        public static void $default$onError(ResultCallback resultCallback, Throwable th) {
        }
    }

    void onComplete(T result);

    void onError(TLRPC$TL_error error);
}
