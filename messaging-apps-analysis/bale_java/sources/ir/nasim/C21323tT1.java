package ir.nasim;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.tT1, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21323tT1 extends AbstractC20423rz2 {
    private List l;
    private GN1 m;
    private RecyclerView.t n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C21323tT1(Fragment fragment, List list, GN1 gn1, RecyclerView.t tVar) {
        super(fragment);
        AbstractC13042fc3.i(fragment, "fragment");
        AbstractC13042fc3.i(list, "dialogTabTypes");
        this.l = list;
        this.m = gn1;
        this.n = tVar;
    }

    @Override // ir.nasim.AbstractC20423rz2
    public Fragment B(int i) {
        return ((CP1) this.l.get(i)).a(this.m, this.n);
    }

    public final void T() {
        this.m = null;
        this.n = null;
        this.l.clear();
    }

    public final void U(List list) {
        AbstractC13042fc3.i(list, "newList");
        this.l.clear();
        this.l.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.l.size();
    }
}
