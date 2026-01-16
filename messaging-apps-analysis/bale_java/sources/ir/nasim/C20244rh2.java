package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.InterfaceC14910ih2;
import java.util.ArrayList;

/* renamed from: ir.nasim.rh2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C20244rh2 extends i.f {
    public static final C20244rh2 a = new C20244rh2();

    private C20244rh2() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(C4743Gj2 c4743Gj2, C4743Gj2 c4743Gj22) {
        AbstractC13042fc3.i(c4743Gj2, "oldItem");
        AbstractC13042fc3.i(c4743Gj22, "newItem");
        return AbstractC13042fc3.d(c4743Gj2, c4743Gj22) && c4743Gj2.i() == c4743Gj22.i() && c4743Gj2.k() == c4743Gj22.k() && c4743Gj2.j().size() == c4743Gj22.j().size() && c4743Gj2.e().k().containsAll(c4743Gj22.e().k()) && c4743Gj22.e().k().containsAll(c4743Gj2.e().k());
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(C4743Gj2 c4743Gj2, C4743Gj2 c4743Gj22) {
        AbstractC13042fc3.i(c4743Gj2, "oldItem");
        AbstractC13042fc3.i(c4743Gj22, "newItem");
        return AbstractC13042fc3.d(c4743Gj2, c4743Gj22);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object c(C4743Gj2 c4743Gj2, C4743Gj2 c4743Gj22) {
        AbstractC13042fc3.i(c4743Gj2, "oldItem");
        AbstractC13042fc3.i(c4743Gj22, "newItem");
        ArrayList arrayList = new ArrayList();
        if (c4743Gj2.i() != c4743Gj22.i()) {
            arrayList.add(new InterfaceC14910ih2.a(c4743Gj22.i()));
        }
        if (c4743Gj2.k() != c4743Gj22.k()) {
            arrayList.add(new InterfaceC14910ih2.d(c4743Gj22.e(), c4743Gj22.k()));
        }
        if (c4743Gj2.j().size() != c4743Gj22.j().size()) {
            arrayList.add(new InterfaceC14910ih2.c(c4743Gj22.j()));
        }
        if (!AbstractC13042fc3.d(c4743Gj2.e().k(), c4743Gj22.e().k())) {
            arrayList.add(new InterfaceC14910ih2.b(c4743Gj22));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }
}
