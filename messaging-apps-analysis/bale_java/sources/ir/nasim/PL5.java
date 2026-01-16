package ir.nasim;

import java.util.Collection;
import java.util.List;

/* loaded from: classes8.dex */
public final class PL5 extends IL5 implements InterfaceC22715vi3 {
    private final C9424Zw2 a;

    public PL5(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        this.a = c9424Zw2;
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public boolean E() {
        return false;
    }

    @Override // ir.nasim.InterfaceC22715vi3
    public Collection F(UA2 ua2) {
        AbstractC13042fc3.i(ua2, "nameFilter");
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public List getAnnotations() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC22715vi3
    public C9424Zw2 e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof PL5) && AbstractC13042fc3.d(e(), ((PL5) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return PL5.class.getName() + ": " + e();
    }

    @Override // ir.nasim.InterfaceC22715vi3
    public Collection u() {
        return AbstractC10360bX0.m();
    }

    @Override // ir.nasim.InterfaceC5194Ih3
    public InterfaceC4009Dh3 z(C9424Zw2 c9424Zw2) {
        AbstractC13042fc3.i(c9424Zw2, "fqName");
        return null;
    }
}
