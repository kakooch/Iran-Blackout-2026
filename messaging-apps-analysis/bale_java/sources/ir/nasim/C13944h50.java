package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.h50, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C13944h50 {
    public static final a c = new a(null);
    private final int a;
    private final String b;

    /* renamed from: ir.nasim.h50$a */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(ED1 ed1) {
            this();
        }
    }

    public C13944h50(int i, String str) {
        AbstractC13042fc3.i(str, "title");
        this.a = i;
        this.b = str;
    }

    public final int a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C13944h50)) {
            return false;
        }
        C13944h50 c13944h50 = (C13944h50) obj;
        return this.a == c13944h50.a && AbstractC13042fc3.d(this.b, c13944h50.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "BankCardSuggestButton(id=" + this.a + ", title=" + this.b + Separators.RPAREN;
    }
}
