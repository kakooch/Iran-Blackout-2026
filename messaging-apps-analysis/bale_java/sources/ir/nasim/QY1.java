package ir.nasim;

import android.gov.nist.core.Separators;

/* loaded from: classes5.dex */
public final class QY1 {
    private final C6035Lx a;

    public QY1(C6035Lx c6035Lx) {
        this.a = c6035Lx;
    }

    public final C6035Lx a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof QY1) && AbstractC13042fc3.d(this.a, ((QY1) obj).a);
    }

    public int hashCode() {
        C6035Lx c6035Lx = this.a;
        if (c6035Lx == null) {
            return 0;
        }
        return c6035Lx.hashCode();
    }

    public String toString() {
        return "DownloadSource(documentMessage=" + this.a + Separators.RPAREN;
    }
}
