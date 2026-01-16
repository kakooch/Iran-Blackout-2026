package ir.nasim;

import android.view.LayoutInflater;
import android.view.ViewGroup;

/* loaded from: classes4.dex */
public final class VT4 extends AbstractC14051hG3 {
    @Override // ir.nasim.AbstractC14051hG3
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void B(WT4 wt4, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(wt4, "holder");
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        wt4.C0(abstractC13460gG3);
    }

    @Override // ir.nasim.AbstractC14051hG3
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public WT4 C(ViewGroup viewGroup, AbstractC13460gG3 abstractC13460gG3) {
        AbstractC13042fc3.i(viewGroup, "parent");
        AbstractC13042fc3.i(abstractC13460gG3, "loadState");
        C25083zi1 c25083zi1C = C25083zi1.c(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        AbstractC13042fc3.h(c25083zi1C, "inflate(...)");
        return new WT4(c25083zi1C);
    }
}
