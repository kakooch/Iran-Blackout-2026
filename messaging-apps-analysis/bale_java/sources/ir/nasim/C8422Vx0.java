package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;

/* renamed from: ir.nasim.Vx0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C8422Vx0 extends androidx.recyclerview.widget.q {
    public C8422Vx0() {
        super(C8656Wx0.a);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(C8188Ux0 c8188Ux0, int i) {
        AbstractC13042fc3.i(c8188Ux0, "holder");
        Object obj = z().get(i);
        AbstractC13042fc3.h(obj, "get(...)");
        c8188Ux0.D0((InterfaceC5569Jx0) obj);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.h
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C8188Ux0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        AbstractC13042fc3.i(viewGroup, "parent");
        C5418Jg2 c5418Jg2C = C5418Jg2.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c5418Jg2C, "inflate(...)");
        return new C8188Ux0(c5418Jg2C, C6011Lu2.k());
    }
}
