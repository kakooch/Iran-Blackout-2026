package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes4.dex */
public final class IG5 extends RecyclerView.h {
    private final List d;
    private final RJ4 e;

    public IG5(List list, RJ4 rj4) {
        AbstractC13042fc3.i(list, "reactions");
        AbstractC13042fc3.i(rj4, "onReactionClickListener");
        this.d = list;
        this.e = rj4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C11601dH5 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C11601dH5.w.a(viewGroup, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C11601dH5 c11601dH5) {
        AbstractC13042fc3.i(c11601dH5, "holder");
        super.onViewRecycled(c11601dH5);
        c11601dH5.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C11601dH5 c11601dH5, int i) {
        AbstractC13042fc3.i(c11601dH5, "holder");
        c11601dH5.D0((C13471gH5) this.d.get(i));
    }
}
