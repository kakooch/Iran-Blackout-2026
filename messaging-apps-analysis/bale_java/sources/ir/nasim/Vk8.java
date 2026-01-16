package ir.nasim;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* loaded from: classes3.dex */
final class Vk8 implements Runnable {
    final /* synthetic */ LifecycleCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ Tl8 c;

    Vk8(Tl8 tl8, LifecycleCallback lifecycleCallback, String str) {
        this.c = tl8;
        this.a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        Tl8 tl8 = this.c;
        if (tl8.X0 > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            if (tl8.Y0 != null) {
                bundle = tl8.Y0.getBundle(this.b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.c.X0 >= 2) {
            this.a.j();
        }
        if (this.c.X0 >= 3) {
            this.a.h();
        }
        if (this.c.X0 >= 4) {
            this.a.k();
        }
        if (this.c.X0 >= 5) {
            this.a.g();
        }
    }
}
