package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.jS0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C15356jS0 {
    private final String a;
    private final String b;
    private final String c;
    private final boolean d;

    public C15356jS0(String str, String str2, String str3, boolean z) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(str3, "clearButton");
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = z;
    }

    public final boolean a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.b;
    }

    public final String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C15356jS0)) {
            return false;
        }
        C15356jS0 c15356jS0 = (C15356jS0) obj;
        return AbstractC13042fc3.d(this.a, c15356jS0.a) && AbstractC13042fc3.d(this.b, c15356jS0.b) && AbstractC13042fc3.d(this.c, c15356jS0.c) && this.d == c15356jS0.d;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + Boolean.hashCode(this.d);
    }

    public String toString() {
        return "ChatsStorageUiState(title=" + this.a + ", description=" + this.b + ", clearButton=" + this.c + ", canBeCleared=" + this.d + Separators.RPAREN;
    }
}
