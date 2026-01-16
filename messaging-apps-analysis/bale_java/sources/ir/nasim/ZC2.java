package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.O15;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes6.dex */
public final class ZC2 extends i.f {
    public static final ZC2 a = new ZC2();

    private ZC2() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(C21837uD2 c21837uD2, C21837uD2 c21837uD22) {
        AbstractC13042fc3.i(c21837uD2, "oldItem");
        AbstractC13042fc3.i(c21837uD22, "newItem");
        return AbstractC13042fc3.d(c21837uD2.f(), c21837uD22.f()) && AbstractC13042fc3.d(c21837uD2.g(), c21837uD22.g());
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(C21837uD2 c21837uD2, C21837uD2 c21837uD22) {
        AbstractC13042fc3.i(c21837uD2, "oldItem");
        AbstractC13042fc3.i(c21837uD22, "newItem");
        return c21837uD2.c() == c21837uD22.c();
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public List c(C21837uD2 c21837uD2, C21837uD2 c21837uD22) {
        AbstractC13042fc3.i(c21837uD2, "oldItem");
        AbstractC13042fc3.i(c21837uD22, "newItem");
        ArrayList arrayList = new ArrayList();
        if (!AbstractC13042fc3.d(c21837uD2.g(), c21837uD22.g())) {
            arrayList.add(new O15.b(c21837uD22.g()));
        }
        if (!AbstractC13042fc3.d(c21837uD2.f(), c21837uD22.f())) {
            arrayList.add(new O15.a(c21837uD22.f(), c21837uD22.h()));
        }
        return arrayList;
    }
}
