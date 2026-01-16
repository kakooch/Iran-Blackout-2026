package ir.nasim;

import ir.nasim.InterfaceC4356Eu;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes8.dex */
public class YI1 implements InterfaceC4356Eu {
    static final /* synthetic */ InterfaceC5239Im3[] b = {AbstractC10882cM5.i(new C25226zw5(AbstractC10882cM5.b(YI1.class), "annotations", "getAnnotations()Ljava/util/List;"))};
    private final InterfaceC23016wC4 a;

    public YI1(ON6 on6, SA2 sa2) {
        AbstractC13042fc3.i(on6, "storageManager");
        AbstractC13042fc3.i(sa2, "compute");
        this.a = on6.c(sa2);
    }

    private final List f() {
        return (List) MN6.a(this.a, this, b[0]);
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean M1(C9424Zw2 c9424Zw2) {
        return InterfaceC4356Eu.b.b(this, c9424Zw2);
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public boolean isEmpty() {
        return f().isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return f().iterator();
    }

    @Override // ir.nasim.InterfaceC4356Eu
    public InterfaceC21651tu z(C9424Zw2 c9424Zw2) {
        return InterfaceC4356Eu.b.a(this, c9424Zw2);
    }
}
