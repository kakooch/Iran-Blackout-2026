package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.e50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C12126e50 extends RecyclerView.h {
    public static final a h = new a(null);
    public static final int i = 8;
    private ArrayList d = new ArrayList();
    private b e;
    private c f;
    private d g;

    /* renamed from: ir.nasim.e50$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.e50$b */
    public interface b {
        void t0(C11483d50 c11483d50);
    }

    /* renamed from: ir.nasim.e50$c */
    public interface c {
        void p2(C11483d50 c11483d50);
    }

    /* renamed from: ir.nasim.e50$d */
    public interface d {
        void t(C13944h50 c13944h50);
    }

    public final void A(b bVar) {
        this.e = bVar;
    }

    public final void B(c cVar) {
        this.f = cVar;
    }

    public final void C(d dVar) {
        this.g = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i2) {
        Object obj = this.d.get(i2);
        if (obj instanceof C11483d50) {
            return 7;
        }
        return obj instanceof C13944h50 ? 10 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i2) {
        AbstractC13042fc3.i(c2, "holder");
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 7) {
            Object obj = this.d.get(i2);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.features.payment.data.model.BankCardSuggest");
            ((C18099o50) c2).E0((C11483d50) obj);
        } else {
            if (itemViewType != 10) {
                return;
            }
            Object obj2 = this.d.get(i2);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type ir.nasim.features.payment.data.model.BankCardSuggestButton");
            ((C15144j50) c2).D0((C13944h50) obj2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i2 == 7 ? C18099o50.w.a(viewGroup, this.e, this.f) : C15144j50.v.a(viewGroup, this.g);
    }

    public final void z(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.d = arrayList;
    }
}
