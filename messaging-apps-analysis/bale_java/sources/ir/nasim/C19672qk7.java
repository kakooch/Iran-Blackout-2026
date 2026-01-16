package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.qk7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C19672qk7 {
    private final List a;

    public C19672qk7(List list) {
        AbstractC13042fc3.i(list, "keyboardRows");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C19672qk7) && AbstractC13042fc3.d(this.a, ((C19672qk7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "Template(keyboardRows=" + this.a + Separators.RPAREN;
    }
}
