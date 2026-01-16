package ir.nasim;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: ir.nasim.gj2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13729gj2 extends AbstractC14051hG3 {
    private final SA2 e;

    public C13729gj2(SA2 sa2) {
        AbstractC13042fc3.i(sa2, "retry");
        this.e = sa2;
    }

    @Override // ir.nasim.AbstractC14051hG3
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void B(C10889cN3 c10889cN3, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(c10889cN3, "holder");
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        c10889cN3.C0(abstractC13460gG3);
    }

    @Override // ir.nasim.AbstractC14051hG3
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public C10889cN3 C(ViewGroup viewGroup, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(viewGroup, "parent");
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(HC5.feed_load_state_holder, viewGroup, false);
        AbstractC13042fc3.f(viewInflate);
        return new C10889cN3(viewInflate, this.e);
    }
}
