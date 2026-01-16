package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.Ff6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4462Ff6 extends RecyclerView.h {
    private final UA2 d;
    private List e;

    public C4462Ff6(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "onItemClick");
        this.d = ua2;
        this.e = AbstractC10360bX0.m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C5413Jf6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C4945Hf6 c4945Hf6C = C4945Hf6.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c4945Hf6C, "inflate(...)");
        c4945Hf6C.c.setTypeface(C6011Lu2.k());
        return C5413Jf6.x.a(c4945Hf6C, this.d);
    }

    public final void B(List list) {
        AbstractC13042fc3.i(list, "items");
        this.e = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C5413Jf6 c5413Jf6, int i) {
        AbstractC13042fc3.i(c5413Jf6, "holder");
        c5413Jf6.E0((C4711Gf6) this.e.get(i), i);
    }
}
