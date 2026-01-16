package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.nS0, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C17720nS0 {
    public static final int f = 0;
    private final int a;
    private final boolean b;
    private final boolean c;
    private final String d;
    private final UA2 e;

    public C17720nS0(int i, boolean z, boolean z2, String str, UA2 ua2) {
        AbstractC13042fc3.i(ua2, "clickHandler");
        this.a = i;
        this.b = z;
        this.c = z2;
        this.d = str;
        this.e = ua2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b(boolean z) {
        return C19938rB7.a;
    }

    public final UA2 c() {
        return this.e;
    }

    public final String d() {
        return this.d;
    }

    public final int e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C17720nS0)) {
            return false;
        }
        C17720nS0 c17720nS0 = (C17720nS0) obj;
        return this.a == c17720nS0.a && this.b == c17720nS0.b && this.c == c17720nS0.c && AbstractC13042fc3.d(this.d, c17720nS0.d) && AbstractC13042fc3.d(this.e, c17720nS0.e);
    }

    public final boolean f() {
        return this.b;
    }

    public final boolean g() {
        return this.c;
    }

    public int hashCode() {
        int iHashCode = ((((Integer.hashCode(this.a) * 31) + Boolean.hashCode(this.b)) * 31) + Boolean.hashCode(this.c)) * 31;
        String str = this.d;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "CheckBoxItem(title=" + this.a + ", isChecked=" + this.b + ", isEnabled=" + this.c + ", description=" + this.d + ", clickHandler=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C17720nS0(int i, boolean z, boolean z2, String str, UA2 ua2, int i2, ED1 ed1) {
        this(i, z, (i2 & 4) != 0 ? true : z2, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? new UA2() { // from class: ir.nasim.mS0
            @Override // ir.nasim.UA2
            public final Object invoke(Object obj) {
                return C17720nS0.b(((Boolean) obj).booleanValue());
            }
        } : ua2);
    }
}
