package ir.nasim;

import android.view.ViewGroup;

/* loaded from: classes7.dex */
public final class HG5 extends androidx.recyclerview.widget.q {
    private final UA2 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HG5(UA2 ua2) {
        super(new C14062hH5());
        AbstractC13042fc3.i(ua2, "onItemClick");
        this.f = ua2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C12244eH5 c12244eH5, int i) {
        AbstractC13042fc3.i(c12244eH5, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        c12244eH5.D0((C12853fH5) objA);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C12244eH5 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C12244eH5.w.a(viewGroup, this.f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C12244eH5 c12244eH5) {
        AbstractC13042fc3.i(c12244eH5, "holder");
        c12244eH5.a();
        super.onViewRecycled(c12244eH5);
    }
}
