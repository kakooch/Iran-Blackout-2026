package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC17917nm5;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import java.util.List;

/* renamed from: ir.nasim.nm5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC17917nm5 {

    /* renamed from: ir.nasim.nm5$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ List a;
        final /* synthetic */ long b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ boolean d;

        /* renamed from: ir.nasim.nm5$a$a, reason: collision with other inner class name */
        public static final class C1417a extends AbstractC8614Ws3 implements UA2 {
            public static final C1417a e = new C1417a();

            public C1417a() {
                super(1);
            }

            @Override // ir.nasim.UA2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Object obj) {
                return null;
            }
        }

        /* renamed from: ir.nasim.nm5$a$b */
        public static final class b extends AbstractC8614Ws3 implements UA2 {
            final /* synthetic */ UA2 e;
            final /* synthetic */ List f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(UA2 ua2, List list) {
                super(1);
                this.e = ua2;
                this.f = list;
            }

            public final Object a(int i) {
                return this.e.invoke(this.f.get(i));
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return a(((Number) obj).intValue());
            }
        }

        /* renamed from: ir.nasim.nm5$a$c */
        public static final class c extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
            final /* synthetic */ List e;
            final /* synthetic */ long f;
            final /* synthetic */ UA2 g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, long j, UA2 ua2) {
                super(4);
                this.e = list;
                this.f = j;
                this.g = ua2;
            }

            public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                if ((i2 & 6) == 0) {
                    i3 = i2 | (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
                }
                if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                    interfaceC22053ub1.L();
                    return;
                }
                if (AbstractC5138Ib1.I()) {
                    AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                C6167Ml5 c6167Ml5 = (C6167Ml5) this.e.get(i);
                interfaceC22053ub1.W(1400541447);
                e.a aVar = androidx.compose.ui.e.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
                C9784aZ0 c9784aZ0 = C9784aZ0.a;
                AbstractC23353wm5.p(c6167Ml5.f() == this.f, c6167Ml5, null, 0.0f, null, null, this.g, interfaceC22053ub1, 0, 60);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
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

        a(List list, long j, UA2 ua2, boolean z) {
            this.a = list;
            this.b = j;
            this.c = ua2;
            this.d = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(List list, long j, UA2 ua2, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$items");
            AbstractC13042fc3.i(ua2, "$onItemSelected");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            R71 r71 = R71.a;
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, r71.a(), 3, null);
            interfaceC15069ix3.a(list.size(), null, new b(C1417a.e, list), AbstractC19242q11.c(-632812321, true, new c(list, j, ua2)));
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, r71.b(), 3, null);
            return C19938rB7.a;
        }

        public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            e.a aVar;
            int i2;
            G10 g10;
            AbstractC13042fc3.i(zy0, "$this$Card");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar2 = androidx.compose.ui.e.a;
            G10 g102 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.b.d(aVar2, g102.a(interfaceC22053ub1, i3).y(), null, 2, null), 0.0f, 1, null), g102.c(interfaceC22053ub1, i3).b().e());
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            boolean z = this.d;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            if (z) {
                interfaceC22053ub1.W(1787333165);
                String strC = UY6.c(QD5.base_premium_special, interfaceC22053ub1, 0);
                C9348Zn7 c9348Zn7L = g102.d(interfaceC22053ub1, i3).l();
                aVar = aVar2;
                AbstractC9339Zm7.b(strC, null, g102.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub1, 0, 0, 65530);
                interfaceC22053ub1.Q();
                i2 = i3;
                g10 = g102;
            } else {
                aVar = aVar2;
                interfaceC22053ub1.W(1787674537);
                String strC2 = UY6.c(QD5.base_premium_not_special, interfaceC22053ub1, 0);
                C9348Zn7 c9348Zn7L2 = g102.d(interfaceC22053ub1, i3).l();
                i2 = i3;
                g10 = g102;
                AbstractC9339Zm7.b(strC2, null, g102.a(interfaceC22053ub1, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L2.b((16744447 & 1) != 0 ? c9348Zn7L2.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L2.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L2.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L2.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L2.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L2.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L2.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L2.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L2.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L2.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L2.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L2.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L2.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L2.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L2.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L2.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7L2.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L2.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L2.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L2.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L2.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L2.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L2.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L2.b.k() : null), interfaceC22053ub1, 0, 0, 65530);
                interfaceC22053ub1.Q();
            }
            interfaceC22053ub1.u();
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            e.a aVar4 = aVar;
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(aVar4, g10.c(interfaceC22053ub1, i2).b().c(), 0.0f, 2, null);
            interfaceC22053ub1.W(-1904648598);
            boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.f(this.b) | interfaceC22053ub1.V(this.c);
            final List list = this.a;
            final long j = this.b;
            final UA2 ua2 = this.c;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.mm5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC17917nm5.a.c(list, j, ua2, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC12623ev3.b(eVarK, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 510);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void b(final ZY0 zy0, final List list, final long j, final TS4 ts4, final boolean z, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(zy0, "<this>");
        AbstractC13042fc3.i(list, "items");
        AbstractC13042fc3.i(ts4, "paddingValues");
        AbstractC13042fc3.i(ua2, "onItemSelected");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(852564508);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.f(j) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.V(ts4) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 131072 : 65536;
        }
        if ((i2 & 74899) == 74898 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.q.h(zy0.a(androidx.compose.ui.e.a, 1.0f, false), ts4);
            G10 g10 = G10.a;
            int i3 = G10.b;
            PG0.a(FV0.a(eVarH, N46.d(g10.c(interfaceC22053ub1J, i3).a().b())), N46.d(g10.c(interfaceC22053ub1J, i3).a().b()), MG0.a.b(g10.a(interfaceC22053ub1J, i3).r(), 0L, 0L, 0L, interfaceC22053ub1J, MG0.b << 12, 14), null, AbstractC11256ci0.a(C17784nZ1.q(1), g10.a(interfaceC22053ub1J, i3).C()), AbstractC19242q11.e(-1433464306, true, new a(list, j, ua2, z), interfaceC22053ub1J, 54), interfaceC22053ub1J, 196608, 8);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.lm5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC17917nm5.c(zy0, list, j, ts4, z, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c(ZY0 zy0, List list, long j, TS4 ts4, boolean z, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(zy0, "$this_PremiumPackageCard");
        AbstractC13042fc3.i(list, "$items");
        AbstractC13042fc3.i(ts4, "$paddingValues");
        AbstractC13042fc3.i(ua2, "$onItemSelected");
        b(zy0, list, j, ts4, z, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
