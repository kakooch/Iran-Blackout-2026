package ir.nasim;

import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC19332qA1;
import ir.nasim.C24254yJ;
import ir.nasim.G45;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.OA2;
import ir.nasim.Q12;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* renamed from: ir.nasim.qA1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC19332qA1 {

    /* renamed from: ir.nasim.qA1$a */
    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ InterfaceC9102Ym4 d;
        final /* synthetic */ InterfaceC9102Ym4 e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = z;
            this.d = interfaceC9102Ym4;
            this.e = interfaceC9102Ym42;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, this.e, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC19332qA1.i(this.e, this.c ? G45.d(new E45(AbstractC19332qA1.f(this.d)), "Y/m/d", G45.a.FARSI) : new SimpleDateFormat("yyyy/MM/dd", Locale.getDefault()).format(AbstractC19332qA1.f(this.d)));
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.qA1$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ boolean a;
        final /* synthetic */ androidx.compose.ui.e b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ InterfaceC9102Ym4 g;
        final /* synthetic */ InterfaceC9102Ym4 h;
        final /* synthetic */ InterfaceC9102Ym4 i;

        /* renamed from: ir.nasim.qA1$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ androidx.compose.ui.e a;
            final /* synthetic */ UA2 b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ boolean f;
            final /* synthetic */ InterfaceC9102Ym4 g;
            final /* synthetic */ InterfaceC9102Ym4 h;
            final /* synthetic */ InterfaceC9102Ym4 i;

            a(androidx.compose.ui.e eVar, UA2 ua2, SA2 sa2, String str, String str2, boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43) {
                this.a = eVar;
                this.b = ua2;
                this.c = sa2;
                this.d = str;
                this.e = str2;
                this.f = z;
                this.g = interfaceC9102Ym4;
                this.h = interfaceC9102Ym42;
                this.i = interfaceC9102Ym43;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(SA2 sa2) {
                AbstractC13042fc3.i(sa2, "$onCloseClicked");
                sa2.invoke();
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 h(boolean z, InterfaceC9102Ym4 interfaceC9102Ym4, int i, int i2, int i3) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$currentSelectedDate$delegate");
                AbstractC19332qA1.g(interfaceC9102Ym4, AbstractC19332qA1.z(i, i2, i3, z));
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(UA2 ua2, SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(ua2, "$onDoneClicked");
                AbstractC13042fc3.i(sa2, "$onCloseClicked");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$currentSelectedDate$delegate");
                ua2.invoke(Long.valueOf(AbstractC19332qA1.f(interfaceC9102Ym4).getTime()));
                sa2.invoke();
                return C19938rB7.a;
            }

            public final void d(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                final InterfaceC9102Ym4 interfaceC9102Ym4;
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVar = this.a;
                G10 g10 = G10.a;
                float f = 24;
                androidx.compose.ui.e eVarC = androidx.compose.foundation.b.c(eVar, g10.a(interfaceC22053ub1, 6).M(), N46.d(C17784nZ1.q(f)));
                final UA2 ua2 = this.b;
                final SA2 sa2 = this.c;
                String str = this.d;
                String str2 = this.e;
                final boolean z = this.f;
                InterfaceC9102Ym4 interfaceC9102Ym42 = this.g;
                InterfaceC9102Ym4 interfaceC9102Ym43 = this.h;
                InterfaceC9102Ym4 interfaceC9102Ym44 = this.i;
                C24254yJ.m mVarH = C24254yJ.a.h();
                InterfaceC12529em.a aVar = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar.k(), interfaceC22053ub1, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarC);
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
                e.a aVar3 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarK = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.i(aVar3, C17784nZ1.q(60)), 0.0f, 1, null), g10.c(interfaceC22053ub1, 6).b().e(), 0.0f, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK);
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
                EV4 ev4C = FV4.c(AbstractC24188yB5.close, interfaceC22053ub1, 0);
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar3, C17784nZ1.q(f));
                interfaceC22053ub1.W(-1036198824);
                boolean zV = interfaceC22053ub1.V(sa2);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.rA1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC19332qA1.b.a.f(sa2);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                AbstractC24077y03.b(ev4C, "", hVar.h(androidx.compose.foundation.e.f(eVarT, false, null, null, (SA2) objB, 7, null), aVar.f()), g10.a(interfaceC22053ub1, 6).F(), interfaceC22053ub1, 48, 0);
                AbstractC9339Zm7.b(str, hVar.h(aVar3, aVar.e()), g10.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, 6).l(), interfaceC22053ub1, 0, 0, 65528);
                interfaceC22053ub1.u();
                MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
                androidx.compose.ui.e eVarK2 = androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), g10.c(interfaceC22053ub1, 6).b().e(), 0.0f, 2, null);
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar.o(), false);
                int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarK2);
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
                DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G2, aVar2.e());
                DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B3 = aVar2.b();
                if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                    interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                    interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
                }
                DG7.c(interfaceC22053ub1A3, eVarE3, aVar2.f());
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(AbstractC9287Zh0.f(androidx.compose.foundation.layout.q.m(aVar3, 0.0f, g10.c(interfaceC22053ub1, 6).b().j(), 0.0f, 0.0f, 13, null), C17784nZ1.q(1), g10.a(interfaceC22053ub1, 6).A(), N46.d(g10.c(interfaceC22053ub1, 6).a().b())), g10.c(interfaceC22053ub1, 6).b().d());
                InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(aVar.o(), false);
                int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarI);
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
                DG7.c(interfaceC22053ub1A4, interfaceC10970cW3G3, aVar2.e());
                DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar2.g());
                InterfaceC14603iB2 interfaceC14603iB2B4 = aVar2.b();
                if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                    interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                    interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
                }
                DG7.c(interfaceC22053ub1A4, eVarE4, aVar2.f());
                HA1 ha1J = AbstractC19332qA1.j(interfaceC9102Ym42);
                interfaceC22053ub1.W(-1874439073);
                boolean zA = interfaceC22053ub1.a(z);
                Object objB2 = interfaceC22053ub1.B();
                if (zA || objB2 == InterfaceC22053ub1.a.a()) {
                    interfaceC9102Ym4 = interfaceC9102Ym43;
                    objB2 = new InterfaceC15796kB2() { // from class: ir.nasim.sA1
                        @Override // ir.nasim.InterfaceC15796kB2
                        public final Object q(Object obj, Object obj2, Object obj3) {
                            return AbstractC19332qA1.b.a.h(z, interfaceC9102Ym4, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                } else {
                    interfaceC9102Ym4 = interfaceC9102Ym43;
                }
                interfaceC22053ub1.Q();
                final InterfaceC9102Ym4 interfaceC9102Ym45 = interfaceC9102Ym4;
                FA1.g(ha1J, null, null, (InterfaceC15796kB2) objB2, interfaceC22053ub1, 0, 6);
                interfaceC22053ub1.u();
                AbstractC9339Zm7.b(str2 == null ? AbstractC19332qA1.h(interfaceC9102Ym44) : str2, androidx.compose.foundation.layout.q.k(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.n.c(aVar3, 0.0f, C17784nZ1.q(C13193fo7.h(g10.d(interfaceC22053ub1, 6).o().l())), 1, null), g10.c(interfaceC22053ub1, 6).b().e(), 0.0f, 0.0f, 0.0f, 14, null), g10.a(interfaceC22053ub1, 6).M(), null, 2, null), g10.c(interfaceC22053ub1, 6).b().u(), 0.0f, 2, null), g10.a(interfaceC22053ub1, 6).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, 6).o(), interfaceC22053ub1, 0, 0, 65528);
                interfaceC22053ub1.u();
                MY2.b(androidx.compose.foundation.layout.q.m(aVar3, 0.0f, g10.c(interfaceC22053ub1, 6).b().c(), 0.0f, 0.0f, 13, null), null, 0L, interfaceC22053ub1, 0, 6);
                androidx.compose.ui.e eVarI2 = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), g10.c(interfaceC22053ub1, 6).b().c());
                String strC = UY6.c(UD5.done, interfaceC22053ub1, 0);
                OA2.b.C0545b c0545b = OA2.b.C0545b.c;
                interfaceC22053ub1.W(-596996315);
                boolean zV2 = interfaceC22053ub1.V(ua2) | interfaceC22053ub1.V(sa2);
                Object objB3 = interfaceC22053ub1.B();
                if (zV2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.tA1
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC19332qA1.b.a.i(ua2, sa2, interfaceC9102Ym45);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC17932no0.y(eVarI2, (SA2) objB3, c0545b, null, strC, null, interfaceC22053ub1, 384, 40);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                d((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(boolean z, androidx.compose.ui.e eVar, UA2 ua2, SA2 sa2, String str, String str2, InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC9102Ym4 interfaceC9102Ym42, InterfaceC9102Ym4 interfaceC9102Ym43) {
            this.a = z;
            this.b = eVar;
            this.c = ua2;
            this.d = sa2;
            this.e = str;
            this.f = str2;
            this.g = interfaceC9102Ym4;
            this.h = interfaceC9102Ym42;
            this.i = interfaceC9102Ym43;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(this.a ? EnumC12613eu3.b : EnumC12613eu3.a), AbstractC19242q11.e(-2099466172, true, new a(this.b, this.c, this.d, this.e, this.f, this.a, this.g, this.h, this.i), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final boolean A(InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1564398179);
        boolean zD = AbstractC13042fc3.d(((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g())).getResources().getConfiguration().getLocales().get(0).getLanguage(), "fa");
        interfaceC22053ub1.Q();
        return zD;
    }

    private static final HA1 B(boolean z, Date date, Date date2, Date date3) {
        return z ? y(date, date2, date3) : x(date, date2, date3);
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01d5  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:147:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void e(final java.lang.String r23, final java.util.Date r24, final java.util.Date r25, final ir.nasim.UA2 r26, final ir.nasim.SA2 r27, androidx.compose.ui.e r28, java.lang.String r29, java.util.Date r30, boolean r31, ir.nasim.InterfaceC22053ub1 r32, final int r33, final int r34) {
        /*
            Method dump skipped, instructions count: 624
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC19332qA1.e(java.lang.String, java.util.Date, java.util.Date, ir.nasim.UA2, ir.nasim.SA2, androidx.compose.ui.e, java.lang.String, java.util.Date, boolean, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date f(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (Date) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(InterfaceC9102Ym4 interfaceC9102Ym4, Date date) {
        interfaceC9102Ym4.setValue(date);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String h(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (String) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(InterfaceC9102Ym4 interfaceC9102Ym4, String str) {
        interfaceC9102Ym4.setValue(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HA1 j(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (HA1) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 k(String str, Date date, Date date2, UA2 ua2, SA2 sa2, androidx.compose.ui.e eVar, String str2, Date date3, boolean z, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(str, "$title");
        AbstractC13042fc3.i(date, "$maxDate");
        AbstractC13042fc3.i(date2, "$minDate");
        AbstractC13042fc3.i(ua2, "$onDoneClicked");
        AbstractC13042fc3.i(sa2, "$onCloseClicked");
        e(str, date, date2, ua2, sa2, eVar, str2, date3, z, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void l(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-464068417);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Date date = new Date();
            Date date2 = new Date();
            long time = date.getTime();
            Q12.a aVar = Q12.b;
            Date date3 = new Date(time - Q12.A(T12.s(365, W12.h)));
            String strC = UY6.c(UD5.select_date, interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(1729458082);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar2 = InterfaceC22053ub1.a;
            if (objB == aVar2.a()) {
                objB = new UA2() { // from class: ir.nasim.mA1
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC19332qA1.m(((Long) obj).longValue());
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(1729459010);
            Object objB2 = interfaceC22053ub1J.B();
            if (objB2 == aVar2.a()) {
                objB2 = new SA2() { // from class: ir.nasim.nA1
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC19332qA1.n();
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            e(strC, date2, date3, ua2, (SA2) objB2, null, null, date, false, interfaceC22053ub1J, 27648, 352);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.oA1
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC19332qA1.o(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(long j) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        l(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final C24411ya3 v(Date date, Date date2, int i, int i2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        boolean z = false;
        boolean z2 = i == calendar.get(1);
        boolean z3 = i == calendar2.get(1);
        boolean z4 = z2 && i2 == calendar.get(2);
        if (z3 && i2 == calendar2.get(2)) {
            z = true;
        }
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(1, i);
        calendar3.set(2, i2);
        calendar3.set(5, 1);
        int actualMaximum = calendar3.getActualMaximum(5);
        int i3 = z ? calendar2.get(5) : 1;
        if (z4) {
            actualMaximum = Math.min(calendar.get(5), actualMaximum);
        }
        return new C24411ya3(i3, actualMaximum);
    }

    private static final C24411ya3 w(E45 e45, E45 e452, int i, int i2) throws ParseException {
        boolean z = false;
        boolean z2 = i == e45.L();
        boolean z3 = i == e452.L();
        boolean z4 = z2 && i2 == e45.K();
        if (z3 && i2 == e452.K()) {
            z = true;
        }
        E45 e453 = new E45();
        e453.d0(i);
        e453.c0(i2);
        e453.b0(1);
        int iD = e453.D();
        int iJ = z ? e452.J() : 1;
        if (z4) {
            iD = Math.min(e45.J(), iD);
        }
        return new C24411ya3(iJ, iD);
    }

    private static final HA1 x(Date date, Date date2, Date date3) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date3);
        List listM1 = AbstractC15401jX0.m1(new C24411ya3(calendar.get(1), calendar2.get(1)));
        List listP = AbstractC10360bX0.p("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
        if (calendar2.get(1) <= calendar3.get(1)) {
            listP = AbstractC15401jX0.Y0(listP, new C24411ya3(0, calendar2.get(2)));
        }
        C24411ya3 c24411ya3V = v(date2, date, calendar3.get(1), calendar3.get(2));
        int iO = c24411ya3V.o();
        int iT = c24411ya3V.t();
        int i = calendar3.get(5);
        return new HA1(AbstractC7783Te2.d(listM1), AbstractC7783Te2.d(listP), AbstractC7783Te2.d(c24411ya3V), calendar3.get(1), calendar3.get(2), (iO > i || i > iT) ? c24411ya3V.t() : calendar3.get(5));
    }

    private static final HA1 y(Date date, Date date2, Date date3) throws ParseException {
        List listF1;
        E45 e45 = new E45(date);
        E45 e452 = new E45(date2);
        E45 e453 = new E45(date3);
        if (e452.L() == e453.L()) {
            String[] strArrU = e453.U();
            AbstractC13042fc3.h(strArrU, "monthList(...)");
            listF1 = AbstractC10242bK.P0(strArrU, AbstractC23053wG5.y(0, e452.K()));
        } else {
            String[] strArrU2 = e453.U();
            AbstractC13042fc3.h(strArrU2, "monthList(...)");
            listF1 = AbstractC10242bK.f1(strArrU2);
        }
        int size = listF1.size();
        int iK = e453.K() - 1;
        int size2 = (iK < 0 || iK >= size) ? listF1.size() : e453.K();
        C24411ya3 c24411ya3W = w(e452, e45, e453.L(), size2);
        int iO = c24411ya3W.o();
        int iT = c24411ya3W.t();
        int iJ = e453.J();
        return new HA1(AbstractC7783Te2.d(new C24411ya3(e45.L(), e452.L())), AbstractC7783Te2.d(listF1), AbstractC7783Te2.d(c24411ya3W), e453.L(), size2 - 1, (iO > iJ || iJ > iT) ? c24411ya3W.t() : e453.J());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Date z(int i, int i2, int i3, boolean z) throws ParseException {
        if (z) {
            int i4 = i2 + 1;
            E45 e45 = new E45();
            e45.d0(i);
            e45.c0(i4);
            e45.b0(1);
            int iD = e45.D();
            if (i3 > iD) {
                i3 = iD;
            }
            E45 e452 = new E45();
            e452.d0(i);
            e452.c0(i4);
            e452.b0(i3);
            e452.a0(6);
            Date dateE0 = e452.e0();
            AbstractC13042fc3.f(dateE0);
            return dateE0;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, 1);
        calendar.set(10, 6);
        int actualMaximum = calendar.getActualMaximum(5);
        if (i3 > actualMaximum) {
            i3 = actualMaximum;
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(1, i);
        calendar2.set(2, i2);
        calendar2.set(5, i3);
        calendar2.set(10, 6);
        Date time = calendar2.getTime();
        AbstractC13042fc3.f(time);
        return time;
    }
}
