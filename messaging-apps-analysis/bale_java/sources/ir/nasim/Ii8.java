package ir.nasim;

import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class Ii8 implements InterfaceC22720vi8 {
    @Override // ir.nasim.InterfaceC22720vi8
    public final InterfaceC22720vi8 d() {
        return InterfaceC22720vi8.r0;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return obj instanceof Ii8;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final String j() {
        return StringUtils.UNDEFINED;
    }

    @Override // ir.nasim.InterfaceC22720vi8
    public final Double k() {
        return Double.valueOf(Double.NaN);
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
        throw new IllegalStateException(String.format("Undefined has no function %s", str));
    }
}
