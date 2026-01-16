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

/* loaded from: classes2.dex */
public final class VO3 extends AbstractC16640ld0 {
    public static final a G = new a(null);
    public static final int H = 8;
    private InterfaceC20315ro1 A;
    private InterfaceC7857Tm2 B;
    private C9724aS3 D;
    private final C4942Hf3 v;
    private final C23731xQ3.b w;
    private final C12950fS3.b x;
    private final UA2 y;
    private final UA2 z;

    public static final class a {
        private a() {
        }

        private final void b(C4942Hf3 c4942Hf3) {
            c4942Hf3.d.setTypeface(C6011Lu2.i());
            if (C5495Jo7.a.J2()) {
                c4942Hf3.b.setElevation(0.0f);
            }
        }

        public final VO3 a(ViewGroup viewGroup, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(bVar2, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C4942Hf3 c4942Hf3C = C4942Hf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c4942Hf3C, "inflate(...)");
            b(c4942Hf3C);
            return new VO3(c4942Hf3C, bVar, bVar2, ua2, ua22, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public static final class b implements InterfaceC8091Um2 {
        b() {
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void c(float f) {
            VO3.this.N0();
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void d(InterfaceC3346Am2 interfaceC3346Am2) {
            AbstractC13042fc3.i(interfaceC3346Am2, "reference");
            QI2 qi2 = QI2.a;
            ImageView imageView = VO3.this.v.e;
            AbstractC13042fc3.h(imageView, "img");
            qi2.m(imageView, interfaceC3346Am2.getDescriptor());
            VO3.this.v.e.setVisibility(0);
            VO3.this.v.f.getRoot().setVisibility(8);
        }

        @Override // ir.nasim.InterfaceC8091Um2
        public void e() {
            VO3.this.N0();
        }
    }

    public /* synthetic */ VO3(C4942Hf3 c4942Hf3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c4942Hf3, bVar, bVar2, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean L0(VO3 vo3, MarketProductItem marketProductItem, View view) {
        AbstractC13042fc3.i(vo3, "this$0");
        AbstractC13042fc3.i(marketProductItem, "$item");
        vo3.x.x2(marketProductItem);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M0(VO3 vo3, MarketProductItem marketProductItem, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(vo3, "this$0");
        AbstractC13042fc3.i(marketProductItem, "$item");
        AbstractC13042fc3.i(marketSection, "$row");
        C23731xQ3.b bVar = vo3.w;
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
        this.v.f.getRoot().setVisibility(0);
    }

    private final void O0(MarketProductItem marketProductItem) {
        InterfaceC7857Tm2 interfaceC7857Tm2 = this.B;
        if (interfaceC7857Tm2 != null) {
            interfaceC7857Tm2.b();
            this.B = null;
        }
        this.B = AbstractC5969Lp4.e().D().D(marketProductItem.getPost().fileReference(), true, new b(), (56 & 8) != 0 ? false : false, (56 & 16) != 0, (56 & 32) != 0 ? false : false);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0075 A[Catch: Exception -> 0x0044, TryCatch #0 {Exception -> 0x0044, blocks: (B:3:0x002c, B:5:0x0038, B:7:0x003f, B:12:0x0049, B:14:0x007e, B:13:0x0075), top: B:18:0x002c }] */
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
            ir.nasim.Hf3 r0 = r4.v
            androidx.cardview.widget.CardView r0 = r0.b
            ir.nasim.TO3 r1 = new ir.nasim.TO3
            r1.<init>()
            r0.setOnLongClickListener(r1)
            r4.N0()     // Catch: java.lang.Exception -> L44
            r4.O0(r5)     // Catch: java.lang.Exception -> L44
            java.lang.Integer r0 = r5.getDiscount()     // Catch: java.lang.Exception -> L44
            if (r0 == 0) goto L75
            java.lang.Integer r0 = r5.getDiscount()     // Catch: java.lang.Exception -> L44
            r1 = 0
            if (r0 == 0) goto L46
            int r0 = r0.intValue()     // Catch: java.lang.Exception -> L44
            goto L47
        L44:
            r5 = move-exception
            goto L8b
        L46:
            r0 = r1
        L47:
            if (r0 <= 0) goto L75
            ir.nasim.Hf3 r0 = r4.v     // Catch: java.lang.Exception -> L44
            android.widget.TextView r0 = r0.d     // Catch: java.lang.Exception -> L44
            java.lang.Integer r2 = r5.getDiscount()     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = ir.nasim.GY6.a(r2)     // Catch: java.lang.Exception -> L44
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L44
            r3.<init>()     // Catch: java.lang.Exception -> L44
            r3.append(r2)     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = "%"
            r3.append(r2)     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = r3.toString()     // Catch: java.lang.Exception -> L44
            r0.setText(r2)     // Catch: java.lang.Exception -> L44
            ir.nasim.Hf3 r0 = r4.v     // Catch: java.lang.Exception -> L44
            android.widget.TextView r0 = r0.d     // Catch: java.lang.Exception -> L44
            r0.setVisibility(r1)     // Catch: java.lang.Exception -> L44
            goto L7e
        L75:
            ir.nasim.Hf3 r0 = r4.v     // Catch: java.lang.Exception -> L44
            android.widget.TextView r0 = r0.d     // Catch: java.lang.Exception -> L44
            r1 = 8
            r0.setVisibility(r1)     // Catch: java.lang.Exception -> L44
        L7e:
            ir.nasim.Hf3 r0 = r4.v     // Catch: java.lang.Exception -> L44
            androidx.cardview.widget.CardView r0 = r0.b     // Catch: java.lang.Exception -> L44
            ir.nasim.UO3 r1 = new ir.nasim.UO3     // Catch: java.lang.Exception -> L44
            r1.<init>()     // Catch: java.lang.Exception -> L44
            r0.setOnClickListener(r1)     // Catch: java.lang.Exception -> L44
            goto L90
        L8b:
            java.lang.String r6 = "NON_FATAL_EXCEPTION"
            ir.nasim.C19406qI3.d(r6, r5)
        L90:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.VO3.J0(ir.nasim.core.modules.market.model.MarketProductItem, ir.nasim.core.modules.market.model.MarketSection):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private VO3(C4942Hf3 c4942Hf3, C23731xQ3.b bVar, C12950fS3.b bVar2, UA2 ua2, UA2 ua22) {
        ConstraintLayout root = c4942Hf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c4942Hf3;
        this.w = bVar;
        this.x = bVar2;
        this.y = ua2;
        this.z = ua22;
    }
}
