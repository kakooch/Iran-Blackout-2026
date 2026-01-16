package ir.nasim;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public class OE1 implements InterfaceC16352l76 {
    private final Handler a = AbstractC18913pT2.a(Looper.getMainLooper());

    @Override // ir.nasim.InterfaceC16352l76
    public void a(Runnable runnable) {
        this.a.removeCallbacks(runnable);
    }

    @Override // ir.nasim.InterfaceC16352l76
    public void b(long j, Runnable runnable) {
        this.a.postDelayed(runnable, j);
    }
}
