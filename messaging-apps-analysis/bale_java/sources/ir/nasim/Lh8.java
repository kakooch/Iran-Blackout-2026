package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Lh8 implements InterfaceC22720vi8 {
    private final InterfaceC22720vi8 a;
    private final String b;

    public Lh8(String str) {
        this.a = InterfaceC22720vi8.r0;
        this.b = str;
    }

    public final InterfaceC22720vi8 a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return new Lh8(this.b, this.a.d());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Lh8)) {
            return false;
        }
        Lh8 lh8 = (Lh8) obj;
        return this.b.equals(lh8.b) && this.a.equals(lh8.a);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        throw new IllegalStateException("Control is not a boolean");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return null;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public Lh8(String str, InterfaceC22720vi8 interfaceC22720vi8) {
        this.a = interfaceC22720vi8;
        this.b = str;
    }
}
