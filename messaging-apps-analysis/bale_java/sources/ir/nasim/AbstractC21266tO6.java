package ir.nasim;

import android.content.Context;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC17026mG5;
import ir.nasim.AbstractC21266tO6;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.OA2;
import ir.nasim.PN6;
import ir.nasim.QN6;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.tO6, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC21266tO6 {

    /* renamed from: ir.nasim.tO6$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SN6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ androidx.compose.ui.e d;

        /* renamed from: ir.nasim.tO6$a$a, reason: collision with other inner class name */
        static final class C1574a implements InterfaceC14603iB2 {
            final /* synthetic */ SN6 a;

            C1574a(SN6 sn6) {
                this.a = sn6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.z0(this.a.f(), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.tO6$a$b */
        static final class b implements InterfaceC14603iB2 {
            final /* synthetic */ SN6 a;

            b(SN6 sn6) {
                this.a = sn6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC19555qZ.c0(this.a.a(), interfaceC22053ub1, 0);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SN6 sn6, SA2 sa2, SA2 sa22, androidx.compose.ui.e eVar) {
            this.a = sn6;
            this.b = sa2;
            this.c = sa22;
            this.d = eVar;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            AbstractC19555qZ.E(AbstractC19242q11.e(-1609565683, true, new C1574a(this.a), interfaceC22053ub1, 54), AbstractC10289bP1.b.c.b, AbstractC19242q11.e(14654155, true, new b(this.a), interfaceC22053ub1, 54), AbstractC10289bP1.a.c.a, this.a.e(), this.b, this.a.d(), this.a.b(), this.c, this.a.c(), this.d, interfaceC22053ub1, (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9), 0, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tO6$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ QN6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ UA2 c;

        b(QN6 qn6, SA2 sa2, UA2 ua2) {
            this.a = qn6;
            this.b = sa2;
            this.c = ua2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 c(UA2 ua2, QN6.a aVar, boolean z) {
            AbstractC13042fc3.i(aVar, "$item");
            ua2.invoke(Long.valueOf(aVar.b()));
            return C19938rB7.a;
        }

        public final void b(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            QN6 qn6 = this.a;
            SA2 sa2 = this.b;
            UA2 ua2 = this.c;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), bVarG, interfaceC22053ub1, 48);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            UA2 ua22 = ua2;
            AbstractC9339Zm7.b(UY6.c(qn6.d(), interfaceC22053ub1, 0), null, g10.a(interfaceC22053ub1, i2).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i2).l(), interfaceC22053ub1, 0, 0, 65530);
            MY2.b(androidx.compose.foundation.layout.q.m(aVar, 0.0f, g10.c(interfaceC22053ub1, i2).b().e(), 0.0f, 0.0f, 13, null), null, 0L, interfaceC22053ub1, 0, 6);
            interfaceC22053ub1.W(-1571800021);
            for (final QN6.a aVar3 : qn6.c()) {
                int iC = aVar3.c();
                boolean zD = aVar3.d();
                boolean zE = aVar3.e();
                String strA = aVar3.a();
                interfaceC22053ub1.W(1690866285);
                final UA2 ua23 = ua22;
                boolean zV = interfaceC22053ub1.V(ua23) | interfaceC22053ub1.V(aVar3);
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.uO6
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC21266tO6.b.c(ua23, aVar3, ((Boolean) obj).booleanValue());
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                interfaceC22053ub1.Q();
                QX.e(new C17720nS0(iC, zE, zD, strA, (UA2) objB), null, interfaceC22053ub1, C17720nS0.f, 2);
                MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
                ua22 = ua23;
            }
            interfaceC22053ub1.Q();
            AbstractC17932no0.A(sa2, qn6.b(), UY6.c(qn6.a(), interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), G10.a.c(interfaceC22053ub1, G10.b).b().e()), null, null, interfaceC22053ub1, 24576, 32);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            b((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tO6$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ FO6 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ SA2 e;
        final /* synthetic */ SA2 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ UA2 h;

        c(FO6 fo6, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, SA2 sa26, UA2 ua2) {
            this.a = fo6;
            this.b = sa2;
            this.c = sa22;
            this.d = sa23;
            this.e = sa24;
            this.f = sa25;
            this.g = sa26;
            this.h = ua2;
        }

        public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "paddingValues");
            if ((i & 6) == 0) {
                i2 = (interfaceC22053ub1.V(ts4) ? 4 : 2) | i;
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-47173790);
            if (this.a == null) {
                AbstractC21266tO6.T(androidx.compose.foundation.layout.q.h(androidx.compose.ui.e.a, ts4), interfaceC22053ub1, 0, 0);
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.Q();
            SN6 sn6C = this.a.c();
            interfaceC22053ub1.W(-47168797);
            if (sn6C != null) {
                AbstractC21266tO6.F(sn6C, null, this.b, this.c, interfaceC22053ub1, 0, 2);
                C19938rB7 c19938rB7 = C19938rB7.a;
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(androidx.compose.foundation.layout.q.h(androidx.compose.ui.e.a, ts4), 0.0f, 1, null);
            InterfaceC12529em.b bVarG = InterfaceC12529em.a.g();
            FO6 fo6 = this.a;
            SA2 sa2 = this.d;
            SA2 sa22 = this.e;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), bVarG, interfaceC22053ub1, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC21266tO6.M(fo6.d(), null, sa2, interfaceC22053ub1, 0, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            AbstractC21266tO6.A(fo6.b(), null, sa22, interfaceC22053ub1, 0, 2);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
            interfaceC22053ub1.u();
            QN6 qn6A = this.a.a();
            if (qn6A == null) {
                return;
            }
            AbstractC21266tO6.H(qn6A, null, this.f, this.g, this.h, interfaceC22053ub1, 0, 2);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tO6$d */
    static final class d implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        d(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.settings_storage_manager_appbar, interfaceC22053ub1, 0), null, this.a, null, null, null, null, interfaceC22053ub1, 0, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.tO6$e */
    static final class e implements InterfaceC14603iB2 {
        final /* synthetic */ FO6 a;
        final /* synthetic */ androidx.compose.ui.e b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ GO6 d;

        e(FO6 fo6, androidx.compose.ui.e eVar, SA2 sa2, GO6 go6) {
            this.a = fo6;
            this.b = eVar;
            this.c = sa2;
            this.d = go6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(GO6 go6) {
            go6.a1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 o(GO6 go6) {
            go6.j1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 p(GO6 go6) {
            go6.d1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 t(GO6 go6) {
            go6.b1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 v(GO6 go6) {
            go6.i1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 w(GO6 go6) {
            go6.c1();
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 x(GO6 go6, long j) {
            go6.h1(j);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            k((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }

        public final void k(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            FO6 fo6 = this.a;
            androidx.compose.ui.e eVar = this.b;
            SA2 sa2 = this.c;
            interfaceC22053ub1.W(-102839758);
            boolean zD = interfaceC22053ub1.D(this.d);
            final GO6 go6 = this.d;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.vO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21266tO6.e.n(go6);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            SA2 sa22 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-102829248);
            boolean zD2 = interfaceC22053ub1.D(this.d);
            final GO6 go62 = this.d;
            Object objB2 = interfaceC22053ub1.B();
            if (zD2 || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new SA2() { // from class: ir.nasim.wO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21266tO6.e.t(go62);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            SA2 sa23 = (SA2) objB2;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-102836485);
            boolean zD3 = interfaceC22053ub1.D(this.d);
            final GO6 go63 = this.d;
            Object objB3 = interfaceC22053ub1.B();
            if (zD3 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.xO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21266tO6.e.v(go63);
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            SA2 sa24 = (SA2) objB3;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-102832834);
            boolean zD4 = interfaceC22053ub1.D(this.d);
            final GO6 go64 = this.d;
            Object objB4 = interfaceC22053ub1.B();
            if (zD4 || objB4 == InterfaceC22053ub1.a.a()) {
                objB4 = new SA2() { // from class: ir.nasim.yO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21266tO6.e.w(go64);
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            SA2 sa25 = (SA2) objB4;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-102817562);
            boolean zD5 = interfaceC22053ub1.D(this.d);
            final GO6 go65 = this.d;
            Object objB5 = interfaceC22053ub1.B();
            if (zD5 || objB5 == InterfaceC22053ub1.a.a()) {
                objB5 = new UA2() { // from class: ir.nasim.zO6
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC21266tO6.e.x(go65, ((Long) obj).longValue());
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            UA2 ua2 = (UA2) objB5;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-102825375);
            boolean zD6 = interfaceC22053ub1.D(this.d);
            final GO6 go66 = this.d;
            Object objB6 = interfaceC22053ub1.B();
            if (zD6 || objB6 == InterfaceC22053ub1.a.a()) {
                objB6 = new SA2() { // from class: ir.nasim.AO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21266tO6.e.o(go66);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            SA2 sa26 = (SA2) objB6;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-102821372);
            boolean zD7 = interfaceC22053ub1.D(this.d);
            final GO6 go67 = this.d;
            Object objB7 = interfaceC22053ub1.B();
            if (zD7 || objB7 == InterfaceC22053ub1.a.a()) {
                objB7 = new SA2() { // from class: ir.nasim.BO6
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC21266tO6.e.p(go67);
                    }
                };
                interfaceC22053ub1.s(objB7);
            }
            interfaceC22053ub1.Q();
            AbstractC21266tO6.V(fo6, eVar, sa2, sa22, sa23, sa24, sa25, ua2, sa26, (SA2) objB7, interfaceC22053ub1, 0, 0);
        }
    }

    /* renamed from: ir.nasim.tO6$f */
    public /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[PN6.a.values().length];
            try {
                iArr[PN6.a.a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PN6.a.b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PN6.a.c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void A(final ir.nasim.C15356jS0 r38, androidx.compose.ui.e r39, final ir.nasim.SA2 r40, ir.nasim.InterfaceC22053ub1 r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21266tO6.A(ir.nasim.jS0, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDeleteChatsClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDeleteChatsClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E(C15356jS0 c15356jS0, androidx.compose.ui.e eVar, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c15356jS0, "$chatsStorageUiState");
        AbstractC13042fc3.i(sa2, "$onDeleteChatsClicked");
        A(c15356jS0, eVar, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void F(final ir.nasim.SN6 r13, androidx.compose.ui.e r14, final ir.nasim.SA2 r15, final ir.nasim.SA2 r16, ir.nasim.InterfaceC22053ub1 r17, final int r18, final int r19) {
        /*
            r1 = r13
            r3 = r15
            r10 = r16
            r11 = r18
            r0 = -853660832(0xffffffffcd1e2b60, float:-1.6585267E8)
            r2 = r17
            ir.nasim.ub1 r0 = r2.j(r0)
            r2 = r19 & 1
            if (r2 == 0) goto L16
            r2 = r11 | 6
            goto L26
        L16:
            r2 = r11 & 6
            if (r2 != 0) goto L25
            boolean r2 = r0.D(r13)
            if (r2 == 0) goto L22
            r2 = 4
            goto L23
        L22:
            r2 = 2
        L23:
            r2 = r2 | r11
            goto L26
        L25:
            r2 = r11
        L26:
            r4 = r19 & 2
            if (r4 == 0) goto L2e
            r2 = r2 | 48
        L2c:
            r5 = r14
            goto L3f
        L2e:
            r5 = r11 & 48
            if (r5 != 0) goto L2c
            r5 = r14
            boolean r6 = r0.V(r14)
            if (r6 == 0) goto L3c
            r6 = 32
            goto L3e
        L3c:
            r6 = 16
        L3e:
            r2 = r2 | r6
        L3f:
            r6 = r19 & 4
            if (r6 == 0) goto L46
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L56
        L46:
            r6 = r11 & 384(0x180, float:5.38E-43)
            if (r6 != 0) goto L56
            boolean r6 = r0.D(r15)
            if (r6 == 0) goto L53
            r6 = 256(0x100, float:3.59E-43)
            goto L55
        L53:
            r6 = 128(0x80, float:1.8E-43)
        L55:
            r2 = r2 | r6
        L56:
            r6 = r19 & 8
            if (r6 == 0) goto L5d
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L6d
        L5d:
            r6 = r11 & 3072(0xc00, float:4.305E-42)
            if (r6 != 0) goto L6d
            boolean r6 = r0.D(r10)
            if (r6 == 0) goto L6a
            r6 = 2048(0x800, float:2.87E-42)
            goto L6c
        L6a:
            r6 = 1024(0x400, float:1.435E-42)
        L6c:
            r2 = r2 | r6
        L6d:
            r6 = r2 & 1171(0x493, float:1.641E-42)
            r7 = 1170(0x492, float:1.64E-42)
            if (r6 != r7) goto L7f
            boolean r6 = r0.k()
            if (r6 != 0) goto L7a
            goto L7f
        L7a:
            r0.L()
            r2 = r5
            goto La4
        L7f:
            if (r4 == 0) goto L85
            androidx.compose.ui.e$a r4 = androidx.compose.ui.e.a
            r12 = r4
            goto L86
        L85:
            r12 = r5
        L86:
            ir.nasim.tO6$a r4 = new ir.nasim.tO6$a
            r4.<init>(r13, r15, r10, r12)
            r5 = 54
            r6 = -244830615(0xfffffffff1682e69, float:-1.14970606E30)
            r7 = 1
            ir.nasim.o11 r6 = ir.nasim.AbstractC19242q11.e(r6, r7, r4, r0, r5)
            int r2 = r2 >> 9
            r2 = r2 & 14
            r8 = r2 | 384(0x180, float:5.38E-43)
            r9 = 2
            r5 = 0
            r4 = r16
            r7 = r0
            ir.nasim.AbstractC6687Oo.a(r4, r5, r6, r7, r8, r9)
            r2 = r12
        La4:
            ir.nasim.rd6 r7 = r0.m()
            if (r7 == 0) goto Lbb
            ir.nasim.UN6 r8 = new ir.nasim.UN6
            r0 = r8
            r1 = r13
            r3 = r15
            r4 = r16
            r5 = r18
            r6 = r19
            r0.<init>()
            r7.a(r8)
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21266tO6.F(ir.nasim.SN6, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(SN6 sn6, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sn6, "$dialogUiState");
        AbstractC13042fc3.i(sa2, "$onDeleteChatsClicked");
        AbstractC13042fc3.i(sa22, "$onCancelClicked");
        F(sn6, eVar, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:89:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void H(final ir.nasim.QN6 r28, androidx.compose.ui.e r29, ir.nasim.SA2 r30, ir.nasim.SA2 r31, ir.nasim.UA2 r32, ir.nasim.InterfaceC22053ub1 r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21266tO6.H(ir.nasim.QN6, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 K(long j) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(QN6 qn6, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, UA2 ua2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(qn6, "$bottomSheetUiState");
        H(qn6, eVar, sa2, sa22, ua2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void M(final ir.nasim.C4062Dn2 r38, androidx.compose.ui.e r39, final ir.nasim.SA2 r40, ir.nasim.InterfaceC22053ub1 r41, final int r42, final int r43) {
        /*
            Method dump skipped, instructions count: 846
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21266tO6.M(ir.nasim.Dn2, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDeleteFilesClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 O(InterfaceC11943do6 interfaceC11943do6) {
        AbstractC13042fc3.i(interfaceC11943do6, "$this$semantics");
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onDeleteFilesClicked");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(C4062Dn2 c4062Dn2, androidx.compose.ui.e eVar, SA2 sa2, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(c4062Dn2, "$fileStorageState");
        AbstractC13042fc3.i(sa2, "$onDeleteFilesClicked");
        M(c4062Dn2, eVar, sa2, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    private static final void R(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1297458271);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            eVar2 = eVar;
        } else if ((i & 6) == 0) {
            eVar2 = eVar;
            i3 = (interfaceC22053ub1J.V(eVar2) ? 4 : 2) | i;
        } else {
            eVar2 = eVar;
            i3 = i;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            float f2 = 16;
            androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.t.h(eVar3, 0.0f, 1, null), C17784nZ1.q(f2));
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.e eVarG = c24254yJ.g();
            InterfaceC12529em.a aVar = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarI);
            InterfaceC16030kb1.a aVar2 = InterfaceC16030kb1.d0;
            SA2 sa2A = aVar2.a();
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            M66 m66 = M66.a;
            e.a aVar3 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarB = L66.b(m66, aVar3, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar.k(), interfaceC22053ub1J, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
            SA2 sa2A2 = aVar2.a();
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar2.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar3, C17784nZ1.q(160)), C17784nZ1.q(24)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            G10 g10 = G10.a;
            int i5 = G10.b;
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar3, g10.c(interfaceC22053ub1J, i5).b().u()), interfaceC22053ub1J, 0);
            float f3 = 20;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar3, 0.0f, 1, null), C17784nZ1.q(f3)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            ZH6.a(androidx.compose.foundation.layout.t.i(aVar3, g10.c(interfaceC22053ub1J, i5).b().n()), interfaceC22053ub1J, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.m(aVar3, 0.0f, 0.0f, C17784nZ1.q(f2), 0.0f, 11, null), 0.0f, 1, null), C17784nZ1.q(f3)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar3, g10.c(interfaceC22053ub1J, i5).b().e()), interfaceC22053ub1J, 0);
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(aVar3, C17784nZ1.q(50)), C17784nZ1.q(f3)), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.jO6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21266tO6.S(eVar3, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 S(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        R(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(final androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-734183390);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (interfaceC22053ub1J.V(eVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i3 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            if (i4 != 0) {
                eVar = androidx.compose.ui.e.a;
            }
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(eVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.g(), interfaceC22053ub1J, 48);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            R(null, interfaceC22053ub1J, 0, 1);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            R(null, interfaceC22053ub1J, 0, 1);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ZN6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21266tO6.U(eVar, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 U(androidx.compose.ui.e eVar, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        T(eVar, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00f9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void V(final ir.nasim.FO6 r29, androidx.compose.ui.e r30, ir.nasim.SA2 r31, ir.nasim.SA2 r32, ir.nasim.SA2 r33, ir.nasim.SA2 r34, ir.nasim.SA2 r35, ir.nasim.UA2 r36, ir.nasim.SA2 r37, ir.nasim.SA2 r38, ir.nasim.InterfaceC22053ub1 r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 753
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21266tO6.V(ir.nasim.FO6, androidx.compose.ui.e, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 W() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 X() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Y() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Z(long j) {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 a0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 c0(FO6 fo6, androidx.compose.ui.e eVar, SA2 sa2, SA2 sa22, SA2 sa23, SA2 sa24, SA2 sa25, UA2 ua2, SA2 sa26, SA2 sa27, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        V(fo6, eVar, sa2, sa22, sa23, sa24, sa25, ua2, sa26, sa27, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d0() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e0() {
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void f0(final ir.nasim.SA2 r12, androidx.compose.ui.e r13, ir.nasim.GO6 r14, ir.nasim.InterfaceC22053ub1 r15, final int r16, final int r17) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC21266tO6.f0(ir.nasim.SA2, androidx.compose.ui.e, ir.nasim.GO6, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 g0(SA2 sa2, androidx.compose.ui.e eVar, GO6 go6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        f0(sa2, eVar, go6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void h0(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1185401162);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C4062Dn2 c4062Dn2 = new C4062Dn2(UY6.c(QD5.settings_storage_manager_file_management_title, interfaceC22053ub1J, 0), UY6.c(QD5.settings_storage_manager_file_management_description, interfaceC22053ub1J, 0), UY6.c(QD5.settings_storage_manager_file_management_delete, interfaceC22053ub1J, 0), true);
            C15356jS0 c15356jS0 = new C15356jS0(UY6.c(QD5.settings_storage_manager_chat_management_title, interfaceC22053ub1J, 0), UY6.c(QD5.settings_storage_manager_chat_management_description, interfaceC22053ub1J, 0), UY6.c(QD5.settings_storage_manager_chat_management_clear, interfaceC22053ub1J, 0), true);
            SN6 sn6 = new SN6(QD5.settings_storage_manager_delete_chats_dialog_title, QD5.settings_storage_manager_delete_chats_dialog_description, QD5.settings_storage_manager_delete_chats_dialog_positive_button, QD5.settings_storage_manager_delete_chats_dialog_negative_button, InterfaceC19114po0.b.a.a, InterfaceC19114po0.b.C1454b.a);
            int i2 = QD5.settings_storage_manager_delete_files_bottom_sheet_title;
            int i3 = QD5.settings_storage_manager_delete_files_bottom_sheet_button;
            InterfaceC19114po0.a.C1453a c1453a = InterfaceC19114po0.a.C1453a.a;
            int i4 = QD5.name;
            AbstractC17026mG5.a aVar = AbstractC17026mG5.a;
            V(new FO6(c4062Dn2, c15356jS0, sn6, new QN6(i2, i3, c1453a, AbstractC7783Te2.b(new QN6.a(1L, i4, aVar.c(), aVar.c(), "128 GB")))), null, null, null, null, null, null, null, null, null, interfaceC22053ub1J, 0, 1022);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.TN6
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC21266tO6.i0(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i0(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        h0(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final FO6 p0(InterfaceC10258bL6 interfaceC10258bL6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(-1603449333);
        EO6 eo6Q0 = q0(AbstractC10222bH6.b(interfaceC10258bL6, null, interfaceC22053ub1, i & 14, 1));
        FO6 fo6T0 = eo6Q0 != null ? t0(eo6Q0, interfaceC22053ub1, 0) : null;
        interfaceC22053ub1.Q();
        return fo6T0;
    }

    private static final EO6 q0(InterfaceC9664aL6 interfaceC9664aL6) {
        return (EO6) interfaceC9664aL6.getValue();
    }

    private static final String r0(long j, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        interfaceC22053ub1.W(538045500);
        String strB = C20877sl2.b((Context) interfaceC22053ub1.H(AndroidCompositionLocals_androidKt.g()), j);
        interfaceC22053ub1.Q();
        return strB;
    }

    private static final int s0(PN6.b bVar) {
        if (bVar instanceof PN6.b.a) {
            return QD5.settings_storage_manager_directory_audios;
        }
        if (bVar instanceof PN6.b.c) {
            return QD5.settings_storage_manager_directory_photos;
        }
        if (bVar instanceof PN6.b.e) {
            return QD5.settings_storage_manager_directory_videos;
        }
        if (bVar instanceof PN6.b.d) {
            return QD5.settings_storage_manager_directory_stories;
        }
        if (bVar instanceof PN6.b.C0575b) {
            return QD5.settings_storage_manager_directory_documents;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final FO6 t0(EO6 eo6, InterfaceC22053ub1 interfaceC22053ub1, int i) {
        InterfaceC19114po0 interfaceC19114po0;
        interfaceC22053ub1.W(-1445732098);
        C4062Dn2 c4062Dn2 = new C4062Dn2(UY6.d(QD5.settings_storage_manager_file_management_title, new Object[]{r0(eo6.d().a(), interfaceC22053ub1, 0)}, interfaceC22053ub1, 0), UY6.c(QD5.settings_storage_manager_file_management_description, interfaceC22053ub1, 0), UY6.c(QD5.settings_storage_manager_file_management_delete, interfaceC22053ub1, 0), eo6.d().b());
        C15356jS0 c15356jS0 = new C15356jS0(UY6.d(QD5.settings_storage_manager_chat_management_title, new Object[]{r0(eo6.b().a(), interfaceC22053ub1, 0)}, interfaceC22053ub1, 0), UY6.c(QD5.settings_storage_manager_chat_management_description, interfaceC22053ub1, 0), UY6.c(QD5.settings_storage_manager_chat_management_clear, interfaceC22053ub1, 0), eo6.b().b());
        RN6 rn6C = eo6.c();
        QN6 qn6 = null;
        SN6 sn6 = rn6C != null ? new SN6(QD5.settings_storage_manager_delete_chats_dialog_title, QD5.settings_storage_manager_delete_chats_dialog_description, QD5.settings_storage_manager_delete_chats_dialog_positive_button, QD5.settings_storage_manager_delete_chats_dialog_negative_button, rn6C.a() ? OA2.a.b : InterfaceC19114po0.b.a.a, rn6C.a() ? InterfaceC19114po0.a.b.a : InterfaceC19114po0.b.C1454b.a) : null;
        PN6 pn6A = eo6.a();
        if (pn6A != null) {
            int i2 = QD5.settings_storage_manager_delete_files_bottom_sheet_title;
            int i3 = QD5.settings_storage_manager_delete_files_bottom_sheet_button;
            int i4 = f.a[pn6A.a().ordinal()];
            if (i4 == 1) {
                interfaceC19114po0 = InterfaceC19114po0.b.a.a;
            } else if (i4 == 2) {
                interfaceC19114po0 = InterfaceC19114po0.a.C1453a.a;
            } else {
                if (i4 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC19114po0 = OA2.a.b;
            }
            interfaceC22053ub1.W(1635442760);
            List<PN6.b> listB = pn6A.b();
            ArrayList arrayList = new ArrayList(AbstractC10976cX0.x(listB, 10));
            for (PN6.b bVar : listB) {
                arrayList.add(new QN6.a(bVar.getId(), s0(bVar), bVar.b() > 0, bVar.a(), r0(bVar.b(), interfaceC22053ub1, 0)));
            }
            interfaceC22053ub1.Q();
            qn6 = new QN6(i2, i3, interfaceC19114po0, AbstractC7783Te2.e(arrayList));
        }
        FO6 fo6 = new FO6(c4062Dn2, c15356jS0, sn6, qn6);
        interfaceC22053ub1.Q();
        return fo6;
    }
}
