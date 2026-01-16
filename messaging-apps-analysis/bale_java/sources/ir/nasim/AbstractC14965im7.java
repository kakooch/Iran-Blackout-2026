package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC21430te5;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.im7, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC14965im7 {
    private static final float a = C17784nZ1.q(20);
    private static final float b = C17784nZ1.q(10);
    private static final float c = C17784nZ1.q(2);

    /* renamed from: ir.nasim.im7$a */
    static final class a extends AbstractC8614Ws3 implements InterfaceC15796kB2 {
        final /* synthetic */ String e;
        final /* synthetic */ boolean f;
        final /* synthetic */ boolean g;
        final /* synthetic */ QY7 h;
        final /* synthetic */ InterfaceC18507om4 i;
        final /* synthetic */ boolean j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ InterfaceC10031ax6 o;
        final /* synthetic */ InterfaceC7614Sl7 p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String str, boolean z, boolean z2, QY7 qy7, InterfaceC18507om4 interfaceC18507om4, boolean z3, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7) {
            super(3);
            this.e = str;
            this.f = z;
            this.g = z2;
            this.h = qy7;
            this.i = interfaceC18507om4;
            this.j = z3;
            this.k = interfaceC14603iB2;
            this.l = interfaceC14603iB22;
            this.m = interfaceC14603iB23;
            this.n = interfaceC14603iB24;
            this.o = interfaceC10031ax6;
            this.p = interfaceC7614Sl7;
        }

        public final void a(InterfaceC14603iB2 interfaceC14603iB2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.D(interfaceC14603iB2) ? 4 : 2);
            } else {
                i2 = i;
            }
            if (!interfaceC22053ub1.o((i2 & 19) != 18, i2 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(989834338, i2, -1, "androidx.compose.material.TextField.<anonymous> (TextField.kt:377)");
            }
            C8555Wl7.a.c(this.e, interfaceC14603iB2, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, null, interfaceC22053ub1, (i2 << 3) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 24576, 8192);
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC14603iB2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.im7$b */
    static final class b extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ int A;
        final /* synthetic */ String e;
        final /* synthetic */ UA2 f;
        final /* synthetic */ androidx.compose.ui.e g;
        final /* synthetic */ boolean h;
        final /* synthetic */ boolean i;
        final /* synthetic */ C9348Zn7 j;
        final /* synthetic */ InterfaceC14603iB2 k;
        final /* synthetic */ InterfaceC14603iB2 l;
        final /* synthetic */ InterfaceC14603iB2 m;
        final /* synthetic */ InterfaceC14603iB2 n;
        final /* synthetic */ boolean o;
        final /* synthetic */ QY7 p;
        final /* synthetic */ C21605tp3 q;
        final /* synthetic */ C11329cp3 r;
        final /* synthetic */ boolean s;
        final /* synthetic */ int t;
        final /* synthetic */ int u;
        final /* synthetic */ InterfaceC18507om4 v;
        final /* synthetic */ InterfaceC10031ax6 w;
        final /* synthetic */ InterfaceC7614Sl7 x;
        final /* synthetic */ int y;
        final /* synthetic */ int z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, UA2 ua2, androidx.compose.ui.e eVar, boolean z, boolean z2, C9348Zn7 c9348Zn7, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z3, QY7 qy7, C21605tp3 c21605tp3, C11329cp3 c11329cp3, boolean z4, int i, int i2, InterfaceC18507om4 interfaceC18507om4, InterfaceC10031ax6 interfaceC10031ax6, InterfaceC7614Sl7 interfaceC7614Sl7, int i3, int i4, int i5) {
            super(2);
            this.e = str;
            this.f = ua2;
            this.g = eVar;
            this.h = z;
            this.i = z2;
            this.j = c9348Zn7;
            this.k = interfaceC14603iB2;
            this.l = interfaceC14603iB22;
            this.m = interfaceC14603iB23;
            this.n = interfaceC14603iB24;
            this.o = z3;
            this.p = qy7;
            this.q = c21605tp3;
            this.r = c11329cp3;
            this.s = z4;
            this.t = i;
            this.u = i2;
            this.v = interfaceC18507om4;
            this.w = interfaceC10031ax6;
            this.x = interfaceC7614Sl7;
            this.y = i3;
            this.z = i4;
            this.A = i5;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14965im7.a(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, interfaceC22053ub1, QJ5.a(this.y | 1), QJ5.a(this.z), this.A);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.im7$c */
    static final class c extends AbstractC8614Ws3 implements InterfaceC14603iB2 {
        final /* synthetic */ androidx.compose.ui.e e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ InterfaceC14603iB2 g;
        final /* synthetic */ InterfaceC15796kB2 h;
        final /* synthetic */ InterfaceC14603iB2 i;
        final /* synthetic */ InterfaceC14603iB2 j;
        final /* synthetic */ boolean k;
        final /* synthetic */ float l;
        final /* synthetic */ TS4 m;
        final /* synthetic */ int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z, float f, TS4 ts4, int i) {
            super(2);
            this.e = eVar;
            this.f = interfaceC14603iB2;
            this.g = interfaceC14603iB22;
            this.h = interfaceC15796kB2;
            this.i = interfaceC14603iB23;
            this.j = interfaceC14603iB24;
            this.k = z;
            this.l = f;
            this.m = ts4;
            this.n = i;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC14965im7.b(this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, interfaceC22053ub1, QJ5.a(this.n | 1));
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.im7$d */
    static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ float e;
        final /* synthetic */ C10493bi0 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(float f, C10493bi0 c10493bi0) {
            super(1);
            this.e = f;
            this.f = c10493bi0;
        }

        public final void a(InterfaceC23919xk1 interfaceC23919xk1) {
            interfaceC23919xk1.N1();
            if (C17784nZ1.s(this.e, C17784nZ1.b.a())) {
                return;
            }
            float density = this.e * interfaceC23919xk1.getDensity();
            float fG = OD6.g(interfaceC23919xk1.d()) - (density / 2);
            InterfaceC17460n02.c1(interfaceC23919xk1, this.f.a(), AbstractC10836cH4.a(0.0f, fG), AbstractC10836cH4.a(OD6.i(interfaceC23919xk1.d()), fG), density, 0, null, 0.0f, null, 0, 496, null);
        }

        @Override // ir.nasim.UA2
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((InterfaceC23919xk1) obj);
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x05b8  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:327:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(java.lang.String r71, ir.nasim.UA2 r72, androidx.compose.ui.e r73, boolean r74, boolean r75, ir.nasim.C9348Zn7 r76, ir.nasim.InterfaceC14603iB2 r77, ir.nasim.InterfaceC14603iB2 r78, ir.nasim.InterfaceC14603iB2 r79, ir.nasim.InterfaceC14603iB2 r80, boolean r81, ir.nasim.QY7 r82, ir.nasim.C21605tp3 r83, ir.nasim.C11329cp3 r84, boolean r85, int r86, int r87, ir.nasim.InterfaceC18507om4 r88, ir.nasim.InterfaceC10031ax6 r89, ir.nasim.InterfaceC7614Sl7 r90, ir.nasim.InterfaceC22053ub1 r91, int r92, int r93, int r94) {
        /*
            Method dump skipped, instructions count: 1537
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC14965im7.a(java.lang.String, ir.nasim.UA2, androidx.compose.ui.e, boolean, boolean, ir.nasim.Zn7, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, ir.nasim.iB2, boolean, ir.nasim.QY7, ir.nasim.tp3, ir.nasim.cp3, boolean, int, int, ir.nasim.om4, ir.nasim.ax6, ir.nasim.Sl7, ir.nasim.ub1, int, int, int):void");
    }

    public static final void b(androidx.compose.ui.e eVar, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, InterfaceC15796kB2 interfaceC15796kB2, InterfaceC14603iB2 interfaceC14603iB23, InterfaceC14603iB2 interfaceC14603iB24, boolean z, float f, TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        int i2;
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2112507061);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB23) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB24) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.c(f) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(ts4) ? 67108864 : 33554432;
        }
        if (interfaceC22053ub1J.o((38347923 & i2) != 38347922, i2 & 1)) {
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-2112507061, i2, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:652)");
            }
            boolean z2 = ((3670016 & i2) == 1048576) | ((29360128 & i2) == 8388608) | ((234881024 & i2) == 67108864);
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new C15555jm7(z, f, ts4);
                interfaceC22053ub1J.s(objB);
            }
            C15555jm7 c15555jm7 = (C15555jm7) objB;
            EnumC12613eu3 enumC12613eu3 = (EnumC12613eu3) interfaceC22053ub1J.H(AbstractC13040fc1.n());
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
            DG7.c(interfaceC22053ub1A, c15555jm7, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            if (interfaceC14603iB23 != null) {
                interfaceC22053ub1J.W(79117075);
                androidx.compose.ui.e eVarC = AbstractC25015zb3.c(androidx.compose.ui.layout.a.b(androidx.compose.ui.e.a, "Leading"));
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC);
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
                interfaceC14603iB23.invoke(interfaceC22053ub1J, Integer.valueOf((i2 >> 12) & 14));
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(79362130);
                interfaceC22053ub1J.Q();
            }
            if (interfaceC14603iB24 != null) {
                interfaceC22053ub1J.W(79404817);
                androidx.compose.ui.e eVarC2 = AbstractC25015zb3.c(androidx.compose.ui.layout.a.b(androidx.compose.ui.e.a, "Trailing"));
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarC2);
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
                androidx.compose.foundation.layout.h hVar2 = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB24.invoke(interfaceC22053ub1J, Integer.valueOf((i2 >> 15) & 14));
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(79651794);
                interfaceC22053ub1J.Q();
            }
            float fG = androidx.compose.foundation.layout.q.g(ts4, enumC12613eu3);
            float f2 = androidx.compose.foundation.layout.q.f(ts4, enumC12613eu3);
            e.a aVar2 = androidx.compose.ui.e.a;
            if (interfaceC14603iB23 != null) {
                i3 = 0;
                fG = C17784nZ1.q(AbstractC23053wG5.d(C17784nZ1.q(fG - AbstractC11925dm7.d()), C17784nZ1.q(0)));
            } else {
                i3 = 0;
            }
            float f3 = fG;
            if (interfaceC14603iB24 != null) {
                f2 = C17784nZ1.q(AbstractC23053wG5.d(C17784nZ1.q(f2 - AbstractC11925dm7.d()), C17784nZ1.q(i3)));
            }
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar2, f3, 0.0f, f2, 0.0f, 10, null);
            if (interfaceC15796kB2 != null) {
                interfaceC22053ub1J.W(80502775);
                interfaceC15796kB2.q(androidx.compose.ui.layout.a.b(aVar2, "Hint").i(eVarM), interfaceC22053ub1J, Integer.valueOf((i2 >> 6) & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER));
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(80590226);
                interfaceC22053ub1J.Q();
            }
            if (interfaceC14603iB22 != null) {
                interfaceC22053ub1J.W(80624729);
                androidx.compose.ui.e eVarI = androidx.compose.ui.layout.a.b(aVar2, "Label").i(eVarM);
                InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), false);
                int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
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
                androidx.compose.foundation.layout.h hVar3 = androidx.compose.foundation.layout.h.a;
                interfaceC14603iB22.invoke(interfaceC22053ub1J, Integer.valueOf((i2 >> 6) & 14));
                interfaceC22053ub1J.u();
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(80710258);
                interfaceC22053ub1J.Q();
            }
            androidx.compose.ui.e eVarI2 = androidx.compose.ui.layout.a.b(aVar2, "TextField").i(eVarM);
            InterfaceC10970cW3 interfaceC10970cW3G4 = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.o(), true);
            int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI2);
            SA2 sa2A5 = aVar.a();
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
            DG7.c(interfaceC22053ub1A5, interfaceC10970cW3G4, aVar.e());
            DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B5 = aVar.b();
            if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
            }
            DG7.c(interfaceC22053ub1A5, eVarE5, aVar.f());
            androidx.compose.foundation.layout.h hVar4 = androidx.compose.foundation.layout.h.a;
            interfaceC14603iB2.invoke(interfaceC22053ub1J, Integer.valueOf((i2 >> 3) & 14));
            interfaceC22053ub1J.u();
            interfaceC22053ub1J.u();
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.P();
            }
        } else {
            interfaceC22053ub1J.L();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new c(eVar, interfaceC14603iB2, interfaceC14603iB22, interfaceC15796kB2, interfaceC14603iB23, interfaceC14603iB24, z, f, ts4, i));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int h(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f, TS4 ts4) {
        float f2 = c * f;
        float fC = ts4.c() * f;
        float fA = ts4.a() * f;
        int iMax = Math.max(i, i5);
        return AbstractC19606qe1.f(j, Math.max(AbstractC20723sV3.d(z ? i2 + f2 + iMax + fA : fC + iMax + fA), Math.max(i3, i4)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(int i, int i2, int i3, int i4, int i5, long j) {
        return AbstractC19606qe1.g(j, i + Math.max(i3, Math.max(i4, i5)) + i2);
    }

    public static final androidx.compose.ui.e j(androidx.compose.ui.e eVar, C10493bi0 c10493bi0) {
        return androidx.compose.ui.draw.b.d(eVar, new d(c10493bi0.b(), c10493bi0));
    }

    public static final float k() {
        return a;
    }

    public static final float l() {
        return b;
    }

    public static final float m() {
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AbstractC21430te5.a aVar, int i, int i2, AbstractC21430te5 abstractC21430te5, AbstractC21430te5 abstractC21430te52, AbstractC21430te5 abstractC21430te53, AbstractC21430te5 abstractC21430te54, AbstractC21430te5 abstractC21430te55, boolean z, int i3, int i4, float f, float f2) {
        if (abstractC21430te54 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te54, 0, InterfaceC12529em.a.i().a(abstractC21430te54.A0(), i2), 0.0f, 4, null);
        }
        if (abstractC21430te55 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te55, i - abstractC21430te55.P0(), InterfaceC12529em.a.i().a(abstractC21430te55.A0(), i2), 0.0f, 4, null);
        }
        if (abstractC21430te52 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te52, AbstractC11925dm7.h(abstractC21430te54), (z ? InterfaceC12529em.a.i().a(abstractC21430te52.A0(), i2) : AbstractC20723sV3.d(AbstractC11925dm7.f() * f2)) - AbstractC20723sV3.d((r0 - i3) * f), 0.0f, 4, null);
        }
        AbstractC21430te5.a.l(aVar, abstractC21430te5, AbstractC11925dm7.h(abstractC21430te54), i4, 0.0f, 4, null);
        if (abstractC21430te53 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te53, AbstractC11925dm7.h(abstractC21430te54), i4, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(AbstractC21430te5.a aVar, int i, int i2, AbstractC21430te5 abstractC21430te5, AbstractC21430te5 abstractC21430te52, AbstractC21430te5 abstractC21430te53, AbstractC21430te5 abstractC21430te54, boolean z, float f, TS4 ts4) {
        int iD = AbstractC20723sV3.d(ts4.c() * f);
        if (abstractC21430te53 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te53, 0, InterfaceC12529em.a.i().a(abstractC21430te53.A0(), i2), 0.0f, 4, null);
        }
        if (abstractC21430te54 != null) {
            AbstractC21430te5.a.l(aVar, abstractC21430te54, i - abstractC21430te54.P0(), InterfaceC12529em.a.i().a(abstractC21430te54.A0(), i2), 0.0f, 4, null);
        }
        AbstractC21430te5.a.l(aVar, abstractC21430te5, AbstractC11925dm7.h(abstractC21430te53), z ? InterfaceC12529em.a.i().a(abstractC21430te5.A0(), i2) : iD, 0.0f, 4, null);
        if (abstractC21430te52 != null) {
            if (z) {
                iD = InterfaceC12529em.a.i().a(abstractC21430te52.A0(), i2);
            }
            AbstractC21430te5.a.l(aVar, abstractC21430te52, AbstractC11925dm7.h(abstractC21430te53), iD, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int p(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : i - i2;
    }
}
