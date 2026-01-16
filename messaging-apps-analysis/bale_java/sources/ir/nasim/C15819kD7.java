package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* renamed from: ir.nasim.kD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C15819kD7 extends AbstractC20556sC7 {
    private final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C15819kD7(List list) {
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
        return (obj instanceof C15819kD7) && AbstractC13042fc3.d(this.a, ((C15819kD7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateDialogsMarkedAsRead(peers=" + this.a + Separators.RPAREN;
    }
}
