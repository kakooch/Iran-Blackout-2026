package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.compose.ui.e;
import androidx.compose.ui.graphics.painter.BitmapPainter;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import okhttp3.internal.http.StatusLine;

/* renamed from: ir.nasim.xl5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC23933xl5 {

    /* renamed from: ir.nasim.xl5$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C4950Hg2 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.xl5$a$a, reason: collision with other inner class name */
        static final class C1772a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ C4950Hg2 c;
            final /* synthetic */ InterfaceC9102Ym4 d;

            /* renamed from: ir.nasim.xl5$a$a$a, reason: collision with other inner class name */
            static final class C1773a extends AbstractC19859r37 implements InterfaceC14603iB2 {
                int b;
                final /* synthetic */ Bitmap c;
                final /* synthetic */ InterfaceC9102Ym4 d;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C1773a(Bitmap bitmap, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                    super(2, interfaceC20295rm1);
                    this.c = bitmap;
                    this.d = interfaceC9102Ym4;
                }

                @Override // ir.nasim.E90
                public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                    return new C1773a(this.c, this.d, interfaceC20295rm1);
                }

                @Override // ir.nasim.E90
                public final Object invokeSuspend(Object obj) {
                    AbstractC14862ic3.e();
                    if (this.b != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    AbstractC23933xl5.h(this.d, this.c);
                    return C19938rB7.a;
                }

                @Override // ir.nasim.InterfaceC14603iB2
                /* renamed from: n, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                    return ((C1773a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C1772a(C4950Hg2 c4950Hg2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = c4950Hg2;
                this.d = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C1772a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Bitmap bitmapCreateBitmap;
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    try {
                        com.caverock.androidsvg.g gVarO = com.caverock.androidsvg.g.o(this.c.f());
                        bitmapCreateBitmap = Bitmap.createBitmap(AbstractC23053wG5.e((int) gVarO.h(), 1), AbstractC23053wG5.e((int) gVarO.f(), 1), Bitmap.Config.ARGB_8888);
                        gVarO.r(new Canvas(bitmapCreateBitmap));
                    } catch (Exception unused) {
                        bitmapCreateBitmap = null;
                    }
                    WM3 wm3C = C12366eV1.c();
                    C1773a c1773a = new C1773a(bitmapCreateBitmap, this.d, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(wm3C, c1773a, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C1772a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C4950Hg2 c4950Hg2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c4950Hg2;
            this.d = interfaceC9102Ym4;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                AbstractC13778go1 abstractC13778go1B = C12366eV1.b();
                C1772a c1772a = new C1772a(this.c, this.d, null);
                this.b = 1;
                if (AbstractC9323Zl0.g(abstractC13778go1B, c1772a, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final void e(final C4950Hg2 c4950Hg2, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        e.a aVar;
        int i3;
        G10 g10;
        e.a aVar2;
        int i4;
        AbstractC13042fc3.i(c4950Hg2, "item");
        AbstractC13042fc3.i(sa2, "onUpdateClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-296192810);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c4950Hg2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        int i5 = i2;
        if ((i5 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            G10 g102 = G10.a;
            int i6 = G10.b;
            C10847cI6 c10847cI6B = g102.c(interfaceC22053ub1J, i6).b();
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), c10847cI6B.u(), c10847cI6B.r());
            InterfaceC12529em.a aVar4 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar4.i();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar5 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar5.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar5.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar5.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar5.f());
            M66 m66 = M66.a;
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar3, g102.c(interfaceC22053ub1J, i6).b().m());
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar4.e(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarT);
            SA2 sa2A2 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar5.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar5.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar5.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1J.W(-1429497363);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar6 = InterfaceC22053ub1.a;
            if (objB == aVar6.a()) {
                objB = AbstractC13472gH6.d(null, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            String strF = c4950Hg2.f();
            interfaceC22053ub1J.W(-1429494037);
            boolean z = (i5 & 14) == 4;
            Object objB2 = interfaceC22053ub1J.B();
            if (z || objB2 == aVar6.a()) {
                objB2 = new a(c4950Hg2, interfaceC9102Ym4, null);
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.e(strF, (InterfaceC14603iB2) objB2, interfaceC22053ub1J, 0);
            Bitmap bitmapG = g(interfaceC9102Ym4);
            interfaceC22053ub1J.W(-1429470032);
            if (bitmapG == null) {
                aVar = aVar3;
                i3 = i6;
                g10 = g102;
            } else {
                aVar = aVar3;
                i3 = i6;
                g10 = g102;
                AbstractC11456d23.b(new BitmapPainter(AbstractC19123pp.c(bitmapG), 0L, 0L, 6, null), null, androidx.compose.foundation.layout.t.t(aVar3, c10847cI6B.j()), null, null, 0.0f, null, interfaceC22053ub1J, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            int i7 = i3;
            e.a aVar7 = aVar;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar7, g10.c(interfaceC22053ub1J, i7).b().u()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(aVar7, 0.0f, c10847cI6B.u(), 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar4.k(), interfaceC22053ub1J, 0);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
            SA2 sa2A3 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3A, aVar5.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar5.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar5.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            InterfaceC10970cW3 interfaceC10970cW3B2 = J66.b(c24254yJ.g(), aVar4.i(), interfaceC22053ub1J, 48);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar7);
            SA2 sa2A4 = aVar5.a();
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
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3B2, aVar5.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar5.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar5.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar5.f());
            String strD = JF5.g() ? c4950Hg2.d() : c4950Hg2.b();
            C9348Zn7 c9348Zn7A = g10.d(interfaceC22053ub1J, i7).a();
            C6399Nk7.a aVar8 = C6399Nk7.b;
            AbstractC9339Zm7.b(strD, null, g10.a(interfaceC22053ub1J, i7).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7A.b((16744447 & 1) != 0 ? c9348Zn7A.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7A.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7A.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7A.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7A.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7A.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7A.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7A.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7A.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7A.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7A.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7A.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7A.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7A.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7A.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7A.b.h() : aVar8.f(), (16744447 & 65536) != 0 ? c9348Zn7A.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7A.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7A.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7A.c : null, (16744447 & 1048576) != 0 ? c9348Zn7A.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7A.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7A.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7A.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.W(-1679855069);
            int iG = c4950Hg2.g();
            String strR = AbstractC20507s76.r();
            AbstractC13042fc3.h(strR, "getVersion(...)");
            if (iG > ZI2.b(strR)) {
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar7, c10847cI6B.c()), interfaceC22053ub1J, 0);
                androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(aVar7, g10.a(interfaceC22053ub1J, i7).A(), N46.g());
                interfaceC22053ub1J.W(-1679841623);
                Object objB3 = interfaceC22053ub1J.B();
                if (objB3 == aVar6.a()) {
                    objB3 = AbstractC23831xb3.a();
                    interfaceC22053ub1J.s(objB3);
                }
                InterfaceC18507om4 interfaceC18507om4 = (InterfaceC18507om4) objB3;
                interfaceC22053ub1J.Q();
                interfaceC22053ub1J.W(-1679837679);
                boolean z2 = (i5 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
                Object objB4 = interfaceC22053ub1J.B();
                if (z2 || objB4 == aVar6.a()) {
                    objB4 = new SA2() { // from class: ir.nasim.vl5
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC23933xl5.f(sa2);
                        }
                    };
                    interfaceC22053ub1J.s(objB4);
                }
                interfaceC22053ub1J.Q();
                androidx.compose.ui.e eVarJ2 = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.e.d(eVarC, interfaceC18507om4, null, false, null, null, (SA2) objB4, 28, null), g10.c(interfaceC22053ub1J, i7).b().u(), g10.c(interfaceC22053ub1J, i7).b().g());
                InterfaceC10970cW3 interfaceC10970cW3B3 = J66.b(c24254yJ.g(), aVar4.i(), interfaceC22053ub1J, 48);
                int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ2);
                SA2 sa2A5 = aVar5.a();
                if (!(interfaceC22053ub1J.l() instanceof InterfaceC15247jG)) {
                    AbstractC6797Pa1.c();
                }
                interfaceC22053ub1J.G();
                if (interfaceC22053ub1J.h()) {
                    interfaceC22053ub1J.g(sa2A5);
                } else {
                    interfaceC22053ub1J.r();
                }
                InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub1J);
                DG7.c(interfaceC22053ub1A5, interfaceC10970cW3B3, aVar5.e());
                DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar5.g());
                InterfaceC14603iB2 interfaceC14603iB2B5 = aVar5.b();
                if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                    interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                    interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
                }
                DG7.c(interfaceC22053ub1A5, eVarE5, aVar5.f());
                AbstractC24077y03.b(FV4.c(KB5.reload, interfaceC22053ub1J, 0), null, androidx.compose.foundation.layout.t.t(aVar7, g10.c(interfaceC22053ub1J, i7).b().e()), g10.a(interfaceC22053ub1J, i7).B(), interfaceC22053ub1J, 48, 0);
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar7, g10.c(interfaceC22053ub1J, i7).b().g()), interfaceC22053ub1J, 0);
                i4 = i7;
                aVar2 = aVar7;
                AbstractC9339Zm7.b(UY6.c(QD5.premium_need_update, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i7).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i7).g(), interfaceC22053ub1J, 0, 0, 65530);
                interfaceC22053ub1J.u();
            } else {
                aVar2 = aVar7;
                i4 = i7;
            }
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, c10847cI6B.n()), interfaceC22053ub1J, 0);
            String strC = JF5.g() ? c4950Hg2.c() : c4950Hg2.a();
            int i8 = i4;
            C9348Zn7 c9348Zn7D = g10.d(interfaceC22053ub1J, i8).d();
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1J, i8).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7D.b((16744447 & 1) != 0 ? c9348Zn7D.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7D.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7D.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7D.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7D.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7D.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7D.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7D.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7D.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7D.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7D.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7D.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7D.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7D.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7D.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7D.b.h() : aVar8.f(), (16744447 & 65536) != 0 ? c9348Zn7D.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7D.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7D.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7D.c : null, (16744447 & 1048576) != 0 ? c9348Zn7D.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7D.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7D.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7D.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.wl5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23933xl5.i(c4950Hg2, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 f(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onUpdateClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    private static final Bitmap g(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (Bitmap) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(InterfaceC9102Ym4 interfaceC9102Ym4, Bitmap bitmap) {
        interfaceC9102Ym4.setValue(bitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(C4950Hg2 c4950Hg2, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c4950Hg2, "$item");
        AbstractC13042fc3.i(sa2, "$onUpdateClick");
        e(c4950Hg2, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void j(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(856643287);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            G10 g10 = G10.a;
            int i2 = G10.b;
            C10847cI6 c10847cI6B = g10.c(interfaceC22053ub1J, i2).b();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), c10847cI6B.u(), c10847cI6B.r());
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.c cVarI = aVar2.i();
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), cVarI, interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
            InterfaceC16030kb1.a aVar3 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar3.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            M66 m66 = M66.a;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.t(aVar, C17784nZ1.q(36)), N46.g()), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i2).b().u()), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(L66.b(m66, aVar, 1.0f, false, 2, null), 0.0f, c10847cI6B.u(), 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar2.k(), interfaceC22053ub1J, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarK);
            SA2 sa2A2 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(20)), C17784nZ1.q(SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER)), N46.d(g10.c(interfaceC22053ub1J, i2).a().b())), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i2).b().u()), interfaceC22053ub1J, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(FV0.a(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(18)), C17784nZ1.q(StatusLine.HTTP_PERM_REDIRECT)), N46.d(g10.c(interfaceC22053ub1J, i2).a().b())), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ul5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23933xl5.k(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        j(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void l(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-482634473);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, E71.a.a(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.tl5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC23933xl5.m(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        l(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
