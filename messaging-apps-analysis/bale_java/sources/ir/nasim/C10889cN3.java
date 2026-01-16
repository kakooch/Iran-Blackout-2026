package ir.nasim;

import ai.bale.proto.SetRpcStruct$ComposedRpc;
import android.content.Context;
import android.gov.nist.javax.sip.stack.SIPTransactionStack;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import ir.nasim.C10889cN3;
import ir.nasim.C24254yJ;
import ir.nasim.C4081Dp3;
import ir.nasim.InterfaceC12529em;
import ir.nasim.InterfaceC16030kb1;
import ir.nasim.InterfaceC22053ub1;
import org.xbill.DNS.Type;

/* renamed from: ir.nasim.cN3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C10889cN3 extends RecyclerView.C {
    private final SA2 u;
    private final C14320hj2 v;

    /* renamed from: ir.nasim.cN3$a */
    static final class a implements InterfaceC14603iB2 {
        final /* synthetic */ AbstractC13460gG3 b;

        /* renamed from: ir.nasim.cN3$a$a, reason: collision with other inner class name */
        static final class C0935a implements InterfaceC14603iB2 {
            final /* synthetic */ C10889cN3 a;
            final /* synthetic */ AbstractC13460gG3 b;

            C0935a(C10889cN3 c10889cN3, AbstractC13460gG3 abstractC13460gG3) {
                this.a = c10889cN3;
                this.b = abstractC13460gG3;
            }

            private static final AbstractC13460gG3 d(InterfaceC9102Ym4 interfaceC9102Ym4) {
                return (AbstractC13460gG3) interfaceC9102Ym4.getValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 f(C4081Dp3.b bVar) {
                AbstractC13042fc3.i(bVar, "$this$keyframes");
                bVar.d(SetRpcStruct$ComposedRpc.GET_JWT_TOKEN_FIELD_NUMBER);
                return C19938rB7.a;
            }

            private static final float h(InterfaceC9664aL6 interfaceC9664aL6) {
                return ((Number) interfaceC9664aL6.getValue()).floatValue();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 i(C10889cN3 c10889cN3) {
                AbstractC13042fc3.i(c10889cN3, "this$0");
                c10889cN3.D0().invoke();
                return C19938rB7.a;
            }

            public final void c(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                interfaceC22053ub1.W(-1182082564);
                AbstractC13460gG3 abstractC13460gG3 = this.b;
                Object objB = interfaceC22053ub1.B();
                InterfaceC22053ub1.a aVar = InterfaceC22053ub1.a;
                if (objB == aVar.a()) {
                    objB = AbstractC13472gH6.d(abstractC13460gG3, null, 2, null);
                    interfaceC22053ub1.s(objB);
                }
                InterfaceC9102Ym4 interfaceC9102Ym4 = (InterfaceC9102Ym4) objB;
                interfaceC22053ub1.Q();
                if (d(interfaceC9102Ym4) instanceof AbstractC13460gG3.b) {
                    interfaceC22053ub1.W(2010306948);
                    C21097t63 c21097t63C = AbstractC22957w63.c("Loading", interfaceC22053ub1, 6, 0);
                    interfaceC22053ub1.W(-1182066810);
                    Object objB2 = interfaceC22053ub1.B();
                    if (objB2 == aVar.a()) {
                        objB2 = new UA2() { // from class: ir.nasim.aN3
                            @Override // ir.nasim.UA2
                            public final Object invoke(Object obj) {
                                return C10889cN3.a.C0935a.f((C4081Dp3.b) obj);
                            }
                        };
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    AbstractC11456d23.b(FV4.c(AbstractC18163oB5.ic_feed_loading, interfaceC22053ub1, 0), null, G46.a(androidx.compose.foundation.layout.t.t(androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16)), C17784nZ1.q(24)), h(AbstractC22957w63.a(c21097t63C, 0.0f, 360.0f, AbstractC5999Lt.e(AbstractC5999Lt.f((UA2) objB2), null, 0L, 6, null), "Loading", interfaceC22053ub1, C21097t63.f | 25008 | (C20494s63.d << 9), 0))), null, null, 0.0f, null, interfaceC22053ub1, 48, SetRpcStruct$ComposedRpc.EDIT_GROUP_DEFAULT_CARD_NUMBER_FIELD_NUMBER);
                    interfaceC22053ub1.Q();
                    return;
                }
                if (!(d(interfaceC9102Ym4) instanceof AbstractC13460gG3.a)) {
                    interfaceC22053ub1.W(2012657616);
                    interfaceC22053ub1.Q();
                    return;
                }
                interfaceC22053ub1.W(2011271854);
                C24254yJ c24254yJ = C24254yJ.a;
                float fQ = C17784nZ1.q(10);
                InterfaceC12529em.a aVar2 = InterfaceC12529em.a;
                C24254yJ.e eVarP = c24254yJ.p(fQ, aVar2.g());
                InterfaceC12529em.c cVarI = aVar2.i();
                androidx.compose.ui.e eVarI = androidx.compose.foundation.layout.q.i(androidx.compose.ui.e.a, C17784nZ1.q(16));
                interfaceC22053ub1.W(-1182034311);
                boolean zD = interfaceC22053ub1.D(this.a);
                final C10889cN3 c10889cN3 = this.a;
                Object objB3 = interfaceC22053ub1.B();
                if (zD || objB3 == aVar.a()) {
                    objB3 = new SA2() { // from class: ir.nasim.bN3
                        @Override // ir.nasim.SA2
                        public final Object invoke() {
                            return C10889cN3.a.C0935a.i(c10889cN3);
                        }
                    };
                    interfaceC22053ub1.s(objB3);
                }
                interfaceC22053ub1.Q();
                androidx.compose.ui.e eVarF = androidx.compose.foundation.e.f(eVarI, false, null, null, (SA2) objB3, 7, null);
                C10889cN3 c10889cN32 = this.a;
                InterfaceC10970cW3 interfaceC10970cW3B = J66.b(eVarP, cVarI, interfaceC22053ub1, 54);
                int iA = AbstractC6797Pa1.a(interfaceC22053ub1, 0);
                InterfaceC11819dc1 interfaceC11819dc1Q = interfaceC22053ub1.q();
                androidx.compose.ui.e eVarE = androidx.compose.ui.c.e(interfaceC22053ub1, eVarF);
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
                AbstractC11456d23.b(FV4.c(AbstractC18163oB5.ic_feed_retry, interfaceC22053ub1, 0), "image description", null, null, InterfaceC13157fl1.a.g(), 0.0f, null, interfaceC22053ub1, 24624, Type.EUI48);
                String string = c10889cN32.a.getContext().getString(ID5.try_again);
                AbstractC13042fc3.h(string, "getString(...)");
                long jG = AbstractC13784go7.g(13);
                long jG2 = AbstractC13784go7.g(22);
                AbstractC9998au2 abstractC9998au2A = AbstractC19143pr.a(C6011Lu2.i());
                C4593Fu2 c4593Fu2 = new C4593Fu2(SIPTransactionStack.BASE_TIMER_INTERVAL);
                Context context = c10889cN32.a.getContext();
                AbstractC13042fc3.h(context, "getContext(...)");
                AbstractC9105Ym7.b(string, null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new C9348Zn7(DX0.b(OY0.b(context, AbstractC13999hA5.colorPrimary)), jG, c4593Fu2, (C3418Au2) null, (C3657Bu2) null, abstractC9998au2A, (String) null, 0L, (C18413od0) null, (C3590Bm7) null, (IH3) null, 0L, (C24525yl7) null, (C5566Jw6) null, (AbstractC18051o02) null, C6399Nk7.b.f(), 0, jG2, (C5477Jm7) null, (C23283wf5) null, (C4888Gz3) null, 0, 0, (C22179un7) null, 16613336, (ED1) null), interfaceC22053ub1, 0, 0, 65534);
                interfaceC22053ub1.u();
                interfaceC22053ub1.Q();
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a(AbstractC13460gG3 abstractC13460gG3) {
            this.b = abstractC13460gG3;
        }

        public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(1362442337, true, new C0935a(C10889cN3.this, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10889cN3(View view, SA2 sa2) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        AbstractC13042fc3.i(sa2, "retry");
        this.u = sa2;
        C14320hj2 c14320hj2A = C14320hj2.a(view);
        AbstractC13042fc3.h(c14320hj2A, "bind(...)");
        this.v = c14320hj2A;
    }

    public final void C0(AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        this.v.b.setContent(AbstractC19242q11.c(513677158, true, new a(abstractC13460gG3)));
    }

    public final SA2 D0() {
        return this.u;
    }
}
