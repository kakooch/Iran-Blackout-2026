package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

/* renamed from: ir.nasim.hH, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14056hH extends RecyclerView.h {
    public static final a h = new a(null);
    public static final int i = 8;
    private ArrayList d = new ArrayList();
    private c e;
    private d f;
    private b g;

    /* renamed from: ir.nasim.hH$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.hH$b */
    public interface b {
        void j2(C13465gH c13465gH);
    }

    /* renamed from: ir.nasim.hH$c */
    public interface c {
        void D2(C12847fH c12847fH);
    }

    /* renamed from: ir.nasim.hH$d */
    public interface d {
        void B4(C12847fH c12847fH);
    }

    public final void A(c cVar) {
        this.e = cVar;
    }

    public final void B(d dVar) {
        this.f = dVar;
    }

    public final void C(b bVar) {
        this.g = bVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i2) {
        Object obj = this.d.get(i2);
        if (obj instanceof C12847fH) {
            return 7;
        }
        return obj instanceof C13465gH ? 10 : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i2) {
        AbstractC13042fc3.i(c2, "holder");
        int itemViewType = getItemViewType(i2);
        if (itemViewType == 7) {
            Object obj = this.d.get(i2);
            AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.features.arbaeen.ArbaeenMobileItem");
            ((C17029mH) c2).E0((C12847fH) obj);
        } else {
            if (itemViewType != 10) {
                return;
            }
            Object obj2 = this.d.get(i2);
            AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type ir.nasim.features.arbaeen.ArbaeenMobileItemButton");
            ((C15256jH) c2).D0((C13465gH) obj2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i2 == 7 ? C17029mH.w.a(viewGroup, this.e, this.f) : C15256jH.v.a(viewGroup, this.g);
    }

    public final void z(ArrayList arrayList) {
        AbstractC13042fc3.i(arrayList, "<set-?>");
        this.d = arrayList;
    }
}
