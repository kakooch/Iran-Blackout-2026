package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.content.res.Resources;
import android.gov.nist.javax.sip.parser.TokenNames;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC14472hy4;
import ir.nasim.AbstractC20510s8;
import ir.nasim.AbstractC24153y8;
import ir.nasim.G8;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.y8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC24153y8 {

    /* renamed from: ir.nasim.y8$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ UA2 a;

        /* renamed from: ir.nasim.y8$a$a, reason: collision with other inner class name */
        static final class C1776a implements InterfaceC14603iB2 {
            final /* synthetic */ UA2 a;

            C1776a(UA2 ua2) {
                this.a = ua2;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 c(UA2 ua2) {
                AbstractC13042fc3.i(ua2, "$handleUiAction");
                ua2.invoke(G8.b.a);
                return C19938rB7.a;
            }

            public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-406980941);
                boolean zV = interfaceC22053ub1.V(this.a);
                final UA2 ua2 = this.a;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.x8
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC24153y8.a.C1776a.c(ua2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC20434s03.a((SA2) objB, null, false, null, null, C24085y11.a.b(), interfaceC22053ub1, 196608, 30);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(UA2 ua2) {
            this.a = ua2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.h(C24085y11.a.a(), null, AbstractC19242q11.e(-1257617240, true, new C1776a(this.a), interfaceC22053ub1, 54), null, null, null, null, interfaceC22053ub1, 390, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.y8$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ I8 a;
        final /* synthetic */ UA2 b;
        final /* synthetic */ androidx.navigation.e c;
        final /* synthetic */ androidx.compose.ui.focus.m d;
        final /* synthetic */ InterfaceC9102Ym4 e;
        final /* synthetic */ InterfaceC9664aL6 f;
        final /* synthetic */ InterfaceC9664aL6 g;

        b(I8 i8, UA2 ua2, androidx.navigation.e eVar, androidx.compose.ui.focus.m mVar, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC9664aL6 interfaceC9664aL62) {
            this.a = i8;
            this.b = ua2;
            this.c = eVar;
            this.d = mVar;
            this.e = interfaceC9102Ym4;
            this.f = interfaceC9664aL6;
            this.g = interfaceC9664aL62;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(UA2 ua2, String str) {
            AbstractC13042fc3.i(ua2, "$handleUiAction");
            AbstractC13042fc3.i(str, "it");
            ua2.invoke(new G8.d(str));
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(eVar, "$navController");
            androidx.navigation.e.S(eVar, AbstractC20510s8.b.a.a(), null, null, 6, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(I8 i8, UA2 ua2, String str) {
            AbstractC13042fc3.i(i8, "$uiState");
            AbstractC13042fc3.i(ua2, "$handleUiAction");
            AbstractC13042fc3.i(str, "newValue");
            String strB = AbstractC12152e76.b(str);
            String strD = i8.f().d();
            if (strD != null) {
                int i = 0;
                for (int i2 = 0; i2 < strD.length(); i2++) {
                    if (strD.charAt(i2) == 'X') {
                        i++;
                    }
                }
                ua2.invoke(new G8.e(AbstractC22039uZ6.A1(strB, i)));
            } else {
                ua2.invoke(new G8.e(strB));
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(androidx.navigation.e eVar) throws Resources.NotFoundException {
            AbstractC13042fc3.i(eVar, "$navController");
            androidx.navigation.e.S(eVar, AbstractC20510s8.b.a.a(), null, null, 6, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(UA2 ua2) {
            AbstractC13042fc3.i(ua2, "$handleUiAction");
            ua2.invoke(G8.a.a);
            return C19938rB7.a;
        }

        public final void h(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(586956299);
            if (this.a.g()) {
                CG3.g(null, null, new C18876pP1(false, false, false, 7, (ED1) null), interfaceC22053ub1, 384, 3);
            }
            interfaceC22053ub1.Q();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC12529em.b bVarG = aVar2.g();
            final I8 i8 = this.a;
            final UA2 ua2 = this.b;
            final androidx.navigation.e eVar = this.c;
            androidx.compose.ui.focus.m mVar = this.d;
            InterfaceC9102Ym4 interfaceC9102Ym4 = this.e;
            InterfaceC9664aL6 interfaceC9664aL6 = this.f;
            InterfaceC9664aL6 interfaceC9664aL62 = this.g;
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), bVarG, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.ui.e eVarB = ZY0.b(C9784aZ0.a, aVar, 1.0f, false, 2, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(eVarB, g10.c(interfaceC22053ub1, i3).b().e());
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.q(g10.c(interfaceC22053ub1, i3).b().e(), aVar2.l()), aVar2.g(), interfaceC22053ub1, 48);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
            SA2 sa2A2 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A2, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            String strC = i8.c();
            String strC2 = UY6.c(ED5.contact_name, interfaceC22053ub1, 0);
            String strC3 = UY6.c(ED5.enter_contact_name, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-2000198680);
            boolean zV = interfaceC22053ub1.V(ua2);
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.z8
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC24153y8.b.i(ua2, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.e0(strC, (UA2) objB, strC2, strC3, eVarH, null, false, false, null, null, null, null, null, true, 0, 0, null, null, false, false, null, false, interfaceC22053ub1, 24576, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 4186080);
            String strC4 = i8.f().c();
            String strA = i8.f().a();
            String strB = i8.f().b();
            interfaceC22053ub1.W(-2000179288);
            boolean zD = interfaceC22053ub1.D(eVar);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.A8
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24153y8.b.k(eVar);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC18534op1.h(null, strC4, strA, strB, (SA2) objB2, interfaceC22053ub1, 0, 1);
            String strA2 = i8.f().a();
            String strD = i8.d();
            String strF = AbstractC24153y8.f(interfaceC9102Ym4);
            AbstractC14472hy4 abstractC14472hy4I = AbstractC24153y8.i(interfaceC9664aL6);
            interfaceC22053ub1.W(-2000169280);
            boolean zD2 = interfaceC22053ub1.D(i8) | interfaceC22053ub1.V(ua2);
            Object objB3 = interfaceC22053ub1.B();
            if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.B8
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC24153y8.b.n(i8, ua2, (String) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            UA2 ua22 = (UA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-2000143352);
            boolean zD3 = interfaceC22053ub1.D(eVar);
            Object objB4 = interfaceC22053ub1.B();
            if (zD3 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.C8
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24153y8.b.o(eVar);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            AbstractC8426Vx4.A(null, strD, ua22, strA2, strF, true, 0, 0, false, abstractC14472hy4I, mVar, (SA2) objB4, null, false, interfaceC22053ub1, (AbstractC14472hy4.a << 27) | 196608, 6, 12737);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarI2 = AbstractC18394ob1.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.a(interfaceC22053ub1, i3).A(), 0.0f, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI2);
            SA2 sa2A3 = aVar3.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar3.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarI3 = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), g10.c(interfaceC22053ub1, i3).b().e());
            String strC5 = UY6.c(ED5.add_contact, interfaceC22053ub1, 0);
            InterfaceC19114po0 interfaceC19114po0K = AbstractC24153y8.k(interfaceC9664aL62);
            interfaceC22053ub1.W(-2000125679);
            boolean zV2 = interfaceC22053ub1.V(ua2);
            Object objB5 = interfaceC22053ub1.B();
            if (zV2 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new SA2() { // from class: ir.nasim.D8
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24153y8.b.p(ua2);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.y(eVarI3, (SA2) objB5, interfaceC19114po0K, null, strC5, null, interfaceC22053ub1, 0, 40);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            h((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void e(final androidx.navigation.e eVar, final I8 i8, final UA2 ua2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        String strK;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(i8, "uiState");
        AbstractC13042fc3.i(ua2, "handleUiAction");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-683656734);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(eVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(i8) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            final Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            C13788gp1 c13788gp1F = i8.f();
            interfaceC22053ub1J.W(1632192627);
            boolean zV = interfaceC22053ub1J.V(c13788gp1F);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                String strD = i8.f().d();
                if (strD == null || (strK = AbstractC20153rZ6.K(strD, TokenNames.X, "_ ", true)) == null) {
                    strK = "";
                }
                objB = AbstractC13472gH6.d(strK, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            String strD2 = i8.d();
            C13788gp1 c13788gp1F2 = i8.f();
            interfaceC22053ub1J.W(1632203049);
            boolean zV2 = interfaceC22053ub1J.V(strD2) | interfaceC22053ub1J.V(c13788gp1F2);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.u8
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24153y8.h(i8, context);
                    }
                });
                interfaceC22053ub1J.s(objB2);
            }
            final InterfaceC9664aL6 interfaceC9664aL6 = (InterfaceC9664aL6) objB2;
            interfaceC22053ub1J.Q();
            String strC = i8.c();
            String strD3 = i8.d();
            AbstractC14472hy4 abstractC14472hy4I = i(interfaceC9664aL6);
            interfaceC22053ub1J.W(1632238907);
            boolean zV3 = interfaceC22053ub1J.V(strC) | interfaceC22053ub1J.V(strD3) | interfaceC22053ub1J.V(abstractC14472hy4I);
            Object objB3 = interfaceC22053ub1J.B();
            if (zV3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = AbstractC10222bH6.d(new SA2() { // from class: ir.nasim.v8
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC24153y8.j(i8, interfaceC9664aL6);
                    }
                });
                interfaceC22053ub1J.s(objB3);
            }
            InterfaceC9664aL6 interfaceC9664aL62 = (InterfaceC9664aL6) objB3;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1632252416);
            Object objB4 = interfaceC22053ub1J.B();
            if (objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new androidx.compose.ui.focus.m();
                interfaceC22053ub1J.s(objB4);
            }
            androidx.compose.ui.focus.m mVar = (androidx.compose.ui.focus.m) objB4;
            interfaceC22053ub1J.Q();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(-205459546, true, new a(ua2), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-1099233999, true, new b(i8, ua2, eVar, mVar, interfaceC9102Ym4, interfaceC9664aL6, interfaceC9664aL62), interfaceC22053ub1J, 54), interfaceC22053ub12, 805306422, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.w8
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24153y8.g(eVar, i8, ua2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g(androidx.navigation.e eVar, I8 i8, UA2 ua2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(eVar, "$navController");
        AbstractC13042fc3.i(i8, "$uiState");
        AbstractC13042fc3.i(ua2, "$handleUiAction");
        e(eVar, i8, ua2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC14472hy4 h(I8 i8, Context context) {
        AbstractC13042fc3.i(i8, "$uiState");
        AbstractC13042fc3.i(context, "$context");
        if (i8.f().d() == null) {
            if (i8.d().length() > 13) {
                return new AbstractC14472hy4.a(Integer.valueOf(AbstractC15799kB5.danger), context.getString(ED5.phone_number_is_wrong), null, 4, null);
            }
            return new AbstractC14472hy4.d(null, null, null, 7, null);
        }
        int length = i8.d().length();
        if (length != 0) {
            String strD = i8.f().d();
            int i = 0;
            for (int i2 = 0; i2 < strD.length(); i2++) {
                if (strD.charAt(i2) == 'X') {
                    i++;
                }
            }
            if (length < i) {
                return new AbstractC14472hy4.a(Integer.valueOf(AbstractC15799kB5.danger), context.getString(ED5.phone_number_is_wrong), null, 4, null);
            }
        }
        return new AbstractC14472hy4.d(null, null, null, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AbstractC14472hy4 i(InterfaceC9664aL6 interfaceC9664aL6) {
        return (AbstractC14472hy4) interfaceC9664aL6.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final ir.nasim.InterfaceC19114po0 j(ir.nasim.I8 r1, ir.nasim.InterfaceC9664aL6 r2) {
        /*
            java.lang.String r0 = "$uiState"
            ir.nasim.AbstractC13042fc3.i(r1, r0)
            java.lang.String r0 = "$phoneNumberTextFieldState$delegate"
            ir.nasim.AbstractC13042fc3.i(r2, r0)
            java.lang.String r0 = r1.c()
            java.lang.String r1 = r1.d()
            java.lang.String[] r1 = new java.lang.String[]{r0, r1}
            java.util.List r1 = ir.nasim.ZW0.p(r1)
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L2a
            r0 = r1
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L2a
            goto L41
        L2a:
            java.util.Iterator r1 = r1.iterator()
        L2e:
            boolean r0 = r1.hasNext()
            if (r0 == 0) goto L41
            java.lang.Object r0 = r1.next()
            java.lang.String r0 = (java.lang.String) r0
            boolean r0 = ir.nasim.AbstractC14836iZ6.n0(r0)
            if (r0 == 0) goto L2e
            goto L49
        L41:
            ir.nasim.hy4 r1 = i(r2)
            boolean r1 = r1 instanceof ir.nasim.AbstractC14472hy4.d
            if (r1 != 0) goto L4c
        L49:
            ir.nasim.po0$a$a r1 = ir.nasim.InterfaceC19114po0.a.C1453a.a
            goto L4e
        L4c:
            ir.nasim.po0$b$a r1 = ir.nasim.InterfaceC19114po0.b.a.a
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC24153y8.j(ir.nasim.I8, ir.nasim.aL6):ir.nasim.po0");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC19114po0 k(InterfaceC9664aL6 interfaceC9664aL6) {
        return (InterfaceC19114po0) interfaceC9664aL6.getValue();
    }

    public static final void l(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(800085272);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C24085y11.a.c(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.t8
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC24153y8.m(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
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
