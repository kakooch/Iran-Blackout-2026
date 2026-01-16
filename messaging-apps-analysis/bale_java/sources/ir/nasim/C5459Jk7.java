package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.Jk7, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C5459Jk7 {
    private final int a;
    private final String b;

    public C5459Jk7(int i, String str) {
        AbstractC13042fc3.i(str, "storyId");
        this.a = i;
        this.b = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5459Jk7)) {
            return false;
        }
        C5459Jk7 c5459Jk7 = (C5459Jk7) obj;
        return this.a == c5459Jk7.a && AbstractC13042fc3.d(this.b, c5459Jk7.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "TestTag(userId=" + this.a + ", storyId=" + this.b + Separators.RPAREN;
    }
}
