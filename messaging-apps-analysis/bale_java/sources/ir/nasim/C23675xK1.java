package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.xK1, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C23675xK1 {
    private final boolean a;
    private final List b;

    public C23675xK1(boolean z, List list) {
        AbstractC13042fc3.i(list, "deviceList");
        this.a = z;
        this.b = list;
    }

    public static /* synthetic */ C23675xK1 b(C23675xK1 c23675xK1, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = c23675xK1.a;
        }
        if ((i & 2) != 0) {
            list = c23675xK1.b;
        }
        return c23675xK1.a(z, list);
    }

    public final C23675xK1 a(boolean z, List list) {
        AbstractC13042fc3.i(list, "deviceList");
        return new C23675xK1(z, list);
    }

    public final List c() {
        return this.b;
    }

    public final boolean d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C23675xK1)) {
            return false;
        }
        C23675xK1 c23675xK1 = (C23675xK1) obj;
        return this.a == c23675xK1.a && AbstractC13042fc3.d(this.b, c23675xK1.b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DeviceState(loading=" + this.a + ", deviceList=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C23675xK1(boolean z, List list, int i, ED1 ed1) {
        this((i & 1) != 0 ? true : z, (i & 2) != 0 ? AbstractC10360bX0.m() : list);
    }
}
