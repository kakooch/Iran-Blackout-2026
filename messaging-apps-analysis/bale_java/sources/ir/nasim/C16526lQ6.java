package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.lQ6, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C16526lQ6 {
    private final String a;
    private final int b;

    public C16526lQ6(String str, int i) {
        AbstractC13042fc3.i(str, "id");
        this.a = str;
        this.b = i;
    }

    public final String a() {
        return this.a;
    }

    public final int b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C16526lQ6)) {
            return false;
        }
        C16526lQ6 c16526lQ6 = (C16526lQ6) obj;
        return AbstractC13042fc3.d(this.a, c16526lQ6.a) && this.b == c16526lQ6.b;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + Integer.hashCode(this.b);
    }

    public String toString() {
        return "StoryEntity(id=" + this.a + ", ownerUserId=" + this.b + Separators.RPAREN;
    }
}
