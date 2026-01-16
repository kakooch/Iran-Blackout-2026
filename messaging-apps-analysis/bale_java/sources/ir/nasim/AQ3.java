package ir.nasim;

import android.gov.nist.core.Separators;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.facebook.shimmer.ShimmerFrameLayout;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketPost;
import ir.nasim.core.modules.market.model.MarketSection;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class AQ3 extends AbstractC16640ld0 {
    public static final a J = new a(null);
    public static final int Y = 8;
    private MarketItem A;
    private InterfaceC20315ro1 B;
    private InterfaceC7857Tm2 D;
    private InterfaceC7857Tm2 G;
    private C22536vP3 H;
    private final C4459Ff3 v;
    private final C23731xQ3.b w;
    private final C12950fS3.b x;
    private final UA2 y;
    private final UA2 z;

    public static final class a {
        private a() {
        }

        private final void b(C4459Ff3 c4459Ff3) {
            c4459Ff3.k.setTypeface(C6011Lu2.k());
            C5495Jo7 c5495Jo7 = C5495Jo7.a;
            if (c5495Jo7.J2()) {
                c4459Ff3.c.setElevation(0.0f);
            }
            c4459Ff3.f.setTypeface(C6011Lu2.i());
            c4459Ff3.f.setBackground(AbstractC4310Eo7.d(C22078ud6.a(8.0f), c5495Jo7.i1()));
            if (c5495Jo7.J2()) {
                c4459Ff3.c.setElevation(0.0f);
            }
            c4459Ff3.b.B(22.0f, true);
        }

        public final AQ3 a(ViewGroup viewGroup, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(bVar2, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C4459Ff3 c4459Ff3C = C4459Ff3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c4459Ff3C, "inflate(...)");
            b(c4459Ff3C);
            return new AQ3(c4459Ff3C, bVar, bVar2, ua2, ua22, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements InterfaceC8091Um2 {
        final /* synthetic */ XV4 b;

        b(XV4 xv4) {
            this.b = xv4;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            AQ3.this.P0(this.b);
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
            AQ3.this.P0(this.b);
        }
    }

    public static final class c implements InterfaceC8091Um2 {
        final /* synthetic */ XV4 b;

        c(XV4 xv4) {
            this.b = xv4;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            AQ3.this.P0(this.b);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2.a.m((ImageView) this.b.e(), interfaceC3346Am2.getDescriptor());
            ((ImageView) this.b.e()).setVisibility(0);
            ((ShimmerFrameLayout) this.b.f()).setVisibility(8);
            AQ3.this.G = null;
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            AQ3.this.P0(this.b);
        }
    }

    static final class d extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MarketItem d;
        final /* synthetic */ AQ3 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ AQ3 c;
            final /* synthetic */ C14733iO2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(AQ3 aq3, C14733iO2 c14733iO2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = aq3;
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
                this.c.Q0(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(MarketItem marketItem, AQ3 aq3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = marketItem;
            this.e = aq3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            d dVar = new d(this.d, this.e, interfaceC20295rm1);
            dVar.c = obj;
            return dVar;
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
            return ((d) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ AQ3(C4459Ff3 c4459Ff3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c4459Ff3, bVar, bVar2, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean M0(AQ3 aq3, MarketItem marketItem, View view) {
        AbstractC13042fc3.i(aq3, "this$0");
        AbstractC13042fc3.i(marketItem, "$item");
        aq3.x.x2(marketItem);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N0(AQ3 aq3, MarketItem marketItem, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(aq3, "this$0");
        AbstractC13042fc3.i(marketItem, "$item");
        AbstractC13042fc3.i(marketSection, "$row");
        C23731xQ3.b bVar = aq3.w;
        if (bVar != null) {
            bVar.C(marketItem, marketSection);
        }
    }

    private final XV4 O0(int i) {
        if (i == 0) {
            C4459Ff3 c4459Ff3 = this.v;
            return new XV4(c4459Ff3.g, c4459Ff3.i.getRoot());
        }
        C4459Ff3 c4459Ff32 = this.v;
        return new XV4(c4459Ff32.h, c4459Ff32.j.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P0(XV4 xv4) {
        QI2.a.a((ImageView) xv4.e());
        ((ImageView) xv4.e()).setVisibility(8);
        ((ShimmerFrameLayout) xv4.f()).setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q0(C14733iO2 c14733iO2) {
        this.v.b.q(c14733iO2);
    }

    private final void S0(MarketItem marketItem) {
        ArrayList<MarketPost> posts = marketItem.getPosts();
        if (posts == null || posts.isEmpty()) {
            this.v.h.setVisibility(8);
            this.v.j.getRoot().setVisibility(0);
            this.v.g.setVisibility(8);
            this.v.i.getRoot().setVisibility(0);
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
            XV4 xv4O0 = O0(i);
            if (i == 0) {
                InterfaceC7857Tm2 interfaceC7857Tm2 = this.D;
                if (interfaceC7857Tm2 != null) {
                    interfaceC7857Tm2.b();
                    this.D = null;
                }
                this.D = AbstractC5969Lp4.e().D().D(marketPost.fileReference(), true, new b(xv4O0), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            } else if (i == 1) {
                InterfaceC7857Tm2 interfaceC7857Tm22 = this.G;
                if (interfaceC7857Tm22 != null) {
                    interfaceC7857Tm22.b();
                    this.G = null;
                }
                this.G = AbstractC5969Lp4.e().D().D(marketPost.fileReference(), true, new c(xv4O0), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
            }
            i = i2;
        }
        ArrayList<MarketPost> posts3 = marketItem.getPosts();
        AbstractC13042fc3.f(posts3);
        if (posts3.size() == 1) {
            this.v.h.setVisibility(8);
            this.v.j.getRoot().setVisibility(0);
        }
    }

    private final void T0(MarketItem marketItem) {
        try {
            InterfaceC20315ro1 interfaceC20315ro1 = this.B;
            if (interfaceC20315ro1 != null) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new d(marketItem, this, null), 3, null);
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    private final void U0() {
        P0(O0(0));
        P0(O0(1));
    }

    public final void L0(final MarketItem marketItem, final MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        UA2 ua2 = this.y;
        C22536vP3 c22536vP3 = new C22536vP3(marketItem, marketSection);
        this.H = c22536vP3;
        ua2.invoke(c22536vP3);
        this.B = AbstractC20906so1.a(C12366eV1.b());
        this.v.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.yQ3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AQ3.M0(this.a, marketItem, view);
            }
        });
        this.A = marketItem;
        try {
            U0();
            this.v.k.setText(XY6.e(marketItem.getTitle()));
            T0(marketItem);
            S0(marketItem);
            this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.zQ3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    AQ3.N0(this.a, marketItem, marketSection, view);
                }
            });
            if (marketItem.getDiscount() != null) {
                Integer discount = marketItem.getDiscount();
                AbstractC13042fc3.f(discount);
                if (discount.intValue() < 1) {
                    this.v.f.setVisibility(8);
                } else {
                    this.v.f.setText(Separators.PERCENT + XY6.e(String.valueOf(marketItem.getDiscount())));
                    this.v.f.setVisibility(0);
                }
            } else {
                this.v.f.setVisibility(8);
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public final void a() {
        C22536vP3 c22536vP3 = this.H;
        if (c22536vP3 != null) {
            this.z.invoke(c22536vP3);
        }
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.D;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
            this.D = null;
        }
        InterfaceC7857Tm2 interfaceC7857Tm22 = this.G;
        if (interfaceC7857Tm22 != null) {
            interfaceC7857Tm22.a(true);
            this.G = null;
        }
        U0();
        this.v.b.D();
        InterfaceC20315ro1 interfaceC20315ro1 = this.B;
        if (interfaceC20315ro1 != null) {
            AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private AQ3(C4459Ff3 c4459Ff3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
        CardView root = c4459Ff3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c4459Ff3;
        this.w = bVar;
        this.x = bVar2;
        this.y = ua2;
        this.z = ua22;
    }
}
