package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import androidx.compose.ui.e;
import ir.nasim.AbstractC16293l17;
import ir.nasim.AbstractC5914Lj3;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;
import ir.nasim.JK4;
import ir.nasim.OA2;
import ir.nasim.features.call.ui.AvatarAsyncImagePainterKt;
import ir.nasim.features.onboarding.data.model.OnboardingPeer;
import ir.nasim.features.onboarding.data.model.OnboardingSpot;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;

/* renamed from: ir.nasim.l17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC16293l17 {

    /* renamed from: ir.nasim.l17$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ JK4 a;

        a(JK4 jk4) {
            this.a = jk4;
        }

        public final void a(InterfaceC6988Pv3 interfaceC6988Pv3, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC6988Pv3, "$this$item");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                IK.b(androidx.compose.foundation.layout.c.b(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 1.4f, false, 2, null), ((JK4.b.e) this.a.e()).f(), null, InterfaceC13157fl1.a.b(), 0.0f, null, null, interfaceC22053ub1, 1575942, 52);
            }
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC6988Pv3) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l17$b */
    static final class b implements InterfaceC14603iB2 {
        final /* synthetic */ P07 a;
        final /* synthetic */ C25038zd6 b;

        /* renamed from: ir.nasim.l17$b$a */
        static final class a implements SA2 {
            final /* synthetic */ P07 a;
            final /* synthetic */ C25038zd6 b;

            a(P07 p07, C25038zd6 c25038zd6) {
                this.a = p07;
                this.b = c25038zd6;
            }

            public final void a() {
                AbstractC5914Lj3 abstractC5914Lj3C = this.a.c();
                if (abstractC5914Lj3C instanceof AbstractC5914Lj3.c) {
                    this.b.f().invoke(this.a.d());
                } else {
                    if (abstractC5914Lj3C instanceof AbstractC5914Lj3.b) {
                        return;
                    }
                    if (!(abstractC5914Lj3C instanceof AbstractC5914Lj3.a)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    this.b.h().invoke(this.a.d());
                }
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        /* renamed from: ir.nasim.l17$b$b, reason: collision with other inner class name */
        static final class C1366b implements SA2 {
            final /* synthetic */ C25038zd6 a;
            final /* synthetic */ P07 b;

            C1366b(C25038zd6 c25038zd6, P07 p07) {
                this.a = c25038zd6;
                this.b = p07;
            }

            public final void a() {
                this.a.h().invoke(this.b.d());
            }

            @Override // ir.nasim.SA2
            public /* bridge */ /* synthetic */ Object invoke() {
                a();
                return C19938rB7.a;
            }
        }

        b(P07 p07, C25038zd6 c25038zd6) {
            this.a = p07;
            this.b = c25038zd6;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            EV4 ev4H;
            String buttonText;
            InterfaceC19114po0 interfaceC19114po0;
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            e.a aVar = androidx.compose.ui.e.a;
            G10 g10 = G10.a;
            int i2 = G10.b;
            androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(aVar, g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().r());
            if (this.a.d().getPeerData().getAvatar() == null) {
                interfaceC22053ub1.W(-191227111);
                ev4H = coil.compose.e.a(null, null, null, null, 0, null, interfaceC22053ub1, 6, 62);
                interfaceC22053ub1.Q();
            } else {
                interfaceC22053ub1.W(-191117991);
                ev4H = AvatarAsyncImagePainterKt.h(this.a.d().getPeerData().getAvatar(), null, false, 0, interfaceC22053ub1, 0, 14);
                interfaceC22053ub1.Q();
            }
            EV4 ev4 = ev4H;
            String name = this.a.d().getPeerData().getName();
            String description = this.a.d().getDescription();
            AbstractC5914Lj3 abstractC5914Lj3C = this.a.c();
            interfaceC22053ub1.W(1656413313);
            if ((abstractC5914Lj3C instanceof AbstractC5914Lj3.c) || (abstractC5914Lj3C instanceof AbstractC5914Lj3.b)) {
                buttonText = this.a.d().getButtonText();
            } else {
                if (!(abstractC5914Lj3C instanceof AbstractC5914Lj3.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                buttonText = UY6.c(KD5.see, interfaceC22053ub1, 0);
            }
            String str = buttonText;
            interfaceC22053ub1.Q();
            AbstractC5914Lj3 abstractC5914Lj3C2 = this.a.c();
            if (abstractC5914Lj3C2 instanceof AbstractC5914Lj3.c) {
                interfaceC19114po0 = InterfaceC19114po0.b.a.a;
            } else if (abstractC5914Lj3C2 instanceof AbstractC5914Lj3.b) {
                interfaceC19114po0 = OA2.a.b;
            } else {
                if (!(abstractC5914Lj3C2 instanceof AbstractC5914Lj3.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                interfaceC19114po0 = InterfaceC19114po0.b.C1454b.a;
            }
            InterfaceC19114po0 interfaceC19114po02 = interfaceC19114po0;
            boolean hasBlueTick = this.a.d().getPeerData().getHasBlueTick();
            interfaceC22053ub1.W(1656439939);
            boolean zD = interfaceC22053ub1.D(this.a) | interfaceC22053ub1.V(this.b);
            P07 p07 = this.a;
            C25038zd6 c25038zd6 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new a(p07, c25038zd6);
                interfaceC22053ub1.s(objB);
            }
            SA2 sa2 = (SA2) objB;
            interfaceC22053ub1.Q();
            interfaceC22053ub1.W(1656460211);
            boolean zV = interfaceC22053ub1.V(this.b) | interfaceC22053ub1.D(this.a);
            C25038zd6 c25038zd62 = this.b;
            P07 p072 = this.a;
            Object objB2 = interfaceC22053ub1.B();
            if (zV || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new C1366b(c25038zd62, p072);
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            N07.e(eVarJ, ev4, name, description, interfaceC19114po02, str, hasBlueTick, true, sa2, (SA2) objB2, interfaceC22053ub1, 12582912, 0);
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* renamed from: ir.nasim.l17$c */
    public static final class c extends AbstractC8614Ws3 implements UA2 {
        public static final c e = new c();

        public c() {
            super(1);
        }

        @Override // ir.nasim.UA2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Void invoke(Object obj) {
            return null;
        }
    }

    /* renamed from: ir.nasim.l17$d */
    public static final class d extends AbstractC8614Ws3 implements UA2 {
        final /* synthetic */ UA2 e;
        final /* synthetic */ List f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(UA2 ua2, List list) {
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

    /* renamed from: ir.nasim.l17$e */
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

    /* renamed from: ir.nasim.l17$f */
    public static final class f extends AbstractC8614Ws3 implements InterfaceC16978mB2 {
        final /* synthetic */ List e;
        final /* synthetic */ C25038zd6 f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(List list, C25038zd6 c25038zd6) {
            super(4);
            this.e = list;
            this.f = c25038zd6;
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
            if (!interfaceC22053ub1.o((i3 & 147) != 146, i3 & 1)) {
                interfaceC22053ub1.L();
                return;
            }
            if (AbstractC5138Ib1.I()) {
                AbstractC5138Ib1.Q(-632812321, i3, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
            }
            P07 p07 = (P07) this.e.get(i);
            interfaceC22053ub1.W(718934914);
            AbstractC11024cc1.a(AvatarAsyncImagePainterKt.g().d(new C17660nL3(20)), AbstractC19242q11.e(-1773463898, true, new b(p07, this.f), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
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

    /* renamed from: ir.nasim.l17$g */
    static final class g implements InterfaceC14603iB2 {
        final /* synthetic */ List a;

        /* renamed from: ir.nasim.l17$g$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ List a;

            a(List list) {
                this.a = list;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 d() {
                return C19938rB7.a;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(OnboardingPeer.EmptyStateSuggestedPeer emptyStateSuggestedPeer) {
                AbstractC13042fc3.i(emptyStateSuggestedPeer, "it");
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                JK4 jk4 = new JK4(JK4.a.C0443a.a, new JK4.b.e(this.a, null, "چه خدماتی به «بله» اضافه شد؟", 2, null), OnboardingSpot.DialogBanner.a);
                interfaceC22053ub1.W(276084420);
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = new SA2() { // from class: ir.nasim.m17
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC16293l17.g.a.d();
                        }
                    };
                    interfaceC22053ub1.s(objB);
                }
                SA2 sa2 = (SA2) objB;
                interfaceC22053ub1.Q();
                interfaceC22053ub1.W(276084548);
                Object objB2 = interfaceC22053ub1.B();
                if (objB2 == aVar.a()) {
                    objB2 = new UA2() { // from class: ir.nasim.n17
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj) {
                            return AbstractC16293l17.g.a.f((OnboardingPeer.EmptyStateSuggestedPeer) obj);
                        }
                    };
                    interfaceC22053ub1.s(objB2);
                }
                interfaceC22053ub1.Q();
                AbstractC16293l17.o(jk4, new C25038zd6(sa2, (UA2) objB2, null, null, 12, null), interfaceC22053ub1, 0);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        g(List list) {
            this.a = list;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                AbstractC11024cc1.a(AbstractC13040fc1.n().d(EnumC12613eu3.b), AbstractC19242q11.e(1712574958, true, new a(this.a), interfaceC22053ub1, 54), interfaceC22053ub1, C7252Qx5.i | 48);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    public static final void g(androidx.compose.ui.e eVar, final JK4 jk4, final C25038zd6 c25038zd6, InterfaceC22053ub1 interfaceC22053ub1, final int i, final int i2) {
        androidx.compose.ui.e eVar2;
        int i3;
        final androidx.compose.ui.e eVar3;
        AbstractC13042fc3.i(jk4, "uiState");
        AbstractC13042fc3.i(c25038zd6, "screenDelegate");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(-375368355);
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
            i3 |= interfaceC22053ub1J.D(jk4) ? 32 : 16;
        }
        if ((i2 & 4) != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= interfaceC22053ub1J.V(c25038zd6) ? 256 : 128;
        }
        if ((i3 & 147) == 146 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            eVar3 = eVar2;
        } else {
            eVar3 = i4 != 0 ? androidx.compose.ui.e.a : eVar2;
            interfaceC22053ub1J.W(-1823258849);
            boolean zD = interfaceC22053ub1J.D(jk4) | ((i3 & 896) == 256);
            Object objB = interfaceC22053ub1J.B();
            if (zD || objB == InterfaceC22053ub1.a.a()) {
                objB = new UA2() { // from class: ir.nasim.i17
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC16293l17.h(jk4, c25038zd6, (InterfaceC15069ix3) obj);
                    }
                };
                interfaceC22053ub1J.s(objB);
            }
            interfaceC22053ub1J.Q();
            AbstractC12623ev3.b(eVar3, null, null, false, null, null, null, false, null, (UA2) objB, interfaceC22053ub1J, i3 & 14, 510);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.j17
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16293l17.j(eVar3, jk4, c25038zd6, i, i2, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 h(JK4 jk4, C25038zd6 c25038zd6, InterfaceC15069ix3 interfaceC15069ix3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        AbstractC13042fc3.i(interfaceC15069ix3, "$this$LazyColumn");
        InterfaceC15069ix3.d(interfaceC15069ix3, null, null, AbstractC19242q11.c(-98376014, true, new a(jk4)), 3, null);
        JK4.a aVarC = jk4.c();
        if (aVarC instanceof JK4.a.b) {
            for (int i = 0; i < 10; i++) {
                InterfaceC15069ix3.d(interfaceC15069ix3, null, null, C14229ha1.a.a(), 3, null);
            }
        } else {
            if (!(aVarC instanceof JK4.a.C0443a)) {
                throw new NoWhenBranchMatchedException();
            }
            List listG = ((JK4.b.e) jk4.e()).g();
            interfaceC15069ix3.a(listG.size(), new d(new UA2() { // from class: ir.nasim.k17
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return AbstractC16293l17.i((P07) obj);
                }
            }, listG), new e(c.e, listG), AbstractC19242q11.c(-632812321, true, new f(listG, c25038zd6)));
        }
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object i(P07 p07) {
        AbstractC13042fc3.i(p07, "it");
        return p07.d().getPeerData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 j(androidx.compose.ui.e eVar, JK4 jk4, C25038zd6 c25038zd6, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        g(eVar, jk4, c25038zd6, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }

    public static final void k(final List list, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(list, "peerList");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1367808009);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 3) == 2 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, AbstractC19242q11.e(423272110, true, new g(list), interfaceC22053ub1J, 54), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.g17
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16293l17.l(list, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 l(List list, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(list, "$peerList");
        k(list, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void m(InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(786526460);
        if (i == 0 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            M10.f(false, C14229ha1.a.c(), interfaceC22053ub1J, 48, 1);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.f17
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16293l17.n(i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 n(int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        m(interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }

    public static final void o(final JK4 jk4, final C25038zd6 c25038zd6, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        InterfaceC22053ub1 interfaceC22053ub12;
        AbstractC13042fc3.i(jk4, "uiState");
        AbstractC13042fc3.i(c25038zd6, "screenDelegate");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(543857671);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(jk4) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.V(c25038zd6) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
            interfaceC22053ub12 = interfaceC22053ub1J;
        } else {
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(aVar, G10.a.a(interfaceC22053ub1J, G10.b).r(), null, 2, null);
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1J, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1J, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1J.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1J, eVarD);
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
            androidx.compose.ui.e eVarB = FV0.b(AbstractC22050ua8.c(aVar, AbstractC21393ta8.g(C17979ns7.a.e(interfaceC22053ub1J, C17979ns7.g), AbstractC23236wa8.a.f())));
            String strE = ((JK4.b.e) jk4.e()).e();
            if (strE == null) {
                strE = "";
            }
            AbstractC21639ts7.i(strE, eVarB, c25038zd6.e(), null, null, null, null, interfaceC22053ub1J, 0, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
            int i3 = i2 << 3;
            interfaceC22053ub12 = interfaceC22053ub1J;
            g(ZY0.b(c9784aZ0, aVar, 1.0f, false, 2, null), jk4, c25038zd6, interfaceC22053ub1J, (i3 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) | (i3 & 896), 0);
            interfaceC22053ub12.u();
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub12.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.h17
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC16293l17.p(jk4, c25038zd6, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 p(JK4 jk4, C25038zd6 c25038zd6, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(jk4, "$uiState");
        AbstractC13042fc3.i(c25038zd6, "$screenDelegate");
        o(jk4, c25038zd6, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
