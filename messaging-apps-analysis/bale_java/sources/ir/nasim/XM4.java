package ir.nasim;

import android.content.Context;
import android.text.Spannable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.N15;
import ir.nasim.XM4;
import ir.nasim.database.dailogLists.DialogEntity;
import ir.nasim.features.conversation.messages.content.adapter.view.BubbleTextView;
import ir.nasim.features.conversation.messages.content.adapter.view.TemplateRowView;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public final class XM4 extends P64 {
    public static final a G0 = new a(null);
    public static final int H0 = 8;
    private final C11851df3 D0;
    private final InterfaceC20284rl0 E0;
    private final LinearLayout F0;

    public static final class a {
        private a() {
        }

        public final P64 a(ViewGroup viewGroup, LayoutInflater layoutInflater, InterfaceC22152ul0 interfaceC22152ul0, InterfaceC22948w54 interfaceC22948w54, EW7 ew7, EnumC8893Xt7 enumC8893Xt7, boolean z) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(layoutInflater, "inflater");
            AbstractC13042fc3.i(interfaceC22152ul0, "bubbleFactory");
            AbstractC13042fc3.i(interfaceC22948w54, "messageClickListener");
            AbstractC13042fc3.i(ew7, "viewHolderClickListener");
            C11851df3 c11851df3C = C11851df3.c(layoutInflater, viewGroup, false);
            AbstractC13042fc3.h(c11851df3C, "inflate(...)");
            ViewStub viewStub = c11851df3C.b;
            AbstractC13042fc3.h(viewStub, "bubbleStub");
            return new XM4(c11851df3C, interfaceC22152ul0.a(viewStub), interfaceC22948w54, ew7, enumC8893Xt7, z);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b implements Runnable {
        final /* synthetic */ View a;
        final /* synthetic */ C11637dL5 b;

        b(View view, C11637dL5 c11637dL5) {
            this.a = view;
            this.b = c11637dL5;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.setMinimumWidth(this.b.a);
        }
    }

    public static final class c implements View.OnLayoutChangeListener {
        public c() {
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            view.removeOnLayoutChangeListener(this);
            C11637dL5 c11637dL5 = new C11637dL5();
            c11637dL5.a = XM4.this.E0.d().getWidth() - ((int) ((12 * AbstractC3742Cd6.c()) + 0.5d));
            Iterator it = AbstractC24379yW7.b(XM4.this.F0).iterator();
            while (it.hasNext()) {
                c11637dL5.a = Math.max(((View) it.next()).getWidth(), c11637dL5.a);
            }
            for (View view2 : AbstractC24379yW7.b(XM4.this.F0)) {
                if (!view2.post(new b(view2, c11637dL5))) {
                    return;
                }
            }
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ InterfaceC20284rl0 c;
        final /* synthetic */ XM4 d;
        final /* synthetic */ C8967Xz7 e;
        final /* synthetic */ AbstractC23538x54 f;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            /* synthetic */ Object c;
            final /* synthetic */ XM4 d;
            final /* synthetic */ C8967Xz7 e;
            final /* synthetic */ AbstractC23538x54 f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(XM4 xm4, C8967Xz7 c8967Xz7, AbstractC23538x54 abstractC23538x54, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.d = xm4;
                this.e = c8967Xz7;
                this.f = abstractC23538x54;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final C19938rB7 y(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, G73 g73) {
                abstractC23538x54.b().r(c8967Xz7, g73);
                return C19938rB7.a;
            }

            @Override // ir.nasim.E90
            public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
                a aVar = new a(this.d, this.e, this.f, interfaceC20295rm1);
                aVar.c = obj;
                return aVar;
            }

            @Override // ir.nasim.E90
            public final Object invokeSuspend(Object obj) {
                AbstractC14862ic3.e();
                if (this.b != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC10685c16.b(obj);
                if (((EnumC9477a18) this.c) == EnumC9477a18.d) {
                    XM4 xm4 = this.d;
                    C19672qk7 c19672qk7S = this.e.s();
                    boolean z = this.e.g() != null;
                    final AbstractC23538x54 abstractC23538x54 = this.f;
                    final C8967Xz7 c8967Xz7 = this.e;
                    xm4.H1(c19672qk7S, z, new UA2() { // from class: ir.nasim.YM4
                        @Override // ir.nasim.UA2
                        public final Object invoke(Object obj2) {
                            return XM4.d.a.y(abstractC23538x54, c8967Xz7, (G73) obj2);
                        }
                    });
                } else {
                    LinearLayout linearLayout = this.d.F0;
                    if (linearLayout != null) {
                        linearLayout.removeAllViews();
                    }
                }
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: w, reason: merged with bridge method [inline-methods] */
            public final Object invoke(EnumC9477a18 enumC9477a18, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(enumC9477a18, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(InterfaceC20284rl0 interfaceC20284rl0, XM4 xm4, C8967Xz7 c8967Xz7, AbstractC23538x54 abstractC23538x54, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = interfaceC20284rl0;
            this.d = xm4;
            this.e = c8967Xz7;
            this.f = abstractC23538x54;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new d(this.c, this.d, this.e, this.f, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC10258bL6 state = ((NM) this.c).X1().i.getState();
                a aVar = new a(this.d, this.e, this.f, null);
                this.b = 1;
                if (AbstractC6459Nq2.l(state, aVar, this) == objE) {
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public XM4(C11851df3 c11851df3, InterfaceC20284rl0 interfaceC20284rl0, InterfaceC22948w54 interfaceC22948w54, EW7 ew7, EnumC8893Xt7 enumC8893Xt7, boolean z) {
        AbstractC13042fc3.i(c11851df3, "binding");
        AbstractC13042fc3.i(interfaceC20284rl0, "bubble");
        AbstractC13042fc3.i(interfaceC22948w54, "messageClickListener");
        AbstractC13042fc3.i(ew7, "viewHolderClickListener");
        ConstraintLayout root = c11851df3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root, interfaceC20284rl0, interfaceC22948w54, enumC8893Xt7, ew7);
        this.D0 = c11851df3;
        this.E0 = interfaceC20284rl0;
        c11851df3.c.setTypeface(C6011Lu2.k());
        c11851df3.e.setTypeface(C6011Lu2.i());
        this.F0 = J1(z);
    }

    private final void D1(LinearLayout linearLayout, C19672qk7 c19672qk7, UA2 ua2) {
        List<C20281rk7> listA = c19672qk7.a();
        ViewGroup.LayoutParams layoutParamsM1 = M1();
        for (C20281rk7 c20281rk7 : listA) {
            Context context = linearLayout.getContext();
            AbstractC13042fc3.h(context, "getContext(...)");
            TemplateRowView templateRowView = new TemplateRowView(context, null, 0, 6, null);
            templateRowView.e(c20281rk7, ua2);
            linearLayout.addView(templateRowView, layoutParamsM1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 E1(AbstractC23538x54 abstractC23538x54, C8967Xz7 c8967Xz7, G73 g73) {
        AbstractC13042fc3.i(abstractC23538x54, "$messageClickListenerAdapter");
        AbstractC13042fc3.i(c8967Xz7, "$message");
        AbstractC13042fc3.i(g73, "inlineButton");
        abstractC23538x54.b().r(c8967Xz7, g73);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 F1(N15.k kVar, G73 g73) {
        AbstractC13042fc3.i(kVar, "$this_with");
        AbstractC13042fc3.i(g73, "inlineButton");
        kVar.c().b().r(kVar.b(), g73);
        return C19938rB7.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H1(C19672qk7 c19672qk7, boolean z, UA2 ua2) {
        LinearLayout linearLayout = this.F0;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            if ((this.E0 instanceof NM) && l1(c19672qk7) && !((NM) this.E0).X1().i.a()) {
                return;
            }
            LinearLayout linearLayout2 = this.F0;
            if (linearLayout2.isLaidOut() && !linearLayout2.isLayoutRequested()) {
                C11637dL5 c11637dL5 = new C11637dL5();
                c11637dL5.a = this.E0.d().getWidth() - ((int) ((12 * AbstractC3742Cd6.c()) + 0.5d));
                Iterator it = AbstractC24379yW7.b(this.F0).iterator();
                while (it.hasNext()) {
                    c11637dL5.a = Math.max(((View) it.next()).getWidth(), c11637dL5.a);
                }
                for (View view : AbstractC24379yW7.b(this.F0)) {
                    if (!view.post(new b(view, c11637dL5))) {
                        break;
                    }
                }
            } else {
                linearLayout2.addOnLayoutChangeListener(new c());
            }
            if (c19672qk7 == null || z) {
                return;
            }
            D1(linearLayout, c19672qk7, ua2);
        }
    }

    private final void I1(C8967Xz7 c8967Xz7, InterfaceC20284rl0 interfaceC20284rl0, AbstractC23538x54 abstractC23538x54) {
        if (interfaceC20284rl0 instanceof NM) {
            C8386Vt0 c8386Vt0 = C8386Vt0.a;
            if (c8386Vt0.Tb() && c8386Vt0.Vb()) {
                AbstractC10533bm0.d(((NM) interfaceC20284rl0).U1(), C12366eV1.c().F0(), null, new d(interfaceC20284rl0, this, c8967Xz7, abstractC23538x54, null), 2, null);
            }
        }
    }

    private final LinearLayout J1(boolean z) {
        C11851df3 c11851df3 = this.D0;
        if (!z) {
            return null;
        }
        LinearLayout linearLayout = new LinearLayout(c11851df3.getRoot().getContext());
        linearLayout.setId(View.generateViewId());
        linearLayout.setOrientation(1);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        linearLayout.setGravity(5);
        layoutParams.e = c11851df3.d.getId();
        layoutParams.g = 0;
        layoutParams.k = 0;
        double d2 = 8;
        layoutParams.setMargins((int) ((AbstractC3742Cd6.c() * d2) + 0.5d), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin, (int) ((d2 * AbstractC3742Cd6.c()) + 0.5d), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
        linearLayout.setLayoutParams(layoutParams);
        this.D0.getRoot().addView(linearLayout);
        ViewStub viewStub = c11851df3.b;
        AbstractC13042fc3.h(viewStub, "bubbleStub");
        L1(viewStub, linearLayout);
        return linearLayout;
    }

    private static final void L1(View view, LinearLayout linearLayout) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        layoutParams2.k = -1;
        layoutParams2.j = linearLayout.getId();
        view.setLayoutParams(layoutParams2);
    }

    private final LinearLayout.LayoutParams M1() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = (int) ((4 * AbstractC3742Cd6.c()) + 0.5d);
        return layoutParams;
    }

    @Override // ir.nasim.P64
    protected void V0(final C8967Xz7 c8967Xz7, Spannable spannable, boolean z, boolean z2, boolean z3, final AbstractC23538x54 abstractC23538x54, boolean z4) {
        AbstractC13042fc3.i(c8967Xz7, DialogEntity.COLUMN_MESSAGE);
        AbstractC13042fc3.i(abstractC23538x54, "messageClickListenerAdapter");
        super.V0(c8967Xz7, spannable, z, z2, z3, abstractC23538x54, z4);
        I1(c8967Xz7, this.E0, abstractC23538x54);
        H1(c8967Xz7.s(), c8967Xz7.g() != null, new UA2() { // from class: ir.nasim.VM4
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return XM4.E1(abstractC23538x54, c8967Xz7, (G73) obj);
            }
        });
        BubbleTextView bubbleTextView = this.D0.e;
        AbstractC13042fc3.h(bubbleTextView, "newMessageSeparator");
        bubbleTextView.setVisibility(z ? 0 : 8);
        this.D0.c.r(spannable);
    }

    @Override // ir.nasim.P64
    public int j1(int i) {
        ViewGroup.LayoutParams layoutParams = this.D0.b.getLayoutParams();
        AbstractC13042fc3.g(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        return (int) (i * ((ConstraintLayout.LayoutParams) layoutParams).U);
    }

    @Override // ir.nasim.P64
    protected void z(N15 n15) {
        AbstractC13042fc3.i(n15, "payload");
        if (!(n15 instanceof N15.k)) {
            super.z(n15);
        } else {
            final N15.k kVar = (N15.k) n15;
            H1(kVar.d(), kVar.b().g() != null, new UA2() { // from class: ir.nasim.WM4
                @Override // ir.nasim.UA2
                public final Object invoke(Object obj) {
                    return XM4.F1(kVar, (G73) obj);
                }
            });
        }
    }
}
