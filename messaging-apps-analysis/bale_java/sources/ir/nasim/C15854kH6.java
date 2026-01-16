package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.kH6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C15854kH6 {
    private final AtomicReference a = new AtomicReference(AbstractC16445lH6.a);
    private final Object b = new Object();
    private Object c;

    public final Object a() {
        long jA = AbstractC16176kp7.a();
        return jA == AbstractC15585jp7.a() ? this.c : ((C9357Zo7) this.a.get()).b(jA);
    }

    public final void b(Object obj) {
        long jA = AbstractC16176kp7.a();
        if (jA == AbstractC15585jp7.a()) {
            this.c = obj;
            return;
        }
        synchronized (this.b) {
            C9357Zo7 c9357Zo7 = (C9357Zo7) this.a.get();
            if (c9357Zo7.d(jA, obj)) {
                return;
            }
            this.a.set(c9357Zo7.c(jA, obj));
            C19938rB7 c19938rB7 = C19938rB7.a;
        }
    }
}
