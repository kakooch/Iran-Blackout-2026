package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.C10489bh6;
import ir.nasim.C22698vg6;
import java.util.ArrayList;

/* renamed from: ir.nasim.fh6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C13122fh6 extends RecyclerView.h {
    public static final a h = new a(null);
    public static final int i = 8;
    private b d;
    private c e;
    private d f;
    private final ArrayList g = new ArrayList();

    /* renamed from: ir.nasim.fh6$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    /* renamed from: ir.nasim.fh6$b */
    public interface b {
        void z1(C22698vg6.b bVar);
    }

    /* renamed from: ir.nasim.fh6$c */
    public interface c {
        void r4(C10489bh6.b bVar);
    }

    /* renamed from: ir.nasim.fh6$d */
    public interface d {
        void r2(C22698vg6.d dVar);
    }

    public final void A() {
        int itemCount = getItemCount();
        this.g.clear();
        if (itemCount > 0) {
            notifyItemRangeRemoved(0, itemCount);
        }
    }

    public final void B(b bVar) {
        this.d = bVar;
    }

    public final void C(c cVar) {
        this.e = cVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i2) {
        Object obj = this.g.get(i2);
        if (obj instanceof C22698vg6.b) {
            return 0;
        }
        if (obj instanceof C10489bh6.b) {
            return 1;
        }
        if (obj instanceof C22698vg6.c) {
            return 2;
        }
        return obj instanceof C10489bh6.c ? 3 : 4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c2, int i2) {
        AbstractC13042fc3.i(c2, "holder");
        try {
            if ((c2 instanceof C14914ih6) && getItemViewType(i2) == 0) {
                Object obj = this.g.get(i2);
                AbstractC13042fc3.g(obj, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchMarketResponse.Peer");
                ((C14914ih6) c2).F0((C22698vg6.b) obj);
            } else if ((c2 instanceof C17277mh6) && getItemViewType(i2) == 2) {
                Object obj2 = this.g.get(i2);
                AbstractC13042fc3.g(obj2, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchMarketResponse.PeerLoading");
                ((C17277mh6) c2).D0((C22698vg6.c) obj2);
            } else if ((c2 instanceof C16095kh6) && getItemViewType(i2) == 1) {
                Object obj3 = this.g.get(i2);
                AbstractC13042fc3.g(obj3, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchProductResponse.Post");
                ((C16095kh6) c2).F0((C10489bh6.b) obj3);
            } else if ((c2 instanceof C17868nh6) && getItemViewType(i2) == 3) {
                Object obj4 = this.g.get(i2);
                AbstractC13042fc3.g(obj4, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchProductResponse.PostLoading");
                ((C17868nh6) c2).D0((C10489bh6.c) obj4);
            } else if ((c2 instanceof C19050ph6) && getItemViewType(i2) == 4) {
                Object obj5 = this.g.get(i2);
                AbstractC13042fc3.g(obj5, "null cannot be cast to non-null type ir.nasim.core.modules.market.model.SearchMarketResponse.ShowAll");
                AbstractC18350oW3.a(obj5);
                ((C19050ph6) c2).E0(null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? C19050ph6.x.a(viewGroup, this.f) : C17868nh6.v.a(viewGroup) : C17277mh6.v.a(viewGroup) : C16095kh6.y.a(viewGroup, this.e) : C14914ih6.y.a(viewGroup, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c2) {
        AbstractC13042fc3.i(c2, "holder");
        super.onViewRecycled(c2);
        if (c2 instanceof C14914ih6) {
            ((C14914ih6) c2).M0();
        } else if (c2 instanceof C16095kh6) {
            ((C16095kh6) c2).J0();
        }
    }

    public final ArrayList z() {
        return this.g;
    }
}
