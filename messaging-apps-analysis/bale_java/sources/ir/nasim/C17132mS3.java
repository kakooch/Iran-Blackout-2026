package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.mS3, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17132mS3 {
    private final int a;

    public C17132mS3(int i) {
        this.a = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C17132mS3) && this.a == ((C17132mS3) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "MarketSearch(id=" + this.a + Separators.RPAREN;
    }
}
