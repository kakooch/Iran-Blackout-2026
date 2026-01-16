package ir.nasim;

import java.util.Iterator;
import java.util.List;

/* renamed from: ir.nasim.pi8, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C19062pi8 implements InterfaceC22720vi8 {
    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return InterfaceC22720vi8.s0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof C19062pi8;
    }

    public final int hashCode() {
        return 1;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return "null";
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return Double.valueOf(0.0d);
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Boolean o() {
        return Boolean.FALSE;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Iterator r() {
        return null;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 t(String str, C20322ro8 c20322ro8, List list) {
        throw new IllegalStateException(String.format("null has no function %s", str));
    }
}
