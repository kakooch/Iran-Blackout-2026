package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes7.dex */
public final class RN6 {
    private final boolean a;

    public RN6(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RN6) && this.a == ((RN6) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "StorageManagerDialogState(isDeletingContent=" + this.a + Separators.RPAREN;
    }
}
