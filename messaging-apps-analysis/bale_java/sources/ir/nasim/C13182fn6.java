package ir.nasim;

import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C13182fn6;
import java.util.List;

/* renamed from: ir.nasim.fn6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C13182fn6 extends RecyclerView.C {
    private final UA2 u;
    private final InterfaceC10258bL6 v;

    /* renamed from: ir.nasim.fn6$a */
    static final class a implements InterfaceC14603iB2 {

        /* renamed from: ir.nasim.fn6$a$a, reason: collision with other inner class name */
        static final class C1241a implements InterfaceC14603iB2 {
            final /* synthetic */ InterfaceC9664aL6 a;
            final /* synthetic */ C13182fn6 b;

            /* renamed from: ir.nasim.fn6$a$a$a, reason: collision with other inner class name */
            static final class C1242a implements InterfaceC15796kB2 {
                final /* synthetic */ InterfaceC9664aL6 a;
                final /* synthetic */ C13182fn6 b;

                C1242a(InterfaceC9664aL6 interfaceC9664aL6, C13182fn6 c13182fn6) {
                    this.a = interfaceC9664aL6;
                    this.b = c13182fn6;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final C19938rB7 c(C13182fn6 c13182fn6, C22613vY c22613vY) {
                    AbstractC13042fc3.i(c13182fn6, "this$0");
                    AbstractC13042fc3.i(c22613vY, "it");
                    c13182fn6.u.invoke(c22613vY);
                    return C19938rB7.a;
                }

                public final void b(InterfaceC16782lr2 interfaceC16782lr2, InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    AbstractC13042fc3.i(interfaceC16782lr2, "$this$FlowRow");
                    if ((i & 17) == 16 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    List<C22613vY> listC = a.c(this.a);
                    final C13182fn6 c13182fn6 = this.b;
                    for (C22613vY c22613vY : listC) {
                        interfaceC22053ub1.W(1378789442);
                        boolean zD = interfaceC22053ub1.D(c13182fn6);
                        Object objB = interfaceC22053ub1.B();
                        if (zD || objB == InterfaceC22053ub1.a.a()) {
                            objB = new UA2() { // from class: ir.nasim.en6
                                @Override // ir.nasim.UA2
                                public final Object invoke(Object obj) {
                                    return C13182fn6.a.C1241a.C1242a.c(c13182fn6, (C22613vY) obj);
                                }
                            };
                            interfaceC22053ub1.s(objB);
                        }
                        interfaceC22053ub1.Q();
                        AbstractC11934dn6.c(c22613vY, (UA2) objB, interfaceC22053ub1, 0);
                    }
                }

                @Override // ir.nasim.InterfaceC15796kB2
                public /* bridge */ /* synthetic */ Object q(Object obj, Object obj2, Object obj3) {
                    b((InterfaceC16782lr2) obj, (InterfaceC22053ub1) obj2, ((Number) obj3).intValue());
                    return C19938rB7.a;
                }
            }

            C1241a(InterfaceC9664aL6 interfaceC9664aL6, C13182fn6 c13182fn6) {
                this.a = interfaceC9664aL6;
                this.b = c13182fn6;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                    return;
                }
                androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.b.d(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), WX0.a(TA5.color4, interfaceC22053ub1, 0), null, 2, null), 0.0f, 0.0f, 0.0f, C17784nZ1.q(12), 7, null);
                C24254yJ c24254yJ = C24254yJ.a;
                float f = 8;
                AbstractC12582er2.b(eVarM, c24254yJ.p(C17784nZ1.q(f), InterfaceC12529em.a.k()), c24254yJ.o(C17784nZ1.q(f)), null, 0, 0, AbstractC19242q11.e(2020833923, true, new C1242a(this.a, this.b), interfaceC22053ub1, 54), interfaceC22053ub1, 1573296, 56);
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List c(InterfaceC9664aL6 interfaceC9664aL6) {
            return (List) interfaceC9664aL6.getValue();
        }

        public final void b(InterfaceC22053ub1 interfaceC22053ub1, int i) {
            if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                interfaceC22053ub1.L();
            } else {
                M10.f(false, AbstractC19242q11.e(-715772130, true, new C1241a(AbstractC5976Lq2.c(C13182fn6.this.v, null, null, null, interfaceC22053ub1, 0, 7), C13182fn6.this), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
            }
        }

        @Override // ir.nasim.InterfaceC14603iB2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            b((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
            return C19938rB7.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13182fn6(C10476bg3 c10476bg3, UA2 ua2, InterfaceC10258bL6 interfaceC10258bL6) {
        super(c10476bg3.getRoot());
        AbstractC13042fc3.i(c10476bg3, "binding");
        AbstractC13042fc3.i(ua2, "removeContact");
        AbstractC13042fc3.i(interfaceC10258bL6, "selectedContact");
        this.u = ua2;
        this.v = interfaceC10258bL6;
        c10476bg3.b.setContent(AbstractC19242q11.c(1795774371, true, new a()));
    }
}
