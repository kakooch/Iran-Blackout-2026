package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mA2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C16969mA2 {
    private final long a;
    private boolean b;

    public C16969mA2(long j, boolean z) {
        this.a = j;
        this.b = z;
    }

    public final long a() {
        return this.a;
    }

    public final boolean b() {
        return this.b;
    }

    public final void c(boolean z) {
        this.b = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16969mA2)) {
            return false;
        }
        C16969mA2 c16969mA2 = (C16969mA2) obj;
        return this.a == c16969mA2.a && this.b == c16969mA2.b;
    }

    public int hashCode() {
        return (Long.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "FriendsShareCrowdfunding(userId=" + this.a + ", isSelected=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ C16969mA2(long j, boolean z, int i, ED1 ed1) {
        this(j, (i & 2) != 0 ? false : z);
    }
}
