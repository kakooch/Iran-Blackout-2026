package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.AbstractC19785qw0;
import ir.nasim.InterfaceC16239kw0;
import java.util.ArrayList;

/* renamed from: ir.nasim.hw0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C14450hw0 extends i.f {
    public static final C14450hw0 a = new C14450hw0();

    private C14450hw0() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InterfaceC16239kw0 interfaceC16239kw0, InterfaceC16239kw0 interfaceC16239kw02) {
        AbstractC13042fc3.i(interfaceC16239kw0, "oldItem");
        AbstractC13042fc3.i(interfaceC16239kw02, "newItem");
        return AbstractC13042fc3.d(interfaceC16239kw0, interfaceC16239kw02);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(InterfaceC16239kw0 interfaceC16239kw0, InterfaceC16239kw0 interfaceC16239kw02) {
        AbstractC13042fc3.i(interfaceC16239kw0, "oldItem");
        AbstractC13042fc3.i(interfaceC16239kw02, "newItem");
        return ((interfaceC16239kw0 instanceof InterfaceC16239kw0.a) && (interfaceC16239kw02 instanceof InterfaceC16239kw0.a) && (((InterfaceC16239kw0.a) interfaceC16239kw0).getId() > ((InterfaceC16239kw0.a) interfaceC16239kw02).getId() ? 1 : (((InterfaceC16239kw0.a) interfaceC16239kw0).getId() == ((InterfaceC16239kw0.a) interfaceC16239kw02).getId() ? 0 : -1)) == 0) || ((interfaceC16239kw0 instanceof InterfaceC16239kw0.d) && (interfaceC16239kw02 instanceof InterfaceC16239kw0.d)) || ((interfaceC16239kw0 instanceof InterfaceC16239kw0.b) && (interfaceC16239kw02 instanceof InterfaceC16239kw0.b));
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public Object c(InterfaceC16239kw0 interfaceC16239kw0, InterfaceC16239kw0 interfaceC16239kw02) {
        AbstractC13042fc3.i(interfaceC16239kw0, "oldItem");
        AbstractC13042fc3.i(interfaceC16239kw02, "newItem");
        if (!(interfaceC16239kw0 instanceof InterfaceC16239kw0.a) || !(interfaceC16239kw02 instanceof InterfaceC16239kw0.a)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        InterfaceC16239kw0.a aVar = (InterfaceC16239kw0.a) interfaceC16239kw02;
        if (((InterfaceC16239kw0.a) interfaceC16239kw0).b() != aVar.b()) {
            arrayList.add(new AbstractC19785qw0.a(aVar.b()));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }
}
