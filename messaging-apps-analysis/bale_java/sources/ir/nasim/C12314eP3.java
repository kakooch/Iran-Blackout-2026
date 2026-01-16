package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;

/* renamed from: ir.nasim.eP3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12314eP3 extends AbstractC16640ld0 {
    public static final a G = new a(null);
    public static final int H = 8;
    private InterfaceC20315ro1 A;
    private InterfaceC7857Tm2 B;
    private C9724aS3 D;
    private final C5176If3 v;
    private final C23731xQ3.b w;
    private final C12950fS3.b x;
    private final UA2 y;
    private final UA2 z;

    /* renamed from: ir.nasim.eP3$a */
    public static final class a {
        private a() {
        }

        private final void b(C5176If3 c5176If3) {
            c5176If3.l.setTypeface(C6011Lu2.k());
            c5176If3.g.setTypeface(C6011Lu2.i());
            c5176If3.h.setTypeface(C6011Lu2.k());
            c5176If3.i.setTypeface(C6011Lu2.k());
            c5176If3.d.setTypeface(C6011Lu2.i());
            if (C5495Jo7.a.J2()) {
                c5176If3.b.setElevation(0.0f);
            }
        }

        public final C12314eP3 a(ViewGroup viewGroup, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(bVar2, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C5176If3 c5176If3C = C5176If3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c5176If3C, "inflate(...)");
            b(c5176If3C);
            return new C12314eP3(c5176If3C, bVar, bVar2, ua2, ua22, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.eP3$b */
    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            C12314eP3.this.N0();
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2 qi2 = QI2.a;
            ImageView imageView = C12314eP3.this.v.e;
            AbstractC13042fc3.h(imageView, "img");
            qi2.m(imageView, interfaceC3346Am2.getDescriptor());
            C12314eP3.this.v.e.setVisibility(0);
            C12314eP3.this.v.k.getRoot().setVisibility(8);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            C12314eP3.this.N0();
        }
    }

    public /* synthetic */ C12314eP3(C5176If3 c5176If3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c5176If3, bVar, bVar2, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L0(C12314eP3 c12314eP3, MarketProductItem marketProductItem, View view) {
        AbstractC13042fc3.i(c12314eP3, "this$0");
        AbstractC13042fc3.i(marketProductItem, "$item");
        c12314eP3.x.x2(marketProductItem);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(C12314eP3 c12314eP3, MarketProductItem marketProductItem, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(c12314eP3, "this$0");
        AbstractC13042fc3.i(marketProductItem, "$item");
        AbstractC13042fc3.i(marketSection, "$row");
        C23731xQ3.b bVar = c12314eP3.w;
        if (bVar != null) {
            bVar.k(marketProductItem, marketSection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0() {
        QI2 qi2 = QI2.a;
        ImageView imageView = this.v.e;
        AbstractC13042fc3.h(imageView, "img");
        qi2.a(imageView);
        this.v.e.setVisibility(8);
        this.v.k.getRoot().setVisibility(0);
    }

    private final void O0(MarketProductItem marketProductItem) {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.B;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
            this.B = null;
        }
        this.B = AbstractC5969Lp4.e().D().D(marketProductItem.getPost().fileReference(), true, new b(), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00eb A[Catch: Exception -> 0x0056, TryCatch #0 {Exception -> 0x0056, blocks: (B:3:0x002c, B:5:0x004b, B:7:0x0051, B:11:0x005a, B:13:0x00b1, B:15:0x00be, B:17:0x00f4, B:16:0x00eb), top: B:21:0x002c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void J0(final ir.nasim.core.modules.market.model.MarketProductItem r5, final ir.nasim.core.modules.market.model.MarketSection r6) {
        /*
            r4 = this;
            java.lang.String r0 = "item"
            ir.nasim.AbstractC13042fc3.i(r5, r0)
            java.lang.String r0 = "row"
            ir.nasim.AbstractC13042fc3.i(r6, r0)
            ir.nasim.UA2 r0 = r4.y
            ir.nasim.aS3 r1 = new ir.nasim.aS3
            r1.<init>(r5, r6)
            r4.D = r1
            r0.invoke(r1)
            ir.nasim.go1 r0 = ir.nasim.C12366eV1.b()
            ir.nasim.ro1 r0 = ir.nasim.AbstractC20906so1.a(r0)
            r4.A = r0
            ir.nasim.If3 r0 = r4.v
            androidx.cardview.widget.CardView r0 = r0.b
            ir.nasim.cP3 r1 = new ir.nasim.cP3
            r1.<init>()
            r0.setOnLongClickListener(r1)
            r4.N0()     // Catch: java.lang.Exception -> L56
            r4.O0(r5)     // Catch: java.lang.Exception -> L56
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.l     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = r5.getTitle()     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = ir.nasim.XY6.e(r1)     // Catch: java.lang.Exception -> L56
            r0.setText(r1)     // Catch: java.lang.Exception -> L56
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.g     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = r5.getPrice()     // Catch: java.lang.Exception -> L56
            if (r1 == 0) goto L59
            java.lang.String r1 = ir.nasim.GY6.g(r1)     // Catch: java.lang.Exception -> L56
            if (r1 == 0) goto L59
            java.lang.String r1 = ir.nasim.GY6.a(r1)     // Catch: java.lang.Exception -> L56
            goto L5a
        L56:
            r5 = move-exception
            goto L101
        L59:
            r1 = 0
        L5a:
            android.view.View r2 = r4.a     // Catch: java.lang.Exception -> L56
            android.content.Context r2 = r2.getContext()     // Catch: java.lang.Exception -> L56
            int r3 = ir.nasim.AbstractC12217eE5.market_tooman     // Catch: java.lang.Exception -> L56
            java.lang.String r2 = r2.getString(r3)     // Catch: java.lang.Exception -> L56
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L56
            r3.<init>()     // Catch: java.lang.Exception -> L56
            r3.append(r1)     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = " "
            r3.append(r1)     // Catch: java.lang.Exception -> L56
            r3.append(r2)     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Exception -> L56
            r0.setText(r1)     // Catch: java.lang.Exception -> L56
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.h     // Catch: java.lang.Exception -> L56
            java.lang.Float r1 = r5.getRate()     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = ir.nasim.GY6.a(r1)     // Catch: java.lang.Exception -> L56
            r0.setText(r1)     // Catch: java.lang.Exception -> L56
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.i     // Catch: java.lang.Exception -> L56
            android.view.View r1 = r4.a     // Catch: java.lang.Exception -> L56
            android.content.Context r1 = r1.getContext()     // Catch: java.lang.Exception -> L56
            int r2 = ir.nasim.AbstractC12217eE5.market_comment     // Catch: java.lang.Exception -> L56
            java.lang.Integer r3 = r5.getRateCount()     // Catch: java.lang.Exception -> L56
            java.lang.Object[] r3 = new java.lang.Object[]{r3}     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = r1.getString(r2, r3)     // Catch: java.lang.Exception -> L56
            r0.setText(r1)     // Catch: java.lang.Exception -> L56
            java.lang.Integer r0 = r5.getDiscount()     // Catch: java.lang.Exception -> L56
            if (r0 == 0) goto Leb
            java.lang.Integer r0 = r5.getDiscount()     // Catch: java.lang.Exception -> L56
            ir.nasim.AbstractC13042fc3.f(r0)     // Catch: java.lang.Exception -> L56
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L56
            if (r0 <= 0) goto Leb
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.d     // Catch: java.lang.Exception -> L56
            java.lang.Integer r1 = r5.getDiscount()     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = ir.nasim.GY6.a(r1)     // Catch: java.lang.Exception -> L56
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L56
            r2.<init>()     // Catch: java.lang.Exception -> L56
            r2.append(r1)     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = "%"
            r2.append(r1)     // Catch: java.lang.Exception -> L56
            java.lang.String r1 = r2.toString()     // Catch: java.lang.Exception -> L56
            r0.setText(r1)     // Catch: java.lang.Exception -> L56
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.d     // Catch: java.lang.Exception -> L56
            r1 = 0
            r0.setVisibility(r1)     // Catch: java.lang.Exception -> L56
            goto Lf4
        Leb:
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            android.widget.TextView r0 = r0.d     // Catch: java.lang.Exception -> L56
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Exception -> L56
        Lf4:
            ir.nasim.If3 r0 = r4.v     // Catch: java.lang.Exception -> L56
            androidx.cardview.widget.CardView r0 = r0.b     // Catch: java.lang.Exception -> L56
            ir.nasim.dP3 r1 = new ir.nasim.dP3     // Catch: java.lang.Exception -> L56
            r1.<init>()     // Catch: java.lang.Exception -> L56
            r0.setOnClickListener(r1)     // Catch: java.lang.Exception -> L56
            goto L106
        L101:
            java.lang.String r6 = "NON_FATAL_EXCEPTION"
            ir.nasim.C19406qI3.d(r6, r5)
        L106:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C12314eP3.J0(ir.nasim.core.modules.market.model.MarketProductItem, ir.nasim.core.modules.market.model.MarketSection):void");
    }

    public final void a() {
        C9724aS3 c9724aS3 = this.D;
        if (c9724aS3 != null) {
            this.z.invoke(c9724aS3);
        }
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.B;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.a(true);
            this.B = null;
        }
        N0();
        InterfaceC20315ro1 interfaceC20315ro1 = this.A;
        if (interfaceC20315ro1 != null) {
            AbstractC20906so1.d(interfaceC20315ro1, null, 1, null);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C12314eP3(C5176If3 c5176If3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
        ConstraintLayout root = c5176If3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c5176If3;
        this.w = bVar;
        this.x = bVar2;
        this.y = ua2;
        this.z = ua22;
    }
}
