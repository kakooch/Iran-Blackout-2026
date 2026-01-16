package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.kl1, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16130kl1 extends RecyclerView.h {
    private final String d;
    private final UA2 e;
    private C20644sM5 f;
    private List g;

    public C16130kl1(String str, UA2 ua2) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(ua2, "onClick");
        this.d = str;
        this.e = ua2;
        this.f = new C20644sM5("");
        this.g = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C23929xl1 c23929xl1, int i) {
        AbstractC13042fc3.i(c23929xl1, "holder");
        c23929xl1.J0((InterfaceC14341hl1) this.g.get(i), this.d.length() > 0 && i == 0, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C23929xl1 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C23929xl1.A.b(viewGroup, this.e, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C23929xl1 c23929xl1) {
        AbstractC13042fc3.i(c23929xl1, "holder");
        super.onViewRecycled(c23929xl1);
        c23929xl1.P0();
    }

    public final void D(List list, C20644sM5 c20644sM5) {
        AbstractC13042fc3.i(list, "data");
        AbstractC13042fc3.i(c20644sM5, "matcher");
        this.g = list;
        this.f = c20644sM5;
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
