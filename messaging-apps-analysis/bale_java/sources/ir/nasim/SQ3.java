package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import ir.nasim.C23731xQ3;
import ir.nasim.core.modules.market.model.MarketItemMore;
import ir.nasim.core.modules.market.model.MarketSection;

/* loaded from: classes2.dex */
public final class SQ3 extends AbstractC16640ld0 {
    public static final a x = new a(null);
    public static final int y = 8;
    private final C3523Bf3 v;
    private final C23731xQ3.c w;

    public static final class a {
        private a() {
        }

        private final void b(C3523Bf3 c3523Bf3) {
            c3523Bf3.d.setTypeface(C6011Lu2.k());
            if (C5495Jo7.a.J2()) {
                c3523Bf3.b.setElevation(0.0f);
            }
        }

        public final SQ3 a(ViewGroup viewGroup, C23731xQ3.c cVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C3523Bf3 c3523Bf3C = C3523Bf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c3523Bf3C, "inflate(...)");
            b(c3523Bf3C);
            return new SQ3(c3523Bf3C, cVar, null);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public /* synthetic */ SQ3(C3523Bf3 c3523Bf3, C23731xQ3.c cVar, ED1 ed1) {
        this(c3523Bf3, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F0(SQ3 sq3, MarketItemMore marketItemMore, MarketSection marketSection, View view) {
        AbstractC13042fc3.i(sq3, "this$0");
        AbstractC13042fc3.i(marketItemMore, "$item");
        AbstractC13042fc3.i(marketSection, "$row");
        C23731xQ3.c cVar = sq3.w;
        if (cVar != null) {
            cVar.x(marketItemMore, marketSection);
        }
        C21946uP3 c21946uP3 = new C21946uP3(11, null, null, null, null, Integer.valueOf(marketSection.getId()), null, null, null, null, null, null, null, null, null, 32734, null);
        C3343Am.i("market_page", c21946uP3.a());
        C3343Am.j("market_page", c21946uP3.b());
    }

    public final void E0(final MarketItemMore marketItemMore, final MarketSection marketSection) {
        AbstractC13042fc3.i(marketItemMore, "item");
        AbstractC13042fc3.i(marketSection, "row");
        this.v.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.RQ3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SQ3.F0(this.a, marketItemMore, marketSection, view);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    private SQ3(C3523Bf3 c3523Bf3, C23731xQ3.c cVar) {
        ConstraintLayout root = c3523Bf3.getRoot();
        AbstractC13042fc3.h(root, "getRoot(...)");
        super(root);
        this.v = c3523Bf3;
        this.w = cVar;
    }
}
