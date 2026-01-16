package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.q43, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C19274q43 extends RecyclerView.h {
    private ArrayList d = new ArrayList();
    private a e;

    /* renamed from: ir.nasim.q43$a */
    public interface a {
        void y0(C18683p43 c18683p43);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C21077t43 c21077t43, int i) {
        AbstractC13042fc3.i(c21077t43, "holder");
        if (getItemViewType(i) == 0) {
            Object obj = this.d.get(i);
            AbstractC13042fc3.h(obj, "get(...)");
            c21077t43.J0((C18683p43) obj);
        } else {
            Object obj2 = this.d.get(i);
            AbstractC13042fc3.h(obj2, "get(...)");
            c21077t43.F0((C18683p43) obj2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C21077t43 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i == 0 ? C21077t43.x.b(viewGroup, this.e) : C21077t43.x.a(viewGroup, this.e);
    }

    public final void C(a aVar) {
        this.e = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return ((C18683p43) this.d.get(i)).c();
    }

    public final ArrayList z() {
        return this.d;
    }
}
