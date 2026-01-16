package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.response.Bank;
import java.util.List;

/* loaded from: classes6.dex */
public final class P50 extends RecyclerView.h {
    private List d;

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public Q50 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return Q50.u.a(viewGroup);
    }

    public final void B(List list) {
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        List list = this.d;
        if (list == null) {
            return 0;
        }
        AbstractC13042fc3.f(list);
        return list.size() * 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(Q50 q50, int i) {
        AbstractC13042fc3.i(q50, "holder");
        List list = this.d;
        if (list != null) {
            AbstractC13042fc3.f(list);
            Bank bank = (Bank) list.get(i % list.size());
            if (bank != null) {
                q50.C0(bank);
            }
        }
    }
}
