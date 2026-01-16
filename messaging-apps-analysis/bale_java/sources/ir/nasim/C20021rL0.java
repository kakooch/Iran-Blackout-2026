package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.rL0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20021rL0 {
    private final int a;
    private final int b;
    private final Integer c;
    private final String d;
    private final SA2 e;

    public C20021rL0(int i, int i2, Integer num, String str, SA2 sa2) {
        AbstractC13042fc3.i(sa2, "okAction");
        this.a = i;
        this.b = i2;
        this.c = num;
        this.d = str;
        this.e = sa2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C19938rB7 b() {
        return C19938rB7.a;
    }

    public final Integer c() {
        return this.c;
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
        if (!(obj instanceof C20021rL0)) {
            return false;
        }
        C20021rL0 c20021rL0 = (C20021rL0) obj;
        return this.a == c20021rL0.a && this.b == c20021rL0.b && AbstractC13042fc3.d(this.c, c20021rL0.c) && AbstractC13042fc3.d(this.d, c20021rL0.d) && AbstractC13042fc3.d(this.e, c20021rL0.e);
    }

    public final SA2 f() {
        return this.e;
    }

    public final int g() {
        return this.b;
    }

    public int hashCode() {
        int iHashCode = ((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31;
        Integer num = this.c;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.d;
        return ((iHashCode2 + (str != null ? str.hashCode() : 0)) * 31) + this.e.hashCode();
    }

    public String toString() {
        return "ChatDialogData(imageResourceId=" + this.a + ", titleId=" + this.b + ", descriptionId=" + this.c + ", descriptionString=" + this.d + ", okAction=" + this.e + Separators.RPAREN;
    }

    public /* synthetic */ C20021rL0(int i, int i2, Integer num, String str, SA2 sa2, int i3, ED1 ed1) {
        this(i, i2, (i3 & 4) != 0 ? null : num, (i3 & 8) != 0 ? null : str, (i3 & 16) != 0 ? new SA2() { // from class: ir.nasim.qL0
            @Override // ir.nasim.SA2
            public final Object invoke() {
                return C20021rL0.b();
            }
        } : sa2);
    }
}
