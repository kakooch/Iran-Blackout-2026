package ir.nasim;

import ir.nasim.InterfaceC4356Eu;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.Fu, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C4590Fu implements InterfaceC4356Eu {
    private final List a;

    public C4590Fu(List list) {
        AbstractC13042fc3.i(list, "annotations");
        this.a = list;
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean M1(C9424Zw2 c9424Zw2) {
        return InterfaceC4356Eu.b.b(this, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.a.iterator();
    }

    public String toString() {
        return this.a.toString();
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public InterfaceC21651tu z(C9424Zw2 c9424Zw2) {
        return InterfaceC4356Eu.b.a(this, c9424Zw2);
    }
}
