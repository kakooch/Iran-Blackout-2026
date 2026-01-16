package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.rk7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C20281rk7 {
    private final List a;

    public C20281rk7(List list) {
        AbstractC13042fc3.i(list, "buttons");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C20281rk7) && AbstractC13042fc3.d(this.a, ((C20281rk7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TemplateKeyboardRow(buttons=" + this.a + Separators.RPAREN;
    }
}
