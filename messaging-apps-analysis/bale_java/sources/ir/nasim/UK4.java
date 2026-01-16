package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class UK4 implements InterfaceC15283jK {
    private final long a;
    private final long b;
    private final J44 c;
    private final C10508bj5 d;

    public UK4(long j, long j2, J44 j44, C10508bj5 c10508bj5) {
        AbstractC13042fc3.i(j44, "discussionMessage");
        AbstractC13042fc3.i(c10508bj5, "postInfo");
        this.a = j;
        this.b = j2;
        this.c = j44;
        this.d = c10508bj5;
    }

    public final long a() {
        return this.a;
    }

    public final J44 b() {
        return this.c;
    }

    public final C10508bj5 c() {
        return this.d;
    }

    public final long d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UK4)) {
            return false;
        }
        UK4 uk4 = (UK4) obj;
        return this.a == uk4.a && this.b == uk4.b && AbstractC13042fc3.d(this.c, uk4.c) && AbstractC13042fc3.d(this.d, uk4.d);
    }

    public int hashCode() {
        return (((((Long.hashCode(this.a) * 31) + Long.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "OpenCommentHistory(date=" + this.a + ", rid=" + this.b + ", discussionMessage=" + this.c + ", postInfo=" + this.d + Separators.RPAREN;
    }
}
