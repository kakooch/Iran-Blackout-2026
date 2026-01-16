package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.jA2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C15196jA2 extends RecyclerView.h {
    private final ArrayList d = new ArrayList();
    private a e;

    /* renamed from: ir.nasim.jA2$a */
    public interface a {
        void s5(C16969mA2 c16969mA2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C16378lA2 c16378lA2, int i) {
        AbstractC13042fc3.i(c16378lA2, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c16378lA2.E0((C16969mA2) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C16378lA2 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C16378lA2.A.a(viewGroup, this.e);
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
