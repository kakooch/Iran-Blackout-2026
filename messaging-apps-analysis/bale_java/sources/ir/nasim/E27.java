package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import ir.nasim.AbstractC21071t37;
import ir.nasim.InterfaceC16030kb1;

/* loaded from: classes.dex */
public abstract class E27 {

    static final class a extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC10031ax6 f;
        final /* synthetic */ long g;
        final /* synthetic */ float h;
        final /* synthetic */ C10493bi0 i;
        final /* synthetic */ float j;
        final /* synthetic */ InterfaceC14603iB2 k;

        /* renamed from: ir.nasim.E27$a$a, reason: collision with other inner class name */
        static final class C0335a extends AbstractC8614Ws3 implements UA2 {
            public static final C0335a e = new C0335a();

            C0335a() {
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
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-1822160838, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:108)");
            }
            androidx.compose.ui.e eVarI = AbstractC6919Pn6.c(E27.e(this.e, this.f, E27.f(this.g, (G52) interfaceC22053ub1.H(H52.d()), this.h, interfaceC22053ub1, 0), this.i, this.j), false, C0335a.e).i(new SuspendPointerInputElement(C19938rB7.a, null, null, new AbstractC21071t37.a(new b(null)), 6, null));
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
        final /* synthetic */ long h;
        final /* synthetic */ C10493bi0 i;
        final /* synthetic */ float j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ int l;
        final /* synthetic */ int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, C10493bi0 c10493bi0, float f, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC10031ax6;
            this.g = j;
            this.h = j2;
            this.i = c10493bi0;
            this.j = f;
            this.k = interfaceC14603iB2;
            this.l = i;
            this.m = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            E27.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, interfaceC22053ub1, QJ5.a(this.l | 1), this.m);
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
        final /* synthetic */ float j;
        final /* synthetic */ InterfaceC18507om4 k;
        final /* synthetic */ boolean l;
        final /* synthetic */ SA2 m;
        final /* synthetic */ InterfaceC14603iB2 n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, float f, C10493bi0 c10493bi0, float f2, InterfaceC18507om4 interfaceC18507om4, boolean z, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2) {
            super(2);
            this.e = eVar;
            this.f = interfaceC10031ax6;
            this.g = j;
            this.h = f;
            this.i = c10493bi0;
            this.j = f2;
            this.k = interfaceC18507om4;
            this.l = z;
            this.m = sa2;
            this.n = interfaceC14603iB2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if (!interfaceC22053ub1.o((i & 3) != 2, i & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(2031491085, i, -1, "androidx.compose.material.Surface.<anonymous> (Surface.kt:214)");
            }
            androidx.compose.ui.e eVarD = androidx.compose.foundation.e.d(E27.e(AbstractC25015zb3.c(this.e), this.f, E27.f(this.g, (G52) interfaceC22053ub1.H(H52.d()), this.h, interfaceC22053ub1, 0), this.i, this.j), this.k, androidx.compose.material.a.f(false, 0.0f, 0L, 7, null), this.l, null, null, this.m, 24, null);
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

    static final class d extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 e;
        final /* synthetic */ androidx.compose.ui.e f;
        final /* synthetic */ boolean g;
        final /* synthetic */ InterfaceC10031ax6 h;
        final /* synthetic */ long i;
        final /* synthetic */ long j;
        final /* synthetic */ C10493bi0 k;
        final /* synthetic */ float l;
        final /* synthetic */ InterfaceC18507om4 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ int o;
        final /* synthetic */ int p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(SA2 sa2, androidx.compose.ui.e eVar, boolean z, InterfaceC10031ax6 interfaceC10031ax6, long j, long j2, C10493bi0 c10493bi0, float f, InterfaceC18507om4 interfaceC18507om4, InterfaceC14603iB2 interfaceC14603iB2, int i, int i2) {
            super(2);
            this.e = sa2;
            this.f = eVar;
            this.g = z;
            this.h = interfaceC10031ax6;
            this.i = j;
            this.j = j2;
            this.k = c10493bi0;
            this.l = f;
            this.m = interfaceC18507om4;
            this.n = interfaceC14603iB2;
            this.o = i;
            this.p = i2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            E27.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, interfaceC22053ub1, QJ5.a(this.o | 1), this.p);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(androidx.compose.ui.e r26, ir.nasim.InterfaceC10031ax6 r27, long r28, long r30, ir.nasim.C10493bi0 r32, float r33, ir.nasim.InterfaceC14603iB2 r34, ir.nasim.InterfaceC22053ub1 r35, int r36, int r37) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.E27.a(androidx.compose.ui.e, ir.nasim.ax6, long, long, ir.nasim.bi0, float, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void b(ir.nasim.SA2 r29, androidx.compose.ui.e r30, boolean r31, ir.nasim.InterfaceC10031ax6 r32, long r33, long r35, ir.nasim.C10493bi0 r37, float r38, ir.nasim.InterfaceC18507om4 r39, ir.nasim.InterfaceC14603iB2 r40, ir.nasim.InterfaceC22053ub1 r41, int r42, int r43) {
        /*
            Method dump skipped, instructions count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.E27.b(ir.nasim.SA2, androidx.compose.ui.e, boolean, ir.nasim.ax6, long, long, ir.nasim.bi0, float, ir.nasim.om4, ir.nasim.iB2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final androidx.compose.ui.e e(androidx.compose.ui.e eVar, InterfaceC10031ax6 interfaceC10031ax6, long j, C10493bi0 c10493bi0, float f) {
        return FV0.a(androidx.compose.foundation.b.c(AbstractC6033Lw6.b(eVar, f, interfaceC10031ax6, false, 0L, 0L, 24, null).i(c10493bi0 != null ? AbstractC9287Zh0.e(androidx.compose.ui.e.a, c10493bi0, interfaceC10031ax6) : androidx.compose.ui.e.a), j, interfaceC10031ax6), interfaceC10031ax6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long f(long j, G52 g52, float f, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.Q(1561611256, i, -1, "androidx.compose.material.surfaceColorAtElevation (Surface.kt:480)");
        }
        if (!C24381yX0.q(j, C15977kV3.a.a(interfaceC22053ub1, 6).n()) || g52 == null) {
            interfaceC22053ub1.W(1082990783);
            interfaceC22053ub1.Q();
        } else {
            interfaceC22053ub1.W(1082922676);
            j = g52.a(j, f, interfaceC22053ub1, (i & 14) | ((i >> 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | ((i << 3) & 896));
            interfaceC22053ub1.Q();
        }
        if (AbstractC5138Ib1.I()) {
            AbstractC5138Ib1.P();
        }
        return j;
    }
}
