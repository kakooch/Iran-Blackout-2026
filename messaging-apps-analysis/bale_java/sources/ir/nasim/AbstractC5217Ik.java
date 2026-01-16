package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10289bP1;
import ir.nasim.AbstractC20864sk;
import ir.nasim.AbstractC5217Ik;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.LX;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Ik, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC5217Ik {

    /* renamed from: ir.nasim.Ik$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;

        /* renamed from: ir.nasim.Ik$a$a, reason: collision with other inner class name */
        static final class C0423a implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;

            C0423a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC20434s03.a(this.a, null, false, null, null, J11.a.b(), interfaceC22053ub1, 196608, 30);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(SA2 sa2) {
            this.a = sa2;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.h(J11.a.a(), null, AbstractC19242q11.e(-711898958, true, new C0423a(this.a), interfaceC22053ub1, 54), null, null, null, null, interfaceC22053ub1, 390, 122);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ik$b */
    static final class b implements InterfaceC15796kB2 {
        final /* synthetic */ AbstractC20864sk a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;

        /* renamed from: ir.nasim.Ik$b$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ InterfaceC9102Ym4 c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = interfaceC9102Ym4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                Object objE = AbstractC14862ic3.e();
                int i = this.b;
                if (i == 0) {
                    AbstractC10685c16.b(obj);
                    if (b.v(this.c)) {
                        this.b = 1;
                        if (HG1.b(1000L, this) == objE) {
                            return objE;
                        }
                    }
                    return C19938rB7.a;
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                b.w(this.c, false);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* renamed from: ir.nasim.Ik$b$b, reason: collision with other inner class name */
        static final class C0424b implements InterfaceC14603iB2 {
            final /* synthetic */ SA2 a;
            final /* synthetic */ InterfaceC9102Ym4 b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ AbstractC20864sk d;

            /* renamed from: ir.nasim.Ik$b$b$a */
            static final class a implements InterfaceC14603iB2 {
                final /* synthetic */ AbstractC20864sk a;

                a(AbstractC20864sk abstractC20864sk) {
                    this.a = abstractC20864sk;
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    AbstractC20864sk abstractC20864sk = this.a;
                    double dA = ((abstractC20864sk instanceof AbstractC20864sk.d ? (AbstractC20864sk.d) abstractC20864sk : null) != null ? r8.a() : 0L) / 10000.0d;
                    AbstractC19555qZ.e0(UY6.d(AbstractC12217eE5.wallet_amount_not_empty_change_number_desc, new Object[]{((long) Math.rint(dA)) <= 1 ? "" : AbstractC12152e76.b(String.valueOf((long) Math.rint(dA)))}, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            C0424b(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, SA2 sa22, AbstractC20864sk abstractC20864sk) {
                this.a = sa2;
                this.b = interfaceC9102Ym4;
                this.c = sa22;
                this.d = abstractC20864sk;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(sa2, "$openServices");
                AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                sa2.invoke();
                b.D(interfaceC9102Ym4, false);
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
                sa2.invoke();
                b.D(interfaceC9102Ym4, false);
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                InterfaceC14603iB2 interfaceC14603iB2C = J11.a.c();
                AbstractC10289bP1.b.c cVar = AbstractC10289bP1.b.c.b;
                InterfaceC18060o11 interfaceC18060o11E = AbstractC19242q11.e(-1644058223, true, new a(this.d), interfaceC22053ub1, 54);
                AbstractC10289bP1.a.c cVar2 = AbstractC10289bP1.a.c.a;
                InterfaceC19114po0.b.a aVar = InterfaceC19114po0.b.a.a;
                interfaceC22053ub1.W(921821892);
                boolean zV = interfaceC22053ub1.V(this.a) | interfaceC22053ub1.V(this.b);
                final SA2 sa2 = this.a;
                final InterfaceC9102Ym4 interfaceC9102Ym4 = this.b;
                Object objB = interfaceC22053ub1.B();
                if (zV || objB == InterfaceC22053ub1.a.a()) {
                    objB = new SA2() { // from class: ir.nasim.Sk
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5217Ik.b.C0424b.d(sa2, interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa22 = (SA2) objB;
                interfaceC22053ub1.Q();
                String strC = UY6.c(AbstractC12217eE5.Done, interfaceC22053ub1, 0);
                InterfaceC19114po0.b.C1454b c1454b = InterfaceC19114po0.b.C1454b.a;
                interfaceC22053ub1.W(921831488);
                boolean zV2 = interfaceC22053ub1.V(this.c) | interfaceC22053ub1.V(this.b);
                final SA2 sa23 = this.c;
                final InterfaceC9102Ym4 interfaceC9102Ym42 = this.b;
                Object objB2 = interfaceC22053ub1.B();
                if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                    objB2 = new SA2() { // from class: ir.nasim.Tk
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5217Ik.b.C0424b.f(sa23, interfaceC9102Ym42);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC19555qZ.F(interfaceC14603iB2C, cVar, interfaceC18060o11E, cVar2, aVar, sa22, strC, c1454b, (SA2) objB2, UY6.c(AbstractC12217eE5.Cancel, interfaceC22053ub1, 0), null, interfaceC22053ub1, (InterfaceC19114po0.b.C1454b.b << 21) | (AbstractC10289bP1.b.c.c << 3) | 390 | (AbstractC10289bP1.a.c.b << 9) | (InterfaceC19114po0.b.a.b << 12), 0, 1024);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        b(AbstractC20864sk abstractC20864sk, SA2 sa2, SA2 sa22, SA2 sa23) {
            this.a = abstractC20864sk;
            this.b = sa2;
            this.c = sa22;
            this.d = sa23;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 A(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$rippleEffect$delegate");
            if (!v(interfaceC9102Ym4)) {
                w(interfaceC9102Ym4, true);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 B(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
            D(interfaceC9102Ym4, true);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 C(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$openDialog$delegate");
            D(interfaceC9102Ym4, false);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void D(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC9102Ym4 E() {
            return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        }

        private static final boolean F(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        private static final void G(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC9102Ym4 H() {
            return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC9102Ym4 t() {
            return AbstractC13472gH6.d(Boolean.FALSE, null, 2, null);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean v(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void w(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
            interfaceC9102Ym4.setValue(Boolean.valueOf(z));
        }

        private static final long x(InterfaceC9664aL6 interfaceC9664aL6) {
            return ((C24381yX0) interfaceC9664aL6.getValue()).y();
        }

        private static final boolean y(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 z(InterfaceC9102Ym4 interfaceC9102Ym4) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$agreeTerms$delegate");
            G(interfaceC9102Ym4, !F(interfaceC9102Ym4));
            return C19938rB7.a;
        }

        public final void p(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            int i2;
            AbstractC13042fc3.i(ts4, "it");
            if ((i & 6) == 0) {
                i2 = i | (interfaceC22053ub1.V(ts4) ? 4 : 2);
            } else {
                i2 = i;
            }
            if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Object[] objArr = new Object[0];
            interfaceC22053ub1.W(-1768746667);
            Object objB = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = new SA2() { // from class: ir.nasim.Lk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5217Ik.b.t();
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            C9023Yd6 c9023Yd6C = AbstractC8014Ud6.c(0, interfaceC22053ub1, 0, 1);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == aVar.a()) {
                objB2 = AbstractC10721c52.k(C18712p72.a, interfaceC22053ub1);
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) objB2;
            Object[] objArr2 = new Object[0];
            interfaceC22053ub1.W(-1768740683);
            Object objB3 = interfaceC22053ub1.B();
            if (objB3 == aVar.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Mk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5217Ik.b.E();
                    }
                };
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym42 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr2, null, null, (SA2) objB3, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            Object[] objArr3 = new Object[0];
            interfaceC22053ub1.W(-1768738411);
            Object objB4 = interfaceC22053ub1.B();
            if (objB4 == aVar.a()) {
                objB4 = new SA2() { // from class: ir.nasim.Nk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5217Ik.b.H();
                    }
                };
                interfaceC22053ub1.s(objB4);
            }
            interfaceC22053ub1.Q();
            final InterfaceC9102Ym4 interfaceC9102Ym43 = (InterfaceC9102Ym4) AbstractC9681aN5.e(objArr3, null, null, (SA2) objB4, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 6);
            G10 g10 = G10.a;
            int i3 = G10.b;
            InterfaceC9664aL6 interfaceC9664aL6A = BD6.a(g10.a(interfaceC22053ub1, i3).K(), AbstractC5999Lt.l(AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT, 0, null, 6, null), "rippleColor", null, interfaceC22053ub1, 432, 8);
            interfaceC22053ub1.W(-1768730199);
            long jX = v(interfaceC9102Ym43) ? x(interfaceC9664aL6A) : g10.a(interfaceC22053ub1, i3).r();
            interfaceC22053ub1.Q();
            Boolean boolValueOf = Boolean.valueOf(v(interfaceC9102Ym43));
            interfaceC22053ub1.W(-1768726474);
            boolean zV = interfaceC22053ub1.V(interfaceC9102Ym43);
            Object objB5 = interfaceC22053ub1.B();
            if (zV || objB5 == aVar.a()) {
                objB5 = new a(interfaceC9102Ym43, null);
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB5, interfaceC22053ub1, 0);
            interfaceC22053ub1.W(-1768721922);
            if (this.a instanceof AbstractC20864sk.c) {
                e.a aVar2 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar2, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
                InterfaceC12529em.a aVar3 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar3.o(), false);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM);
                InterfaceC16030kb1.a aVar4 = InterfaceC16030kb1.d0;
                SA2 sa2A = aVar4.a();
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
                DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar4.e());
                DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar4.g());
                InterfaceC14603iB2 interfaceC14603iB2B = aVar4.b();
                if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                    interfaceC22053ub1A.s(Integer.valueOf(iA));
                    interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                }
                DG7.c(interfaceC22053ub1A, eVarE, aVar4.f());
                AbstractC10628bv5.a(androidx.compose.foundation.layout.h.a.h(aVar2, aVar3.e()), g10.a(interfaceC22053ub1, i3).I(), 0.0f, 0L, 0, interfaceC22053ub1, 0, 28);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1768706948);
            if (this.a instanceof AbstractC20864sk.a) {
                e.a aVar5 = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarM2 = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar5, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
                InterfaceC12529em.a aVar6 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3G2 = androidx.compose.foundation.layout.f.g(aVar6.o(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarM2);
                InterfaceC16030kb1.a aVar7 = InterfaceC16030kb1.d0;
                SA2 sa2A2 = aVar7.a();
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G2, aVar7.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar7.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar7.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar7.f());
                AbstractC9339Zm7.b(UY6.c(AbstractC12217eE5.bank_first_toast_for_check_network_description, interfaceC22053ub1, 0), androidx.compose.foundation.layout.q.i(androidx.compose.foundation.layout.h.a.h(aVar5, aVar6.e()), g10.c(interfaceC22053ub1, i3).b().c()), g10.a(interfaceC22053ub1, i3).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1, i3).a(), interfaceC22053ub1, 0, 0, 65528);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
                return;
            }
            interfaceC22053ub1.Q();
            e.a aVar8 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar8, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null), g10.a(interfaceC22053ub1, i3).r(), null, 2, null);
            SA2 sa2 = this.b;
            SA2 sa22 = this.c;
            AbstractC20864sk abstractC20864sk = this.a;
            InterfaceC12529em.a aVar9 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G3 = androidx.compose.foundation.layout.f.g(aVar9.o(), false);
            int iA3 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q3 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE3 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
            InterfaceC16030kb1.a aVar10 = InterfaceC16030kb1.d0;
            SA2 sa2A3 = aVar10.a();
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
            DG7.c(interfaceC22053ub1A3, interfaceC10970cW3G3, aVar10.e());
            DG7.c(interfaceC22053ub1A3, interfaceC11819dc1Q3, aVar10.g());
            InterfaceC14603iB2 interfaceC14603iB2B3 = aVar10.b();
            if (interfaceC22053ub1A3.h() || !AbstractC13042fc3.d(interfaceC22053ub1A3.B(), Integer.valueOf(iA3))) {
                interfaceC22053ub1A3.s(Integer.valueOf(iA3));
                interfaceC22053ub1A3.v(Integer.valueOf(iA3), interfaceC14603iB2B3);
            }
            DG7.c(interfaceC22053ub1A3, eVarE3, aVar10.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            androidx.compose.ui.e eVarG = AbstractC8014Ud6.g(hVar.h(aVar8, aVar9.m()), c9023Yd6C, false, null, false, 14, null);
            C24254yJ c24254yJ = C24254yJ.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(c24254yJ.h(), aVar9.g(), interfaceC22053ub1, 54);
            int iA4 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q4 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE4 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarG);
            SA2 sa2A4 = aVar10.a();
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
            DG7.c(interfaceC22053ub1A4, interfaceC10970cW3A, aVar10.e());
            DG7.c(interfaceC22053ub1A4, interfaceC11819dc1Q4, aVar10.g());
            InterfaceC14603iB2 interfaceC14603iB2B4 = aVar10.b();
            if (interfaceC22053ub1A4.h() || !AbstractC13042fc3.d(interfaceC22053ub1A4.B(), Integer.valueOf(iA4))) {
                interfaceC22053ub1A4.s(Integer.valueOf(iA4));
                interfaceC22053ub1A4.v(Integer.valueOf(iA4), interfaceC14603iB2B4);
            }
            DG7.c(interfaceC22053ub1A4, eVarE4, aVar10.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar8, g10.c(interfaceC22053ub1, i3).b().c()), interfaceC22053ub1, 0);
            AbstractC5217Ik.w(UY6.c(QD5.phone_change_intro_title, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            AbstractC5217Ik.q(AbstractC10360bX0.p(UY6.c(QD5.phone_change_bullet_1, interfaceC22053ub1, 0), UY6.c(QD5.phone_change_bullet_2, interfaceC22053ub1, 0), UY6.c(QD5.phone_change_bullet_3, interfaceC22053ub1, 0), UY6.c(QD5.phone_change_bullet_4, interfaceC22053ub1, 0)), interfaceC22053ub1, 0);
            AbstractC5217Ik.w(UY6.c(QD5.phone_change_intro_title_2, interfaceC22053ub1, 0), interfaceC22053ub1, 0);
            AbstractC5217Ik.q(AbstractC10360bX0.p(UY6.c(QD5.phone_change_bullet_1_1, interfaceC22053ub1, 0), UY6.c(QD5.phone_change_bullet_1_2, interfaceC22053ub1, 0), UY6.c(QD5.phone_change_bullet_1_3, interfaceC22053ub1, 0), UY6.c(QD5.phone_change_bullet_1_4, interfaceC22053ub1, 0)), interfaceC22053ub1, 0);
            float f = 1;
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.c(androidx.compose.foundation.layout.q.k(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.i(aVar8, C17784nZ1.q(f)), 0.0f, 1, null), g10.c(interfaceC22053ub1, i3).b().c(), 0.0f, 2, null), g10.a(interfaceC22053ub1, i3).A(), new C12993fX1(C17784nZ1.q(10), null)), interfaceC22053ub1, 0);
            boolean zF = F(interfaceC9102Ym42);
            interfaceC22053ub1.W(-1789034758);
            boolean zV2 = interfaceC22053ub1.V(interfaceC9102Ym42);
            Object objB6 = interfaceC22053ub1.B();
            if (zV2 || objB6 == aVar.a()) {
                objB6 = new SA2() { // from class: ir.nasim.Ok
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5217Ik.b.z(interfaceC9102Ym42);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            interfaceC22053ub1.Q();
            AbstractC5217Ik.t(zF, jX, (SA2) objB6, interfaceC22053ub1, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar8, C17784nZ1.q(79)), interfaceC22053ub1, 6);
            interfaceC22053ub1.u();
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(hVar.h(aVar8, aVar9.b()), 0.0f, 1, null), g10.a(interfaceC22053ub1, i3).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A2 = XY0.a(c24254yJ.a(), aVar9.g(), interfaceC22053ub1, 54);
            int iA5 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q5 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE5 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD2);
            SA2 sa2A5 = aVar10.a();
            if (!(interfaceC22053ub1.l() instanceof InterfaceC15247jG)) {
                AbstractC6797Pa1.c();
            }
            interfaceC22053ub1.G();
            if (interfaceC22053ub1.h()) {
                interfaceC22053ub1.g(sa2A5);
            } else {
                interfaceC22053ub1.r();
            }
            InterfaceC22053ub1 interfaceC22053ub1A5 = DG7.a(interfaceC22053ub1);
            DG7.c(interfaceC22053ub1A5, interfaceC10970cW3A2, aVar10.e());
            DG7.c(interfaceC22053ub1A5, interfaceC11819dc1Q5, aVar10.g());
            InterfaceC14603iB2 interfaceC14603iB2B5 = aVar10.b();
            if (interfaceC22053ub1A5.h() || !AbstractC13042fc3.d(interfaceC22053ub1A5.B(), Integer.valueOf(iA5))) {
                interfaceC22053ub1A5.s(Integer.valueOf(iA5));
                interfaceC22053ub1A5.v(Integer.valueOf(iA5), interfaceC14603iB2B5);
            }
            DG7.c(interfaceC22053ub1A5, eVarE5, aVar10.f());
            ZV1.b(androidx.compose.foundation.layout.t.y(androidx.compose.foundation.layout.t.h(aVar8, 0.0f, 1, null), C17784nZ1.q(f)), 0.0f, g10.a(interfaceC22053ub1, i3).A(), interfaceC22053ub1, 6, 2);
            boolean zF2 = F(interfaceC9102Ym42);
            interfaceC22053ub1.W(-1789004887);
            boolean zV3 = interfaceC22053ub1.V(interfaceC9102Ym43);
            Object objB7 = interfaceC22053ub1.B();
            if (zV3 || objB7 == aVar.a()) {
                objB7 = new UA2() { // from class: ir.nasim.Pk
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC5217Ik.b.A(interfaceC9102Ym43, ((Boolean) obj).booleanValue());
                    }
                };
                interfaceC22053ub1.s(objB7);
            }
            UA2 ua2 = (UA2) objB7;
            interfaceC22053ub1.Q();
            AbstractC20864sk.d dVar = abstractC20864sk instanceof AbstractC20864sk.d ? (AbstractC20864sk.d) abstractC20864sk : null;
            boolean zB = dVar != null ? dVar.b() : false;
            interfaceC22053ub1.W(-1788999825);
            boolean zV4 = interfaceC22053ub1.V(interfaceC9102Ym4);
            Object objB8 = interfaceC22053ub1.B();
            if (zV4 || objB8 == aVar.a()) {
                objB8 = new SA2() { // from class: ir.nasim.Qk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5217Ik.b.B(interfaceC9102Ym4);
                    }
                };
                interfaceC22053ub1.s(objB8);
            }
            interfaceC22053ub1.Q();
            AbstractC5217Ik.y(zF2, sa2, interfaceC20315ro1, c9023Yd6C, sa22, ua2, zB, (SA2) objB8, interfaceC22053ub1, 0, 0);
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
            if (y(interfaceC9102Ym4)) {
                interfaceC22053ub1.W(-1768583662);
                boolean zV5 = interfaceC22053ub1.V(interfaceC9102Ym4);
                Object objB9 = interfaceC22053ub1.B();
                if (zV5 || objB9 == aVar.a()) {
                    objB9 = new SA2() { // from class: ir.nasim.Rk
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC5217Ik.b.C(interfaceC9102Ym4);
                        }
                    };
                    interfaceC22053ub1.s(objB9);
                }
                interfaceC22053ub1.Q();
                AbstractC6687Oo.a((SA2) objB9, null, AbstractC19242q11.e(1394268851, true, new C0424b(this.d, interfaceC9102Ym4, this.c, this.a), interfaceC22053ub1, 54), interfaceC22053ub1, 384, 2);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            p((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Ik$c */
    static final class c extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C9023Yd6 c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(C9023Yd6 c9023Yd6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c9023Yd6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new c(this.c, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C9023Yd6 c9023Yd6 = this.c;
                int iN = c9023Yd6.n();
                this.b = 1;
                if (C9023Yd6.l(c9023Yd6, iN, null, this, 2, null) == objE) {
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
            return ((c) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(UA2 ua2, Throwable th) {
        ua2.invoke(Boolean.TRUE);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(boolean z, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, C9023Yd6 c9023Yd6, SA2 sa22, UA2 ua2, boolean z2, SA2 sa23, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$onSubmit");
        AbstractC13042fc3.i(interfaceC20315ro1, "$rememberCoroutineScope");
        AbstractC13042fc3.i(c9023Yd6, "$rememberScrollState");
        AbstractC13042fc3.i(sa22, "$onCancel");
        AbstractC13042fc3.i(sa23, "$onShowDialog");
        y(z, sa2, interfaceC20315ro1, c9023Yd6, sa22, ua2, z2, sa23, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 C(boolean z) {
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m(ir.nasim.SA2 r21, ir.nasim.SA2 r22, final ir.nasim.SA2 r23, final ir.nasim.AbstractC20864sk r24, ir.nasim.InterfaceC22053ub1 r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 307
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5217Ik.m(ir.nasim.SA2, ir.nasim.SA2, ir.nasim.SA2, ir.nasim.sk, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(SA2 sa2, SA2 sa22, SA2 sa23, AbstractC20864sk abstractC20864sk, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa23, "$openServices");
        AbstractC13042fc3.i(abstractC20864sk, "$walletState");
        m(sa2, sa22, sa23, abstractC20864sk, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(78274399);
        int i3 = 2;
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                e.a aVar = androidx.compose.ui.e.a;
                G10 g10 = G10.a;
                int i4 = G10.b;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.k(aVar, g10.c(interfaceC22053ub1J, i4).b().c(), 0.0f, i3, null), 0.0f, 1, null);
                C24254yJ.e eVarG = C24254yJ.a.g();
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, aVar2.l(), interfaceC22053ub1J, 0);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarH);
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
                androidx.compose.ui.e eVarT = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().j());
                InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.e(), false);
                int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
                androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarT);
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
                DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
                DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
                InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
                if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                    interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                    interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
                }
                DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
                androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
                final long jB = g10.a(interfaceC22053ub1J, i4).B();
                androidx.compose.ui.e eVarT2 = androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().n());
                interfaceC22053ub1J.W(1474355677);
                boolean zF = interfaceC22053ub1J.f(jB);
                Object objB = interfaceC22053ub1J.B();
                if (zF || objB == InterfaceC22053ub1.a.a()) {
                    objB = new UA2() { // from class: ir.nasim.Bk
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC5217Ik.r(jB, (InterfaceC17460n02) obj);
                        }
                    };
                    interfaceC22053ub1J.s(objB);
                }
                interfaceC22053ub1J.Q();
                AbstractC22443vF0.a(eVarT2, (UA2) objB, interfaceC22053ub1J, 0);
                interfaceC22053ub1J.u();
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().g()), interfaceC22053ub1J, 0);
                C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1J, i4).b();
                AbstractC9339Zm7.b(str, null, g10.a(interfaceC22053ub1J, i4).B(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7B.b((16744447 & 1) != 0 ? c9348Zn7B.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7B.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7B.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7B.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7B.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7B.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7B.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7B.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7B.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7B.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7B.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7B.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7B.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7B.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7B.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7B.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7B.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7B.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7B.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7B.c : null, (16744447 & 1048576) != 0 ? c9348Zn7B.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7B.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7B.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7B.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
                interfaceC22053ub1J.u();
                ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().c()), interfaceC22053ub1J, 0);
                i3 = 2;
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ck
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5217Ik.s(list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 r(long j, InterfaceC17460n02 interfaceC17460n02) {
        AbstractC13042fc3.i(interfaceC17460n02, "$this$Canvas");
        InterfaceC17460n02.L(interfaceC17460n02, j, OD6.h(interfaceC17460n02.d()) / 2, 0L, 0.0f, null, null, 0, 124, null);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$titles");
        q(list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final boolean z, final long j, final SA2 sa2, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-1425649843);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.a(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.f(j) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            interfaceC22053ub1J.W(2094415970);
            boolean z2 = (i2 & 896) == 256;
            Object objB = interfaceC22053ub1J.B();
            if (z2 || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Dk
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC5217Ik.u(sa2);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.e.f(eVarH, false, null, null, (SA2) objB, 7, null), j, null, 2, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(eVarD, g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().e());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), InterfaceC12529em.a.l(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
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
            KX.f(null, new LX.a(z, null, false, 6, null), interfaceC22053ub1J, LX.a.d << 3, 1);
            ZH6.a(androidx.compose.foundation.layout.t.y(aVar, g10.c(interfaceC22053ub1J, i3).b().d()), interfaceC22053ub1J, 0);
            String strC = UY6.c(QD5.phone_change_intro_terms, interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1J, i3).b();
            AbstractC9339Zm7.b(strC, null, g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7B.b((16744447 & 1) != 0 ? c9348Zn7B.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7B.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7B.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7B.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7B.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7B.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7B.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7B.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7B.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7B.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7B.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7B.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7B.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7B.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7B.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7B.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7B.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7B.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7B.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7B.c : null, (16744447 & 1048576) != 0 ? c9348Zn7B.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7B.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7B.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7B.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ek
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5217Ik.v(z, j, sa2, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 u(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$onClick");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(boolean z, long j, SA2 sa2, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onClick");
        t(z, j, sa2, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final String str, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2060079095);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(aVar, g10.c(interfaceC22053ub1J, i3).b().c(), 0.0f, g10.c(interfaceC22053ub1J, i3).b().c(), g10.c(interfaceC22053ub1J, i3).b().c(), 2, null);
            C9348Zn7 c9348Zn7L = g10.d(interfaceC22053ub1J, i3).l();
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC9339Zm7.b(str, eVarM, g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7L.b((16744447 & 1) != 0 ? c9348Zn7L.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7L.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7L.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7L.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7L.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7L.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7L.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7L.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7L.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7L.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7L.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7L.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7L.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7L.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7L.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7L.b.h() : C6399Nk7.b.f(), (16744447 & 65536) != 0 ? c9348Zn7L.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7L.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7L.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7L.c : null, (16744447 & 1048576) != 0 ? c9348Zn7L.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7L.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7L.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7L.b.k() : null), interfaceC22053ub12, i2 & 14, 0, 65528);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Fk
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC5217Ik.x(str, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(String str, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(str, "$title");
        w(str, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0242  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void y(final boolean r29, final ir.nasim.SA2 r30, final ir.nasim.InterfaceC20315ro1 r31, final ir.nasim.C9023Yd6 r32, final ir.nasim.SA2 r33, ir.nasim.UA2 r34, final boolean r35, final ir.nasim.SA2 r36, ir.nasim.InterfaceC22053ub1 r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 713
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC5217Ik.y(boolean, ir.nasim.SA2, ir.nasim.ro1, ir.nasim.Yd6, ir.nasim.SA2, ir.nasim.UA2, boolean, ir.nasim.SA2, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(boolean z, boolean z2, SA2 sa2, SA2 sa22, InterfaceC20315ro1 interfaceC20315ro1, C9023Yd6 c9023Yd6, final UA2 ua2) {
        AbstractC13042fc3.i(sa2, "$onSubmit");
        AbstractC13042fc3.i(sa22, "$onShowDialog");
        AbstractC13042fc3.i(interfaceC20315ro1, "$rememberCoroutineScope");
        AbstractC13042fc3.i(c9023Yd6, "$rememberScrollState");
        if (z && !z2) {
            sa2.invoke();
        } else if (z && z2) {
            sa22.invoke();
        } else {
            AbstractC10533bm0.d(interfaceC20315ro1, null, null, new c(c9023Yd6, null), 3, null).s(new UA2() { // from class: ir.nasim.Gk
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC5217Ik.A(ua2, (Throwable) obj);
                }
            });
        }
        return C19938rB7.a;
    }
}
