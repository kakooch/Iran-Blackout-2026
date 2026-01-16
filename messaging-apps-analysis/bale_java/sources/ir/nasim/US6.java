package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes7.dex */
public final class US6 extends RecyclerView.h {
    private List d;
    private List e;
    private final InterfaceC14603iB2 f;

    public US6(List list, List list2, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(list, "list");
        AbstractC13042fc3.i(list2, "exceptionUserIdsList");
        AbstractC13042fc3.i(interfaceC14603iB2, "itemClick");
        this.d = list;
        this.e = list2;
        this.f = interfaceC14603iB2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public HS6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.view_holder_story_privacy_contact, viewGroup, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return new HS6(viewInflate, null, 2, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(HS6 hs6) {
        AbstractC13042fc3.i(hs6, "holder");
        super.onViewAttachedToWindow(hs6);
        hs6.Q0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(HS6 hs6) {
        AbstractC13042fc3.i(hs6, "holder");
        super.onViewDetachedFromWindow(hs6);
        hs6.S0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(HS6 hs6) {
        AbstractC13042fc3.i(hs6, "holder");
        super.onViewRecycled(hs6);
        hs6.a();
    }

    public final void E(List list) {
        AbstractC13042fc3.i(list, "exceptionUserIdsList");
        this.e = list;
    }

    public final void F(List list) {
        AbstractC13042fc3.i(list, "list");
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(HS6 hs6, int i) {
        AbstractC13042fc3.i(hs6, "holder");
        hs6.J0(new C4818Gr5(this.e.contains(Integer.valueOf(((C3512Be1) this.d.get(i)).r())), (C3512Be1) this.d.get(i)), this.f);
    }
}
