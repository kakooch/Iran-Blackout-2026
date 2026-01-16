package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class DD7 extends AbstractC20556sC7 {
    private final List a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DD7(List list) {
        super(null);
        AbstractC13042fc3.i(list, "folderIds");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DD7) && AbstractC13042fc3.d(this.a, ((DD7) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "UpdateFoldersReordered(folderIds=" + this.a + Separators.RPAREN;
    }
}
