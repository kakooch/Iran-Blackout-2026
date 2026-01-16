package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.res.Configuration;
import androidx.compose.ui.e;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import ir.nasim.AbstractC9796aa3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC19114po0;
import ir.nasim.InterfaceC22053ub1;

/* renamed from: ir.nasim.aa3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC9796aa3 {

    /* renamed from: ir.nasim.aa3$a */
    static final class a implements InterfaceC15796kB2 {
        final /* synthetic */ O37 a;
        final /* synthetic */ SA2 b;
        final /* synthetic */ SA2 c;
        final /* synthetic */ InterfaceC9102Ym4 d;

        /* renamed from: ir.nasim.aa3$a$a, reason: collision with other inner class name */
        static final class C0847a implements InterfaceC15796kB2 {
            final /* synthetic */ SA2 a;
            final /* synthetic */ SA2 b;
            final /* synthetic */ InterfaceC9102Ym4 c;

            /* renamed from: ir.nasim.aa3$a$a$a, reason: collision with other inner class name */
            static final class C0848a implements InterfaceC15796kB2 {
                final /* synthetic */ SA2 a;
                final /* synthetic */ SA2 b;
                final /* synthetic */ InterfaceC9102Ym4 c;

                C0848a(SA2 sa2, SA2 sa22, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    this.a = sa2;
                    this.b = sa22;
                    this.c = interfaceC9102Ym4;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4) {
                    AbstractC13042fc3.i(sa2, "$onCloseClick");
                    AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible$delegate");
                    AbstractC9796aa3.f(interfaceC9102Ym4, false);
                    sa2.invoke();
                    return C19938rB7.a;
                }

                public final void b(androidx.compose.ui.e eVar, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    int i2;
                    AbstractC13042fc3.i(eVar, "it");
                    if ((i & 6) == 0) {
                        i2 = i | (interfaceC22053ub1.V(eVar) ? 4 : 2);
                    } else {
                        i2 = i;
                    }
                    if ((i2 & 19) == 18 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    InterfaceC12529em.c cVarI = InterfaceC12529em.a.i();
                    SA2 sa2 = this.a;
                    final SA2 sa22 = this.b;
                    final InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
                    InterfaceC10970cW3 interfaceC10970cW3B = J66.b(C24254yJ.a.g(), cVarI, interfaceC22053ub1, 48);
                    int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                    InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                    androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVar);
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
                    DG7.c(interfaceC22053ub1A, interfaceC10970cW3B, aVar.e());
                    DG7.c(interfaceC22053ub1A, interfaceC11819dc1Q, aVar.g());
                    InterfaceC14603iB2 interfaceC14603iB2B = aVar.b();
                    if (interfaceC22053ub1A.h() || !AbstractC13042fc3.d(interfaceC22053ub1A.B(), Integer.valueOf(iA))) {
                        interfaceC22053ub1A.s(Integer.valueOf(iA));
                        interfaceC22053ub1A.v(Integer.valueOf(iA), interfaceC14603iB2B);
                    }
                    DG7.c(interfaceC22053ub1A, eVarE, aVar.f());
                    M66 m66 = M66.a;
                    e.a aVar2 = androidx.compose.ui.e.a;
                    AbstractC17932no0.Q(sa2, InterfaceC19114po0.b.a.a, UY6.c(UD5.install_button, interfaceC22053ub1, 0), aVar2, null, interfaceC22053ub1, (InterfaceC19114po0.b.a.b << 3) | SetRpcStruct$ComposedRpc.GET_NASIM_FILE_PUBLIC_URL_FIELD_NUMBER, 16);
                    ZH6.a(androidx.compose.foundation.layout.t.y(aVar2, G10.a.c(interfaceC22053ub1, G10.b).b().r()), interfaceC22053ub1, 0);
                    interfaceC22053ub1.W(1400169526);
                    boolean zV = interfaceC22053ub1.V(sa22);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new SA2() { // from class: ir.nasim.Z93
                            @Override // ir.nasim.SA2
                            public final Object invoke() {
                                return AbstractC9796aa3.a.C0847a.C0848a.c(sa22, interfaceC9102Ym4);
                            }
                        };
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC20434s03.a((SA2) objB, aVar2, false, null, null, C13364g61.a.c(), interfaceC22053ub1, 196656, 28);
                    interfaceC22053ub1.u();
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((androidx.compose.ui.e) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            C0847a(SA2 sa2, SA2 sa22, InterfaceC9102Ym4 interfaceC9102Ym4) {
                this.a = sa2;
                this.b = sa22;
                this.c = interfaceC9102Ym4;
            }

            public final void a(L66 l66, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                AbstractC13042fc3.i(l66, "$this$SwipeToDismissBox");
                if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                e.a aVar = androidx.compose.ui.e.a;
                androidx.compose.ui.e eVarH = androidx.compose.foundation.layout.t.h(aVar, 0.0f, 1, null);
                SA2 sa2 = this.a;
                SA2 sa22 = this.b;
                InterfaceC9102Ym4 interfaceC9102Ym4 = this.c;
                InterfaceC10970cW3 interfaceC10970cW3A = XY0.a(C24254yJ.a.h(), InterfaceC12529em.a.k(), interfaceC22053ub1, 0);
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
                MY2.b(null, null, 0L, interfaceC22053ub1, 0, 7);
                C11984ds7 c11984ds7A = C11984ds7.e.a(interfaceC22053ub1, 6);
                G10 g10 = G10.a;
                int i2 = G10.b;
                C11984ds7 c11984ds7A2 = c11984ds7A.a((1 & 1) != 0 ? c11984ds7A.a : g10.a(interfaceC22053ub1, i2).w(), (1 & 2) != 0 ? c11984ds7A.b : 0L, (1 & 4) != 0 ? c11984ds7A.c : 0L, (1 & 8) != 0 ? c11984ds7A.d : 0L);
                AbstractC16797ls7.h(C13364g61.a.b(), aVar, androidx.compose.foundation.layout.q.d(g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().u(), g10.c(interfaceC22053ub1, i2).b().c(), g10.c(interfaceC22053ub1, i2).b().u()), null, null, AbstractC19242q11.e(-1478073397, true, new C0848a(sa2, sa22, interfaceC9102Ym4), interfaceC22053ub1, 54), c11984ds7A2, null, null, interfaceC22053ub1, (C11984ds7.f << 18) | 196662, 408);
                interfaceC22053ub1.u();
            }

            @Override // ir.nasim.InterfaceC15796kB2
            public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                a((L66) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                return C19938rB7.a;
            }
        }

        a(O37 o37, SA2 sa2, SA2 sa22, InterfaceC9102Ym4 interfaceC9102Ym4) {
            this.a = o37;
            this.b = sa2;
            this.c = sa22;
            this.d = interfaceC9102Ym4;
        }

        public final void a(InterfaceC22821vt interfaceC22821vt, InterfaceC22053ub1 interfaceC22053ub1, int i) {
            AbstractC13042fc3.i(interfaceC22821vt, "$this$AnimatedVisibility");
            N37.a(this.a, C13364g61.a.a(), null, false, false, false, AbstractC19242q11.e(810224049, true, new C0847a(this.b, this.c, this.d), interfaceC22053ub1, 54), interfaceC22053ub1, O37.d | 1572912, 60);
        }

        @Override // ir.nasim.InterfaceC15796kB2
        public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
            a((InterfaceC22821vt) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
            return C19938rB7.a;
        }
    }

    public static final void d(final SA2 sa2, final SA2 sa22, InterfaceC22053ub1 interfaceC22053ub1, final int i) {
        int i2;
        AbstractC13042fc3.i(sa2, "onInstallClick");
        AbstractC13042fc3.i(sa22, "onCloseClick");
        InterfaceC22053ub1 interfaceC22053ub1J = interfaceC22053ub1.j(1080265628);
        if ((i & 6) == 0) {
            i2 = (interfaceC22053ub1J.D(sa2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= interfaceC22053ub1J.D(sa22) ? 32 : 16;
        }
        if ((i2 & 19) == 18 && interfaceC22053ub1J.k()) {
            interfaceC22053ub1J.L();
        } else {
            final int i3 = ((Configuration) interfaceC22053ub1J.H(AndroidCompositionLocals_androidKt.f())).screenWidthDp;
            interfaceC22053ub1J.W(502147728);
            Object objB = interfaceC22053ub1J.B();
            InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
            if (objB == aVar.a()) {
                objB = AbstractC13472gH6.d(Boolean.TRUE, null, 2, null);
                interfaceC22053ub1J.s(objB);
            }
            final InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(502151883);
            final WH1 wh1 = (WH1) interfaceC22053ub1J.H(AbstractC13040fc1.g());
            interfaceC22053ub1J.W(488190411);
            boolean zV = interfaceC22053ub1J.V(wh1) | interfaceC22053ub1J.e(i3);
            Object objB2 = interfaceC22053ub1J.B();
            if (zV || objB2 == aVar.a()) {
                objB2 = new UA2() { // from class: ir.nasim.W93
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Float.valueOf(AbstractC9796aa3.g(wh1, i3, ((Float) obj).floatValue()));
                    }
                };
                interfaceC22053ub1J.s(objB2);
            }
            UA2 ua2 = (UA2) objB2;
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.Q();
            interfaceC22053ub1J.W(502154991);
            boolean z = (i2 & SetRpcStruct$ComposedRpc.SEARCH_CONTACTS_FIELD_NUMBER) == 32;
            Object objB3 = interfaceC22053ub1J.B();
            if (z || objB3 == aVar.a()) {
                objB3 = new UA2() { // from class: ir.nasim.X93
                    @Override // ir.nasim.UA2
                    public final Object invoke(Object obj) {
                        return Boolean.valueOf(AbstractC9796aa3.h(sa22, interfaceC9102Ym4, (P37) obj));
                    }
                };
                interfaceC22053ub1J.s(objB3);
            }
            interfaceC22053ub1J.Q();
            AbstractC22231ut.f(e(interfaceC9102Ym4), null, null, androidx.compose.animation.f.y(null, null, false, null, 15, null).c(androidx.compose.animation.f.q(null, 0.0f, 3, null)), null, AbstractC19242q11.e(-1165020044, true, new a(N37.c(null, (UA2) objB3, ua2, interfaceC22053ub1J, 0, 1), sa2, sa22, interfaceC9102Ym4), interfaceC22053ub1J, 54), interfaceC22053ub1J, 199680, 22);
        }
        InterfaceC20208rd6 interfaceC20208rd6M = interfaceC22053ub1J.m();
        if (interfaceC20208rd6M != null) {
            interfaceC20208rd6M.a(new InterfaceC14603iB2() { // from class: ir.nasim.Y93
                @Override // ir.nasim.InterfaceC14603iB2
                public final Object invoke(Object obj, Object obj2) {
                    return AbstractC9796aa3.i(sa2, sa22, i, (InterfaceC22053ub1) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean e(InterfaceC9102Ym4 interfaceC9102Ym4) {
        return ((Boolean) interfaceC9102Ym4.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(InterfaceC9102Ym4 interfaceC9102Ym4, boolean z) {
        interfaceC9102Ym4.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float g(WH1 wh1, int i, float f) {
        AbstractC13042fc3.i(wh1, "$this_with");
        return wh1.w1(C17784nZ1.q(i)) / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean h(SA2 sa2, InterfaceC9102Ym4 interfaceC9102Ym4, P37 p37) {
        AbstractC13042fc3.i(sa2, "$onCloseClick");
        AbstractC13042fc3.i(interfaceC9102Ym4, "$isVisible$delegate");
        AbstractC13042fc3.i(p37, "it");
        if (p37 != P37.StartToEnd && p37 != P37.EndToStart) {
            return false;
        }
        f(interfaceC9102Ym4, false);
        sa2.invoke();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 i(SA2 sa2, SA2 sa22, int i, InterfaceC22053ub1 interfaceC22053ub1, int i2) {
        AbstractC13042fc3.i(sa2, "$onInstallClick");
        AbstractC13042fc3.i(sa22, "$onCloseClick");
        d(sa2, sa22, interfaceC22053ub1, QJ5.a(i | 1));
        return C19938rB7.a;
    }
}
