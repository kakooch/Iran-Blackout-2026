package ir.nasim;

import android.gov.nist.core.Separators;

/* renamed from: ir.nasim.v17, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C22315v17 {
    private final boolean a;

    public C22315v17(boolean z) {
        this.a = z;
    }

    public final C22315v17 a(boolean z) {
        return new C22315v17(z);
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C22315v17) && this.a == ((C22315v17) obj).a;
    }

    public int hashCode() {
        return Boolean.hashCode(this.a);
    }

    public String toString() {
        return "SuggestersUiState(listLoaded=" + this.a + Separators.RPAREN;
    }
}
