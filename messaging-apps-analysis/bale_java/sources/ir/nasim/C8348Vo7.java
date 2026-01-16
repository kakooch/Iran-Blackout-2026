package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import ir.nasim.InterfaceC6695Oo7;

/* renamed from: ir.nasim.Vo7, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C8348Vo7 implements InterfaceC6695Oo7 {
    private final Object a;
    private final ThreadLocal b;
    private final InterfaceC11938do1.c c;

    public C8348Vo7(Object obj, ThreadLocal threadLocal) {
        this.a = obj;
        this.b = threadLocal;
        this.c = new C8848Xo7(threadLocal);
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC6695Oo7.a.b(this, interfaceC11938do1);
    }

    @Override // ir.nasim.InterfaceC11938do1.b, ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        if (!AbstractC13042fc3.d(getKey(), cVar)) {
            return null;
        }
        AbstractC13042fc3.g(this, "null cannot be cast to non-null type E of kotlinx.coroutines.internal.ThreadLocalElement.get");
        return this;
    }

    @Override // ir.nasim.InterfaceC6695Oo7
    public void d0(InterfaceC11938do1 interfaceC11938do1, Object obj) {
        this.b.set(obj);
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        return InterfaceC6695Oo7.a.a(this, obj, interfaceC14603iB2);
    }

    @Override // ir.nasim.InterfaceC11938do1.b
    public InterfaceC11938do1.c getKey() {
        return this.c;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        return AbstractC13042fc3.d(getKey(), cVar) ? C18712p72.a : this;
    }

    @Override // ir.nasim.InterfaceC6695Oo7
    public Object s0(InterfaceC11938do1 interfaceC11938do1) {
        Object obj = this.b.get();
        this.b.set(this.a);
        return obj;
    }

    public String toString() {
        return "ThreadLocal(value=" + this.a + ", threadLocal = " + this.b + ')';
    }
}
