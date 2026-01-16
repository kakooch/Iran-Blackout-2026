package ir.nasim;

import android.os.Bundle;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* renamed from: ir.nasim.ah8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
final class RunnableC9871ah8 implements Runnable {
    final /* synthetic */ LifecycleCallback a;
    final /* synthetic */ String b;
    final /* synthetic */ FragmentC21550tj8 c;

    RunnableC9871ah8(FragmentC21550tj8 fragmentC21550tj8, LifecycleCallback lifecycleCallback, String str) {
        this.c = fragmentC21550tj8;
        this.a = lifecycleCallback;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bundle bundle;
        FragmentC21550tj8 fragmentC21550tj8 = this.c;
        if (fragmentC21550tj8.b > 0) {
            LifecycleCallback lifecycleCallback = this.a;
            if (fragmentC21550tj8.c != null) {
                bundle = fragmentC21550tj8.c.getBundle(this.b);
            } else {
                bundle = null;
            }
            lifecycleCallback.f(bundle);
        }
        if (this.c.b >= 2) {
            this.a.j();
        }
        if (this.c.b >= 3) {
            this.a.h();
        }
        if (this.c.b >= 4) {
            this.a.k();
        }
        if (this.c.b >= 5) {
            this.a.g();
        }
    }
}
