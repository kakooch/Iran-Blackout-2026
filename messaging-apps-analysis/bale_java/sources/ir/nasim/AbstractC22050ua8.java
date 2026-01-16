package ir.nasim;

/* renamed from: ir.nasim.ua8, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC22050ua8 {
    private static final C6774Ox5 a = AbstractC20829sg4.a(a.e);

    /* renamed from: ir.nasim.ua8$a */
    static final class a extends AbstractC8614Ws3 implements SA2 {
        public static final a e = new a();

        a() {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final A98 invoke() {
            return AbstractC21393ta8.a(0, 0, 0, 0);
        }
    }

    /* renamed from: ir.nasim.ua8$b */
    public static final class b extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(UA2 ua2) {
            super(1);
            this.e = ua2;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ua8$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ UA2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(UA2 ua2) {
            super(3);
            this.e = ua2;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1608161351);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1608161351, i, -1, "androidx.compose.foundation.layout.onConsumedWindowInsetsChanged.<anonymous> (WindowInsetsPadding.kt:141)");
            }
            boolean zV = interfaceC22053ub1.V(this.e);
            UA2 ua2 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C22673ve1(ua2);
                interfaceC22053ub1.s(objB);
            }
            C22673ve1 c22673ve1 = (C22673ve1) objB;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return c22673ve1;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    /* renamed from: ir.nasim.ua8$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ A98 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(A98 a98) {
            super(1);
            this.e = a98;
        }

        public final void a(T93 t93) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            AbstractC18350oW3.a(obj);
            a(null);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.ua8$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ A98 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(A98 a98) {
            super(3);
            this.e = a98;
        }

        public final androidx.compose.ui.e a(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            interfaceC22053ub1.W(-1415685722);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1415685722, i, -1, "androidx.compose.foundation.layout.windowInsetsPadding.<anonymous> (WindowInsetsPadding.kt:79)");
            }
            boolean zV = interfaceC22053ub1.V(this.e);
            A98 a98 = this.e;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new N93(a98);
                interfaceC22053ub1.s(objB);
            }
            N93 n93 = (N93) objB;
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
            interfaceC22053ub1.Q();
            return n93;
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return a((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
        }
    }

    public static final C6774Ox5 a() {
        return a;
    }

    public static final androidx.compose.ui.e b(androidx.compose.ui.e eVar, UA2 ua2) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new b(ua2) : Q93.a(), new c(ua2));
    }

    public static final androidx.compose.ui.e c(androidx.compose.ui.e eVar, A98 a98) {
        return androidx.compose.ui.c.b(eVar, Q93.b() ? new d(a98) : Q93.a(), new e(a98));
    }
}
