package ir.nasim;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import ir.nasim.PI7;

/* loaded from: classes7.dex */
public final class HS6 extends AbstractC16640ld0 {
    private final UW7 v;
    private HW7 w;
    private long x;

    static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        final /* synthetic */ C14375ho5 c;
        final /* synthetic */ HS6 d;

        /* renamed from: ir.nasim.HS6$a$a, reason: collision with other inner class name */
        static final class C0399a implements InterfaceC4806Gq2 {
            final /* synthetic */ HS6 a;

            C0399a(HS6 hs6) {
                this.a = hs6;
            }

            @Override // ir.nasim.InterfaceC4806Gq2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object a(PI7 pi7, InterfaceC20295rm1 interfaceC20295rm1) {
                this.a.P0(pi7);
                return C19938rB7.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(C14375ho5 c14375ho5, HS6 hs6, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.c = c14375ho5;
            this.d = hs6;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return new a(this.c, this.d, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            InterfaceC4557Fq2 interfaceC4557Fq2F;
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                C14375ho5 c14375ho5 = this.c;
                long j = this.d.x;
                this.b = 1;
                obj = c14375ho5.F(j, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC10685c16.b(obj);
                    return C19938rB7.a;
                }
                AbstractC10685c16.b(obj);
            }
            InterfaceC4557Fq2 interfaceC4557Fq2 = (InterfaceC4557Fq2) obj;
            if (interfaceC4557Fq2 != null && (interfaceC4557Fq2F = AbstractC6459Nq2.F(interfaceC4557Fq2)) != null) {
                C0399a c0399a = new C0399a(this.d);
                this.b = 2;
                if (interfaceC4557Fq2F.b(c0399a, this) == objE) {
                    return objE;
                }
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ HS6(View view, UW7 uw7, int i, ED1 ed1) {
        this(view, (i & 2) != 0 ? new UW7() : uw7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(InterfaceC14603iB2 interfaceC14603iB2, C4818Gr5 c4818Gr5, CheckBox checkBox, View view) {
        AbstractC13042fc3.i(interfaceC14603iB2, "$itemClick");
        AbstractC13042fc3.i(c4818Gr5, "$item");
        AbstractC13042fc3.i(checkBox, "$checkBox");
        interfaceC14603iB2.invoke(Integer.valueOf(c4818Gr5.a().r()), Boolean.valueOf(checkBox.isChecked()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(HS6 hs6, View view) {
        AbstractC13042fc3.i(hs6, "this$0");
        hs6.w.b.performClick();
    }

    private final void N0() {
        HW7 hw7 = this.w;
        hw7.d.setText(hw7.getRoot().getContext().getString(AbstractC12217eE5.members_adapter_bot_online_status));
        ImageView imageView = hw7.f;
        AbstractC13042fc3.h(imageView, "onlineCircle");
        imageView.setVisibility(8);
    }

    private final InterfaceC13730gj3 O0() {
        return AbstractC10533bm0.d(androidx.lifecycle.o.a(this.v.getLifecycle()), null, null, new a(AbstractC5969Lp4.e().H().e0(), this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(PI7 pi7) {
        HW7 hw7 = this.w;
        Context context = hw7.d.getContext();
        AbstractC13042fc3.f(context);
        String strY = C14593iA1.y(context, pi7, false, 4, null);
        if (pi7.u() == PI7.a.ONLINE) {
            hw7.d.setTextColor(C5495Jo7.a.e2());
            hw7.f.setImageResource(KB5.ic_online_circle);
        } else {
            hw7.d.setTextColor(C5495Jo7.a.n0());
            hw7.f.setImageResource(KB5.ic_online_circle_gray);
        }
        hw7.d.setText(strY);
    }

    public final void J0(final C4818Gr5 c4818Gr5, final InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(c4818Gr5, "item");
        AbstractC13042fc3.i(interfaceC14603iB2, "itemClick");
        this.x = c4818Gr5.a().r();
        this.w.e.setText(c4818Gr5.a().getName());
        if (c4818Gr5.a().s()) {
            N0();
        } else {
            O0();
        }
        this.w.c.o(c4818Gr5.a());
        final CheckBox checkBox = this.w.b;
        checkBox.setChecked(c4818Gr5.b());
        checkBox.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HS6.L0(interfaceC14603iB2, c4818Gr5, checkBox, view);
            }
        });
        this.w.getRoot().setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.GS6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                HS6.M0(this.a, view);
            }
        });
    }

    public void Q0() {
        this.v.a();
    }

    public void S0() {
        this.v.b();
    }

    public final void a() {
        this.w.c.D();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HS6(View view, UW7 uw7) {
        super(view);
        AbstractC13042fc3.i(view, "itemView");
        AbstractC13042fc3.i(uw7, "viewLifecycleHolder");
        this.v = uw7;
        HW7 hw7A = HW7.a(view);
        AbstractC13042fc3.h(hw7A, "bind(...)");
        this.w = hw7A;
        hw7A.c.B(22.0f, true);
    }
}
