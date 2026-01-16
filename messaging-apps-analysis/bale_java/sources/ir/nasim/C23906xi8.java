package ir.nasim;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.xi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C23906xi8 implements InterfaceC22720vi8 {
    private final String a;
    private final ArrayList b;

    public C23906xi8(String str, List list) {
        this.a = str;
        ArrayList arrayList = new ArrayList();
        this.b = arrayList;
        arrayList.addAll(list);
    }

    public final String a() {
        return this.a;
    }

    public final ArrayList b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23906xi8)) {
            return false;
        }
        C23906xi8 c23906xi8 = (C23906xi8) obj;
        String str = this.a;
        if (str == null ? c23906xi8.a == null : str.equals(c23906xi8.a)) {
            return this.b.equals(c23906xi8.b);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.a;
        return ((str != null ? str.hashCode() : 0) * 31) + this.b.hashCode();
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return null;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return this;
    }
}
