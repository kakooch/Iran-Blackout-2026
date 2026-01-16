package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC7304Rd3;

/* renamed from: ir.nasim.Qd3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C7070Qd3 extends i.f {
    public static final C7070Qd3 a = new C7070Qd3();

    private C7070Qd3() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(C22613vY c22613vY, C22613vY c22613vY2) {
        AbstractC13042fc3.i(c22613vY, "oldItem");
        AbstractC13042fc3.i(c22613vY2, "newItem");
        return AbstractC13042fc3.d(c22613vY, c22613vY2);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(C22613vY c22613vY, C22613vY c22613vY2) {
        AbstractC13042fc3.i(c22613vY, "oldItem");
        AbstractC13042fc3.i(c22613vY2, "newItem");
        return c22613vY.d() == c22613vY2.d();
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object c(C22613vY c22613vY, C22613vY c22613vY2) {
        AbstractC13042fc3.i(c22613vY, "oldItem");
        AbstractC13042fc3.i(c22613vY2, "newItem");
        if (c22613vY.h() != c22613vY2.h()) {
            return new AbstractC7304Rd3.a(c22613vY2.h());
        }
        return null;
    }
}
