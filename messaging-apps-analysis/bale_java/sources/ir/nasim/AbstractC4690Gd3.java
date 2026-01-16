package ir.nasim;

import androidx.compose.ui.e;
import ir.nasim.AbstractC4690Gd3;
import ir.nasim.C24254yJ;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;

/* renamed from: ir.nasim.Gd3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC4690Gd3 {

    /* renamed from: ir.nasim.Gd3$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ C5860Ld3 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ InterfaceC20315ro1 c;
        final /* synthetic */ C19818qz6 d;
        final /* synthetic */ C20996sx3 e;

        /* renamed from: ir.nasim.Gd3$a$a, reason: collision with other inner class name */
        static final class C0393a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ SA2 c;
            final /* synthetic */ InterfaceC9664aL6 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0393a(SA2 sa2, InterfaceC9664aL6 interfaceC9664aL6, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = sa2;
                this.d = interfaceC9664aL6;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                return new C0393a(this.c, this.d, interfaceC20295rm1);
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (a.f(this.d).d()) {
                    this.c.invoke();
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((C0393a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        a(C5860Ld3 c5860Ld3, SA2 sa2, InterfaceC20315ro1 interfaceC20315ro1, C19818qz6 c19818qz6, C20996sx3 c20996sx3) {
            this.a = c5860Ld3;
            this.b = sa2;
            this.c = interfaceC20315ro1;
            this.d = c19818qz6;
            this.e = c20996sx3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C5626Kd3 f(InterfaceC9664aL6 interfaceC9664aL6) {
            return (C5626Kd3) interfaceC9664aL6.getValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 h(C5860Ld3 c5860Ld3, C22613vY c22613vY) {
            AbstractC13042fc3.i(c22613vY, "contact");
            c5860Ld3.f1(c22613vY);
            return C19938rB7.a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final C19938rB7 i(C5860Ld3 c5860Ld3) {
            c5860Ld3.c1();
            return C19938rB7.a;
        }

        public final void d(ZY0 zy0, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(zy0, "$this$ModalBottomSheet");
            if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
                return;
            }
            InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a.a1(), null, interfaceC22053ub1, 0, 1);
            Boolean boolValueOf = Boolean.valueOf(f(interfaceC9664aL6B).d());
            interfaceC22053ub1.W(-169978821);
            boolean zV = interfaceC22053ub1.V(interfaceC9664aL6B) | interfaceC22053ub1.V(this.b);
            SA2 sa2 = this.b;
            Object objB = interfaceC22053ub1.B();
            if (zV || objB == InterfaceC22053ub1.a.a()) {
                objB = new C0393a(sa2, interfaceC9664aL6B, null);
                interfaceC22053ub1.s(objB);
            }
            interfaceC22053ub1.Q();
            AbstractC10721c52.e(boolValueOf, (InterfaceC14603iB2) objB, interfaceC22053ub1, 0);
            e.a aVar = androidx.compose.ui.e.a;
            androidx.compose.ui.e eVarD = androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.d(androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), 0.0f, 1, null), WX0.a(TA5.color4, interfaceC22053ub1, 0), null, 2, null);
            SA2 sa22 = this.b;
            InterfaceC20315ro1 interfaceC20315ro1 = this.c;
            C19818qz6 c19818qz6 = this.d;
            final C5860Ld3 c5860Ld3 = this.a;
            C20996sx3 c20996sx3 = this.e;
            C24254yJ.m mVarH = C24254yJ.a.h();
            InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
            InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(mVarH, aVar2.k(), interfaceC22053ub1, 0);
            int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD);
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
            C9784aZ0 c9784aZ0 = C9784aZ0.a;
            AbstractC9105Ym7.b(UY6.c(AbstractC12217eE5.invite_call_btm_title, interfaceC22053ub1, 0), androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null), WX0.a(TA5.color9, interfaceC22053ub1, 0), AbstractC13784go7.g(18), null, null, M10.p(), 0L, null, C6399Nk7.h(C6399Nk7.b.a()), 0L, 0, false, 0, 0, null, null, interfaceC22053ub1, 3120, 0, 130480);
            float f = 16;
            float f2 = 12;
            AbstractC9758aW1.a(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(androidx.compose.foundation.layout.q.j(aVar, C17784nZ1.q(f), C17784nZ1.q(f2)), 0.0f, 1, null), C17784nZ1.q(1)), WX0.a(TA5.color1, interfaceC22053ub1, 0), null, 2, null), 0L, 0.0f, 0.0f, interfaceC22053ub1, 0, 14);
            AbstractC18426oe3.j(f(interfaceC9664aL6B).e(), sa22, interfaceC20315ro1, c19818qz6, c5860Ld3, interfaceC22053ub1, C5860Ld3.m << 12);
            androidx.compose.ui.e eVarD2 = androidx.compose.foundation.layout.t.d(aVar, 0.0f, 1, null);
            InterfaceC10970cW3 interfaceC10970cW3G = androidx.compose.foundation.layout.f.g(aVar2.o(), false);
            int iA2 = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
            InterfaceC11819dc1 interfaceC11819dc1Q2 = interfaceC22053ub1.q();
            androidx.compose.ui.e eVarE2 = androidx.compose.ui.c.e(interfaceC22053ub1, eVarD2);
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
            DG7.c(interfaceC22053ub1A2, interfaceC10970cW3G, aVar3.e());
            DG7.c(interfaceC22053ub1A2, interfaceC11819dc1Q2, aVar3.g());
            InterfaceC14603iB2 interfaceC14603iB2B2 = aVar3.b();
            if (interfaceC22053ub1A2.h() || !AbstractC13042fc3.d(interfaceC22053ub1A2.B(), Integer.valueOf(iA2))) {
                interfaceC22053ub1A2.s(Integer.valueOf(iA2));
                interfaceC22053ub1A2.v(Integer.valueOf(iA2), interfaceC14603iB2B2);
            }
            DG7.c(interfaceC22053ub1A2, eVarE2, aVar3.f());
            androidx.compose.foundation.layout.h hVar = androidx.compose.foundation.layout.h.a;
            interfaceC22053ub1.W(478909169);
            boolean zD = interfaceC22053ub1.D(c5860Ld3);
            Object objB2 = interfaceC22053ub1.B();
            if (zD || objB2 == InterfaceC22053ub1.a.a()) {
                objB2 = new UA2() { // from class: ir.nasim.Ad3
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return AbstractC4690Gd3.a.h(c5860Ld3, (C22613vY) obj);
                    }
                };
                interfaceC22053ub1.s(objB2);
            }
            interfaceC22053ub1.Q();
            AbstractC5008Hm6.e(c20996sx3, (UA2) objB2, interfaceC22053ub1, C20996sx3.f);
            interfaceC22053ub1.W(478913652);
            if (f(interfaceC9664aL6B).f()) {
                androidx.compose.ui.e eVarJ = androidx.compose.foundation.layout.q.j(hVar.h(androidx.compose.foundation.layout.t.i(androidx.compose.foundation.layout.t.h(AbstractC22640va8.a(aVar), 0.0f, 1, null), C17784nZ1.q(78)), aVar2.d()), C17784nZ1.q(f), C17784nZ1.q(f2));
                M46 m46D = N46.d(C17784nZ1.q(8));
                InterfaceC6180Mn0 interfaceC6180Mn0A = C6913Pn0.a.a(G10.a.a(interfaceC22053ub1, G10.b).v(), 0L, 0L, 0L, interfaceC22053ub1, C6913Pn0.l << 12, 14);
                interfaceC22053ub1.W(478931483);
                boolean zD2 = interfaceC22053ub1.D(c5860Ld3);
                Object objB3 = interfaceC22053ub1.B();
                if (zD2 || objB3 == InterfaceC22053ub1.a.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.Cd3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return AbstractC4690Gd3.a.i(c5860Ld3);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                AbstractC16750lo0.a((SA2) objB3, eVarJ, false, null, null, m46D, null, interfaceC6180Mn0A, null, C15746k61.a.a(), interfaceC22053ub1, 805306368, 348);
            }
            interfaceC22053ub1.Q();
            interfaceC22053ub1.u();
            interfaceC22053ub1.u();
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            d((ZY0) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void c(final ir.nasim.SA2 r28, final ir.nasim.C19818qz6 r29, ir.nasim.C5860Ld3 r30, ir.nasim.InterfaceC22053ub1 r31, final int r32, final int r33) {
        /*
            Method dump skipped, instructions count: 399
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.AbstractC4690Gd3.c(ir.nasim.SA2, ir.nasim.qz6, ir.nasim.Ld3, ir.nasim.ub1, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 d(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "$closeBottomSheet");
        sa2.invoke();
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 e(SA2 sa2, C19818qz6 c19818qz6, C5860Ld3 c5860Ld3, int i, int i2, InterfaceC22053ub1 interfaceC22053ub1, int i3) {
        AbstractC13042fc3.i(sa2, "$closeBottomSheet");
        AbstractC13042fc3.i(c19818qz6, "$bottomSheetState");
        c(sa2, c19818qz6, c5860Ld3, interfaceC22053ub1, QJ5.a(i | 1), i2);
        return C19938rB7.a;
    }
}
