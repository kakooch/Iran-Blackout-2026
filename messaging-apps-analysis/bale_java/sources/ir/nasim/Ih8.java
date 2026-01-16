package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Ih8 implements InterfaceC22720vi8 {
    private final boolean a;

    public Ih8(Boolean bool) {
        this.a = bool == null ? false : bool.booleanValue();
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return new Ih8(Boolean.valueOf(this.a));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Ih8) && this.a == ((Ih8) obj).a;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.a).hashCode();
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return Boolean.toString(this.a);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return Double.valueOf(true != this.a ? 0.0d : 1.0d);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        return Boolean.valueOf(this.a);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return null;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        if ("toString".equals(str)) {
            return new Ei8(Boolean.toString(this.a));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.a), str));
    }

    public final String toString() {
        return String.valueOf(this.a);
    }
}
