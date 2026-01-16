package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.C24254yJ;
import ir.nasim.ED;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class ED {
    private static final float a;
    private static final float b;
    private static final float c;
    private static final float d;
    private static final C11397cw1 e;
    private static final float f;
    private static final float g;
    private static final float h;
    private static final float i;

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ InterfaceC15796kB2 h;
        final /* synthetic */ float i;
        final /* synthetic */ A98 j;
        final /* synthetic */ C17388ms7 k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(InterfaceC14603iB2 interfaceC14603iB2, androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2, float f, A98 a98, C17388ms7 c17388ms7, InterfaceC24595ys7 interfaceC24595ys7, int i, int i2) {
            super(2);
            this.e = interfaceC14603iB2;
            this.f = eVar;
            this.g = interfaceC14603iB22;
            this.h = interfaceC15796kB2;
            this.i = f;
            this.j = a98;
            this.k = c17388ms7;
            this.l = i;
            this.m = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            ED.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, null, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class b extends AbstractC8614Ws3 implements SA2 {
        final /* synthetic */ float e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(InterfaceC24595ys7 interfaceC24595ys7, float f) {
            super(0);
            this.e = f;
        }

        public final void a() {
            AbstractC13042fc3.b(null, -this.e);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return C19938rB7.a;
        }
    }

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ A98 e;
        final /* synthetic */ float f;
        final /* synthetic */ C17388ms7 g;
        final /* synthetic */ InterfaceC14603iB2 h;
        final /* synthetic */ C9348Zn7 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(A98 a98, float f, InterfaceC24595ys7 interfaceC24595ys7, C17388ms7 c17388ms7, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, boolean z, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23) {
            super(2);
            this.e = a98;
            this.f = f;
            this.g = c17388ms7;
            this.h = interfaceC14603iB2;
            this.i = c9348Zn7;
            this.j = z;
            this.k = interfaceC14603iB22;
            this.l = interfaceC14603iB23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final float c(InterfaceC24595ys7 interfaceC24595ys7) {
            if (interfaceC24595ys7 == null) {
                return 0.0f;
            }
            interfaceC24595ys7.getState();
            return 0.0f;
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1943739546, i, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1927)");
            }
            final InterfaceC24595ys7 interfaceC24595ys7 = null;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.t.k(FV0.b(AbstractC22050ua8.c(androidx.compose.ui.e.a, this.e)), 0.0f, this.f, 1, null);
            boolean zV = interfaceC22053ub1.V(null);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new InterfaceC22678ve6(interfaceC24595ys7) { // from class: ir.nasim.FD
                    @Override // ir.nasim.InterfaceC22678ve6
                    public final float a() {
                        return ED.c.c(null);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            InterfaceC22678ve6 interfaceC22678ve6 = (InterfaceC22678ve6) objB;
            long jE = this.g.e();
            long jF = this.g.f();
            long jD = this.g.d();
            InterfaceC14603iB2 interfaceC14603iB2 = this.h;
            C9348Zn7 c9348Zn7 = this.i;
            C24254yJ c24254yJ = C24254yJ.a;
            ED.e(eVarK, interfaceC22678ve6, jE, jF, jD, interfaceC14603iB2, c9348Zn7, 1.0f, c24254yJ.b(), this.j ? c24254yJ.b() : c24254yJ.g(), 0, false, this.k, this.l, interfaceC22053ub1, 113246208, 3126);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ C9348Zn7 g;
        final /* synthetic */ boolean h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ InterfaceC15796kB2 j;
        final /* synthetic */ float k;
        final /* synthetic */ A98 l;
        final /* synthetic */ C17388ms7 m;
        final /* synthetic */ int n;
        final /* synthetic */ int o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, boolean z, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2, float f, A98 a98, C17388ms7 c17388ms7, InterfaceC24595ys7 interfaceC24595ys7, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = c9348Zn7;
            this.h = z;
            this.i = interfaceC14603iB22;
            this.j = interfaceC15796kB2;
            this.k = f;
            this.l = a98;
            this.m = c17388ms7;
            this.n = i;
            this.o = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            ED.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, null, interfaceC22053ub1, QJ5.a(this.n | 1), this.o);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static final class e extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC15796kB2 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(InterfaceC15796kB2 interfaceC15796kB2) {
            super(2);
            this.e = interfaceC15796kB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1370231018, i, -1, "androidx.compose.material3.SingleRowTopAppBar.<anonymous> (AppBar.kt:1895)");
            }
            C24254yJ.e eVarC = C24254yJ.a.c();
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            InterfaceC15796kB2 interfaceC15796kB2 = this.e;
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarC, cVarI, interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, aVar);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            interfaceC15796kB2.q(M66.a, interfaceC22053ub1, 6);
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

    static final class f extends AbstractC8614Ws3 implements UA2 {
        f(InterfaceC24595ys7 interfaceC24595ys7) {
            super(1);
        }

        public final void a(float f) {
            throw null;
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a(((Number) obj).floatValue());
            return C19938rB7.a;
        }
    }

    static final class g extends AbstractC19859r37 implements InterfaceC15796kB2 {
        int b;
        /* synthetic */ float c;

        g(InterfaceC24595ys7 interfaceC24595ys7, InterfaceC20295rm1 interfaceC20295rm1) {
            super(3, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                throw null;
            }
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            return C19938rB7.a;
        }

        public final Object n(InterfaceC20315ro1 interfaceC20315ro1, float f, InterfaceC20295rm1 interfaceC20295rm1) {
            g gVar = new g(null, interfaceC20295rm1);
            gVar.c = f;
            return gVar.invokeSuspend(C19938rB7.a);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            return n((InterfaceC20315ro1) obj, ((Number) obj2).floatValue(), (InterfaceC20295rm1) obj3);
        }
    }

    static final class h extends AbstractC8614Ws3 implements SA2 {
        h(InterfaceC24595ys7 interfaceC24595ys7) {
            super(0);
        }

        @Override // ir.nasim.SA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Float invoke() {
            return Float.valueOf(0.0f > 0.01f ? 1.0f : 0.0f);
        }
    }

    static final class j implements InterfaceC10970cW3 {
        final /* synthetic */ InterfaceC22678ve6 a;
        final /* synthetic */ C24254yJ.e b;
        final /* synthetic */ C24254yJ.m c;
        final /* synthetic */ int d;

        static final class a extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ AbstractC21430te5 e;
            final /* synthetic */ int f;
            final /* synthetic */ AbstractC21430te5 g;
            final /* synthetic */ C24254yJ.e h;
            final /* synthetic */ long i;
            final /* synthetic */ AbstractC21430te5 j;
            final /* synthetic */ InterfaceC12377eW3 k;
            final /* synthetic */ C24254yJ.m l;
            final /* synthetic */ int m;
            final /* synthetic */ int n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AbstractC21430te5 abstractC21430te5, int i, AbstractC21430te5 abstractC21430te52, C24254yJ.e eVar, long j, AbstractC21430te5 abstractC21430te53, InterfaceC12377eW3 interfaceC12377eW3, C24254yJ.m mVar, int i2, int i3) {
                super(1);
                this.e = abstractC21430te5;
                this.f = i;
                this.g = abstractC21430te52;
                this.h = eVar;
                this.i = j;
                this.j = abstractC21430te53;
                this.k = interfaceC12377eW3;
                this.l = mVar;
                this.m = i2;
                this.n = i3;
            }

            public final void a(AbstractC21430te5.a aVar) {
                int iL;
                int iA0;
                int iA02;
                int iL2;
                AbstractC21430te5 abstractC21430te5 = this.e;
                AbstractC21430te5.a.l(aVar, abstractC21430te5, 0, (this.f - abstractC21430te5.A0()) / 2, 0.0f, 4, null);
                AbstractC21430te5 abstractC21430te52 = this.g;
                C24254yJ.e eVar = this.h;
                C24254yJ c24254yJ = C24254yJ.a;
                if (AbstractC13042fc3.d(eVar, c24254yJ.b())) {
                    iL = (C17833ne1.l(this.i) - this.g.P0()) / 2;
                    if (iL < this.e.P0()) {
                        iL2 = this.e.P0() - iL;
                    } else if (this.g.P0() + iL > C17833ne1.l(this.i) - this.j.P0()) {
                        iL2 = (C17833ne1.l(this.i) - this.j.P0()) - (this.g.P0() + iL);
                    }
                    iL += iL2;
                } else {
                    iL = AbstractC13042fc3.d(eVar, c24254yJ.c()) ? (C17833ne1.l(this.i) - this.g.P0()) - this.j.P0() : Math.max(this.k.B0(ED.i), this.e.P0());
                }
                int i = iL;
                C24254yJ.m mVar = this.l;
                if (!AbstractC13042fc3.d(mVar, c24254yJ.b())) {
                    if (AbstractC13042fc3.d(mVar, c24254yJ.a())) {
                        int i2 = this.m;
                        if (i2 == 0) {
                            iA02 = this.f - this.g.A0();
                        } else {
                            int iA03 = i2 - (this.g.A0() - this.n);
                            int iA04 = this.g.A0() + iA03;
                            if (iA04 > C17833ne1.k(this.i)) {
                                iA03 -= iA04 - C17833ne1.k(this.i);
                            }
                            iA0 = (this.f - this.g.A0()) - Math.max(0, iA03);
                        }
                    } else {
                        iA0 = 0;
                    }
                    AbstractC21430te5.a.l(aVar, abstractC21430te52, i, iA0, 0.0f, 4, null);
                    AbstractC21430te5.a.l(aVar, this.j, C17833ne1.l(this.i) - this.j.P0(), (this.f - this.j.A0()) / 2, 0.0f, 4, null);
                }
                iA02 = (this.f - this.g.A0()) / 2;
                iA0 = iA02;
                AbstractC21430te5.a.l(aVar, abstractC21430te52, i, iA0, 0.0f, 4, null);
                AbstractC21430te5.a.l(aVar, this.j, C17833ne1.l(this.i) - this.j.P0(), (this.f - this.j.A0()) / 2, 0.0f, 4, null);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((AbstractC21430te5.a) obj);
                return C19938rB7.a;
            }
        }

        j(InterfaceC22678ve6 interfaceC22678ve6, C24254yJ.e eVar, C24254yJ.m mVar, int i) {
            this.a = interfaceC22678ve6;
            this.b = eVar;
            this.c = mVar;
            this.d = i;
        }

        @Override // ir.nasim.InterfaceC10970cW3
        public final InterfaceC11734dW3 b(InterfaceC12377eW3 interfaceC12377eW3, List list, long j) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ZV3 zv3 = (ZV3) list.get(i);
                if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv3), "navigationIcon")) {
                    AbstractC21430te5 abstractC21430te5L0 = zv3.l0(C17833ne1.d(j, 0, 0, 0, 0, 14, null));
                    int size2 = list.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ZV3 zv32 = (ZV3) list.get(i2);
                        if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv32), "actionIcons")) {
                            AbstractC21430te5 abstractC21430te5L02 = zv32.l0(C17833ne1.d(j, 0, 0, 0, 0, 14, null));
                            int iL = C17833ne1.l(j) == Integer.MAX_VALUE ? C17833ne1.l(j) : AbstractC23053wG5.e((C17833ne1.l(j) - abstractC21430te5L0.P0()) - abstractC21430te5L02.P0(), 0);
                            int size3 = list.size();
                            for (int i3 = 0; i3 < size3; i3++) {
                                ZV3 zv33 = (ZV3) list.get(i3);
                                if (AbstractC13042fc3.d(androidx.compose.ui.layout.a.a(zv33), "title")) {
                                    AbstractC21430te5 abstractC21430te5L03 = zv33.l0(C17833ne1.d(j, 0, iL, 0, 0, 12, null));
                                    int iJ = abstractC21430te5L03.J(AbstractC13756gm.b()) != Integer.MIN_VALUE ? abstractC21430te5L03.J(AbstractC13756gm.b()) : 0;
                                    float fA = this.a.a();
                                    int iK = C17833ne1.k(j) == Integer.MAX_VALUE ? C17833ne1.k(j) : C17833ne1.k(j) + (Float.isNaN(fA) ? 0 : AbstractC20723sV3.d(fA));
                                    return InterfaceC12377eW3.Q1(interfaceC12377eW3, C17833ne1.l(j), iK, null, new a(abstractC21430te5L0, iK, abstractC21430te5L03, this.b, j, abstractC21430te5L02, interfaceC12377eW3, this.c, this.d, iJ), 4, null);
                                }
                            }
                            throw new NoSuchElementException("Collection contains no element matching the predicate.");
                        }
                    }
                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                }
            }
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }
    }

    static final class k extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC22678ve6 f;
        final /* synthetic */ long g;
        final /* synthetic */ long h;
        final /* synthetic */ long i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ C9348Zn7 k;
        final /* synthetic */ float l;
        final /* synthetic */ C24254yJ.m m;
        final /* synthetic */ C24254yJ.e n;
        final /* synthetic */ int o;
        final /* synthetic */ boolean p;
        final /* synthetic */ InterfaceC14603iB2 q;
        final /* synthetic */ InterfaceC14603iB2 r;
        final /* synthetic */ int s;
        final /* synthetic */ int t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        k(androidx.compose.ui.e eVar, InterfaceC22678ve6 interfaceC22678ve6, long j, long j2, long j3, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, float f, C24254yJ.m mVar, C24254yJ.e eVar2, int i, boolean z, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, int i2, int i3) {
            super(2);
            this.e = eVar;
            this.f = interfaceC22678ve6;
            this.g = j;
            this.h = j2;
            this.i = j3;
            this.j = interfaceC14603iB2;
            this.k = c9348Zn7;
            this.l = f;
            this.m = mVar;
            this.n = eVar2;
            this.o = i;
            this.p = z;
            this.q = interfaceC14603iB22;
            this.r = interfaceC14603iB23;
            this.s = i2;
            this.t = i3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            ED.e(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, interfaceC22053ub1, QJ5.a(this.s | 1), QJ5.a(this.t));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    static {
        float f2 = 16;
        float f3 = 12;
        float fQ = C17784nZ1.q(C17784nZ1.q(f2) - C17784nZ1.q(f3));
        a = fQ;
        float fQ2 = C17784nZ1.q(C17784nZ1.q(f2) - C17784nZ1.q(f3));
        b = fQ2;
        c = C17784nZ1.q(C17784nZ1.q(f2) - fQ);
        d = C17784nZ1.q(C17784nZ1.q(f3) - fQ2);
        e = new C11397cw1(0.8f, 0.0f, 0.8f, 0.15f);
        f = C17784nZ1.q(24);
        g = C17784nZ1.q(28);
        float fQ3 = C17784nZ1.q(4);
        h = fQ3;
        i = C17784nZ1.q(C17784nZ1.q(f2) - fQ3);
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(ir.nasim.InterfaceC14603iB2 r24, androidx.compose.ui.e r25, ir.nasim.InterfaceC14603iB2 r26, ir.nasim.InterfaceC15796kB2 r27, float r28, ir.nasim.A98 r29, ir.nasim.C17388ms7 r30, ir.nasim.InterfaceC24595ys7 r31, ir.nasim.InterfaceC22053ub1 r32, int r33, int r34) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ED.a(ir.nasim.iB2, androidx.compose.ui.e, ir.nasim.iB2, ir.nasim.kB2, float, ir.nasim.A98, ir.nasim.ms7, ir.nasim.ys7, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(androidx.compose.ui.e r33, ir.nasim.InterfaceC14603iB2 r34, ir.nasim.C9348Zn7 r35, boolean r36, ir.nasim.InterfaceC14603iB2 r37, ir.nasim.InterfaceC15796kB2 r38, float r39, ir.nasim.A98 r40, ir.nasim.C17388ms7 r41, ir.nasim.InterfaceC24595ys7 r42, ir.nasim.InterfaceC22053ub1 r43, int r44, int r45) {
        /*
            Method dump skipped, instructions count: 746
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.ED.b(androidx.compose.ui.e, ir.nasim.iB2, ir.nasim.Zn7, boolean, ir.nasim.iB2, ir.nasim.kB2, float, ir.nasim.A98, ir.nasim.ms7, ir.nasim.ys7, ir.nasim.ub1, int, int):void");
    }

    private static final long c(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((C24381yX0) interfaceC9664aL6.getValue()).y();
    }

    private static final float d(InterfaceC9664aL6 interfaceC9664aL6) {
        return ((Number) interfaceC9664aL6.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(androidx.compose.ui.e eVar, InterfaceC22678ve6 interfaceC22678ve6, long j2, long j3, long j4, InterfaceC14603iB2 interfaceC14603iB2, C9348Zn7 c9348Zn7, float f2, C24254yJ.m mVar, C24254yJ.e eVar2, int i2, boolean z, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC22053ub1 interfaceC22053ub1, int i3, int i4) {
        int i5;
        int i6;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-742442296);
        if ((i3 & 6) == 0) {
            i5 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= (i3 & 64) == 0 ? interfaceC22053ub1J.V(interfaceC22678ve6) : interfaceC22053ub1J.D(interfaceC22678ve6) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= interfaceC22053ub1J.f(j2) ? 256 : 128;
        }
        if ((i3 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i5 |= interfaceC22053ub1J.f(j3) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= interfaceC22053ub1J.f(j4) ? 16384 : 8192;
        }
        if ((196608 & i3) == 0) {
            i5 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 131072 : 65536;
        }
        if ((i3 & 1572864) == 0) {
            i5 |= interfaceC22053ub1J.V(c9348Zn7) ? 1048576 : 524288;
        }
        if ((i3 & 12582912) == 0) {
            i5 |= interfaceC22053ub1J.c(f2) ? 8388608 : 4194304;
        }
        if ((i3 & 100663296) == 0) {
            i5 |= interfaceC22053ub1J.V(mVar) ? 67108864 : 33554432;
        }
        if ((805306368 & i3) == 0) {
            i5 |= interfaceC22053ub1J.V(eVar2) ? 536870912 : 268435456;
        }
        if ((i4 & 6) == 0) {
            i6 = (interfaceC22053ub1J.e(i2) ? 4 : 2) | i4;
        } else {
            i6 = i4;
        }
        if ((i4 & 48) == 0) {
            i6 |= interfaceC22053ub1J.a(z) ? 32 : 16;
        }
        if ((i4 & 384) == 0) {
            i6 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 256 : 128;
        }
        if ((i4 & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i6 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 2048 : 1024;
        }
        if ((306783379 & i5) == 306783378 && (i6 & 1171) == 1170 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-742442296, i5, i6, "androidx.compose.material3.TopAppBarLayout (AppBar.kt:2134)");
            }
            boolean z2 = ((i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32 || ((i5 & 64) != 0 && interfaceC22053ub1J.D(interfaceC22678ve6))) | ((1879048192 & i5) == 536870912) | ((234881024 & i5) == 67108864) | ((i6 & 14) == 4);
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new j(interfaceC22678ve6, eVar2, mVar, i2);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC10970cW3 interfaceC10970cW3 = (InterfaceC10970cW3) objB;
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVar);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarB = androidx.compose.ui.layout.a.b(aVar2, "navigationIcon");
            float f3 = h;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(eVarB, f3, 0.0f, 0.0f, 0.0f, 14, null);
            InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM);
            SA2 sa2A2 = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A2);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A2 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            C7252Qx5 c7252Qx5D = AbstractC21553tk1.a().d(C24381yX0.k(j2));
            int i7 = C7252Qx5.i;
            AbstractC11024cc1.a(c7252Qx5D, interfaceC14603iB22, interfaceC22053ub1J, ((i6 >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | i7);
            interfaceC22053ub1J.u();
            androidx.compose.ui.e eVarC = androidx.compose.ui.graphics.b.c(androidx.compose.foundation.layout.q.k(androidx.compose.ui.layout.a.b(aVar2, "title"), f3, 0.0f, 2, null).i(z ? AbstractC6919Pn6.a(aVar2, i.e) : aVar2), 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, null, false, null, 0L, 0L, 0, 131067, null);
            InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
            SA2 sa2A3 = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A3);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A3 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar.f());
            int i8 = i5 >> 9;
            AbstractC7008Px5.a(j3, c9348Zn7, interfaceC14603iB2, interfaceC22053ub1J, ((i5 >> 15) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i8 & 14) | (i8 & 896));
            interfaceC22053ub1J.u();
            androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(androidx.compose.ui.layout.a.b(aVar2, "actionIcons"), 0.0f, 0.0f, f3, 0.0f, 11, null);
            InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM2);
            SA2 sa2A4 = aVar.a();
            if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1J.G();
            if (interfaceC22053ub1J.h()) {
                interfaceC22053ub1J.g(sa2A4);
            } else {
                interfaceC22053ub1J.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A4 = DG7.a(interfaceC22053ub1J);
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3G3, aVar.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar.f());
            AbstractC11024cc1.a(AbstractC21553tk1.a().d(C24381yX0.k(j4)), interfaceC14603iB23, interfaceC22053ub1J, ((i6 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | i7);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new k(eVar, interfaceC22678ve6, j2, j3, j4, interfaceC14603iB2, c9348Zn7, f2, mVar, eVar2, i2, z, interfaceC14603iB22, interfaceC14603iB23, i3, i4));
        }
    }

    static final class i extends AbstractC8614Ws3 implements UA2 {
        public static final i e = new i();

        i() {
            super(1);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC11943do6) obj);
            return C19938rB7.a;
        }

        public final void a(InterfaceC11943do6 interfaceC11943do6) {
        }
    }
}
