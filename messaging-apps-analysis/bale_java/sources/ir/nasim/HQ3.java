package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.market.model.MarketMenuItem;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class HQ3 extends RecyclerView.h {
    private a d;
    private ArrayList e = new ArrayList();

    public interface a {
        void s0(MarketMenuItem marketMenuItem);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public JQ3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return JQ3.x.a(viewGroup, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(JQ3 jq3, int i) {
        AbstractC13042fc3.i(jq3, "holder");
        Object obj = this.e.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        jq3.E0((MarketMenuItem) obj);
    }
}
