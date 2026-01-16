package ir.nasim;

/* renamed from: ir.nasim.kv3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C16232kv3 extends AbstractC17424mw3 implements InterfaceC4369Ev3 {
    private static final b e = new b(null);
    public static final int f = 8;
    private static final InterfaceC14603iB2 g = a.e;
    private final C5788Kv3 a = new C5788Kv3(this);
    private final C19689qm4 b = new C19689qm4();
    private boolean c;
    private C16143km4 d;

    /* renamed from: ir.nasim.kv3$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        public static final a e = new a();

        a() {
            super(2);
        }

        public final long a(InterfaceC20387rv3 interfaceC20387rv3, int i) {
            return AbstractC5554Jv3.a(1);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return C10870cL2.a(a((InterfaceC20387rv3) obj, ((Number) obj2).intValue()));
        }
    }

    /* renamed from: ir.nasim.kv3$b */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.kv3$c */
    static final class c extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Object obj) {
            super(1);
            this.e = obj;
        }

        public final Object a(int i) {
            return this.e;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.kv3$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(UA2 ua2) {
            super(2);
            this.e = ua2;
        }

        public final long a(InterfaceC20387rv3 interfaceC20387rv3, int i) {
            return ((C10870cL2) this.e.invoke(interfaceC20387rv3)).g();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return C10870cL2.a(a((InterfaceC20387rv3) obj, ((Number) obj2).intValue()));
        }
    }

    /* renamed from: ir.nasim.kv3$e */
    static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Object obj) {
            super(1);
            this.e = obj;
        }

        public final Object a(int i) {
            return this.e;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    /* renamed from: ir.nasim.kv3$f */
    static final class f extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(InterfaceC15796kB2 interfaceC15796kB2) {
            super(4);
            this.e = interfaceC15796kB2;
        }

        public final void a(InterfaceC19187pv3 interfaceC19187pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            if ((i2 & 6) == 0) {
                i2 |= interfaceC22053ub1.V(interfaceC19187pv3) ? 4 : 2;
            }
            if (!interfaceC22053ub1.o((i2 & 131) != 130, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-34608120, i2, -1, "androidx.compose.foundation.lazy.grid.LazyGridIntervalContent.item.<anonymous> (LazyGridIntervalContent.kt:55)");
            }
            this.e.q(interfaceC19187pv3, interfaceC22053ub1, Integer.valueOf(i2 & 14));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC19187pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public C16232kv3(UA2 ua2) {
        ua2.invoke(this);
    }

    @Override // ir.nasim.InterfaceC4369Ev3
    public void c(Object obj, UA2 ua2, Object obj2, InterfaceC15796kB2 interfaceC15796kB2) {
        j().b(1, new C15641jv3(obj != null ? new c(obj) : null, ua2 != null ? new d(ua2) : g, new e(obj2), AbstractC19242q11.c(-34608120, true, new f(interfaceC15796kB2))));
        if (ua2 != null) {
            this.c = true;
        }
    }

    @Override // ir.nasim.InterfaceC4369Ev3
    public void e(int i, UA2 ua2, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2) {
        j().b(i, new C15641jv3(ua2, interfaceC14603iB2 == null ? g : interfaceC14603iB2, ua22, interfaceC16978mB2));
        if (interfaceC14603iB2 != null) {
            this.c = true;
        }
    }

    public final boolean m() {
        return this.c;
    }

    public final AbstractC18977pa3 n() {
        C16143km4 c16143km4 = this.d;
        return c16143km4 != null ? c16143km4 : AbstractC19568qa3.a();
    }

    @Override // ir.nasim.AbstractC17424mw3
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public C19689qm4 j() {
        return this.b;
    }

    public final C5788Kv3 p() {
        return this.a;
    }
}
