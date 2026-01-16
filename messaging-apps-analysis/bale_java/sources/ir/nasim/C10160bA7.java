package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.bA7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C10160bA7 {
    private final List a;

    public C10160bA7(List list) {
        AbstractC13042fc3.i(list, "items");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C10160bA7) && AbstractC13042fc3.d(this.a, ((C10160bA7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UIState(items=" + this.a + Separators.RPAREN;
    }
}
