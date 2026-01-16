package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import ir.nasim.InterfaceC16030kb1;

/* loaded from: classes2.dex */
public abstract class SZ6 {
    private static final a a = new a();

    public static final class a {
        a() {
        }

        public String toString() {
            return "ReusedSlotId";
        }
    }

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ int g;
        final /* synthetic */ int h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = i;
            this.h = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            SZ6.a(this.e, this.f, interfaceC22053ub1, QJ5.a(this.g | 1), this.h);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ TZ6 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(TZ6 tz6) {
            super(0);
            this.e = tz6;
        }

        public final void a() {
            this.e.d();
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ TZ6 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(TZ6 tz6, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = tz6;
            this.f = eVar;
            this.g = interfaceC14603iB2;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            SZ6.b(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1298353104);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if (interfaceC22053ub1J.o((i3 & 19) != 18, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1298353104, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:82)");
            }
            Object objB = interfaceC22053ub1J.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new TZ6();
                interfaceC22053ub1J.s(objB);
            }
            TZ6 tz6 = (TZ6) objB;
            int i5 = i3 << 3;
            b(tz6, eVar, interfaceC14603iB2, interfaceC22053ub1J, (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i5 & 896), 0);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(eVar, interfaceC14603iB2, i, i2));
        }
    }

    public static final void b(TZ6 tz6, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-511989831);
        if ((i2 & 1) != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(tz6) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-511989831, i3, -1, "androidx.compose.ui.layout.SubcomposeLayout (SubcomposeLayout.kt:115)");
            }
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            AbstractC7050Qb1 abstractC7050Qb1D = AbstractC6797Pa1.d(interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            SA2 sa2A = C3419Au3.J0.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A, tz6, tz6.g());
            DG7.c(interfaceC22053ub1A, abstractC7050Qb1D, tz6.e());
            DG7.c(interfaceC22053ub1A, interfaceC14603iB2, tz6.f());
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC22053ub1J.u();
            if (interfaceC22053ub1J.k()) {
                interfaceC22053ub1J.W(-26267397);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-26326018);
                boolean zD = interfaceC22053ub1J.D(tz6);
                Object objB = interfaceC22053ub1J.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new c(tz6);
                    interfaceC22053ub1J.s(objB);
                }
                AbstractC10721c52.i((SA2) objB, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.Q();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        androidx.compose.ui.e eVar2 = eVar;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new d(tz6, eVar2, interfaceC14603iB2, i, i2));
        }
    }
}
