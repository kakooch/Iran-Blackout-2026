package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: ir.nasim.oJ4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18234oJ4 extends androidx.recyclerview.widget.q {
    private final SA2 f;
    private final InterfaceC19342qB2 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C18234oJ4(SA2 sa2, InterfaceC19342qB2 interfaceC19342qB2) {
        super(C18825pJ4.a);
        AbstractC13042fc3.i(sa2, "openCurrentCallClickListener");
        AbstractC13042fc3.i(interfaceC19342qB2, "joinCallClickListener");
        this.f = sa2;
        this.g = interfaceC19342qB2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public int getItemViewType(int i) {
        return i == 0 ? MU2.u.a() : C21219tJ4.x.a();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onBindViewHolder(RecyclerView.C c, int i) {
        AbstractC13042fc3.i(c, "holder");
        if (c instanceof C21219tJ4) {
            Object objA = A(i);
            AbstractC13042fc3.g(objA, "null cannot be cast to non-null type ir.nasim.call.ui.calllog.adapters.holder.OnGoingCallItem");
            ((C21219tJ4) c).E0((InterfaceC19416qJ4) objA);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public RecyclerView.C onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        if (i == MU2.u.a()) {
            NU2 nu2C = NU2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(nu2C, "inflate(...)");
            return new MU2(nu2C);
        }
        if (i == C21219tJ4.x.a()) {
            C19307q76 c19307q76C = C19307q76.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            AbstractC13042fc3.h(c19307q76C, "inflate(...)");
            return new C21219tJ4(c19307q76C, this.g, this.f);
        }
        throw new IllegalStateException("this type with id <" + i + "> is not found!");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    public void onViewRecycled(RecyclerView.C c) {
        AbstractC13042fc3.i(c, "holder");
        if (c instanceof C21219tJ4) {
            ((C21219tJ4) c).a();
        }
        super.onViewRecycled(c);
    }
}
