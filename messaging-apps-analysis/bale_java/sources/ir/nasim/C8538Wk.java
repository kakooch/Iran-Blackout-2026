package ir.nasim;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import ir.nasim.AbstractC15520jj2;

/* renamed from: ir.nasim.Wk, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C8538Wk extends androidx.recyclerview.widget.q {
    public static final int i = C14970in2.j;
    private final UA2 f;
    private final InterfaceC21561tl g;
    private final C14970in2 h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C8538Wk(UA2 ua2, InterfaceC21561tl interfaceC21561tl, C14970in2 c14970in2) {
        super(C22570vT1.a);
        AbstractC13042fc3.i(ua2, "itemSizeProvider");
        AbstractC13042fc3.i(interfaceC21561tl, "albumItemListener");
        AbstractC13042fc3.i(c14970in2, "filesModule");
        this.f = ua2;
        this.g = interfaceC21561tl;
        this.h = c14970in2;
    }

    @Override // androidx.recyclerview.widget.q, androidx.recyclerview.widget.RecyclerView.h
    public int getItemCount() {
        return z().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i2) {
        AbstractC13042fc3.i(c, "holder");
        AbstractC15520jj2.a aVar = (AbstractC15520jj2.a) z().get(i2);
        if (c instanceof C3573Bl) {
            AbstractC13042fc3.f(aVar);
            ((C3573Bl) c).H0(aVar, (XV4) this.f.invoke(Integer.valueOf(i2)));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i2) {
        AbstractC13042fc3.i(viewGroup, "parent");
        return i2 == EnumC12502ej2.d.j() ? C3573Bl.A.a(viewGroup, this.g, this.h) : C3573Bl.A.a(viewGroup, this.g, this.h);
    }
}
