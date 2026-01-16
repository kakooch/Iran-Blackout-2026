package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketSection;

/* loaded from: classes2.dex */
public final class GQ3 extends AbstractC16640ld0 {
    public static final a D = new a(null);
    public static final int G = 8;
    private InterfaceC20315ro1 A;
    private C22536vP3 B;
    private final C22685vf3 v;
    private final C23731xQ3.b w;
    private final C12950fS3.b x;
    private final UA2 y;
    private final UA2 z;

    public static final class a {
        private a() {
        }

        private final void b(C22685vf3 c22685vf3) {
            c22685vf3.e.setTypeface(C6011Lu2.k());
            c22685vf3.d.setTypeface(C6011Lu2.k());
            if (C5495Jo7.a.J2()) {
                c22685vf3.c.setElevation(0.0f);
            }
            c22685vf3.b.B(22.0f, true);
        }

        public final GQ3 a(ViewGroup viewGroup, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(bVar2, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C22685vf3 c22685vf3C = C22685vf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c22685vf3C, "inflate(...)");
            b(c22685vf3C);
            return new GQ3(c22685vf3C, bVar, bVar2, ua2, ua22, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    static final class b extends AbstractC19859r37 implements InterfaceC14603iB2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ MarketItem d;
        final /* synthetic */ GQ3 e;

        static final class a extends AbstractC19859r37 implements InterfaceC14603iB2 {
            int b;
            final /* synthetic */ GQ3 c;
            final /* synthetic */ C14733iO2 d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(GQ3 gq3, C14733iO2 c14733iO2, InterfaceC20295rm1 interfaceC20295rm1) {
                super(2, interfaceC20295rm1);
                this.c = gq3;
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
                this.c.M0(this.d);
                return C19938rB7.a;
            }

            @Override // ir.nasim.InterfaceC14603iB2
            /* renamed from: n, reason: merged with bridge method [inline-methods] */
            public final Object invoke(InterfaceC20315ro1 interfaceC20315ro1, InterfaceC20295rm1 interfaceC20295rm1) {
                return ((a) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(MarketItem marketItem, GQ3 gq3, InterfaceC20295rm1 interfaceC20295rm1) {
            super(2, interfaceC20295rm1);
            this.d = marketItem;
            this.e = gq3;
        }

        @Override // ir.nasim.E90
        public final InterfaceC20295rm1 create(Object obj, InterfaceC20295rm1 interfaceC20295rm1) {
            b bVar = new b(this.d, this.e, interfaceC20295rm1);
            bVar.c = obj;
            return bVar;
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
            return ((b) create(interfaceC20315ro1, interfaceC20295rm1)).invokeSuspend(C19938rB7.a);
        }
    }

    public /* synthetic */ GQ3(C22685vf3 c22685vf3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c22685vf3, bVar, bVar2, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean J0(GQ3 gq3, MarketItem marketItem, View view) {
        AbstractC13042fc3.i(gq3, "this$0");
        AbstractC13042fc3.i(marketItem, "$item");
        gq3.x.x2(marketItem);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(GQ3 gq3, MarketItem marketItem, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(gq3, "this$0");
        AbstractC13042fc3.i(marketItem, "$item");
        AbstractC13042fc3.i(marketSection, "$row");
        C23731xQ3.b bVar = gq3.w;
        if (bVar != null) {
            bVar.C(marketItem, marketSection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M0(C14733iO2 c14733iO2) {
        this.v.b.q(c14733iO2);
    }

    private final void N0(MarketItem marketItem) {
        try {
            InterfaceC20315ro1 interfaceC20315ro1 = this.A;
            if (interfaceC20315ro1 != null) {
                AbstractC10533bm0.d(interfaceC20315ro1, null, null, new b(marketItem, this, null), 3, null);
            }
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public final void H0(final MarketItem marketItem, final MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        UA2 ua2 = this.y;
        C22536vP3 c22536vP3 = new C22536vP3(marketItem, marketSection);
        this.B = c22536vP3;
        ua2.invoke(c22536vP3);
        this.A = AbstractC20906so1.a(C12366eV1.b());
        this.v.c.setOnLongClickListener(new View.OnLongClickListener() { // from class: ir.nasim.EQ3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return GQ3.J0(this.a, marketItem, view);
            }
        });
        try {
            this.v.e.setText(XY6.e(marketItem.getTitle()));
            N0(marketItem);
            this.v.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.FQ3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    GQ3.L0(this.a, marketItem, marketSection, view);
                }
            });
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public final void a() {
        C22536vP3 c22536vP3 = this.B;
        if (c22536vP3 != null) {
            this.z.invoke(c22536vP3);
        }
        this.v.b.D();
        InterfaceC20315ro1 interfaceC20315ro1 = this.A;
        if (interfaceC20315ro1 != null) {
            AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private GQ3(C22685vf3 c22685vf3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
        ConstraintLayout root = c22685vf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c22685vf3;
        this.w = bVar;
        this.x = bVar2;
        this.y = ua2;
        this.z = ua22;
    }
}
