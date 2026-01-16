package ir.nasim;

import android.content.Context;
import android.widget.ImageView;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC4692Gd5;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.core.modules.file.entity.FileReference;
import ir.nasim.core.modules.profile.entity.ExPeerType;
import java.util.List;

/* renamed from: ir.nasim.Gd5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4692Gd5 {

    /* renamed from: ir.nasim.Gd5$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ ImageView a;

        a(ImageView imageView) {
            this.a = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ImageView d(ImageView imageView, Context context) {
            AbstractC13042fc3.i(imageView, "$imageView");
            AbstractC13042fc3.i(context, "it");
            return imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 f(ImageView imageView) {
            AbstractC13042fc3.i(imageView, "it");
            imageView.invalidate();
            return C19938rB7.a;
        }

        public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            interfaceC22053ub1.W(-1567412652);
            boolean zD = interfaceC22053ub1.D(this.a);
            final ImageView imageView = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.Ed5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4692Gd5.a.d(imageView, (Context) obj);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            UA2 ua2 = (UA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(-1567411466);
            Object objB2 = interfaceC22053ub1.B();
            if (objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Fd5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4692Gd5.a.f((ImageView) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC11355cs.a(ua2, null, (UA2) objB2, interfaceC22053ub1, 384, 2);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.Gd5$b */
    public static final class b implements KV1 {
        final /* synthetic */ C23880xg2 a;

        public b(C23880xg2 c23880xg2) {
            this.a = c23880xg2;
        }

        @Override // ir.nasim.KV1
        public void dispose() {
            C23880xg2 c23880xg2 = this.a;
            if (c23880xg2 != null) {
                c23880xg2.m();
            }
            C23880xg2 c23880xg22 = this.a;
            if (c23880xg22 != null) {
                c23880xg22.q();
            }
        }
    }

    /* renamed from: ir.nasim.Gd5$c */
    static final class c implements InterfaceC14603iB2 {
        final /* synthetic */ List a;
        final /* synthetic */ InterfaceC14603iB2 b;
        final /* synthetic */ UA2 c;
        final /* synthetic */ ExPeerType d;
        final /* synthetic */ C11458d25 e;
        final /* synthetic */ SA2 f;

        /* renamed from: ir.nasim.Gd5$c$a */
        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ List c;
            final /* synthetic */ InterfaceC17916nm4 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(List list, InterfaceC17916nm4 interfaceC17916nm4, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = list;
                this.d = interfaceC17916nm4;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (this.c.size() == c.o(this.d)) {
                    c.p(this.d, c.o(this.d) - 1);
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        c(List list, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, ExPeerType exPeerType, C11458d25 c11458d25, SA2 sa2) {
            this.a = list;
            this.b = interfaceC14603iB2;
            this.c = ua2;
            this.d = exPeerType;
            this.e = c11458d25;
            this.f = sa2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final InterfaceC17916nm4 i(List list) {
            return UG6.a(list.size() - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 k(InterfaceC14603iB2 interfaceC14603iB2, List list, UA2 ua2, InterfaceC17916nm4 interfaceC17916nm4) {
            AbstractC13042fc3.i(interfaceC14603iB2, "$onClick");
            AbstractC13042fc3.i(ua2, "$onScrollToMessage");
            AbstractC13042fc3.i(interfaceC17916nm4, "$pinSelectedIndex$delegate");
            interfaceC14603iB2.invoke(Integer.valueOf(Math.abs(list.size() - o(interfaceC17916nm4))), list.get(o(interfaceC17916nm4)));
            ua2.invoke(list.get(o(interfaceC17916nm4)));
            p(interfaceC17916nm4, o(interfaceC17916nm4) - 1);
            if (o(interfaceC17916nm4) == -1) {
                p(interfaceC17916nm4, list.size() - 1);
            }
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 n(InterfaceC9102Ym4 interfaceC9102Ym4, InterfaceC17460n02 interfaceC17460n02) {
            AbstractC13042fc3.i(interfaceC9102Ym4, "$strokeColor$delegate");
            AbstractC13042fc3.i(interfaceC17460n02, "$this$drawBehind");
            long jV = v(interfaceC9102Ym4);
            float fIntBitsToFloat = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
            long jE = ZG4.e((Float.floatToRawIntBits(fIntBitsToFloat) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
            float fIntBitsToFloat2 = Float.intBitsToFloat((int) (interfaceC17460n02.d() >> 32));
            float fIntBitsToFloat3 = Float.intBitsToFloat((int) (interfaceC17460n02.d() & 4294967295L));
            InterfaceC17460n02.V0(interfaceC17460n02, jV, jE, ZG4.e((4294967295L & Float.floatToRawIntBits(fIntBitsToFloat3)) | (Float.floatToRawIntBits(fIntBitsToFloat2) << 32)), interfaceC17460n02.w1(C17784nZ1.q(1)), 0, null, 0.0f, null, 0, 496, null);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final int o(InterfaceC17916nm4 interfaceC17916nm4) {
            return interfaceC17916nm4.d();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void p(InterfaceC17916nm4 interfaceC17916nm4, int i) {
            interfaceC17916nm4.h(i);
        }

        private static final int t(InterfaceC17916nm4 interfaceC17916nm4) {
            return interfaceC17916nm4.d();
        }

        private static final long v(InterfaceC9102Ym4 interfaceC9102Ym4) {
            return ((C24381yX0) interfaceC9102Ym4.getValue()).y();
        }

        public final void h(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            Object[] objArr = new Object[0];
            interfaceC22053ub1.W(1986984087);
            boolean zD = interfaceC22053ub1.D(this.a);
            final List list = this.a;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new SA2() { // from class: ir.nasim.Hd5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC4692Gd5.c.i(list);
                    }
                };
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            final InterfaceC17916nm4 interfaceC17916nm4 = (InterfaceC17916nm4) AbstractC9681aN5.e(objArr, null, null, (SA2) objB, interfaceC22053ub1, 0, 6);
            int iO = o(interfaceC17916nm4);
            interfaceC22053ub1.W(1986987266);
            boolean zE = interfaceC22053ub1.e(iO) | interfaceC22053ub1.V(this.a);
            List list2 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zE || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = UG6.a(list2.size() > 5 ? AbstractC23053wG5.e(o(interfaceC17916nm4) - ((list2.size() - 1) % 5), 0) : o(interfaceC17916nm4));
                interfaceC22053ub1.s(objB2);
            }
            InterfaceC17916nm4 interfaceC17916nm42 = (InterfaceC17916nm4) objB2;
            interfaceC22053ub1.Q();
            List list3 = this.a;
            interfaceC22053ub1.W(1986998764);
            boolean zD2 = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(interfaceC17916nm4);
            List list4 = this.a;
            Object objB3 = interfaceC22053ub1.B();
            if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                objB3 = new a(list4, interfaceC17916nm4, null);
                interfaceC22053ub1.s(objB3);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(list3, (InterfaceC14603iB2) objB3, interfaceC22053ub1, 0);
            G10 g10 = G10.a;
            int i2 = G10.b;
            long jC = g10.a(interfaceC22053ub1, i2).C();
            interfaceC22053ub1.W(1987003986);
            Object objB4 = interfaceC22053ub1.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB4 == aVar.a()) {
                objB4 = AbstractC13472gH6.d(C24381yX0.k(jC), null, 2, null);
                interfaceC22053ub1.s(objB4);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB4;
            interfaceC22053ub1.Q();
            e.a aVar2 = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(aVar2, 0.0f, 1, null), C17784nZ1.q(50)), g10.a(interfaceC22053ub1, i2).r(), null, 2, null);
            interfaceC22053ub1.W(1987012507);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(interfaceC17916nm4) | interfaceC22053ub1.V(this.c);
            final InterfaceC14603iB2 interfaceC14603iB2 = this.b;
            final List list5 = this.a;
            final UA2 ua2 = this.c;
            Object objB5 = interfaceC22053ub1.B();
            if (zV || objB5 == aVar.a()) {
                objB5 = new SA2() { // from class: ir.nasim.Id5
                    @Override // ir.nasim.SA2
                    public final Object invoke() {
                        return AbstractC4692Gd5.c.k(interfaceC14603iB2, list5, ua2, interfaceC17916nm4);
                    }
                };
                interfaceC22053ub1.s(objB5);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarD, false, null, null, (SA2) objB5, 7, null);
            interfaceC22053ub1.W(1987023735);
            Object objB6 = interfaceC22053ub1.B();
            if (objB6 == aVar.a()) {
                objB6 = new UA2() { // from class: ir.nasim.Jd5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4692Gd5.c.n(interfaceC9102Ym4, (InterfaceC17460n02) obj);
                    }
                };
                interfaceC22053ub1.s(objB6);
            }
            interfaceC22053ub1.Q();
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(androidx.compose.ui.draw.b.b(eVarF, (UA2) objB6), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().n());
            InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
            C24254yJ.e eVarG = C24254yJ.a.g();
            List list6 = this.a;
            ExPeerType exPeerType = this.d;
            C11458d25 c11458d25 = this.e;
            SA2 sa2 = this.f;
            InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarG, cVarI, interfaceC22053ub1, 54);
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
            AbstractC4692Gd5.r(list6, t(interfaceC17916nm42), interfaceC22053ub1, 0);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().u()), interfaceC22053ub1, 0);
            AbstractC4692Gd5.w(list6, o(interfaceC17916nm4), interfaceC22053ub1, 0);
            AbstractC4692Gd5.C(m66, list6, o(interfaceC17916nm4), exPeerType, c11458d25, interfaceC22053ub1, 6);
            ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g10.c(interfaceC22053ub1, i2).b().c()), interfaceC22053ub1, 0);
            AbstractC4692Gd5.l(list6, sa2, exPeerType, interfaceC22053ub1, 0);
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            h((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 A(List list, UA2 ua2, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, ExPeerType exPeerType, C11458d25 c11458d25, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onScrollToMessage");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onClick");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c11458d25, "$peer");
        y(list, ua2, sa2, interfaceC14603iB2, exPeerType, c11458d25, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 B(List list, UA2 ua2, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2, ExPeerType exPeerType, C11458d25 c11458d25, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(ua2, "$onScrollToMessage");
        AbstractC13042fc3.i(interfaceC14603iB2, "$onClick");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c11458d25, "$peer");
        y(list, ua2, sa2, interfaceC14603iB2, exPeerType, c11458d25, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0237  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void C(final ir.nasim.L66 r51, final java.util.List r52, final int r53, final ir.nasim.core.modules.profile.entity.ExPeerType r54, final ir.nasim.C11458d25 r55, ir.nasim.InterfaceC22053ub1 r56, final int r57) {
        /*
            Method dump skipped, instructions count: 732
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4692Gd5.C(ir.nasim.L66, java.util.List, int, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.d25, ir.nasim.ub1, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 D(L66 l66, List list, int i, ExPeerType exPeerType, C11458d25 c11458d25, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(l66, "$this_PinText");
        AbstractC13042fc3.i(list, "$pinMessages");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        AbstractC13042fc3.i(c11458d25, "$peer");
        C(l66, list, i, exPeerType, c11458d25, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final List list, final SA2 sa2, final ExPeerType exPeerType, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(563205508);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= interfaceC22053ub1J.V(exPeerType) ? 256 : 128;
        }
        if ((i2 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            interfaceC22053ub1J.W(1873737381);
            boolean zV = ((i2 & 896) == 256) | interfaceC22053ub1J.V(list);
            Object objB = interfaceC22053ub1J.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = Integer.valueOf(AbstractC15208jB5.close);
                interfaceC22053ub1J.s(objB);
            }
            int iIntValue = ((Number) objB).intValue();
            interfaceC22053ub1J.Q();
            androidx.compose.ui.e eVarA = FV0.a(androidx.compose.ui.e.a, N46.g());
            G10 g10 = G10.a;
            int i3 = G10.b;
            androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(androidx.compose.foundation.layout.t.t(eVarA, g10.c(interfaceC22053ub1J, i3).b().i()), false, null, null, sa2, 7, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(InterfaceC12529em.a.e(), false);
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
            DG7.c(interfaceC22053ub1A, interfaceC10970cW3G, aVar.e());
            DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
            InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
            if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                interfaceC22053ub1A.s(Integer.valueOf(iA));
                interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
            }
            DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub12 = interfaceC22053ub1J;
            AbstractC24077y03.b(FV4.c(iIntValue, interfaceC22053ub1J, 0), UY6.c(DD5.dialog_negative_button_cancel, interfaceC22053ub1J, 0), null, g10.a(interfaceC22053ub1J, i3).B(), interfaceC22053ub12, 0, 4);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Ad5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4692Gd5.m(list, sa2, exPeerType, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 m(List list, SA2 sa2, ExPeerType exPeerType, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$pinMessages");
        AbstractC13042fc3.i(sa2, "$onCloseClicked");
        AbstractC13042fc3.i(exPeerType, "$exPeerType");
        l(list, sa2, exPeerType, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void n(final ZY0 zy0, final int i, final int i2, InterfaceC22053ub1 interfaceC22053ub1, final int i3) {
        long jK;
        AbstractC13042fc3.i(zy0, "<this>");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1142141903);
        int i4 = (i3 & 6) == 0 ? (interfaceC22053ub1J.V(zy0) ? 4 : 2) | i3 : i3;
        if ((i3 & 48) == 0) {
            i4 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i4 |= interfaceC22053ub1J.e(i2) ? 256 : 128;
        }
        if ((i4 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            for (int i5 = 0; i5 < i; i5++) {
                androidx.compose.ui.e eVarB = ZY0.b(zy0, androidx.compose.foundation.layout.t.y(androidx.compose.ui.e.a, C17784nZ1.q(3)), 1.0f, false, 2, null);
                if (i5 == i2) {
                    interfaceC22053ub1J.W(1452637045);
                    jK = G10.a.a(interfaceC22053ub1J, G10.b).I();
                } else {
                    interfaceC22053ub1J.W(1452638228);
                    jK = G10.a.a(interfaceC22053ub1J, G10.b).K();
                }
                interfaceC22053ub1J.Q();
                androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.c(eVarB, jK, N46.b(100)), interfaceC22053ub1J, 0);
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Dd5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4692Gd5.o(zy0, i, i2, i3, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 o(ZY0 zy0, int i, int i2, int i3, InterfaceC22053ub1 interfaceC22053ub1, int i4) {
        AbstractC13042fc3.i(zy0, "$this_DrawIndicators");
        n(zy0, i, i2, interfaceC22053ub1, QJ5.a(i3 | 1));
        return C19938rB7.a;
    }

    public static final void p(final long j, final float f, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-257848473);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.f(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.c(f) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            androidx.compose.foundation.layout.f.a(androidx.compose.foundation.b.c(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.y(androidx.compose.ui.e.a, C17784nZ1.q(3)), f), j, N46.b(100)), interfaceC22053ub1J, 0);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.ud5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4692Gd5.q(j, f, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 q(long j, float f, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        p(j, f, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final List list, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-129128356);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            C24254yJ c24254yJ = C24254yJ.a;
            G10 g10 = G10.a;
            int i4 = G10.b;
            C24254yJ.f fVarO = c24254yJ.o(g10.c(interfaceC22053ub1J, i4).b().g());
            e.a aVar = androidx.compose.ui.e.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(fVarO, InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, aVar);
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
            if (list.size() <= 5) {
                interfaceC22053ub1J.W(-219802475);
                n(c9784aZ0, list.size(), i, interfaceC22053ub1J, ((i3 << 3) & 896) | 6);
                interfaceC22053ub1J.Q();
            } else {
                interfaceC22053ub1J.W(-219691309);
                if (i == 0) {
                    interfaceC22053ub1J.W(-219645057);
                    p(g10.a(interfaceC22053ub1J, i4).I(), C17784nZ1.q(5), interfaceC22053ub1J, 48);
                    n(c9784aZ0, 4, -1, interfaceC22053ub1J, 438);
                    p(g10.a(interfaceC22053ub1J, i4).K(), C17784nZ1.q(3), interfaceC22053ub1J, 48);
                    interfaceC22053ub1J.Q();
                } else {
                    interfaceC22053ub1J.W(-219350898);
                    p(g10.a(interfaceC22053ub1J, i4).K(), C17784nZ1.q(3), interfaceC22053ub1J, 48);
                    n(c9784aZ0, 5, i - 1, interfaceC22053ub1J, 54);
                    interfaceC22053ub1J.Q();
                }
                interfaceC22053ub1J.Q();
            }
            interfaceC22053ub1J.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.yd5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4692Gd5.s(list, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 s(List list, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$pinMessages");
        r(list, i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    public static final void t(androidx.compose.ui.e eVar, final AbstractC17457n0 abstractC17457n0, final EnumC5425Jh0 enumC5425Jh0, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(abstractC17457n0, "documentContent");
        AbstractC13042fc3.i(enumC5425Jh0, "blurType");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-2126331671);
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
        if ((i2 & 2) != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= interfaceC22053ub1J.D(abstractC17457n0) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(enumC5425Jh0) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            Context context = (Context) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.g());
            interfaceC22053ub1J.W(-435642403);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            Object obj = objB;
            if (objB == aVar.a()) {
                ImageView imageView = new ImageView(context);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                interfaceC22053ub1J.s(imageView);
                obj = imageView;
            }
            final ImageView imageView2 = (ImageView) obj;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(-435636983);
            boolean zD = interfaceC22053ub1J.D(abstractC17457n0) | interfaceC22053ub1J.D(imageView2) | ((i3 & 896) == 256);
            Object objB2 = interfaceC22053ub1J.B();
            if (zD || objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Bd5
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj2) {
                        return AbstractC4692Gd5.u(abstractC17457n0, imageView2, enumC5425Jh0, (LV1) obj2);
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            interfaceC22053ub1J.Q();
            AbstractC10721c52.a(abstractC17457n0, (UA2) objB2, interfaceC22053ub1J, (i3 >> 3) & 14);
            F27.a(eVar3, N46.d(G10.a.c(interfaceC22053ub1J, G10.b).a().c()), 0L, 0L, 0.0f, 0.0f, null, AbstractC19242q11.e(1012566532, true, new a(imageView2), interfaceC22053ub1J, 54), interfaceC22053ub1J, (i3 & 14) | 12582912, 124);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Cd5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj2, Object obj3) {
                    return AbstractC4692Gd5.v(eVar3, abstractC17457n0, enumC5425Jh0, i, i2, (InterfaceC22053ub1) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final KV1 u(AbstractC17457n0 abstractC17457n0, ImageView imageView, EnumC5425Jh0 enumC5425Jh0, LV1 lv1) {
        C23880xg2 c23880xg2;
        FileReference fileReferenceB;
        C22694vg2 c22694vg2V;
        AbstractC13042fc3.i(abstractC17457n0, "$documentContent");
        AbstractC13042fc3.i(imageView, "$imageView");
        AbstractC13042fc3.i(enumC5425Jh0, "$blurType");
        AbstractC13042fc3.i(lv1, "$this$DisposableEffect");
        C23880xg2 c23880xg22 = null;
        bArrC = null;
        byte[] bArrC = null;
        FileReference fileReferenceB2 = null;
        if (!abstractC17457n0.m()) {
            if (abstractC17457n0 instanceof JM6) {
                JM6 jm6 = (JM6) abstractC17457n0;
                A23 a23U = jm6.u();
                if (a23U == null || (fileReferenceB = a23U.b()) == null) {
                    A23 a23V = jm6.v();
                    if (a23V != null) {
                        fileReferenceB2 = a23V.b();
                    }
                } else {
                    fileReferenceB2 = fileReferenceB;
                }
                c23880xg2 = new C23880xg2(imageView, enumC5425Jh0, fileReferenceB2);
            }
            return new b(c23880xg22);
        }
        C24967zW1 c24967zW1F = abstractC17457n0.f();
        if (c24967zW1F != null && (c22694vg2V = c24967zW1F.v()) != null) {
            bArrC = c22694vg2V.c();
        }
        c23880xg2 = new C23880xg2(imageView, enumC5425Jh0, bArrC);
        c23880xg22 = c23880xg2;
        return new b(c23880xg22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 v(androidx.compose.ui.e eVar, AbstractC17457n0 abstractC17457n0, EnumC5425Jh0 enumC5425Jh0, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(abstractC17457n0, "$documentContent");
        AbstractC13042fc3.i(enumC5425Jh0, "$blurType");
        t(eVar, abstractC17457n0, enumC5425Jh0, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(final List list, final int i, InterfaceC22053ub1 interfaceC22053ub1, final int i2) {
        int i3;
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(2019341844);
        if ((i2 & 6) == 0) {
            i3 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= interfaceC22053ub1J.e(i) ? 32 : 16;
        }
        if ((i3 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            S74 s74 = (S74) AbstractC15401jX0.t0(list, i);
            if (s74 != null) {
                J44 j44A = s74.a();
                C24967zW1 c24967zW1H = j44A.H();
                interfaceC22053ub1J.W(1658818706);
                if (c24967zW1H != null) {
                    interfaceC22053ub1J.W(1895475509);
                    if ((j44A.H() instanceof C13388g85) || (j44A.H() instanceof GS7) || (j44A.H() instanceof XG2)) {
                        e.a aVar = androidx.compose.ui.e.a;
                        G10 g10 = G10.a;
                        int i4 = G10.b;
                        t(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().l()), c24967zW1H, EnumC5425Jh0.BITMAP_BLUR, interfaceC22053ub1J, 384, 0);
                        ZH6.a(androidx.compose.foundation.layout.t.t(aVar, g10.c(interfaceC22053ub1J, i4).b().u()), interfaceC22053ub1J, 0);
                    }
                    interfaceC22053ub1J.Q();
                }
                interfaceC22053ub1J.Q();
                AbstractC17457n0 abstractC17457n0F = j44A.F();
                JM6 jm6 = abstractC17457n0F instanceof JM6 ? (JM6) abstractC17457n0F : null;
                interfaceC22053ub1J.W(1658835547);
                if (jm6 != null) {
                    e.a aVar2 = androidx.compose.ui.e.a;
                    G10 g102 = G10.a;
                    int i5 = G10.b;
                    t(androidx.compose.foundation.layout.t.t(aVar2, g102.c(interfaceC22053ub1J, i5).b().l()), jm6, EnumC5425Jh0.BITMAP_BLUR, interfaceC22053ub1J, 384, 0);
                    ZH6.a(androidx.compose.foundation.layout.t.t(aVar2, g102.c(interfaceC22053ub1J, i5).b().u()), interfaceC22053ub1J, 0);
                    C19938rB7 c19938rB7 = C19938rB7.a;
                }
                interfaceC22053ub1J.Q();
            }
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.xd5
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC4692Gd5.x(list, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 x(List list, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(list, "$pinMessages");
        w(list, i, interfaceC22053ub1, QJ5.a(i2 | 1));
        return C19938rB7.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void y(java.util.List r16, final ir.nasim.UA2 r17, ir.nasim.SA2 r18, final ir.nasim.InterfaceC14603iB2 r19, final ir.nasim.core.modules.profile.entity.ExPeerType r20, final ir.nasim.C11458d25 r21, ir.nasim.InterfaceC22053ub1 r22, final int r23, final int r24) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4692Gd5.y(java.util.List, ir.nasim.UA2, ir.nasim.SA2, ir.nasim.iB2, ir.nasim.core.modules.profile.entity.ExPeerType, ir.nasim.d25, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 z() {
        return C19938rB7.a;
    }
}
