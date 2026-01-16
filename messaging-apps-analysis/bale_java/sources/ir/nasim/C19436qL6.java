package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.model.StatementItem;
import java.util.ArrayList;

/* renamed from: ir.nasim.qL6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19436qL6 extends RecyclerView.h {
    private ArrayList d = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public NL6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return NL6.u.a(viewGroup);
    }

    public final void B(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(NL6 nl6, int i) {
        AbstractC13042fc3.i(nl6, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        nl6.C0((StatementItem) obj);
    }
}
