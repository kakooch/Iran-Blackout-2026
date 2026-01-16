package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class OS0 {
    private static final float a;
    private static final TS4 b;
    private static final TS4 c;
    private static final TS4 d;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ float e;
        final /* synthetic */ TS4 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ long j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ long l;

        /* renamed from: ir.nasim.OS0$a$a, reason: collision with other inner class name */
        static final class C0553a implements InterfaceC10970cW3 {
            public static final C0553a a = new C0553a();

            /* renamed from: ir.nasim.OS0$a$a$a, reason: collision with other inner class name */
            static final class C0554a extends AbstractC8614Ws3 implements UA2 {
                final /* synthetic */ AbstractC21430te5 e;
                final /* synthetic */ int f;
                final /* synthetic */ int g;
                final /* synthetic */ AbstractC21430te5 h;
                final /* synthetic */ int i;
                final /* synthetic */ AbstractC21430te5 j;
                final /* synthetic */ int k;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C0554a(AbstractC21430te5 abstractC21430te5, int i, int i2, AbstractC21430te5 abstractC21430te52, int i3, AbstractC21430te5 abstractC21430te53, int i4) {
                    super(1);
                    this.e = abstractC21430te5;
                    this.f = i;
                    this.g = i2;
                    this.h = abstractC21430te52;
                    this.i = i3;
                    this.j = abstractC21430te53;
                    this.k = i4;
                }

                public final void a(AbstractC21430te5.a aVar) {
                    AbstractC21430te5 abstractC21430te5 = this.e;
                    if (abstractC21430te5 != null) {
                        AbstractC21430te5.a.l(aVar, abstractC21430te5, 0, InterfaceC12529em.a.i().a(this.f, this.g), 0.0f, 4, null);
                    }
                    AbstractC21430te5.a.l(aVar, this.h, this.i, 0, 0.0f, 4, null);
                    AbstractC21430te5 abstractC21430te52 = this.j;
                    if (abstractC21430te52 != null) {
                        AbstractC21430te5.a.l(aVar, abstractC21430te52, this.h.P0() + this.i, InterfaceC12529em.a.i().a(this.k, this.g), 0.0f, 4, null);
                    }
                }

                @Override // ir.nasim.UA2
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    a((AbstractC21430te5.a) obj);
                    return C19938rB7.a;
                }
            }

            C0553a() {
            }

            @Override // ir.nasim.InterfaceC10970cW3
            public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
                Object obj;
                Object obj2;
                int size = list.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        obj = null;
                        break;
                    }
                    obj = list.get(i);
                    if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj), "leadingIcon")) {
                        break;
                    }
                    i++;
                }
                ZV3 zv3 = (ZV3) obj;
                AbstractC21430te5 abstractC21430te5L0 = zv3 != null ? zv3.l0(C17833ne1.d(j, 0, 0, 0, 0, 10, null)) : null;
                int iB = AbstractC12537em7.b(abstractC21430te5L0);
                int iA = AbstractC12537em7.a(abstractC21430te5L0);
                int size2 = list.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size2) {
                        obj2 = null;
                        break;
                    }
                    obj2 = list.get(i2);
                    if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a((ZV3) obj2), "trailingIcon")) {
                        break;
                    }
                    i2++;
                }
                ZV3 zv32 = (ZV3) obj2;
                AbstractC21430te5 abstractC21430te5L02 = zv32 != null ? zv32.l0(C17833ne1.d(j, 0, 0, 0, 0, 10, null)) : null;
                int iB2 = AbstractC12537em7.b(abstractC21430te5L02);
                int iA2 = AbstractC12537em7.a(abstractC21430te5L02);
                int size3 = list.size();
                for (int i3 = 0; i3 < size3; i3++) {
                    ZV3 zv33 = (ZV3) list.get(i3);
                    if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv33), "label")) {
                        AbstractC21430te5 abstractC21430te5L03 = zv33.l0(AbstractC19606qe1.j(j, -(iB + iB2), 0, 2, null));
                        int iP0 = abstractC21430te5L03.P0() + iB + iB2;
                        int iMax = Math.max(iA, Math.max(abstractC21430te5L03.A0(), iA2));
                        return InterfaceC12377eW3.Q1(interfaceC12377eW3, iP0, iMax, null, new C0554a(abstractC21430te5L0, iA, iMax, abstractC21430te5L03, iB, abstractC21430te5L02, iA2), 4, null);
                    }
                }
                throw new NoSuchElementException("Collection contains no element matching the predicate.");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(float f, TS4 ts4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, long j, InterfaceC14603iB2 interfaceC14603iB24, long j2) {
            super(2);
            this.e = f;
            this.f = ts4;
            this.g = interfaceC14603iB2;
            this.h = interfaceC14603iB22;
            this.i = interfaceC14603iB23;
            this.j = j;
            this.k = interfaceC14603iB24;
            this.l = j2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1748799148, i, -1, "androidx.compose.material3.ChipContent.<anonymous> (Chip.kt:2056)");
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(androidx.compose.foundation.layout.t.b(aVar, 0.0f, this.e, 1, null), this.f);
            C0553a c0553a = C0553a.a;
            InterfaceC14603iB2 interfaceC14603iB2 = this.g;
            InterfaceC14603iB2 interfaceC14603iB22 = this.h;
            InterfaceC14603iB2 interfaceC14603iB23 = this.i;
            long j = this.j;
            InterfaceC14603iB2 interfaceC14603iB24 = this.k;
            long j2 = this.l;
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarH);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A, c0553a, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            interfaceC22053ub1.W(-1293169671);
            if (interfaceC14603iB2 != null || interfaceC14603iB22 != null) {
                androidx.compose.ui.e eVarB = androidx.compose.ui.layout.a.b(aVar, "leadingIcon");
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
                SA2 sa2A2 = aVar2.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A2);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar2.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar2.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar2.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                if (interfaceC14603iB2 != null) {
                    interfaceC22053ub1.W(832680499);
                    interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
                    interfaceC22053ub1.Q();
                } else if (interfaceC14603iB22 != null) {
                    interfaceC22053ub1.W(832788565);
                    AbstractC11024cc1.a(AbstractC21553tk1.a().d(C24381yX0.k(j)), interfaceC14603iB22, interfaceC22053ub1, C7252Qx5.i);
                    interfaceC22053ub1.Q();
                } else {
                    interfaceC22053ub1.W(833040347);
                    interfaceC22053ub1.Q();
                }
                interfaceC22053ub1.u();
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.ui.layout.a.b(aVar, "label"), OS0.a, C17784nZ1.q(0));
            C24254yJ.e eVarG = C24254yJ.a.g();
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar3.i(), interfaceC22053ub1, 54);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
            SA2 sa2A3 = aVar2.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A3);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar2.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar2.f());
            M66 m66 = M66.a;
            interfaceC14603iB24.invoke(interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
            interfaceC22053ub1.W(-1293135324);
            if (interfaceC14603iB23 != null) {
                androidx.compose.ui.e eVarB2 = androidx.compose.ui.layout.a.b(aVar, "trailingIcon");
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar3.e(), false);
                int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB2);
                SA2 sa2A4 = aVar2.a();
                if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1.G();
                if (interfaceC22053ub1.h()) {
                    interfaceC22053ub1.g(sa2A4);
                } else {
                    interfaceC22053ub1.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1);
                DG7.c(interfaceC22053ub1A4, interfaceC10970cW3G2, aVar2.e());
                DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B4 = aVar2.b();
                if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                    interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                    interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
                }
                DG7.c(interfaceC22053ub1A4, eVarE4, aVar2.f());
                androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
                AbstractC11024cc1.a(AbstractC21553tk1.a().d(C24381yX0.k(j2)), interfaceC14603iB23, interfaceC22053ub1, C7252Qx5.i);
                interfaceC22053ub1.u();
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
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

    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ C9348Zn7 f;
        final /* synthetic */ long g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ long k;
        final /* synthetic */ long l;
        final /* synthetic */ float m;
        final /* synthetic */ TS4 n;
        final /* synthetic */ int o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, long j, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, long j2, long j3, float f, TS4 ts4, int i) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = c9348Zn7;
            this.g = j;
            this.h = interfaceC14603iB22;
            this.i = interfaceC14603iB23;
            this.j = interfaceC14603iB24;
            this.k = j2;
            this.l = j3;
            this.m = f;
            this.n = ts4;
            this.o = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            OS0.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, interfaceC22053ub1, QJ5.a(this.o | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ androidx.compose.ui.e h;
        final /* synthetic */ boolean i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC10031ax6 l;
        final /* synthetic */ C3350Am6 m;
        final /* synthetic */ C3589Bm6 n;
        final /* synthetic */ C10493bi0 o;
        final /* synthetic */ InterfaceC18507om4 p;
        final /* synthetic */ int q;
        final /* synthetic */ int r;
        final /* synthetic */ int s;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(boolean z, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, androidx.compose.ui.e eVar, boolean z2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC10031ax6 interfaceC10031ax6, C3350Am6 c3350Am6, C3589Bm6 c3589Bm6, C10493bi0 c10493bi0, InterfaceC18507om4 interfaceC18507om4, int i, int i2, int i3) {
            super(2);
            this.e = z;
            this.f = sa2;
            this.g = interfaceC14603iB2;
            this.h = eVar;
            this.i = z2;
            this.j = interfaceC14603iB22;
            this.k = interfaceC14603iB23;
            this.l = interfaceC10031ax6;
            this.m = c3350Am6;
            this.n = c3589Bm6;
            this.o = c10493bi0;
            this.p = interfaceC18507om4;
            this.q = i;
            this.r = i2;
            this.s = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            OS0.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, interfaceC22053ub1, QJ5.a(this.q | 1), QJ5.a(this.r), this.s);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        d() {
            super(1);
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
            AbstractC9939ao6.p0(interfaceC11943do6, B26.b.c());
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ C3350Am6 e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ C9348Zn7 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ float m;
        final /* synthetic */ TS4 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(C3350Am6 c3350Am6, boolean z, boolean z2, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, float f, TS4 ts4) {
            super(2);
            this.e = c3350Am6;
            this.f = z;
            this.g = z2;
            this.h = interfaceC14603iB2;
            this.i = c9348Zn7;
            this.j = interfaceC14603iB22;
            this.k = interfaceC14603iB23;
            this.l = interfaceC14603iB24;
            this.m = f;
            this.n = ts4;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-577614814, i, -1, "androidx.compose.material3.SelectableChip.<anonymous> (Chip.kt:2024)");
            }
            OS0.a(this.h, this.i, this.e.d(this.f, this.g), this.j, this.k, this.l, this.e.e(this.f, this.g), this.e.f(this.f, this.g), this.m, this.n, interfaceC22053ub1, 0);
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

    static final class f extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ boolean e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ C9348Zn7 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC10031ax6 n;
        final /* synthetic */ C3350Am6 o;
        final /* synthetic */ C3589Bm6 p;
        final /* synthetic */ C10493bi0 q;
        final /* synthetic */ float r;
        final /* synthetic */ TS4 s;
        final /* synthetic */ InterfaceC18507om4 t;
        final /* synthetic */ int u;
        final /* synthetic */ int v;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(boolean z, androidx.compose.ui.e eVar, SA2 sa2, boolean z2, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC10031ax6 interfaceC10031ax6, C3350Am6 c3350Am6, C3589Bm6 c3589Bm6, C10493bi0 c10493bi0, float f, TS4 ts4, InterfaceC18507om4 interfaceC18507om4, int i, int i2) {
            super(2);
            this.e = z;
            this.f = eVar;
            this.g = sa2;
            this.h = z2;
            this.i = interfaceC14603iB2;
            this.j = c9348Zn7;
            this.k = interfaceC14603iB22;
            this.l = interfaceC14603iB23;
            this.m = interfaceC14603iB24;
            this.n = interfaceC10031ax6;
            this.o = c3350Am6;
            this.p = c3589Bm6;
            this.q = c10493bi0;
            this.r = f;
            this.s = ts4;
            this.t = interfaceC18507om4;
            this.u = i;
            this.v = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            OS0.c(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, interfaceC22053ub1, QJ5.a(this.u | 1), QJ5.a(this.v));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        float fQ = C17784nZ1.q(8);
        a = fQ;
        b = androidx.compose.foundation.layout.q.c(fQ, 0.0f, 2, null);
        c = androidx.compose.foundation.layout.q.c(fQ, 0.0f, 2, null);
        d = androidx.compose.foundation.layout.q.c(fQ, 0.0f, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, long j, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, long j2, long j3, float f2, TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-782878228);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(interfaceC14603iB2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c9348Zn7) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.f(j) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.f(j2) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.f(j3) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.c(f2) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i2 |= interfaceC22053ub1J.V(ts4) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-782878228, i2, -1, "androidx.compose.material3.ChipContent (Chip.kt:2051)");
            }
            AbstractC11024cc1.b(new C7252Qx5[]{AbstractC21553tk1.a().d(C24381yX0.k(j)), AbstractC9339Zm7.d().d(c9348Zn7)}, AbstractC19242q11.e(1748799148, true, new a(f2, ts4, interfaceC14603iB23, interfaceC14603iB22, interfaceC14603iB24, j2, interfaceC14603iB2, j3), interfaceC22053ub1J, 54), interfaceC22053ub1J, C7252Qx5.i | 48);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new b(interfaceC14603iB2, c9348Zn7, j, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, j2, j3, f2, ts4, i));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x029d  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:201:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0113  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(boolean r43, ir.nasim.SA2 r44, ir.nasim.InterfaceC14603iB2 r45, androidx.compose.ui.e r46, boolean r47, ir.nasim.InterfaceC14603iB2 r48, ir.nasim.InterfaceC14603iB2 r49, ir.nasim.InterfaceC10031ax6 r50, ir.nasim.C3350Am6 r51, ir.nasim.C3589Bm6 r52, ir.nasim.C10493bi0 r53, ir.nasim.InterfaceC18507om4 r54, ir.nasim.InterfaceC22053ub1 r55, int r56, int r57, int r58) {
        /*
            Method dump skipped, instructions count: 849
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.OS0.b(boolean, ir.nasim.SA2, ir.nasim.iB2, androidx.compose.ui.e, boolean, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.ax6, ir.nasim.Am6, ir.nasim.Bm6, ir.nasim.bi0, ir.nasim.om4, ir.nasim.ub1, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(boolean z, androidx.compose.ui.e eVar, SA2 sa2, boolean z2, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC10031ax6 interfaceC10031ax6, C3350Am6 c3350Am6, C3589Bm6 c3589Bm6, C10493bi0 c10493bi0, float f2, TS4 ts4, InterfaceC18507om4 interfaceC18507om4, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        int i3;
        int i4;
        InterfaceC18507om4 interfaceC18507om42;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(402951308);
        if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.V(eVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i3 |= interfaceC22053ub1J.a(z2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i3 |= interfaceC22053ub1J.V(c9348Zn7) ? 131072 : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 1048576 : 524288;
        }
        if ((i & 12582912) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= interfaceC22053ub1J.D(interfaceC14603iB24) ? 67108864 : 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= interfaceC22053ub1J.V(interfaceC10031ax6) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = (interfaceC22053ub1J.V(c3350Am6) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= interfaceC22053ub1J.V(c3589Bm6) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= interfaceC22053ub1J.V(c10493bi0) ? 256 : 128;
        }
        if ((i2 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i4 |= interfaceC22053ub1J.c(f2) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= interfaceC22053ub1J.V(ts4) ? 16384 : 8192;
        }
        if ((i2 & 196608) == 0) {
            i4 |= interfaceC22053ub1J.V(interfaceC18507om4) ? 131072 : 65536;
        }
        if ((i3 & 306783379) == 306783378 && (74899 & i4) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(402951308, i3, i4, "androidx.compose.material3.SelectableChip (Chip.kt:2009)");
            }
            interfaceC22053ub1J.W(2072749057);
            if (interfaceC18507om4 == null) {
                Object objB = interfaceC22053ub1J.B();
                if (objB == InterfaceC22053ub1.a.a()) {
                    objB = AbstractC23831xb3.a();
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC18507om42 = (InterfaceC18507om4) objB;
            } else {
                interfaceC18507om42 = interfaceC18507om4;
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVar, false, d.e, 1, null);
            long jA = c3350Am6.a(z2, z);
            interfaceC22053ub1J.W(2072762384);
            InterfaceC9664aL6 interfaceC9664aL6F = c3589Bm6 != null ? c3589Bm6.f(z2, interfaceC18507om42, interfaceC22053ub1J, ((i3 >> 9) & 14) | ((i4 << 3) & 896)) : null;
            interfaceC22053ub1J.Q();
            int i5 = i3;
            interfaceC22053ub12 = interfaceC22053ub1J;
            F27.b(z, sa2, eVarD, z2, interfaceC10031ax6, jA, 0L, 0.0f, interfaceC9664aL6F != null ? ((C17784nZ1) interfaceC9664aL6F.getValue()).v() : C17784nZ1.q(0), c10493bi0, interfaceC18507om42, AbstractC19242q11.e(-577614814, true, new e(c3350Am6, z2, z, interfaceC14603iB2, c9348Zn7, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, f2, ts4), interfaceC22053ub1J, 54), interfaceC22053ub1J, (i5 & 14) | ((i5 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i5 & 7168) | ((i5 >> 15) & 57344) | ((i4 << 21) & 1879048192), 48, 192);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new f(z, eVar, sa2, z2, interfaceC14603iB2, c9348Zn7, interfaceC14603iB22, interfaceC14603iB23, interfaceC14603iB24, interfaceC10031ax6, c3350Am6, c3589Bm6, c10493bi0, f2, ts4, interfaceC18507om4, i, i2));
        }
    }
}
