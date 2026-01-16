package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import io.appmetrica.analytics.AppMetricaDefaultValues;
import ir.nasim.AbstractC10528bl5;
import ir.nasim.C24254yJ;
import ir.nasim.C6399Nk7;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.OA2;
import ir.nasim.features.bank.mybank.model.ServicesPageSectionEntity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.en5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC12545en5 {

    /* renamed from: ir.nasim.en5$a */
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
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            AbstractC12545en5.E(this.c, AbstractC10528bl5.a.a);
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* renamed from: ir.nasim.en5$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ SA2 a;
        final /* synthetic */ SA2 b;

        /* renamed from: ir.nasim.en5$b$a */
        static final class a implements InterfaceC15796kB2 {
            final /* synthetic */ SA2 a;

            a(SA2 sa2) {
                this.a = sa2;
            }

            public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(l66, "$this$BaleTopAppbar");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    AbstractC20434s03.a(this.a, null, false, null, null, Y71.a.a(), interfaceC22053ub1, 196608, 30);
                }
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        b(SA2 sa2, SA2 sa22) {
            this.a = sa2;
            this.b = sa22;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC21639ts7.i(UY6.c(QD5.base_premium_title, interfaceC22053ub1, 0), null, this.a, AbstractC19242q11.e(-1427226296, true, new a(this.b), interfaceC22053ub1, 54), null, null, null, interfaceC22053ub1, SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 114);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.en5$c */
    static final class c implements InterfaceC15796kB2 {
        final /* synthetic */ C13161fl5 a;
        final /* synthetic */ C14063hH6 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ SA2 d;
        final /* synthetic */ InterfaceC14603iB2 e;
        final /* synthetic */ InterfaceC14603iB2 f;
        final /* synthetic */ SA2 g;
        final /* synthetic */ VT1 h;
        final /* synthetic */ boolean i;

        c(C13161fl5 c13161fl5, C14063hH6 c14063hH6, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, SA2 sa23, VT1 vt1, boolean z) {
            this.a = c13161fl5;
            this.b = c14063hH6;
            this.c = sa2;
            this.d = sa22;
            this.e = interfaceC14603iB2;
            this.f = interfaceC14603iB22;
            this.g = sa23;
            this.h = vt1;
            this.i = z;
        }

        public final void a(TS4 ts4, InterfaceC22053ub1 interfaceC22053ub1, int i) {
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
            if (this.a.e()) {
                interfaceC22053ub1.W(-357754030);
                AbstractC12545en5.r(ts4, this.b, this.a, this.c, this.d, interfaceC22053ub1, i2 & 14);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-357517686);
                AbstractC12545en5.u(this.a.d(), this.e, this.c, this.f, this.g, this.h, ts4, this.b, this.i, interfaceC22053ub1, 3670016 & (i2 << 18));
                interfaceC22053ub1.Q();
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((TS4) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.en5$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        public static final d e = new d();

        public d() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.en5$e */
    public static final class e extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.en5$f */
    public static final class f extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.en5$g */
    public static final class g extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ SA2 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(List list, SA2 sa2) {
            super(4);
            this.e = list;
            this.f = sa2;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (interfaceC22053ub1.V(interfaceC6988Pv3) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= interfaceC22053ub1.e(i) ? 32 : 16;
            }
            if (!interfaceC22053ub1.o((i3 & 147) != 146, 1 & i3)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            C4950Hg2 c4950Hg2 = (C4950Hg2) this.e.get(i);
            interfaceC22053ub1.W(-913784307);
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
            AbstractC23933xl5.e(c4950Hg2, this.f, interfaceC22053ub1, 0);
            MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
        E(interfaceC9102Ym4, AbstractC10528bl5.d.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(AbstractC22767vn5 abstractC22767vn5, InterfaceC14603iB2 interfaceC14603iB2, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB22, SA2 sa22, VT1 vt1, TS4 ts4, C14063hH6 c14063hH6, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(abstractC22767vn5, "$state");
        AbstractC13042fc3.i(interfaceC14603iB2, "$purchasePackage");
        AbstractC13042fc3.i(sa2, "$onQuestionClick");
        AbstractC13042fc3.i(interfaceC14603iB22, "$calculateDiscountedPrice");
        AbstractC13042fc3.i(sa22, "$rollbackDiscountedPrice");
        AbstractC13042fc3.i(vt1, "$discountState");
        AbstractC13042fc3.i(ts4, "$paddingValues");
        AbstractC13042fc3.i(c14063hH6, "$banners");
        u(abstractC22767vn5, interfaceC14603iB2, sa2, interfaceC14603iB22, sa22, vt1, ts4, c14063hH6, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InterfaceC9102Ym4 C() {
        return AbstractC13472gH6.d(AbstractC10528bl5.a.a, null, 2, null);
    }

    private static final AbstractC10528bl5 D(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return (AbstractC10528bl5) interfaceC9102Ym4.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(InterfaceC9102Ym4 interfaceC9102Ym4, AbstractC10528bl5 abstractC10528bl5) {
        interfaceC9102Ym4.setValue(abstractC10528bl5);
    }

    private static final void F(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1342924456);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null);
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarF);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            String strC = UY6.c(AbstractC12217eE5.auth_error_unknown, interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarH = hVar.h(aVar, aVar2.e());
            G10 g10 = G10.a;
            int i2 = G10.b;
            AbstractC9339Zm7.b(strC, androidx.compose.foundation.layout.q.i(eVarH, g10.c(interfaceC22053ub1J, i2).b().c()), g10.a(interfaceC22053ub1J, i2).t(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, g10.d(interfaceC22053ub1J, i2).a(), interfaceC22053ub1J, 0, 0, 65528);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Om5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC12545en5.G(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 G(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        F(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void H(final ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(404078988);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            float f2 = 0.0f;
            Object obj = null;
            int i3 = 0;
            androidx.compose.foundation.layout.f.a(AbstractC21704tz6.a(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.t.i(aVar, C17784nZ1.q(36)), 0.0f, 1, null), (255 & 1) != 0 ? AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT : 0, (255 & 2) != 0 ? 0 : 0, (255 & 4) == 0 ? 0 : 0, (255 & 8) != 0 ? C19938rB7.a : null, (255 & 16) != 0 ? null : null, (255 & 32) != 0 ? EnumC14086hK2.b : null, (255 & 64) != 0 ? AbstractC4553Fp7.a.a() : 0, (255 & 128) != 0), interfaceC22053ub1J, 0);
            androidx.compose.ui.e eVarB = ZY0.b(zy0, aVar, 1.0f, false, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarB);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar2.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar2.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar2.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar2.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(-1334047856);
            int i4 = 0;
            while (i4 < 10) {
                AbstractC23933xl5.j(interfaceC22053ub1J, i3);
                MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
                i4++;
                interfaceC22053ub1J = interfaceC22053ub1J;
                obj = obj;
                f2 = f2;
                i3 = i3;
            }
            int i5 = i3;
            interfaceC22053ub12 = interfaceC22053ub1J;
            interfaceC22053ub12.Q();
            interfaceC22053ub12.u();
            MY2.b(null, null, 0L, interfaceC22053ub12, 0, 7);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, G10.a.c(interfaceC22053ub12, G10.b).b().c()), f2, 1, obj);
            interfaceC22053ub12.W(-226626119);
            Object objB = interfaceC22053ub12.B();
            if (objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Sm5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC12545en5.I();
                    }
                };
                interfaceC22053ub12.s(objB);
            }
            interfaceC22053ub12.Q();
            AbstractC17932no0.y(eVarH, (SA2) objB, InterfaceC19114po0.a.C1453a.a, null, UY6.c(QD5.base_premium_btn, interfaceC22053ub12, i5), null, interfaceC22053ub12, (InterfaceC19114po0.a.C1453a.b << 6) | 48, 40);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Tm5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return AbstractC12545en5.J(zy0, i, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 I() {
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 J(ZY0 zy0, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(zy0, "$this_PremiumLoadingState");
        H(zy0, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void K(final C13161fl5 c13161fl5, final SA2 sa2, final SA2 sa22, final InterfaceC14603iB2 interfaceC14603iB2, final InterfaceC14603iB2 interfaceC14603iB22, final SA2 sa23, final VT1 vt1, final SA2 sa24, final C14063hH6 c14063hH6, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(c13161fl5, "state");
        AbstractC13042fc3.i(sa2, "onBackPressed");
        AbstractC13042fc3.i(sa22, "onQuestionClick");
        AbstractC13042fc3.i(interfaceC14603iB2, "purchasePackage");
        AbstractC13042fc3.i(interfaceC14603iB22, "calculateDiscountedPrice");
        AbstractC13042fc3.i(sa23, "rollbackDiscountedPrice");
        AbstractC13042fc3.i(vt1, "discountState");
        AbstractC13042fc3.i(sa24, "openDetail");
        AbstractC13042fc3.i(c14063hH6, ServicesPageSectionEntity.BANNERS_SECTION_TITLE);
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1339812427);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(c13161fl5) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(interfaceC14603iB22) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa23) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(vt1) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= interfaceC22053ub1J.D(sa24) ? 8388608 : 4194304;
        }
        if ((100663296 & i) == 0) {
            i2 |= interfaceC22053ub1J.V(c14063hH6) ? 67108864 : 33554432;
        }
        if ((805306368 & i) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 536870912 : 268435456;
        }
        if ((i2 & 306783379) == 306783378 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC11029cc6.a(androidx.compose.foundation.layout.t.f(androidx.compose.ui.e.a, 0.0f, 1, null), AbstractC19242q11.e(2126455055, true, new b(sa2, sa22), interfaceC22053ub1J, 54), null, null, null, 0, G10.a.a(interfaceC22053ub1J, G10.b).r(), 0L, null, AbstractC19242q11.e(-457226918, true, new c(c13161fl5, c14063hH6, sa22, sa24, interfaceC14603iB2, interfaceC14603iB22, sa23, vt1, z), interfaceC22053ub12, 54), interfaceC22053ub12, 805306422, 444);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Nm5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC12545en5.L(c13161fl5, sa2, sa22, interfaceC14603iB2, interfaceC14603iB22, sa23, vt1, sa24, c14063hH6, z, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 L(C13161fl5 c13161fl5, SA2 sa2, SA2 sa22, InterfaceC14603iB2 interfaceC14603iB2, InterfaceC14603iB2 interfaceC14603iB22, SA2 sa23, VT1 vt1, SA2 sa24, C14063hH6 c14063hH6, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(c13161fl5, "$state");
        AbstractC13042fc3.i(sa2, "$onBackPressed");
        AbstractC13042fc3.i(sa22, "$onQuestionClick");
        AbstractC13042fc3.i(interfaceC14603iB2, "$purchasePackage");
        AbstractC13042fc3.i(interfaceC14603iB22, "$calculateDiscountedPrice");
        AbstractC13042fc3.i(sa23, "$rollbackDiscountedPrice");
        AbstractC13042fc3.i(vt1, "$discountState");
        AbstractC13042fc3.i(sa24, "$openDetail");
        AbstractC13042fc3.i(c14063hH6, "$banners");
        K(c13161fl5, sa2, sa22, interfaceC14603iB2, interfaceC14603iB22, sa23, vt1, sa24, c14063hH6, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    private static final void M(final ZY0 zy0, final List list, final SA2 sa2, final SA2 sa22, final boolean z, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-964347963);
        int i2 = (i & 6) == 0 ? (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.a(z) ? 16384 : 8192;
        }
        int i3 = i2;
        if ((i3 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            AbstractC5232Il5.c(UY6.c(QD5.base_premium_feat_title, interfaceC22053ub1J, 0), interfaceC22053ub1J, 0);
            interfaceC22053ub1J.W(601695104);
            boolean zV = interfaceC22053ub1J.V(list);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    AbstractC13610gX0.D(arrayList, ((C6167Ml5) it.next()).e());
                }
                HashSet hashSet = new HashSet();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : arrayList) {
                    if (hashSet.add(Long.valueOf(((C4950Hg2) obj).e()))) {
                        arrayList2.add(obj);
                    }
                }
                interfaceC22053ub1J.s(arrayList2);
                objB = arrayList2;
            }
            final List list2 = (List) objB;
            interfaceC22053ub1J.Q();
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarB = ZY0.b(zy0, aVar, 1.0f, false, 2, null);
            interfaceC22053ub1J.W(601698953);
            boolean zD = interfaceC22053ub1J.D(list2) | ((i3 & 896) == 256);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Pm5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return AbstractC12545en5.N(list2, sa2, (InterfaceC15069ix3) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVarB, null, null, false, null, null, null, false, null, (UA2) objB2, interfaceC22053ub1J, 0, 510);
            MY2.b(null, null, 0L, interfaceC22053ub1J, 0, 7);
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.i(aVar, G10.a.c(interfaceC22053ub1J, G10.b).b().c()), 0.0f, 1, null);
            interfaceC22053ub1J.W(601710368);
            boolean z2 = (i3 & 7168) == 2048;
            Object objB3 = interfaceC22053ub1J.B();
            if (z2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new SA2() { // from class: ir.nasim.Qm5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC12545en5.P(sa22);
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            SA2 sa23 = (SA2) objB3;
            interfaceC22053ub1J.Q();
            AbstractC17932no0.y(eVarH, sa23, z ? OA2.a.b : InterfaceC19114po0.b.a.a, null, UY6.c(QD5.base_premium_btn, interfaceC22053ub1J, 0), null, interfaceC22053ub1J, 0, 40);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Rm5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return AbstractC12545en5.Q(zy0, list, sa2, sa22, z, i, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 N(List list, SA2 sa2, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(list, "$features");
        AbstractC13042fc3.i(sa2, "$openDialog");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        interfaceC15069ix3.a(list.size(), new e(new UA2() { // from class: ir.nasim.Um5
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return AbstractC12545en5.O((C4950Hg2) obj);
            }
        }, list), new f(d.e, list), AbstractC19242q11.c(-632812321, true, new g(list, sa2)));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object O(C4950Hg2 c4950Hg2) {
        AbstractC13042fc3.i(c4950Hg2, "it");
        return Long.valueOf(c4950Hg2.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 P(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$showBottomSheet");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 Q(ZY0 zy0, List list, SA2 sa2, SA2 sa22, boolean z, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(zy0, "$this_PremiumSuccessState");
        AbstractC13042fc3.i(list, "$items");
        AbstractC13042fc3.i(sa2, "$openDialog");
        AbstractC13042fc3.i(sa22, "$showBottomSheet");
        M(zy0, list, sa2, sa22, z, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final TS4 ts4, final C14063hH6 c14063hH6, final C13161fl5 c13161fl5, final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1008059872);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.V(ts4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c14063hH6) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(c13161fl5) ? 256 : 128;
        }
        if ((i & SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 16384 : 8192;
        }
        if ((i2 & 9363) == 9362 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.f(aVar, 0.0f, 1, null), 0.0f, ts4.c(), 0.0f, 0.0f, 13, null);
            C24254yJ c24254yJ = C24254yJ.a;
            C24254yJ.m mVarH = c24254yJ.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarM);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3A, aVar3.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar3.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar3.f());
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            interfaceC22053ub1J.W(-785653541);
            if (!c14063hH6.isEmpty()) {
                AbstractC6891Pk5.k(androidx.compose.foundation.layout.q.i(aVar, G10.a.c(interfaceC22053ub1J, G10.b).b().e()), c14063hH6, interfaceC22053ub1J, i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER, 0);
            }
            interfaceC22053ub1J.Q();
            long jC = c13161fl5.c();
            interfaceC22053ub1J.W(-785648292);
            boolean zF = interfaceC22053ub1J.f(jC);
            Object objB = interfaceC22053ub1J.B();
            if (zF || objB == InterfaceC22053ub1.a.a()) {
                objB = WG6.a((long) Math.ceil(AbstractC23053wG5.f(c13161fl5.c() - (AbstractC20507s76.o() / AppMetricaDefaultValues.DEFAULT_MAX_REPORTS_IN_DATABASE_COUNT), 0L) / 86400));
                interfaceC22053ub1J.s(objB);
            }
            InterfaceC23352wm4 interfaceC23352wm4 = (InterfaceC23352wm4) objB;
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.foundation.b.d(eVarH, g10.a(interfaceC22053ub1J, i3).y(), null, 2, null), g10.c(interfaceC22053ub1J, i3).b().e(), g10.c(interfaceC22053ub1J, i3).b().c());
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(c24254yJ.g(), aVar2.l(), interfaceC22053ub1J, 0);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarJ);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3B, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.ui.e eVarB = L66.b(M66.a, aVar, 1.0f, false, 2, null);
            String strC = UY6.c(QD5.premium_info, interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7B = g10.d(interfaceC22053ub1J, i3).b();
            C6399Nk7.a aVar4 = C6399Nk7.b;
            AbstractC9339Zm7.b(strC, eVarB, g10.a(interfaceC22053ub1J, i3).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7B.b((16744447 & 1) != 0 ? c9348Zn7B.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7B.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7B.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7B.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7B.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7B.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7B.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7B.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7B.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7B.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7B.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7B.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7B.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7B.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7B.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7B.b.h() : aVar4.f(), (16744447 & 65536) != 0 ? c9348Zn7B.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7B.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7B.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7B.c : null, (16744447 & 1048576) != 0 ? c9348Zn7B.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7B.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7B.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7B.b.k() : null), interfaceC22053ub1J, 0, 0, 65528);
            String strV = XY6.v(String.valueOf(s(interfaceC23352wm4)));
            C9348Zn7 c9348Zn7C = g10.d(interfaceC22053ub1J, i3).c();
            AbstractC9339Zm7.b(strV, null, g10.a(interfaceC22053ub1J, i3).F(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C.b((16744447 & 1) != 0 ? c9348Zn7C.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7C.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C.b.h() : aVar4.f(), (16744447 & 65536) != 0 ? c9348Zn7C.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i3).b().g()), interfaceC22053ub1J, 0);
            String strC2 = UY6.c(QD5.premium_remain, interfaceC22053ub1J, 0);
            C9348Zn7 c9348Zn7C2 = g10.d(interfaceC22053ub1J, i3).c();
            AbstractC9339Zm7.b(strC2, null, g10.a(interfaceC22053ub1J, i3).D(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, c9348Zn7C2.b((16744447 & 1) != 0 ? c9348Zn7C2.a.g() : 0L, (16744447 & 2) != 0 ? c9348Zn7C2.a.k() : 0L, (16744447 & 4) != 0 ? c9348Zn7C2.a.n() : null, (16744447 & 8) != 0 ? c9348Zn7C2.a.l() : null, (16744447 & 16) != 0 ? c9348Zn7C2.a.m() : null, (16744447 & 32) != 0 ? c9348Zn7C2.a.i() : null, (16744447 & 64) != 0 ? c9348Zn7C2.a.j() : null, (16744447 & 128) != 0 ? c9348Zn7C2.a.o() : 0L, (16744447 & 256) != 0 ? c9348Zn7C2.a.e() : null, (16744447 & 512) != 0 ? c9348Zn7C2.a.u() : null, (16744447 & 1024) != 0 ? c9348Zn7C2.a.p() : null, (16744447 & 2048) != 0 ? c9348Zn7C2.a.d() : 0L, (16744447 & 4096) != 0 ? c9348Zn7C2.a.s() : null, (16744447 & 8192) != 0 ? c9348Zn7C2.a.r() : null, (16744447 & 16384) != 0 ? c9348Zn7C2.a.h() : null, (16744447 & 32768) != 0 ? c9348Zn7C2.b.h() : aVar4.f(), (16744447 & 65536) != 0 ? c9348Zn7C2.b.i() : 0, (16744447 & 131072) != 0 ? c9348Zn7C2.b.e() : 0L, (16744447 & 262144) != 0 ? c9348Zn7C2.b.j() : null, (16744447 & 524288) != 0 ? c9348Zn7C2.c : null, (16744447 & 1048576) != 0 ? c9348Zn7C2.b.f() : null, (16744447 & 2097152) != 0 ? c9348Zn7C2.b.d() : 0, (16744447 & 4194304) != 0 ? c9348Zn7C2.b.c() : 0, (16744447 & 8388608) != 0 ? c9348Zn7C2.b.k() : null), interfaceC22053ub1J, 0, 0, 65530);
            interfaceC22053ub1J.u();
            MY2.b(null, EnumC10352bW1.a, 0L, interfaceC22053ub1J, 48, 5);
            AbstractC4773Gm5.c(sa2, interfaceC22053ub1J, (i2 >> 9) & 14);
            AbstractC20880sl5.l(sa22, interfaceC22053ub1J, (i2 >> 12) & 14);
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.dn5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC12545en5.t(ts4, c14063hH6, c13161fl5, sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final long s(InterfaceC23352wm4 interfaceC23352wm4) {
        return interfaceC23352wm4.getLongValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 t(TS4 ts4, C14063hH6 c14063hH6, C13161fl5 c13161fl5, SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(ts4, "$paddingValues");
        AbstractC13042fc3.i(c14063hH6, "$banners");
        AbstractC13042fc3.i(c13161fl5, "$state");
        AbstractC13042fc3.i(sa2, "$onQuestionClick");
        AbstractC13042fc3.i(sa22, "$openDetail");
        r(ts4, c14063hH6, c13161fl5, sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:151:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0382  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void u(final ir.nasim.AbstractC22767vn5 r27, final ir.nasim.InterfaceC14603iB2 r28, final ir.nasim.SA2 r29, final ir.nasim.InterfaceC14603iB2 r30, final ir.nasim.SA2 r31, final ir.nasim.VT1 r32, final ir.nasim.TS4 r33, final ir.nasim.C14063hH6 r34, final boolean r35, ir.nasim.InterfaceC22053ub1 r36, final int r37) {
        /*
            Method dump skipped, instructions count: 1089
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC12545en5.u(ir.nasim.vn5, ir.nasim.iB2, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.SA2, ir.nasim.VT1, ir.nasim.TS4, ir.nasim.hH6, boolean, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
        E(interfaceC9102Ym4, AbstractC10528bl5.a.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 w(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
        E(interfaceC9102Ym4, AbstractC10528bl5.a.a);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(InterfaceC9102Ym4 interfaceC9102Ym4, long j) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
        E(interfaceC9102Ym4, new AbstractC10528bl5.c(j));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 y(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(sa2, "$rollbackDiscountedPrice");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
        E(interfaceC9102Ym4, AbstractC10528bl5.a.a);
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z(InterfaceC9102Ym4 interfaceC9102Ym4) {
        AbstractC13042fc3.i(interfaceC9102Ym4, "$dialogState$delegate");
        E(interfaceC9102Ym4, AbstractC10528bl5.b.a);
        return C19938rB7.a;
    }
}
