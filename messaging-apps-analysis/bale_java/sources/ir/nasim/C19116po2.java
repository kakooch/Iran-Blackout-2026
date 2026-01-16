package ir.nasim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* renamed from: ir.nasim.po2, reason: case insensitive filesystem */
/* loaded from: classes8.dex */
public final class C19116po2 implements InterfaceC4356Eu {
    private final InterfaceC4356Eu a;
    private final boolean b;
    private final UA2 c;

    public C19116po2(InterfaceC4356Eu interfaceC4356Eu, boolean z, UA2 ua2) {
        AbstractC13042fc3.i(interfaceC4356Eu, "delegate");
        AbstractC13042fc3.i(ua2, "fqNameFilter");
        this.a = interfaceC4356Eu;
        this.b = z;
        this.c = ua2;
    }

    private final boolean f(InterfaceC21651tu interfaceC21651tu) {
        C9424Zw2 c9424Zw2E = interfaceC21651tu.e();
        return c9424Zw2E != null && ((Boolean) this.c.invoke(c9424Zw2E)).booleanValue();
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean M1(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        if (((Boolean) this.c.invoke(c9424Zw2)).booleanValue()) {
            return this.a.M1(c9424Zw2);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean isEmpty() {
        boolean z;
        InterfaceC4356Eu interfaceC4356Eu = this.a;
        if ((interfaceC4356Eu instanceof Collection) && ((Collection) interfaceC4356Eu).isEmpty()) {
            z = false;
        } else {
            Iterator it = interfaceC4356Eu.iterator();
            while (it.hasNext()) {
                if (f((InterfaceC21651tu) it.next())) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return this.b ? !z : z;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        InterfaceC4356Eu interfaceC4356Eu = this.a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : interfaceC4356Eu) {
            if (f((InterfaceC21651tu) obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.iterator();
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public InterfaceC21651tu z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        if (((Boolean) this.c.invoke(c9424Zw2)).booleanValue()) {
            return this.a.z(c9424Zw2);
        }
        return null;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C19116po2(InterfaceC4356Eu interfaceC4356Eu, UA2 ua2) {
        this(interfaceC4356Eu, false, ua2);
        AbstractC13042fc3.i(interfaceC4356Eu, "delegate");
        AbstractC13042fc3.i(ua2, "fqNameFilter");
    }
}
