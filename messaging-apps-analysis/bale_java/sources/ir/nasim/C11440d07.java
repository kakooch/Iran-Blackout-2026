package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.d07, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C11440d07 {
    private final boolean a;
    private final List b;

    public C11440d07(boolean z, List list) {
        AbstractC13042fc3.i(list, "groups");
        this.a = z;
        this.b = list;
    }

    public final List a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C11440d07)) {
            return false;
        }
        C11440d07 c11440d07 = (C11440d07) obj;
        return this.a == c11440d07.a && AbstractC13042fc3.d(this.b, c11440d07.b);
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SubmitPassportResult(needToShowUpdateDialog=" + this.a + ", groups=" + this.b + Separators.RPAREN;
    }
}
