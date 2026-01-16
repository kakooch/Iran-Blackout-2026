package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import java.util.List;

/* renamed from: ir.nasim.yi5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C24493yi5 extends RecyclerView.h {
    private final UA2 d;
    private List e;

    public C24493yi5(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onCLick");
        this.d = ua2;
        this.e = AbstractC10360bX0.m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C5907Li5 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C25087zi5 c25087zi5C = C25087zi5.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c25087zi5C, "inflate(...)");
        return new C5907Li5(c25087zi5C, this.d);
    }

    public final void B(List list) {
        AbstractC13042fc3.i(list, "value");
        this.e = list;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C5907Li5 c5907Li5, int i) {
        AbstractC13042fc3.i(c5907Li5, "holder");
        c5907Li5.E0((SearchSuggestion) this.e.get(i), i == 0);
    }
}
