package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Ji5, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5439Ji5 {
    private final int a;
    private final int b;

    public C5439Ji5(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5439Ji5)) {
            return false;
        }
        C5439Ji5 c5439Ji5 = (C5439Ji5) obj;
        return this.a == c5439Ji5.a && this.b == c5439Ji5.b;
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "PopularStoryViews(viewCount=" + this.a + ", likeCount=" + this.b + Separators.RPAREN;
    }
}
