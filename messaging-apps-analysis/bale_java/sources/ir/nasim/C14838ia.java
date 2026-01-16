package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.ia, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C14838ia implements InterfaceC15283jK {
    private final List a;

    public C14838ia(List list) {
        AbstractC13042fc3.i(list, "tags");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C14838ia) && AbstractC13042fc3.d(this.a, ((C14838ia) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "AddUserTag(tags=" + this.a + Separators.RPAREN;
    }
}
