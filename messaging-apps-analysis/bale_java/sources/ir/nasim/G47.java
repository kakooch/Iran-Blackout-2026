package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes8.dex */
public final class G47 {
    private final boolean a;
    private final boolean b;

    public G47(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
    }

    public final boolean a() {
        return this.b;
    }

    public final boolean b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof G47)) {
            return false;
        }
        G47 g47 = (G47) obj;
        return this.a == g47.a && this.b == g47.b;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.a) * 31) + Boolean.hashCode(this.b);
    }

    public String toString() {
        return "SystemBarState(statusBarIsVisible=" + this.a + ", navigationBarIsVisible=" + this.b + Separators.RPAREN;
    }

    public /* synthetic */ G47(boolean z, boolean z2, int i, ED1 ed1) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2);
    }
}
