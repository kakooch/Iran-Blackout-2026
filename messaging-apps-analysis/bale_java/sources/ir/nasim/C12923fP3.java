package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.market.model.MarketCategory;
import java.util.ArrayList;

/* renamed from: ir.nasim.fP3, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C12923fP3 extends RecyclerView.h {
    private final ArrayList d = new ArrayList();
    private a e;

    /* renamed from: ir.nasim.fP3$a */
    public interface a {
        void J2(MarketCategory marketCategory);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C21289tP3 c21289tP3, int i) {
        AbstractC13042fc3.i(c21289tP3, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c21289tP3.D0((MarketCategory) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C21289tP3 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C21289tP3.w.a(viewGroup, this.e);
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
