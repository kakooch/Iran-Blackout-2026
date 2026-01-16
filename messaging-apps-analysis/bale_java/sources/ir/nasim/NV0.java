package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public interface NV0 {
    public static final NV0 a = new K47();

    InterfaceC23757xT2 a(Looper looper, Handler.Callback callback);

    void b();

    long elapsedRealtime();

    long uptimeMillis();
}
