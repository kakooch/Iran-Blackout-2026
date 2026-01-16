package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* renamed from: ir.nasim.Jp, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC5496Jp implements InterfaceC12905fN3 {
    public static volatile Handler a = new Handler(Looper.getMainLooper());

    @Override // ir.nasim.InterfaceC12905fN3
    public boolean a() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override // ir.nasim.InterfaceC12905fN3
    public void b(Runnable runnable, long j) {
        a.postDelayed(runnable, j);
    }

    @Override // ir.nasim.InterfaceC12905fN3
    public boolean c() {
        return false;
    }

    @Override // ir.nasim.InterfaceC12905fN3
    public void d(Runnable runnable) {
        a.post(runnable);
    }

    @Override // ir.nasim.InterfaceC12905fN3
    public void e(Runnable runnable) {
        a.removeCallbacks(runnable);
    }
}
