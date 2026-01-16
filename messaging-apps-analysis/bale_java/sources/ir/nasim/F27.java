package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import ir.nasim.AbstractC21071t37;
import ir.nasim.InterfaceC16030kb1;

/* loaded from: classes.dex */
public abstract class F27 {
    private static final AbstractC6535Nx5 a = AbstractC11024cc1.d(null, d.e, 1, null);

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC10031ax6 f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ C10493bi0 i;
        final /* synthetic */ float j;
        final /* synthetic */ InterfaceC14603iB2 k;

        /* renamed from: ir.nasim.F27$a$a, reason: collision with other inner class name */
        static final class C0353a extends AbstractC8614Ws3 implements UA2 {
            public static final C0353a e = new C0353a();

            C0353a() {
                super(1);
            }

            public final void a(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC9939ao6.c0(interfaceC11943do6, true);
            }

            @Override // ir.nasim.UA2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                a((InterfaceC11943do6) obj);
                return C19938rB7.a;
            }
        }

        static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;

            b(InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new b(interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC9049Yg5 interfaceC9049Yg5, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((b) create(interfaceC9049Yg5, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, float f, C10493bi0 c10493bi0, float f2, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC10031ax6;
            this.g = j;
            this.h = f;
            this.i = c10493bi0;
            this.j = f2;
            this.k = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-70914509, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:108)");
            }
            androidx.compose.ui.e eVarI = AbstractC6919Pn6.c(F27.f(this.e, this.f, F27.g(this.g, this.h, interfaceC22053ub1, 0), this.i, ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.j)), false, C0353a.e).i(new SuspendPointerInputElement(C19938rB7.a, null, null, new AbstractC21071t37.a(new b(null)), 6, null));
            InterfaceC14603iB2 interfaceC14603iB2 = this.k;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), true);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
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
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC10031ax6 f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ C10493bi0 i;
        final /* synthetic */ InterfaceC18507om4 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ SA2 l;
        final /* synthetic */ float m;
        final /* synthetic */ InterfaceC14603iB2 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, float f, C10493bi0 c10493bi0, InterfaceC18507om4 interfaceC18507om4, boolean z, SA2 sa2, float f2, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC10031ax6;
            this.g = j;
            this.h = f;
            this.i = c10493bi0;
            this.j = interfaceC18507om4;
            this.k = z;
            this.l = sa2;
            this.m = f2;
            this.n = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(1279702876, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:209)");
            }
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(F27.f(AbstractC3248Ab3.b(this.e), this.f, F27.g(this.g, this.h, interfaceC22053ub1, 0), this.i, ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.m)), this.j, androidx.compose.material3.a.e(false, 0.0f, 0L, interfaceC22053ub1, 0, 7), this.k, null, null, this.l, 24, null);
            InterfaceC14603iB2 interfaceC14603iB2 = this.n;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), true);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
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

    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC10031ax6 f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ C10493bi0 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC18507om4 k;
        final /* synthetic */ boolean l;
        final /* synthetic */ SA2 m;
        final /* synthetic */ float n;
        final /* synthetic */ InterfaceC14603iB2 o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, float f, C10493bi0 c10493bi0, boolean z, InterfaceC18507om4 interfaceC18507om4, boolean z2, SA2 sa2, float f2, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC10031ax6;
            this.g = j;
            this.h = f;
            this.i = c10493bi0;
            this.j = z;
            this.k = interfaceC18507om4;
            this.l = z2;
            this.m = sa2;
            this.n = f2;
            this.o = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1164547968, i, -1, "androidx.compose.material3.Surface.<anonymous> (Surface.kt:312)");
            }
            androidx.compose.ui.e eVarB = androidx.compose.foundation.selection.a.b(F27.f(AbstractC3248Ab3.b(this.e), this.f, F27.g(this.g, this.h, interfaceC22053ub1, 0), this.i, ((WH1) interfaceC22053ub1.H(AbstractC13040fc1.g())).w1(this.n)), this.j, this.k, androidx.compose.material3.a.e(false, 0.0f, 0L, interfaceC22053ub1, 0, 7), this.l, null, this.m, 16, null);
            InterfaceC14603iB2 interfaceC14603iB2 = this.o;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), true);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarB);
            InterfaceC16030kb1.a aVar = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1, 0);
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

    static final class d extends AbstractC8614Ws3 implements SA2 {
        public static final d e = new d();

        d() {
            super(0);
        }

        public final float a() {
            return C17784nZ1.q(0);
        }

        @Override // ir.nasim.SA2
        public /* bridge */ /* synthetic */ Object invoke() {
            return C17784nZ1.j(a());
        }
    }

    public static final void a(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, float f, float f2, C10493bi0 c10493bi0, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2) {
        androidx.compose.ui.e eVar2 = (i2 & 1) != 0 ? androidx.compose.ui.e.a : eVar;
        InterfaceC10031ax6 interfaceC10031ax6A = (i2 & 2) != 0 ? MK5.a() : interfaceC10031ax6;
        long jH = (i2 & 4) != 0 ? C15386jV3.a.a(interfaceC22053ub1, 6).H() : j;
        long jC = (i2 & 8) != 0 ? ZX0.c(jH, interfaceC22053ub1, (i >> 6) & 14) : j2;
        float fQ = (i2 & 16) != 0 ? C17784nZ1.q(0) : f;
        float fQ2 = (i2 & 32) != 0 ? C17784nZ1.q(0) : f2;
        C10493bi0 c10493bi02 = (i2 & 64) != 0 ? null : c10493bi0;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-513881741, i, -1, "androidx.compose.material3.Surface (Surface.kt:102)");
        }
        AbstractC6535Nx5 abstractC6535Nx5 = a;
        float fQ3 = C17784nZ1.q(((C17784nZ1) interfaceC22053ub1.H(abstractC6535Nx5)).v() + fQ);
        AbstractC11024cc1.b(new C7252Qx5[]{AbstractC21553tk1.a().d(C24381yX0.k(jC)), abstractC6535Nx5.d(C17784nZ1.j(fQ3))}, AbstractC19242q11.e(-70914509, true, new a(eVar2, interfaceC10031ax6A, jH, fQ3, c10493bi02, fQ2, interfaceC14603iB2), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void b(boolean z, SA2 sa2, androidx.compose.ui.e eVar, boolean z2, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, float f, float f2, C10493bi0 c10493bi0, InterfaceC18507om4 interfaceC18507om4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3) {
        androidx.compose.ui.e eVar2 = (i3 & 4) != 0 ? androidx.compose.ui.e.a : eVar;
        boolean z3 = (i3 & 8) != 0 ? true : z2;
        InterfaceC10031ax6 interfaceC10031ax6A = (i3 & 16) != 0 ? MK5.a() : interfaceC10031ax6;
        long jH = (i3 & 32) != 0 ? C15386jV3.a.a(interfaceC22053ub1, 6).H() : j;
        long jC = (i3 & 64) != 0 ? ZX0.c(jH, interfaceC22053ub1, (i >> 15) & 14) : j2;
        float fQ = (i3 & 128) != 0 ? C17784nZ1.q(0) : f;
        float fQ2 = (i3 & 256) != 0 ? C17784nZ1.q(0) : f2;
        C10493bi0 c10493bi02 = (i3 & 512) != 0 ? null : c10493bi0;
        InterfaceC18507om4 interfaceC18507om42 = (i3 & 1024) != 0 ? null : interfaceC18507om4;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(540296512, i, i2, "androidx.compose.material3.Surface (Surface.kt:306)");
        }
        AbstractC6535Nx5 abstractC6535Nx5 = a;
        float fQ3 = C17784nZ1.q(((C17784nZ1) interfaceC22053ub1.H(abstractC6535Nx5)).v() + fQ);
        AbstractC11024cc1.b(new C7252Qx5[]{AbstractC21553tk1.a().d(C24381yX0.k(jC)), abstractC6535Nx5.d(C17784nZ1.j(fQ3))}, AbstractC19242q11.e(-1164547968, true, new c(eVar2, interfaceC10031ax6A, jH, fQ3, c10493bi02, z, interfaceC18507om42, z3, sa2, fQ2, interfaceC14603iB2), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    public static final void c(SA2 sa2, androidx.compose.ui.e eVar, boolean z, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, float f, float f2, C10493bi0 c10493bi0, InterfaceC18507om4 interfaceC18507om4, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i, int i2, int i3) {
        androidx.compose.ui.e eVar2 = (i3 & 2) != 0 ? androidx.compose.ui.e.a : eVar;
        boolean z2 = (i3 & 4) != 0 ? true : z;
        InterfaceC10031ax6 interfaceC10031ax6A = (i3 & 8) != 0 ? MK5.a() : interfaceC10031ax6;
        long jH = (i3 & 16) != 0 ? C15386jV3.a.a(interfaceC22053ub1, 6).H() : j;
        long jC = (i3 & 32) != 0 ? ZX0.c(jH, interfaceC22053ub1, (i >> 12) & 14) : j2;
        float fQ = (i3 & 64) != 0 ? C17784nZ1.q(0) : f;
        float fQ2 = (i3 & 128) != 0 ? C17784nZ1.q(0) : f2;
        C10493bi0 c10493bi02 = (i3 & 256) != 0 ? null : c10493bi0;
        InterfaceC18507om4 interfaceC18507om42 = (i3 & 512) == 0 ? interfaceC18507om4 : null;
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-789752804, i, i2, "androidx.compose.material3.Surface (Surface.kt:203)");
        }
        AbstractC6535Nx5 abstractC6535Nx5 = a;
        float fQ3 = C17784nZ1.q(((C17784nZ1) interfaceC22053ub1.H(abstractC6535Nx5)).v() + fQ);
        AbstractC11024cc1.b(new C7252Qx5[]{AbstractC21553tk1.a().d(C24381yX0.k(jC)), abstractC6535Nx5.d(C17784nZ1.j(fQ3))}, AbstractC19242q11.e(1279702876, true, new b(eVar2, interfaceC10031ax6A, jH, fQ3, c10493bi02, interfaceC18507om42, z2, sa2, fQ2, interfaceC14603iB2), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.e f(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, C10493bi0 c10493bi0, float f) {
        InterfaceC10031ax6 interfaceC10031ax62;
        androidx.compose.ui.e eVarE;
        androidx.compose.ui.e eVarI = eVar.i(f > 0.0f ? androidx.compose.ui.graphics.b.c(androidx.compose.ui.e.a, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f, 0.0f, 0.0f, 0.0f, 0.0f, 0L, interfaceC10031ax6, false, null, 0L, 0L, 0, 124895, null) : androidx.compose.ui.e.a);
        if (c10493bi0 != null) {
            interfaceC10031ax62 = interfaceC10031ax6;
            eVarE = AbstractC9287Zh0.e(androidx.compose.ui.e.a, c10493bi0, interfaceC10031ax62);
        } else {
            interfaceC10031ax62 = interfaceC10031ax6;
            eVarE = androidx.compose.ui.e.a;
        }
        return FV0.a(androidx.compose.foundation.b.c(eVarI.i(eVarE), j, interfaceC10031ax62), interfaceC10031ax62);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long g(long j, float f, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(-2079918090, i, -1, "androidx.compose.material3.surfaceColorAtElevation (Surface.kt:465)");
        }
        int i2 = i << 3;
        long jA = ZX0.a(C15386jV3.a.a(interfaceC22053ub1, 6), j, f, interfaceC22053ub1, (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i2 & 896));
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return jA;
    }
}
