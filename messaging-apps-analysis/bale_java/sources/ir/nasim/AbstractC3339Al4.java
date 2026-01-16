package ir.nasim;

import ir.nasim.C13245fu;
import java.util.ArrayList;
import java.util.List;

/* renamed from: ir.nasim.Al4, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC3339Al4 {
    /* JADX INFO: Access modifiers changed from: private */
    public static final List b(List list, int i, int i2) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            C13245fu.d dVar = (C13245fu.d) list.get(i3);
            if (AbstractC13836gu.i(i, i2, dVar.h(), dVar.f())) {
                if (!(i <= dVar.h() && dVar.f() <= i2)) {
                    N73.a("placeholder can not overlap with paragraph.");
                }
                arrayList.add(new C13245fu.d(dVar.g(), dVar.h() - i, dVar.f() - i));
            }
        }
        return arrayList;
    }
}
