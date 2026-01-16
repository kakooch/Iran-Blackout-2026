package ir.nasim;

import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* renamed from: ir.nasim.qu3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC19768qu3 {

    /* renamed from: ir.nasim.qu3$a */
    static final class a extends AbstractC8614Ws3 implements UA2 {
        public static final a e = new a();

        a() {
            super(1);
        }

        public final void a(C3419Au3 c3419Au3) {
            c3419Au3.J1(true);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((C3419Au3) obj);
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qu3$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ InterfaceC10970cW3 g;
        final /* synthetic */ int h;
        final /* synthetic */ int i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC10970cW3 interfaceC10970cW3, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = interfaceC10970cW3;
            this.h = i;
            this.i = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC19768qu3.a(this.e, this.f, this.g, interfaceC22053ub1, QJ5.a(this.h | 1), this.i);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qu3$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list) {
            super(2);
            this.e = list;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1953651383, i, -1, "androidx.compose.ui.layout.combineAsVirtualLayouts.<anonymous> (Layout.kt:176)");
            }
            List list = this.e;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC14603iB2 interfaceC14603iB2 = (InterfaceC14603iB2) list.get(i2);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
                SA2 sa2I = aVar.i();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2I);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
                InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qu3$d */
    static final class d extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ androidx.compose.ui.e e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(androidx.compose.ui.e eVar) {
            super(3);
            this.e = eVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, InterfaceC22053ub1 interfaceC22053ub12, int i) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1586257396, i, -1, "androidx.compose.ui.layout.materializerOf.<anonymous> (Layout.kt:196)");
            }
            int iA = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub12, this.e);
            interfaceC22053ub1.A(509942095);
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC22053ub1.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a(((C12827fE6) obj).f(), (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.qu3$e */
    static final class e extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ androidx.compose.ui.e e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(androidx.compose.ui.e eVar) {
            super(3);
            this.e = eVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, InterfaceC22053ub1 interfaceC22053ub12, int i) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-55743822, i, -1, "androidx.compose.ui.layout.materializerOfWithCompositionLocalInjection.<anonymous> (Layout.kt:218)");
            }
            int iA = AbstractC6797Pa1.a(interfaceC22053ub12, 0);
            androidx.compose.ui.e eVarF = androidx.compose.ui.c.f(interfaceC22053ub12, this.e);
            interfaceC22053ub1.A(509942095);
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            DG7.c(interfaceC22053ub1A, eVarF, aVar.f());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC22053ub1.U();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a(((C12827fE6) obj).f(), (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void a(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC10970cW3 interfaceC10970cW3, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1949933075);
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
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(interfaceC10970cW3) ? 256 : 128;
        }
        if (interfaceC22053ub1J.o((i3 & 147) != 146, i3 & 1)) {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1949933075, i3, -1, "androidx.compose.ui.layout.MultiMeasureLayout (Layout.kt:237)");
            }
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            SA2 sa2A = C3419Au3.J0.a();
            int i5 = ((i3 << 3) & 896) | 6;
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
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            DG7.b(interfaceC22053ub1A, a.e);
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i5 >> 6) & 14));
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        androidx.compose.ui.e eVar2 = eVar;
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(eVar2, interfaceC14603iB2, interfaceC10970cW3, i, i2));
        }
    }

    public static final InterfaceC14603iB2 b(List list) {
        return AbstractC19242q11.c(-1953651383, true, new c(list));
    }

    public static final InterfaceC15796kB2 c(androidx.compose.ui.e eVar) {
        return AbstractC19242q11.c(-55743822, true, new e(eVar));
    }

    public static final InterfaceC15796kB2 d(androidx.compose.ui.e eVar) {
        return AbstractC19242q11.c(-1586257396, true, new d(eVar));
    }
}
