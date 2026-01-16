package ir.nasim;

import ir.nasim.InterfaceC4356Eu;
import java.util.Iterator;

/* loaded from: classes8.dex */
final class X82 implements InterfaceC4356Eu {
    private final C9424Zw2 a;

    public X82(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqNameToMatch");
        this.a = c9424Zw2;
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean M1(C9424Zw2 c9424Zw2) {
        return InterfaceC4356Eu.b.b(this, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC4356Eu
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public W82 z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        if (AbstractC13042fc3.d(c9424Zw2, this.a)) {
            return W82.a;
        }
        return null;
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return AbstractC10360bX0.m().iterator();
    }
}
