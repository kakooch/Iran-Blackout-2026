package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.mD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C17001mD7 extends AbstractC20556sC7 {
    private final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C17001mD7(List list) {
        super(null);
        AbstractC13042fc3.i(list, "peers");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C17001mD7) && AbstractC13042fc3.d(this.a, ((C17001mD7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateDialogsMarkedAsUnread(peers=" + this.a + Separators.RPAREN;
    }
}
