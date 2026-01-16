package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC13460gG3;

/* renamed from: ir.nasim.hG3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC14051hG3 extends RecyclerView.h {
    private AbstractC13460gG3 d = new AbstractC13460gG3.c(false);

    public int A(AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        return 0;
    }

    public abstract void B(RecyclerView.C c, AbstractC13460gG3 abstractC13460gG3);

    public abstract RecyclerView.C C(ViewGroup viewGroup, AbstractC13460gG3 abstractC13460gG3);

    public final void D(AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        if (AbstractC13042fc3.d(this.d, abstractC13460gG3)) {
            return;
        }
        boolean z = z(this.d);
        boolean z2 = z(abstractC13460gG3);
        if (z && !z2) {
            notifyItemRemoved(0);
        } else if (z2 && !z) {
            notifyItemInserted(0);
        } else if (z && z2) {
            notifyItemChanged(0);
        }
        this.d = abstractC13460gG3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final int getItemCount() {
        return z(this.d) ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final int getItemViewType(int i) {
        return A(this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final void onBindViewHolder(RecyclerView.C c, int i) {
        AbstractC13042fc3.i(c, "holder");
        B(c, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public final RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C(viewGroup, this.d);
    }

    public boolean z(AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        return (abstractC13460gG3 instanceof AbstractC13460gG3.b) || (abstractC13460gG3 instanceof AbstractC13460gG3.a);
    }
}
