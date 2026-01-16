package ir.nasim;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C12923fP3;
import ir.nasim.core.modules.market.model.MarketCategory;
import ir.nasim.core.modules.market.model.SearchSuggestion;

/* renamed from: ir.nasim.tP3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C21289tP3 extends RecyclerView.C {
    public static final a w = new a(null);
    public static final int x = 8;
    private final C23281wf3 u;
    private C12923fP3.a v;

    /* renamed from: ir.nasim.tP3$a */
    public static final class a {
        private a() {
        }

        private final void b(C23281wf3 c23281wf3) {
            c23281wf3.d.setTypeface(C6011Lu2.i());
        }

        public final C21289tP3 a(ViewGroup viewGroup, C12923fP3.a aVar) {
            AbstractC13042fc3.i(viewGroup, "parent");
            C23281wf3 c23281wf3C = C23281wf3.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c23281wf3C, "inflate(...)");
            b(c23281wf3C);
            return new C21289tP3(c23281wf3C, aVar);
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21289tP3(C23281wf3 c23281wf3, C12923fP3.a aVar) {
        super(c23281wf3.getRoot());
        AbstractC13042fc3.i(c23281wf3, "binding");
        this.u = c23281wf3;
        this.v = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E0(MarketCategory marketCategory, C21289tP3 c21289tP3, View view) {
        AbstractC13042fc3.i(marketCategory, "$category");
        AbstractC13042fc3.i(c21289tP3, "this$0");
        marketCategory.setSelected(!marketCategory.isSelected());
        c21289tP3.H0(marketCategory.isSelected(), marketCategory);
        C12923fP3.a aVar = c21289tP3.v;
        if (aVar != null) {
            aVar.J2(marketCategory);
        }
    }

    private final void F0(MarketCategory marketCategory) {
        this.u.b.setStrokeWidth(AbstractC7426Rr.a.f(2.0f));
        if (marketCategory.getDrawableId() != null) {
            Context context = this.a.getContext();
            Integer drawableId = marketCategory.getDrawableId();
            AbstractC13042fc3.f(drawableId);
            Drawable drawableF = AbstractC4043Dl1.f(context, drawableId.intValue());
            int iC = AbstractC4043Dl1.c(this.a.getContext(), TA5.secondary_2);
            if (drawableF != null) {
                AbstractC21710u02.h(drawableF, iC);
            }
            this.u.c.setImageDrawable(drawableF);
        }
        this.u.d.setTextColor(AbstractC4043Dl1.c(this.a.getContext(), TA5.secondary_2));
    }

    private final void H0(boolean z, MarketCategory marketCategory) {
        if (z) {
            F0(marketCategory);
        } else {
            J0(marketCategory);
        }
    }

    private final void J0(MarketCategory marketCategory) {
        this.u.b.setStrokeWidth(0);
        if (marketCategory.getDrawableId() != null) {
            Context context = this.a.getContext();
            Integer drawableId = marketCategory.getDrawableId();
            AbstractC13042fc3.f(drawableId);
            Drawable drawableF = AbstractC4043Dl1.f(context, drawableId.intValue());
            int iC = AbstractC4043Dl1.c(this.a.getContext(), TA5.color8);
            if (drawableF != null) {
                AbstractC21710u02.h(drawableF, iC);
            }
            this.u.c.setImageDrawable(drawableF);
        }
        this.u.d.setTextColor(AbstractC4043Dl1.c(this.a.getContext(), TA5.color8));
    }

    public final void D0(final MarketCategory marketCategory) {
        AbstractC13042fc3.i(marketCategory, SearchSuggestion.CATEGORY_ICON);
        if (marketCategory.getDrawableId() != null) {
            ImageView imageView = this.u.c;
            Context context = this.a.getContext();
            Integer drawableId = marketCategory.getDrawableId();
            AbstractC13042fc3.f(drawableId);
            imageView.setImageDrawable(AbstractC4043Dl1.f(context, drawableId.intValue()));
            this.u.c.setVisibility(0);
        } else {
            this.u.c.setImageDrawable(null);
            this.u.c.setVisibility(8);
        }
        H0(marketCategory.isSelected(), marketCategory);
        this.u.d.setText(marketCategory.getTitle());
        this.u.b.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.sP3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C21289tP3.E0(marketCategory, this, view);
            }
        });
    }
}
