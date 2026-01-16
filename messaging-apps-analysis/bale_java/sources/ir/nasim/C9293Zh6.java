package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C9059Yh6;
import ir.nasim.core.modules.market.model.SearchSuggestionRow;
import java.util.ArrayList;

/* renamed from: ir.nasim.Zh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C9293Zh6 extends RecyclerView.h {
    private ArrayList d = new ArrayList();
    private a e;
    private C9059Yh6.a f;
    private C9059Yh6.b g;

    /* renamed from: ir.nasim.Zh6$a */
    public interface a {
        void n5(SearchSuggestionRow searchSuggestionRow);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C10499bi6 c10499bi6, int i) {
        AbstractC13042fc3.i(c10499bi6, "holder");
        Object obj = this.d.get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c10499bi6.E0((SearchSuggestionRow) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public C10499bi6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return C10499bi6.B.a(viewGroup, this.e, this.f, this.g);
    }

    public final void C(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.d = arrayList;
    }

    public final void D(a aVar) {
        this.e = aVar;
    }

    public final void E(C9059Yh6.b bVar) {
        this.g = bVar;
    }

    public final void F(C9059Yh6.a aVar) {
        this.f = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    public final ArrayList z() {
        return this.d;
    }
}
