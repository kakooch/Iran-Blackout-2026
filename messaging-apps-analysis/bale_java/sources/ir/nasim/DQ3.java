package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.D20;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketPost;
import ir.nasim.core.modules.market.model.MarketSection;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class DQ3 extends AbstractC16640ld0 {
    public static final a Z = new a(null);
    public static final int z0 = 8;
    private MarketItem A;
    private InterfaceC20315ro1 B;
    private InterfaceC20315ro1 D;
    private InterfaceC7857Tm2 G;
    private InterfaceC7857Tm2 H;
    private InterfaceC7857Tm2 J;
    private C22536vP3 Y;
    private final C3991Df3 v;
    private final C23731xQ3.b w;
    private final C12950fS3.b x;
    private final UA2 y;
    private final UA2 z;

    public static final class a {
        private a() {
        }

        private final void b(C3991Df3 c3991Df3) {
            c3991Df3.o.setTypeface(C6011Lu2.k());
            c3991Df3.n.setTypeface(C6011Lu2.i());
            c3991Df3.g.setTypeface(C6011Lu2.i());
            TextView textView = c3991Df3.g;
            int iA = C22078ud6.a(8.0f);
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            textView.setBackground(AbstractC4310Eo7.d(iA, c5495Jo7.i1()));
            if (c5495Jo7.J2()) {
                c3991Df3.c.setElevation(0.0f);
            }
            c3991Df3.b.B(22.0f, true);
        }

        public final DQ3 a(ViewGroup viewGroup, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(bVar2, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C3991Df3 c3991Df3C = C3991Df3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c3991Df3C, "inflate(...)");
            b(c3991Df3C);
            return new DQ3(c3991Df3C, bVar, bVar2, ua2, ua22, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;

        b(InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            return DQ3.this.new b(interfaceC20295rm1);
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            AbstractC14862ic3.e();
            if (this.b != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC10685c16.b(obj);
            if (!C7183Qq.p().h("showed_report_tooltip", false)) {
                String string = DQ3.this.v.o.getContext().getString(AbstractC12217eE5.market_report_description);
                AbstractC13042fc3.h(string, "getString(...)");
                D20.a aVarA = C10600bs7.a.a(null);
                aVarA.X1(string);
                aVarA.a1(0.85f);
                aVarA.j2(false);
                aVarA.L1(200);
                aVarA.b2(8388611);
                D20 d20A = aVarA.a();
                TextView textView = DQ3.this.v.o;
                AbstractC13042fc3.h(textView, "title");
                d20A.J0(textView, AbstractC8943Xx1.c(DQ3.this.v.b.getWidth() - 10) / 2, AbstractC8943Xx1.c(6));
                C7183Qq.p().g("showed_report_tooltip", true);
            }
            return C19938rB7.a;
        }

        @Override // ir.nasim.InterfaceC14603iB2
        /* renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public static final class c implements InterfaceC8091Um2 {
        final /* synthetic */ XV4 b;

        c(XV4 xv4) {
            this.b = xv4;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            DQ3.this.Q0(this.b);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2.a.m((ImageView) this.b.e(), interfaceC3346Am2.getDescriptor());
            ((ImageView) this.b.e()).setVisibility(0);
            ((ShimmerFrameLayout) this.b.f()).setVisibility(8);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            DQ3.this.Q0(this.b);
        }
    }

    public static final class d implements InterfaceC8091Um2 {
        final /* synthetic */ XV4 b;

        d(XV4 xv4) {
            this.b = xv4;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            DQ3.this.Q0(this.b);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2.a.m((ImageView) this.b.e(), interfaceC3346Am2.getDescriptor());
            ((ImageView) this.b.e()).setVisibility(0);
            ((ShimmerFrameLayout) this.b.f()).setVisibility(8);
            DQ3.this.H = null;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            DQ3.this.Q0(this.b);
        }
    }

    public static final class e implements InterfaceC8091Um2 {
        final /* synthetic */ XV4 b;

        e(XV4 xv4) {
            this.b = xv4;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            DQ3.this.Q0(this.b);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2.a.m((ImageView) this.b.e(), interfaceC3346Am2.getDescriptor());
            ((ImageView) this.b.e()).setVisibility(0);
            ((ShimmerFrameLayout) this.b.f()).setVisibility(8);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            DQ3.this.Q0(this.b);
        }
    }

    static final class f extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MarketItem d;
        final /* synthetic */ DQ3 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ DQ3 c;
            final /* synthetic */ C14733iO2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(DQ3 dq3, C14733iO2 c14733iO2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = dq3;
                this.d = c14733iO2;
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
                this.c.S0(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(MarketItem marketItem, DQ3 dq3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = marketItem;
            this.e = dq3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            f fVar = new f(this.d, this.e, interfaceC20295rm1);
            fVar.c = obj;
            return fVar;
        }

        @Override // ir.nasim.E90
        public final Object invokeSuspend(Object obj) {
            Object objE = AbstractC14862ic3.e();
            int i = this.b;
            if (i == 0) {
                AbstractC10685c16.b(obj);
                InterfaceC20315ro1 interfaceC20315ro1 = (InterfaceC20315ro1) this.c;
                C14733iO2 c14733iO2V = AbstractC5969Lp4.d().V((int) this.d.getId());
                if (c14733iO2V != null && AbstractC20906so1.g(interfaceC20315ro1)) {
                    WM3 wm3C = C12366eV1.c();
                    a aVar = new a(this.e, c14733iO2V, null);
                    this.b = 1;
                    if (AbstractC9323Zl0.g(wm3C, aVar, this) == objE) {
                        return objE;
                    }
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
            return ((f) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ DQ3(C3991Df3 c3991Df3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c3991Df3, bVar, bVar2, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean N0(DQ3 dq3, MarketItem marketItem, View view) {
        AbstractC13042fc3.i(dq3, "this$0");
        AbstractC13042fc3.i(marketItem, "$item");
        dq3.x.x2(marketItem);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(DQ3 dq3, MarketItem marketItem, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(dq3, "this$0");
        AbstractC13042fc3.i(marketItem, "$item");
        AbstractC13042fc3.i(marketSection, "$row");
        C23731xQ3.b bVar = dq3.w;
        if (bVar != null) {
            bVar.C(marketItem, marketSection);
        }
    }

    private final XV4 P0(int i) {
        if (i == 0) {
            C3991Df3 c3991Df3 = this.v;
            return new XV4(c3991Df3.h, c3991Df3.k.getRoot());
        }
        if (i != 1) {
            C3991Df3 c3991Df32 = this.v;
            return new XV4(c3991Df32.j, c3991Df32.m.getRoot());
        }
        C3991Df3 c3991Df33 = this.v;
        return new XV4(c3991Df33.i, c3991Df33.l.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(XV4 xv4) {
        QI2.a.a((ImageView) xv4.e());
        ((ImageView) xv4.e()).setVisibility(8);
        ((ShimmerFrameLayout) xv4.f()).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S0(C14733iO2 c14733iO2) {
        this.v.b.q(c14733iO2);
    }

    private final void T0(MarketItem marketItem) {
        ArrayList<MarketPost> posts = marketItem.getPosts();
        if (posts == null || posts.isEmpty()) {
            this.v.j.setVisibility(8);
            this.v.m.getRoot().setVisibility(0);
            this.v.i.setVisibility(8);
            this.v.l.getRoot().setVisibility(0);
            this.v.h.setVisibility(8);
            this.v.k.getRoot().setVisibility(0);
            return;
        }
        ArrayList<MarketPost> posts2 = marketItem.getPosts();
        AbstractC13042fc3.f(posts2);
        int i = 0;
        for (Object obj : posts2) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC10360bX0.w();
            }
            MarketPost marketPost = (MarketPost) obj;
            XV4 xv4P0 = P0(i);
            if (i == 0) {
                InterfaceC7857Tm2 interfaceC7857Tm2 = this.G;
                if (interfaceC7857Tm2 != null) {
                    interfaceC7857Tm2.b();
                    this.G = null;
                }
                this.G = AbstractC5969Lp4.e().D().D(marketPost.fileReference(), true, new c(xv4P0), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            } else if (i == 1) {
                InterfaceC7857Tm2 interfaceC7857Tm22 = this.H;
                if (interfaceC7857Tm22 != null) {
                    interfaceC7857Tm22.b();
                    this.H = null;
                }
                this.H = AbstractC5969Lp4.e().D().D(marketPost.fileReference(), true, new d(xv4P0), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            } else if (i == 2) {
                InterfaceC7857Tm2 interfaceC7857Tm23 = this.J;
                if (interfaceC7857Tm23 != null) {
                    interfaceC7857Tm23.b();
                    this.J = null;
                }
                this.J = AbstractC5969Lp4.e().D().D(marketPost.fileReference(), true, new e(xv4P0), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            }
            i = i2;
        }
        ArrayList<MarketPost> posts3 = marketItem.getPosts();
        AbstractC13042fc3.f(posts3);
        if (posts3.size() == 2) {
            this.v.j.setVisibility(8);
            this.v.m.getRoot().setVisibility(0);
        }
        ArrayList<MarketPost> posts4 = marketItem.getPosts();
        AbstractC13042fc3.f(posts4);
        if (posts4.size() == 1) {
            this.v.j.setVisibility(8);
            this.v.m.getRoot().setVisibility(0);
            this.v.i.setVisibility(8);
            this.v.l.getRoot().setVisibility(0);
        }
    }

    private final void U0(MarketItem marketItem) {
        try {
            InterfaceC20315ro1 interfaceC20315ro1 = this.B;
            if (interfaceC20315ro1 != null) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new f(marketItem, this, null), 3, null);
            }
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    private final void V0() {
        Q0(P0(0));
        Q0(P0(1));
        Q0(P0(2));
    }

    public final void M0(final MarketItem marketItem, final MarketSection marketSection, boolean z) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        UA2 ua2 = this.y;
        C22536vP3 c22536vP3 = new C22536vP3(marketItem, marketSection);
        this.Y = c22536vP3;
        ua2.invoke(c22536vP3);
        this.B = AbstractC20906so1.a(C12366eV1.b());
        if (z) {
            InterfaceC20315ro1 interfaceC20315ro1A = AbstractC20906so1.a(C12366eV1.c());
            this.D = interfaceC20315ro1A;
            if (interfaceC20315ro1A != null) {
                AbstractC10533bm0.d(interfaceC20315ro1A, null, null, new b(null), 3, null);
            }
        }
        this.v.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.BQ3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return DQ3.N0(this.a, marketItem, view);
            }
        });
        this.A = marketItem;
        try {
            V0();
            this.v.o.setText(XY6.e(marketItem.getTitle()));
            if (marketItem.getDiscount() != null) {
                Integer discount = marketItem.getDiscount();
                AbstractC13042fc3.f(discount);
                if (discount.intValue() < 1) {
                    this.v.n.setVisibility(0);
                    this.v.g.setVisibility(8);
                } else {
                    this.v.n.setVisibility(8);
                    this.v.g.setText(Separators.PERCENT + XY6.e(String.valueOf(marketItem.getDiscount())));
                    this.v.g.setVisibility(0);
                }
            } else {
                this.v.n.setVisibility(0);
                this.v.g.setVisibility(8);
            }
            U0(marketItem);
            T0(marketItem);
            this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.CQ3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DQ3.O0(this.a, marketItem, marketSection, view);
                }
            });
        } catch (Exception e2) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e2);
        }
    }

    public final void a() {
        C22536vP3 c22536vP3 = this.Y;
        if (c22536vP3 != null) {
            this.z.invoke(c22536vP3);
        }
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.G;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
            this.G = null;
        }
        InterfaceC7857Tm2 interfaceC7857Tm22 = this.H;
        if (interfaceC7857Tm22 != null) {
            interfaceC7857Tm22.a(true);
            this.H = null;
        }
        InterfaceC7857Tm2 interfaceC7857Tm23 = this.J;
        if (interfaceC7857Tm23 != null) {
            interfaceC7857Tm23.a(true);
            this.J = null;
        }
        V0();
        this.v.b.D();
        InterfaceC20315ro1 interfaceC20315ro1 = this.B;
        if (interfaceC20315ro1 != null) {
            AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
        }
        InterfaceC20315ro1 interfaceC20315ro12 = this.D;
        if (interfaceC20315ro12 != null) {
            AbstractC20906so1.d(interfaceC20315ro12, null, 1, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private DQ3(C3991Df3 c3991Df3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
        ConstraintLayout root = c3991Df3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c3991Df3;
        this.w = bVar;
        this.x = bVar2;
        this.y = ua2;
        this.z = ua22;
    }
}
