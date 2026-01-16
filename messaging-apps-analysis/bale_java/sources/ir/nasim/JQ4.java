package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.features.pfm.tags.PFMTag;
import java.util.List;

/* loaded from: classes6.dex */
public final class JQ4 extends RecyclerView.h {
    public static final a h = new a(null);
    public static final int i = 8;
    private final SQ4 d;
    private int e;
    private List f = AbstractC10360bX0.m();
    private Long g;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public JQ4(SQ4 sq4, int i2) {
        this.d = sq4;
        this.e = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public KQ4 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i2 == 0) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.pfm_sub_tag, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new IQ4(viewInflate, this.d);
        }
        View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.pfm_action_sub_tag, viewGroup, false);
        AbstractC13042fc3.f(viewInflate2);
        return new HO4(viewInflate2, this.d);
    }

    public final void B(Long l) {
        this.g = l;
    }

    public final void C(List list) {
        AbstractC13042fc3.i(list, "<set-?>");
        this.f = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        if (!(!this.f.isEmpty())) {
            return 1;
        }
        return this.e + this.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i2) {
        return i2 == this.f.size() ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(KQ4 kq4, int i2) {
        AbstractC13042fc3.i(kq4, "holder");
        if (this.f.size() > i2) {
            PFMTag pFMTag = (PFMTag) this.f.get(i2);
            Long l = this.g;
            kq4.C0(pFMTag, l != null && l.longValue() == pFMTag.getId(), null);
        }
    }
}
