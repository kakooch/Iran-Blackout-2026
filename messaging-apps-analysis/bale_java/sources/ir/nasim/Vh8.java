package ir.nasim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Vh8 implements InterfaceC22720vi8, InterfaceC14926ii8 {
    protected final String a;
    protected final Map b = new HashMap();

    public Vh8(String str) {
        this.a = str;
    }

    public abstract InterfaceC22720vi8 a(C20322ro8 c20322ro8, List list);

    public final String b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Vh8)) {
            return false;
        }
        Vh8 vh8 = (Vh8) obj;
        String str = this.a;
        if (str != null) {
            return str.equals(vh8.a);
        }
        return false;
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final boolean f(String str) {
        return this.b.containsKey(str);
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final InterfaceC22720vi8 h(String str) {
        return this.b.containsKey(str) ? (InterfaceC22720vi8) this.b.get(str) : InterfaceC22720vi8.r0;
    }

    public final int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // ir.nasim.InterfaceC14926ii8
    public final void i(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        if (interfaceC22720vi8 == null) {
            this.b.remove(str);
        } else {
            this.b.put(str, interfaceC22720vi8);
        }
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return this.a;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return Double.valueOf(Double.NaN);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        return Boolean.TRUE;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return AbstractC11264ci8.b(this.b);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        return "toString".equals(str) ? new Ei8(this.a) : AbstractC11264ci8.a(this, new Ei8(str), c20322ro8, list);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public InterfaceC22720vi8 d() {
        return this;
    }
}
