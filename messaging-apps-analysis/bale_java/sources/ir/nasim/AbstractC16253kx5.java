package ir.nasim;

import ir.nasim.C6526Nw5;

/* renamed from: ir.nasim.kx5, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public abstract class AbstractC16253kx5 {
    private final InterfaceC6692Oo4 a;
    private final C7029Py7 b;
    private final JH6 c;

    /* renamed from: ir.nasim.kx5$a */
    public static final class a extends AbstractC16253kx5 {
        private final C6526Nw5 d;
        private final a e;
        private final C24948zU0 f;
        private final C6526Nw5.c g;
        private final boolean h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(C6526Nw5 c6526Nw5, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, JH6 jh6, a aVar) {
            super(interfaceC6692Oo4, c7029Py7, jh6, null);
            AbstractC13042fc3.i(c6526Nw5, "classProto");
            AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
            AbstractC13042fc3.i(c7029Py7, "typeTable");
            this.d = c6526Nw5;
            this.e = aVar;
            this.f = AbstractC7170Qo4.a(interfaceC6692Oo4, c6526Nw5.s0());
            C6526Nw5.c cVar = (C6526Nw5.c) AbstractC5031Hp2.e.d(c6526Nw5.r0());
            this.g = cVar == null ? C6526Nw5.c.CLASS : cVar;
            Boolean boolD = AbstractC5031Hp2.f.d(c6526Nw5.r0());
            AbstractC13042fc3.h(boolD, "IS_INNER.get(classProto.flags)");
            this.h = boolD.booleanValue();
        }

        @Override // ir.nasim.AbstractC16253kx5
        public C9424Zw2 a() {
            C9424Zw2 c9424Zw2B = this.f.b();
            AbstractC13042fc3.h(c9424Zw2B, "classId.asSingleFqName()");
            return c9424Zw2B;
        }

        public final C24948zU0 e() {
            return this.f;
        }

        public final C6526Nw5 f() {
            return this.d;
        }

        public final C6526Nw5.c g() {
            return this.g;
        }

        public final a h() {
            return this.e;
        }

        public final boolean i() {
            return this.h;
        }
    }

    /* renamed from: ir.nasim.kx5$b */
    public static final class b extends AbstractC16253kx5 {
        private final C9424Zw2 d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C9424Zw2 c9424Zw2, InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, JH6 jh6) {
            super(interfaceC6692Oo4, c7029Py7, jh6, null);
            AbstractC13042fc3.i(c9424Zw2, "fqName");
            AbstractC13042fc3.i(interfaceC6692Oo4, "nameResolver");
            AbstractC13042fc3.i(c7029Py7, "typeTable");
            this.d = c9424Zw2;
        }

        @Override // ir.nasim.AbstractC16253kx5
        public C9424Zw2 a() {
            return this.d;
        }
    }

    public /* synthetic */ AbstractC16253kx5(InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, JH6 jh6, ED1 ed1) {
        this(interfaceC6692Oo4, c7029Py7, jh6);
    }

    public abstract C9424Zw2 a();

    public final InterfaceC6692Oo4 b() {
        return this.a;
    }

    public final JH6 c() {
        return this.c;
    }

    public final C7029Py7 d() {
        return this.b;
    }

    public String toString() {
        return ((Object) getClass().getSimpleName()) + ": " + a();
    }

    private AbstractC16253kx5(InterfaceC6692Oo4 interfaceC6692Oo4, C7029Py7 c7029Py7, JH6 jh6) {
        this.a = interfaceC6692Oo4;
        this.b = c7029Py7;
        this.c = jh6;
    }
}
