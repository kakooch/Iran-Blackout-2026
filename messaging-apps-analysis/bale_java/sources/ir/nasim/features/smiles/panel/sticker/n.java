package ir.nasim.features.smiles.panel.sticker;

import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.features.smiles.panel.sticker.l;
import kotlin.NoWhenBranchMatchedException;

/* loaded from: classes6.dex */
final class n extends i.f {
    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(l lVar, l lVar2) {
        AbstractC13042fc3.i(lVar, "oldItem");
        AbstractC13042fc3.i(lVar2, "newItem");
        if (lVar instanceof l.a) {
            if (lVar2 instanceof l.a) {
                l.a aVar = (l.a) lVar;
                l.a aVar2 = (l.a) lVar2;
                if (AbstractC13042fc3.d(aVar.b().u(), aVar2.b().u()) && aVar.b().y() == aVar2.b().y()) {
                    return true;
                }
            }
        } else {
            if (!(lVar instanceof l.b)) {
                throw new NoWhenBranchMatchedException();
            }
            if (lVar2 instanceof l.b) {
                l.b bVar = (l.b) lVar;
                l.b bVar2 = (l.b) lVar2;
                if (bVar.b() == bVar2.b() && bVar.a() == bVar2.a()) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(l lVar, l lVar2) {
        AbstractC13042fc3.i(lVar, "oldItem");
        AbstractC13042fc3.i(lVar2, "newItem");
        if (lVar instanceof l.a) {
            if (lVar2 instanceof l.a) {
                l.a aVar = (l.a) lVar;
                l.a aVar2 = (l.a) lVar2;
                if (AbstractC13042fc3.d(aVar.b().u(), aVar2.b().u()) && aVar.b().y() == aVar2.b().y()) {
                    return true;
                }
            }
        } else {
            if (!(lVar instanceof l.b)) {
                throw new NoWhenBranchMatchedException();
            }
            if ((lVar2 instanceof l.b) && ((l.b) lVar).b() == ((l.b) lVar2).b()) {
                return true;
            }
        }
        return false;
    }
}
