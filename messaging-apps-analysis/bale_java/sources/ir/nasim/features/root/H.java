package ir.nasim.features.root;

import android.gov.nist.core.Separators;
import ir.nasim.AbstractC11420cy6;
import ir.nasim.AbstractC13042fc3;
import ir.nasim.ED1;
import ir.nasim.InterfaceC10040ay6;
import ir.nasim.core.modules.settings.entity.ChangeLogData;
import ir.nasim.features.root.L;

/* loaded from: classes6.dex */
public final class H {
    private final ChangeLogData a;
    private final String b;
    private final InterfaceC10040ay6 c;
    private final L d;
    private final boolean e;

    public H(ChangeLogData changeLogData, String str, InterfaceC10040ay6 interfaceC10040ay6, L l, boolean z) {
        AbstractC13042fc3.i(interfaceC10040ay6, "callToast");
        AbstractC13042fc3.i(l, "sharedContentState");
        this.a = changeLogData;
        this.b = str;
        this.c = interfaceC10040ay6;
        this.d = l;
        this.e = z;
    }

    public static /* synthetic */ H b(H h, ChangeLogData changeLogData, String str, InterfaceC10040ay6 interfaceC10040ay6, L l, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            changeLogData = h.a;
        }
        if ((i & 2) != 0) {
            str = h.b;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            interfaceC10040ay6 = h.c;
        }
        InterfaceC10040ay6 interfaceC10040ay62 = interfaceC10040ay6;
        if ((i & 8) != 0) {
            l = h.d;
        }
        L l2 = l;
        if ((i & 16) != 0) {
            z = h.e;
        }
        return h.a(changeLogData, str2, interfaceC10040ay62, l2, z);
    }

    public final H a(ChangeLogData changeLogData, String str, InterfaceC10040ay6 interfaceC10040ay6, L l, boolean z) {
        AbstractC13042fc3.i(interfaceC10040ay6, "callToast");
        AbstractC13042fc3.i(l, "sharedContentState");
        return new H(changeLogData, str, interfaceC10040ay6, l, z);
    }

    public final InterfaceC10040ay6 c() {
        return this.c;
    }

    public final ChangeLogData d() {
        return this.a;
    }

    public final String e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h = (H) obj;
        return AbstractC13042fc3.d(this.a, h.a) && AbstractC13042fc3.d(this.b, h.b) && AbstractC13042fc3.d(this.c, h.c) && AbstractC13042fc3.d(this.d, h.d) && this.e == h.e;
    }

    public final L f() {
        return this.d;
    }

    public final boolean g() {
        return this.e;
    }

    public int hashCode() {
        ChangeLogData changeLogData = this.a;
        int iHashCode = (changeLogData == null ? 0 : changeLogData.hashCode()) * 31;
        String str = this.b;
        return ((((((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Boolean.hashCode(this.e);
    }

    public String toString() {
        return "RootFragmentState(changeLogData=" + this.a + ", changeLogHash=" + this.b + ", callToast=" + this.c + ", sharedContentState=" + this.d + ", isReadyToInstallAppUpdate=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ H(ChangeLogData changeLogData, String str, InterfaceC10040ay6 interfaceC10040ay6, L l, boolean z, int i, ED1 ed1) {
        this((i & 1) != 0 ? null : changeLogData, (i & 2) != 0 ? null : str, (i & 4) != 0 ? AbstractC11420cy6.b(0, 0, null, 7, null) : interfaceC10040ay6, (i & 8) != 0 ? L.a.a : l, (i & 16) != 0 ? false : z);
    }
}
