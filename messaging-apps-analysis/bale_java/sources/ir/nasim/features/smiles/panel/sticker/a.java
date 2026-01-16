package ir.nasim.features.smiles.panel.sticker;

import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.features.smiles.panel.sticker.d;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
final class a extends i.f {
    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(d dVar, d dVar2) {
        AbstractC13042fc3.i(dVar, "oldItem");
        AbstractC13042fc3.i(dVar2, "newItem");
        if (dVar instanceof d.a) {
            if (dVar2 instanceof d.a) {
                return AbstractC13042fc3.d(((d.a) dVar).c(), ((d.a) dVar2).c());
            }
            return false;
        }
        if (!(dVar instanceof d.b)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(dVar2 instanceof d.b)) {
            return false;
        }
        d.b bVar = (d.b) dVar;
        d.b bVar2 = (d.b) dVar2;
        return AbstractC13042fc3.d(bVar.b().u(), bVar2.b().u()) && bVar.b().y() == bVar2.b().y();
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(d dVar, d dVar2) {
        AbstractC13042fc3.i(dVar, "oldItem");
        AbstractC13042fc3.i(dVar2, "newItem");
        if (dVar instanceof d.a) {
            if (dVar2 instanceof d.a) {
                return AbstractC13042fc3.d(((d.a) dVar).c(), ((d.a) dVar2).c());
            }
            return false;
        }
        if (!(dVar instanceof d.b)) {
            throw new NoWhenBranchMatchedException();
        }
        if (!(dVar2 instanceof d.b)) {
            return false;
        }
        d.b bVar = (d.b) dVar;
        d.b bVar2 = (d.b) dVar2;
        return AbstractC13042fc3.d(bVar.b().u(), bVar2.b().u()) && bVar.b().y() == bVar2.b().y();
    }
}
