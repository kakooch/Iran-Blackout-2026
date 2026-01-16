package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class Vp8 extends Handler {
    private final Looper a;

    public Vp8(Looper looper) {
        super(looper);
        this.a = Looper.getMainLooper();
    }

    public Vp8(Looper looper, Handler.Callback callback) {
        super(looper, callback);
        this.a = Looper.getMainLooper();
    }
}
