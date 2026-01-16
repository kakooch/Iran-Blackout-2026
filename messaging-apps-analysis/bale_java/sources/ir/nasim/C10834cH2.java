package ir.nasim;

import androidx.recyclerview.widget.i;

/* renamed from: ir.nasim.cH2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
final class C10834cH2 extends i.f {
    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(QG2 qg2, QG2 qg22) {
        AbstractC13042fc3.i(qg2, "oldItem");
        AbstractC13042fc3.i(qg22, "newItem");
        return AbstractC13042fc3.d(qg2, qg22);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(QG2 qg2, QG2 qg22) {
        AbstractC13042fc3.i(qg2, "oldItem");
        AbstractC13042fc3.i(qg22, "newItem");
        return qg2.c().getFileId() == qg22.c().getFileId();
    }
}
