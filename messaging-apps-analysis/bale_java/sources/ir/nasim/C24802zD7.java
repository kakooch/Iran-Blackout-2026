package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.zD7, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C24802zD7 extends AbstractC20556sC7 {
    private final int a;

    public C24802zD7(int i) {
        super(null);
        this.a = i;
    }

    public final int a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C24802zD7) && this.a == ((C24802zD7) obj).a;
    }

    public int hashCode() {
        return Integer.hashCode(this.a);
    }

    public String toString() {
        return "UpdateFolderDeleted(folderId=" + this.a + Separators.RPAREN;
    }
}
