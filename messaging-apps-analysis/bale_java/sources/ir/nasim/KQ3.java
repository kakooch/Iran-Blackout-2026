package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.HQ3;
import ir.nasim.core.modules.market.model.MarketMenu;
import ir.nasim.core.modules.market.model.MarketMenuItem;

/* loaded from: classes2.dex */
public final class KQ3 extends RecyclerView.C implements HQ3.a {
    public static final a x = new a(null);
    public static final int y = 8;
    private final C5878Lf3 u;
    private final HQ3.a v;
    private final HQ3 w;

    public static final class a {
        private a() {
        }

        private final void b(C5878Lf3 c5878Lf3) {
            c5878Lf3.b.setTypeface(C6011Lu2.i());
        }

        public final KQ3 a(ViewGroup viewGroup, HQ3.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C5878Lf3 c5878Lf3C = C5878Lf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c5878Lf3C, "inflate(...)");
            b(c5878Lf3C);
            return new KQ3(c5878Lf3C, aVar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KQ3(C5878Lf3 c5878Lf3, HQ3.a aVar) {
        super(c5878Lf3.getRoot());
        AbstractC13042fc3.i(c5878Lf3, "binding");
        this.u = c5878Lf3;
        this.v = aVar;
        this.w = new HQ3();
    }

    public final void C0(MarketMenu marketMenu) {
        AbstractC13042fc3.i(marketMenu, "marketMenu");
    }

    @Override // ir.nasim.HQ3.a
    public void s0(MarketMenuItem marketMenuItem) {
        AbstractC13042fc3.i(marketMenuItem, "item");
        HQ3.a aVar = this.v;
        if (aVar != null) {
            aVar.s0(marketMenuItem);
        }
    }
}
