package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.Ju6, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public abstract class AbstractC5548Ju6 extends RecyclerView.h {
    private final List d;

    public AbstractC5548Ju6(List list) {
        AbstractC13042fc3.i(list, "values");
        this.d = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public AbstractC5782Ku6 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i == EnumC9185Yv6.a.ordinal() || i == EnumC9185Yv6.b.ordinal() || i == EnumC9185Yv6.d.ordinal() || i == EnumC9185Yv6.f.ordinal() || i == EnumC9185Yv6.g.ordinal()) {
            View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.setting_row_main, viewGroup, false);
            AbstractC13042fc3.f(viewInflate);
            return new C20981sv6(viewInflate);
        }
        if (i == EnumC9185Yv6.e.ordinal()) {
            View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.setting_row_radio_group, viewGroup, false);
            AbstractC13042fc3.f(viewInflate2);
            return new C8930Xv6(viewInflate2);
        }
        if (i == EnumC9185Yv6.c.ordinal()) {
            View viewInflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.setting_row_switch, viewGroup, false);
            AbstractC13042fc3.f(viewInflate3);
            return new C10022aw6(viewInflate3);
        }
        if (i != EnumC9185Yv6.h.ordinal()) {
            throw new IllegalArgumentException("Invalid view type");
        }
        View viewInflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC12208eD5.setting_row_separator, viewGroup, false);
        AbstractC13042fc3.f(viewInflate4);
        return new C9419Zv6(viewInflate4);
    }

    public void B(AbstractC5782Ku6 abstractC5782Ku6, C21668tv6 c21668tv6, int i) {
        AbstractC13042fc3.i(abstractC5782Ku6, "holder");
        AbstractC13042fc3.i(c21668tv6, "item");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return ((C21668tv6) this.d.get(i)).c().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(AbstractC5782Ku6 abstractC5782Ku6, int i) {
        View viewD0;
        AbstractC13042fc3.i(abstractC5782Ku6, "holder");
        C21668tv6 c21668tv6 = (C21668tv6) this.d.get(i);
        abstractC5782Ku6.C0(c21668tv6);
        if (i == this.d.size() - 1 && (viewD0 = abstractC5782Ku6.D0()) != null) {
            viewD0.setVisibility(4);
        }
        B(abstractC5782Ku6, c21668tv6, i);
    }
}
