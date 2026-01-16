package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.vQ3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C22545vQ3 extends RecyclerView.h {
    private ArrayList d = new ArrayList();

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C23141wQ3 c23141wQ3, int i) {
        AbstractC13042fc3.i(c23141wQ3, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c23141wQ3.D0(((Boolean) obj).booleanValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C23141wQ3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C23141wQ3.w.a(viewGroup);
    }

    public final void C(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.d = arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    public final ArrayList z() {
        return this.d;
    }
}
