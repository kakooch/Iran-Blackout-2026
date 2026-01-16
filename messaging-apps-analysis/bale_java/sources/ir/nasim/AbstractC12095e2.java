package ir.nasim;

import ir.nasim.InterfaceC6052Ly7;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Set;

/* renamed from: ir.nasim.e2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC12095e2 implements InterfaceC6052Ly7 {
    private int a;
    private boolean b;
    private ArrayDeque c;
    private Set d;

    /* renamed from: ir.nasim.e2$a */
    public enum a {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* renamed from: ir.nasim.e2$b */
    public static abstract class b {

        /* renamed from: ir.nasim.e2$b$a */
        public static abstract class a extends b {
            public a() {
                super(null);
            }
        }

        /* renamed from: ir.nasim.e2$b$b, reason: collision with other inner class name */
        public static final class C1044b extends b {
            public static final C1044b a = new C1044b();

            private C1044b() {
                super(null);
            }

            @Override // ir.nasim.AbstractC12095e2.b
            public ZC6 a(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3) {
                AbstractC13042fc3.i(abstractC12095e2, "context");
                AbstractC13042fc3.i(interfaceC5050Hr3, "type");
                return abstractC12095e2.C(interfaceC5050Hr3);
            }
        }

        /* renamed from: ir.nasim.e2$b$c */
        public static final class c extends b {
            public static final c a = new c();

            private c() {
                super(null);
            }

            @Override // ir.nasim.AbstractC12095e2.b
            public /* bridge */ /* synthetic */ ZC6 a(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3) {
                return (ZC6) b(abstractC12095e2, interfaceC5050Hr3);
            }

            public Void b(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3) {
                AbstractC13042fc3.i(abstractC12095e2, "context");
                AbstractC13042fc3.i(interfaceC5050Hr3, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* renamed from: ir.nasim.e2$b$d */
        public static final class d extends b {
            public static final d a = new d();

            private d() {
                super(null);
            }

            @Override // ir.nasim.AbstractC12095e2.b
            public ZC6 a(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3) {
                AbstractC13042fc3.i(abstractC12095e2, "context");
                AbstractC13042fc3.i(interfaceC5050Hr3, "type");
                return abstractC12095e2.W(interfaceC5050Hr3);
            }
        }

        private b() {
        }

        public abstract ZC6 a(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3);

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    public static /* synthetic */ Boolean l0(AbstractC12095e2 abstractC12095e2, InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return abstractC12095e2.k0(interfaceC5050Hr3, interfaceC5050Hr32, z);
    }

    public boolean A0(ZC6 zc6) {
        return InterfaceC6052Ly7.a.h(this, zc6);
    }

    public boolean B0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.j(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 C(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.k(this, interfaceC5050Hr3);
    }

    public abstract boolean C0();

    public abstract InterfaceC5050Hr3 D0(InterfaceC5050Hr3 interfaceC5050Hr3);

    public abstract InterfaceC5050Hr3 E0(InterfaceC5050Hr3 interfaceC5050Hr3);

    public abstract b F0(ZC6 zc6);

    @Override // ir.nasim.InterfaceC6052Ly7
    public int R(InterfaceC9204Yx7 interfaceC9204Yx7) {
        return InterfaceC6052Ly7.a.l(this, interfaceC9204Yx7);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public ZC6 W(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.n(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public boolean f(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.i(this, interfaceC5050Hr3);
    }

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC14475hy7 g(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.m(this, interfaceC5050Hr3);
    }

    public Boolean k0(InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32, boolean z) {
        AbstractC13042fc3.i(interfaceC5050Hr3, "subType");
        AbstractC13042fc3.i(interfaceC5050Hr32, "superType");
        return null;
    }

    public final void m0() {
        ArrayDeque arrayDeque = this.c;
        AbstractC13042fc3.f(arrayDeque);
        arrayDeque.clear();
        Set set = this.d;
        AbstractC13042fc3.f(set);
        set.clear();
        this.b = false;
    }

    public boolean n0(InterfaceC5050Hr3 interfaceC5050Hr3, InterfaceC5050Hr3 interfaceC5050Hr32) {
        AbstractC13042fc3.i(interfaceC5050Hr3, "subType");
        AbstractC13042fc3.i(interfaceC5050Hr32, "superType");
        return true;
    }

    public List o0(ZC6 zc6, InterfaceC14475hy7 interfaceC14475hy7) {
        return InterfaceC6052Ly7.a.a(this, zc6, interfaceC14475hy7);
    }

    public InterfaceC9438Zx7 p0(ZC6 zc6, int i) {
        return InterfaceC6052Ly7.a.c(this, zc6, i);
    }

    public a q0(ZC6 zc6, InterfaceC19385qG0 interfaceC19385qG0) {
        AbstractC13042fc3.i(zc6, "subType");
        AbstractC13042fc3.i(interfaceC19385qG0, "superType");
        return a.CHECK_SUBTYPE_AND_LOWER;
    }

    public final ArrayDeque r0() {
        return this.c;
    }

    public final Set s0() {
        return this.d;
    }

    public boolean t0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.d(this, interfaceC5050Hr3);
    }

    public final void u0() {
        this.b = true;
        if (this.c == null) {
            this.c = new ArrayDeque(4);
        }
        if (this.d == null) {
            this.d = DE6.c.a();
        }
    }

    public abstract boolean v0(InterfaceC5050Hr3 interfaceC5050Hr3);

    @Override // ir.nasim.InterfaceC6052Ly7
    public InterfaceC9438Zx7 w(InterfaceC9204Yx7 interfaceC9204Yx7, int i) {
        return InterfaceC6052Ly7.a.b(this, interfaceC9204Yx7, i);
    }

    public boolean w0(ZC6 zc6) {
        return InterfaceC6052Ly7.a.e(this, zc6);
    }

    public boolean x0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.f(this, interfaceC5050Hr3);
    }

    public boolean y0(InterfaceC5050Hr3 interfaceC5050Hr3) {
        return InterfaceC6052Ly7.a.g(this, interfaceC5050Hr3);
    }

    public abstract boolean z0();
}
