package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* renamed from: ir.nasim.kJ5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15871kJ5 extends RecyclerView.h {
    private final Context d;
    private final InterfaceC22483vJ4 e;
    private final C22042ua0 f;
    private final OP1 g;
    private final InterfaceC14603iB2 h;
    private List i;

    public C15871kJ5(Context context, InterfaceC22483vJ4 interfaceC22483vJ4, C22042ua0 c22042ua0, OP1 op1, InterfaceC14603iB2 interfaceC14603iB2) {
        AbstractC13042fc3.i(context, "context");
        AbstractC13042fc3.i(interfaceC22483vJ4, "onItemClicked");
        AbstractC13042fc3.i(c22042ua0, "baseFragment");
        AbstractC13042fc3.i(op1, "dialogType");
        AbstractC13042fc3.i(interfaceC14603iB2, "sendSerajEvent");
        this.d = context;
        this.e = interfaceC22483vJ4;
        this.f = c22042ua0;
        this.g = op1;
        this.h = interfaceC14603iB2;
        this.i = AbstractC10360bX0.m();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return this.i.isEmpty() ? this.g == OP1.GROUP ? 0 : 1 : this.i.size() + 2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return this.g == OP1.GROUP ? (i == this.i.size() + 1 && (this.i.isEmpty() ^ true)) ? PP1.d.j() : (i == 0 && (this.i.isEmpty() ^ true)) ? PP1.b.j() : PP1.c.j() : (i == this.i.size() + 1 || this.i.isEmpty()) ? PP1.d.j() : i == 0 ? PP1.b.j() : PP1.c.j();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i) {
        AbstractC13042fc3.i(c, "holder");
        if (c instanceof C20649sN1) {
            C20649sN1 c20649sN1 = (C20649sN1) c;
            int i2 = i - 1;
            C17067mL1 c17067mL1 = (C17067mL1) this.i.get(i2);
            boolean z = i2 == this.i.size() - 1;
            Boolean bool = Boolean.FALSE;
            c20649sN1.H0(c17067mL1, z, bool, bool, null);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (PP1.b.j() == i) {
            return new KU2(new FrameLayout(this.d), this.d, this.g);
        }
        if (PP1.c.j() == i) {
            return new C20649sN1(this.d, new FrameLayout(this.d), this.e, this.f);
        }
        View viewInflate = LayoutInflater.from(this.d).inflate(AbstractC12208eD5.footer_recommended_channel, viewGroup, false);
        AbstractC13042fc3.h(viewInflate, "inflate(...)");
        return new C6978Pu2(viewInflate, this.g, this.h);
    }

    public final void z(List list) {
        AbstractC13042fc3.i(list, "items");
        this.i = list;
        notifyDataSetChanged();
    }
}
