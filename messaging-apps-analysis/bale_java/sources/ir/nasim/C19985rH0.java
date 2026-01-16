package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.rH0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19985rH0 extends RecyclerView.h {
    private final List d;

    public C19985rH0(List list) {
        AbstractC13042fc3.i(list, "list");
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public BH0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.card_statement_result_item_layout, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new BH0(viewInflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(BH0 bh0, int i) {
        AbstractC13042fc3.i(bh0, "holder");
        bh0.C0((C19014pe0) this.d.get(i));
    }
}
