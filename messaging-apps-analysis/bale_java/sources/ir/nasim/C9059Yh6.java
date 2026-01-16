package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.core.modules.market.model.SearchSuggestion;
import java.util.ArrayList;

/* renamed from: ir.nasim.Yh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9059Yh6 extends RecyclerView.h {
    private final ArrayList d = new ArrayList();
    private a e;
    private b f;

    /* renamed from: ir.nasim.Yh6$a */
    public interface a {
        void k5(SearchSuggestion searchSuggestion);
    }

    /* renamed from: ir.nasim.Yh6$b */
    public interface b {
        void i1(SearchSuggestion searchSuggestion);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C12496ei6 c12496ei6, int i) {
        AbstractC13042fc3.i(c12496ei6, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c12496ei6.F0((SearchSuggestion) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C12496ei6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C12496ei6.y.a(viewGroup, this.e, this.f);
    }

    public final void C(b bVar) {
        this.f = bVar;
    }

    public final void D(a aVar) {
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
