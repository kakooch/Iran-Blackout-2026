package ir.nasim;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.market.model.SearchSuggestion;

/* renamed from: ir.nasim.Li5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C5907Li5 extends RecyclerView.C {
    private final C25087zi5 u;
    private final UA2 v;
    private SearchSuggestion w;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C5907Li5(C25087zi5 c25087zi5, UA2 ua2) {
        super(c25087zi5.getRoot());
        AbstractC13042fc3.i(c25087zi5, "binding");
        AbstractC13042fc3.i(ua2, "onClick");
        this.u = c25087zi5;
        this.v = ua2;
        c25087zi5.b.setTypeface(C6011Lu2.k());
        c25087zi5.d.setTypeface(C6011Lu2.k());
        c25087zi5.c.setOnClickListener(new View.OnClickListener() { // from class: ir.nasim.Ki5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                C5907Li5.D0(this.a, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D0(C5907Li5 c5907Li5, View view) {
        AbstractC13042fc3.i(c5907Li5, "this$0");
        SearchSuggestion searchSuggestion = c5907Li5.w;
        if (searchSuggestion != null) {
            c5907Li5.v.invoke(searchSuggestion);
        }
    }

    public final void E0(SearchSuggestion searchSuggestion, boolean z) {
        AbstractC13042fc3.i(searchSuggestion, "title");
        String displayName = searchSuggestion.getDisplayName();
        if (displayName == null || displayName.length() == 0) {
            TextView textView = this.u.b;
            String term = searchSuggestion.getTerm();
            if (term == null) {
                term = "";
            }
            textView.setText(term);
        } else {
            this.u.b.setText(searchSuggestion.getDisplayName());
        }
        this.w = searchSuggestion;
        if (z) {
            this.u.d.setVisibility(0);
        } else {
            this.u.d.setVisibility(8);
        }
    }
}
