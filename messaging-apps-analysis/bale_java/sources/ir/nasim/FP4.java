package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.features.pfm.entity.PFMTransaction;

/* loaded from: classes6.dex */
public final class FP4 extends i.f {
    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(PFMTransaction pFMTransaction, PFMTransaction pFMTransaction2) {
        AbstractC13042fc3.i(pFMTransaction, "oldItem");
        AbstractC13042fc3.i(pFMTransaction2, "newItem");
        return pFMTransaction.getId() == pFMTransaction2.getId() && AbstractC13042fc3.d(pFMTransaction.getLabels(), pFMTransaction2.getLabels());
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(PFMTransaction pFMTransaction, PFMTransaction pFMTransaction2) {
        AbstractC13042fc3.i(pFMTransaction, "oldItem");
        AbstractC13042fc3.i(pFMTransaction2, "newItem");
        return AbstractC13042fc3.d(pFMTransaction, pFMTransaction2);
    }
}
