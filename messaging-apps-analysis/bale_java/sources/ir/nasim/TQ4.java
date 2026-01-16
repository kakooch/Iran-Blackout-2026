package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.List;

/* loaded from: classes6.dex */
public final class TQ4 extends RecyclerView.h {
    public static final a j = new a(null);
    public static final int k = 8;
    private final SQ4 d;
    private int e;
    private final boolean f;
    private List g = AbstractC10360bX0.m();
    private List h = AbstractC10360bX0.m();
    private Long i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public TQ4(SQ4 sq4, int i, boolean z) {
        this.d = sq4;
        this.e = i;
        this.f = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public KQ4 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i == 0) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.pfm_tag, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new QQ4(viewInflate, this.d);
        }
        View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.pfm_action_tag, viewGroup, false);
        if (this.f) {
            viewInflate2.setVisibility(8);
        }
        AbstractC13042fc3.f(viewInflate2);
        return new HO4(viewInflate2, this.d);
    }

    public final void B(Long l) {
        this.i = l;
    }

    public final void C(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.g = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        if (!this.g.isEmpty()) {
            return this.g.size() + this.e;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return i == this.g.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(KQ4 kq4, int i) {
        AbstractC13042fc3.i(kq4, "holder");
        if (this.g.size() > i) {
            PFMTag pFMTag = (PFMTag) this.g.get(i);
            Long l = null;
            if (!this.h.isEmpty()) {
                try {
                    l = (Long) this.h.get(i);
                } catch (Exception unused) {
                }
            }
            Long l2 = this.i;
            kq4.C0(pFMTag, l2 != null && l2.longValue() == pFMTag.getId(), l);
        }
    }
}
