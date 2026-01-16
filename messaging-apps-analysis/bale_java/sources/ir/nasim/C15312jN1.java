package ir.nasim;

import android.content.Context;
import android.view.ViewGroup;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.v;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;
import java.util.Set;

/* renamed from: ir.nasim.jN1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15312jN1 extends AbstractC14051hG3 {
    public static final a k = new a(null);
    public static final int l = 8;
    private static final Set m = AbstractC4597Fu6.i(2, 3);
    private static final Set n = AbstractC4597Fu6.i(4, 0);
    private final int e;
    private final HI4 f;
    private final InterfaceC10258bL6 g;
    private final SA2 h;
    private final InterfaceC10258bL6 i;
    private final InterfaceC14603iB2 j;

    /* renamed from: ir.nasim.jN1$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.jN1$b */
    public final class b extends RecyclerView.C {
        private final ComposeView u;
        final /* synthetic */ C15312jN1 v;

        /* renamed from: ir.nasim.jN1$b$a */
        static final class a implements InterfaceC14603iB2 {
            final /* synthetic */ C15312jN1 a;
            final /* synthetic */ AbstractC13460gG3 b;
            final /* synthetic */ InterfaceC14603iB2 c;
            final /* synthetic */ HI4 d;
            final /* synthetic */ SA2 e;

            /* renamed from: ir.nasim.jN1$b$a$a, reason: collision with other inner class name */
            static final class C1315a implements InterfaceC14603iB2 {
                final /* synthetic */ C15312jN1 a;
                final /* synthetic */ AbstractC13460gG3 b;
                final /* synthetic */ InterfaceC14603iB2 c;
                final /* synthetic */ HI4 d;
                final /* synthetic */ SA2 e;

                /* renamed from: ir.nasim.jN1$b$a$a$a, reason: collision with other inner class name */
                /* synthetic */ class C1316a extends EB2 implements SA2 {
                    C1316a(Object obj) {
                        super(0, obj, HI4.class, "onNavigateToContactFragment", "onNavigateToContactFragment()V", 0);
                    }

                    @Override // ir.nasim.SA2
                    public /* bridge */ /* synthetic */ Object invoke() {
                        y();
                        return C19938rB7.a;
                    }

                    public final void y() {
                        ((HI4) this.receiver).T0();
                    }
                }

                /* renamed from: ir.nasim.jN1$b$a$a$b, reason: collision with other inner class name */
                /* synthetic */ class C1317b extends EB2 implements UA2 {
                    C1317b(Object obj) {
                        super(1, obj, HI4.class, "onNavigateToStoryFragment", "onNavigateToStoryFragment(I)V", 0);
                    }

                    @Override // ir.nasim.UA2
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        y(((Number) obj).intValue());
                        return C19938rB7.a;
                    }

                    public final void y(int i) {
                        ((HI4) this.receiver).W1(i);
                    }
                }

                C1315a(C15312jN1 c15312jN1, AbstractC13460gG3 abstractC13460gG3, InterfaceC14603iB2 interfaceC14603iB2, HI4 hi4, SA2 sa2) {
                    this.a = c15312jN1;
                    this.b = abstractC13460gG3;
                    this.c = interfaceC14603iB2;
                    this.d = hi4;
                    this.e = sa2;
                }

                private static final int b(InterfaceC9664aL6 interfaceC9664aL6) {
                    return ((Number) interfaceC9664aL6.getValue()).intValue();
                }

                private static final boolean c(InterfaceC9664aL6 interfaceC9664aL6) {
                    return ((Boolean) interfaceC9664aL6.getValue()).booleanValue();
                }

                public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                    if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                        interfaceC22053ub1.L();
                        return;
                    }
                    InterfaceC9664aL6 interfaceC9664aL6B = AbstractC10222bH6.b(this.a.i, null, interfaceC22053ub1, 0, 1);
                    if (this.b instanceof AbstractC13460gG3.b) {
                        interfaceC22053ub1.W(-1234715665);
                        AbstractC14732iO1.c(null, interfaceC22053ub1, 0, 1);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (b(interfaceC9664aL6B) < 16 && this.a.K(this.b) && C8386Vt0.k6()) {
                        interfaceC22053ub1.W(-1234496402);
                        this.c.invoke(interfaceC22053ub1, 0);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    if (b(interfaceC9664aL6B) >= 4 || !this.a.L(this.b) || C8386Vt0.k6()) {
                        interfaceC22053ub1.W(-1233552452);
                        interfaceC22053ub1.Q();
                        return;
                    }
                    interfaceC22053ub1.W(-1234266196);
                    InterfaceC9664aL6 interfaceC9664aL6C = AbstractC5976Lq2.c(this.a.g, null, null, null, interfaceC22053ub1, 0, 7);
                    androidx.compose.ui.e eVarM = androidx.compose.foundation.layout.q.m(androidx.compose.foundation.layout.t.h(androidx.compose.ui.e.a, 0.0f, 1, null), 0.0f, G10.a.c(interfaceC22053ub1, G10.b).b().o(), 0.0f, 0.0f, 13, null);
                    HI4 hi4 = this.d;
                    interfaceC22053ub1.W(652933268);
                    boolean zV = interfaceC22053ub1.V(hi4);
                    Object objB = interfaceC22053ub1.B();
                    if (zV || objB == InterfaceC22053ub1.a.a()) {
                        objB = new C1316a(hi4);
                        interfaceC22053ub1.s(objB);
                    }
                    interfaceC22053ub1.Q();
                    SA2 sa2 = (SA2) ((InterfaceC16733lm3) objB);
                    HI4 hi42 = this.d;
                    interfaceC22053ub1.W(652935826);
                    boolean zV2 = interfaceC22053ub1.V(hi42);
                    Object objB2 = interfaceC22053ub1.B();
                    if (zV2 || objB2 == InterfaceC22053ub1.a.a()) {
                        objB2 = new C1317b(hi42);
                        interfaceC22053ub1.s(objB2);
                    }
                    interfaceC22053ub1.Q();
                    LI4.d(eVarM, sa2, (UA2) ((InterfaceC16733lm3) objB2), null, 0L, false, c(interfaceC9664aL6C), this.e, interfaceC22053ub1, 0, 56);
                    interfaceC22053ub1.Q();
                }

                @Override // ir.nasim.InterfaceC14603iB2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                    return C19938rB7.a;
                }
            }

            a(C15312jN1 c15312jN1, AbstractC13460gG3 abstractC13460gG3, InterfaceC14603iB2 interfaceC14603iB2, HI4 hi4, SA2 sa2) {
                this.a = c15312jN1;
                this.b = abstractC13460gG3;
                this.c = interfaceC14603iB2;
                this.d = hi4;
                this.e = sa2;
            }

            public final void a(InterfaceC22053ub1 interfaceC22053ub1, int i) {
                if ((i & 3) == 2 && interfaceC22053ub1.k()) {
                    interfaceC22053ub1.L();
                } else {
                    M10.f(false, AbstractC19242q11.e(-1991954907, true, new C1315a(this.a, this.b, this.c, this.d, this.e), interfaceC22053ub1, 54), interfaceC22053ub1, 48, 1);
                }
            }

            @Override // ir.nasim.InterfaceC14603iB2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                a((InterfaceC22053ub1) obj, ((Number) obj2).intValue());
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C15312jN1 c15312jN1, ComposeView composeView) {
            super(composeView);
            AbstractC13042fc3.i(composeView, "cv");
            this.v = c15312jN1;
            this.u = composeView;
        }

        public final void C0(AbstractC13460gG3 abstractC13460gG3, HI4 hi4, SA2 sa2, InterfaceC14603iB2 interfaceC14603iB2) {
            AbstractC13042fc3.i(abstractC13460gG3, "loadState");
            AbstractC13042fc3.i(hi4, "onBoardingActions");
            AbstractC13042fc3.i(sa2, "showPermDialog");
            AbstractC13042fc3.i(interfaceC14603iB2, "emptyStateOnBoarding");
            this.u.setContent(AbstractC19242q11.c(144876224, true, new a(this.v, abstractC13460gG3, interfaceC14603iB2, hi4, sa2)));
        }
    }

    public C15312jN1(int i, HI4 hi4, InterfaceC10258bL6 interfaceC10258bL6, SA2 sa2, InterfaceC10258bL6 interfaceC10258bL62, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(hi4, "onBoardingActions");
        AbstractC13042fc3.i(interfaceC10258bL6, "hasNotContactPermission");
        AbstractC13042fc3.i(sa2, "showPermissionDialog");
        AbstractC13042fc3.i(interfaceC10258bL62, "dialogsCountState");
        AbstractC13042fc3.i(interfaceC14603iB2, "emptyStateOnBoarding");
        this.e = i;
        this.f = hi4;
        this.g = interfaceC10258bL6;
        this.h = sa2;
        this.i = interfaceC10258bL62;
        this.j = interfaceC14603iB2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean K(AbstractC13460gG3 abstractC13460gG3) {
        return !(abstractC13460gG3 instanceof AbstractC13460gG3.b) && abstractC13460gG3.a() && n.contains(Integer.valueOf(this.e));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean L(AbstractC13460gG3 abstractC13460gG3) {
        return ((abstractC13460gG3 instanceof AbstractC13460gG3.b) || !abstractC13460gG3.a() || m.contains(Integer.valueOf(this.e))) ? false : true;
    }

    @Override // ir.nasim.AbstractC14051hG3
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public void B(b bVar, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(bVar, "holder");
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        bVar.C0(abstractC13460gG3, this.f, this.h, this.j);
    }

    @Override // ir.nasim.AbstractC14051hG3
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public b C(ViewGroup viewGroup, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(viewGroup, "parent");
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        ComposeView composeView = new ComposeView(context, null, 0, 6, null);
        composeView.setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        composeView.setViewCompositionStrategy(v.b.b);
        return new b(this, composeView);
    }

    @Override // ir.nasim.AbstractC14051hG3
    public boolean z(AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        return (abstractC13460gG3 instanceof AbstractC13460gG3.b) || L(abstractC13460gG3) || K(abstractC13460gG3);
    }
}
