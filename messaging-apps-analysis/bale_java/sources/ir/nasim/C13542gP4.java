package ir.nasim;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import ir.nasim.features.pfm.entity.PFMTransaction;

/* renamed from: ir.nasim.gP4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13542gP4 extends androidx.recyclerview.widget.q {
    private final InterfaceC18633oz3 f;
    private final boolean g;
    private final InterfaceC15408jX7 h;
    private final InterfaceC14603iB2 i;
    private final UA2 j;
    private final boolean k;

    public /* synthetic */ C13542gP4(InterfaceC18633oz3 interfaceC18633oz3, boolean z, InterfaceC15408jX7 interfaceC15408jX7, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, boolean z2, int i, ED1 ed1) {
        this(interfaceC18633oz3, z, interfaceC15408jX7, interfaceC14603iB2, ua2, (i & 32) != 0 ? false : z2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(ir.nasim.features.pfm.g gVar, int i) {
        AbstractC13042fc3.i(gVar, "holder");
        Object objA = A(i);
        AbstractC13042fc3.h(objA, "getItem(...)");
        gVar.e1((PFMTransaction) objA, getItemCount() - 1 == i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public ir.nasim.features.pfm.g onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        FW7 fw7C = FW7.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(fw7C, "inflate(...)");
        InterfaceC14603iB2 interfaceC14603iB2 = this.i;
        Context context = viewGroup.getContext();
        AbstractC13042fc3.h(context, "getContext(...)");
        return new ir.nasim.features.pfm.g(fw7C, interfaceC14603iB2, context, this.f, this.g, this.h, this.j, this.k);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13542gP4(InterfaceC18633oz3 interfaceC18633oz3, boolean z, InterfaceC15408jX7 interfaceC15408jX7, InterfaceC14603iB2 interfaceC14603iB2, UA2 ua2, boolean z2) {
        super(new FP4());
        AbstractC13042fc3.i(interfaceC18633oz3, "lifecycleOwner");
        AbstractC13042fc3.i(interfaceC15408jX7, "viewModelStore");
        AbstractC13042fc3.i(interfaceC14603iB2, "click");
        AbstractC13042fc3.i(ua2, "showFragmentCallback");
        this.f = interfaceC18633oz3;
        this.g = z;
        this.h = interfaceC15408jX7;
        this.i = interfaceC14603iB2;
        this.j = ua2;
        this.k = z2;
    }
}
