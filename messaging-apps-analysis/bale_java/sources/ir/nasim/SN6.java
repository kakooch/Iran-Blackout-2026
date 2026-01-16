package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class SN6 {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final InterfaceC19114po0 e;
    private final InterfaceC19114po0 f;

    public SN6(int i, int i2, int i3, int i4, InterfaceC19114po0 interfaceC19114po0, InterfaceC19114po0 interfaceC19114po02) {
        AbstractC13042fc3.i(interfaceC19114po0, "startButtonState");
        AbstractC13042fc3.i(interfaceC19114po02, "endButtonState");
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = interfaceC19114po0;
        this.f = interfaceC19114po02;
    }

    public final int a() {
        return this.b;
    }

    public final InterfaceC19114po0 b() {
        return this.f;
    }

    public final int c() {
        return this.d;
    }

    public final int d() {
        return this.c;
    }

    public final InterfaceC19114po0 e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SN6)) {
            return false;
        }
        SN6 sn6 = (SN6) obj;
        return this.a == sn6.a && this.b == sn6.b && this.c == sn6.c && this.d == sn6.d && AbstractC13042fc3.d(this.e, sn6.e) && AbstractC13042fc3.d(this.f, sn6.f);
    }

    public final int f() {
        return this.a;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    }

    public String toString() {
        return "StorageManagerDialogUiState(title=" + this.a + ", description=" + this.b + ", positiveButton=" + this.c + ", negativeButton=" + this.d + ", startButtonState=" + this.e + ", endButtonState=" + this.f + Separators.RPAREN;
    }
}
