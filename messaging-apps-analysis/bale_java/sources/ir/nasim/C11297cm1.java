package ir.nasim;

/* renamed from: ir.nasim.cm1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C11297cm1 {
    private final C14063hH6 a = AbstractC10222bH6.f();

    /* renamed from: ir.nasim.cm1$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C6896Pl1 f;
        final /* synthetic */ int g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C6896Pl1 c6896Pl1, int i) {
            super(2);
            this.f = c6896Pl1;
            this.g = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            C11297cm1.this.a(this.f, interfaceC22053ub1, QJ5.a(this.g | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cm1$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ InterfaceC15796kB2 h;
        final /* synthetic */ SA2 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14603iB2 interfaceC14603iB2, boolean z, androidx.compose.ui.e eVar, InterfaceC15796kB2 interfaceC15796kB2, SA2 sa2) {
            super(3);
            this.e = interfaceC14603iB2;
            this.f = z;
            this.g = eVar;
            this.h = interfaceC15796kB2;
            this.i = sa2;
        }

        public final void a(C6896Pl1 c6896Pl1, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1.V(c6896Pl1) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(262103052, i2, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.item.<anonymous> (ContextMenuUi.android.kt:282)");
            }
            String str = (String) this.e.invoke(interfaceC22053ub1, 0);
            if (!(!AbstractC20762sZ6.n0(str))) {
                P73.c("Label must not be blank");
            }
            AbstractC13758gm1.b(str, this.f, c6896Pl1, this.g, this.h, this.i, interfaceC22053ub1, (i2 << 6) & 896, 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((C6896Pl1) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static /* synthetic */ void d(C11297cm1 c11297cm1, InterfaceC14603iB2 interfaceC14603iB2, androidx.compose.ui.e eVar, boolean z, InterfaceC15796kB2 interfaceC15796kB2, SA2 sa2, int i, Object obj) {
        if ((i & 2) != 0) {
            eVar = androidx.compose.ui.e.a;
        }
        androidx.compose.ui.e eVar2 = eVar;
        if ((i & 4) != 0) {
            z = true;
        }
        boolean z2 = z;
        if ((i & 8) != 0) {
            interfaceC15796kB2 = null;
        }
        c11297cm1.c(interfaceC14603iB2, eVar2, z2, interfaceC15796kB2, sa2);
    }

    public final void a(C6896Pl1 c6896Pl1, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1320309496);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.V(c6896Pl1) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(this) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i2 & 19) != 18, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1320309496, i2, -1, "androidx.compose.foundation.contextmenu.ContextMenuScope.Content (ContextMenuUi.android.kt:240)");
            }
            C14063hH6 c14063hH6 = this.a;
            int size = c14063hH6.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((InterfaceC15796kB2) c14063hH6.get(i3)).q(c6896Pl1, interfaceC22053ub1J, Integer.valueOf(i2 & 14));
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new a(c6896Pl1, i));
        }
    }

    public final void b() {
        this.a.clear();
    }

    public final void c(InterfaceC14603iB2 interfaceC14603iB2, androidx.compose.ui.e eVar, boolean z, InterfaceC15796kB2 interfaceC15796kB2, SA2 sa2) {
        this.a.add(AbstractC19242q11.c(262103052, true, new b(interfaceC14603iB2, z, eVar, interfaceC15796kB2, sa2)));
    }
}
