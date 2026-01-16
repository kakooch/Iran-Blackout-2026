package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.payment.data.model.SelectableOption;
import java.util.ArrayList;

/* renamed from: ir.nasim.Wm6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8563Wm6 extends RecyclerView.h {
    private ArrayList d = new ArrayList();
    private a e;

    /* renamed from: ir.nasim.Wm6$a */
    public interface a {
        void a(SelectableOption selectableOption);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C9104Ym6 c9104Ym6, int i) {
        AbstractC13042fc3.i(c9104Ym6, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c9104Ym6.D0((SelectableOption) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C9104Ym6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C9104Ym6.w.a(viewGroup, this.e);
    }

    public final void C(a aVar) {
        this.e = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    public final ArrayList z() {
        return this.d;
    }
}
