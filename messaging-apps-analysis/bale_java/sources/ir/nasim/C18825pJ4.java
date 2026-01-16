package ir.nasim;

import androidx.recyclerview.widget.i;
import ir.nasim.InterfaceC19416qJ4;

/* renamed from: ir.nasim.pJ4, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C18825pJ4 extends i.f {
    public static final C18825pJ4 a = new C18825pJ4();

    private C18825pJ4() {
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InterfaceC19416qJ4 interfaceC19416qJ4, InterfaceC19416qJ4 interfaceC19416qJ42) {
        AbstractC13042fc3.i(interfaceC19416qJ4, "oldItem");
        AbstractC13042fc3.i(interfaceC19416qJ42, "newItem");
        return AbstractC13042fc3.d(interfaceC19416qJ4, interfaceC19416qJ42);
    }

    @Override // androidx.recyclerview.widget.i.f
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public boolean b(InterfaceC19416qJ4 interfaceC19416qJ4, InterfaceC19416qJ4 interfaceC19416qJ42) {
        AbstractC13042fc3.i(interfaceC19416qJ4, "oldItem");
        AbstractC13042fc3.i(interfaceC19416qJ42, "newItem");
        return ((interfaceC19416qJ4 instanceof InterfaceC19416qJ4.c) && (interfaceC19416qJ42 instanceof InterfaceC19416qJ4.c) && (((InterfaceC19416qJ4.c) interfaceC19416qJ4).d() > ((InterfaceC19416qJ4.c) interfaceC19416qJ42).d() ? 1 : (((InterfaceC19416qJ4.c) interfaceC19416qJ4).d() == ((InterfaceC19416qJ4.c) interfaceC19416qJ42).d() ? 0 : -1)) == 0) || ((interfaceC19416qJ4 instanceof InterfaceC19416qJ4.a) && (interfaceC19416qJ42 instanceof InterfaceC19416qJ4.a));
    }
}
