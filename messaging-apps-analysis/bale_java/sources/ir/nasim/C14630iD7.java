package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.iD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C14630iD7 extends AbstractC20556sC7 {
    private final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C14630iD7(List list) {
        super(null);
        AbstractC13042fc3.i(list, "uids");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C14630iD7) && AbstractC13042fc3.d(this.a, ((C14630iD7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateContactsRemoved(uids=" + this.a + Separators.RPAREN;
    }
}
