package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.oP5, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C18289oP5 implements InterfaceC15283jK {
    private final int a;
    private final String b;
    private final String c;
    private final C19811qz d;

    public C18289oP5(int i, String str, String str2, C19811qz c19811qz) {
        AbstractC13042fc3.i(str, "title");
        AbstractC13042fc3.i(str2, "description");
        AbstractC13042fc3.i(c19811qz, "apiMapValue");
        this.a = i;
        this.b = str;
        this.c = str2;
        this.d = c19811qz;
    }

    public final C19811qz a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C18289oP5)) {
            return false;
        }
        C18289oP5 c18289oP5 = (C18289oP5) obj;
        return this.a == c18289oP5.a && AbstractC13042fc3.d(this.b, c18289oP5.b) && AbstractC13042fc3.d(this.c, c18289oP5.c) && AbstractC13042fc3.d(this.d, c18289oP5.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "ReportError(rate=" + this.a + ", title=" + this.b + ", description=" + this.c + ", apiMapValue=" + this.d + Separators.RPAREN;
    }
}
