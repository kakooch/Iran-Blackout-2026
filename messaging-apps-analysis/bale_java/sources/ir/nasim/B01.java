package ir.nasim;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes8.dex */
public class B01 {
    private static final AtomicIntegerFieldUpdater b = AtomicIntegerFieldUpdater.newUpdater(B01.class, "_handled");
    private volatile int _handled;
    public final Throwable a;

    public B01(Throwable th, boolean z) {
        this.a = th;
        this._handled = z ? 1 : 0;
    }

    public final boolean a() {
        return b.get(this) != 0;
    }

    public final boolean b() {
        return b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return YA1.a(this) + '[' + this.a + ']';
    }

    public /* synthetic */ B01(Throwable th, boolean z, int i, ED1 ed1) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
