package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.jaryan.discover.model.BannerItem;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class G80 extends RecyclerView.h {
    private final InterfaceC24154y80 d;
    private final UA2 e;
    private final UA2 f;
    private final List g;
    private int h;

    public G80(InterfaceC24154y80 interfaceC24154y80, UA2 ua2, UA2 ua22) {
        AbstractC13042fc3.i(interfaceC24154y80, "bannerClickListener");
        AbstractC13042fc3.i(ua2, "bindItem");
        AbstractC13042fc3.i(ua22, "unbindItem");
        this.d = interfaceC24154y80;
        this.e = ua2;
        this.f = ua22;
        this.g = new ArrayList();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public E80 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return E80.B.a(viewGroup, this.d, this.e, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(E80 e80) {
        AbstractC13042fc3.i(e80, "holder");
        super.onViewRecycled(e80);
        e80.a();
    }

    public final void C(List list, int i) {
        AbstractC13042fc3.i(list, "bannerItems");
        this.h = i;
        this.g.clear();
        this.g.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(E80 e80, int i) {
        AbstractC13042fc3.i(e80, "holder");
        e80.E0((BannerItem) this.g.get(i), this.h);
    }
}
