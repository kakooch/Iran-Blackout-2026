package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC10940cT0;
import ir.nasim.AbstractC24975zX0;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import java.util.List;

/* renamed from: ir.nasim.cT0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC10940cT0 {

    /* renamed from: ir.nasim.cT0$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ InterfaceC9102Ym4 a;
        final /* synthetic */ String b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ androidx.navigation.e d;

        /* renamed from: ir.nasim.cT0$a$a, reason: collision with other inner class name */
        static final class C0936a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9102Ym4 a;
            final /* synthetic */ String b;
            final /* synthetic */ UA2 c;
            final /* synthetic */ androidx.navigation.e d;

            /* renamed from: ir.nasim.cT0$a$a$a, reason: collision with other inner class name */
            static final class C0937a implements InterfaceC14603iB2 {
                final /* synthetic */ InterfaceC9102Ym4 a;
                final /* synthetic */ String b;
                final /* synthetic */ UA2 c;

                /* renamed from: ir.nasim.cT0$a$a$a$a, reason: collision with other inner class name */
                static final class C0938a implements InterfaceC14603iB2 {
                    final /* synthetic */ String a;
                    final /* synthetic */ UA2 b;

                    C0938a(String str, UA2 ua2) {
                        this.a = str;
                        this.b = ua2;
                    }

                    public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                        if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                            interfaceC22053ub1.L();
                        } else {
                            AbstractC16075kf6.j(UY6.c(AbstractC24206yD5.search_hint_chat, interfaceC22053ub1, 0), this.a, this.b, true, null, null, true, null, null, null, null, interfaceC22053ub1, 1575936, 0, 1968);
                        }
                    }

                    @Override // ir.nasim.InterfaceC14603iB2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                        a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                        return C19938rB7.a;
                    }
                }

                C0937a(InterfaceC9102Ym4 interfaceC9102Ym4, String str, UA2 ua2) {
                    this.a = interfaceC9102Ym4;
                    this.b = str;
                    this.c = ua2;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC10940cT0.f(this.a)) {
                        interfaceC22053ub1.W(1992694764);
                        AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(-993076288, true, new C0938a(this.b, this.c), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    interfaceC22053ub1.W(1992289470);
                    String strC = UY6.c(AbstractC24206yD5.select_country_code, interfaceC22053ub1, 0);
                    G10 g10 = G10.a;
                    int i2 = G10.b;
                    AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1, i2).D(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65018);
                    interfaceC22053ub1.Q();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.cT0$a$a$b */
            static final class b implements InterfaceC14603iB2 {
                final /* synthetic */ InterfaceC9102Ym4 a;
                final /* synthetic */ UA2 b;
                final /* synthetic */ androidx.navigation.e c;

                b(InterfaceC9102Ym4 interfaceC9102Ym4, UA2 ua2, androidx.navigation.e eVar) {
                    this.a = interfaceC9102Ym4;
                    this.b = ua2;
                    this.c = eVar;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(UA2 ua2, androidx.navigation.e eVar, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(ua2, "$onChangeQuery");
                    AbstractC13042fc3.i(eVar, "$navController");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$isSearchMode$delegate");
                    if (AbstractC10940cT0.f(interfaceC9102Ym4)) {
                        ua2.invoke("");
                        AbstractC10940cT0.g(interfaceC9102Ym4, false);
                    } else {
                        eVar.V();
                    }
                    return C19938rB7.a;
                }

                public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    interfaceC22053ub1.W(2003966635);
                    boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.c);
                    final UA2 ua2 = this.b;
                    final androidx.navigation.e eVar = this.c;
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.eT0
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC10940cT0.a.C0936a.b.c(ua2, eVar, interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20434s03.a((SA2) objB, null, false, null, null, C16898m31.a.a(), interfaceC22053ub1, 196608, 30);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            /* renamed from: ir.nasim.cT0$a$a$c */
            static final class c implements InterfaceC15796kB2 {
                final /* synthetic */ InterfaceC9102Ym4 a;

                c(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = interfaceC9102Ym4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$isSearchMode$delegate");
                    AbstractC10940cT0.g(interfaceC9102Ym4, true);
                    return C19938rB7.a;
                }

                public final void b(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(l66, "$this$CenterAlignedTopAppBar");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    if (AbstractC10940cT0.f(this.a)) {
                        return;
                    }
                    interfaceC22053ub1.W(2003997488);
                    boolean zV = interfaceC22053ub1.V(this.a);
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.a;
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.fT0
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC10940cT0.a.C0936a.c.c(interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20434s03.a((SA2) objB, null, false, null, null, C16898m31.a.b(), interfaceC22053ub1, 196608, 30);
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            C0936a(InterfaceC9102Ym4 interfaceC9102Ym4, String str, UA2 ua2, androidx.navigation.e eVar) {
                this.a = interfaceC9102Ym4;
                this.b = str;
                this.c = ua2;
                this.d = eVar;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                C17388ms7 c17388ms7A = C17979ns7.a.a(interfaceC22053ub1, C17979ns7.g);
                ED.a(AbstractC19242q11.e(-944318300, true, new C0937a(this.a, this.b, this.c), interfaceC22053ub1, 54), null, AbstractC19242q11.e(-653973662, true, new b(this.a, this.c, this.d), interfaceC22053ub1, 54), AbstractC19242q11.e(1968245273, true, new c(this.a), interfaceC22053ub1, 54), 0.0f, null, c17388ms7A.b((30 & 1) != 0 ? c17388ms7A.a : G10.a.a(interfaceC22053ub1, G10.b).r(), (30 & 2) != 0 ? c17388ms7A.b : 0L, (30 & 4) != 0 ? c17388ms7A.c : 0L, (30 & 8) != 0 ? c17388ms7A.d : 0L, (30 & 16) != 0 ? c17388ms7A.e : 0L), null, interfaceC22053ub1, 3462, SetRpcStruct$ComposedRpc.RESPONSE_INVITE_URL_FIELD_NUMBER);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(InterfaceC9102Ym4 interfaceC9102Ym4, String str, UA2 ua2, androidx.navigation.e eVar) {
            this.a = interfaceC9102Ym4;
            this.b = str;
            this.c = ua2;
            this.d = eVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.a), AbstractC19242q11.e(301918249, true, new C0936a(this.a, this.b, this.c, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.cT0$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ C12561ep1 a;
        final /* synthetic */ String b;
        final /* synthetic */ InterfaceC15796kB2 c;
        final /* synthetic */ androidx.navigation.e d;

        /* renamed from: ir.nasim.cT0$b$a */
        static final class a implements InterfaceC16978mB2 {
            final /* synthetic */ List a;
            final /* synthetic */ InterfaceC15796kB2 b;
            final /* synthetic */ androidx.navigation.e c;

            a(List list, InterfaceC15796kB2 interfaceC15796kB2, androidx.navigation.e eVar) {
                this.a = list;
                this.b = interfaceC15796kB2;
                this.c = eVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(InterfaceC15796kB2 interfaceC15796kB2, C13197fp1 c13197fp1, String str, androidx.navigation.e eVar) {
                AbstractC13042fc3.i(interfaceC15796kB2, "$onChangeCountry");
                AbstractC13042fc3.i(c13197fp1, "$country");
                AbstractC13042fc3.i(str, "$countryName");
                AbstractC13042fc3.i(eVar, "$navController");
                interfaceC15796kB2.q(c13197fp1.g(), str, c13197fp1.d());
                eVar.V();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(InterfaceC11943do6 interfaceC11943do6) {
                AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
                AbstractC9939ao6.x(interfaceC11943do6);
                return C19938rB7.a;
            }

            public final void c(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
                int i3;
                G10 g10;
                e.a aVar;
                int i4;
                C13197fp1 c13197fp1;
                StringBuilder sb;
                AbstractC13042fc3.i(interfaceC6988Pv3, "$this$items");
                if ((i2 & 48) == 0) {
                    i3 = i2 | (interfaceC22053ub1.e(i) ? 32 : 16);
                } else {
                    i3 = i2;
                }
                if ((i3 & SetRpcStruct$ComposedRpc.EDIT_MY_PREFERRED_LANGUAGES_FIELD_NUMBER) == 144 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                final C13197fp1 c13197fp12 = (C13197fp1) this.a.get(i);
                final String strC = UY6.c(c13197fp12.e(), interfaceC22053ub1, 0);
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null);
                interfaceC22053ub1.W(-1575194718);
                boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(c13197fp12) | interfaceC22053ub1.V(strC) | interfaceC22053ub1.D(this.c);
                final InterfaceC15796kB2 interfaceC15796kB2 = this.b;
                final androidx.navigation.e eVar = this.c;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.pT0
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC10940cT0.b.a.d(interfaceC15796kB2, c13197fp12, strC, eVar);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null);
                G10 g102 = G10.a;
                int i5 = G10.b;
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarF, g102.c(interfaceC22053ub1, i5).b().c(), g102.c(interfaceC22053ub1, i5).b().d());
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.i(), interfaceC22053ub1, 54);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarJ);
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
                String strD = c13197fp12.d();
                interfaceC22053ub1.W(-1028161822);
                if (strD == null) {
                    c13197fp1 = c13197fp12;
                    i4 = i5;
                    g10 = g102;
                    aVar = aVar2;
                } else {
                    androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.m(aVar2, 0.0f, 0.0f, g102.c(interfaceC22053ub1, i5).b().c(), 0.0f, 11, null), g102.c(interfaceC22053ub1, i5).b().k());
                    interfaceC22053ub1.W(-331724137);
                    Object objB2 = interfaceC22053ub1.B();
                    if (objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new UA2() { // from class: ir.nasim.rT0
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return AbstractC10940cT0.b.a.f((InterfaceC11943do6) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    g10 = g102;
                    aVar = aVar2;
                    i4 = i5;
                    c13197fp1 = c13197fp12;
                    AbstractC9339Zm7.b(strD, AbstractC6919Pn6.d(eVarT, false, (UA2) objB2, 1, null), 0L, AbstractC13784go7.g(20), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new C9348Zn7(0L, 0L, (C4593Fu2) null, (C3418Au2) null, (C3657Bu2) null, (AbstractC9998au2) null, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, 0, 0, 0L, (C5477Jm7) null, new C23283wf5(C24136y62.b.c(), (ED1) null), (C4888Gz3) null, 0, 0, (C22179un7) null, 16252927, (ED1) null), interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 0, 65524);
                }
                interfaceC22053ub1.Q();
                G10 g103 = g10;
                int i6 = i4;
                ZH6.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g103.c(interfaceC22053ub1, i6).b().c(), 0.0f, 0.0f, 13, null), interfaceC22053ub1, 0);
                AbstractC9339Zm7.b(UY6.c(c13197fp1.e(), interfaceC22053ub1, 0), L66.b(m66, aVar, 1.0f, false, 2, null), g103.a(interfaceC22053ub1, i6).F(), 0L, null, null, null, 0L, null, C6399Nk7.h(C6399Nk7.b.f()), 0L, 0, false, 0, 0, null, g103.d(interfaceC22053ub1, i6).b(), interfaceC22053ub1, 0, 0, 65016);
                ZH6.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g103.c(interfaceC22053ub1, i6).b().c(), 0.0f, 0.0f, 13, null), interfaceC22053ub1, 0);
                if (JF5.g()) {
                    String strE = XY6.e(c13197fp1.g());
                    sb = new StringBuilder();
                    sb.append(strE);
                    sb.append("+");
                } else {
                    String strG = c13197fp1.g();
                    sb = new StringBuilder();
                    sb.append("+");
                    sb.append(strG);
                }
                AbstractC9339Zm7.b(sb.toString(), null, g103.a(interfaceC22053ub1, i6).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g103.d(interfaceC22053ub1, i6).b(), interfaceC22053ub1, 0, 0, 65530);
                ZH6.a(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g103.c(interfaceC22053ub1, i6).b().c(), 0.0f, 0.0f, 13, null), interfaceC22053ub1, 0);
                interfaceC22053ub1.u();
                ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), C17784nZ1.q(1)), 0.0f, g103.a(interfaceC22053ub1, i6).A(), interfaceC22053ub1, 6, 2);
            }

            @Override // ir.nasim.InterfaceC16978mB2
            public /* bridge */ /* synthetic */ Object e(Object obj, Object obj2, Object obj3, Object obj4) {
                c((InterfaceC6988Pv3) obj, ((Number) obj2).intValue(), (InterfaceC22053ub1) obj3, ((Number) obj4).intValue());
                return C19938rB7.a;
            }
        }

        b(C12561ep1 c12561ep1, String str, InterfaceC15796kB2 interfaceC15796kB2, androidx.navigation.e eVar) {
            this.a = c12561ep1;
            this.b = str;
            this.c = interfaceC15796kB2;
            this.d = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(String str, InterfaceC11943do6 interfaceC11943do6) {
            AbstractC13042fc3.i(str, "$contentDescriptionVal");
            AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
            AbstractC9939ao6.e0(interfaceC11943do6, str);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(EV4 ev4, long j, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(ev4, "$painter");
            AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
            EV4.k(ev4, interfaceC17460n02, ev4.getIntrinsicSize(), 0.0f, AbstractC24975zX0.a.b(AbstractC24975zX0.b, j, 0, 2, null), 2, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(List list, InterfaceC15796kB2 interfaceC15796kB2, androidx.navigation.e eVar, InterfaceC15069ix3 interfaceC15069ix3) {
            AbstractC13042fc3.i(list, "$sortedCountries");
            AbstractC13042fc3.i(interfaceC15796kB2, "$onChangeCountry");
            AbstractC13042fc3.i(eVar, "$navController");
            AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
            InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C16898m31.a.c(), 3, null);
            InterfaceC15069ix3.g(interfaceC15069ix3, list.size(), null, null, AbstractC19242q11.c(-1604445120, true, new a(list, interfaceC15796kB2, eVar)), 6, null);
            return C19938rB7.a;
        }

        public final void d(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
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
            final List listM = this.a.m(AbstractC20762sZ6.n1(this.b).toString(), (Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()));
            if (!listM.isEmpty()) {
                interfaceC22053ub1.W(-716476623);
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.ui.e.a, 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
                interfaceC22053ub1.W(-1962770841);
                boolean zD = interfaceC22053ub1.D(listM) | interfaceC22053ub1.V(this.c) | interfaceC22053ub1.D(this.d);
                final InterfaceC15796kB2 interfaceC15796kB2 = this.c;
                final androidx.navigation.e eVar = this.d;
                Object objB = interfaceC22053ub1.B();
                if (zD || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.nT0
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC10940cT0.b.i(listM, interfaceC15796kB2, eVar, (InterfaceC15069ix3) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC12623ev3.b(eVarM, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1, 0, 510);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.W(-717837027);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.b(), InterfaceC12529em.a.g(), interfaceC22053ub1, 54);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
            final EV4 ev4C = FV4.c(IB5.search, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i3 = G10.b;
            final long jZ = g10.a(interfaceC22053ub1, i3).z();
            final String strC = UY6.c(AbstractC24206yD5.search_hint_chat, interfaceC22053ub1, 0);
            androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1, i3).b().j());
            interfaceC22053ub1.W(-1121498424);
            boolean zV = interfaceC22053ub1.V(strC);
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.jT0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC10940cT0.b.f(strC, (InterfaceC11943do6) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarD = AbstractC6919Pn6.d(eVarT, false, (UA2) objB2, 1, null);
            interfaceC22053ub1.W(-1121496108);
            boolean zD2 = interfaceC22053ub1.D(ev4C) | interfaceC22053ub1.f(jZ);
            Object objB3 = interfaceC22053ub1.B();
            if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new UA2() { // from class: ir.nasim.lT0
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC10940cT0.b.h(ev4C, jZ, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC22443vF0.a(eVarD, (UA2) objB3, interfaceC22053ub1, 0);
            ZH6.a(androidx.compose.foundation.layout.q.i(aVar, g10.c(interfaceC22053ub1, i3).b().e()), interfaceC22053ub1, 0);
            AbstractC9339Zm7.b(UY6.c(AbstractC24206yD5.features_authentication_no_result_found, interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i3).z(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).a(), interfaceC22053ub1, 0, 0, 65530);
            interfaceC22053ub1.u();
            interfaceC22053ub1.Q();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final C12561ep1 c12561ep1, final androidx.navigation.e eVar, final String str, final UA2 ua2, final InterfaceC15796kB2 interfaceC15796kB2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(c12561ep1, "countries");
        AbstractC13042fc3.i(eVar, "navController");
        AbstractC13042fc3.i(str, "query");
        AbstractC13042fc3.i(ua2, "onChangeQuery");
        AbstractC13042fc3.i(interfaceC15796kB2, "onChangeCountry");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-422673107);
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? interfaceC22053ub1J.V(c12561ep1) : interfaceC22053ub1J.D(c12561ep1) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(eVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(str) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(ua2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC15796kB2) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Object[] objArr = new Object[0];
            interfaceC22053ub1J.W(-1507085087);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.XS0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10940cT0.e();
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1J, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            boolean zF = f(interfaceC9102Ym4);
            interfaceC22053ub1J.W(-1507082566);
            boolean zV = interfaceC22053ub1J.V(interfaceC9102Ym4) | ((i3 & 7168) == 2048);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new SA2() { // from class: ir.nasim.ZS0
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC10940cT0.h(ua2, interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            UV.a(zF, (SA2) objB2, interfaceC22053ub1J, 0, 0);
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(613307625, true, new a(interfaceC9102Ym4, str, ua2, eVar), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(1554915454, true, new b(c12561ep1, str, interfaceC15796kB2, eVar), interfaceC22053ub1J, 54), interfaceC22053ub1J, 805306422, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.bT0
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC10940cT0.i(c12561ep1, eVar, str, ua2, interfaceC15796kB2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9102Ym4 e() {
        return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(UA2 ua2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(ua2, "$onChangeQuery");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isSearchMode$delegate");
        g(interfaceC9102Ym4, false);
        ua2.invoke("");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(C12561ep1 c12561ep1, androidx.navigation.e eVar, String str, UA2 ua2, InterfaceC15796kB2 interfaceC15796kB2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c12561ep1, "$countries");
        AbstractC13042fc3.i(eVar, "$navController");
        AbstractC13042fc3.i(str, "$query");
        AbstractC13042fc3.i(ua2, "$onChangeQuery");
        AbstractC13042fc3.i(interfaceC15796kB2, "$onChangeCountry");
        d(c12561ep1, eVar, str, ua2, interfaceC15796kB2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
