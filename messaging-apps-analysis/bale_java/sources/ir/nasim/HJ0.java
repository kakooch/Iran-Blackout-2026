package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class HJ0 extends RecyclerView.h {
    private final String d;
    private final boolean e;
    private final UA2 f;
    private List g;
    private C20644sM5 h;

    public HJ0(String str, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(ua2, "onClick");
        this.d = str;
        this.e = z;
        this.f = ua2;
        this.g = new ArrayList();
        this.h = new C20644sM5("");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(O25 o25, int i) {
        AbstractC13042fc3.i(o25, "holder");
        C12692f25 c12692f25 = (C12692f25) this.g.get(i);
        boolean z = false;
        boolean z2 = i == AbstractC10360bX0.o(this.g);
        if (this.d.length() > 0 && i == 0) {
            z = true;
        }
        o25.L0(c12692f25, z2, z, this.h);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public O25 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        BJ0 bj0C = BJ0.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        bj0C.e.setTypeface(C6011Lu2.k());
        bj0C.f.setTypeface(C6011Lu2.k());
        bj0C.g.setTypeface(C6011Lu2.k());
        bj0C.d.setTypeface(C6011Lu2.i());
        bj0C.h.setTypeface(C6011Lu2.k());
        AbstractC13042fc3.h(bj0C, "apply(...)");
        return new O25(bj0C, this.f, this.d, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(O25 o25) {
        AbstractC13042fc3.i(o25, "holder");
        super.onViewRecycled(o25);
        o25.a();
    }

    public final void D(List list, C20644sM5 c20644sM5) {
        AbstractC13042fc3.i(list, "data");
        AbstractC13042fc3.i(c20644sM5, "matcher");
        this.g = list;
        this.h = c20644sM5;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.g.size();
    }

    public final List z() {
        return this.g;
    }
}
