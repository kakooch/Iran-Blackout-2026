package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.HW;

/* renamed from: ir.nasim.vW, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C22595vW extends i.f {
    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(HW hw, HW hw2) {
        AbstractC13042fc3.i(hw, "oldItem");
        AbstractC13042fc3.i(hw2, "newItem");
        if ((hw instanceof HW.b) && (hw2 instanceof HW.b)) {
            HW.b bVar = (HW.b) hw;
            HW.b bVar2 = (HW.b) hw2;
            if (!AbstractC13042fc3.d(bVar.d(), bVar2.d()) || !AbstractC13042fc3.d(bVar.c(), bVar2.c()) || bVar.a() != bVar2.a()) {
                return false;
            }
        } else if ((hw instanceof HW.a) && (hw2 instanceof HW.a)) {
            HW.a aVar = (HW.a) hw;
            HW.a aVar2 = (HW.a) hw2;
            if (!AbstractC13042fc3.d(aVar.f(), aVar2.f()) || !AbstractC13042fc3.d(aVar.e(), aVar2.e()) || !AbstractC13042fc3.d(aVar.h(), aVar2.h()) || aVar.g() != aVar2.g() || aVar.a() != aVar2.a()) {
                return false;
            }
        } else if ((!(hw instanceof HW.c.a) || !(hw2 instanceof HW.c.a)) && (!(hw instanceof HW.c.b) || !(hw2 instanceof HW.c.b))) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(HW hw, HW hw2) {
        AbstractC13042fc3.i(hw, "oldItem");
        AbstractC13042fc3.i(hw2, "newItem");
        return AbstractC13042fc3.d(hw.b(), hw2.b());
    }
}
