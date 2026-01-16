package ir.nasim;

import ir.nasim.InterfaceC11938do1;
import java.io.Serializable;

/* renamed from: ir.nasim.dZ0, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C11758dZ0 implements InterfaceC11938do1, Serializable {
    private final InterfaceC11938do1 a;
    private final InterfaceC11938do1.b b;

    /* renamed from: ir.nasim.dZ0$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String str, InterfaceC11938do1.b bVar) {
            AbstractC13042fc3.i(str, "acc");
            AbstractC13042fc3.i(bVar, "element");
            if (str.length() == 0) {
                return bVar.toString();
            }
            return str + ", " + bVar;
        }
    }

    public C11758dZ0(InterfaceC11938do1 interfaceC11938do1, InterfaceC11938do1.b bVar) {
        AbstractC13042fc3.i(interfaceC11938do1, "left");
        AbstractC13042fc3.i(bVar, "element");
        this.a = interfaceC11938do1;
        this.b = bVar;
    }

    private final boolean f(InterfaceC11938do1.b bVar) {
        return AbstractC13042fc3.d(a(bVar.getKey()), bVar);
    }

    private final boolean j(C11758dZ0 c11758dZ0) {
        while (f(c11758dZ0.b)) {
            InterfaceC11938do1 interfaceC11938do1 = c11758dZ0.a;
            if (!(interfaceC11938do1 instanceof C11758dZ0)) {
                AbstractC13042fc3.g(interfaceC11938do1, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return f((InterfaceC11938do1.b) interfaceC11938do1);
            }
            c11758dZ0 = (C11758dZ0) interfaceC11938do1;
        }
        return false;
    }

    private final int r() {
        int i = 2;
        C11758dZ0 c11758dZ0 = this;
        while (true) {
            InterfaceC11938do1 interfaceC11938do1 = c11758dZ0.a;
            c11758dZ0 = interfaceC11938do1 instanceof C11758dZ0 ? (C11758dZ0) interfaceC11938do1 : null;
            if (c11758dZ0 == null) {
                return i;
            }
            i++;
        }
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 X(InterfaceC11938do1 interfaceC11938do1) {
        return InterfaceC11938do1.a.a(this, interfaceC11938do1);
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1.b a(InterfaceC11938do1.c cVar) {
        AbstractC13042fc3.i(cVar, "key");
        C11758dZ0 c11758dZ0 = this;
        while (true) {
            InterfaceC11938do1.b bVarA = c11758dZ0.b.a(cVar);
            if (bVarA != null) {
                return bVarA;
            }
            InterfaceC11938do1 interfaceC11938do1 = c11758dZ0.a;
            if (!(interfaceC11938do1 instanceof C11758dZ0)) {
                return interfaceC11938do1.a(cVar);
            }
            c11758dZ0 = (C11758dZ0) interfaceC11938do1;
        }
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof C11758dZ0) {
                C11758dZ0 c11758dZ0 = (C11758dZ0) obj;
                if (c11758dZ0.r() != r() || !c11758dZ0.j(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // ir.nasim.InterfaceC11938do1
    public Object f0(Object obj, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(interfaceC14603iB2, "operation");
        return interfaceC14603iB2.invoke(this.a.f0(obj, interfaceC14603iB2), this.b);
    }

    public int hashCode() {
        return this.a.hashCode() + this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC11938do1
    public InterfaceC11938do1 l(InterfaceC11938do1.c cVar) {
        AbstractC13042fc3.i(cVar, "key");
        if (this.b.a(cVar) != null) {
            return this.a;
        }
        InterfaceC11938do1 interfaceC11938do1L = this.a.l(cVar);
        return interfaceC11938do1L == this.a ? this : interfaceC11938do1L == C18712p72.a ? this.b : new C11758dZ0(interfaceC11938do1L, this.b);
    }

    public String toString() {
        return '[' + ((String) f0("", a.e)) + ']';
    }
}
