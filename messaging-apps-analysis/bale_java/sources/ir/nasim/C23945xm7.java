package ir.nasim;

import java.util.List;

/* renamed from: ir.nasim.xm7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C23945xm7 {
    public static final c d = new c(null);
    private static final InterfaceC8230Vb6 e = AbstractC8464Wb6.a(a.e, b.e);
    private final C13245fu a;
    private final long b;
    private final C4301En7 c;

    /* renamed from: ir.nasim.xm7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC8730Xb6 interfaceC8730Xb6, C23945xm7 c23945xm7) {
            return AbstractC10360bX0.g(AbstractC8984Yb6.z(c23945xm7.e(), AbstractC8984Yb6.h(), interfaceC8730Xb6), AbstractC8984Yb6.z(C4301En7.b(c23945xm7.g()), AbstractC8984Yb6.u(C4301En7.b), interfaceC8730Xb6));
        }
    }

    /* renamed from: ir.nasim.xm7$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        public static final b e = new b();

        b() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C23945xm7 invoke(Object obj) {
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
            List list = (List) obj;
            Object obj2 = list.get(0);
            InterfaceC8230Vb6 interfaceC8230Vb6H = AbstractC8984Yb6.h();
            Boolean bool = Boolean.FALSE;
            C4301En7 c4301En7 = null;
            C13245fu c13245fu = ((!AbstractC13042fc3.d(obj2, bool) || (interfaceC8230Vb6H instanceof InterfaceC15798kB4)) && obj2 != null) ? (C13245fu) interfaceC8230Vb6H.b(obj2) : null;
            AbstractC13042fc3.f(c13245fu);
            Object obj3 = list.get(1);
            InterfaceC8230Vb6 interfaceC8230Vb6U = AbstractC8984Yb6.u(C4301En7.b);
            if ((!AbstractC13042fc3.d(obj3, bool) || (interfaceC8230Vb6U instanceof InterfaceC15798kB4)) && obj3 != null) {
                c4301En7 = (C4301En7) interfaceC8230Vb6U.b(obj3);
            }
            AbstractC13042fc3.f(c4301En7);
            return new C23945xm7(c13245fu, c4301En7.r(), (C4301En7) null, 4, (ED1) null);
        }
    }

    /* renamed from: ir.nasim.xm7$c */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C23945xm7(C13245fu c13245fu, long j, C4301En7 c4301En7, ED1 ed1) {
        this(c13245fu, j, c4301En7);
    }

    public static /* synthetic */ C23945xm7 c(C23945xm7 c23945xm7, C13245fu c13245fu, long j, C4301En7 c4301En7, int i, Object obj) {
        if ((i & 1) != 0) {
            c13245fu = c23945xm7.a;
        }
        if ((i & 2) != 0) {
            j = c23945xm7.b;
        }
        if ((i & 4) != 0) {
            c4301En7 = c23945xm7.c;
        }
        return c23945xm7.a(c13245fu, j, c4301En7);
    }

    public static /* synthetic */ C23945xm7 d(C23945xm7 c23945xm7, String str, long j, C4301En7 c4301En7, int i, Object obj) {
        if ((i & 2) != 0) {
            j = c23945xm7.b;
        }
        if ((i & 4) != 0) {
            c4301En7 = c23945xm7.c;
        }
        return c23945xm7.b(str, j, c4301En7);
    }

    public final C23945xm7 a(C13245fu c13245fu, long j, C4301En7 c4301En7) {
        return new C23945xm7(c13245fu, j, c4301En7, (ED1) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final C23945xm7 b(String str, long j, C4301En7 c4301En7) {
        return new C23945xm7(new C13245fu(str, null, 2, 0 == true ? 1 : 0), j, c4301En7, (ED1) null);
    }

    public final C13245fu e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23945xm7)) {
            return false;
        }
        C23945xm7 c23945xm7 = (C23945xm7) obj;
        return C4301En7.g(this.b, c23945xm7.b) && AbstractC13042fc3.d(this.c, c23945xm7.c) && AbstractC13042fc3.d(this.a, c23945xm7.a);
    }

    public final C4301En7 f() {
        return this.c;
    }

    public final long g() {
        return this.b;
    }

    public final String h() {
        return this.a.k();
    }

    public int hashCode() {
        int iHashCode = ((this.a.hashCode() * 31) + C4301En7.o(this.b)) * 31;
        C4301En7 c4301En7 = this.c;
        return iHashCode + (c4301En7 != null ? C4301En7.o(c4301En7.r()) : 0);
    }

    public String toString() {
        return "TextFieldValue(text='" + ((Object) this.a) + "', selection=" + ((Object) C4301En7.q(this.b)) + ", composition=" + this.c + ')';
    }

    public /* synthetic */ C23945xm7(String str, long j, C4301En7 c4301En7, ED1 ed1) {
        this(str, j, c4301En7);
    }

    private C23945xm7(C13245fu c13245fu, long j, C4301En7 c4301En7) {
        this.a = c13245fu;
        this.b = AbstractC4535Fn7.c(j, 0, h().length());
        this.c = c4301En7 != null ? C4301En7.b(AbstractC4535Fn7.c(c4301En7.r(), 0, h().length())) : null;
    }

    public /* synthetic */ C23945xm7(C13245fu c13245fu, long j, C4301En7 c4301En7, int i, ED1 ed1) {
        this(c13245fu, (i & 2) != 0 ? C4301En7.b.a() : j, (i & 4) != 0 ? null : c4301En7, (ED1) null);
    }

    public /* synthetic */ C23945xm7(String str, long j, C4301En7 c4301En7, int i, ED1 ed1) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? C4301En7.b.a() : j, (i & 4) != 0 ? null : c4301En7, (ED1) null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private C23945xm7(String str, long j, C4301En7 c4301En7) {
        this(new C13245fu(str, null, 2, 0 == true ? 1 : 0), j, c4301En7, (ED1) null);
    }
}
