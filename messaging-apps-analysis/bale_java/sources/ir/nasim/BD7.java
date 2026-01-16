package ir.nasim;

import android.gov.nist.core.Separators;
import java.util.List;

/* loaded from: classes5.dex */
public final class BD7 extends AbstractC20556sC7 {
    private final int a;
    private final String b;
    private final List c;
    private final List d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BD7(int i, String str, List list, List list2) {
        super(null);
        AbstractC13042fc3.i(str, "newName");
        AbstractC13042fc3.i(list, "addedPeers");
        AbstractC13042fc3.i(list2, "deletedPeers");
        this.a = i;
        this.b = str;
        this.c = list;
        this.d = list2;
    }

    public final List a() {
        return this.c;
    }

    public final List b() {
        return this.d;
    }

    public final int c() {
        return this.a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BD7)) {
            return false;
        }
        BD7 bd7 = (BD7) obj;
        return this.a == bd7.a && AbstractC13042fc3.d(this.b, bd7.b) && AbstractC13042fc3.d(this.c, bd7.c) && AbstractC13042fc3.d(this.d, bd7.d);
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.a) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public String toString() {
        return "UpdateFolderEdited(folderId=" + this.a + ", newName=" + this.b + ", addedPeers=" + this.c + ", deletedPeers=" + this.d + Separators.RPAREN;
    }
}
