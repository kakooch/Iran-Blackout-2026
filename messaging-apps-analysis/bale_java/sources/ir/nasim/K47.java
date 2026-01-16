package ir.nasim;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public class K47 implements NV0 {
    protected K47() {
    }

    @Override // ir.nasim.NV0
    public InterfaceC23757xT2 a(Looper looper, Handler.Callback callback) {
        return new N47(new Handler(looper, callback));
    }

    @Override // ir.nasim.NV0
    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    @Override // ir.nasim.NV0
    public long uptimeMillis() {
        return SystemClock.uptimeMillis();
    }

    @Override // ir.nasim.NV0
    public void b() {
    }
}
