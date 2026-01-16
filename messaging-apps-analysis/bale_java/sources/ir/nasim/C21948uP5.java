package ir.nasim;

import android.gov.nist.core.Separators;
import java.io.Serializable;

/* renamed from: ir.nasim.uP5, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C21948uP5 implements Serializable {
    private final int a;
    private final int b;
    private final OP5 c;

    public C21948uP5(int i, int i2, OP5 op5) {
        AbstractC13042fc3.i(op5, "reportType");
        this.a = i;
        this.b = i2;
        this.c = op5;
    }

    public final int a() {
        return this.b;
    }

    public final OP5 b() {
        return this.c;
    }

    public final int c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C21948uP5)) {
            return false;
        }
        C21948uP5 c21948uP5 = (C21948uP5) obj;
        return this.a == c21948uP5.a && this.b == c21948uP5.b && this.c == c21948uP5.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.a) * 31) + Integer.hashCode(this.b)) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "ReportItem(titleRes=" + this.a + ", iconRes=" + this.b + ", reportType=" + this.c + Separators.RPAREN;
    }
}
