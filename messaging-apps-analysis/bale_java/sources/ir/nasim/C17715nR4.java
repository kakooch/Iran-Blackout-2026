package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: ir.nasim.nR4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C17715nR4 extends RecyclerView.h {
    public static final a g = new a(null);
    public static final int h = 8;
    private List d = AbstractC10360bX0.m();
    private List e = AbstractC10360bX0.m();
    private Map f = new LinkedHashMap();

    /* renamed from: ir.nasim.nR4$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public KQ4 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.pfm_transaction_details, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new MQ4(viewInflate);
    }

    public final void B(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.e = list;
    }

    public final void C(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.d = list;
    }

    public final void D(Map map) {
        AbstractC13042fc3.i(map, "<set-?>");
        this.f = map;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(KQ4 kq4, int i) {
        AbstractC13042fc3.i(kq4, "holder");
        if (this.d.size() > i) {
            PFMTag pFMTag = (PFMTag) this.d.get(i);
            Long l = null;
            if (!this.e.isEmpty()) {
                try {
                    l = (Long) this.e.get(i);
                } catch (Exception unused) {
                }
            }
            kq4.E0((Map) this.f.get(pFMTag));
            kq4.C0(pFMTag, i == 0, l);
        }
    }
}
