package ir.nasim;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12950fS3;
import ir.nasim.C23731xQ3;
import ir.nasim.core.modules.market.model.MarketItem;
import ir.nasim.core.modules.market.model.MarketItemMore;
import ir.nasim.core.modules.market.model.MarketProductItem;
import ir.nasim.core.modules.market.model.MarketSection;

/* renamed from: ir.nasim.dS3, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C11698dS3 extends RecyclerView.C implements C23731xQ3.b, C23731xQ3.c, C12950fS3.b {
    public static final a D = new a(null);
    public static final int G = 8;
    private final UA2 A;
    private C23731xQ3 B;
    private final C12341eS3 u;
    private final InterfaceC13568gS3 v;
    private final InterfaceC14159hS3 w;
    private final InterfaceC14770iS3 x;
    private final C12950fS3.b y;
    private final UA2 z;

    /* renamed from: ir.nasim.dS3$a */
    public static final class a {
        private a() {
        }

        public final C11698dS3 a(ViewGroup viewGroup, InterfaceC13568gS3 interfaceC13568gS3, InterfaceC14159hS3 interfaceC14159hS3, InterfaceC14770iS3 interfaceC14770iS3, C12950fS3.b bVar, UA2 ua2, UA2 ua22) {
            AbstractC13042fc3.i(viewGroup, "parent");
            AbstractC13042fc3.i(interfaceC13568gS3, "hintClickListener");
            AbstractC13042fc3.i(interfaceC14159hS3, "onItemClickListener");
            AbstractC13042fc3.i(interfaceC14770iS3, "moreItemClickListener");
            AbstractC13042fc3.i(bVar, "onLongItemClick");
            AbstractC13042fc3.i(ua2, "bindItem");
            AbstractC13042fc3.i(ua22, "unbindItem");
            C12341eS3 c12341eS3C = C12341eS3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c12341eS3C, "inflate(...)");
            return new C11698dS3(c12341eS3C, interfaceC13568gS3, interfaceC14159hS3, interfaceC14770iS3, bVar, ua2, ua22);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11698dS3(C12341eS3 c12341eS3, InterfaceC13568gS3 interfaceC13568gS3, InterfaceC14159hS3 interfaceC14159hS3, InterfaceC14770iS3 interfaceC14770iS3, C12950fS3.b bVar, UA2 ua2, UA2 ua22) {
        super(c12341eS3.getRoot());
        AbstractC13042fc3.i(c12341eS3, "binding");
        AbstractC13042fc3.i(interfaceC13568gS3, "hintClickListener");
        AbstractC13042fc3.i(interfaceC14159hS3, "onItemClickListener");
        AbstractC13042fc3.i(interfaceC14770iS3, "moreItemClickListener");
        AbstractC13042fc3.i(bVar, "onLongItemClick");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.u = c12341eS3;
        this.v = interfaceC13568gS3;
        this.w = interfaceC14159hS3;
        this.x = interfaceC14770iS3;
        this.y = bVar;
        this.z = ua2;
        this.A = ua22;
        c12341eS3.d.setTypeface(C6011Lu2.i());
        c12341eS3.c.setTypeface(C6011Lu2.k());
        c12341eS3.b.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(C11698dS3 c11698dS3, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(c11698dS3, "this$0");
        AbstractC13042fc3.i(marketSection, "$marketSection");
        c11698dS3.v.a3(marketSection);
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void H0(final ir.nasim.core.modules.market.model.MarketSection r12) {
        /*
            Method dump skipped, instructions count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ir.nasim.C11698dS3.H0(ir.nasim.core.modules.market.model.MarketSection):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J0(C11698dS3 c11698dS3, C23731xQ3 c23731xQ3, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(c11698dS3, "this$0");
        AbstractC13042fc3.i(c23731xQ3, "$adapter");
        AbstractC13042fc3.i(marketSection, "$item");
        Object obj = c23731xQ3.z().get(c23731xQ3.z().size() - 1);
        AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.MarketItemMore");
        c11698dS3.x((MarketItemMore) obj, marketSection);
        C21946uP3 c21946uP3 = new C21946uP3(10, null, null, null, null, Integer.valueOf(marketSection.getId()), null, null, null, null, null, null, null, null, null, 32734, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    private final void L0(MarketSection marketSection) {
        Drawable drawableF = AbstractC4043Dl1.f(this.a.getContext(), marketSection.getDrawableIdResource());
        if (drawableF == null || !marketSection.shoudApplyTintOnDrawable()) {
            return;
        }
        AbstractC21710u02.h(drawableF, C5495Jo7.a.g0());
    }

    @Override // ir.nasim.C23731xQ3.b
    public void C(MarketItem marketItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        this.w.C(marketItem, marketSection);
    }

    public final void E0(final MarketSection marketSection) {
        AbstractC13042fc3.i(marketSection, "marketSection");
        try {
            this.u.d.setText(XY6.e(marketSection.getTitle()));
            L0(marketSection);
            if (marketSection.getDialog() == null) {
                this.u.e.setVisibility(8);
            } else {
                this.u.e.setVisibility(0);
                this.u.e.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.bS3
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        C11698dS3.F0(this.a, marketSection, view);
                    }
                });
            }
            H0(marketSection);
        } catch (Exception e) {
            C19406qI3.d("NON_FATAL_EXCEPTION", e);
        }
    }

    public final void a() {
        this.B = null;
        this.u.b.setAdapter(null);
    }

    @Override // ir.nasim.C23731xQ3.b
    public void k(MarketProductItem marketProductItem, MarketSection marketSection) {
        AbstractC13042fc3.i(marketProductItem, "item");
        AbstractC13042fc3.i(marketSection, "row");
        this.w.k(marketProductItem, marketSection);
    }

    @Override // ir.nasim.C23731xQ3.c
    public void x(MarketItemMore marketItemMore, MarketSection marketSection) {
        AbstractC13042fc3.i(marketItemMore, "item");
        AbstractC13042fc3.i(marketSection, "row");
        this.x.x(marketItemMore, marketSection);
    }

    @Override // ir.nasim.C12950fS3.b
    public void x2(Object obj) {
        AbstractC13042fc3.i(obj, "item");
        this.y.x2(obj);
    }
}
