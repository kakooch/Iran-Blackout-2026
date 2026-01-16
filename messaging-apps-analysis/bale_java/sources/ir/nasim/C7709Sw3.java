package ir.nasim;

/* renamed from: ir.nasim.Sw3, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C7709Sw3 extends AbstractC17424mw3 implements InterfaceC15069ix3 {
    private final C19689qm4 a = new C19689qm4();
    private C16143km4 b;

    /* renamed from: ir.nasim.Sw3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Object obj) {
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

    /* renamed from: ir.nasim.Sw3$b */
    static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ Object e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Object obj) {
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

    /* renamed from: ir.nasim.Sw3$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(InterfaceC15796kB2 interfaceC15796kB2) {
            super(4);
            this.e = interfaceC15796kB2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            if ((i2 & 6) == 0) {
                i2 |= interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2;
            }
            if (!interfaceC22053ub1.o((i2 & 131) != 130, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1010194746, i2, -1, "androidx.compose.foundation.lazy.LazyListIntervalContent.item.<anonymous> (LazyListIntervalContent.kt:59)");
            }
            this.e.q(interfaceC6988Pv3, interfaceC22053ub1, Integer.valueOf(i2 & 14));
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC16978mB2
        public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
            a((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
            return C19938rB7.a;
        }
    }

    public C7709Sw3(UA2 ua2) {
        ua2.invoke(this);
    }

    @Override // ir.nasim.InterfaceC15069ix3
    public void a(int i, UA2 ua2, UA2 ua22, InterfaceC16978mB2 interfaceC16978mB2) {
        j().b(i, new C7475Rw3(ua2, ua22, interfaceC16978mB2));
    }

    @Override // ir.nasim.InterfaceC15069ix3
    public void f(Object obj, Object obj2, InterfaceC15796kB2 interfaceC15796kB2) {
        j().b(1, new C7475Rw3(obj != null ? new a(obj) : null, new b(obj2), AbstractC19242q11.c(-1010194746, true, new c(interfaceC15796kB2))));
    }

    public final AbstractC18977pa3 m() {
        C16143km4 c16143km4 = this.b;
        return c16143km4 != null ? c16143km4 : AbstractC19568qa3.a();
    }

    @Override // ir.nasim.AbstractC17424mw3
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public C19689qm4 j() {
        return this.a;
    }
}
