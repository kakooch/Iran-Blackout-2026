package androidx.room;

import ir.nasim.ED1;
import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC14603iB2;
import ir.nasim.InterfaceC22753vm1;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class g implements InterfaceC11938do1.b {
    public static final a c = new a(null);
    private final InterfaceC22753vm1 a;
    private final AtomicInteger b = new AtomicInteger(0);

    public static final class a implements InterfaceC11938do1.c {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public g(InterfaceC22753vm1 interfaceC22753vm1) {
        this.a = interfaceC22753vm1;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC11938do1.b.a.d(this, interfaceC11938do1);
    }

    @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        return InterfaceC11938do1.b.a.b(this, cVar);
    }

    public final void f() {
        this.b.incrementAndGet();
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return InterfaceC11938do1.b.a.a(this, obj, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC11938do1.b
    public InterfaceC11938do1.c getKey() {
        return c;
    }

    public final InterfaceC22753vm1 h() {
        return this.a;
    }

    public final void i() {
        if (this.b.decrementAndGet() < 0) {
            throw new IllegalStateException("Transaction was never started or was already released.");
        }
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return InterfaceC11938do1.b.a.c(this, cVar);
    }
}
