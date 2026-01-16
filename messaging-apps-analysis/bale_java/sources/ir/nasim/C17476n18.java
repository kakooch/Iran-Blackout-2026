package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.n18, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17476n18 extends RecyclerView.h {
    private final int d;
    private final UA2 e;
    private final List f;

    public /* synthetic */ C17476n18(int i, UA2 ua2, int i2, ED1 ed1) {
        this((i2 & 1) != 0 ? 48 : i, (i2 & 2) != 0 ? null : ua2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public C19840r18 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(TC5.reaction_view_item, viewGroup, false);
        ((ImageView) viewInflate.findViewById(AbstractC19354qC5.image)).setImportantForAccessibility(2);
        AbstractC13042fc3.f(viewInflate);
        return new C19840r18(viewInflate, this.d, this.e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void onViewRecycled(C19840r18 c19840r18) {
        AbstractC13042fc3.i(c19840r18, "holder");
        c19840r18.a();
        super.onViewRecycled(c19840r18);
    }

    public final void C(List list) {
        AbstractC13042fc3.i(list, "newList");
        this.f.clear();
        this.f.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C19840r18 c19840r18, int i) {
        AbstractC13042fc3.i(c19840r18, "holder");
        View view = c19840r18.a;
        view.setImportantForAccessibility(2);
        view.setFocusable(false);
        c19840r18.F0((C20610sI7) this.f.get(i));
    }

    public C17476n18(int i, UA2 ua2) {
        this.d = i;
        this.e = ua2;
        this.f = new ArrayList();
    }
}
