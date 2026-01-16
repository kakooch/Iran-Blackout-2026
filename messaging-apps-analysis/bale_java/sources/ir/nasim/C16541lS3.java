package ir.nasim;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketItemMore;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;

/* renamed from: ir.nasim.lS3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C16541lS3 extends AbstractC16640ld0 implements C23731xQ3.b, C23731xQ3.c, C12950fS3.b {
    public static final a D = new a(null);
    public static final int G = 8;
    private final UA2 A;
    private final UA2 B;
    private final C5644Kf3 v;
    private final InterfaceC14159hS3 w;
    private final InterfaceC14770iS3 x;
    private final InterfaceC13568gS3 y;
    private final C12950fS3.b z;

    /* renamed from: ir.nasim.lS3$a */
    public static final class a {
        private a() {
        }

        private final void b(C5644Kf3 c5644Kf3) {
            c5644Kf3.d.setTypeface(C6011Lu2.i());
            c5644Kf3.c.setTypeface(C6011Lu2.k());
        }

        public final C16541lS3 a(ViewGroup viewGroup, InterfaceC14159hS3 interfaceC14159hS3, InterfaceC14770iS3 interfaceC14770iS3, InterfaceC13568gS3 interfaceC13568gS3, C12950fS3.b bVar, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(bVar, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C5644Kf3 c5644Kf3C = C5644Kf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c5644Kf3C, "inflate(...)");
            b(c5644Kf3C);
            return new C16541lS3(c5644Kf3C, interfaceC14159hS3, interfaceC14770iS3, interfaceC13568gS3, bVar, ua2, ua22, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ C16541lS3(C5644Kf3 c5644Kf3, InterfaceC14159hS3 interfaceC14159hS3, InterfaceC14770iS3 interfaceC14770iS3, InterfaceC13568gS3 interfaceC13568gS3, C12950fS3.b bVar, UA2 ua2, UA2 ua22, ED1 ed1) {
        this(c5644Kf3, interfaceC14159hS3, interfaceC14770iS3, interfaceC13568gS3, bVar, ua2, ua22);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(C16541lS3 c16541lS3, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(c16541lS3, "this$0");
        AbstractC13042fc3.i(marketSection, "$item");
        InterfaceC13568gS3 interfaceC13568gS3 = c16541lS3.y;
        if (interfaceC13568gS3 != null) {
            interfaceC13568gS3.a3(marketSection);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void J0(final ir.nasim.core.modules.market.model.MarketSection r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C16541lS3.J0(ir.nasim.core.modules.market.model.MarketSection, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L0(C16541lS3 c16541lS3, C23731xQ3 c23731xQ3, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(c16541lS3, "this$0");
        AbstractC13042fc3.i(c23731xQ3, "$adapter");
        AbstractC13042fc3.i(marketSection, "$item");
        Object obj = c23731xQ3.z().get(c23731xQ3.z().size() - 1);
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItemMore");
        c16541lS3.x((MarketItemMore) obj, marketSection);
        C21946uP3 c21946uP3 = new C21946uP3(10, null, null, null, null, Integer.valueOf(marketSection.getId()), null, null, null, null, null, null, null, null, null, 32734, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    private final void M0(MarketSection marketSection) {
        Drawable drawableF = AbstractC4043Dl1.f(C0(), marketSection.getDrawableIdResource());
        if (drawableF == null) {
            this.v.e.setImageDrawable(null);
            return;
        }
        if (marketSection.shoudApplyTintOnDrawable()) {
            AbstractC21710u02.h(drawableF, C5495Jo7.a.g0());
        }
        this.v.e.setImageDrawable(drawableF);
    }

    @Override // ir.nasim.C23731xQ3.b
    public void C(MarketItem marketItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        InterfaceC14159hS3 interfaceC14159hS3 = this.w;
        if (interfaceC14159hS3 != null) {
            interfaceC14159hS3.C(marketItem, marketSection);
        }
    }

    public final void F0(final MarketSection marketSection, boolean z) {
        AbstractC13042fc3.i(marketSection, "item");
        try {
            this.v.d.setText(XY6.e(marketSection.getTitle()));
            M0(marketSection);
            if (marketSection.getDialog() == null) {
                this.v.f.setVisibility(8);
            } else {
                this.v.f.setVisibility(0);
                this.v.f.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.kS3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C16541lS3.H0(this.a, marketSection, view);
                    }
                });
            }
            J0(marketSection, z);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    @Override // ir.nasim.C23731xQ3.b
    public void k(MarketProductItem marketProductItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketProductItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        InterfaceC14159hS3 interfaceC14159hS3 = this.w;
        if (interfaceC14159hS3 != null) {
            interfaceC14159hS3.k(marketProductItem, marketSection);
        }
    }

    @Override // ir.nasim.C23731xQ3.c
    public void x(MarketItemMore marketItemMore, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItemMore, "item");
        AbstractC13042fc3.i(marketSection, "row");
        InterfaceC14770iS3 interfaceC14770iS3 = this.x;
        if (interfaceC14770iS3 != null) {
            interfaceC14770iS3.x(marketItemMore, marketSection);
        }
    }

    @Override // ir.nasim.C12950fS3.b
    public void x2(Object obj) {
        AbstractC13042fc3.i(obj, "item");
        this.z.x2(obj);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private C16541lS3(C5644Kf3 c5644Kf3, InterfaceC14159hS3 interfaceC14159hS3, InterfaceC14770iS3 interfaceC14770iS3, InterfaceC13568gS3 interfaceC13568gS3, C12950fS3.b bVar, UA2 ua2, UA2 ua22) {
        ConstraintLayout root = c5644Kf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c5644Kf3;
        this.w = interfaceC14159hS3;
        this.x = interfaceC14770iS3;
        this.y = interfaceC13568gS3;
        this.z = bVar;
        this.A = ua2;
        this.B = ua22;
    }
}
