package ir.nasim;

import java.util.concurrent.atomic.AtomicReference;

/* renamed from: ir.nasim.Hm4, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C5006Hm4 {
    private static C5006Hm4 b = new C5006Hm4();
    private final AtomicReference a = new AtomicReference(C3385Aq5.c().c());

    C5006Hm4() {
    }

    public static C5006Hm4 c() {
        return b;
    }

    public Class a(Class cls) {
        return ((C3385Aq5) this.a.get()).e(cls);
    }

    public Object b(AbstractC14981io3 abstractC14981io3, Class cls) {
        return ((C3385Aq5) this.a.get()).f(abstractC14981io3, cls);
    }

    public synchronized void d(AbstractC23983xq5 abstractC23983xq5) {
        this.a.set(C3385Aq5.d((C3385Aq5) this.a.get()).d(abstractC23983xq5).c());
    }

    public synchronized void e(InterfaceC5277Iq5 interfaceC5277Iq5) {
        this.a.set(C3385Aq5.d((C3385Aq5) this.a.get()).e(interfaceC5277Iq5).c());
    }

    public Object f(C4092Dq5 c4092Dq5, Class cls) {
        return ((C3385Aq5) this.a.get()).g(c4092Dq5, cls);
    }
}
